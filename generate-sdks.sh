#!/bin/bash
set -e

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

# Disabled for now
#OPENAPI_GITHUB_LOCATION="/repos/kestra-io/kestra-ee/contents/kestra-ee.yml"
#OPENAPI_LOCATION_BRANCH="v1.0.7-openapi-spec"
#echo "download openapi spec from github at '$OPENAPI_GITHUB_LOCATION' in branch '$OPENAPI_LOCATION_BRANCH'"
#gh api -H "Accept: application/vnd.github.raw" "$OPENAPI_GITHUB_LOCATION?ref=$OPENAPI_LOCATION_BRANCH" > kestra-ee.yml

if [ -n "$TEMPLATE_FLAG" ]; then
  echo "Generating templates"
  docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release author template -g "$LANGUAGES" -o /local/$LANGUAGES/templates
  exit 0
fi

KESTRA_OPENAPI_SDK_CUSTOMIZER_CONF=$(readlink -f ./configurations/kestra-openapi-sdk-customizer.json)
KESTRA_OPENAPI=$(readlink -f ./kestra-ee.yml)
sh -c "cd ./generation-helpers/kestra-openapi-sdk-customizer && npm i && npm run build && npm start $KESTRA_OPENAPI_SDK_CUSTOMIZER_CONF $KESTRA_OPENAPI"

# Generate Java SDK
if [[ ",$LANGUAGES," == *",java,"* ]]; then
rm -rf ./java/java-sdk/docs
rm -rf ./java/java-sdk/src/main/java/io/kestra/sdk/api
rm -rf ./java/java-sdk/src/main/java/io/kestra/sdk/internal
rm -rf ./java/java-sdk/src/main/java/io/kestra/sdk/model

docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release generate \
     -c /local/java/configuration/java-config.yml --artifact-version $VERSION \
      --skip-validate-spec \
      --template-dir=/local/java/template

find ./java/java-sdk/src/main/java -type f -name "*.java" -exec sed -i.bak 's/Map<Task>/List<Task>/g' {} + && find ./java/java-sdk/src/main/java -name "*.bak" -delete
echo "version=$VERSION" > ./java/java-sdk/gradle.properties


# Replace wrong prop in docs for each api
for f in java-sdk/docs/*.md; do
  [ -f "$f" ] || continue
  sed -E -i 's/\b([A-Za-z]+)Api\b/\L\1/g' "$f"
done
fi

# Generate Python SDK
if [[ ",$LANGUAGES," == *",python,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release generate \
    -c /local/python/configuration/python-config.yml \
    --skip-validate-spec \
    --additional-properties=packageVersion=$VERSION \
    --template-dir=/local/python/template

sed $SED_INPLACE -E '/from kestrapy\.models\.list\[label\] import List\[Label\]/d' python/python-sdk/kestrapy/api/executions_api.py
sed $SED_INPLACE -E 's/value: Optional\[Dict\[str, Any\]\] = None/value: Optional[Any] = None/' python/python-sdk/kestrapy/models/kv_controller_typed_value.py
echo "from kestrapy.kestra_client import KestraClient as KestraClient" >> python/python-sdk/kestrapy/__init__.py

# Replace wrong prop in docs for each api
for f in python-sdk/docs/*.md; do
  [ -f "$f" ] || continue
  sed -E -i 's/\b([A-Za-z]+)Api\b/\L\1/g' "$f"
done
fi

# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release generate \
    -c /local/javascript/configuration/javascript-config.yml \
    --skip-validate-spec \
    --additional-properties=projectVersion=$VERSION \
    --template-dir=/local/javascript/template

sed -i '' -E "s/let returnType = \{'String': \['String'\]\};/let returnType = Object;/" ./javascript/javascript-sdk/src/api/NamespacesApi.js
sed -i '' -E "s/let returnType = File;/let returnType = 'Blob';/" ./javascript/javascript-sdk/src/api/ExecutionsApi.js
sed -i '' -E "s/obj\['value'\][[:space:]]*=[[:space:]]*OutputValue\.constructFromObject\(([^)]*)\);/obj['value'] = ApiClient.convertToType(\1, 'Object');/" ./javascript/javascript-sdk/src/model/Output.js
sed -i '' -E "s/obj\[([\"'])([A-Za-z0-9_]+)\1\] = Object\.constructFromObject\(data\[\1\2\1\]\);/obj[\1\2\1] = ApiClient.convertToType(data[\1\2\1], 'Object');/g" ./javascript/javascript-sdk/src/model/Assertion.js
sed -i '' -E "s/obj\[([\"'])([A-Za-z0-9_]+)\1\] = ([\"'])([A-Za-z]+)\3\.constructFromObject\(data\[\1\2\1\]\);/obj[\1\2\1] = ApiClient.convertToType(data[\1\2\1], \3\4\3);/g" ./javascript/javascript-sdk/src/model/Assertion.js
sed -i '' -E "s/let authNames = \[\];/let authNames = \['basicAuth', 'bearerAuth'\];/" ./javascript/javascript-sdk/src/api/TestSuitesApi.js
sed -i '' -E "s/    \* @return \{Promise< module:model\/([A-Za-z0-9_]+) >\}/    \* @return \{Promise<\1>\}/" ./javascript/javascript-sdk/src/api/*.js
rm ./javascript/javascript-sdk/git_push.sh
rm ./javascript/javascript-sdk/mocha.opts
rm ./javascript/javascript-sdk/.babelrc
rm ./javascript/javascript-sdk/.travis.yml
cp -R ./javascript/template-files/* ./javascript/javascript-sdk/
fi

# Generate GoLang SDK
if [[ ",$LANGUAGES," == *",go,"* ]]; then
docker run --rm -v ${PWD}:/local --user ${HOST_UID}:${HOST_GID} openapitools/openapi-generator-cli:latest-release generate \
    -c /local/go/configuration/go-config.yml \
    --skip-validate-spec \
    --additional-properties=packageVersion=$VERSION \
    --template-dir=/local/go/template
# these generated structs collides between api_cluster.go and api_maintenance.go, needs to be improved TODO
sed $SED_INPLACE.bak -e 's/ApiEnterMaintenanceRequest/ApiClusterEnterMaintenanceRequest/g' ./go/go-sdk/api_cluster.go && rm ./go/go-sdk/api_cluster.go.bak
sed $SED_INPLACE.bak -e 's/ApiExitMaintenanceRequest/ApiClusterExitMaintenanceRequest/g' ./go/go-sdk/api_cluster.go && rm ./go/go-sdk/api_cluster.go.bak
gofmt -w ./go-sdk
fi
