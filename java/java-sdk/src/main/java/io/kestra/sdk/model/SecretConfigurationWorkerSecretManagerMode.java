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
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets SecretConfigurationWorkerSecretManagerMode
 */
public enum SecretConfigurationWorkerSecretManagerMode {
  
DIRECT("DIRECT"),
  
CONTROLLER("CONTROLLER"),
  
CONTROLLER_ONLY("CONTROLLER_ONLY");

  private String value;

  SecretConfigurationWorkerSecretManagerMode(String value) {
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
  public static SecretConfigurationWorkerSecretManagerMode fromValue(String value) {
    for (SecretConfigurationWorkerSecretManagerMode b : SecretConfigurationWorkerSecretManagerMode.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
