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
import io.kestra.sdk.model.AssetsControllerApiRelationItem;
import io.kestra.sdk.model.RelationDirection;
import io.kestra.sdk.model.RelationKind;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetsControllerApiRelationGroup
 */
@JsonPropertyOrder({
  AssetsControllerApiRelationGroup.JSON_PROPERTY_KIND,
  AssetsControllerApiRelationGroup.JSON_PROPERTY_DIRECTION,
  AssetsControllerApiRelationGroup.JSON_PROPERTY_TOTAL,
  AssetsControllerApiRelationGroup.JSON_PROPERTY_RESULTS,
  AssetsControllerApiRelationGroup.JSON_PROPERTY_NEXT_CURSOR
})
@JsonTypeName("AssetsController.ApiRelationGroup")
public class AssetsControllerApiRelationGroup {
  public static final String JSON_PROPERTY_KIND = "kind";
  @jakarta.annotation.Nullable  private RelationKind kind;

  public static final String JSON_PROPERTY_DIRECTION = "direction";
  @jakarta.annotation.Nullable  private RelationDirection direction;

  public static final String JSON_PROPERTY_TOTAL = "total";
  @jakarta.annotation.Nullable  private Long total;

  public static final String JSON_PROPERTY_RESULTS = "results";
  @jakarta.annotation.Nullable  private List<AssetsControllerApiRelationItem> results = new ArrayList<>();

  public static final String JSON_PROPERTY_NEXT_CURSOR = "nextCursor";
  @jakarta.annotation.Nullable  private String nextCursor;

  public AssetsControllerApiRelationGroup() {
  }

  public AssetsControllerApiRelationGroup kind(@jakarta.annotation.Nullable RelationKind kind) {
    
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

  public AssetsControllerApiRelationGroup direction(@jakarta.annotation.Nullable RelationDirection direction) {
    
    this.direction = direction;
    return this;
  }

  /**
   * Get direction
   * @return direction
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RelationDirection getDirection() {
    return direction;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDirection(@jakarta.annotation.Nullable RelationDirection direction) {
    this.direction = direction;
  }

  public AssetsControllerApiRelationGroup total(@jakarta.annotation.Nullable Long total) {
    
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotal(@jakarta.annotation.Nullable Long total) {
    this.total = total;
  }

  public AssetsControllerApiRelationGroup results(@jakarta.annotation.Nullable List<AssetsControllerApiRelationItem> results) {
    
    this.results = results;
    return this;
  }

  public AssetsControllerApiRelationGroup addResultsItem(AssetsControllerApiRelationItem resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AssetsControllerApiRelationItem> getResults() {
    return results;
  }


  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResults(@jakarta.annotation.Nullable List<AssetsControllerApiRelationItem> results) {
    this.results = results;
  }

  public AssetsControllerApiRelationGroup nextCursor(@jakarta.annotation.Nullable String nextCursor) {
    
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetsControllerApiRelationGroup assetsControllerApiRelationGroup = (AssetsControllerApiRelationGroup) o;
    return Objects.equals(this.kind, assetsControllerApiRelationGroup.kind) &&
        Objects.equals(this.direction, assetsControllerApiRelationGroup.direction) &&
        Objects.equals(this.total, assetsControllerApiRelationGroup.total) &&
        Objects.equals(this.results, assetsControllerApiRelationGroup.results) &&
        Objects.equals(this.nextCursor, assetsControllerApiRelationGroup.nextCursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, direction, total, results, nextCursor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetsControllerApiRelationGroup {\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    nextCursor: ").append(toIndentedString(nextCursor)).append("\n");
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
