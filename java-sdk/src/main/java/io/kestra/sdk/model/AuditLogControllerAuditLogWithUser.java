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
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.StringJoiner;

/**
 * AuditLogControllerAuditLogWithUser
 */
@JsonPropertyOrder({
  AuditLogControllerAuditLogWithUser.JSON_PROPERTY_AUDIT_LOG,
  AuditLogControllerAuditLogWithUser.JSON_PROPERTY_USER
})
@JsonTypeName("AuditLogController.AuditLogWithUser")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class AuditLogControllerAuditLogWithUser {
  public static final String JSON_PROPERTY_AUDIT_LOG = "auditLog";
  @javax.annotation.Nonnull
  private AuditLog auditLog;

  public static final String JSON_PROPERTY_USER = "user";
  @javax.annotation.Nonnull
  private ApiUser user;

  public AuditLogControllerAuditLogWithUser() {
  }

  public AuditLogControllerAuditLogWithUser auditLog(@javax.annotation.Nonnull AuditLog auditLog) {

    this.auditLog = auditLog;
    return this;
  }

  /**
   * Get auditLog
   * @return auditLog
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_AUDIT_LOG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AuditLog getAuditLog() {
    return auditLog;
  }


  @JsonProperty(JSON_PROPERTY_AUDIT_LOG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAuditLog(@javax.annotation.Nonnull AuditLog auditLog) {
    this.auditLog = auditLog;
  }

  public AuditLogControllerAuditLogWithUser user(@javax.annotation.Nonnull ApiUser user) {

    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_USER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ApiUser getUser() {
    return user;
  }


  @JsonProperty(JSON_PROPERTY_USER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUser(@javax.annotation.Nonnull ApiUser user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditLogControllerAuditLogWithUser auditLogControllerAuditLogWithUser = (AuditLogControllerAuditLogWithUser) o;
    return Objects.equals(this.auditLog, auditLogControllerAuditLogWithUser.auditLog) &&
        Objects.equals(this.user, auditLogControllerAuditLogWithUser.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(auditLog, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditLogControllerAuditLogWithUser {\n");
    sb.append("    auditLog: ").append(toIndentedString(auditLog)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

    // add `auditLog` to the URL query string
    if (getAuditLog() != null) {
      joiner.add(getAuditLog().toUrlQueryString(prefix + "auditLog" + suffix));
    }

    // add `user` to the URL query string
    if (getUser() != null) {
      joiner.add(getUser().toUrlQueryString(prefix + "user" + suffix));
    }

    return joiner.toString();
  }

}

