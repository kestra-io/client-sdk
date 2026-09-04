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

# Cross-platform sed in-place with extended regex
sed_inplace() {
  local cmd="$1"
  shift
  if [[ "$(uname)" == "Darwin" ]]; then
    sed -i '' -E "$cmd" "$@"
  else
    sed -i -E "$cmd" "$@"
  fi
}

# cleanup previous generated files listed by OpenAPI Generator
# Deletes the previous output listed in .openapi-generator/FILES. Callers pass the
# generator config as well: cleanup is destructive and irreversible, so refuse to
# run at all when the config it is clearing the way for is missing — otherwise a
# generator that cannot start takes the whole checked-in SDK with it.
cleanup_openapi_generated_files() {
  local sdk_path="$1"
  local config_file="$2"
  local files_list_file="$sdk_path/.openapi-generator/FILES"

  if [ ! -f "$config_file" ]; then
    echo "generator config $config_file not found; refusing to delete $sdk_path" >&2
    exit 1
  fi

  echo "cleanup previous generated files in $files_list_file"

  if [ ! -f "$files_list_file" ]; then
    echo "No OpenAPI generated files list found at $files_list_file (nothing to cleanup)"
    return 0
  fi

  # Print the file list for visibility
  ls "$files_list_file"

  while IFS= read -r file; do
    # Skip empty lines
    [ -z "$file" ] && continue

    echo "removing file: $sdk_path/$file"
    rm "$sdk_path/$file" || true
  done < "$files_list_file"
}

# check if LANGUAGES is empty
if [ -z "$LANGUAGES" ]; then
  echo "No language specified. Please provide a language. Possible languages are: 'python' and 'javascript' (the Java and Go SDKs are hand-written and not generated)"
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



# Generate Python SDK
if [[ ",$LANGUAGES," == *",python,"* ]]; then
cleanup_openapi_generated_files "./${LANGUAGES}/${LANGUAGES}-sdk" "./python/configuration/python-config.yml"
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release generate \
    -c /local/python/configuration/python-config.yml \
    --skip-validate-spec \
    --additional-properties=packageVersion=$VERSION \
    --template-dir=/local/python/template

sed_inplace '/from kestrapy\.models\.list\[label\] import List\[Label\]/d' python/python-sdk/kestrapy/api/executions_api.py
sed_inplace 's/value: Optional\[Dict\[str, Any\]\] = None/value: Optional[Any] = None/' python/python-sdk/kestrapy/models/kv_controller_kv_detail.py
echo "from kestrapy.kestra_client import KestraClient as KestraClient" >> python/python-sdk/kestrapy/__init__.py

# Since #237 the Python API classes are hand-written, so the generated docs no
# longer match the SDK (wrong accessor/arg order/renamed methods — issue #144).
# Rather than patch the generated examples with brittle sed (the previous loop
# even had the wrong path and silently no-op'd), validate every docs/*.md
# example against the live signatures and fail generation if any has drifted.
# See design/examples-as-source-of-truth.md.
python3 python/python-sdk/scripts/validate_doc_examples.py --check
fi

# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
cd javascript
npm version $VERSION --no-git-tag-version --workspace @kestra-io/kestra-sdk --allow-same-version
npm ci
npm run build
cd ..
fi

