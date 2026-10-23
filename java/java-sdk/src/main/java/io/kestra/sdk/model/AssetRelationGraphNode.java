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
import io.kestra.sdk.model.AssetWriteSummary;
import io.kestra.sdk.model.NodeType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetRelationGraphNode
 */
@JsonPropertyOrder({
  AssetRelationGraphNode.JSON_PROPERTY_UID,
  AssetRelationGraphNode.JSON_PROPERTY_NAMESPACE,
  AssetRelationGraphNode.JSON_PROPERTY_ID,
  AssetRelationGraphNode.JSON_PROPERTY_TYPE,
  AssetRelationGraphNode.JSON_PROPERTY_ASSET_TYPE,
  AssetRelationGraphNode.JSON_PROPERTY_DISPLAY_NAME,
  AssetRelationGraphNode.JSON_PROPERTY_PRODUCER,
  AssetRelationGraphNode.JSON_PROPERTY_RUNS,
  AssetRelationGraphNode.JSON_PROPERTY_COLLAPSED,
  AssetRelationGraphNode.JSON_PROPERTY_TOTAL_DEGREE,
  AssetRelationGraphNode.JSON_PROPERTY_NEXT_CURSOR,
  AssetRelationGraphNode.JSON_PROPERTY_EXHAUSTED
})
@JsonTypeName("AssetRelationGraph.Node")
public class AssetRelationGraphNode {
  public static final String JSON_PROPERTY_UID = "uid";
  @jakarta.annotation.Nullable  private String uid;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_ID = "id";
  @jakarta.annotation.Nullable  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  @jakarta.annotation.Nullable  private NodeType type;

  public static final String JSON_PROPERTY_ASSET_TYPE = "assetType";
  @jakarta.annotation.Nullable  private String assetType;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @jakarta.annotation.Nullable  private String displayName;

  public static final String JSON_PROPERTY_PRODUCER = "producer";
  @jakarta.annotation.Nullable  private AssetWriteSummary producer;

  public static final String JSON_PROPERTY_RUNS = "runs";
  @jakarta.annotation.Nullable  private List<AssetWriteSummary> runs = new ArrayList<>();

  public static final String JSON_PROPERTY_COLLAPSED = "collapsed";
  @jakarta.annotation.Nullable  private Boolean collapsed;

  public static final String JSON_PROPERTY_TOTAL_DEGREE = "totalDegree";
  @jakarta.annotation.Nullable  private Long totalDegree;

  public static final String JSON_PROPERTY_NEXT_CURSOR = "nextCursor";
  @jakarta.annotation.Nullable  private String nextCursor;

  public static final String JSON_PROPERTY_EXHAUSTED = "exhausted";
  @jakarta.annotation.Nullable  private Boolean exhausted;

  public AssetRelationGraphNode() {
  }

