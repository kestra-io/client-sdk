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
import io.kestra.sdk.model.StateType;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AssetWriteSummary
 */
@JsonPropertyOrder({
  AssetWriteSummary.JSON_PROPERTY_EXECUTION_ID,
  AssetWriteSummary.JSON_PROPERTY_NAMESPACE,
  AssetWriteSummary.JSON_PROPERTY_FLOW_ID,
  AssetWriteSummary.JSON_PROPERTY_TASK_ID,
  AssetWriteSummary.JSON_PROPERTY_TASK_TYPE,
  AssetWriteSummary.JSON_PROPERTY_STATE,
  AssetWriteSummary.JSON_PROPERTY_CREATED
})
public class AssetWriteSummary {
  public static final String JSON_PROPERTY_EXECUTION_ID = "executionId";
  @jakarta.annotation.Nullable  private String executionId;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @jakarta.annotation.Nullable  private String flowId;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @jakarta.annotation.Nullable  private String taskId;

  public static final String JSON_PROPERTY_TASK_TYPE = "taskType";
  @jakarta.annotation.Nullable  private String taskType;

  public static final String JSON_PROPERTY_STATE = "state";
  @jakarta.annotation.Nullable  private StateType state;

  public static final String JSON_PROPERTY_CREATED = "created";
  @jakarta.annotation.Nullable  private OffsetDateTime created;

  public AssetWriteSummary() {
  }

  public AssetWriteSummary executionId(@jakarta.annotation.Nullable String executionId) {
    
    this.executionId = executionId;
    return this;
  }

  /**
   * Get executionId
   * @return executionId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExecutionId() {
    return executionId;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutionId(@jakarta.annotation.Nullable String executionId) {
    this.executionId = executionId;
  }

  public AssetWriteSummary namespace(@jakarta.annotation.Nullable String namespace) {
    
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

  public AssetWriteSummary flowId(@jakarta.annotation.Nullable String flowId) {
    
    this.flowId = flowId;
    return this;
  }

  /**
   * Get flowId
   * @return flowId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFlowId() {
    return flowId;
  }


  @JsonProperty(JSON_PROPERTY_FLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFlowId(@jakarta.annotation.Nullable String flowId) {
    this.flowId = flowId;
  }

  public AssetWriteSummary taskId(@jakarta.annotation.Nullable String taskId) {
    
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskId() {
    return taskId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskId(@jakarta.annotation.Nullable String taskId) {
    this.taskId = taskId;
  }

  public AssetWriteSummary taskType(@jakarta.annotation.Nullable String taskType) {
    
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

  public AssetWriteSummary state(@jakarta.annotation.Nullable StateType state) {
    
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StateType getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(@jakarta.annotation.Nullable StateType state) {
    this.state = state;
  }

  public AssetWriteSummary created(@jakarta.annotation.Nullable OffsetDateTime created) {
    
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetWriteSummary assetWriteSummary = (AssetWriteSummary) o;
    return Objects.equals(this.executionId, assetWriteSummary.executionId) &&
        Objects.equals(this.namespace, assetWriteSummary.namespace) &&
        Objects.equals(this.flowId, assetWriteSummary.flowId) &&
        Objects.equals(this.taskId, assetWriteSummary.taskId) &&
        Objects.equals(this.taskType, assetWriteSummary.taskType) &&
        Objects.equals(this.state, assetWriteSummary.state) &&
        Objects.equals(this.created, assetWriteSummary.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executionId, namespace, flowId, taskId, taskType, state, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetWriteSummary {\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    taskType: ").append(toIndentedString(taskType)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
