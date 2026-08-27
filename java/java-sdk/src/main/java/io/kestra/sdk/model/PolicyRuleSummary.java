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
 * PolicyRuleSummary
 */
@JsonPropertyOrder({
  PolicyRuleSummary.JSON_PROPERTY_MUTATE,
  PolicyRuleSummary.JSON_PROPERTY_VALIDATE
})
public class PolicyRuleSummary {
  public static final String JSON_PROPERTY_MUTATE = "mutate";
  @Nullable  private Integer mutate;

  public static final String JSON_PROPERTY_VALIDATE = "validate";
  @Nullable  private Integer validate;

  public PolicyRuleSummary() {
  }

  public PolicyRuleSummary mutate(@Nullable Integer mutate) {
    
    this.mutate = mutate;
    return this;
  }

  /**
   * Get mutate
   * @return mutate
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_MUTATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMutate() {
    return mutate;
  }


  @JsonProperty(JSON_PROPERTY_MUTATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMutate(@Nullable Integer mutate) {
    this.mutate = mutate;
  }

  public PolicyRuleSummary validate(@Nullable Integer validate) {
    
    this.validate = validate;
    return this;
  }

  /**
   * Get validate
   * @return validate
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_VALIDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getValidate() {
    return validate;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidate(@Nullable Integer validate) {
    this.validate = validate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyRuleSummary policyRuleSummary = (PolicyRuleSummary) o;
    return Objects.equals(this.mutate, policyRuleSummary.mutate) &&
        Objects.equals(this.validate, policyRuleSummary.validate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mutate, validate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyRuleSummary {\n");
    sb.append("    mutate: ").append(toIndentedString(mutate)).append("\n");
    sb.append("    validate: ").append(toIndentedString(validate)).append("\n");
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