  public AssetRelationGraphNode uid(@jakarta.annotation.Nullable String uid) {
    
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

  public AssetRelationGraphNode namespace(@jakarta.annotation.Nullable String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
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

  public AssetRelationGraphNode id(@jakarta.annotation.Nullable String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@jakarta.annotation.Nullable String id) {
    this.id = id;
  }

  public AssetRelationGraphNode type(@jakarta.annotation.Nullable NodeType type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NodeType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(@jakarta.annotation.Nullable NodeType type) {
    this.type = type;
  }

  public AssetRelationGraphNode assetType(@jakarta.annotation.Nullable String assetType) {
    
    this.assetType = assetType;
    return this;
  }

  /**
   * Get assetType
   * @return assetType
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssetType() {
    return assetType;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetType(@jakarta.annotation.Nullable String assetType) {
    this.assetType = assetType;
  }

  public AssetRelationGraphNode displayName(@jakarta.annotation.Nullable String displayName) {
    
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
    this.displayName = displayName;
  }

  public AssetRelationGraphNode producer(@jakarta.annotation.Nullable AssetWriteSummary producer) {
    
    this.producer = producer;
    return this;
  }

  /**
   * Get producer
   * @return producer
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_PRODUCER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetWriteSummary getProducer() {
    return producer;
  }


  @JsonProperty(JSON_PROPERTY_PRODUCER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProducer(@jakarta.annotation.Nullable AssetWriteSummary producer) {
    this.producer = producer;
  }

  public AssetRelationGraphNode runs(@jakarta.annotation.Nullable List<AssetWriteSummary> runs) {
    
    this.runs = runs;
    return this;
  }

  public AssetRelationGraphNode addRunsItem(AssetWriteSummary runsItem) {
    if (this.runs == null) {
      this.runs = new ArrayList<>();
    }
    this.runs.add(runsItem);
    return this;
  }

  /**
   * Get runs
   * @return runs
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_RUNS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetWriteSummary> getRuns() {
    return runs;
  }


  @JsonProperty(JSON_PROPERTY_RUNS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRuns(@jakarta.annotation.Nullable List<AssetWriteSummary> runs) {
    this.runs = runs;
  }

  public AssetRelationGraphNode collapsed(@jakarta.annotation.Nullable Boolean collapsed) {
    
    this.collapsed = collapsed;
    return this;
  }

  /**
   * Get collapsed
   * @return collapsed
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_COLLAPSED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getCollapsed() {
    return collapsed;
  }


  @JsonProperty(JSON_PROPERTY_COLLAPSED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCollapsed(@jakarta.annotation.Nullable Boolean collapsed) {
    this.collapsed = collapsed;
  }

  public AssetRelationGraphNode totalDegree(@jakarta.annotation.Nullable Long totalDegree) {
    
    this.totalDegree = totalDegree;
    return this;
  }

  /**
   * Get totalDegree
   * @return totalDegree
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TOTAL_DEGREE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotalDegree() {
    return totalDegree;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_DEGREE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalDegree(@jakarta.annotation.Nullable Long totalDegree) {
    this.totalDegree = totalDegree;
  }

  public AssetRelationGraphNode nextCursor(@jakarta.annotation.Nullable String nextCursor) {
    
    this.nextCursor = nextCursor;
    return this;
  }

  /**
   * Get nextCursor
   * @return nextCursor
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_NEXT_CURSOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNextCursor() {
    return nextCursor;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_CURSOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextCursor(@jakarta.annotation.Nullable String nextCursor) {
    this.nextCursor = nextCursor;
  }

  public AssetRelationGraphNode exhausted(@jakarta.annotation.Nullable Boolean exhausted) {
    
    this.exhausted = exhausted;
    return this;
  }

  /**
   * Get exhausted
   * @return exhausted
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_EXHAUSTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getExhausted() {
    return exhausted;
  }


  @JsonProperty(JSON_PROPERTY_EXHAUSTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExhausted(@jakarta.annotation.Nullable Boolean exhausted) {
    this.exhausted = exhausted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetRelationGraphNode assetRelationGraphNode = (AssetRelationGraphNode) o;
    return Objects.equals(this.uid, assetRelationGraphNode.uid) &&
        Objects.equals(this.namespace, assetRelationGraphNode.namespace) &&
        Objects.equals(this.id, assetRelationGraphNode.id) &&
        Objects.equals(this.type, assetRelationGraphNode.type) &&
        Objects.equals(this.assetType, assetRelationGraphNode.assetType) &&
        Objects.equals(this.displayName, assetRelationGraphNode.displayName) &&
        Objects.equals(this.producer, assetRelationGraphNode.producer) &&
        Objects.equals(this.runs, assetRelationGraphNode.runs) &&
        Objects.equals(this.collapsed, assetRelationGraphNode.collapsed) &&
        Objects.equals(this.totalDegree, assetRelationGraphNode.totalDegree) &&
        Objects.equals(this.nextCursor, assetRelationGraphNode.nextCursor) &&
        Objects.equals(this.exhausted, assetRelationGraphNode.exhausted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, namespace, id, type, assetType, displayName, producer, runs, collapsed, totalDegree, nextCursor, exhausted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetRelationGraphNode {\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    runs: ").append(toIndentedString(runs)).append("\n");
    sb.append("    collapsed: ").append(toIndentedString(collapsed)).append("\n");
    sb.append("    totalDegree: ").append(toIndentedString(totalDegree)).append("\n");
    sb.append("    nextCursor: ").append(toIndentedString(nextCursor)).append("\n");
    sb.append("    exhausted: ").append(toIndentedString(exhausted)).append("\n");
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
