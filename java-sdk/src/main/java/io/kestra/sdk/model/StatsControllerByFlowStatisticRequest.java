/*
 * Kestra EE
 * All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.
 *
 * The version of the OpenAPI document: v1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.kestra.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * StatsControllerByFlowStatisticRequest
 */
@JsonPropertyOrder({
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_Q,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_NAMESPACE,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_FLOW_ID,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_FLOWS,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_START_DATE,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_END_DATE,
  StatsControllerByFlowStatisticRequest.JSON_PROPERTY_NAMESPACE_ONLY
})
@JsonTypeName("StatsController.ByFlowStatisticRequest")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-09T14:00:04.441521653Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class StatsControllerByFlowStatisticRequest {
  public static final String JSON_PROPERTY_Q = "q";
  @javax.annotation.Nullable
  private JsonNullable<String> q = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nullable
  private JsonNullable<String> namespace = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @javax.annotation.Nullable
  private JsonNullable<String> flowId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_FLOWS = "flows";
  @javax.annotation.Nullable
  private JsonNullable<List<ExecutionRepositoryInterfaceFlowFilter>> flows = JsonNullable.<List<ExecutionRepositoryInterfaceFlowFilter>>undefined();

  public static final String JSON_PROPERTY_START_DATE = "startDate";
  @javax.annotation.Nullable
  private JsonNullable<OffsetDateTime> startDate = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_END_DATE = "endDate";
  @javax.annotation.Nullable
  private JsonNullable<OffsetDateTime> endDate = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_NAMESPACE_ONLY = "namespaceOnly";
  @javax.annotation.Nullable
  private JsonNullable<Boolean> namespaceOnly = JsonNullable.<Boolean>undefined();

  public StatsControllerByFlowStatisticRequest() {
  }

  public StatsControllerByFlowStatisticRequest q(@javax.annotation.Nullable String q) {
    this.q = JsonNullable.<String>of(q);

    return this;
  }

  /**
   * Get q
   * @return q
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public String getQ() {
        return q.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_Q)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getQ_JsonNullable() {
    return q;
  }

  @JsonProperty(JSON_PROPERTY_Q)
  public void setQ_JsonNullable(JsonNullable<String> q) {
    this.q = q;
  }

  public void setQ(@javax.annotation.Nullable String q) {
    this.q = JsonNullable.<String>of(q);
  }

  public StatsControllerByFlowStatisticRequest namespace(@javax.annotation.Nullable String namespace) {
    this.namespace = JsonNullable.<String>of(namespace);

    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public String getNamespace() {
        return namespace.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getNamespace_JsonNullable() {
    return namespace;
  }

  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  public void setNamespace_JsonNullable(JsonNullable<String> namespace) {
    this.namespace = namespace;
  }

  public void setNamespace(@javax.annotation.Nullable String namespace) {
    this.namespace = JsonNullable.<String>of(namespace);
  }

  public StatsControllerByFlowStatisticRequest flowId(@javax.annotation.Nullable String flowId) {
    this.flowId = JsonNullable.<String>of(flowId);

    return this;
  }

  /**
   * Get flowId
   * @return flowId
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public String getFlowId() {
        return flowId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getFlowId_JsonNullable() {
    return flowId;
  }

  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  public void setFlowId_JsonNullable(JsonNullable<String> flowId) {
    this.flowId = flowId;
  }

  public void setFlowId(@javax.annotation.Nullable String flowId) {
    this.flowId = JsonNullable.<String>of(flowId);
  }

  public StatsControllerByFlowStatisticRequest flows(@javax.annotation.Nullable List<ExecutionRepositoryInterfaceFlowFilter> flows) {
    this.flows = JsonNullable.<List<ExecutionRepositoryInterfaceFlowFilter>>of(flows);

    return this;
  }

  public StatsControllerByFlowStatisticRequest addFlowsItem(ExecutionRepositoryInterfaceFlowFilter flowsItem) {
    if (this.flows == null || !this.flows.isPresent()) {
      this.flows = JsonNullable.<List<ExecutionRepositoryInterfaceFlowFilter>>of(new ArrayList<>());
    }
    try {
      this.flows.get().add(flowsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

  /**
   * Get flows
   * @return flows
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public List<ExecutionRepositoryInterfaceFlowFilter> getFlows() {
        return flows.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLOWS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<ExecutionRepositoryInterfaceFlowFilter>> getFlows_JsonNullable() {
    return flows;
  }

  @JsonProperty(JSON_PROPERTY_FLOWS)
  public void setFlows_JsonNullable(JsonNullable<List<ExecutionRepositoryInterfaceFlowFilter>> flows) {
    this.flows = flows;
  }

  public void setFlows(@javax.annotation.Nullable List<ExecutionRepositoryInterfaceFlowFilter> flows) {
    this.flows = JsonNullable.<List<ExecutionRepositoryInterfaceFlowFilter>>of(flows);
  }

  public StatsControllerByFlowStatisticRequest startDate(@javax.annotation.Nullable OffsetDateTime startDate) {
    this.startDate = JsonNullable.<OffsetDateTime>of(startDate);

    return this;
  }

  /**
   * Get startDate
   * @return startDate
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public OffsetDateTime getStartDate() {
        return startDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getStartDate_JsonNullable() {
    return startDate;
  }

  @JsonProperty(JSON_PROPERTY_START_DATE)
  public void setStartDate_JsonNullable(JsonNullable<OffsetDateTime> startDate) {
    this.startDate = startDate;
  }

  public void setStartDate(@javax.annotation.Nullable OffsetDateTime startDate) {
    this.startDate = JsonNullable.<OffsetDateTime>of(startDate);
  }

  public StatsControllerByFlowStatisticRequest endDate(@javax.annotation.Nullable OffsetDateTime endDate) {
    this.endDate = JsonNullable.<OffsetDateTime>of(endDate);

    return this;
  }

  /**
   * Get endDate
   * @return endDate
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public OffsetDateTime getEndDate() {
        return endDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_END_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getEndDate_JsonNullable() {
    return endDate;
  }

  @JsonProperty(JSON_PROPERTY_END_DATE)
  public void setEndDate_JsonNullable(JsonNullable<OffsetDateTime> endDate) {
    this.endDate = endDate;
  }

  public void setEndDate(@javax.annotation.Nullable OffsetDateTime endDate) {
    this.endDate = JsonNullable.<OffsetDateTime>of(endDate);
  }

  public StatsControllerByFlowStatisticRequest namespaceOnly(@javax.annotation.Nullable Boolean namespaceOnly) {
    this.namespaceOnly = JsonNullable.<Boolean>of(namespaceOnly);

    return this;
  }

  /**
   * Get namespaceOnly
   * @return namespaceOnly
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public Boolean getNamespaceOnly() {
        return namespaceOnly.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAMESPACE_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Boolean> getNamespaceOnly_JsonNullable() {
    return namespaceOnly;
  }

  @JsonProperty(JSON_PROPERTY_NAMESPACE_ONLY)
  public void setNamespaceOnly_JsonNullable(JsonNullable<Boolean> namespaceOnly) {
    this.namespaceOnly = namespaceOnly;
  }

  public void setNamespaceOnly(@javax.annotation.Nullable Boolean namespaceOnly) {
    this.namespaceOnly = JsonNullable.<Boolean>of(namespaceOnly);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatsControllerByFlowStatisticRequest statsControllerByFlowStatisticRequest = (StatsControllerByFlowStatisticRequest) o;
    return equalsNullable(this.q, statsControllerByFlowStatisticRequest.q) &&
        equalsNullable(this.namespace, statsControllerByFlowStatisticRequest.namespace) &&
        equalsNullable(this.flowId, statsControllerByFlowStatisticRequest.flowId) &&
        equalsNullable(this.flows, statsControllerByFlowStatisticRequest.flows) &&
        equalsNullable(this.startDate, statsControllerByFlowStatisticRequest.startDate) &&
        equalsNullable(this.endDate, statsControllerByFlowStatisticRequest.endDate) &&
        equalsNullable(this.namespaceOnly, statsControllerByFlowStatisticRequest.namespaceOnly);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(q), hashCodeNullable(namespace), hashCodeNullable(flowId), hashCodeNullable(flows), hashCodeNullable(startDate), hashCodeNullable(endDate), hashCodeNullable(namespaceOnly));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatsControllerByFlowStatisticRequest {\n");
    sb.append("    q: ").append(toIndentedString(q)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    flows: ").append(toIndentedString(flows)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    namespaceOnly: ").append(toIndentedString(namespaceOnly)).append("\n");
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

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `q` to the URL query string
    if (getQ() != null) {
      try {
        joiner.add(String.format("%sq%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getQ()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `namespace` to the URL query string
    if (getNamespace() != null) {
      try {
        joiner.add(String.format("%snamespace%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNamespace()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `flowId` to the URL query string
    if (getFlowId() != null) {
      try {
        joiner.add(String.format("%sflowId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getFlowId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `flows` to the URL query string
    if (getFlows() != null) {
      for (int i = 0; i < getFlows().size(); i++) {
        if (getFlows().get(i) != null) {
          joiner.add(getFlows().get(i).toUrlQueryString(String.format("%sflows%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `startDate` to the URL query string
    if (getStartDate() != null) {
      try {
        joiner.add(String.format("%sstartDate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStartDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `endDate` to the URL query string
    if (getEndDate() != null) {
      try {
        joiner.add(String.format("%sendDate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEndDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `namespaceOnly` to the URL query string
    if (getNamespaceOnly() != null) {
      try {
        joiner.add(String.format("%snamespaceOnly%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNamespaceOnly()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

