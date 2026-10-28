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
 * A reference to another asset of the same tenant.
 */
@JsonPropertyOrder({
  AssetRelationRef.JSON_PROPERTY_ID,
  AssetRelationRef.JSON_PROPERTY_NAMESPACE,
  AssetRelationRef.JSON_PROPERTY_ROLE
})
public class AssetRelationRef {
  public static final String JSON_PROPERTY_ID = "id";
  @jakarta.annotation.Nonnull  private String id;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nullable  private String role;

  public AssetRelationRef() {
  }

  public AssetRelationRef id(@jakarta.annotation.Nonnull String id) {
    
    this.id = id;
    return this;
  }

  /**
   * The id of the referenced asset.
   * @return id
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(@jakarta.annotation.Nonnull String id) {
    this.id = id;
  }

  public AssetRelationRef namespace(@jakarta.annotation.Nullable String namespace) {
    
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

  public AssetRelationRef role(@jakarta.annotation.Nullable String role) {
    
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
    AssetRelationRef assetRelationRef = (AssetRelationRef) o;
    return Objects.equals(this.id, assetRelationRef.id) &&
        Objects.equals(this.namespace, assetRelationRef.namespace) &&
        Objects.equals(this.role, assetRelationRef.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, namespace, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetRelationRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
