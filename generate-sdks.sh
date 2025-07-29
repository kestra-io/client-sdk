#!/bin/bash

VERSION=$1
LANGUAGES=$2

# check if LANGUAGES is empty
if [ -z "$LANGUAGES" ]; then
  echo "No languages specified. Please provide a comma-separated list of languages. Possible languages are: 'java', 'python', 'go' and 'javascript'"
  exit 1
fi

BASE_PKG=io.kestra.sdk

# Generate Java SDK
if [[ ",$LANGUAGES," == *",java,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
     -c /local/configurations/java-config.yml --artifact-version $VERSION \
      --skip-validate-spec
fi

# Generate Python SDK
if [[ ",$LANGUAGES," == *",python,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
    -c /local/configurations/python-config.yml \
    --skip-validate-spec \
    --additional-properties=packageVersion=$VERSION
sed -i 's/^license = .*/license = "Apache-2.0"/' python-sdk/pyproject.toml
sed -i 's/^requires-python = .*/requires-python = ">=3.9"/' python-sdk/pyproject.toml
sed -i '/from kestra_api_client\.models\.list\[label\] import List\[Label\]/d' python-sdk/kestra_api_client/api/executions_api.py
grep -vF '{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}' python-sdk/kestra_api_client/models/task.py > temp_file && mv temp_file python-sdk/kestra_api_client/models/task.py
echo "from kestra_api_client.kestra_client import KestraClient as KestraClient" >> python-sdk/kestra_api_client/__init__.py
fi

# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
    -c /local/configurations/javascript-config.yml \
    --skip-validate-spec \
    --additional-properties=projectVersion=$VERSION
fi

# Generate GoLang SDK
if [[ ",$LANGUAGES," == *",go,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
      -c /local/configurations/go-config.yml \
      --skip-validate-spec \
      --additional-properties=packageVersion=$VERSION
# these generated structs collides between api_cluster.go and api_maintenance.go, needs to be improved TODO
sed -i.bak -e 's/ApiEnterMaintenanceRequest/ApiClusterEnterMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak
sed -i.bak -e 's/ApiExitMaintenanceRequest/ApiClusterExitMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak
gofmt -w ./go-sdk
fi
