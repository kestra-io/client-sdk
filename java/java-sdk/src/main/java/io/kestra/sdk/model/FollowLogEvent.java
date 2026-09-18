/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.OffsetDateTime;

/**
 * FollowLogEvent
 */
@JsonPropertyOrder({
  FollowLogEvent.JSON_PROPERTY_TENANT_ID,
  FollowLogEvent.JSON_PROPERTY_NAMESPACE,
  FollowLogEvent.JSON_PROPERTY_FLOW_ID,
  FollowLogEvent.JSON_PROPERTY_TASK_ID,
  FollowLogEvent.JSON_PROPERTY_EXECUTION_ID,
  FollowLogEvent.JSON_PROPERTY_TASK_RUN_ID,
  FollowLogEvent.JSON_PROPERTY_ATTEMPT_NUMBER,
  FollowLogEvent.JSON_PROPERTY_TRIGGER_ID,
  FollowLogEvent.JSON_PROPERTY_TIMESTAMP,
  FollowLogEvent.JSON_PROPERTY_LEVEL,
  FollowLogEvent.JSON_PROPERTY_THREAD,
  FollowLogEvent.JSON_PROPERTY_MESSAGE,
  FollowLogEvent.JSON_PROPERTY_EXECUTION_KIND
})
public class FollowLogEvent {
  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  @jakarta.annotation.Nullable  private String tenantId;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @jakarta.annotation.Nullable  private String namespace;

  public static final String JSON_PROPERTY_FLOW_ID = "flowId";
  @jakarta.annotation.Nullable  private String flowId;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @jakarta.annotation.Nullable  private String taskId;

  public static final String JSON_PROPERTY_EXECUTION_ID = "executionId";
  @jakarta.annotation.Nullable  private String executionId;

  public static final String JSON_PROPERTY_TASK_RUN_ID = "taskRunId";
  @jakarta.annotation.Nullable  private String taskRunId;

  public static final String JSON_PROPERTY_ATTEMPT_NUMBER = "attemptNumber";
  @jakarta.annotation.Nullable  private Integer attemptNumber;

  public static final String JSON_PROPERTY_TRIGGER_ID = "triggerId";
  @jakarta.annotation.Nullable  private String triggerId;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  @jakarta.annotation.Nullable  private OffsetDateTime timestamp;

  public static final String JSON_PROPERTY_LEVEL = "level";
  @jakarta.annotation.Nullable  private Level level;

  public static final String JSON_PROPERTY_THREAD = "thread";
  @jakarta.annotation.Nullable  private String thread;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @jakarta.annotation.Nullable  private String message;

  public static final String JSON_PROPERTY_EXECUTION_KIND = "executionKind";
  @jakarta.annotation.Nullable  private ExecutionKind executionKind;

  public FollowLogEvent() {
  }

  public FollowLogEvent tenantId(@jakarta.annotation.Nullable String tenantId) {

    this.tenantId = tenantId;
    return this;
  }

  /**
   * Get tenantId
   * @return tenantId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTenantId() {
    return tenantId;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenantId(@jakarta.annotation.Nullable String tenantId) {
    this.tenantId = tenantId;
  }

  public FollowLogEvent namespace(@jakarta.annotation.Nullable String namespace) {

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

  public FollowLogEvent flowId(@jakarta.annotation.Nullable String flowId) {

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

  public FollowLogEvent taskId(@jakarta.annotation.Nullable String taskId) {

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

  public FollowLogEvent executionId(@jakarta.annotation.Nullable String executionId) {

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

  public FollowLogEvent taskRunId(@jakarta.annotation.Nullable String taskRunId) {

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

  public FollowLogEvent attemptNumber(@jakarta.annotation.Nullable Integer attemptNumber) {

    this.attemptNumber = attemptNumber;
    return this;
  }

  /**
   * Get attemptNumber
   * @return attemptNumber
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_ATTEMPT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAttemptNumber() {
    return attemptNumber;
  }


  @JsonProperty(JSON_PROPERTY_ATTEMPT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttemptNumber(@jakarta.annotation.Nullable Integer attemptNumber) {
    this.attemptNumber = attemptNumber;
  }

  public FollowLogEvent triggerId(@jakarta.annotation.Nullable String triggerId) {

    this.triggerId = triggerId;
    return this;
  }

  /**
   * Get triggerId
   * @return triggerId
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TRIGGER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTriggerId() {
    return triggerId;
  }


  @JsonProperty(JSON_PROPERTY_TRIGGER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTriggerId(@jakarta.annotation.Nullable String triggerId) {
    this.triggerId = triggerId;
  }

  public FollowLogEvent timestamp(@jakarta.annotation.Nullable OffsetDateTime timestamp) {

    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimestamp(@jakarta.annotation.Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public FollowLogEvent level(@jakarta.annotation.Nullable Level level) {

    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Level getLevel() {
    return level;
  }


  @JsonProperty(JSON_PROPERTY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLevel(@jakarta.annotation.Nullable Level level) {
    this.level = level;
  }

  public FollowLogEvent thread(@jakarta.annotation.Nullable String thread) {

    this.thread = thread;
    return this;
  }

  /**
   * Get thread
   * @return thread
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_THREAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getThread() {
    return thread;
  }


  @JsonProperty(JSON_PROPERTY_THREAD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThread(@jakarta.annotation.Nullable String thread) {
    this.thread = thread;
  }

  public FollowLogEvent message(@jakarta.annotation.Nullable String message) {

    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(@jakarta.annotation.Nullable String message) {
    this.message = message;
  }

  public FollowLogEvent executionKind(@jakarta.annotation.Nullable ExecutionKind executionKind) {

    this.executionKind = executionKind;
    return this;
  }

  /**
   * Get executionKind
   * @return executionKind
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_EXECUTION_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ExecutionKind getExecutionKind() {
    return executionKind;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTION_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutionKind(@jakarta.annotation.Nullable ExecutionKind executionKind) {
    this.executionKind = executionKind;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FollowLogEvent followLogEvent = (FollowLogEvent) o;
    return Objects.equals(this.tenantId, followLogEvent.tenantId) &&
        Objects.equals(this.namespace, followLogEvent.namespace) &&
        Objects.equals(this.flowId, followLogEvent.flowId) &&
        Objects.equals(this.taskId, followLogEvent.taskId) &&
        Objects.equals(this.executionId, followLogEvent.executionId) &&
        Objects.equals(this.taskRunId, followLogEvent.taskRunId) &&
        Objects.equals(this.attemptNumber, followLogEvent.attemptNumber) &&
        Objects.equals(this.triggerId, followLogEvent.triggerId) &&
        Objects.equals(this.timestamp, followLogEvent.timestamp) &&
        Objects.equals(this.level, followLogEvent.level) &&
        Objects.equals(this.thread, followLogEvent.thread) &&
        Objects.equals(this.message, followLogEvent.message) &&
        Objects.equals(this.executionKind, followLogEvent.executionKind);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, namespace, flowId, taskId, executionId, taskRunId, attemptNumber, triggerId, timestamp, level, thread, message, executionKind);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FollowLogEvent {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    taskRunId: ").append(toIndentedString(taskRunId)).append("\n");
    sb.append("    attemptNumber: ").append(toIndentedString(attemptNumber)).append("\n");
    sb.append("    triggerId: ").append(toIndentedString(triggerId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    thread: ").append(toIndentedString(thread)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    executionKind: ").append(toIndentedString(executionKind)).append("\n");
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

