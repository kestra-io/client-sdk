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
 * PolicyMutation
 */
@JsonPropertyOrder({
  PolicyMutation.JSON_PROPERTY_ACTION,
  PolicyMutation.JSON_PROPERTY_TARGET,
  PolicyMutation.JSON_PROPERTY_VALUE,
  PolicyMutation.JSON_PROPERTY_PREVIOUS_VALUE,
  PolicyMutation.JSON_PROPERTY_POLICY_ID,
  PolicyMutation.JSON_PROPERTY_SCOPE
})
public class PolicyMutation {
  public static final String JSON_PROPERTY_ACTION = "action";
  @Nullable  private ApiPolicyMutationAction action;

  public static final String JSON_PROPERTY_TARGET = "target";
  @Nullable  private String target;

  public static final String JSON_PROPERTY_VALUE = "value";
  @Nullable  private Object value;

  public static final String JSON_PROPERTY_PREVIOUS_VALUE = "previousValue";
  @Nullable  private Object previousValue;

  public static final String JSON_PROPERTY_POLICY_ID = "policyId";
  @Nullable  private String policyId;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @Nullable  private Scope scope;

  public PolicyMutation() {
  }

  public PolicyMutation action(@Nullable ApiPolicyMutationAction action) {
    
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ApiPolicyMutationAction getAction() {
    return action;
  }


  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAction(@Nullable ApiPolicyMutationAction action) {
    this.action = action;
  }

  public PolicyMutation target(@Nullable String target) {
    
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

  public PolicyMutation value(@Nullable Object value) {
    
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(@Nullable Object value) {
    this.value = value;
  }

  public PolicyMutation previousValue(@Nullable Object previousValue) {
    
    this.previousValue = previousValue;
    return this;
  }

  /**
   * Get previousValue
   * @return previousValue
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_PREVIOUS_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getPreviousValue() {
    return previousValue;
  }


  @JsonProperty(JSON_PROPERTY_PREVIOUS_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPreviousValue(@Nullable Object previousValue) {
    this.previousValue = previousValue;
  }

  public PolicyMutation policyId(@Nullable String policyId) {
    
    this.policyId = policyId;
    return this;
  }

  /**
   * Get policyId
   * @return policyId
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPolicyId() {
    return policyId;
  }


  @JsonProperty(JSON_PROPERTY_POLICY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPolicyId(@Nullable String policyId) {
    this.policyId = policyId;
  }

  public PolicyMutation scope(@Nullable Scope scope) {
    
    this.scope = scope;
    return this;
  }

  /**
   * Get scope
   * @return scope
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Scope getScope() {
    return scope;
  }


  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setScope(@Nullable Scope scope) {
    this.scope = scope;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyMutation policyMutation = (PolicyMutation) o;
    return Objects.equals(this.action, policyMutation.action) &&
        Objects.equals(this.target, policyMutation.target) &&
        Objects.equals(this.value, policyMutation.value) &&
        Objects.equals(this.previousValue, policyMutation.previousValue) &&
        Objects.equals(this.policyId, policyMutation.policyId) &&
        Objects.equals(this.scope, policyMutation.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, target, value, previousValue, policyId, scope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyMutation {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    previousValue: ").append(toIndentedString(previousValue)).append("\n");
    sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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
