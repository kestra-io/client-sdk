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

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * A User Service Account.
 */
@JsonPropertyOrder({
  ApiServiceAccount.JSON_PROPERTY_ID,
  ApiServiceAccount.JSON_PROPERTY_NAME,
  ApiServiceAccount.JSON_PROPERTY_DESCRIPTION,
  ApiServiceAccount.JSON_PROPERTY_GROUP_LIST
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class ApiServiceAccount {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nonnull
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  @javax.annotation.Nonnull
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nonnull
  private String description;

  public static final String JSON_PROPERTY_GROUP_LIST = "groupList";
  @javax.annotation.Nonnull
  private List<AbstractUserGroupIdentifier> groupList = new ArrayList<>();

  public ApiServiceAccount() {
  }

  public ApiServiceAccount id(@javax.annotation.Nonnull String id) {

    this.id = id;
    return this;
  }

  /**
   * the identifier of this service account.
   * @return id
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(@javax.annotation.Nonnull String id) {
    this.id = id;
  }

  public ApiServiceAccount name(@javax.annotation.Nonnull String name) {

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

  public ApiServiceAccount description(@javax.annotation.Nonnull String description) {

    this.description = description;
    return this;
  }

  /**
   * the description of this service account.
   * @return description
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(@javax.annotation.Nonnull String description) {
    this.description = description;
  }

  public ApiServiceAccount groupList(@javax.annotation.Nonnull List<AbstractUserGroupIdentifier> groupList) {

    this.groupList = groupList;
    return this;
  }

  public ApiServiceAccount addGroupListItem(AbstractUserGroupIdentifier groupListItem) {
    if (this.groupList == null) {
      this.groupList = new ArrayList<>();
    }
    this.groupList.add(groupListItem);
    return this;
  }

  /**
   * Get groupList
   * @return groupList
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_GROUP_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<AbstractUserGroupIdentifier> getGroupList() {
    return groupList;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupList(@javax.annotation.Nonnull List<AbstractUserGroupIdentifier> groupList) {
    this.groupList = groupList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiServiceAccount apiServiceAccount = (ApiServiceAccount) o;
    return Objects.equals(this.id, apiServiceAccount.id) &&
        Objects.equals(this.name, apiServiceAccount.name) &&
        Objects.equals(this.description, apiServiceAccount.description) &&
        Objects.equals(this.groupList, apiServiceAccount.groupList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, groupList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiServiceAccount {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    groupList: ").append(toIndentedString(groupList)).append("\n");
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

    // add `groupList` to the URL query string
    if (getGroupList() != null) {
      for (int i = 0; i < getGroupList().size(); i++) {
        if (getGroupList().get(i) != null) {
          joiner.add(getGroupList().get(i).toUrlQueryString(String.format("%sgroupList%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

