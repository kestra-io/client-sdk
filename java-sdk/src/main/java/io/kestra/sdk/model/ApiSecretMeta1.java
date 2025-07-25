/*
 * Kestra EE
 * All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.
 *
 * The version of the OpenAPI document: v1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.kestra.sdk.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * ApiSecretMeta1
 */
@JsonPropertyOrder({
  ApiSecretMeta1.JSON_PROPERTY_KEY,
  ApiSecretMeta1.JSON_PROPERTY_DESCRIPTION,
  ApiSecretMeta1.JSON_PROPERTY_TAGS
})
@JsonTypeName("ApiSecretMeta_1")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-05T09:35:00.542044223Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class ApiSecretMeta1 {
  public static final String JSON_PROPERTY_KEY = "key";
  @javax.annotation.Nonnull
  private String key;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nonnull
  private String description;

  public static final String JSON_PROPERTY_TAGS = "tags";
  @javax.annotation.Nonnull
  private List<ApiSecretTag> tags = new ArrayList<>();

  public ApiSecretMeta1() {
  }

  public ApiSecretMeta1 key(@javax.annotation.Nonnull String key) {

    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getKey() {
    return key;
  }


  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKey(@javax.annotation.Nonnull String key) {
    this.key = key;
  }

  public ApiSecretMeta1 description(@javax.annotation.Nonnull String description) {

    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(@javax.annotation.Nonnull String description) {
    this.description = description;
  }

  public ApiSecretMeta1 tags(@javax.annotation.Nonnull List<ApiSecretTag> tags) {

    this.tags = tags;
    return this;
  }

  public ApiSecretMeta1 addTagsItem(ApiSecretTag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ApiSecretTag> getTags() {
    return tags;
  }


  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTags(@javax.annotation.Nonnull List<ApiSecretTag> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiSecretMeta1 apiSecretMeta1 = (ApiSecretMeta1) o;
    return Objects.equals(this.key, apiSecretMeta1.key) &&
        Objects.equals(this.description, apiSecretMeta1.description) &&
        Objects.equals(this.tags, apiSecretMeta1.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSecretMeta1 {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `key` to the URL query string
    if (getKey() != null) {
      try {
        joiner.add(String.format("%skey%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getKey()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `description` to the URL query string
    if (getDescription() != null) {
      try {
        joiner.add(String.format("%sdescription%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDescription()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `tags` to the URL query string
    if (getTags() != null) {
      for (int i = 0; i < getTags().size(); i++) {
        if (getTags().get(i) != null) {
          joiner.add(getTags().get(i).toUrlQueryString(String.format("%stags%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

