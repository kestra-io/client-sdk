/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nullable;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PolicyImportResult
 */
@JsonPropertyOrder({
  PolicyImportResult.JSON_PROPERTY_IMPORTED,
  PolicyImportResult.JSON_PROPERTY_ERRORS
})
public class PolicyImportResult {
  public static final String JSON_PROPERTY_IMPORTED = "imported";
  @Nullable  private Integer imported;

  public static final String JSON_PROPERTY_ERRORS = "errors";
  @Nullable  private List<ApiPolicyImportResultError> errors = new ArrayList<>();

  public PolicyImportResult() {
  }

  public PolicyImportResult imported(@Nullable Integer imported) {
    
    this.imported = imported;
    return this;
  }

  /**
   * Get imported
   * @return imported
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_IMPORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getImported() {
    return imported;
  }


  @JsonProperty(JSON_PROPERTY_IMPORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setImported(@Nullable Integer imported) {
    this.imported = imported;
  }

  public PolicyImportResult errors(@Nullable List<ApiPolicyImportResultError> errors) {
    
    this.errors = errors;
    return this;
  }

  public PolicyImportResult addErrorsItem(ApiPolicyImportResultError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ApiPolicyImportResultError> getErrors() {
    return errors;
  }


  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrors(@Nullable List<ApiPolicyImportResultError> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyImportResult policyImportResult = (PolicyImportResult) o;
    return Objects.equals(this.imported, policyImportResult.imported) &&
        Objects.equals(this.errors, policyImportResult.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imported, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyImportResult {\n");
    sb.append("    imported: ").append(toIndentedString(imported)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
