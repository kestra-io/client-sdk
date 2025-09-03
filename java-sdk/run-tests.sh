#!/usr/bin/env bash

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

# Check for exactly one argument
if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <kestra_version>"
  echo "kestra_version: is the version for Kestra to run the tests with (develop, v0.24..)"
  exit 1
fi

KESTRA_VERSION="$1"

#CURRENT_TIMESTAMP=$(date -u "+%Y%m%d%H%M%S" 2>/dev/null || date -u -j "+%Y%m%d%H%M%S")

LOCAL_CI_VERSION_TO_TEST="local-ci-version"

echo "/n------------------------------------------------"
echo "Build local SDK and test it in an example project"
echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"

echo "publish a local version $LOCAL_CI_VERSION_TO_TEST"
log_and_run ./gradlew publishToMavenLocal -PciVersionOverride="${LOCAL_CI_VERSION_TO_TEST}"

echo "start Kestra container"
log_and_run docker compose -f docker-compose-ci.yml down

export KESTRA_VERSION=$KESTRA_VERSION
log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
   echo "db Docker Compose failed. Dumping logs:";
   log_and_run docker compose -f docker-compose-ci.yml logs;
   exit 1;
}

echo "compile"
log_and_run sh -c 'cd ./java-sdk-test && ./gradlew clean compileJava'

echo "start tests"
log_and_run sh -c 'cd ./java-sdk-test && ./gradlew check --info -Dtest.showStandardStreams=true'

echo "stop Kestra container"
log_and_run docker compose -f docker-compose-ci.yml down
