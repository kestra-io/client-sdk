/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * 
 *
 */


package io.kestra.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets UserType
 */
public enum UserType {
  
  STANDARD("STANDARD"),
  
  SERVICE_ACCOUNT("SERVICE_ACCOUNT"),
  
  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  UserType(String value) {
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
  public static UserType fromValue(String value) {
    for (UserType b : UserType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}

