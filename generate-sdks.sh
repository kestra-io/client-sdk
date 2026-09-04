#!/bin/bash
set -euo pipefail

LANGUAGES=$1
VERSION=${2:-}
TEMPLATE_FLAG="${3:-}"

# if the language starts with "v" and a number or simply a number, it means that is the version
# language and version have been inverted, so we need to swap them
if [[ "$LANGUAGES" =~ ^v?[0-9]+[.+-] ]]; then
  VERSION="$LANGUAGES"
  LANGUAGES="${2:-}"
  echo "Language and version have been inverted, swapping them. Language: $LANGUAGES, Version: $VERSION"
fi

HOST_UID=$(id -u)
HOST_GID=$(id -g)

# if version is not provided, use 0.0.0-dev as default
if [ -z "$VERSION" ]; then
  VERSION="0.0.0-dev"
  echo "No version provided, using default: $VERSION"
fi

# cleanup previous generated files listed by OpenAPI Generator

# check if LANGUAGES is empty
if [ -z "$LANGUAGES" ]; then
  echo "No language specified. The only generated SDK is 'javascript' (Java, Go and Python are hand-written)"
  exit 1
fi

if [[ "$LANGUAGES" == *,* ]]; then
  echo "Multiple languages specified. Please provide exactly one language (no commas)."
  exit 1
fi

# Java SDK is hand-written and no longer generated
if [[ ",$LANGUAGES," == *",java,"* ]]; then
  echo "ERROR: the Java SDK is hand-written (since #222) and is no longer generated."
  echo "Running the generator would delete java/java-sdk/src/main/java/io/kestra/sdk entirely."
  echo "Edit the sources under java/java-sdk directly instead."
  exit 1
fi

# Go SDK is hand-written and no longer generated
if [[ ",$LANGUAGES," == *",go,"* ]]; then
  echo "ERROR: the Go SDK is hand-written (since #230) and is no longer generated."
  echo "#230 deleted go-sdk/configuration/ and go-sdk/template/, so the generator could"
  echo "never run again — but it cleaned up first, so invoking it deleted all 417 files"
  echo "listed in go-sdk/kestra_api_client/.openapi-generator/FILES before failing."
  echo "Edit the sources under go-sdk directly instead."
  exit 1
fi

# Python SDK is hand-written and no longer generated
if [[ ",$LANGUAGES," == *",python,"* ]]; then
  echo "ERROR: the Python SDK is hand-written (since #237) and is no longer generated."
  echo "Unlike Java and Go the generator would still RUN, which is worse: the 10 API"
  echo "classes it lists in python/python-sdk/.openapi-generator/FILES are hand-written,"
  echo ".openapi-generator-ignore has no active rules, and the config's tag FILTER covers"
  echo "9 of the SDK's 20 API modules — so it deleted and overwrote hand-written code."
  echo "Edit the sources under python/python-sdk directly instead."
  echo "(Doc examples are validated by scripts/validate_doc_examples.py, run in CI.)"
  exit 1
fi

BASE_PKG=io.kestra.sdk

# Disabled for now
#OPENAPI_GITHUB_LOCATION="/repos/kestra-io/kestra-ee/contents/kestra-ee.yml"
#OPENAPI_LOCATION_BRANCH="v1.0.7-openapi-spec"
#echo "download openapi spec from github at '$OPENAPI_GITHUB_LOCATION' in branch '$OPENAPI_LOCATION_BRANCH'"
#gh api -H "Accept: application/vnd.github.raw" "$OPENAPI_GITHUB_LOCATION?ref=$OPENAPI_LOCATION_BRANCH" > kestra-ee.yml

if [ -n "$TEMPLATE_FLAG" ]; then
  echo "Generating templates"
  docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release author template -g "$LANGUAGES" -o /local/$LANGUAGES/template
  exit 0
fi

KESTRA_OPENAPI_SDK_CUSTOMIZER_CONF=$(readlink -f ./configurations/kestra-openapi-sdk-customizer.json)
KESTRA_OPENAPI=$(readlink -f ./kestra-ee.yml)
sh -c "cd ./generation-helpers/kestra-openapi-sdk-customizer && npm i && npm run build && npm start $KESTRA_OPENAPI_SDK_CUSTOMIZER_CONF $KESTRA_OPENAPI"




# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
cd javascript
npm version $VERSION --no-git-tag-version --workspace @kestra-io/kestra-sdk --allow-same-version
npm ci
npm run build
cd ..
fi

