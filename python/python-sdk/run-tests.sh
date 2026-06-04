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
  # the JVM writes its GC log here (bind mount); also where we collect histograms
  mkdir -p kestra-logs
  rm -f kestra-logs/*
  log_and_run docker compose -f docker-compose-ci.yml down

  log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
     echo "db Docker Compose failed. Dumping logs:";
     log_and_run docker compose -f docker-compose-ci.yml logs;
     exit 1;
  }

  # Background poller for a per-class heap histogram. The JVM has no flag to print
  # one on OOM (PrintClassHistogram*FullGC was removed in modern JDKs), so snapshot
  # it from the host every 20s and keep the last few; the snapshot just before the
  # OOM shows which classes are accumulating. jcmd/jmap are JDK tools that may be
  # absent on a JRE image, so try both and record which (or that neither) worked.
  (
    while [ "$(docker inspect -f '{{.State.Running}}' python-sdk-test-kestra 2>/dev/null)" = "true" ]; do
      snap="kestra-logs/histo-$(date +%H%M%S).txt"
      if ! docker exec python-sdk-test-kestra sh -c 'command -v jcmd >/dev/null 2>&1 && exec jcmd 1 GC.class_histogram' > "$snap" 2>/dev/null; then
        if ! docker exec python-sdk-test-kestra sh -c 'command -v jmap >/dev/null 2>&1 && exec jmap -histo:live 1' > "$snap" 2>/dev/null; then
          echo "jcmd/jmap unavailable in image (or JVM is not PID 1)" > "$snap"
        fi
      fi
      # keep only the 3 most recent snapshots
      ls -1t kestra-logs/histo-*.txt 2>/dev/null | tail -n +4 | xargs -r rm -f
      sleep 20
    done
  ) &
  histo_poller_pid=$!

  echo "start tests"
  set +e
  python3 -m pytest -v --timeout=10
  test_rc=$?
  set -e

  kill "$histo_poller_pid" 2>/dev/null || true
  wait "$histo_poller_pid" 2>/dev/null || true

  if [ "$test_rc" -ne 0 ]; then
    echo "tests failed (rc=$test_rc) - dumping Kestra diagnostics before teardown"
    echo "----- kestra container state -----"
    docker inspect python-sdk-test-kestra \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}} Restarts={{.RestartCount}}' || true
    echo "----- postgres container state -----"
    docker inspect python-sdk-test-postgres \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}}' || true
    # Capture the FULL kestra stdout to a file for upload; print only the tail to
    # the console. The GC log and histogram snapshots already sit in kestra-logs/.
    docker compose -f docker-compose-ci.yml logs --no-color --no-log-prefix kestra > kestra-logs/kestra.log 2>&1 || true
    echo "----- kestra logs (last 300 lines; full logs + GC log + histograms uploaded as artifact) -----"
    tail -n 300 kestra-logs/kestra.log || true
    # gc.log is written by root inside the container; make everything readable for upload
    sudo chmod -R a+r kestra-logs 2>/dev/null || chmod -R a+r kestra-logs 2>/dev/null || true
    ls -lh kestra-logs/ || true
  fi

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  if [ "$test_rc" -ne 0 ]; then
    exit "$test_rc"
  fi
done
