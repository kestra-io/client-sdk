/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kestra.sdk.model.Backfill;
import io.kestra.sdk.model.StateType;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * Trigger
 */
@JsonPropertyOrder({
  Trigger.JSON_PROPERTY_DISABLED,
  Trigger.JSON_PROPERTY_TENANT_ID,
  Trigger.JSON_PROPERTY_NAMESPACE,
  Trigger.JSON_PROPERTY_FLOW_ID,
  Trigger.JSON_PROPERTY_TRIGGER_ID,
  Trigger.JSON_PROPERTY_DATE,
  Trigger.JSON_PROPERTY_NEXT_EXECUTION_DATE,
  Trigger.JSON_PROPERTY_BACKFILL,
  Trigger.JSON_PROPERTY_STOP_AFTER,
  Trigger.JSON_PROPERTY_EXECUTION_ID,
  Trigger.JSON_PROPERTY_UPDATED_DATE,
  Trigger.JSON_PROPERTY_EVALUATE_RUNNING_DATE,
  Trigger.JSON_PROPERTY_WORKER_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class Trigger {
  public static final String JSON_PROPERTY_DISABLED = "disabled";
  @javax.annotation.Nullable
  private Boolean disabled;

  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  @javax.annotation.Nullable
  private String tenantId;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nonnull
  private String namespace;

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @javax.annotation.Nonnull
  private String flowId;

  public static final String JSON_PROPERTY_TRIGGER_ID = "triggerId";
  @javax.annotation.Nonnull
  private String triggerId;

  public static final String JSON_PROPERTY_DATE = "date";
  @javax.annotation.Nonnull
  private OffsetDateTime date;

  public static final String JSON_PROPERTY_NEXT_EXECUTION_DATE = "nextExecutionDate";
  @javax.annotation.Nullable
  private JsonNullable<OffsetDateTime> nextExecutionDate = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_BACKFILL = "backfill";
  @javax.annotation.Nullable
  private JsonNullable<Backfill> backfill = JsonNullable.<Backfill>undefined();

  public static final String JSON_PROPERTY_STOP_AFTER = "stopAfter";
  @javax.annotation.Nullable
  private JsonNullable<List<StateType>> stopAfter = JsonNullable.<List<StateType>>undefined();

  public static final String JSON_PROPERTY_EXECUTION_ID = "executionId";
  @javax.annotation.Nullable
  private JsonNullable<String> executionId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
  @javax.annotation.Nullable
  private JsonNullable<OffsetDateTime> updatedDate = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_EVALUATE_RUNNING_DATE = "evaluateRunningDate";
  @javax.annotation.Nullable
  private JsonNullable<OffsetDateTime> evaluateRunningDate = JsonNullable.<OffsetDateTime>undefined();

  public static final String JSON_PROPERTY_WORKER_ID = "workerId";
  @javax.annotation.Nullable
  private JsonNullable<String> workerId = JsonNullable.<String>undefined();

  public Trigger() {
  }

  public Trigger disabled(@javax.annotation.Nullable Boolean disabled) {
    
    this.disabled = disabled;
    return this;
  }

  /**
   * Get disabled
   * @return disabled
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDisabled() {
    return disabled;
  }


  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisabled(@javax.annotation.Nullable Boolean disabled) {
    this.disabled = disabled;
  }

  public Trigger tenantId(@javax.annotation.Nullable String tenantId) {
    
    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTenantId() {
    return tenantId;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenantId(@javax.annotation.Nullable String tenantId) {
    this.tenantId = tenantId;
  }

  public Trigger namespace(@javax.annotation.Nonnull String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNamespace(@javax.annotation.Nonnull String namespace) {
    this.namespace = namespace;
  }

  public Trigger flowId(@javax.annotation.Nonnull String flowId) {
    
    this.flowId = flowId;
    return this;
  }

  /**
   * Get flowId
   * @return flowId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFlowId() {
    return flowId;
  }


  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFlowId(@javax.annotation.Nonnull String flowId) {
    this.flowId = flowId;
  }

  public Trigger triggerId(@javax.annotation.Nonnull String triggerId) {
    
    this.triggerId = triggerId;
    return this;
  }

  /**
   * Get triggerId
   * @return triggerId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRIGGER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTriggerId() {
    return triggerId;
  }


  @JsonProperty(JSON_PROPERTY_TRIGGER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTriggerId(@javax.annotation.Nonnull String triggerId) {
    this.triggerId = triggerId;
  }

  public Trigger date(@javax.annotation.Nonnull OffsetDateTime date) {
    
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getDate() {
    return date;
  }


  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDate(@javax.annotation.Nonnull OffsetDateTime date) {
    this.date = date;
  }

  public Trigger nextExecutionDate(@javax.annotation.Nullable OffsetDateTime nextExecutionDate) {
    this.nextExecutionDate = JsonNullable.<OffsetDateTime>of(nextExecutionDate);
    
    return this;
  }

  /**
   * Get nextExecutionDate
   * @return nextExecutionDate
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public OffsetDateTime getNextExecutionDate() {
        return nextExecutionDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT_EXECUTION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getNextExecutionDate_JsonNullable() {
    return nextExecutionDate;
  }
  
  @JsonProperty(JSON_PROPERTY_NEXT_EXECUTION_DATE)
  public void setNextExecutionDate_JsonNullable(JsonNullable<OffsetDateTime> nextExecutionDate) {
    this.nextExecutionDate = nextExecutionDate;
  }

  public void setNextExecutionDate(@javax.annotation.Nullable OffsetDateTime nextExecutionDate) {
    this.nextExecutionDate = JsonNullable.<OffsetDateTime>of(nextExecutionDate);
  }

  public Trigger backfill(@javax.annotation.Nullable Backfill backfill) {
    this.backfill = JsonNullable.<Backfill>of(backfill);
    
    return this;
  }

  /**
   * Get backfill
   * @return backfill
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public Backfill getBackfill() {
        return backfill.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BACKFILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Backfill> getBackfill_JsonNullable() {
    return backfill;
  }
  
  @JsonProperty(JSON_PROPERTY_BACKFILL)
  public void setBackfill_JsonNullable(JsonNullable<Backfill> backfill) {
    this.backfill = backfill;
  }

  public void setBackfill(@javax.annotation.Nullable Backfill backfill) {
    this.backfill = JsonNullable.<Backfill>of(backfill);
  }

  public Trigger stopAfter(@javax.annotation.Nullable List<StateType> stopAfter) {
    this.stopAfter = JsonNullable.<List<StateType>>of(stopAfter);
    
    return this;
  }

  public Trigger addStopAfterItem(StateType stopAfterItem) {
    if (this.stopAfter == null || !this.stopAfter.isPresent()) {
      this.stopAfter = JsonNullable.<List<StateType>>of(new ArrayList<>());
    }
    try {
      this.stopAfter.get().add(stopAfterItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

  /**
   * Get stopAfter
   * @return stopAfter
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public List<StateType> getStopAfter() {
        return stopAfter.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STOP_AFTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<StateType>> getStopAfter_JsonNullable() {
    return stopAfter;
  }
  
  @JsonProperty(JSON_PROPERTY_STOP_AFTER)
  public void setStopAfter_JsonNullable(JsonNullable<List<StateType>> stopAfter) {
    this.stopAfter = stopAfter;
  }

  public void setStopAfter(@javax.annotation.Nullable List<StateType> stopAfter) {
    this.stopAfter = JsonNullable.<List<StateType>>of(stopAfter);
  }

  public Trigger executionId(@javax.annotation.Nullable String executionId) {
    this.executionId = JsonNullable.<String>of(executionId);
    
    return this;
  }

  /**
   * Get executionId
   * @return executionId
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public String getExecutionId() {
        return executionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getExecutionId_JsonNullable() {
    return executionId;
  }
  
  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  public void setExecutionId_JsonNullable(JsonNullable<String> executionId) {
    this.executionId = executionId;
  }

  public void setExecutionId(@javax.annotation.Nullable String executionId) {
    this.executionId = JsonNullable.<String>of(executionId);
  }

  public Trigger updatedDate(@javax.annotation.Nullable OffsetDateTime updatedDate) {
    this.updatedDate = JsonNullable.<OffsetDateTime>of(updatedDate);
    
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public OffsetDateTime getUpdatedDate() {
        return updatedDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATED_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getUpdatedDate_JsonNullable() {
    return updatedDate;
  }
  
  @JsonProperty(JSON_PROPERTY_UPDATED_DATE)
  public void setUpdatedDate_JsonNullable(JsonNullable<OffsetDateTime> updatedDate) {
    this.updatedDate = updatedDate;
  }

  public void setUpdatedDate(@javax.annotation.Nullable OffsetDateTime updatedDate) {
    this.updatedDate = JsonNullable.<OffsetDateTime>of(updatedDate);
  }

  public Trigger evaluateRunningDate(@javax.annotation.Nullable OffsetDateTime evaluateRunningDate) {
    this.evaluateRunningDate = JsonNullable.<OffsetDateTime>of(evaluateRunningDate);
    
    return this;
  }

  /**
   * Get evaluateRunningDate
   * @return evaluateRunningDate
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public OffsetDateTime getEvaluateRunningDate() {
        return evaluateRunningDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVALUATE_RUNNING_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<OffsetDateTime> getEvaluateRunningDate_JsonNullable() {
    return evaluateRunningDate;
  }
  
  @JsonProperty(JSON_PROPERTY_EVALUATE_RUNNING_DATE)
  public void setEvaluateRunningDate_JsonNullable(JsonNullable<OffsetDateTime> evaluateRunningDate) {
    this.evaluateRunningDate = evaluateRunningDate;
  }

  public void setEvaluateRunningDate(@javax.annotation.Nullable OffsetDateTime evaluateRunningDate) {
    this.evaluateRunningDate = JsonNullable.<OffsetDateTime>of(evaluateRunningDate);
  }

  public Trigger workerId(@javax.annotation.Nullable String workerId) {
    this.workerId = JsonNullable.<String>of(workerId);
    
    return this;
  }

  /**
   * Get workerId
   * @return workerId
   */
  @javax.annotation.Nullable
  @JsonIgnore

  public String getWorkerId() {
        return workerId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WORKER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getWorkerId_JsonNullable() {
    return workerId;
  }
  
  @JsonProperty(JSON_PROPERTY_WORKER_ID)
  public void setWorkerId_JsonNullable(JsonNullable<String> workerId) {
    this.workerId = workerId;
  }

  public void setWorkerId(@javax.annotation.Nullable String workerId) {
    this.workerId = JsonNullable.<String>of(workerId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trigger trigger = (Trigger) o;
    return Objects.equals(this.disabled, trigger.disabled) &&
        Objects.equals(this.tenantId, trigger.tenantId) &&
        Objects.equals(this.namespace, trigger.namespace) &&
        Objects.equals(this.flowId, trigger.flowId) &&
        Objects.equals(this.triggerId, trigger.triggerId) &&
        Objects.equals(this.date, trigger.date) &&
        equalsNullable(this.nextExecutionDate, trigger.nextExecutionDate) &&
        equalsNullable(this.backfill, trigger.backfill) &&
        equalsNullable(this.stopAfter, trigger.stopAfter) &&
        equalsNullable(this.executionId, trigger.executionId) &&
        equalsNullable(this.updatedDate, trigger.updatedDate) &&
        equalsNullable(this.evaluateRunningDate, trigger.evaluateRunningDate) &&
        equalsNullable(this.workerId, trigger.workerId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabled, tenantId, namespace, flowId, triggerId, date, hashCodeNullable(nextExecutionDate), hashCodeNullable(backfill), hashCodeNullable(stopAfter), hashCodeNullable(executionId), hashCodeNullable(updatedDate), hashCodeNullable(evaluateRunningDate), hashCodeNullable(workerId));
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
    sb.append("class Trigger {\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    triggerId: ").append(toIndentedString(triggerId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    nextExecutionDate: ").append(toIndentedString(nextExecutionDate)).append("\n");
    sb.append("    backfill: ").append(toIndentedString(backfill)).append("\n");
    sb.append("    stopAfter: ").append(toIndentedString(stopAfter)).append("\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    evaluateRunningDate: ").append(toIndentedString(evaluateRunningDate)).append("\n");
    sb.append("    workerId: ").append(toIndentedString(workerId)).append("\n");
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

    // add `disabled` to the URL query string
    if (getDisabled() != null) {
      try {
        joiner.add(String.format("%sdisabled%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDisabled()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `tenantId` to the URL query string
    if (getTenantId() != null) {
      try {
        joiner.add(String.format("%stenantId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTenantId()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `triggerId` to the URL query string
    if (getTriggerId() != null) {
      try {
        joiner.add(String.format("%striggerId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTriggerId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `date` to the URL query string
    if (getDate() != null) {
      try {
        joiner.add(String.format("%sdate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `nextExecutionDate` to the URL query string
    if (getNextExecutionDate() != null) {
      try {
        joiner.add(String.format("%snextExecutionDate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getNextExecutionDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `backfill` to the URL query string
    if (getBackfill() != null) {
      joiner.add(getBackfill().toUrlQueryString(prefix + "backfill" + suffix));
    }

    // add `stopAfter` to the URL query string
    if (getStopAfter() != null) {
      for (int i = 0; i < getStopAfter().size(); i++) {
        if (getStopAfter().get(i) != null) {
          try {
            joiner.add(String.format("%sstopAfter%s%s=%s", prefix, suffix,
                "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
                URLEncoder.encode(String.valueOf(getStopAfter().get(i)), "UTF-8").replaceAll("\\+", "%20")));
          } catch (UnsupportedEncodingException e) {
            // Should never happen, UTF-8 is always supported
            throw new RuntimeException(e);
          }
        }
      }
    }

    // add `executionId` to the URL query string
    if (getExecutionId() != null) {
      try {
        joiner.add(String.format("%sexecutionId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getExecutionId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `updatedDate` to the URL query string
    if (getUpdatedDate() != null) {
      try {
        joiner.add(String.format("%supdatedDate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getUpdatedDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `evaluateRunningDate` to the URL query string
    if (getEvaluateRunningDate() != null) {
      try {
        joiner.add(String.format("%sevaluateRunningDate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEvaluateRunningDate()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `workerId` to the URL query string
    if (getWorkerId() != null) {
      try {
        joiner.add(String.format("%sworkerId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getWorkerId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

