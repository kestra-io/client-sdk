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

# Generate Javascript SDK
if [[ ",$LANGUAGES," == *",javascript,"* ]]; then
    docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate \
        -i /local/kestra-ee.yml -g javascript -o /local/javascript-sdk --skip-validate-spec \
        --global-property=apiTests=false,modelTests=false \
        --additional-properties=packageName=kestra_api_client,projectName=kestra_api,packageVersion=$VERSION,usePromises=true

    PACKAGE_JSON_PATH="javascript-sdk/package.json"

    if [ -f "${PACKAGE_JSON_PATH}" ]; then
        echo "Modifying generated package.json at ${PACKAGE_JSON_PATH}..."

        TEMP_PACKAGE_JSON="${PACKAGE_JSON_PATH}.tmp"

        # Properly update the version and set type as "module" (ES Modules)
        awk -v new_version="$VERSION" '
        BEGIN {
            in_scripts_block = 0;
            scripts_buffer = "";
            inserted_type = 0;
        }

        # Handle the "name" line to insert "type"
        /  "name": / && !inserted_type {
            print $0;
            print "  \"type\": \"module\","
            inserted_type = 1;
            next;
        }

        # Handle the "version" line
        /  "version": / {
            print "  \"version\": \"" new_version "\","
            next;
        }

        # Handle the "main" line
        /  "main": "dist\/index.js"/ {
            print "  \"main\": \"src/index.js\","
            next;
        }

        # Start of "scripts" block
        /  "scripts": {/ {
            # Print the opening line
            print $0;
            in_scripts_block = 1;
            scripts_buffer = ""; # Clear buffer for new block
            next;
        }

        # End of "scripts" block
        in_scripts_block && /  }/ {
            # This is the closing brace for the scripts block.
            # Print the buffered, filtered scripts, then the closing brace.
            # Ensure no trailing comma before the closing brace if the last script was removed
            if (scripts_buffer != "") {
                # Remove trailing comma from the last line in the buffer, if it exists
                sub(/,$/, "", scripts_buffer);
                print scripts_buffer;
            }
            print $0; # Print the closing brace
            in_scripts_block = 0;
            next;
        }

        # Inside "scripts" block: filter "build" and "prepare"
        in_scripts_block {
            if ($0 ~ /"build": / || $0 ~ /"prepare": /) {
                # Skip these lines
            } else {
                # Buffer other script lines
                scripts_buffer = scripts_buffer $0 "\n";
            }
            next;
        }

        # Default action: print line as is (outside of scripts block)
        { print }
        ' "$PACKAGE_JSON_PATH" > "$TEMP_PACKAGE_JSON"

        find "${LOCAL_OUTPUT_PATH}/src" -type f -name "*.js" -print0 | while IFS= read -r -d $'\0' file; do
            # Use sed to add .js to relative imports (e.g., from './ModuleName' to './ModuleName.js')
            # This targets import statements that start with './' or '../' and don't end in .js
            # Adjust regex if other import patterns are present (e.g., from 'module_name/file')
            sed -i -E "s/^(import [^']+'\.\/[^']+)'$/\1.js'/" "$file"
            sed -i -E "s/^(import [^']+'\.\.\/[^']+)'$/\1.js'/" "$file"
            # Also need to handle require statements if they exist and are relative
            sed -i -E "s/^(require\('\.\/[^']+)'\))/\1.js')/" "$file"
            sed -i -E "s/^(require\('\.\.\/[^']+)'\))/\1.js')/" "$file"
            # More complex: handle cases like import Module from './dir/Module';
            # This is a general solution, might need fine-tuning based on actual generated imports.
            sed -i -E "s/^(import .* from ['\"'](\.\/|\.\.\/)[^'\"\.]+)['\"]/\1.js'/g" "$file"
            sed -i -E "s/^(require\(['\"](\.\/|\.\.\/)[^'\"\.]+)['\"]\))/\1.js')/g" "$file"
        done

        # Move the temporary file back to the original location
        if mv "$TEMP_PACKAGE_JSON" "$PACKAGE_JSON_PATH"; then
            echo "package.json modified successfully."
        else
            echo "Error: Failed to move temporary package.json file."
            rm -f "$TEMP_PACKAGE_JSON" # Clean up temp file
        fi
    else
        echo "Warning: package.json not found at ${PACKAGE_JSON_PATH}. Manual inspection needed."
    fi
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
