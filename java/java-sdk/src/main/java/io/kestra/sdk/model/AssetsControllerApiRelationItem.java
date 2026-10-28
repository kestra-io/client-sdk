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
import io.kestra.sdk.model.AssetsControllerApiAsset;
import io.kestra.sdk.model.AssetsControllerApiRelation;
import io.kestra.sdk.model.AssetsControllerApiRelationNode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetsControllerApiRelationItem
 */
@JsonPropertyOrder({
  AssetsControllerApiRelationItem.JSON_PROPERTY_RELATION,
  AssetsControllerApiRelationItem.JSON_PROPERTY_NODE,
  AssetsControllerApiRelationItem.JSON_PROPERTY_ASSET
})
@JsonTypeName("AssetsController.ApiRelationItem")
public class AssetsControllerApiRelationItem {
  public static final String JSON_PROPERTY_RELATION = "relation";
  @jakarta.annotation.Nullable  private AssetsControllerApiRelation relation;

  public static final String JSON_PROPERTY_NODE = "node";
  @jakarta.annotation.Nullable  private AssetsControllerApiRelationNode node;

  public static final String JSON_PROPERTY_ASSET = "asset";
  @jakarta.annotation.Nullable  private AssetsControllerApiAsset asset;

  public AssetsControllerApiRelationItem() {
  }

  public AssetsControllerApiRelationItem relation(@jakarta.annotation.Nullable AssetsControllerApiRelation relation) {
    
    this.relation = relation;
    return this;
  }

  /**
   * Get relation
   * @return relation
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_RELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetsControllerApiRelation getRelation() {
    return relation;
  }


  @JsonProperty(JSON_PROPERTY_RELATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRelation(@jakarta.annotation.Nullable AssetsControllerApiRelation relation) {
    this.relation = relation;
  }

  public AssetsControllerApiRelationItem node(@jakarta.annotation.Nullable AssetsControllerApiRelationNode node) {
    
    this.node = node;
    return this;
  }

  /**
   * Get node
   * @return node
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_NODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetsControllerApiRelationNode getNode() {
    return node;
  }


  @JsonProperty(JSON_PROPERTY_NODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNode(@jakarta.annotation.Nullable AssetsControllerApiRelationNode node) {
    this.node = node;
  }

  public AssetsControllerApiRelationItem asset(@jakarta.annotation.Nullable AssetsControllerApiAsset asset) {
    
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   * @return asset
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetsControllerApiAsset getAsset() {
    return asset;
  }


  @JsonProperty(JSON_PROPERTY_ASSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAsset(@jakarta.annotation.Nullable AssetsControllerApiAsset asset) {
    this.asset = asset;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetsControllerApiRelationItem assetsControllerApiRelationItem = (AssetsControllerApiRelationItem) o;
    return Objects.equals(this.relation, assetsControllerApiRelationItem.relation) &&
        Objects.equals(this.node, assetsControllerApiRelationItem.node) &&
        Objects.equals(this.asset, assetsControllerApiRelationItem.asset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relation, node, asset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiRelationItem {\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
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
