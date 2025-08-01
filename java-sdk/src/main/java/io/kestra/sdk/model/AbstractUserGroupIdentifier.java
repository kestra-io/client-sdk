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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * AbstractUserGroupIdentifier
 */
@JsonPropertyOrder({
  AbstractUserGroupIdentifier.JSON_PROPERTY_TENANT_ID,
  AbstractUserGroupIdentifier.JSON_PROPERTY_GROUP_ID,
  AbstractUserGroupIdentifier.JSON_PROPERTY_MEMBERSHIP,
  AbstractUserGroupIdentifier.JSON_PROPERTY_MANAGED_EXTERNALLY
})
@JsonTypeName("AbstractUser.GroupIdentifier")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class AbstractUserGroupIdentifier {
  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  @javax.annotation.Nullable
  private String tenantId;

  public static final String JSON_PROPERTY_GROUP_ID = "groupId";
  @javax.annotation.Nonnull
  private String groupId;

  public static final String JSON_PROPERTY_MEMBERSHIP = "membership";
  @javax.annotation.Nonnull
  private AbstractUserGroupIdentifierMembership membership;

  public static final String JSON_PROPERTY_MANAGED_EXTERNALLY = "managedExternally";
  @javax.annotation.Nonnull
  private Boolean managedExternally;

  public AbstractUserGroupIdentifier() {
  }

  public AbstractUserGroupIdentifier tenantId(@javax.annotation.Nullable String tenantId) {

    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTenantId() {
    return tenantId;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTenantId(@javax.annotation.Nullable String tenantId) {
    this.tenantId = tenantId;
  }

  public AbstractUserGroupIdentifier groupId(@javax.annotation.Nonnull String groupId) {

    this.groupId = groupId;
    return this;
  }

  /**
   * Get groupId
   * @return groupId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGroupId() {
    return groupId;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupId(@javax.annotation.Nonnull String groupId) {
    this.groupId = groupId;
  }

  public AbstractUserGroupIdentifier membership(@javax.annotation.Nonnull AbstractUserGroupIdentifierMembership membership) {

    this.membership = membership;
    return this;
  }

  /**
   * Get membership
   * @return membership
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MEMBERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AbstractUserGroupIdentifierMembership getMembership() {
    return membership;
  }


  @JsonProperty(JSON_PROPERTY_MEMBERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMembership(@javax.annotation.Nonnull AbstractUserGroupIdentifierMembership membership) {
    this.membership = membership;
  }

  public AbstractUserGroupIdentifier managedExternally(@javax.annotation.Nonnull Boolean managedExternally) {

    this.managedExternally = managedExternally;
    return this;
  }

  /**
   * Get managedExternally
   * @return managedExternally
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MANAGED_EXTERNALLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getManagedExternally() {
    return managedExternally;
  }


  @JsonProperty(JSON_PROPERTY_MANAGED_EXTERNALLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setManagedExternally(@javax.annotation.Nonnull Boolean managedExternally) {
    this.managedExternally = managedExternally;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractUserGroupIdentifier abstractUserGroupIdentifier = (AbstractUserGroupIdentifier) o;
    return Objects.equals(this.tenantId, abstractUserGroupIdentifier.tenantId) &&
        Objects.equals(this.groupId, abstractUserGroupIdentifier.groupId) &&
        Objects.equals(this.membership, abstractUserGroupIdentifier.membership) &&
        Objects.equals(this.managedExternally, abstractUserGroupIdentifier.managedExternally);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, groupId, membership, managedExternally);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbstractUserGroupIdentifier {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    membership: ").append(toIndentedString(membership)).append("\n");
    sb.append("    managedExternally: ").append(toIndentedString(managedExternally)).append("\n");
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

    // add `tenantId` to the URL query string
    if (getTenantId() != null) {
      try {
        joiner.add(String.format("%stenantId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTenantId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `groupId` to the URL query string
    if (getGroupId() != null) {
      try {
        joiner.add(String.format("%sgroupId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getGroupId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `membership` to the URL query string
    if (getMembership() != null) {
      try {
        joiner.add(String.format("%smembership%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMembership()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `managedExternally` to the URL query string
    if (getManagedExternally() != null) {
      try {
        joiner.add(String.format("%smanagedExternally%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getManagedExternally()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

