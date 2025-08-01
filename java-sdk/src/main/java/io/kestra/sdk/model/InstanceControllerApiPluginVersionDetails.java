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
import io.kestra.sdk.model.InstanceControllerApiPluginVersionDetailsApiPluginClasses;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * InstanceControllerApiPluginVersionDetails
 */
@JsonPropertyOrder({
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_ARTIFACT_ID,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_GROUP_ID,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_VERSION,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_TITLE,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_DESCRIPTION,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_ICON,
  InstanceControllerApiPluginVersionDetails.JSON_PROPERTY_CLASSES
})
@JsonTypeName("InstanceController.ApiPluginVersionDetails")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class InstanceControllerApiPluginVersionDetails {
  public static final String JSON_PROPERTY_ARTIFACT_ID = "artifactId";
  @javax.annotation.Nullable
  private String artifactId;

  public static final String JSON_PROPERTY_GROUP_ID = "groupId";
  @javax.annotation.Nullable
  private String groupId;

  public static final String JSON_PROPERTY_VERSION = "version";
  @javax.annotation.Nullable
  private String version;

  public static final String JSON_PROPERTY_TITLE = "title";
  @javax.annotation.Nullable
  private String title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nullable
  private String description;

  public static final String JSON_PROPERTY_ICON = "icon";
  @javax.annotation.Nullable
  private String icon;

  public static final String JSON_PROPERTY_CLASSES = "classes";
  @javax.annotation.Nullable
  private List<InstanceControllerApiPluginVersionDetailsApiPluginClasses> classes = new ArrayList<>();

  public InstanceControllerApiPluginVersionDetails() {
  }

  public InstanceControllerApiPluginVersionDetails artifactId(@javax.annotation.Nullable String artifactId) {
    
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

  public InstanceControllerApiPluginVersionDetails groupId(@javax.annotation.Nullable String groupId) {
    
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

  public InstanceControllerApiPluginVersionDetails version(@javax.annotation.Nullable String version) {
    
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVersion() {
    return version;
  }


  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(@javax.annotation.Nullable String version) {
    this.version = version;
  }

  public InstanceControllerApiPluginVersionDetails title(@javax.annotation.Nullable String title) {
    
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

  public InstanceControllerApiPluginVersionDetails description(@javax.annotation.Nullable String description) {
    
    this.description = description;
    return this;
  }

  /**
   * Get description
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

  public InstanceControllerApiPluginVersionDetails icon(@javax.annotation.Nullable String icon) {
    
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

  public InstanceControllerApiPluginVersionDetails classes(@javax.annotation.Nullable List<InstanceControllerApiPluginVersionDetailsApiPluginClasses> classes) {
    
    this.classes = classes;
    return this;
  }

  public InstanceControllerApiPluginVersionDetails addClassesItem(InstanceControllerApiPluginVersionDetailsApiPluginClasses classesItem) {
    if (this.classes == null) {
      this.classes = new ArrayList<>();
    }
    this.classes.add(classesItem);
    return this;
  }

  /**
   * Get classes
   * @return classes
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CLASSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<InstanceControllerApiPluginVersionDetailsApiPluginClasses> getClasses() {
    return classes;
  }


  @JsonProperty(JSON_PROPERTY_CLASSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClasses(@javax.annotation.Nullable List<InstanceControllerApiPluginVersionDetailsApiPluginClasses> classes) {
    this.classes = classes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceControllerApiPluginVersionDetails instanceControllerApiPluginVersionDetails = (InstanceControllerApiPluginVersionDetails) o;
    return Objects.equals(this.artifactId, instanceControllerApiPluginVersionDetails.artifactId) &&
        Objects.equals(this.groupId, instanceControllerApiPluginVersionDetails.groupId) &&
        Objects.equals(this.version, instanceControllerApiPluginVersionDetails.version) &&
        Objects.equals(this.title, instanceControllerApiPluginVersionDetails.title) &&
        Objects.equals(this.description, instanceControllerApiPluginVersionDetails.description) &&
        Objects.equals(this.icon, instanceControllerApiPluginVersionDetails.icon) &&
        Objects.equals(this.classes, instanceControllerApiPluginVersionDetails.classes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artifactId, groupId, version, title, description, icon, classes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceControllerApiPluginVersionDetails {\n");
    sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    classes: ").append(toIndentedString(classes)).append("\n");
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

    // add `artifactId` to the URL query string
    if (getArtifactId() != null) {
      try {
        joiner.add(String.format("%sartifactId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getArtifactId()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `version` to the URL query string
    if (getVersion() != null) {
      try {
        joiner.add(String.format("%sversion%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getVersion()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `title` to the URL query string
    if (getTitle() != null) {
      try {
        joiner.add(String.format("%stitle%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTitle()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `icon` to the URL query string
    if (getIcon() != null) {
      try {
        joiner.add(String.format("%sicon%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIcon()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `classes` to the URL query string
    if (getClasses() != null) {
      for (int i = 0; i < getClasses().size(); i++) {
        if (getClasses().get(i) != null) {
          joiner.add(getClasses().get(i).toUrlQueryString(String.format("%sclasses%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

