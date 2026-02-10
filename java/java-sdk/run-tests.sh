#!/usr/bin/env bash

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

if [ $# -ge 1 ]; then
  KESTRA_VERSION="$1"
else
  KESTRA_VERSION=$(cat ../../COMPATIBLE_KESTRA_VERSION.properties)
fi

export KESTRA_VERSION=$KESTRA_VERSION

#CURRENT_TIMESTAMP=$(date -u "+%Y%m%d%H%M%S" 2>/dev/null || date -u -j "+%Y%m%d%H%M%S")

LOCAL_CI_VERSION_TO_TEST="local-ci-version"

echo "/n------------------------------------------------"
echo "Build local SDK and test it in an example project"
echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"

echo "publish a local version $LOCAL_CI_VERSION_TO_TEST"
log_and_run ./gradlew publishToMavenLocal -PciVersionOverride="${LOCAL_CI_VERSION_TO_TEST}"

echo "start Kestra container"
log_and_run docker compose -f docker-compose-ci.yml down

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
