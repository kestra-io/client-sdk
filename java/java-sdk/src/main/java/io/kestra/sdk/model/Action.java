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
 * Gets or Sets Action
 */
public enum Action {
  
  VIEW("VIEW"),
  
  LIST("LIST"),
  
  CREATE("CREATE"),
  
  UPDATE("UPDATE"),
  
  DELETE("DELETE"),
  
  EXECUTE("EXECUTE"),
  
  RESTART("RESTART"),
  
  KILL("KILL"),
  
  REPLAY("REPLAY"),
  
  PAUSE("PAUSE"),
  
  RESUME("RESUME"),
  
  UNQUEUE("UNQUEUE"),
  
  FORCE_RUN("FORCE_RUN"),
  
  FOLLOW("FOLLOW"),
  
  TEMPLATE("TEMPLATE"),
  
  CHANGE_LABELS("CHANGE_LABELS"),
  
  ACCESS_LOGS("ACCESS_LOGS"),
  
  ACCESS_OUTPUTS("ACCESS_OUTPUTS"),
  
  ACCESS_FILES("ACCESS_FILES"),
  
  EXPORT("EXPORT"),
  
  IMPORT("IMPORT"),
  
  DISABLE("DISABLE"),
  
  ENABLE("ENABLE"),
  
  VALIDATE("VALIDATE"),
  
  UNLOCK("UNLOCK"),
  
  LOCK("LOCK"),
  
  BACKFILL("BACKFILL"),
  
  PROMOTE("PROMOTE"),
  
  MANAGE_FILES("MANAGE_FILES"),
  
  MANAGE_MEMBERS("MANAGE_MEMBERS"),
  
  MANAGE_GROUP_MEMBERSHIP("MANAGE_GROUP_MEMBERSHIP"),
  
  USE("USE"),
  
  IMPERSONATE("IMPERSONATE"),
  
  READ("READ"),
  
  UNKNOWN("UNKNOWN"),
  
  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  Action(String value) {
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
  public static Action fromValue(String value) {
    for (Action b : Action.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}

