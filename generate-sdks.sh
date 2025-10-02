#!/bin/bash

VERSION=$1
LANGUAGES=$2
TEMPLATE_FLAG=$3

HOST_UID=$(id -u)
HOST_GID=$(id -g)

get_sed_inplace_option() {
  if [[ "$(uname)" == "Darwin" ]]; then
    echo "-i ''"
  else
    echo "-i"
  fi
}
SED_INPLACE=$(get_sed_inplace_option)

# check if LANGUAGES is empty
if [ -z "$LANGUAGES" ]; then
  echo "No languages specified. Please provide a comma-separated list of languages. Possible languages are: 'java', 'python', 'go' and 'javascript'"
  exit 1
fi

BASE_PKG=io.kestra.sdk

if [ -n "$TEMPLATE_FLAG" ]; then
  docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli author template -g "$LANGUAGES" -o /local/templates/java
  exit 0
fi

# Generate Java SDK
if [[ ",$LANGUAGES," == *",java,"* ]]; then
rm -rf ./java-sdk/docs
rm -rf ./java-sdk/src/main/java/io/kestra/sdk/api
rm -rf ./java-sdk/src/main/java/io/kestra/sdk/internal
rm -rf ./java-sdk/src/main/java/io/kestra/sdk/model

docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli generate \
     -c /local/configurations/java-config.yml --artifact-version $VERSION \
      --skip-validate-spec

find ./java-sdk/src/main/java -type f -name "*.java" -exec sed -i.bak 's/Map<Task>/List<Task>/g' {} + && find ./java-sdk/src/main/java -name "*.bak" -delete
echo "version=$VERSION" > ./java-sdk/gradle.properties
fi

# Generate Python SDK
if [[ ",$LANGUAGES," == *",python,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli generate \
    -c /local/configurations/python-config.yml \
    --skip-validate-spec \
    --additional-properties=packageVersion=$VERSION \
    --template-dir=/local/templates/python

sed $SED_INPLACE -E 's/^license = .*/license = "Apache-2.0"/' python-sdk/pyproject.toml
sed $SED_INPLACE -E 's/^requires-python = .*/requires-python = ">=3.9"/' python-sdk/pyproject.toml
sed $SED_INPLACE -E '/from kestrapy\.models\.list\[label\] import List\[Label\]/d' python-sdk/kestrapy/api/executions_api.py
grep -vF '{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}' python-sdk/kestrapy/models/task.py > temp_file && mv temp_file python-sdk/kestrapy/models/task.py
echo "from kestrapy.kestra_client import KestraClient as KestraClient" >> python-sdk/kestrapy/__init__.py
fi

# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli generate \
    -c /local/configurations/javascript-config.yml \
    --skip-validate-spec \
    --additional-properties=projectVersion=$VERSION
fi

# Generate GoLang SDK
if [[ ",$LANGUAGES," == *",go,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli generate \
      -c /local/configurations/go-config.yml \
      --skip-validate-spec \
      --additional-properties=packageVersion=$VERSION
# these generated structs collides between api_cluster.go and api_maintenance.go, needs to be improved TODO
sed $SED_INPLACE.bak -e 's/ApiEnterMaintenanceRequest/ApiClusterEnterMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak
sed $SED_INPLACE.bak -e 's/ApiExitMaintenanceRequest/ApiClusterExitMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak
gofmt -w ./go-sdk
fi
