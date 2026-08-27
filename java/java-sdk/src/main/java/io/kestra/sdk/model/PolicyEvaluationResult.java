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
 * PolicyEvaluationResult
 */
@JsonPropertyOrder({
  PolicyEvaluationResult.JSON_PROPERTY_RESOURCE,
  PolicyEvaluationResult.JSON_PROPERTY_MUTATIONS,
  PolicyEvaluationResult.JSON_PROPERTY_VIOLATIONS,
  PolicyEvaluationResult.JSON_PROPERTY_CONFLICTS
})
public class PolicyEvaluationResult {
  public static final String JSON_PROPERTY_RESOURCE = "resource";
  @Nullable  private ApiPolicyEvaluationResource resource;

  public static final String JSON_PROPERTY_MUTATIONS = "mutations";
  @Nullable  private List<PolicyMutation> mutations = new ArrayList<>();

  public static final String JSON_PROPERTY_VIOLATIONS = "violations";
  @Nullable  private List<PolicyViolation> violations = new ArrayList<>();

  public static final String JSON_PROPERTY_CONFLICTS = "conflicts";
  @Nullable  private List<PolicyConflict> conflicts = new ArrayList<>();

  public PolicyEvaluationResult() {
  }

  public PolicyEvaluationResult resource(@Nullable ApiPolicyEvaluationResource resource) {
    
    this.resource = resource;
    return this;
  }

  /**
   * Get resource
   * @return resource
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ApiPolicyEvaluationResource getResource() {
    return resource;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResource(@Nullable ApiPolicyEvaluationResource resource) {
    this.resource = resource;
  }

  public PolicyEvaluationResult mutations(@Nullable List<PolicyMutation> mutations) {
    
    this.mutations = mutations;
    return this;
  }

  public PolicyEvaluationResult addMutationsItem(PolicyMutation mutationsItem) {
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

  public PolicyEvaluationResult violations(@Nullable List<PolicyViolation> violations) {
    
    this.violations = violations;
    return this;
  }

  public PolicyEvaluationResult addViolationsItem(PolicyViolation violationsItem) {
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

  public PolicyEvaluationResult conflicts(@Nullable List<PolicyConflict> conflicts) {
    
    this.conflicts = conflicts;
    return this;
  }

  public PolicyEvaluationResult addConflictsItem(PolicyConflict conflictsItem) {
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
    PolicyEvaluationResult policyEvaluationResult = (PolicyEvaluationResult) o;
    return Objects.equals(this.resource, policyEvaluationResult.resource) &&
        Objects.equals(this.mutations, policyEvaluationResult.mutations) &&
        Objects.equals(this.violations, policyEvaluationResult.violations) &&
        Objects.equals(this.conflicts, policyEvaluationResult.conflicts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, mutations, violations, conflicts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyEvaluationResult {\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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
