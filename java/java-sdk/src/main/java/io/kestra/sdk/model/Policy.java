/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Policy
 */
@JsonPropertyOrder({
  Policy.JSON_PROPERTY_ID,
  Policy.JSON_PROPERTY_DISPLAY_NAME,
  Policy.JSON_PROPERTY_DESCRIPTION,
  Policy.JSON_PROPERTY_ENFORCEMENT,
  Policy.JSON_PROPERTY_TARGET,
  Policy.JSON_PROPERTY_RULES,
  Policy.JSON_PROPERTY_SOURCE,
  Policy.JSON_PROPERTY_DELETED
})
public class Policy {
  public static final String JSON_PROPERTY_ID = "id";
  @Nonnull  private String id;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @Nullable  private String displayName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @Nullable  private String description;

  public static final String JSON_PROPERTY_ENFORCEMENT = "enforcement";
  @Nonnull  private Enforcement enforcement;

  public static final String JSON_PROPERTY_TARGET = "target";
  @Nullable  private PolicyTarget target;

  public static final String JSON_PROPERTY_RULES = "rules";
  @Nonnull  private List<Rule> rules = new ArrayList<>();

  public static final String JSON_PROPERTY_SOURCE = "source";
  @Nullable  private String source;

  public static final String JSON_PROPERTY_DELETED = "deleted";
  @Nonnull  private Boolean deleted;

  public Policy() {
  }

  public Policy id(@Nonnull String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@Nonnull String id) {
    this.id = id;
  }

  public Policy displayName(@Nullable String displayName) {
    
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

  public Policy description(@Nullable String description) {
    
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

  public Policy enforcement(@Nonnull Enforcement enforcement) {
    
    this.enforcement = enforcement;
    return this;
  }

  /**
   * Get enforcement
   * @return enforcement
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_ENFORCEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Enforcement getEnforcement() {
    return enforcement;
  }


  @JsonProperty(JSON_PROPERTY_ENFORCEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnforcement(@Nonnull Enforcement enforcement) {
    this.enforcement = enforcement;
  }

  public Policy target(@Nullable PolicyTarget target) {
    
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

  public Policy rules(@Nonnull List<Rule> rules) {
    
    this.rules = rules;
    return this;
  }

  public Policy addRulesItem(Rule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<>();
    }
    this.rules.add(rulesItem);
    return this;
  }

  /**
   * Get rules
   * @return rules
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_RULES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Rule> getRules() {
    return rules;
  }


  @JsonProperty(JSON_PROPERTY_RULES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRules(@Nonnull List<Rule> rules) {
    this.rules = rules;
  }

  public Policy source(@Nullable String source) {
    
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSource() {
    return source;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(@Nullable String source) {
    this.source = source;
  }

  public Policy deleted(@Nonnull Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }

  /**
   * Get deleted
   * @return deleted
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_DELETED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDeleted() {
    return deleted;
  }


  @JsonProperty(JSON_PROPERTY_DELETED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeleted(@Nonnull Boolean deleted) {
    this.deleted = deleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Policy policy = (Policy) o;
    return Objects.equals(this.id, policy.id) &&
        Objects.equals(this.displayName, policy.displayName) &&
        Objects.equals(this.description, policy.description) &&
        Objects.equals(this.enforcement, policy.enforcement) &&
        Objects.equals(this.target, policy.target) &&
        Objects.equals(this.rules, policy.rules) &&
        Objects.equals(this.source, policy.source) &&
        Objects.equals(this.deleted, policy.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, description, enforcement, target, rules, source, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Policy {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enforcement: ").append(toIndentedString(enforcement)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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
