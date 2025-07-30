# Java SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` with latest OpenSpec API changes (if necessary).
   - As of 2025-06-09, a custom `kestra-ee.yml` is used to generate the Java SDK. In this file, the `tenant` field is set as mandatory rather than optional.
   - The current file was generated with Micronaut OpenAPI version `6.15`. For the next generation, ensure you use the latest available version, which should fix two known bugs.

2. Generate the SDK using the `generate-sdks.sh` script, which leverages the `openapi-generator-cli` Docker image.

3. Apply manual modifications to the generated SDK files:

  - Remove all `classifier` from the build.gradle file.

   - Add the following dependency to `build.gradle`:

    ```groovy
    implementation "io.swagger.core.v3:swagger-annotations:$swagger_v3_annotations_version"
    ```
    - Enforce the SLF4J version to be greater than 2.0:

      ```groovy
      configurations.all {
        resolutionStrategy {
            force("org.slf4j:slf4j-api:2.0.17")
        }
      }
      ```

   - In `ApiClient.java`, add support for YAML MIME types.

    First, add this method that will help detecting if a mime type is a yaml mime type:

    ```java
    public boolean isYamlMime(String mime) {
        // This regex matches application/x-yaml, text/yaml, or any subtype like application/vnd.api+yaml
        String yamlMime = "(?i)^(application/x-yaml|text/yaml|[^;/ \t]+/[^;/ \t]+[+]yaml)[ \t]*(;.*)?$";
        return mime != null && mime.matches(yamlMime);
    }
    ```

    Then, in the method `public HttpEntity serialize(Object obj, Map<String, Object> formParams, ContentType contentType)` of that same client,
    add the following else/if code:

    ```java
      else if (isYamlMime(mimeType)) {
        return new StringEntity((String) obj, contentType.withCharset(StandardCharsets.UTF_8));
      }
      ```

## How to use

The OpenAPI generator creates one API class per controller. To streamline integration, use the manually written `io.kestra.sdk.KestraClient`, which consolidates all APIs into a single client.

Instantiate the client once per API and configure it as needed for your usage.
