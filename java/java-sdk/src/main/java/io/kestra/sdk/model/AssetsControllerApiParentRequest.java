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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A request to set the parent of an asset.
 */
@JsonPropertyOrder({
  AssetsControllerApiParentRequest.JSON_PROPERTY_PARENT_ID,
  AssetsControllerApiParentRequest.JSON_PROPERTY_NAMESPACE,
  AssetsControllerApiParentRequest.JSON_PROPERTY_ROLE
})
@JsonTypeName("AssetsController.ApiParentRequest")
public class AssetsControllerApiParentRequest {
  public static final String JSON_PROPERTY_PARENT_ID = "parentId";
  @jakarta.annotation.Nonnull  private String parentId;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nullable  private String role;

  public AssetsControllerApiParentRequest() {
  }

  public AssetsControllerApiParentRequest parentId(@jakarta.annotation.Nonnull String parentId) {
    
    this.parentId = parentId;
    return this;
  }

  /**
   * The id of the referenced asset.
   * @return parentId
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_PARENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getParentId() {
    return parentId;
  }


  @JsonProperty(JSON_PROPERTY_PARENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setParentId(@jakarta.annotation.Nonnull String parentId) {
    this.parentId = parentId;
  }

  public AssetsControllerApiParentRequest namespace(@jakarta.annotation.Nullable String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * The namespace of the referenced asset, informational: asset ids are unique per tenant.
   * @return namespace
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespace(@jakarta.annotation.Nullable String namespace) {
    this.namespace = namespace;
  }

  public AssetsControllerApiParentRequest role(@jakarta.annotation.Nullable String role) {
    
    this.role = role;
    return this;
  }

  /**
   * The role this asset plays in the relation, for example primary or backup.
   * @return role
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRole() {
    return role;
  }


  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRole(@jakarta.annotation.Nullable String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetsControllerApiParentRequest assetsControllerApiParentRequest = (AssetsControllerApiParentRequest) o;
    return Objects.equals(this.parentId, assetsControllerApiParentRequest.parentId) &&
        Objects.equals(this.namespace, assetsControllerApiParentRequest.namespace) &&
        Objects.equals(this.role, assetsControllerApiParentRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentId, namespace, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiParentRequest {\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
