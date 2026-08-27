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
 * PolicySummary
 */
@JsonPropertyOrder({
  PolicySummary.JSON_PROPERTY_ID,
  PolicySummary.JSON_PROPERTY_DISPLAY_NAME,
  PolicySummary.JSON_PROPERTY_DESCRIPTION,
  PolicySummary.JSON_PROPERTY_SCOPE,
  PolicySummary.JSON_PROPERTY_NAMESPACE,
  PolicySummary.JSON_PROPERTY_TARGET,
  PolicySummary.JSON_PROPERTY_ENFORCEMENT,
  PolicySummary.JSON_PROPERTY_RULES
})
public class PolicySummary {
  public static final String JSON_PROPERTY_ID = "id";
  @Nullable  private String id;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @Nullable  private String displayName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @Nullable  private String description;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @Nullable  private Scope scope;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @Nullable  private String namespace;

  public static final String JSON_PROPERTY_TARGET = "target";
  @Nullable  private PolicyTarget target;

  public static final String JSON_PROPERTY_ENFORCEMENT = "enforcement";
  @Nullable  private Enforcement enforcement;

  public static final String JSON_PROPERTY_RULES = "rules";
  @Nullable  private PolicyRuleSummary rules;

  public PolicySummary() {
  }

  public PolicySummary id(@Nullable String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@Nullable String id) {
    this.id = id;
  }

  public PolicySummary displayName(@Nullable String displayName) {
    
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(@Nullable String displayName) {
    this.displayName = displayName;
  }

  public PolicySummary description(@Nullable String description) {
    
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public PolicySummary scope(@Nullable Scope scope) {
    
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

  public PolicySummary namespace(@Nullable String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespace(@Nullable String namespace) {
    this.namespace = namespace;
  }

  public PolicySummary target(@Nullable PolicyTarget target) {
    
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PolicyTarget getTarget() {
    return target;
  }


  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(@Nullable PolicyTarget target) {
    this.target = target;
  }

  public PolicySummary enforcement(@Nullable Enforcement enforcement) {
    
    this.enforcement = enforcement;
    return this;
  }

  /**
   * Get enforcement
   * @return enforcement
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ENFORCEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Enforcement getEnforcement() {
    return enforcement;
  }


  @JsonProperty(JSON_PROPERTY_ENFORCEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnforcement(@Nullable Enforcement enforcement) {
    this.enforcement = enforcement;
  }

  public PolicySummary rules(@Nullable PolicyRuleSummary rules) {
    
    this.rules = rules;
    return this;
  }

  /**
   * Get rules
   * @return rules
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_RULES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PolicyRuleSummary getRules() {
    return rules;
  }


  @JsonProperty(JSON_PROPERTY_RULES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRules(@Nullable PolicyRuleSummary rules) {
    this.rules = rules;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicySummary policySummary = (PolicySummary) o;
    return Objects.equals(this.id, policySummary.id) &&
        Objects.equals(this.displayName, policySummary.displayName) &&
        Objects.equals(this.description, policySummary.description) &&
        Objects.equals(this.scope, policySummary.scope) &&
        Objects.equals(this.namespace, policySummary.namespace) &&
        Objects.equals(this.target, policySummary.target) &&
        Objects.equals(this.enforcement, policySummary.enforcement) &&
        Objects.equals(this.rules, policySummary.rules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, description, scope, namespace, target, enforcement, rules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicySummary {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    enforcement: ").append(toIndentedString(enforcement)).append("\n");
    sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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
