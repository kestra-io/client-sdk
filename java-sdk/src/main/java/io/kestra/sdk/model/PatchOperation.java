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
import io.kestra.sdk.model.PatchOperationPath;
import io.kestra.sdk.model.PatchOperationType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * PatchOperation
 */
@JsonPropertyOrder({
  PatchOperation.JSON_PROPERTY_OPERATION,
  PatchOperation.JSON_PROPERTY_PATH,
  PatchOperation.JSON_PROPERTY_VALUE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class PatchOperation {
  public static final String JSON_PROPERTY_OPERATION = "operation";
  @javax.annotation.Nullable
  private PatchOperationType operation;

  public static final String JSON_PROPERTY_PATH = "path";
  @javax.annotation.Nullable
  private PatchOperationPath path;

  public static final String JSON_PROPERTY_VALUE = "value";
  @javax.annotation.Nullable
  private Object value;

  public PatchOperation() {
  }

  public PatchOperation operation(@javax.annotation.Nullable PatchOperationType operation) {
    
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PatchOperationType getOperation() {
    return operation;
  }


  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperation(@javax.annotation.Nullable PatchOperationType operation) {
    this.operation = operation;
  }

  public PatchOperation path(@javax.annotation.Nullable PatchOperationPath path) {
    
    this.path = path;
    return this;
  }

  /**
   * Get path
   * @return path
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PatchOperationPath getPath() {
    return path;
  }


  @JsonProperty(JSON_PROPERTY_PATH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPath(@javax.annotation.Nullable PatchOperationPath path) {
    this.path = path;
  }

  public PatchOperation value(@javax.annotation.Nullable Object value) {
    
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(@javax.annotation.Nullable Object value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchOperation patchOperation = (PatchOperation) o;
    return Objects.equals(this.operation, patchOperation.operation) &&
        Objects.equals(this.path, patchOperation.path) &&
        Objects.equals(this.value, patchOperation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, path, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchOperation {\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

    // add `operation` to the URL query string
    if (getOperation() != null) {
      try {
        joiner.add(String.format("%soperation%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getOperation()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `path` to the URL query string
    if (getPath() != null) {
      joiner.add(getPath().toUrlQueryString(prefix + "path" + suffix));
    }

    // add `value` to the URL query string
    if (getValue() != null) {
      try {
        joiner.add(String.format("%svalue%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getValue()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

