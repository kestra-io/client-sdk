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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * InstanceControllerApiPluginArtifact
 */
@JsonPropertyOrder({
  InstanceControllerApiPluginArtifact.JSON_PROPERTY_TITLE,
  InstanceControllerApiPluginArtifact.JSON_PROPERTY_ICON,
  InstanceControllerApiPluginArtifact.JSON_PROPERTY_GROUP_ID,
  InstanceControllerApiPluginArtifact.JSON_PROPERTY_ARTIFACT_ID,
  InstanceControllerApiPluginArtifact.JSON_PROPERTY_VERSIONS
})
@JsonTypeName("InstanceController.ApiPluginArtifact")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class InstanceControllerApiPluginArtifact {
  public static final String JSON_PROPERTY_TITLE = "title";
  @javax.annotation.Nullable
  private String title;

  public static final String JSON_PROPERTY_ICON = "icon";
  @javax.annotation.Nullable
  private String icon;

  public static final String JSON_PROPERTY_GROUP_ID = "groupId";
  @javax.annotation.Nullable
  private String groupId;

  public static final String JSON_PROPERTY_ARTIFACT_ID = "artifactId";
  @javax.annotation.Nullable
  private String artifactId;

  public static final String JSON_PROPERTY_VERSIONS = "versions";
  @javax.annotation.Nullable
  private List<String> versions = new ArrayList<>();

  public InstanceControllerApiPluginArtifact() {
  }

  public InstanceControllerApiPluginArtifact title(@javax.annotation.Nullable String title) {
    
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(@javax.annotation.Nullable String title) {
    this.title = title;
  }

  public InstanceControllerApiPluginArtifact icon(@javax.annotation.Nullable String icon) {
    
    this.icon = icon;
    return this;
  }

  /**
   * Get icon
   * @return icon
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ICON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIcon() {
    return icon;
  }


  @JsonProperty(JSON_PROPERTY_ICON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIcon(@javax.annotation.Nullable String icon) {
    this.icon = icon;
  }

  public InstanceControllerApiPluginArtifact groupId(@javax.annotation.Nullable String groupId) {
    
    this.groupId = groupId;
    return this;
  }

  /**
   * Get groupId
   * @return groupId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGroupId() {
    return groupId;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroupId(@javax.annotation.Nullable String groupId) {
    this.groupId = groupId;
  }

  public InstanceControllerApiPluginArtifact artifactId(@javax.annotation.Nullable String artifactId) {
    
    this.artifactId = artifactId;
    return this;
  }

  /**
   * Get artifactId
   * @return artifactId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARTIFACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getArtifactId() {
    return artifactId;
  }


  @JsonProperty(JSON_PROPERTY_ARTIFACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArtifactId(@javax.annotation.Nullable String artifactId) {
    this.artifactId = artifactId;
  }

  public InstanceControllerApiPluginArtifact versions(@javax.annotation.Nullable List<String> versions) {
    
    this.versions = versions;
    return this;
  }

  public InstanceControllerApiPluginArtifact addVersionsItem(String versionsItem) {
    if (this.versions == null) {
      this.versions = new ArrayList<>();
    }
    this.versions.add(versionsItem);
    return this;
  }

  /**
   * Get versions
   * @return versions
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getVersions() {
    return versions;
  }


  @JsonProperty(JSON_PROPERTY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersions(@javax.annotation.Nullable List<String> versions) {
    this.versions = versions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceControllerApiPluginArtifact instanceControllerApiPluginArtifact = (InstanceControllerApiPluginArtifact) o;
    return Objects.equals(this.title, instanceControllerApiPluginArtifact.title) &&
        Objects.equals(this.icon, instanceControllerApiPluginArtifact.icon) &&
        Objects.equals(this.groupId, instanceControllerApiPluginArtifact.groupId) &&
        Objects.equals(this.artifactId, instanceControllerApiPluginArtifact.artifactId) &&
        Objects.equals(this.versions, instanceControllerApiPluginArtifact.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, icon, groupId, artifactId, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceControllerApiPluginArtifact {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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

    // add `title` to the URL query string
    if (getTitle() != null) {
      try {
        joiner.add(String.format("%stitle%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTitle()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `icon` to the URL query string
    if (getIcon() != null) {
      try {
        joiner.add(String.format("%sicon%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIcon()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `artifactId` to the URL query string
    if (getArtifactId() != null) {
      try {
        joiner.add(String.format("%sartifactId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getArtifactId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `versions` to the URL query string
    if (getVersions() != null) {
      for (int i = 0; i < getVersions().size(); i++) {
        try {
          joiner.add(String.format("%sversions%s%s=%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
              URLEncoder.encode(String.valueOf(getVersions().get(i)), "UTF-8").replaceAll("\\+", "%20")));
        } catch (UnsupportedEncodingException e) {
          // Should never happen, UTF-8 is always supported
          throw new RuntimeException(e);
        }
      }
    }

    return joiner.toString();
  }

}

