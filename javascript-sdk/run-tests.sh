#!/usr/bin/env bash

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

if [ $# -ge 1 ]; then
  KESTRA_VERSION="$1"
else
  KESTRA_VERSION=$(cat ../COMPATIBLE_KESTRA_VERSION.properties)
fi

echo "/n------------------------------------------------"
echo "Build local SDK and test it in an example project"
echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"


echo "start Kestra container"
log_and_run docker compose -f docker-compose-ci.yml down

export KESTRA_VERSION=$KESTRA_VERSION
log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
   echo "db Docker Compose failed. Dumping logs:";
   log_and_run docker compose -f docker-compose-ci.yml logs;
   exit 1;
}

echo "install requirements"
log_and_run npm ci

echo "install SDK locally so it can be imported and used in e2e tests"
log_and_run npm run build

echo "install test_javascript_sdk dependencies"
log_and_run sh -c 'cd test_javascript_sdk && npm ci'

echo "run test_javascript_sdk tests"
log_and_run sh -c 'cd test_javascript_sdk && npm run test'

echo "stop Kestra container"
log_and_run docker compose -f docker-compose-ci.yml down
