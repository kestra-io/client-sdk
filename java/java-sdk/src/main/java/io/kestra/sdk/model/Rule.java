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
 * Rule
 */
@JsonPropertyOrder({
  Rule.JSON_PROPERTY_TYPE,
  Rule.JSON_PROPERTY_ON,
  Rule.JSON_PROPERTY_WHERE
})
public class Rule {
  public static final String JSON_PROPERTY_TYPE = "type";
  @Nonnull  private String type;

  public static final String JSON_PROPERTY_ON = "on";
  @Nullable  private RuleTarget on;

  public static final String JSON_PROPERTY_WHERE = "where";
  @Nullable  private List<Condition> where = new ArrayList<>();

  public Rule() {
  }

  public Rule type(@Nonnull String type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(@Nonnull String type) {
    this.type = type;
  }

  public Rule on(@Nullable RuleTarget on) {
    
    this.on = on;
    return this;
  }

  /**
   * Get on
   * @return on
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RuleTarget getOn() {
    return on;
  }


  @JsonProperty(JSON_PROPERTY_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOn(@Nullable RuleTarget on) {
    this.on = on;
  }

  public Rule where(@Nullable List<Condition> where) {
    
    this.where = where;
    return this;
  }

  public Rule addWhereItem(Condition whereItem) {
    if (this.where == null) {
      this.where = new ArrayList<>();
    }
    this.where.add(whereItem);
    return this;
  }

  /**
   * Get where
   * @return where
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_WHERE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Condition> getWhere() {
    return where;
  }


  @JsonProperty(JSON_PROPERTY_WHERE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWhere(@Nullable List<Condition> where) {
    this.where = where;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rule rule = (Rule) o;
    return Objects.equals(this.type, rule.type) &&
        Objects.equals(this.on, rule.on) &&
        Objects.equals(this.where, rule.where);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, on, where);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rule {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    on: ").append(toIndentedString(on)).append("\n");
    sb.append("    where: ").append(toIndentedString(where)).append("\n");
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
