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
 * ApiPolicyEvaluationCounts
 */
@JsonPropertyOrder({
  ApiPolicyEvaluationCounts.JSON_PROPERTY_SCANNED,
  ApiPolicyEvaluationCounts.JSON_PROPERTY_MUTATED,
  ApiPolicyEvaluationCounts.JSON_PROPERTY_VIOLATING,
  ApiPolicyEvaluationCounts.JSON_PROPERTY_CONFLICTING
})
public class ApiPolicyEvaluationCounts {
  public static final String JSON_PROPERTY_SCANNED = "scanned";
  @Nullable  private Long scanned;

  public static final String JSON_PROPERTY_MUTATED = "mutated";
  @Nullable  private Long mutated;

  public static final String JSON_PROPERTY_VIOLATING = "violating";
  @Nullable  private Long violating;

  public static final String JSON_PROPERTY_CONFLICTING = "conflicting";
  @Nullable  private Long conflicting;

  public ApiPolicyEvaluationCounts() {
  }

  public ApiPolicyEvaluationCounts scanned(@Nullable Long scanned) {
    
    this.scanned = scanned;
    return this;
  }

  /**
   * Get scanned
   * @return scanned
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_SCANNED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getScanned() {
    return scanned;
  }


  @JsonProperty(JSON_PROPERTY_SCANNED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScanned(@Nullable Long scanned) {
    this.scanned = scanned;
  }

  public ApiPolicyEvaluationCounts mutated(@Nullable Long mutated) {
    
    this.mutated = mutated;
    return this;
  }

  /**
   * Get mutated
   * @return mutated
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_MUTATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getMutated() {
    return mutated;
  }


  @JsonProperty(JSON_PROPERTY_MUTATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMutated(@Nullable Long mutated) {
    this.mutated = mutated;
  }

  public ApiPolicyEvaluationCounts violating(@Nullable Long violating) {
    
    this.violating = violating;
    return this;
  }

  /**
   * Get violating
   * @return violating
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_VIOLATING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getViolating() {
    return violating;
  }


  @JsonProperty(JSON_PROPERTY_VIOLATING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setViolating(@Nullable Long violating) {
    this.violating = violating;
  }

  public ApiPolicyEvaluationCounts conflicting(@Nullable Long conflicting) {
    
    this.conflicting = conflicting;
    return this;
  }

  /**
   * Get conflicting
   * @return conflicting
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_CONFLICTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getConflicting() {
    return conflicting;
  }


  @JsonProperty(JSON_PROPERTY_CONFLICTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConflicting(@Nullable Long conflicting) {
    this.conflicting = conflicting;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiPolicyEvaluationCounts apiPolicyEvaluationCounts = (ApiPolicyEvaluationCounts) o;
    return Objects.equals(this.scanned, apiPolicyEvaluationCounts.scanned) &&
        Objects.equals(this.mutated, apiPolicyEvaluationCounts.mutated) &&
        Objects.equals(this.violating, apiPolicyEvaluationCounts.violating) &&
        Objects.equals(this.conflicting, apiPolicyEvaluationCounts.conflicting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scanned, mutated, violating, conflicting);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPolicyEvaluationCounts {\n");
    sb.append("    scanned: ").append(toIndentedString(scanned)).append("\n");
    sb.append("    mutated: ").append(toIndentedString(mutated)).append("\n");
    sb.append("    violating: ").append(toIndentedString(violating)).append("\n");
    sb.append("    conflicting: ").append(toIndentedString(conflicting)).append("\n");
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
