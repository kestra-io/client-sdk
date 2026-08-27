/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nullable;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PolicyTarget
 */
@JsonPropertyOrder({
  PolicyTarget.JSON_PROPERTY_TENANTS,
  PolicyTarget.JSON_PROPERTY_NAMESPACES
})
public class PolicyTarget {
  public static final String JSON_PROPERTY_TENANTS = "tenants";
  @Nullable  private List<String> tenants = new ArrayList<>();

  public static final String JSON_PROPERTY_NAMESPACES = "namespaces";
  @Nullable  private List<String> namespaces = new ArrayList<>();

  public PolicyTarget() {
  }

  public PolicyTarget tenants(@Nullable List<String> tenants) {
    
    this.tenants = tenants;
    return this;
  }

  public PolicyTarget addTenantsItem(String tenantsItem) {
    if (this.tenants == null) {
      this.tenants = new ArrayList<>();
    }
    this.tenants.add(tenantsItem);
    return this;
  }

  /**
   * Get tenants
   * @return tenants
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_TENANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTenants() {
    return tenants;
  }


  @JsonProperty(JSON_PROPERTY_TENANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenants(@Nullable List<String> tenants) {
    this.tenants = tenants;
  }

  public PolicyTarget namespaces(@Nullable List<String> namespaces) {
    
    this.namespaces = namespaces;
    return this;
  }

  public PolicyTarget addNamespacesItem(String namespacesItem) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList<>();
    }
    this.namespaces.add(namespacesItem);
    return this;
  }

  /**
   * Get namespaces
   * @return namespaces
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_NAMESPACES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getNamespaces() {
    return namespaces;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaces(@Nullable List<String> namespaces) {
    this.namespaces = namespaces;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyTarget policyTarget = (PolicyTarget) o;
    return Objects.equals(this.tenants, policyTarget.tenants) &&
        Objects.equals(this.namespaces, policyTarget.namespaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenants, namespaces);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyTarget {\n");
    sb.append("    tenants: ").append(toIndentedString(tenants)).append("\n");
    sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
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
