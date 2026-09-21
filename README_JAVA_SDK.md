# Java SDK

## History: how the SDK was originally generated (before #222)

> **This SDK is hand-written since #222.** `./generate-sdks.sh` refuses to run
> for it, and the generator apparatus (templates, `.openapi-generator/`
> metadata, embedded spec copy) has been removed from this repository. Edit
> the sources under `java/java-sdk` directly. The steps below describe how the
> SDK was generated before that change, kept for historical context only.

1. The `kestra-ee.yml` was updated as needed with the latest openapi spec changes.

   - As of 09/06/25, a custom `kestra-ee.yml` was used to generate the Java SDK, where we did set the tenant as mandatory instead of optional.
   - Last `kestra-ee.yml` was generated with micronaut openapi `6.15`, for the next make sure to use the most recent version of it who should fixe 2 bugs.
2. The SDK was generated using the (now-removed) `generate-sdks.sh` templating step, which used the openapi-generator-cli docker image.

3. Then multiples files changes had to be done manually in the generated SDK:
  - Remove all `classifier` from the build.gradle file.
  - Add this dependency in the build.gradle file:
    ```groovy
    implementation "io.swagger.core.v3:swagger-annotations:$swagger_v3_annotations_version"
    ```
    note: you may only need to rollback all the build.gradle and bump gradle.properties
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

### More informations (historical)

- SSE methods were injected from templates (now removed)
- Openapi spec was modified during generation through a custom TS script
- KestraClient is manually written to gather all API clients in one client
- ApiClient & build.gradle were fixed through the templates (now removed)
- Method with Multipart form need an annotation on Kestra side to generate properly the SDK method

## Step to use

The openapi generator will generate 1 Api per controller, so we create a custom Kestra Client that need to be instantiated once for every API.
Use the `io.kestra.sdk.KestraClient` manually written that gather everything in one client.

## Complex queries (AND / OR filters)

Every `*ByQuery` / search endpoint accepts grouped filters. Build them with the `Query`
DSL instead of hand-encoding `filters[...]` strings:

```java
import static io.kestra.sdk.query.Query.*;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;

List<QueryFilter> filters = where(
    and(
        eq(QueryFilterField.NAMESPACE, "company.team"),
        or(
            eq(QueryFilterField.STATE, "SUCCESS"),
            eq(QueryFilterField.STATE, "WARNING")
        )
    )
);
// filters drops straight into any *ByQuery / search method that takes List<QueryFilter>.
```

- Helpers: `where`, `and`, `or`, `filter`, `eq`, `notEq`, `in`, `notIn`, `contains`, `startsWith`,
  `endsWith`, `regex`, `prefix`, `greaterThan`, `greaterThanOrEqual`, `lessThan`, `lessThanOrEqual`.
- **Backward compatible:** a plain `List<QueryFilter>` (or `where(and(...leaves))`) serializes to the
  same flat `filters[field][OP]=value` wire format as before.
- Nesting is **one level deep** (an `and` containing an `or`, or vice-versa); deeper nesting throws.