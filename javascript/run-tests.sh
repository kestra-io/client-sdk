#!/usr/bin/env bash
# remember where the script has been run from
original_dir=$(pwd)

# Move to the script directory
cd "$(dirname "$0")"

# On exit, move back to the original directory
trap "cd $original_dir" EXIT

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

if [ $# -ge 1 ]; then
  versions="$1"
else
  versions=$(cat ../COMPATIBLE_KESTRA_VERSION.properties)
fi

echo "/n------------------------------------------------"
echo "Build local SDK and test it in a docker Kestra instance"

# only install and build if the --no-build flag is not set
if [[ "$@" != *"--no-build"* ]]; then
   echo "installing and building SDK"
    echo ""
    echo "install requirements"
    log_and_run npm ci

    echo "install SDK locally so it can be imported and used in e2e tests"
    log_and_run npm run build
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

  log_and_run npm run test -w test_javascript_sdk -- --coverage

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down
done
