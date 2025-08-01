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
import io.kestra.sdk.model.IAMUserControllerApiTenant;
import io.kestra.sdk.model.IAMUserControllerApiUserAuth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * IAMUserControllerApiUserSummary
 */
@JsonPropertyOrder({
  IAMUserControllerApiUserSummary.JSON_PROPERTY_ID,
  IAMUserControllerApiUserSummary.JSON_PROPERTY_USERNAME,
  IAMUserControllerApiUserSummary.JSON_PROPERTY_DISPLAY_NAME,
  IAMUserControllerApiUserSummary.JSON_PROPERTY_TENANTS,
  IAMUserControllerApiUserSummary.JSON_PROPERTY_AUTHS,
  IAMUserControllerApiUserSummary.JSON_PROPERTY_SUPER_ADMIN
})
@JsonTypeName("IAMUserController.ApiUserSummary")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class IAMUserControllerApiUserSummary {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nullable
  private String id;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @javax.annotation.Nullable
  private String username;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @javax.annotation.Nullable
  private String displayName;

  public static final String JSON_PROPERTY_TENANTS = "tenants";
  @javax.annotation.Nullable
  private List<IAMUserControllerApiTenant> tenants = new ArrayList<>();

  public static final String JSON_PROPERTY_AUTHS = "auths";
  @javax.annotation.Nullable
  private List<IAMUserControllerApiUserAuth> auths = new ArrayList<>();

  public static final String JSON_PROPERTY_SUPER_ADMIN = "superAdmin";
  @javax.annotation.Nullable
  private Boolean superAdmin;

  public IAMUserControllerApiUserSummary() {
  }

  public IAMUserControllerApiUserSummary id(@javax.annotation.Nullable String id) {
    
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

  public IAMUserControllerApiUserSummary username(@javax.annotation.Nullable String username) {
    
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUsername() {
    return username;
  }


  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUsername(@javax.annotation.Nullable String username) {
    this.username = username;
  }

  public IAMUserControllerApiUserSummary displayName(@javax.annotation.Nullable String displayName) {
    
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(@javax.annotation.Nullable String displayName) {
    this.displayName = displayName;
  }

  public IAMUserControllerApiUserSummary tenants(@javax.annotation.Nullable List<IAMUserControllerApiTenant> tenants) {
    
    this.tenants = tenants;
    return this;
  }

  public IAMUserControllerApiUserSummary addTenantsItem(IAMUserControllerApiTenant tenantsItem) {
    if (this.tenants == null) {
      this.tenants = new ArrayList<>();
    }
    this.tenants.add(tenantsItem);
    return this;
  }

  /**
   * Get tenants
   * @return tenants
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<IAMUserControllerApiTenant> getTenants() {
    return tenants;
  }


  @JsonProperty(JSON_PROPERTY_TENANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenants(@javax.annotation.Nullable List<IAMUserControllerApiTenant> tenants) {
    this.tenants = tenants;
  }

  public IAMUserControllerApiUserSummary auths(@javax.annotation.Nullable List<IAMUserControllerApiUserAuth> auths) {
    
    this.auths = auths;
    return this;
  }

  public IAMUserControllerApiUserSummary addAuthsItem(IAMUserControllerApiUserAuth authsItem) {
    if (this.auths == null) {
      this.auths = new ArrayList<>();
    }
    this.auths.add(authsItem);
    return this;
  }

  /**
   * Get auths
   * @return auths
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AUTHS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<IAMUserControllerApiUserAuth> getAuths() {
    return auths;
  }


  @JsonProperty(JSON_PROPERTY_AUTHS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAuths(@javax.annotation.Nullable List<IAMUserControllerApiUserAuth> auths) {
    this.auths = auths;
  }

  public IAMUserControllerApiUserSummary superAdmin(@javax.annotation.Nullable Boolean superAdmin) {
    
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IAMUserControllerApiUserSummary iaMUserControllerApiUserSummary = (IAMUserControllerApiUserSummary) o;
    return Objects.equals(this.id, iaMUserControllerApiUserSummary.id) &&
        Objects.equals(this.username, iaMUserControllerApiUserSummary.username) &&
        Objects.equals(this.displayName, iaMUserControllerApiUserSummary.displayName) &&
        Objects.equals(this.tenants, iaMUserControllerApiUserSummary.tenants) &&
        Objects.equals(this.auths, iaMUserControllerApiUserSummary.auths) &&
        Objects.equals(this.superAdmin, iaMUserControllerApiUserSummary.superAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, displayName, tenants, auths, superAdmin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IAMUserControllerApiUserSummary {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    tenants: ").append(toIndentedString(tenants)).append("\n");
    sb.append("    auths: ").append(toIndentedString(auths)).append("\n");
    sb.append("    superAdmin: ").append(toIndentedString(superAdmin)).append("\n");
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

    // add `username` to the URL query string
    if (getUsername() != null) {
      try {
        joiner.add(String.format("%susername%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getUsername()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `displayName` to the URL query string
    if (getDisplayName() != null) {
      try {
        joiner.add(String.format("%sdisplayName%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDisplayName()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `tenants` to the URL query string
    if (getTenants() != null) {
      for (int i = 0; i < getTenants().size(); i++) {
        if (getTenants().get(i) != null) {
          joiner.add(getTenants().get(i).toUrlQueryString(String.format("%stenants%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `auths` to the URL query string
    if (getAuths() != null) {
      for (int i = 0; i < getAuths().size(); i++) {
        if (getAuths().get(i) != null) {
          joiner.add(getAuths().get(i).toUrlQueryString(String.format("%sauths%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
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

    return joiner.toString();
  }

}

