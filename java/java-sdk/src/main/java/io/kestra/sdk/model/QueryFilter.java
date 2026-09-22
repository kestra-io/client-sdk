/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * 
 *
 */


package io.kestra.sdk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterLogical;
import io.kestra.sdk.model.QueryFilterOp;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * QueryFilter
 */
@JsonPropertyOrder({
  QueryFilter.JSON_PROPERTY_FIELD,
  QueryFilter.JSON_PROPERTY_OPERATION,
  QueryFilter.JSON_PROPERTY_VALUE,
  QueryFilter.JSON_PROPERTY_LOGICAL,
  QueryFilter.JSON_PROPERTY_CHILDREN
})
public class QueryFilter {
  public static final String JSON_PROPERTY_FIELD = "field";
  @jakarta.annotation.Nullable  private QueryFilterField field;

  public static final String JSON_PROPERTY_OPERATION = "operation";
  @jakarta.annotation.Nullable  private QueryFilterOp operation;

  public static final String JSON_PROPERTY_VALUE = "value";
  @jakarta.annotation.Nullable  private Object value;

  public static final String JSON_PROPERTY_LOGICAL = "logical";
  @jakarta.annotation.Nullable  private QueryFilterLogical logical;

  public static final String JSON_PROPERTY_CHILDREN = "children";
  @jakarta.annotation.Nullable  private List<QueryFilter> children;

  public QueryFilter() {
  }

  public QueryFilter field(@jakarta.annotation.Nullable QueryFilterField field) {
    
    this.field = field;
    return this;
  }

  /**
   * Get field
   * @return field
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public QueryFilterField getField() {
    return field;
  }


  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setField(@jakarta.annotation.Nullable QueryFilterField field) {
    this.field = field;
  }

  public QueryFilter operation(@jakarta.annotation.Nullable QueryFilterOp operation) {
    
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public QueryFilterOp getOperation() {
    return operation;
  }


  @JsonProperty(JSON_PROPERTY_OPERATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperation(@jakarta.annotation.Nullable QueryFilterOp operation) {
    this.operation = operation;
  }

  public QueryFilter value(@jakarta.annotation.Nullable Object value) {
    
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(@jakarta.annotation.Nullable Object value) {
    this.value = value;
  }

  public QueryFilter logical(@jakarta.annotation.Nullable QueryFilterLogical logical) {

    this.logical = logical;
    return this;
  }

  /**
   * Logical connector when this node is a group (AND/OR of {@code children}).
   * @return logical
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_LOGICAL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public QueryFilterLogical getLogical() {
    return logical;
  }


  @JsonProperty(JSON_PROPERTY_LOGICAL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setLogical(@jakarta.annotation.Nullable QueryFilterLogical logical) {
    this.logical = logical;
  }

  public QueryFilter children(@jakarta.annotation.Nullable List<QueryFilter> children) {

    this.children = children;
    return this;
  }

  public QueryFilter addChildrenItem(QueryFilter childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Child filters when this node is a group. A group has {@code logical} + {@code children}
   * and no {@code field}; a leaf has {@code field} + {@code operation} and no {@code children}.
   * @return children
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_CHILDREN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<QueryFilter> getChildren() {
    return children;
  }


  @JsonProperty(JSON_PROPERTY_CHILDREN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setChildren(@jakarta.annotation.Nullable List<QueryFilter> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryFilter queryFilter = (QueryFilter) o;
    return Objects.equals(this.field, queryFilter.field) &&
        Objects.equals(this.operation, queryFilter.operation) &&
        Objects.equals(this.value, queryFilter.value) &&
        Objects.equals(this.logical, queryFilter.logical) &&
        Objects.equals(this.children, queryFilter.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, operation, value, logical, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryFilter {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    logical: ").append(toIndentedString(logical)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

