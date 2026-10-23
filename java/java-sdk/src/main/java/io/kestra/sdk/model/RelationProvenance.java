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
 * RelationProvenance
 */
@JsonPropertyOrder({
  RelationProvenance.JSON_PROPERTY_NAMESPACE,
  RelationProvenance.JSON_PROPERTY_FLOW_ID,
  RelationProvenance.JSON_PROPERTY_FLOW_REVISION,
  RelationProvenance.JSON_PROPERTY_EXECUTION_ID,
  RelationProvenance.JSON_PROPERTY_TASK_ID,
  RelationProvenance.JSON_PROPERTY_TASK_RUN_ID,
  RelationProvenance.JSON_PROPERTY_TASK_TYPE,
  RelationProvenance.JSON_PROPERTY_STATE,
  RelationProvenance.JSON_PROPERTY_START_DATE,
  RelationProvenance.JSON_PROPERTY_END_DATE
})
public class RelationProvenance {
  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @jakarta.annotation.Nullable  private String flowId;

  public static final String JSON_PROPERTY_FLOW_REVISION = "flowRevision";
  @jakarta.annotation.Nullable  private Integer flowRevision;

  public static final String JSON_PROPERTY_EXECUTION_ID = "executionId";
  @jakarta.annotation.Nullable  private String executionId;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @jakarta.annotation.Nullable  private String taskId;

  public static final String JSON_PROPERTY_TASK_RUN_ID = "taskRunId";
  @jakarta.annotation.Nullable  private String taskRunId;

  public static final String JSON_PROPERTY_TASK_TYPE = "taskType";
  @jakarta.annotation.Nullable  private String taskType;

  public static final String JSON_PROPERTY_STATE = "state";
  @jakarta.annotation.Nullable  private StateType state;

  public static final String JSON_PROPERTY_START_DATE = "startDate";
  @jakarta.annotation.Nullable  private OffsetDateTime startDate;

  public static final String JSON_PROPERTY_END_DATE = "endDate";
  @jakarta.annotation.Nullable  private OffsetDateTime endDate;

  public RelationProvenance() {
  }

  public RelationProvenance namespace(@jakarta.annotation.Nullable String namespace) {
    
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

  public RelationProvenance flowId(@jakarta.annotation.Nullable String flowId) {
    
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

  public RelationProvenance flowRevision(@jakarta.annotation.Nullable Integer flowRevision) {
    
    this.flowRevision = flowRevision;
    return this;
  }

  /**
   * Get flowRevision
   * @return flowRevision
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_FLOW_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getFlowRevision() {
    return flowRevision;
  }


  @JsonProperty(JSON_PROPERTY_FLOW_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFlowRevision(@jakarta.annotation.Nullable Integer flowRevision) {
    this.flowRevision = flowRevision;
  }

  public RelationProvenance executionId(@jakarta.annotation.Nullable String executionId) {
    
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

  public RelationProvenance taskId(@jakarta.annotation.Nullable String taskId) {
    
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

  public RelationProvenance taskRunId(@jakarta.annotation.Nullable String taskRunId) {
    
    this.taskRunId = taskRunId;
    return this;
  }

  /**
   * Get taskRunId
   * @return taskRunId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TASK_RUN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskRunId() {
    return taskRunId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_RUN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskRunId(@jakarta.annotation.Nullable String taskRunId) {
    this.taskRunId = taskRunId;
  }

  public RelationProvenance taskType(@jakarta.annotation.Nullable String taskType) {
    
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

  public RelationProvenance state(@jakarta.annotation.Nullable StateType state) {
    
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

  public RelationProvenance startDate(@jakarta.annotation.Nullable OffsetDateTime startDate) {
    
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getStartDate() {
    return startDate;
  }


  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartDate(@jakarta.annotation.Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public RelationProvenance endDate(@jakarta.annotation.Nullable OffsetDateTime endDate) {
    
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_END_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getEndDate() {
    return endDate;
  }


  @JsonProperty(JSON_PROPERTY_END_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndDate(@jakarta.annotation.Nullable OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationProvenance relationProvenance = (RelationProvenance) o;
    return Objects.equals(this.namespace, relationProvenance.namespace) &&
        Objects.equals(this.flowId, relationProvenance.flowId) &&
        Objects.equals(this.flowRevision, relationProvenance.flowRevision) &&
        Objects.equals(this.executionId, relationProvenance.executionId) &&
        Objects.equals(this.taskId, relationProvenance.taskId) &&
        Objects.equals(this.taskRunId, relationProvenance.taskRunId) &&
        Objects.equals(this.taskType, relationProvenance.taskType) &&
        Objects.equals(this.state, relationProvenance.state) &&
        Objects.equals(this.startDate, relationProvenance.startDate) &&
        Objects.equals(this.endDate, relationProvenance.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, flowId, flowRevision, executionId, taskId, taskRunId, taskType, state, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationProvenance {\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    flowRevision: ").append(toIndentedString(flowRevision)).append("\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    taskRunId: ").append(toIndentedString(taskRunId)).append("\n");
    sb.append("    taskType: ").append(toIndentedString(taskType)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
