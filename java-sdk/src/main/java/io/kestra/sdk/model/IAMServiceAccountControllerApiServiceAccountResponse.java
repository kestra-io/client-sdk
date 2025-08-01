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
import io.kestra.sdk.model.IAMServiceAccountControllerApiGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * A User Service Account.
 */
@JsonPropertyOrder({
  IAMServiceAccountControllerApiServiceAccountResponse.JSON_PROPERTY_ID,
  IAMServiceAccountControllerApiServiceAccountResponse.JSON_PROPERTY_NAME,
  IAMServiceAccountControllerApiServiceAccountResponse.JSON_PROPERTY_DESCRIPTION,
  IAMServiceAccountControllerApiServiceAccountResponse.JSON_PROPERTY_GROUPS,
  IAMServiceAccountControllerApiServiceAccountResponse.JSON_PROPERTY_SUPER_ADMIN
})
@JsonTypeName("IAMServiceAccountController.ApiServiceAccountResponse")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class IAMServiceAccountControllerApiServiceAccountResponse {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nullable
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  @javax.annotation.Nonnull
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nullable
  private String description;

  public static final String JSON_PROPERTY_GROUPS = "groups";
  @javax.annotation.Nullable
  private List<IAMServiceAccountControllerApiGroup> groups = new ArrayList<>();

  public static final String JSON_PROPERTY_SUPER_ADMIN = "superAdmin";
  @javax.annotation.Nullable
  private Boolean superAdmin;

  public IAMServiceAccountControllerApiServiceAccountResponse() {
  }

  public IAMServiceAccountControllerApiServiceAccountResponse id(@javax.annotation.Nullable String id) {
    
    this.id = id;
    return this;
  }

  /**
   * the identifier of this service account.
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

  public IAMServiceAccountControllerApiServiceAccountResponse name(@javax.annotation.Nonnull String name) {
    
    this.name = name;
    return this;
  }

  /**
   * the name of this service account.
   * @return name
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(@javax.annotation.Nonnull String name) {
    this.name = name;
  }

  public IAMServiceAccountControllerApiServiceAccountResponse description(@javax.annotation.Nullable String description) {
    
    this.description = description;
    return this;
  }

  /**
   * the description of this service account.
   * @return description
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@javax.annotation.Nullable String description) {
    this.description = description;
  }

  public IAMServiceAccountControllerApiServiceAccountResponse groups(@javax.annotation.Nullable List<IAMServiceAccountControllerApiGroup> groups) {
    
    this.groups = groups;
    return this;
  }

  public IAMServiceAccountControllerApiServiceAccountResponse addGroupsItem(IAMServiceAccountControllerApiGroup groupsItem) {
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

  public List<IAMServiceAccountControllerApiGroup> getGroups() {
    return groups;
  }


  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroups(@javax.annotation.Nullable List<IAMServiceAccountControllerApiGroup> groups) {
    this.groups = groups;
  }

  public IAMServiceAccountControllerApiServiceAccountResponse superAdmin(@javax.annotation.Nullable Boolean superAdmin) {
    
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
    IAMServiceAccountControllerApiServiceAccountResponse iaMServiceAccountControllerApiServiceAccountResponse = (IAMServiceAccountControllerApiServiceAccountResponse) o;
    return Objects.equals(this.id, iaMServiceAccountControllerApiServiceAccountResponse.id) &&
        Objects.equals(this.name, iaMServiceAccountControllerApiServiceAccountResponse.name) &&
        Objects.equals(this.description, iaMServiceAccountControllerApiServiceAccountResponse.description) &&
        Objects.equals(this.groups, iaMServiceAccountControllerApiServiceAccountResponse.groups) &&
        Objects.equals(this.superAdmin, iaMServiceAccountControllerApiServiceAccountResponse.superAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, groups, superAdmin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IAMServiceAccountControllerApiServiceAccountResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

    // add `name` to the URL query string
    if (getName() != null) {
      try {
        joiner.add(String.format("%sname%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getName()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `groups` to the URL query string
    if (getGroups() != null) {
      for (int i = 0; i < getGroups().size(); i++) {
        if (getGroups().get(i) != null) {
          joiner.add(getGroups().get(i).toUrlQueryString(String.format("%sgroups%s%s", prefix, suffix,
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

