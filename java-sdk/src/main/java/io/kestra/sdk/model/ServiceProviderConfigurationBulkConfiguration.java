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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * ServiceProviderConfigurationBulkConfiguration
 */
@JsonPropertyOrder({
  ServiceProviderConfigurationBulkConfiguration.JSON_PROPERTY_SUPPORTED,
  ServiceProviderConfigurationBulkConfiguration.JSON_PROPERTY_MAX_OPERATIONS,
  ServiceProviderConfigurationBulkConfiguration.JSON_PROPERTY_MAX_PAYLOAD_SIZE
})
@JsonTypeName("ServiceProviderConfiguration.BulkConfiguration")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class ServiceProviderConfigurationBulkConfiguration {
  public static final String JSON_PROPERTY_SUPPORTED = "supported";
  @javax.annotation.Nullable
  private Boolean supported;

  public static final String JSON_PROPERTY_MAX_OPERATIONS = "maxOperations";
  @javax.annotation.Nullable
  private Integer maxOperations;

  public static final String JSON_PROPERTY_MAX_PAYLOAD_SIZE = "maxPayloadSize";
  @javax.annotation.Nullable
  private Integer maxPayloadSize;

  public ServiceProviderConfigurationBulkConfiguration() {
  }

  public ServiceProviderConfigurationBulkConfiguration supported(@javax.annotation.Nullable Boolean supported) {
    
    this.supported = supported;
    return this;
  }

  /**
   * Get supported
   * @return supported
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSupported() {
    return supported;
  }


  @JsonProperty(JSON_PROPERTY_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupported(@javax.annotation.Nullable Boolean supported) {
    this.supported = supported;
  }

  public ServiceProviderConfigurationBulkConfiguration maxOperations(@javax.annotation.Nullable Integer maxOperations) {
    
    this.maxOperations = maxOperations;
    return this;
  }

  /**
   * Get maxOperations
   * @return maxOperations
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MAX_OPERATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxOperations() {
    return maxOperations;
  }


  @JsonProperty(JSON_PROPERTY_MAX_OPERATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxOperations(@javax.annotation.Nullable Integer maxOperations) {
    this.maxOperations = maxOperations;
  }

  public ServiceProviderConfigurationBulkConfiguration maxPayloadSize(@javax.annotation.Nullable Integer maxPayloadSize) {
    
    this.maxPayloadSize = maxPayloadSize;
    return this;
  }

  /**
   * Get maxPayloadSize
   * @return maxPayloadSize
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MAX_PAYLOAD_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxPayloadSize() {
    return maxPayloadSize;
  }


  @JsonProperty(JSON_PROPERTY_MAX_PAYLOAD_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxPayloadSize(@javax.annotation.Nullable Integer maxPayloadSize) {
    this.maxPayloadSize = maxPayloadSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceProviderConfigurationBulkConfiguration serviceProviderConfigurationBulkConfiguration = (ServiceProviderConfigurationBulkConfiguration) o;
    return Objects.equals(this.supported, serviceProviderConfigurationBulkConfiguration.supported) &&
        Objects.equals(this.maxOperations, serviceProviderConfigurationBulkConfiguration.maxOperations) &&
        Objects.equals(this.maxPayloadSize, serviceProviderConfigurationBulkConfiguration.maxPayloadSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supported, maxOperations, maxPayloadSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceProviderConfigurationBulkConfiguration {\n");
    sb.append("    supported: ").append(toIndentedString(supported)).append("\n");
    sb.append("    maxOperations: ").append(toIndentedString(maxOperations)).append("\n");
    sb.append("    maxPayloadSize: ").append(toIndentedString(maxPayloadSize)).append("\n");
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

    // add `supported` to the URL query string
    if (getSupported() != null) {
      try {
        joiner.add(String.format("%ssupported%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getSupported()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `maxOperations` to the URL query string
    if (getMaxOperations() != null) {
      try {
        joiner.add(String.format("%smaxOperations%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMaxOperations()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `maxPayloadSize` to the URL query string
    if (getMaxPayloadSize() != null) {
      try {
        joiner.add(String.format("%smaxPayloadSize%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMaxPayloadSize()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

