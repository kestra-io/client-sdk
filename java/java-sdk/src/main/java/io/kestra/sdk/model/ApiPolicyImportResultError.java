/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nullable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ApiPolicyImportResultError
 */
@JsonPropertyOrder({
  ApiPolicyImportResultError.JSON_PROPERTY_DOCUMENT,
  ApiPolicyImportResultError.JSON_PROPERTY_MESSAGE
})
public class ApiPolicyImportResultError {
  public static final String JSON_PROPERTY_DOCUMENT = "document";
  @Nullable  private String document;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @Nullable  private String message;

  public ApiPolicyImportResultError() {
  }

  public ApiPolicyImportResultError document(@Nullable String document) {
    
    this.document = document;
    return this;
  }

  /**
   * Get document
   * @return document
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDocument() {
    return document;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDocument(@Nullable String document) {
    this.document = document;
  }

  public ApiPolicyImportResultError message(@Nullable String message) {
    
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(@Nullable String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiPolicyImportResultError apiPolicyImportResultError = (ApiPolicyImportResultError) o;
    return Objects.equals(this.document, apiPolicyImportResultError.document) &&
        Objects.equals(this.message, apiPolicyImportResultError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(document, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPolicyImportResultError {\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

}
