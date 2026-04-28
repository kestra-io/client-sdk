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

# if --no-build is passed as an argument, skip building the SDK
if [[ "$@" != *"--no-build"* ]]; then
    echo "/n------------------------------------------------"
    echo "Build local SDK and test it in a docker Kestra instance"

    echo ""
    echo "install requirements"
    log_and_run npm ci

    echo "install SDK locally so it can be imported and used in e2e tests"
    log_and_run sh -c 'npm run build'
fi

for KESTRA_VERSION in $versions; do
  if [ -z "$KESTRA_VERSION" ]; then
    continue
  fi

  echo "docker KESTRA_VERSION used: $KESTRA_VERSION"

  export KESTRA_VERSION=$KESTRA_VERSION

  echo ""
  echo "stop probable Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  echo ""
  echo "start new Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
     echo "db Docker Compose failed. Dumping logs:";
     log_and_run docker compose -f docker-compose-ci.yml logs;
     exit 1;
  }

  echo "run test_javascript-sdk tests"
  log_and_run sh -c 'npm run test --workspace test_javascript_sdk -- --coverage'

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down
done
