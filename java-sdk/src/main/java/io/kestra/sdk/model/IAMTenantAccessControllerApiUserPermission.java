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
import io.kestra.sdk.model.Action;
import io.kestra.sdk.model.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * IAMTenantAccessControllerApiUserPermission
 */
@JsonPropertyOrder({
  IAMTenantAccessControllerApiUserPermission.JSON_PROPERTY_PERMISSION,
  IAMTenantAccessControllerApiUserPermission.JSON_PROPERTY_ACTIONS
})
@JsonTypeName("IAMTenantAccessController.ApiUserPermission")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class IAMTenantAccessControllerApiUserPermission {
  public static final String JSON_PROPERTY_PERMISSION = "permission";
  @javax.annotation.Nullable
  private Permission permission;

  public static final String JSON_PROPERTY_ACTIONS = "actions";
  @javax.annotation.Nullable
  private List<Action> actions = new ArrayList<>();

  public IAMTenantAccessControllerApiUserPermission() {
  }

  public IAMTenantAccessControllerApiUserPermission permission(@javax.annotation.Nullable Permission permission) {
    
    this.permission = permission;
    return this;
  }

  /**
   * Get permission
   * @return permission
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERMISSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Permission getPermission() {
    return permission;
  }


  @JsonProperty(JSON_PROPERTY_PERMISSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPermission(@javax.annotation.Nullable Permission permission) {
    this.permission = permission;
  }

  public IAMTenantAccessControllerApiUserPermission actions(@javax.annotation.Nullable List<Action> actions) {
    
    this.actions = actions;
    return this;
  }

  public IAMTenantAccessControllerApiUserPermission addActionsItem(Action actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<>();
    }
    this.actions.add(actionsItem);
    return this;
  }

  /**
   * Get actions
   * @return actions
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Action> getActions() {
    return actions;
  }


  @JsonProperty(JSON_PROPERTY_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActions(@javax.annotation.Nullable List<Action> actions) {
    this.actions = actions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IAMTenantAccessControllerApiUserPermission iaMTenantAccessControllerApiUserPermission = (IAMTenantAccessControllerApiUserPermission) o;
    return Objects.equals(this.permission, iaMTenantAccessControllerApiUserPermission.permission) &&
        Objects.equals(this.actions, iaMTenantAccessControllerApiUserPermission.actions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permission, actions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IAMTenantAccessControllerApiUserPermission {\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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

    // add `permission` to the URL query string
    if (getPermission() != null) {
      try {
        joiner.add(String.format("%spermission%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getPermission()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `actions` to the URL query string
    if (getActions() != null) {
      for (int i = 0; i < getActions().size(); i++) {
        if (getActions().get(i) != null) {
          try {
            joiner.add(String.format("%sactions%s%s=%s", prefix, suffix,
                "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
                URLEncoder.encode(String.valueOf(getActions().get(i)), "UTF-8").replaceAll("\\+", "%20")));
          } catch (UnsupportedEncodingException e) {
            // Should never happen, UTF-8 is always supported
            throw new RuntimeException(e);
          }
        }
      }
    }

    return joiner.toString();
  }

}

