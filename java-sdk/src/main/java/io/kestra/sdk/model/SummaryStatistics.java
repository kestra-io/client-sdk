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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * SummaryStatistics
 */
@JsonPropertyOrder({
  SummaryStatistics.JSON_PROPERTY_FLOWS,
  SummaryStatistics.JSON_PROPERTY_TRIGGERS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-09T14:00:04.441521653Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class SummaryStatistics {
  public static final String JSON_PROPERTY_FLOWS = "flows";
  @javax.annotation.Nonnull
  private Integer flows;

  public static final String JSON_PROPERTY_TRIGGERS = "triggers";
  @javax.annotation.Nonnull
  private Integer triggers;

  public SummaryStatistics() {
  }

  public SummaryStatistics flows(@javax.annotation.Nonnull Integer flows) {

    this.flows = flows;
    return this;
  }

  /**
   * Get flows
   * @return flows
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FLOWS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getFlows() {
    return flows;
  }


  @JsonProperty(JSON_PROPERTY_FLOWS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFlows(@javax.annotation.Nonnull Integer flows) {
    this.flows = flows;
  }

  public SummaryStatistics triggers(@javax.annotation.Nonnull Integer triggers) {

    this.triggers = triggers;
    return this;
  }

  /**
   * Get triggers
   * @return triggers
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRIGGERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getTriggers() {
    return triggers;
  }


  @JsonProperty(JSON_PROPERTY_TRIGGERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTriggers(@javax.annotation.Nonnull Integer triggers) {
    this.triggers = triggers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryStatistics summaryStatistics = (SummaryStatistics) o;
    return Objects.equals(this.flows, summaryStatistics.flows) &&
        Objects.equals(this.triggers, summaryStatistics.triggers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flows, triggers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryStatistics {\n");
    sb.append("    flows: ").append(toIndentedString(flows)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
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

    // add `flows` to the URL query string
    if (getFlows() != null) {
      try {
        joiner.add(String.format("%sflows%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFlows()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `triggers` to the URL query string
    if (getTriggers() != null) {
      try {
        joiner.add(String.format("%striggers%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTriggers()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

