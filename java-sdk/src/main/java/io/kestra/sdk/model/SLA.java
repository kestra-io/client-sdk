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
import io.kestra.sdk.model.FlowWithSourceAllOfLabels;
import io.kestra.sdk.model.SLABehavior;
import io.kestra.sdk.model.SLAType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * SLA
 */
@JsonPropertyOrder({
  SLA.JSON_PROPERTY_ID,
  SLA.JSON_PROPERTY_TYPE,
  SLA.JSON_PROPERTY_BEHAVIOR,
  SLA.JSON_PROPERTY_LABELS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class SLA {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nonnull
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  @javax.annotation.Nonnull
  private SLAType type;

  public static final String JSON_PROPERTY_BEHAVIOR = "behavior";
  @javax.annotation.Nonnull
  private SLABehavior behavior;

  public static final String JSON_PROPERTY_LABELS = "labels";
  @javax.annotation.Nullable
  private FlowWithSourceAllOfLabels labels;

  public SLA() {
  }

  public SLA id(@javax.annotation.Nonnull String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
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

  public SLA type(@javax.annotation.Nonnull SLAType type) {
    
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

  public SLAType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(@javax.annotation.Nonnull SLAType type) {
    this.type = type;
  }

  public SLA behavior(@javax.annotation.Nonnull SLABehavior behavior) {
    
    this.behavior = behavior;
    return this;
  }

  /**
   * Get behavior
   * @return behavior
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BEHAVIOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SLABehavior getBehavior() {
    return behavior;
  }


  @JsonProperty(JSON_PROPERTY_BEHAVIOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBehavior(@javax.annotation.Nonnull SLABehavior behavior) {
    this.behavior = behavior;
  }

  public SLA labels(@javax.annotation.Nullable FlowWithSourceAllOfLabels labels) {
    
    this.labels = labels;
    return this;
  }

  /**
   * Get labels
   * @return labels
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FlowWithSourceAllOfLabels getLabels() {
    return labels;
  }


  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabels(@javax.annotation.Nullable FlowWithSourceAllOfLabels labels) {
    this.labels = labels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SLA SLA = (SLA) o;
    return Objects.equals(this.id, SLA.id) &&
        Objects.equals(this.type, SLA.type) &&
        Objects.equals(this.behavior, SLA.behavior) &&
        Objects.equals(this.labels, SLA.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, behavior, labels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SLA {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    behavior: ").append(toIndentedString(behavior)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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

    // add `type` to the URL query string
    if (getType() != null) {
      try {
        joiner.add(String.format("%stype%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `behavior` to the URL query string
    if (getBehavior() != null) {
      try {
        joiner.add(String.format("%sbehavior%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getBehavior()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `labels` to the URL query string
    if (getLabels() != null) {
      joiner.add(getLabels().toUrlQueryString(prefix + "labels" + suffix));
    }

    return joiner.toString();
  }

}

