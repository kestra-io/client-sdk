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
 * FlowId
 */
@JsonPropertyOrder({
  FlowId.JSON_PROPERTY_ID,
  FlowId.JSON_PROPERTY_NAMESPACE,
  FlowId.JSON_PROPERTY_REVISION,
  FlowId.JSON_PROPERTY_TENANT_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class FlowId {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nullable
  private String id;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nullable
  private String namespace;

  public static final String JSON_PROPERTY_REVISION = "revision";
  @javax.annotation.Nullable
  private Integer revision;

  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  @javax.annotation.Nullable
  private String tenantId;

  public FlowId() {
  }

  public FlowId id(@javax.annotation.Nullable String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@javax.annotation.Nullable String id) {
    this.id = id;
  }

  public FlowId namespace(@javax.annotation.Nullable String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespace(@javax.annotation.Nullable String namespace) {
    this.namespace = namespace;
  }

  public FlowId revision(@javax.annotation.Nullable Integer revision) {
    
    this.revision = revision;
    return this;
  }

  /**
   * Get revision
   * @return revision
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRevision() {
    return revision;
  }


  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRevision(@javax.annotation.Nullable Integer revision) {
    this.revision = revision;
  }

  public FlowId tenantId(@javax.annotation.Nullable String tenantId) {
    
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTenantId() {
    return tenantId;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenantId(@javax.annotation.Nullable String tenantId) {
    this.tenantId = tenantId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowId flowId = (FlowId) o;
    return Objects.equals(this.id, flowId.id) &&
        Objects.equals(this.namespace, flowId.namespace) &&
        Objects.equals(this.revision, flowId.revision) &&
        Objects.equals(this.tenantId, flowId.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, namespace, revision, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowId {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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

    // add `id` to the URL query string
    if (getId() != null) {
      try {
        joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `namespace` to the URL query string
    if (getNamespace() != null) {
      try {
        joiner.add(String.format("%snamespace%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNamespace()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `revision` to the URL query string
    if (getRevision() != null) {
      try {
        joiner.add(String.format("%srevision%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getRevision()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `tenantId` to the URL query string
    if (getTenantId() != null) {
      try {
        joiner.add(String.format("%stenantId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTenantId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

