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
import io.kestra.sdk.model.RelationKind;
import io.kestra.sdk.model.RelationOrigin;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetRelationGraphEdge
 */
@JsonPropertyOrder({
  AssetRelationGraphEdge.JSON_PROPERTY_SOURCE,
  AssetRelationGraphEdge.JSON_PROPERTY_TARGET,
  AssetRelationGraphEdge.JSON_PROPERTY_KIND,
  AssetRelationGraphEdge.JSON_PROPERTY_DIRECTED,
  AssetRelationGraphEdge.JSON_PROPERTY_ROLE,
  AssetRelationGraphEdge.JSON_PROPERTY_ORIGIN,
  AssetRelationGraphEdge.JSON_PROPERTY_TASK_TYPE
})
@JsonTypeName("AssetRelationGraph.Edge")
public class AssetRelationGraphEdge {
  public static final String JSON_PROPERTY_SOURCE = "source";
  @jakarta.annotation.Nullable  private String source;

  public static final String JSON_PROPERTY_TARGET = "target";
  @jakarta.annotation.Nullable  private String target;

  public static final String JSON_PROPERTY_KIND = "kind";
  @jakarta.annotation.Nullable  private RelationKind kind;

  public static final String JSON_PROPERTY_DIRECTED = "directed";
  @jakarta.annotation.Nullable  private Boolean directed;

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nullable  private String role;

  public static final String JSON_PROPERTY_ORIGIN = "origin";
  @jakarta.annotation.Nullable  private RelationOrigin origin;

  public static final String JSON_PROPERTY_TASK_TYPE = "taskType";
  @jakarta.annotation.Nullable  private String taskType;

  public AssetRelationGraphEdge() {
  }

  public AssetRelationGraphEdge source(@jakarta.annotation.Nullable String source) {
    
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSource() {
    return source;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(@jakarta.annotation.Nullable String source) {
    this.source = source;
  }

  public AssetRelationGraphEdge target(@jakarta.annotation.Nullable String target) {
    
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTarget() {
    return target;
  }


  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(@jakarta.annotation.Nullable String target) {
    this.target = target;
  }

  public AssetRelationGraphEdge kind(@jakarta.annotation.Nullable RelationKind kind) {
    
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

  public AssetRelationGraphEdge directed(@jakarta.annotation.Nullable Boolean directed) {
    
    this.directed = directed;
    return this;
  }

  /**
   * Get directed
   * @return directed
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DIRECTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDirected() {
    return directed;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDirected(@jakarta.annotation.Nullable Boolean directed) {
    this.directed = directed;
  }

  public AssetRelationGraphEdge role(@jakarta.annotation.Nullable String role) {
    
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

  public AssetRelationGraphEdge origin(@jakarta.annotation.Nullable RelationOrigin origin) {
    
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

  public AssetRelationGraphEdge taskType(@jakarta.annotation.Nullable String taskType) {
    
    this.taskType = taskType;
    return this;
  }

  /**
   * Get taskType
   * @return taskType
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TASK_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskType() {
    return taskType;
  }


  @JsonProperty(JSON_PROPERTY_TASK_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskType(@jakarta.annotation.Nullable String taskType) {
    this.taskType = taskType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetRelationGraphEdge assetRelationGraphEdge = (AssetRelationGraphEdge) o;
    return Objects.equals(this.source, assetRelationGraphEdge.source) &&
        Objects.equals(this.target, assetRelationGraphEdge.target) &&
        Objects.equals(this.kind, assetRelationGraphEdge.kind) &&
        Objects.equals(this.directed, assetRelationGraphEdge.directed) &&
        Objects.equals(this.role, assetRelationGraphEdge.role) &&
        Objects.equals(this.origin, assetRelationGraphEdge.origin) &&
        Objects.equals(this.taskType, assetRelationGraphEdge.taskType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target, kind, directed, role, origin, taskType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetRelationGraphEdge {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    directed: ").append(toIndentedString(directed)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    taskType: ").append(toIndentedString(taskType)).append("\n");
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
