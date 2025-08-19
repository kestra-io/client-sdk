# Java SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.

   - As of 09/06/25, a custom `kestra-ee.yml` is used to generate the Java SDK, where we did set the tenant as mandatory instead of optional.
   - Last `kestra-ee.yml` was generated with micronaut openapi `6.15`, for the next make sure to use the most recent version of it who should fixe 2 bugs.
2. Generate the SDK using the script `generate-sdks.sh` that uses the openapi-generator-cli docker image.

3. Then multiples files changes are needed to be done manually in the generated SDK:
  - Remove all `classifier` from the build.gradle file.
  - Add this dependency in the build.gradle file:
    ```groovy
    implementation "io.swagger.core.v3:swagger-annotations:$swagger_v3_annotations_version"
    ```
    - Enforce the SLF4J version to > 2.0
      ```groovy
      configurations.all {
        resolutionStrategy {
            force("org.slf4j:slf4j-api:2.0.17")
        }
      }
      ```
  - in the ApiClient.java file, we need to make it handle yaml mime type.

    First, add this method that will help detecting if a mime type is a yaml mime type:
  - ```java
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

## Step to use

The openapi generator will generate 1 Api per controller, so we create a custom Kestra Client that need to be instantiated once for every API.
Use the `io.kestra.sdk.KestraClient` manually written that gather everything in one client.