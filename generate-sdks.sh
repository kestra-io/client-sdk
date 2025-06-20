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
    -i /local/kestra-ee.yml -g java -o /local/java-sdk --skip-validate-spec \
    --library apache-httpclient --global-property=apiTests=false,modelTests=false \
    --invoker-package $BASE_PKG.internal --model-package $BASE_PKG.model --api-package $BASE_PKG.api \
    --group-id io.kestra --artifact-id kestra-api-client --artifact-version $VERSION
fi

# Generate Python SDK
if [[ ",$LANGUAGES," == *",python,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
    -i /local/kestra-ee.yml -g python -o /local/python-sdk --skip-validate-spec \
    --global-property=apiTests=false,modelTests=false \
    --additional-properties=packageName=kestra_api_client,projectName=kestra_api,packageVersion=$VERSION
fi

# Generate Python SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
    -i /local/kestra-ee.yml -g javascript -o /local/javascript-sdk --skip-validate-spec \
    --global-property=apiTests=false,modelTests=false \
    --additional-properties=packageName=kestra_api_client,projectName=kestra_api,packageVersion=$VERSION
fi


# Generate GoLang SDK
if [[ ",$LANGUAGES," == *",go,"* ]]; then
docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
    -i /local/kestra-ee.yml -g go -o /local/go-sdk --skip-validate-spec \
    --global-property=apiTests=false,modelTests=false \
    --additional-properties=packageName=kestra_api_client,projectName=kestra_api,packageVersion=$VERSION,enumClassPrefix=true \
    --git-user-id=kestra-io --git-repo-id=client-sdk/go-sdk
# these generated structs collides between api_cluster.go and api_maintenance.go, needs to be improved TODO
sed -i.bak -e 's/ApiEnterMaintenanceRequest/ApiClusterEnterMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak
sed -i.bak -e 's/ApiExitMaintenanceRequest/ApiClusterExitMaintenanceRequest/g' ./go-sdk/api_cluster.go && rm ./go-sdk/api_cluster.go.bak

gofmt -w ./go-sdk
fi

