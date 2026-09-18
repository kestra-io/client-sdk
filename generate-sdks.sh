#!/bin/bash
set -euo pipefail

LANGUAGES=$1
VERSION=${2:-}

# if the language starts with "v" and a number or simply a number, it means that is the version
# language and version have been inverted, so we need to swap them
if [[ "$LANGUAGES" =~ ^v?[0-9]+[.+-] ]]; then
  VERSION="$LANGUAGES"
  LANGUAGES="${2:-}"
  echo "Language and version have been inverted, swapping them. Language: $LANGUAGES, Version: $VERSION"
fi

# if version is not provided, use 0.0.0-dev as default
if [ -z "$VERSION" ]; then
  VERSION="0.0.0-dev"
  echo "No version provided, using default: $VERSION"
fi

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
  echo "ERROR: the Java SDK is hand-written (since #222);"
  echo "edit the sources under java/java-sdk directly instead."
  exit 1
fi

# Go SDK is hand-written and no longer generated
if [[ ",$LANGUAGES," == *",go,"* ]]; then
  echo "ERROR: the Go SDK is hand-written (since #230);"
  echo "edit the sources under go-sdk directly instead."
  exit 1
fi

# Python SDK is hand-written and no longer generated
if [[ ",$LANGUAGES," == *",python,"* ]]; then
  echo "ERROR: the Python SDK is hand-written (since #237);"
  echo "edit the sources under python/python-sdk directly instead."
  exit 1
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

