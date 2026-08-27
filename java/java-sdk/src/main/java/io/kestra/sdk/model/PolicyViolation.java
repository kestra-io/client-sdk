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
 * PolicyViolation
 */
@JsonPropertyOrder({
  PolicyViolation.JSON_PROPERTY_SEVERITY,
  PolicyViolation.JSON_PROPERTY_RULE_TYPE,
  PolicyViolation.JSON_PROPERTY_TARGET,
  PolicyViolation.JSON_PROPERTY_MESSAGE,
  PolicyViolation.JSON_PROPERTY_POLICY_ID,
  PolicyViolation.JSON_PROPERTY_SCOPE,
  PolicyViolation.JSON_PROPERTY_TASK_ID
})
public class PolicyViolation {
  public static final String JSON_PROPERTY_SEVERITY = "severity";
  @Nullable  private RuleAction severity;

  public static final String JSON_PROPERTY_RULE_TYPE = "ruleType";
  @Nullable  private String ruleType;

  public static final String JSON_PROPERTY_TARGET = "target";
  @Nullable  private String target;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @Nullable  private String message;

  public static final String JSON_PROPERTY_POLICY_ID = "policyId";
  @Nullable  private String policyId;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @Nullable  private Scope scope;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @Nullable  private String taskId;

  public PolicyViolation() {
  }

  public PolicyViolation severity(@Nullable RuleAction severity) {
    
    this.severity = severity;
    return this;
  }

  /**
   * Get severity
   * @return severity
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RuleAction getSeverity() {
    return severity;
  }


  @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSeverity(@Nullable RuleAction severity) {
    this.severity = severity;
  }

  public PolicyViolation ruleType(@Nullable String ruleType) {
    
    this.ruleType = ruleType;
    return this;
  }

  /**
   * Get ruleType
   * @return ruleType
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_RULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRuleType() {
    return ruleType;
  }


  @JsonProperty(JSON_PROPERTY_RULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRuleType(@Nullable String ruleType) {
    this.ruleType = ruleType;
  }

  public PolicyViolation target(@Nullable String target) {
    
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

  public PolicyViolation message(@Nullable String message) {
    
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

  public PolicyViolation policyId(@Nullable String policyId) {
    
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

  public PolicyViolation scope(@Nullable Scope scope) {
    
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

  public PolicyViolation taskId(@Nullable String taskId) {
    
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskId() {
    return taskId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskId(@Nullable String taskId) {
    this.taskId = taskId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyViolation policyViolation = (PolicyViolation) o;
    return Objects.equals(this.severity, policyViolation.severity) &&
        Objects.equals(this.ruleType, policyViolation.ruleType) &&
        Objects.equals(this.target, policyViolation.target) &&
        Objects.equals(this.message, policyViolation.message) &&
        Objects.equals(this.policyId, policyViolation.policyId) &&
        Objects.equals(this.scope, policyViolation.scope) &&
        Objects.equals(this.taskId, policyViolation.taskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(severity, ruleType, target, message, policyId, scope, taskId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyViolation {\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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
