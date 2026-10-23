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
import io.kestra.sdk.model.RelationDirection;
import io.kestra.sdk.model.RelationKind;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetsControllerApiRelationRequest
 */
@JsonPropertyOrder({
  AssetsControllerApiRelationRequest.JSON_PROPERTY_KIND,
  AssetsControllerApiRelationRequest.JSON_PROPERTY_DIRECTION,
  AssetsControllerApiRelationRequest.JSON_PROPERTY_TARGET_ID,
  AssetsControllerApiRelationRequest.JSON_PROPERTY_TARGET_NAMESPACE,
  AssetsControllerApiRelationRequest.JSON_PROPERTY_ROLE
})
@JsonTypeName("AssetsController.ApiRelationRequest")
public class AssetsControllerApiRelationRequest {
  public static final String JSON_PROPERTY_KIND = "kind";
  @jakarta.annotation.Nonnull  private RelationKind kind;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  @jakarta.annotation.Nonnull  private RelationDirection direction;

  public static final String JSON_PROPERTY_TARGET_ID = "targetId";
  @jakarta.annotation.Nonnull  private String targetId;

  public static final String JSON_PROPERTY_TARGET_NAMESPACE = "targetNamespace";
  @jakarta.annotation.Nullable  private String targetNamespace;

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nullable  private String role;

  public AssetsControllerApiRelationRequest() {
  }

  public AssetsControllerApiRelationRequest kind(@jakarta.annotation.Nonnull RelationKind kind) {
    
    this.kind = kind;
    return this;
  }

  /**
   * The kind of relation to create.
   * @return kind
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RelationKind getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKind(@jakarta.annotation.Nonnull RelationKind kind) {
    this.kind = kind;
  }

  public AssetsControllerApiRelationRequest direction(@jakarta.annotation.Nonnull RelationDirection direction) {
    
    this.direction = direction;
    return this;
  }

  /**
   * The side the asset takes; ignored by an undirected kind.
   * @return direction
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RelationDirection getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirection(@jakarta.annotation.Nonnull RelationDirection direction) {
    this.direction = direction;
  }

  public AssetsControllerApiRelationRequest targetId(@jakarta.annotation.Nonnull String targetId) {
    
    this.targetId = targetId;
    return this;
  }

  /**
   * The id of the asset or flow at the other end.
   * @return targetId
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_TARGET_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTargetId() {
    return targetId;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTargetId(@jakarta.annotation.Nonnull String targetId) {
    this.targetId = targetId;
  }

  public AssetsControllerApiRelationRequest targetNamespace(@jakarta.annotation.Nullable String targetNamespace) {
    
    this.targetNamespace = targetNamespace;
    return this;
  }

  /**
   * The namespace at the other end, required when it is a flow.
   * @return targetNamespace
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TARGET_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTargetNamespace() {
    return targetNamespace;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTargetNamespace(@jakarta.annotation.Nullable String targetNamespace) {
    this.targetNamespace = targetNamespace;
  }

  public AssetsControllerApiRelationRequest role(@jakarta.annotation.Nullable String role) {
    
    this.role = role;
    return this;
  }

  /**
   * The role the other end plays, for example primary or backup.
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
    AssetsControllerApiRelationRequest assetsControllerApiRelationRequest = (AssetsControllerApiRelationRequest) o;
    return Objects.equals(this.kind, assetsControllerApiRelationRequest.kind) &&
        Objects.equals(this.direction, assetsControllerApiRelationRequest.direction) &&
        Objects.equals(this.targetId, assetsControllerApiRelationRequest.targetId) &&
        Objects.equals(this.targetNamespace, assetsControllerApiRelationRequest.targetNamespace) &&
        Objects.equals(this.role, assetsControllerApiRelationRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, direction, targetId, targetNamespace, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiRelationRequest {\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
    sb.append("    targetNamespace: ").append(toIndentedString(targetNamespace)).append("\n");
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
