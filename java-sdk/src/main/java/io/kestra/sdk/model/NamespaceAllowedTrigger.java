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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * NamespaceAllowedTrigger
 * @deprecated
 */
@Deprecated
@JsonPropertyOrder({
  NamespaceAllowedTrigger.JSON_PROPERTY_NAMESPACE,
  NamespaceAllowedTrigger.JSON_PROPERTY_FLOW_ID
})
@JsonTypeName("Namespace.AllowedTrigger")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class NamespaceAllowedTrigger {
  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nonnull
  private String namespace;

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @javax.annotation.Nullable
  private String flowId;

  public NamespaceAllowedTrigger() {
  }

  public NamespaceAllowedTrigger namespace(@javax.annotation.Nonnull String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNamespace(@javax.annotation.Nonnull String namespace) {
    this.namespace = namespace;
  }

  public NamespaceAllowedTrigger flowId(@javax.annotation.Nullable String flowId) {
    
    this.flowId = flowId;
    return this;
  }

  /**
   * Get flowId
   * @return flowId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFlowId() {
    return flowId;
  }


  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFlowId(@javax.annotation.Nullable String flowId) {
    this.flowId = flowId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NamespaceAllowedTrigger namespaceAllowedTrigger = (NamespaceAllowedTrigger) o;
    return Objects.equals(this.namespace, namespaceAllowedTrigger.namespace) &&
        Objects.equals(this.flowId, namespaceAllowedTrigger.flowId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, flowId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NamespaceAllowedTrigger {\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
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

    // add `namespace` to the URL query string
    if (getNamespace() != null) {
      try {
        joiner.add(String.format("%snamespace%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNamespace()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `flowId` to the URL query string
    if (getFlowId() != null) {
      try {
        joiner.add(String.format("%sflowId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFlowId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

