/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AbstractFilterFilterType
 */
public enum AbstractFilterFilterType {
  
  CONTAINS("CONTAINS"),
  
  ENDS_WITH("ENDS_WITH"),
  
  EQUAL_TO("EQUAL_TO"),
  
  GREATER_THAN("GREATER_THAN"),
  
  GREATER_THAN_OR_EQUAL_TO("GREATER_THAN_OR_EQUAL_TO"),
  
  IN("IN"),
  
  IS_FALSE("IS_FALSE"),
  
  IS_NOT_NULL("IS_NOT_NULL"),
  
  IS_NULL("IS_NULL"),
  
  IS_TRUE("IS_TRUE"),
  
  LESS_THAN("LESS_THAN"),
  
  LESS_THAN_OR_EQUAL_TO("LESS_THAN_OR_EQUAL_TO"),
  
  NOT_CONTAINS("NOT_CONTAINS"),
  
  NOT_EQUAL_TO("NOT_EQUAL_TO"),
  
  NOT_IN("NOT_IN"),
  
  OR("OR"),
  
  REGEX("REGEX"),
  
  STARTS_WITH("STARTS_WITH"),
  
  PREFIX("PREFIX"),
  
  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  AbstractFilterFilterType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AbstractFilterFilterType fromValue(String value) {
    for (AbstractFilterFilterType b : AbstractFilterFilterType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
