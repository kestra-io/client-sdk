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
import io.kestra.sdk.model.ApiGroupSummary;
import io.kestra.sdk.model.ApiRoleSummary;
import io.kestra.sdk.model.InvitationInvitationStatus;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * IAMInvitationControllerApiInvitationDetail
 */
@JsonPropertyOrder({
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_ID,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_ROLES,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_GROUPS,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_TENANT_ID,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_EMAIL,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_STATUS,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_SENT_AT,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_EXPIRED_AT,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_ACCEPTED_AT,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_SUPER_ADMIN,
  IAMInvitationControllerApiInvitationDetail.JSON_PROPERTY_LINK
})
@JsonTypeName("IAMInvitationController.ApiInvitationDetail")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class IAMInvitationControllerApiInvitationDetail {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nullable
  private String id;

  public static final String JSON_PROPERTY_ROLES = "roles";
  @javax.annotation.Nullable
  private List<ApiRoleSummary> roles = new ArrayList<>();

  public static final String JSON_PROPERTY_GROUPS = "groups";
  @javax.annotation.Nullable
  private List<ApiGroupSummary> groups = new ArrayList<>();

  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  @javax.annotation.Nullable
  private String tenantId;

  public static final String JSON_PROPERTY_EMAIL = "email";
  @javax.annotation.Nullable
  private String email;

  public static final String JSON_PROPERTY_STATUS = "status";
  @javax.annotation.Nullable
  private InvitationInvitationStatus status;

  public static final String JSON_PROPERTY_SENT_AT = "sentAt";
  @javax.annotation.Nullable
  private OffsetDateTime sentAt;

  public static final String JSON_PROPERTY_EXPIRED_AT = "expiredAt";
  @javax.annotation.Nullable
  private OffsetDateTime expiredAt;

  public static final String JSON_PROPERTY_ACCEPTED_AT = "acceptedAt";
  @javax.annotation.Nullable
  private OffsetDateTime acceptedAt;

  public static final String JSON_PROPERTY_SUPER_ADMIN = "superAdmin";
  @javax.annotation.Nullable
  private Boolean superAdmin;

  public static final String JSON_PROPERTY_LINK = "link";
  @javax.annotation.Nullable
  private String link;

  public IAMInvitationControllerApiInvitationDetail() {
  }

  public IAMInvitationControllerApiInvitationDetail id(@javax.annotation.Nullable String id) {
    
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

  public IAMInvitationControllerApiInvitationDetail roles(@javax.annotation.Nullable List<ApiRoleSummary> roles) {
    
    this.roles = roles;
    return this;
  }

  public IAMInvitationControllerApiInvitationDetail addRolesItem(ApiRoleSummary rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ApiRoleSummary> getRoles() {
    return roles;
  }


  @JsonProperty(JSON_PROPERTY_ROLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoles(@javax.annotation.Nullable List<ApiRoleSummary> roles) {
    this.roles = roles;
  }

  public IAMInvitationControllerApiInvitationDetail groups(@javax.annotation.Nullable List<ApiGroupSummary> groups) {
    
    this.groups = groups;
    return this;
  }

  public IAMInvitationControllerApiInvitationDetail addGroupsItem(ApiGroupSummary groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ApiGroupSummary> getGroups() {
    return groups;
  }


  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroups(@javax.annotation.Nullable List<ApiGroupSummary> groups) {
    this.groups = groups;
  }

  public IAMInvitationControllerApiInvitationDetail tenantId(@javax.annotation.Nullable String tenantId) {
    
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

  public IAMInvitationControllerApiInvitationDetail email(@javax.annotation.Nullable String email) {
    
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(@javax.annotation.Nullable String email) {
    this.email = email;
  }

  public IAMInvitationControllerApiInvitationDetail status(@javax.annotation.Nullable InvitationInvitationStatus status) {
    
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InvitationInvitationStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(@javax.annotation.Nullable InvitationInvitationStatus status) {
    this.status = status;
  }

  public IAMInvitationControllerApiInvitationDetail sentAt(@javax.annotation.Nullable OffsetDateTime sentAt) {
    
    this.sentAt = sentAt;
    return this;
  }

  /**
   * Get sentAt
   * @return sentAt
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getSentAt() {
    return sentAt;
  }


  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSentAt(@javax.annotation.Nullable OffsetDateTime sentAt) {
    this.sentAt = sentAt;
  }

  public IAMInvitationControllerApiInvitationDetail expiredAt(@javax.annotation.Nullable OffsetDateTime expiredAt) {
    
    this.expiredAt = expiredAt;
    return this;
  }

  /**
   * Get expiredAt
   * @return expiredAt
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXPIRED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getExpiredAt() {
    return expiredAt;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiredAt(@javax.annotation.Nullable OffsetDateTime expiredAt) {
    this.expiredAt = expiredAt;
  }

  public IAMInvitationControllerApiInvitationDetail acceptedAt(@javax.annotation.Nullable OffsetDateTime acceptedAt) {
    
    this.acceptedAt = acceptedAt;
    return this;
  }

  /**
   * Get acceptedAt
   * @return acceptedAt
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ACCEPTED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getAcceptedAt() {
    return acceptedAt;
  }


  @JsonProperty(JSON_PROPERTY_ACCEPTED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAcceptedAt(@javax.annotation.Nullable OffsetDateTime acceptedAt) {
    this.acceptedAt = acceptedAt;
  }

  public IAMInvitationControllerApiInvitationDetail superAdmin(@javax.annotation.Nullable Boolean superAdmin) {
    
    this.superAdmin = superAdmin;
    return this;
  }

  /**
   * Get superAdmin
   * @return superAdmin
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPER_ADMIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSuperAdmin() {
    return superAdmin;
  }


  @JsonProperty(JSON_PROPERTY_SUPER_ADMIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuperAdmin(@javax.annotation.Nullable Boolean superAdmin) {
    this.superAdmin = superAdmin;
  }

  public IAMInvitationControllerApiInvitationDetail link(@javax.annotation.Nullable String link) {
    
    this.link = link;
    return this;
  }

  /**
   * Get link
   * @return link
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLink() {
    return link;
  }


  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLink(@javax.annotation.Nullable String link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IAMInvitationControllerApiInvitationDetail iaMInvitationControllerApiInvitationDetail = (IAMInvitationControllerApiInvitationDetail) o;
    return Objects.equals(this.id, iaMInvitationControllerApiInvitationDetail.id) &&
        Objects.equals(this.roles, iaMInvitationControllerApiInvitationDetail.roles) &&
        Objects.equals(this.groups, iaMInvitationControllerApiInvitationDetail.groups) &&
        Objects.equals(this.tenantId, iaMInvitationControllerApiInvitationDetail.tenantId) &&
        Objects.equals(this.email, iaMInvitationControllerApiInvitationDetail.email) &&
        Objects.equals(this.status, iaMInvitationControllerApiInvitationDetail.status) &&
        Objects.equals(this.sentAt, iaMInvitationControllerApiInvitationDetail.sentAt) &&
        Objects.equals(this.expiredAt, iaMInvitationControllerApiInvitationDetail.expiredAt) &&
        Objects.equals(this.acceptedAt, iaMInvitationControllerApiInvitationDetail.acceptedAt) &&
        Objects.equals(this.superAdmin, iaMInvitationControllerApiInvitationDetail.superAdmin) &&
        Objects.equals(this.link, iaMInvitationControllerApiInvitationDetail.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, roles, groups, tenantId, email, status, sentAt, expiredAt, acceptedAt, superAdmin, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IAMInvitationControllerApiInvitationDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sentAt: ").append(toIndentedString(sentAt)).append("\n");
    sb.append("    expiredAt: ").append(toIndentedString(expiredAt)).append("\n");
    sb.append("    acceptedAt: ").append(toIndentedString(acceptedAt)).append("\n");
    sb.append("    superAdmin: ").append(toIndentedString(superAdmin)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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

    // add `roles` to the URL query string
    if (getRoles() != null) {
      for (int i = 0; i < getRoles().size(); i++) {
        if (getRoles().get(i) != null) {
          joiner.add(getRoles().get(i).toUrlQueryString(String.format("%sroles%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `groups` to the URL query string
    if (getGroups() != null) {
      for (int i = 0; i < getGroups().size(); i++) {
        if (getGroups().get(i) != null) {
          joiner.add(getGroups().get(i).toUrlQueryString(String.format("%sgroups%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
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

    // add `email` to the URL query string
    if (getEmail() != null) {
      try {
        joiner.add(String.format("%semail%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEmail()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `status` to the URL query string
    if (getStatus() != null) {
      try {
        joiner.add(String.format("%sstatus%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStatus()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `sentAt` to the URL query string
    if (getSentAt() != null) {
      try {
        joiner.add(String.format("%ssentAt%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSentAt()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `expiredAt` to the URL query string
    if (getExpiredAt() != null) {
      try {
        joiner.add(String.format("%sexpiredAt%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExpiredAt()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `acceptedAt` to the URL query string
    if (getAcceptedAt() != null) {
      try {
        joiner.add(String.format("%sacceptedAt%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getAcceptedAt()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `superAdmin` to the URL query string
    if (getSuperAdmin() != null) {
      try {
        joiner.add(String.format("%ssuperAdmin%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSuperAdmin()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `link` to the URL query string
    if (getLink() != null) {
      try {
        joiner.add(String.format("%slink%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getLink()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

