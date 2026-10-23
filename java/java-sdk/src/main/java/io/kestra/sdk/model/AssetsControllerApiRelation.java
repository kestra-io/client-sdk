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
import io.kestra.sdk.model.AssetsControllerApiRelationNode;
import io.kestra.sdk.model.RelationKind;
import io.kestra.sdk.model.RelationOrigin;
import io.kestra.sdk.model.RelationProvenance;
import io.kestra.sdk.model.RelationState;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetsControllerApiRelation
 */
@JsonPropertyOrder({
  AssetsControllerApiRelation.JSON_PROPERTY_UID,
  AssetsControllerApiRelation.JSON_PROPERTY_KIND,
  AssetsControllerApiRelation.JSON_PROPERTY_ROLE,
  AssetsControllerApiRelation.JSON_PROPERTY_ORIGIN,
  AssetsControllerApiRelation.JSON_PROPERTY_STATE,
  AssetsControllerApiRelation.JSON_PROPERTY_SOURCE,
  AssetsControllerApiRelation.JSON_PROPERTY_TARGET,
  AssetsControllerApiRelation.JSON_PROPERTY_PROVENANCE,
  AssetsControllerApiRelation.JSON_PROPERTY_CREATED,
  AssetsControllerApiRelation.JSON_PROPERTY_UPDATED
})
@JsonTypeName("AssetsController.ApiRelation")
public class AssetsControllerApiRelation {
  public static final String JSON_PROPERTY_UID = "uid";
  @jakarta.annotation.Nullable  private String uid;

  public static final String JSON_PROPERTY_KIND = "kind";
  @jakarta.annotation.Nullable  private RelationKind kind;

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nullable  private String role;

  public static final String JSON_PROPERTY_ORIGIN = "origin";
  @jakarta.annotation.Nullable  private RelationOrigin origin;

  public static final String JSON_PROPERTY_STATE = "state";
  @jakarta.annotation.Nullable  private RelationState state;

  public static final String JSON_PROPERTY_SOURCE = "source";
  @jakarta.annotation.Nullable  private AssetsControllerApiRelationNode source;

  public static final String JSON_PROPERTY_TARGET = "target";
  @jakarta.annotation.Nullable  private AssetsControllerApiRelationNode target;

  public static final String JSON_PROPERTY_PROVENANCE = "provenance";
  @jakarta.annotation.Nullable  private RelationProvenance provenance;

  public static final String JSON_PROPERTY_CREATED = "created";
  @jakarta.annotation.Nullable  private OffsetDateTime created;

  public static final String JSON_PROPERTY_UPDATED = "updated";
  @jakarta.annotation.Nullable  private OffsetDateTime updated;

  public AssetsControllerApiRelation() {
  }

  public AssetsControllerApiRelation uid(@jakarta.annotation.Nullable String uid) {
    
    this.uid = uid;
    return this;
  }

  /**
   * Get uid
   * @return uid
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_UID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUid() {
    return uid;
  }


  @JsonProperty(JSON_PROPERTY_UID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUid(@jakarta.annotation.Nullable String uid) {
    this.uid = uid;
  }

  public AssetsControllerApiRelation kind(@jakarta.annotation.Nullable RelationKind kind) {
    
    this.kind = kind;
    return this;
  }

  /**
   * Get kind
   * @return kind
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RelationKind getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(@jakarta.annotation.Nullable RelationKind kind) {
    this.kind = kind;
  }

  public AssetsControllerApiRelation role(@jakarta.annotation.Nullable String role) {
    
    this.role = role;
    return this;
  }

  /**
   * Get role
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

  public AssetsControllerApiRelation origin(@jakarta.annotation.Nullable RelationOrigin origin) {
    
    this.origin = origin;
    return this;
  }

  /**
   * Get origin
   * @return origin
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RelationOrigin getOrigin() {
    return origin;
  }


  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrigin(@jakarta.annotation.Nullable RelationOrigin origin) {
    this.origin = origin;
  }

  public AssetsControllerApiRelation state(@jakarta.annotation.Nullable RelationState state) {
    
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RelationState getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(@jakarta.annotation.Nullable RelationState state) {
    this.state = state;
  }

  public AssetsControllerApiRelation source(@jakarta.annotation.Nullable AssetsControllerApiRelationNode source) {
    
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetsControllerApiRelationNode getSource() {
    return source;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(@jakarta.annotation.Nullable AssetsControllerApiRelationNode source) {
    this.source = source;
  }

  public AssetsControllerApiRelation target(@jakarta.annotation.Nullable AssetsControllerApiRelationNode target) {
    
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetsControllerApiRelationNode getTarget() {
    return target;
  }


  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(@jakarta.annotation.Nullable AssetsControllerApiRelationNode target) {
    this.target = target;
  }

  public AssetsControllerApiRelation provenance(@jakarta.annotation.Nullable RelationProvenance provenance) {
    
    this.provenance = provenance;
    return this;
  }

  /**
   * Get provenance
   * @return provenance
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_PROVENANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RelationProvenance getProvenance() {
    return provenance;
  }


  @JsonProperty(JSON_PROPERTY_PROVENANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProvenance(@jakarta.annotation.Nullable RelationProvenance provenance) {
    this.provenance = provenance;
  }

  public AssetsControllerApiRelation created(@jakarta.annotation.Nullable OffsetDateTime created) {
    
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }


  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreated(@jakarta.annotation.Nullable OffsetDateTime created) {
    this.created = created;
  }

  public AssetsControllerApiRelation updated(@jakarta.annotation.Nullable OffsetDateTime updated) {
    
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdated() {
    return updated;
  }


  @JsonProperty(JSON_PROPERTY_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdated(@jakarta.annotation.Nullable OffsetDateTime updated) {
    this.updated = updated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetsControllerApiRelation assetsControllerApiRelation = (AssetsControllerApiRelation) o;
    return Objects.equals(this.uid, assetsControllerApiRelation.uid) &&
        Objects.equals(this.kind, assetsControllerApiRelation.kind) &&
        Objects.equals(this.role, assetsControllerApiRelation.role) &&
        Objects.equals(this.origin, assetsControllerApiRelation.origin) &&
        Objects.equals(this.state, assetsControllerApiRelation.state) &&
        Objects.equals(this.source, assetsControllerApiRelation.source) &&
        Objects.equals(this.target, assetsControllerApiRelation.target) &&
        Objects.equals(this.provenance, assetsControllerApiRelation.provenance) &&
        Objects.equals(this.created, assetsControllerApiRelation.created) &&
        Objects.equals(this.updated, assetsControllerApiRelation.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, kind, role, origin, state, source, target, provenance, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiRelation {\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    provenance: ").append(toIndentedString(provenance)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
