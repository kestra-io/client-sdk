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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kestra.sdk.model.AssetsControllerApiRelationGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetsControllerApiRelationSummary
 */
@JsonPropertyOrder({
  AssetsControllerApiRelationSummary.JSON_PROPERTY_GROUPS
})
@JsonTypeName("AssetsController.ApiRelationSummary")
public class AssetsControllerApiRelationSummary {
  public static final String JSON_PROPERTY_GROUPS = "groups";
  @jakarta.annotation.Nullable  private List<AssetsControllerApiRelationGroup> groups = new ArrayList<>();

  public AssetsControllerApiRelationSummary() {
  }

  public AssetsControllerApiRelationSummary groups(@jakarta.annotation.Nullable List<AssetsControllerApiRelationGroup> groups) {
    
    this.groups = groups;
    return this;
  }

  public AssetsControllerApiRelationSummary addGroupsItem(AssetsControllerApiRelationGroup groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetsControllerApiRelationGroup> getGroups() {
    return groups;
  }


  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroups(@jakarta.annotation.Nullable List<AssetsControllerApiRelationGroup> groups) {
    this.groups = groups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetsControllerApiRelationSummary assetsControllerApiRelationSummary = (AssetsControllerApiRelationSummary) o;
    return Objects.equals(this.groups, assetsControllerApiRelationSummary.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groups);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiRelationSummary {\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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
