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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * AuthControllerResetPasswordRequest
 */
@JsonPropertyOrder({
  AuthControllerResetPasswordRequest.JSON_PROPERTY_TOKEN,
  AuthControllerResetPasswordRequest.JSON_PROPERTY_PASSWORD
})
@JsonTypeName("AuthController.ResetPasswordRequest")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class AuthControllerResetPasswordRequest {
  public static final String JSON_PROPERTY_TOKEN = "token";
  @javax.annotation.Nonnull
  private String token;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @javax.annotation.Nonnull
  private String password;

  public AuthControllerResetPasswordRequest() {
  }

  public AuthControllerResetPasswordRequest token(@javax.annotation.Nonnull String token) {

    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getToken() {
    return token;
  }


  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToken(@javax.annotation.Nonnull String token) {
    this.token = token;
  }

  public AuthControllerResetPasswordRequest password(@javax.annotation.Nonnull String password) {

    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPassword() {
    return password;
  }


  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPassword(@javax.annotation.Nonnull String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthControllerResetPasswordRequest authControllerResetPasswordRequest = (AuthControllerResetPasswordRequest) o;
    return Objects.equals(this.token, authControllerResetPasswordRequest.token) &&
        Objects.equals(this.password, authControllerResetPasswordRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthControllerResetPasswordRequest {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

    // add `token` to the URL query string
    if (getToken() != null) {
      try {
        joiner.add(String.format("%stoken%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getToken()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `password` to the URL query string
    if (getPassword() != null) {
      try {
        joiner.add(String.format("%spassword%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getPassword()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

