/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PolicyCondition
 */
@JsonPropertyOrder({
  PolicyCondition.JSON_PROPERTY_FIELD,
  PolicyCondition.JSON_PROPERTY_OPERATOR,
  PolicyCondition.JSON_PROPERTY_VALUE
})
public class PolicyCondition {
  public static final String JSON_PROPERTY_FIELD = "field";
  @Nonnull  private String field;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  @Nonnull  private AbstractFilterFilterType operator;

  public static final String JSON_PROPERTY_VALUE = "value";
  @Nullable  private Object value;

  public PolicyCondition() {
  }

  public PolicyCondition field(@Nonnull String field) {
    
    this.field = field;
    return this;
  }

  /**
   * Get field
   * @return field
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getField() {
    return field;
  }


  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setField(@Nonnull String field) {
    this.field = field;
  }

  public PolicyCondition operator(@Nonnull AbstractFilterFilterType operator) {
    
    this.operator = operator;
    return this;
  }

  /**
   * Get operator
   * @return operator
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AbstractFilterFilterType getOperator() {
    return operator;
  }


  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperator(@Nonnull AbstractFilterFilterType operator) {
    this.operator = operator;
  }

  public PolicyCondition value(@Nullable Object value) {
    
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyCondition policyCondition = (PolicyCondition) o;
    return Objects.equals(this.field, policyCondition.field) &&
        Objects.equals(this.operator, policyCondition.operator) &&
        Objects.equals(this.value, policyCondition.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, operator, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyCondition {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
