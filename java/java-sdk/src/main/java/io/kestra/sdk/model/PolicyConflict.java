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
 * PolicyConflict
 */
@JsonPropertyOrder({
  PolicyConflict.JSON_PROPERTY_TARGET,
  PolicyConflict.JSON_PROPERTY_ADD_POLICY_ID,
  PolicyConflict.JSON_PROPERTY_ADD_SCOPE,
  PolicyConflict.JSON_PROPERTY_DELETE_POLICY_ID,
  PolicyConflict.JSON_PROPERTY_DELETE_SCOPE
})
public class PolicyConflict {
  public static final String JSON_PROPERTY_TARGET = "target";
  @Nullable  private String target;

  public static final String JSON_PROPERTY_ADD_POLICY_ID = "addPolicyId";
  @Nullable  private String addPolicyId;

  public static final String JSON_PROPERTY_ADD_SCOPE = "addScope";
  @Nullable  private Scope addScope;

  public static final String JSON_PROPERTY_DELETE_POLICY_ID = "deletePolicyId";
  @Nullable  private String deletePolicyId;

  public static final String JSON_PROPERTY_DELETE_SCOPE = "deleteScope";
  @Nullable  private Scope deleteScope;

  public PolicyConflict() {
  }

  public PolicyConflict target(@Nullable String target) {
    
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTarget() {
    return target;
  }


  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(@Nullable String target) {
    this.target = target;
  }

  public PolicyConflict addPolicyId(@Nullable String addPolicyId) {
    
    this.addPolicyId = addPolicyId;
    return this;
  }

  /**
   * Get addPolicyId
   * @return addPolicyId
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ADD_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAddPolicyId() {
    return addPolicyId;
  }


  @JsonProperty(JSON_PROPERTY_ADD_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddPolicyId(@Nullable String addPolicyId) {
    this.addPolicyId = addPolicyId;
  }

  public PolicyConflict addScope(@Nullable Scope addScope) {
    
    this.addScope = addScope;
    return this;
  }

  /**
   * Get addScope
   * @return addScope
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ADD_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getAddScope() {
    return addScope;
  }


  @JsonProperty(JSON_PROPERTY_ADD_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddScope(@Nullable Scope addScope) {
    this.addScope = addScope;
  }

  public PolicyConflict deletePolicyId(@Nullable String deletePolicyId) {
    
    this.deletePolicyId = deletePolicyId;
    return this;
  }

  /**
   * Get deletePolicyId
   * @return deletePolicyId
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_DELETE_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDeletePolicyId() {
    return deletePolicyId;
  }


  @JsonProperty(JSON_PROPERTY_DELETE_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeletePolicyId(@Nullable String deletePolicyId) {
    this.deletePolicyId = deletePolicyId;
  }

  public PolicyConflict deleteScope(@Nullable Scope deleteScope) {
    
    this.deleteScope = deleteScope;
    return this;
  }

  /**
   * Get deleteScope
   * @return deleteScope
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_DELETE_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getDeleteScope() {
    return deleteScope;
  }


  @JsonProperty(JSON_PROPERTY_DELETE_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeleteScope(@Nullable Scope deleteScope) {
    this.deleteScope = deleteScope;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyConflict policyConflict = (PolicyConflict) o;
    return Objects.equals(this.target, policyConflict.target) &&
        Objects.equals(this.addPolicyId, policyConflict.addPolicyId) &&
        Objects.equals(this.addScope, policyConflict.addScope) &&
        Objects.equals(this.deletePolicyId, policyConflict.deletePolicyId) &&
        Objects.equals(this.deleteScope, policyConflict.deleteScope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(target, addPolicyId, addScope, deletePolicyId, deleteScope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyConflict {\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    addPolicyId: ").append(toIndentedString(addPolicyId)).append("\n");
    sb.append("    addScope: ").append(toIndentedString(addScope)).append("\n");
    sb.append("    deletePolicyId: ").append(toIndentedString(deletePolicyId)).append("\n");
    sb.append("    deleteScope: ").append(toIndentedString(deleteScope)).append("\n");
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
