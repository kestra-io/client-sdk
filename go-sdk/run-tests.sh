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

#CURRENT_TIMESTAMP=$(date -u "+%Y%m%d%H%M%S" 2>/dev/null || date -u -j "+%Y%m%d%H%M%S")

LOCAL_CI_VERSION_TO_TEST="local-ci-version"

. "$(dirname "$0")/../test-utils/resolve-kestra-image-suffix.sh"

echo "/n------------------------------------------------"
echo "Build local SDK and test it in a docker Kestra instance"

for KESTRA_VERSION in $versions; do
  if [ -z "$KESTRA_VERSION" ]; then
    continue
  fi

  echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"

  export KESTRA_VERSION=$KESTRA_VERSION
  export KESTRA_IMAGE_SUFFIX=$(resolve_kestra_image_suffix "$KESTRA_VERSION")

  echo "start Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
     echo "db Docker Compose failed. Dumping logs:";
     log_and_run docker compose -f docker-compose-ci.yml logs;
     exit 1;
  }

  echo "build"
  log_and_run sh -c 'go build ./...'

  echo "start tests"
  log_and_run sh -c 'go test ./...' || {
     rc=$?
     echo "go tests failed (rc=$rc). Dumping Kestra container diagnostics:"
     # Diagnostics are best-effort: under `set -e` a failing command here would
     # abort before the logs are printed.
     docker compose -f docker-compose-ci.yml ps -a || true
     # ExitCode=137 + OOMKilled=true = cgroup memory kill; distinguishes it from a JVM crash.
     docker inspect go-sdk-test-kestra \
       --format 'kestra: OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}} Restarts={{.RestartCount}}' || true
     docker compose -f docker-compose-ci.yml logs --no-color --timestamps --tail=500 || true
     exit "$rc"
  }

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down
done
