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
import io.kestra.sdk.model.AssetRelationGraphEdge;
import io.kestra.sdk.model.AssetRelationGraphNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetRelationGraph
 */
@JsonPropertyOrder({
  AssetRelationGraph.JSON_PROPERTY_NODES,
  AssetRelationGraph.JSON_PROPERTY_EDGES,
  AssetRelationGraph.JSON_PROPERTY_TRUNCATED
})
public class AssetRelationGraph {
  public static final String JSON_PROPERTY_NODES = "nodes";
  @jakarta.annotation.Nullable  private List<AssetRelationGraphNode> nodes = new ArrayList<>();

  public static final String JSON_PROPERTY_EDGES = "edges";
  @jakarta.annotation.Nullable  private List<AssetRelationGraphEdge> edges = new ArrayList<>();

  public static final String JSON_PROPERTY_TRUNCATED = "truncated";
  @jakarta.annotation.Nullable  private Boolean truncated;

  public AssetRelationGraph() {
  }

  public AssetRelationGraph nodes(@jakarta.annotation.Nullable List<AssetRelationGraphNode> nodes) {
    
    this.nodes = nodes;
    return this;
  }

  public AssetRelationGraph addNodesItem(AssetRelationGraphNode nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

  /**
   * Get nodes
   * @return nodes
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_NODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetRelationGraphNode> getNodes() {
    return nodes;
  }


  @JsonProperty(JSON_PROPERTY_NODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNodes(@jakarta.annotation.Nullable List<AssetRelationGraphNode> nodes) {
    this.nodes = nodes;
  }

  public AssetRelationGraph edges(@jakarta.annotation.Nullable List<AssetRelationGraphEdge> edges) {
    
    this.edges = edges;
    return this;
  }

  public AssetRelationGraph addEdgesItem(AssetRelationGraphEdge edgesItem) {
    if (this.edges == null) {
      this.edges = new ArrayList<>();
    }
    this.edges.add(edgesItem);
    return this;
  }

  /**
   * Get edges
   * @return edges
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_EDGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetRelationGraphEdge> getEdges() {
    return edges;
  }


  @JsonProperty(JSON_PROPERTY_EDGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEdges(@jakarta.annotation.Nullable List<AssetRelationGraphEdge> edges) {
    this.edges = edges;
  }

  public AssetRelationGraph truncated(@jakarta.annotation.Nullable Boolean truncated) {
    
    this.truncated = truncated;
    return this;
  }

  /**
   * Get truncated
   * @return truncated
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TRUNCATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getTruncated() {
    return truncated;
  }


  @JsonProperty(JSON_PROPERTY_TRUNCATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTruncated(@jakarta.annotation.Nullable Boolean truncated) {
    this.truncated = truncated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetRelationGraph assetRelationGraph = (AssetRelationGraph) o;
    return Objects.equals(this.nodes, assetRelationGraph.nodes) &&
        Objects.equals(this.edges, assetRelationGraph.edges) &&
        Objects.equals(this.truncated, assetRelationGraph.truncated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, edges, truncated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetRelationGraph {\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    edges: ").append(toIndentedString(edges)).append("\n");
    sb.append("    truncated: ").append(toIndentedString(truncated)).append("\n");
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
