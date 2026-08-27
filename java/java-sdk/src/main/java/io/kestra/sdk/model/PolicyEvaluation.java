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
 * PolicyEvaluation
 */
@JsonPropertyOrder({
  PolicyEvaluation.JSON_PROPERTY_COUNTS,
  PolicyEvaluation.JSON_PROPERTY_TOTAL,
  PolicyEvaluation.JSON_PROPERTY_RESULTS
})
public class PolicyEvaluation {
  public static final String JSON_PROPERTY_COUNTS = "counts";
  @Nullable  private ApiPolicyEvaluationCounts counts;

  public static final String JSON_PROPERTY_TOTAL = "total";
  @Nullable  private Long total;

  public static final String JSON_PROPERTY_RESULTS = "results";
  @Nullable  private List<PolicyEvaluationResult> results = new ArrayList<>();

  public PolicyEvaluation() {
  }

  public PolicyEvaluation counts(@Nullable ApiPolicyEvaluationCounts counts) {
    
    this.counts = counts;
    return this;
  }

  /**
   * Get counts
   * @return counts
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_COUNTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ApiPolicyEvaluationCounts getCounts() {
    return counts;
  }


  @JsonProperty(JSON_PROPERTY_COUNTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCounts(@Nullable ApiPolicyEvaluationCounts counts) {
    this.counts = counts;
  }

  public PolicyEvaluation total(@Nullable Long total) {
    
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotal(@Nullable Long total) {
    this.total = total;
  }

  public PolicyEvaluation results(@Nullable List<PolicyEvaluationResult> results) {
    
    this.results = results;
    return this;
  }

  public PolicyEvaluation addResultsItem(PolicyEvaluationResult resultsItem) {
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
  @Nullable  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PolicyEvaluationResult> getResults() {
    return results;
  }


  @JsonProperty(JSON_PROPERTY_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResults(@Nullable List<PolicyEvaluationResult> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyEvaluation policyEvaluation = (PolicyEvaluation) o;
    return Objects.equals(this.counts, policyEvaluation.counts) &&
        Objects.equals(this.total, policyEvaluation.total) &&
        Objects.equals(this.results, policyEvaluation.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(counts, total, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyEvaluation {\n");
    sb.append("    counts: ").append(toIndentedString(counts)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
