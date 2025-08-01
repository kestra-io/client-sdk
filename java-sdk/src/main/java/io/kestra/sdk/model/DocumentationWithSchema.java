/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kestra.sdk.model.PluginSchema;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * DocumentationWithSchema
 */
@JsonPropertyOrder({
  DocumentationWithSchema.JSON_PROPERTY_MARKDOWN,
  DocumentationWithSchema.JSON_PROPERTY_SCHEMA
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class DocumentationWithSchema {
  public static final String JSON_PROPERTY_MARKDOWN = "markdown";
  @javax.annotation.Nullable
  private String markdown;

  public static final String JSON_PROPERTY_SCHEMA = "schema";
  @javax.annotation.Nullable
  private PluginSchema schema;

  public DocumentationWithSchema() {
  }

  public DocumentationWithSchema markdown(@javax.annotation.Nullable String markdown) {
    
    this.markdown = markdown;
    return this;
  }

  /**
   * Get markdown
   * @return markdown
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MARKDOWN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMarkdown() {
    return markdown;
  }


  @JsonProperty(JSON_PROPERTY_MARKDOWN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMarkdown(@javax.annotation.Nullable String markdown) {
    this.markdown = markdown;
  }

  public DocumentationWithSchema schema(@javax.annotation.Nullable PluginSchema schema) {
    
    this.schema = schema;
    return this;
  }

  /**
   * Get schema
   * @return schema
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PluginSchema getSchema() {
    return schema;
  }


  @JsonProperty(JSON_PROPERTY_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSchema(@javax.annotation.Nullable PluginSchema schema) {
    this.schema = schema;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentationWithSchema documentationWithSchema = (DocumentationWithSchema) o;
    return Objects.equals(this.markdown, documentationWithSchema.markdown) &&
        Objects.equals(this.schema, documentationWithSchema.schema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(markdown, schema);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentationWithSchema {\n");
    sb.append("    markdown: ").append(toIndentedString(markdown)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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

    // add `markdown` to the URL query string
    if (getMarkdown() != null) {
      try {
        joiner.add(String.format("%smarkdown%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMarkdown()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `schema` to the URL query string
    if (getSchema() != null) {
      joiner.add(getSchema().toUrlQueryString(prefix + "schema" + suffix));
    }

    return joiner.toString();
  }

}

