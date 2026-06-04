#!/usr/bin/env bash

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

if [ $# -ge 1 ]; then
  versions="$1"
else
  versions="develop"
fi

echo "/n------------------------------------------------"
echo "Build local SDK and test it in a docker Kestra instance"

echo "install requirements"
log_and_run pip install -r requirements.txt -r test-requirements.txt --break-system-packages

echo "install SDK locally so it can be imported and used in e2e tests"
log_and_run pip install -e . --break-system-packages

for KESTRA_VERSION in $versions; do
  if [ -z "$KESTRA_VERSION" ]; then
    continue
  fi

  echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"

  export KESTRA_VERSION=$KESTRA_VERSION

  echo "start Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
     echo "db Docker Compose failed. Dumping logs:";
     log_and_run docker compose -f docker-compose-ci.yml logs;
     exit 1;
  }

  echo "start tests"
  set +e
  python3 -m pytest -v --timeout=10
  test_rc=$?
  set -e

  if [ "$test_rc" -ne 0 ]; then
    echo "tests failed (rc=$test_rc) - dumping Kestra diagnostics before teardown"
    echo "----- kestra container state -----"
    docker inspect python-sdk-test-kestra \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}} Restarts={{.RestartCount}}' || true
    echo "----- postgres container state -----"
    docker inspect python-sdk-test-postgres \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}}' || true
    # Capture the FULL kestra logs to a file for upload: the OOM class histograms
    # (-XX:+PrintClassHistogram{Before,After}FullGC) run to thousands of lines and
    # would be cut off by a tail. Print only the tail to the console for a quick look.
    mkdir -p kestra-logs
    docker compose -f docker-compose-ci.yml logs --no-color --no-log-prefix kestra > kestra-logs/kestra.log 2>&1 || true
    echo "----- kestra logs (last 300 lines; full log uploaded as artifact) -----"
    tail -n 300 kestra-logs/kestra.log || true
  fi

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  if [ "$test_rc" -ne 0 ]; then
    exit "$test_rc"
  fi
done
