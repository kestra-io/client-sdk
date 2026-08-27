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
 * PolicyPreviewResponse
 */
@JsonPropertyOrder({
  PolicyPreviewResponse.JSON_PROPERTY_RESOLVED_SOURCE,
  PolicyPreviewResponse.JSON_PROPERTY_MUTATIONS,
  PolicyPreviewResponse.JSON_PROPERTY_VIOLATIONS,
  PolicyPreviewResponse.JSON_PROPERTY_CONFLICTS
})
public class PolicyPreviewResponse {
  public static final String JSON_PROPERTY_RESOLVED_SOURCE = "resolvedSource";
  @Nullable  private String resolvedSource;

  public static final String JSON_PROPERTY_MUTATIONS = "mutations";
  @Nullable  private List<PolicyMutation> mutations = new ArrayList<>();

  public static final String JSON_PROPERTY_VIOLATIONS = "violations";
  @Nullable  private List<PolicyViolation> violations = new ArrayList<>();

  public static final String JSON_PROPERTY_CONFLICTS = "conflicts";
  @Nullable  private List<PolicyConflict> conflicts = new ArrayList<>();

  public PolicyPreviewResponse() {
  }

  public PolicyPreviewResponse resolvedSource(@Nullable String resolvedSource) {
    
    this.resolvedSource = resolvedSource;
    return this;
  }

  /**
   * Get resolvedSource
   * @return resolvedSource
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_RESOLVED_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResolvedSource() {
    return resolvedSource;
  }


  @JsonProperty(JSON_PROPERTY_RESOLVED_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResolvedSource(@Nullable String resolvedSource) {
    this.resolvedSource = resolvedSource;
  }

  public PolicyPreviewResponse mutations(@Nullable List<PolicyMutation> mutations) {
    
    this.mutations = mutations;
    return this;
  }

  public PolicyPreviewResponse addMutationsItem(PolicyMutation mutationsItem) {
    if (this.mutations == null) {
      this.mutations = new ArrayList<>();
    }
    this.mutations.add(mutationsItem);
    return this;
  }

  /**
   * Get mutations
   * @return mutations
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_MUTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PolicyMutation> getMutations() {
    return mutations;
  }


  @JsonProperty(JSON_PROPERTY_MUTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMutations(@Nullable List<PolicyMutation> mutations) {
    this.mutations = mutations;
  }

  public PolicyPreviewResponse violations(@Nullable List<PolicyViolation> violations) {
    
    this.violations = violations;
    return this;
  }

  public PolicyPreviewResponse addViolationsItem(PolicyViolation violationsItem) {
    if (this.violations == null) {
      this.violations = new ArrayList<>();
    }
    this.violations.add(violationsItem);
    return this;
  }

  /**
   * Get violations
   * @return violations
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_VIOLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PolicyViolation> getViolations() {
    return violations;
  }


  @JsonProperty(JSON_PROPERTY_VIOLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setViolations(@Nullable List<PolicyViolation> violations) {
    this.violations = violations;
  }

  public PolicyPreviewResponse conflicts(@Nullable List<PolicyConflict> conflicts) {
    
    this.conflicts = conflicts;
    return this;
  }

  public PolicyPreviewResponse addConflictsItem(PolicyConflict conflictsItem) {
    if (this.conflicts == null) {
      this.conflicts = new ArrayList<>();
    }
    this.conflicts.add(conflictsItem);
    return this;
  }

  /**
   * Get conflicts
   * @return conflicts
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_CONFLICTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PolicyConflict> getConflicts() {
    return conflicts;
  }


  @JsonProperty(JSON_PROPERTY_CONFLICTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConflicts(@Nullable List<PolicyConflict> conflicts) {
    this.conflicts = conflicts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyPreviewResponse policyPreviewResponse = (PolicyPreviewResponse) o;
    return Objects.equals(this.resolvedSource, policyPreviewResponse.resolvedSource) &&
        Objects.equals(this.mutations, policyPreviewResponse.mutations) &&
        Objects.equals(this.violations, policyPreviewResponse.violations) &&
        Objects.equals(this.conflicts, policyPreviewResponse.conflicts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resolvedSource, mutations, violations, conflicts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyPreviewResponse {\n");
    sb.append("    resolvedSource: ").append(toIndentedString(resolvedSource)).append("\n");
    sb.append("    mutations: ").append(toIndentedString(mutations)).append("\n");
    sb.append("    violations: ").append(toIndentedString(violations)).append("\n");
    sb.append("    conflicts: ").append(toIndentedString(conflicts)).append("\n");
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
