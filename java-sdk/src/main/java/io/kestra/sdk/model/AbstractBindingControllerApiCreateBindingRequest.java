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
import io.kestra.sdk.model.BindingType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * AbstractBindingControllerApiCreateBindingRequest
 */
@JsonPropertyOrder({
  AbstractBindingControllerApiCreateBindingRequest.JSON_PROPERTY_TYPE,
  AbstractBindingControllerApiCreateBindingRequest.JSON_PROPERTY_EXTERNAL_ID,
  AbstractBindingControllerApiCreateBindingRequest.JSON_PROPERTY_ROLE_ID,
  AbstractBindingControllerApiCreateBindingRequest.JSON_PROPERTY_NAMESPACE_ID
})
@JsonTypeName("AbstractBindingController.ApiCreateBindingRequest")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:07:17.548591265Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class AbstractBindingControllerApiCreateBindingRequest {
  public static final String JSON_PROPERTY_TYPE = "type";
  @javax.annotation.Nonnull
  private BindingType type;

  public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
  @javax.annotation.Nonnull
  private String externalId;

  public static final String JSON_PROPERTY_ROLE_ID = "roleId";
  @javax.annotation.Nonnull
  private String roleId;

  public static final String JSON_PROPERTY_NAMESPACE_ID = "namespaceId";
  @javax.annotation.Nonnull
  private String namespaceId;

  public AbstractBindingControllerApiCreateBindingRequest() {
  }

  public AbstractBindingControllerApiCreateBindingRequest type(@javax.annotation.Nonnull BindingType type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BindingType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(@javax.annotation.Nonnull BindingType type) {
    this.type = type;
  }

  public AbstractBindingControllerApiCreateBindingRequest externalId(@javax.annotation.Nonnull String externalId) {
    
    this.externalId = externalId;
    return this;
  }

  /**
   * Get externalId
   * @return externalId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExternalId() {
    return externalId;
  }


  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExternalId(@javax.annotation.Nonnull String externalId) {
    this.externalId = externalId;
  }

  public AbstractBindingControllerApiCreateBindingRequest roleId(@javax.annotation.Nonnull String roleId) {
    
    this.roleId = roleId;
    return this;
  }

  /**
   * Get roleId
   * @return roleId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ROLE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRoleId() {
    return roleId;
  }


  @JsonProperty(JSON_PROPERTY_ROLE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRoleId(@javax.annotation.Nonnull String roleId) {
    this.roleId = roleId;
  }

  public AbstractBindingControllerApiCreateBindingRequest namespaceId(@javax.annotation.Nonnull String namespaceId) {
    
    this.namespaceId = namespaceId;
    return this;
  }

  /**
   * Get namespaceId
   * @return namespaceId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAMESPACE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNamespaceId() {
    return namespaceId;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNamespaceId(@javax.annotation.Nonnull String namespaceId) {
    this.namespaceId = namespaceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractBindingControllerApiCreateBindingRequest abstractBindingControllerApiCreateBindingRequest = (AbstractBindingControllerApiCreateBindingRequest) o;
    return Objects.equals(this.type, abstractBindingControllerApiCreateBindingRequest.type) &&
        Objects.equals(this.externalId, abstractBindingControllerApiCreateBindingRequest.externalId) &&
        Objects.equals(this.roleId, abstractBindingControllerApiCreateBindingRequest.roleId) &&
        Objects.equals(this.namespaceId, abstractBindingControllerApiCreateBindingRequest.namespaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, externalId, roleId, namespaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbstractBindingControllerApiCreateBindingRequest {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    namespaceId: ").append(toIndentedString(namespaceId)).append("\n");
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

    // add `type` to the URL query string
    if (getType() != null) {
      try {
        joiner.add(String.format("%stype%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `externalId` to the URL query string
    if (getExternalId() != null) {
      try {
        joiner.add(String.format("%sexternalId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExternalId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `roleId` to the URL query string
    if (getRoleId() != null) {
      try {
        joiner.add(String.format("%sroleId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getRoleId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `namespaceId` to the URL query string
    if (getNamespaceId() != null) {
      try {
        joiner.add(String.format("%snamespaceId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNamespaceId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

