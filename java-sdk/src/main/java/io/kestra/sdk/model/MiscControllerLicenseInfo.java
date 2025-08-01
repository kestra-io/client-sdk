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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * MiscControllerLicenseInfo
 */
@JsonPropertyOrder({
  MiscControllerLicenseInfo.JSON_PROPERTY_TYPE,
  MiscControllerLicenseInfo.JSON_PROPERTY_EXPIRY,
  MiscControllerLicenseInfo.JSON_PROPERTY_EXPIRED,
  MiscControllerLicenseInfo.JSON_PROPERTY_MAX_SERVERS,
  MiscControllerLicenseInfo.JSON_PROPERTY_STANDALONE,
  MiscControllerLicenseInfo.JSON_PROPERTY_WORKER_GROUPS
})
@JsonTypeName("MiscController.LicenseInfo")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class MiscControllerLicenseInfo {
  public static final String JSON_PROPERTY_TYPE = "type";
  @javax.annotation.Nullable
  private String type;

  public static final String JSON_PROPERTY_EXPIRY = "expiry";
  @javax.annotation.Nullable
  private OffsetDateTime expiry;

  public static final String JSON_PROPERTY_EXPIRED = "expired";
  @javax.annotation.Nullable
  private Boolean expired;

  public static final String JSON_PROPERTY_MAX_SERVERS = "maxServers";
  @javax.annotation.Nullable
  private Integer maxServers;

  public static final String JSON_PROPERTY_STANDALONE = "standalone";
  @javax.annotation.Nullable
  private Boolean standalone;

  public static final String JSON_PROPERTY_WORKER_GROUPS = "workerGroups";
  @javax.annotation.Nullable
  private Boolean workerGroups;

  public MiscControllerLicenseInfo() {
  }

  public MiscControllerLicenseInfo type(@javax.annotation.Nullable String type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(@javax.annotation.Nullable String type) {
    this.type = type;
  }

  public MiscControllerLicenseInfo expiry(@javax.annotation.Nullable OffsetDateTime expiry) {
    
    this.expiry = expiry;
    return this;
  }

  /**
   * Get expiry
   * @return expiry
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getExpiry() {
    return expiry;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpiry(@javax.annotation.Nullable OffsetDateTime expiry) {
    this.expiry = expiry;
  }

  public MiscControllerLicenseInfo expired(@javax.annotation.Nullable Boolean expired) {
    
    this.expired = expired;
    return this;
  }

  /**
   * Get expired
   * @return expired
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXPIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getExpired() {
    return expired;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpired(@javax.annotation.Nullable Boolean expired) {
    this.expired = expired;
  }

  public MiscControllerLicenseInfo maxServers(@javax.annotation.Nullable Integer maxServers) {
    
    this.maxServers = maxServers;
    return this;
  }

  /**
   * Get maxServers
   * @return maxServers
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MAX_SERVERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxServers() {
    return maxServers;
  }


  @JsonProperty(JSON_PROPERTY_MAX_SERVERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxServers(@javax.annotation.Nullable Integer maxServers) {
    this.maxServers = maxServers;
  }

  public MiscControllerLicenseInfo standalone(@javax.annotation.Nullable Boolean standalone) {
    
    this.standalone = standalone;
    return this;
  }

  /**
   * Get standalone
   * @return standalone
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STANDALONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getStandalone() {
    return standalone;
  }


  @JsonProperty(JSON_PROPERTY_STANDALONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStandalone(@javax.annotation.Nullable Boolean standalone) {
    this.standalone = standalone;
  }

  public MiscControllerLicenseInfo workerGroups(@javax.annotation.Nullable Boolean workerGroups) {
    
    this.workerGroups = workerGroups;
    return this;
  }

  /**
   * Get workerGroups
   * @return workerGroups
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_WORKER_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getWorkerGroups() {
    return workerGroups;
  }


  @JsonProperty(JSON_PROPERTY_WORKER_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWorkerGroups(@javax.annotation.Nullable Boolean workerGroups) {
    this.workerGroups = workerGroups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MiscControllerLicenseInfo miscControllerLicenseInfo = (MiscControllerLicenseInfo) o;
    return Objects.equals(this.type, miscControllerLicenseInfo.type) &&
        Objects.equals(this.expiry, miscControllerLicenseInfo.expiry) &&
        Objects.equals(this.expired, miscControllerLicenseInfo.expired) &&
        Objects.equals(this.maxServers, miscControllerLicenseInfo.maxServers) &&
        Objects.equals(this.standalone, miscControllerLicenseInfo.standalone) &&
        Objects.equals(this.workerGroups, miscControllerLicenseInfo.workerGroups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, expiry, expired, maxServers, standalone, workerGroups);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MiscControllerLicenseInfo {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    maxServers: ").append(toIndentedString(maxServers)).append("\n");
    sb.append("    standalone: ").append(toIndentedString(standalone)).append("\n");
    sb.append("    workerGroups: ").append(toIndentedString(workerGroups)).append("\n");
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

    // add `type` to the URL query string
    if (getType() != null) {
      try {
        joiner.add(String.format("%stype%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `expiry` to the URL query string
    if (getExpiry() != null) {
      try {
        joiner.add(String.format("%sexpiry%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExpiry()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `expired` to the URL query string
    if (getExpired() != null) {
      try {
        joiner.add(String.format("%sexpired%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExpired()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `maxServers` to the URL query string
    if (getMaxServers() != null) {
      try {
        joiner.add(String.format("%smaxServers%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMaxServers()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `standalone` to the URL query string
    if (getStandalone() != null) {
      try {
        joiner.add(String.format("%sstandalone%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStandalone()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `workerGroups` to the URL query string
    if (getWorkerGroups() != null) {
      try {
        joiner.add(String.format("%sworkerGroups%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getWorkerGroups()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

