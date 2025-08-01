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
import io.kestra.sdk.model.AbstractTrigger;
import io.kestra.sdk.model.Concurrency;
import io.kestra.sdk.model.FlowWithSourceAllOfLabels;
import io.kestra.sdk.model.InputObject;
import io.kestra.sdk.model.Listener;
import io.kestra.sdk.model.Output;
import io.kestra.sdk.model.PluginDefault;
import io.kestra.sdk.model.SLA;
import io.kestra.sdk.model.Task;
import io.kestra.sdk.model.WorkerGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * FlowWithSource
 */
@JsonPropertyOrder({
  FlowWithSource.JSON_PROPERTY_ID,
  FlowWithSource.JSON_PROPERTY_NAMESPACE,
  FlowWithSource.JSON_PROPERTY_REVISION,
  FlowWithSource.JSON_PROPERTY_INPUTS,
  FlowWithSource.JSON_PROPERTY_OUTPUTS,
  FlowWithSource.JSON_PROPERTY_DISABLED,
  FlowWithSource.JSON_PROPERTY_LABELS,
  FlowWithSource.JSON_PROPERTY_VARIABLES,
  FlowWithSource.JSON_PROPERTY_WORKER_GROUP,
  FlowWithSource.JSON_PROPERTY_DELETED,
  FlowWithSource.JSON_PROPERTY_FINALLY,
  FlowWithSource.JSON_PROPERTY_TASK_DEFAULTS,
  FlowWithSource.JSON_PROPERTY_DESCRIPTION,
  FlowWithSource.JSON_PROPERTY_TASKS,
  FlowWithSource.JSON_PROPERTY_ERRORS,
  FlowWithSource.JSON_PROPERTY_LISTENERS,
  FlowWithSource.JSON_PROPERTY_AFTER_EXECUTION,
  FlowWithSource.JSON_PROPERTY_TRIGGERS,
  FlowWithSource.JSON_PROPERTY_PLUGIN_DEFAULTS,
  FlowWithSource.JSON_PROPERTY_CONCURRENCY,
  FlowWithSource.JSON_PROPERTY_RETRY,
  FlowWithSource.JSON_PROPERTY_SLA
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class FlowWithSource {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nonnull
  private String id;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nonnull
  private String namespace;

  public static final String JSON_PROPERTY_REVISION = "revision";
  @javax.annotation.Nullable
  private Integer revision;

  public static final String JSON_PROPERTY_INPUTS = "inputs";
  @javax.annotation.Nullable
  private List<InputObject> inputs = new ArrayList<>();

  public static final String JSON_PROPERTY_OUTPUTS = "outputs";
  @javax.annotation.Nullable
  private List<Output> outputs = new ArrayList<>();

  public static final String JSON_PROPERTY_DISABLED = "disabled";
  @javax.annotation.Nonnull
  private Boolean disabled;

  public static final String JSON_PROPERTY_LABELS = "labels";
  @javax.annotation.Nullable
  private FlowWithSourceAllOfLabels labels;

  public static final String JSON_PROPERTY_VARIABLES = "variables";
  @javax.annotation.Nullable
  private Map<String, Object> variables = new HashMap<>();

  public static final String JSON_PROPERTY_WORKER_GROUP = "workerGroup";
  @javax.annotation.Nullable
  private WorkerGroup workerGroup;

  public static final String JSON_PROPERTY_DELETED = "deleted";
  @javax.annotation.Nonnull
  private Boolean deleted;

  public static final String JSON_PROPERTY_FINALLY = "finally";
  @javax.annotation.Nullable
  private List<Task> _finally = new ArrayList<>();

  public static final String JSON_PROPERTY_TASK_DEFAULTS = "taskDefaults";
  @javax.annotation.Nullable
  private List<PluginDefault> taskDefaults = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nullable
  private String description;

  public static final String JSON_PROPERTY_TASKS = "tasks";
  @javax.annotation.Nonnull
  private List<Task> tasks = new ArrayList<>();

  public static final String JSON_PROPERTY_ERRORS = "errors";
  @javax.annotation.Nullable
  private List<Task> errors = new ArrayList<>();

  public static final String JSON_PROPERTY_LISTENERS = "listeners";
  @javax.annotation.Nullable
  private List<Listener> listeners = new ArrayList<>();

  public static final String JSON_PROPERTY_AFTER_EXECUTION = "afterExecution";
  @javax.annotation.Nullable
  private List<Task> afterExecution = new ArrayList<>();

  public static final String JSON_PROPERTY_TRIGGERS = "triggers";
  @javax.annotation.Nullable
  private List<AbstractTrigger> triggers = new ArrayList<>();

  public static final String JSON_PROPERTY_PLUGIN_DEFAULTS = "pluginDefaults";
  @javax.annotation.Nullable
  private List<PluginDefault> pluginDefaults = new ArrayList<>();

  public static final String JSON_PROPERTY_CONCURRENCY = "concurrency";
  @javax.annotation.Nullable
  private Concurrency concurrency;

  public static final String JSON_PROPERTY_RETRY = "retry";
  @javax.annotation.Nullable
  private Object retry;

  public static final String JSON_PROPERTY_SLA = "sla";
  @javax.annotation.Nullable
  private List<SLA> sla = new ArrayList<>();

  public FlowWithSource() {
  }

  public FlowWithSource id(@javax.annotation.Nonnull String id) {

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(@javax.annotation.Nonnull String id) {
    this.id = id;
  }

  public FlowWithSource namespace(@javax.annotation.Nonnull String namespace) {

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

  public FlowWithSource revision(@javax.annotation.Nullable Integer revision) {

    this.revision = revision;
    return this;
  }

  /**
   * Get revision
   * minimum: 1
   * @return revision
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRevision() {
    return revision;
  }


  @JsonProperty(JSON_PROPERTY_REVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRevision(@javax.annotation.Nullable Integer revision) {
    this.revision = revision;
  }

  public FlowWithSource inputs(@javax.annotation.Nullable List<InputObject> inputs) {

    this.inputs = inputs;
    return this;
  }

  public FlowWithSource addInputsItem(InputObject inputsItem) {
    if (this.inputs == null) {
      this.inputs = new ArrayList<>();
    }
    this.inputs.add(inputsItem);
    return this;
  }

  /**
   * Get inputs
   * @return inputs
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INPUTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<InputObject> getInputs() {
    return inputs;
  }


  @JsonProperty(JSON_PROPERTY_INPUTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInputs(@javax.annotation.Nullable List<InputObject> inputs) {
    this.inputs = inputs;
  }

  public FlowWithSource outputs(@javax.annotation.Nullable List<Output> outputs) {

    this.outputs = outputs;
    return this;
  }

  public FlowWithSource addOutputsItem(Output outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

  /**
   * Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages.
   * @return outputs
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OUTPUTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Output> getOutputs() {
    return outputs;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutputs(@javax.annotation.Nullable List<Output> outputs) {
    this.outputs = outputs;
  }

  public FlowWithSource disabled(@javax.annotation.Nonnull Boolean disabled) {

    this.disabled = disabled;
    return this;
  }

  /**
   * Get disabled
   * @return disabled
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getDisabled() {
    return disabled;
  }


  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDisabled(@javax.annotation.Nonnull Boolean disabled) {
    this.disabled = disabled;
  }

  public FlowWithSource labels(@javax.annotation.Nullable FlowWithSourceAllOfLabels labels) {

    this.labels = labels;
    return this;
  }

  /**
   * Get labels
   * @return labels
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FlowWithSourceAllOfLabels getLabels() {
    return labels;
  }


  @JsonProperty(JSON_PROPERTY_LABELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabels(@javax.annotation.Nullable FlowWithSourceAllOfLabels labels) {
    this.labels = labels;
  }

  public FlowWithSource variables(@javax.annotation.Nullable Map<String, Object> variables) {

    this.variables = variables;
    return this;
  }

  public FlowWithSource putVariablesItem(String key, Object variablesItem) {
    if (this.variables == null) {
      this.variables = new HashMap<>();
    }
    this.variables.put(key, variablesItem);
    return this;
  }

  /**
   * Get variables
   * @return variables
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getVariables() {
    return variables;
  }


  @JsonProperty(JSON_PROPERTY_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVariables(@javax.annotation.Nullable Map<String, Object> variables) {
    this.variables = variables;
  }

  public FlowWithSource workerGroup(@javax.annotation.Nullable WorkerGroup workerGroup) {

    this.workerGroup = workerGroup;
    return this;
  }

  /**
   * Get workerGroup
   * @return workerGroup
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_WORKER_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WorkerGroup getWorkerGroup() {
    return workerGroup;
  }


  @JsonProperty(JSON_PROPERTY_WORKER_GROUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWorkerGroup(@javax.annotation.Nullable WorkerGroup workerGroup) {
    this.workerGroup = workerGroup;
  }

  public FlowWithSource deleted(@javax.annotation.Nonnull Boolean deleted) {

    this.deleted = deleted;
    return this;
  }

  /**
   * Get deleted
   * @return deleted
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DELETED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getDeleted() {
    return deleted;
  }


  @JsonProperty(JSON_PROPERTY_DELETED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDeleted(@javax.annotation.Nonnull Boolean deleted) {
    this.deleted = deleted;
  }

  public FlowWithSource _finally(@javax.annotation.Nullable List<Task> _finally) {

    this._finally = _finally;
    return this;
  }

  public FlowWithSource addFinallyItem(Task _finallyItem) {
    if (this._finally == null) {
      this._finally = new ArrayList<>();
    }
    this._finally.add(_finallyItem);
    return this;
  }

  /**
   * Get _finally
   * @return _finally
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FINALLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Task> getFinally() {
    return _finally;
  }


  @JsonProperty(JSON_PROPERTY_FINALLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFinally(@javax.annotation.Nullable List<Task> _finally) {
    this._finally = _finally;
  }

  public FlowWithSource taskDefaults(@javax.annotation.Nullable List<PluginDefault> taskDefaults) {

    this.taskDefaults = taskDefaults;
    return this;
  }

  public FlowWithSource addTaskDefaultsItem(PluginDefault taskDefaultsItem) {
    if (this.taskDefaults == null) {
      this.taskDefaults = new ArrayList<>();
    }
    this.taskDefaults.add(taskDefaultsItem);
    return this;
  }

  /**
   * Get taskDefaults
   * @return taskDefaults
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PluginDefault> getTaskDefaults() {
    return taskDefaults;
  }


  @JsonProperty(JSON_PROPERTY_TASK_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskDefaults(@javax.annotation.Nullable List<PluginDefault> taskDefaults) {
    this.taskDefaults = taskDefaults;
  }

  public FlowWithSource description(@javax.annotation.Nullable String description) {

    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@javax.annotation.Nullable String description) {
    this.description = description;
  }

  public FlowWithSource tasks(@javax.annotation.Nonnull List<Task> tasks) {

    this.tasks = tasks;
    return this;
  }

  public FlowWithSource addTasksItem(Task tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * Get tasks
   * @return tasks
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TASKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Task> getTasks() {
    return tasks;
  }


  @JsonProperty(JSON_PROPERTY_TASKS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTasks(@javax.annotation.Nonnull List<Task> tasks) {
    this.tasks = tasks;
  }

  public FlowWithSource errors(@javax.annotation.Nullable List<Task> errors) {

    this.errors = errors;
    return this;
  }

  public FlowWithSource addErrorsItem(Task errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Task> getErrors() {
    return errors;
  }


  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrors(@javax.annotation.Nullable List<Task> errors) {
    this.errors = errors;
  }

  public FlowWithSource listeners(@javax.annotation.Nullable List<Listener> listeners) {

    this.listeners = listeners;
    return this;
  }

  public FlowWithSource addListenersItem(Listener listenersItem) {
    if (this.listeners == null) {
      this.listeners = new ArrayList<>();
    }
    this.listeners.add(listenersItem);
    return this;
  }

  /**
   * Get listeners
   * @return listeners
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LISTENERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Listener> getListeners() {
    return listeners;
  }


  @JsonProperty(JSON_PROPERTY_LISTENERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setListeners(@javax.annotation.Nullable List<Listener> listeners) {
    this.listeners = listeners;
  }

  public FlowWithSource afterExecution(@javax.annotation.Nullable List<Task> afterExecution) {

    this.afterExecution = afterExecution;
    return this;
  }

  public FlowWithSource addAfterExecutionItem(Task afterExecutionItem) {
    if (this.afterExecution == null) {
      this.afterExecution = new ArrayList<>();
    }
    this.afterExecution.add(afterExecutionItem);
    return this;
  }

  /**
   * Get afterExecution
   * @return afterExecution
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_AFTER_EXECUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Task> getAfterExecution() {
    return afterExecution;
  }


  @JsonProperty(JSON_PROPERTY_AFTER_EXECUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAfterExecution(@javax.annotation.Nullable List<Task> afterExecution) {
    this.afterExecution = afterExecution;
  }

  public FlowWithSource triggers(@javax.annotation.Nullable List<AbstractTrigger> triggers) {

    this.triggers = triggers;
    return this;
  }

  public FlowWithSource addTriggersItem(AbstractTrigger triggersItem) {
    if (this.triggers == null) {
      this.triggers = new ArrayList<>();
    }
    this.triggers.add(triggersItem);
    return this;
  }

  /**
   * Get triggers
   * @return triggers
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRIGGERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AbstractTrigger> getTriggers() {
    return triggers;
  }


  @JsonProperty(JSON_PROPERTY_TRIGGERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTriggers(@javax.annotation.Nullable List<AbstractTrigger> triggers) {
    this.triggers = triggers;
  }

  public FlowWithSource pluginDefaults(@javax.annotation.Nullable List<PluginDefault> pluginDefaults) {

    this.pluginDefaults = pluginDefaults;
    return this;
  }

  public FlowWithSource addPluginDefaultsItem(PluginDefault pluginDefaultsItem) {
    if (this.pluginDefaults == null) {
      this.pluginDefaults = new ArrayList<>();
    }
    this.pluginDefaults.add(pluginDefaultsItem);
    return this;
  }

  /**
   * Get pluginDefaults
   * @return pluginDefaults
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PLUGIN_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PluginDefault> getPluginDefaults() {
    return pluginDefaults;
  }


  @JsonProperty(JSON_PROPERTY_PLUGIN_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPluginDefaults(@javax.annotation.Nullable List<PluginDefault> pluginDefaults) {
    this.pluginDefaults = pluginDefaults;
  }

  public FlowWithSource concurrency(@javax.annotation.Nullable Concurrency concurrency) {

    this.concurrency = concurrency;
    return this;
  }

  /**
   * Get concurrency
   * @return concurrency
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONCURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Concurrency getConcurrency() {
    return concurrency;
  }


  @JsonProperty(JSON_PROPERTY_CONCURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConcurrency(@javax.annotation.Nullable Concurrency concurrency) {
    this.concurrency = concurrency;
  }

  public FlowWithSource retry(@javax.annotation.Nullable Object retry) {

    this.retry = retry;
    return this;
  }

  /**
   * Get retry
   * @return retry
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RETRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getRetry() {
    return retry;
  }


  @JsonProperty(JSON_PROPERTY_RETRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRetry(@javax.annotation.Nullable Object retry) {
    this.retry = retry;
  }

  public FlowWithSource sla(@javax.annotation.Nullable List<SLA> sla) {

    this.sla = sla;
    return this;
  }

  public FlowWithSource addSlaItem(SLA slaItem) {
    if (this.sla == null) {
      this.sla = new ArrayList<>();
    }
    this.sla.add(slaItem);
    return this;
  }

  /**
   * Get sla
   * @return sla
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SLA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SLA> getSla() {
    return sla;
  }


  @JsonProperty(JSON_PROPERTY_SLA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSla(@javax.annotation.Nullable List<SLA> sla) {
    this.sla = sla;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowWithSource flowWithSource = (FlowWithSource) o;
    return Objects.equals(this.id, flowWithSource.id) &&
        Objects.equals(this.namespace, flowWithSource.namespace) &&
        Objects.equals(this.revision, flowWithSource.revision) &&
        Objects.equals(this.inputs, flowWithSource.inputs) &&
        Objects.equals(this.outputs, flowWithSource.outputs) &&
        Objects.equals(this.disabled, flowWithSource.disabled) &&
        Objects.equals(this.labels, flowWithSource.labels) &&
        Objects.equals(this.variables, flowWithSource.variables) &&
        Objects.equals(this.workerGroup, flowWithSource.workerGroup) &&
        Objects.equals(this.deleted, flowWithSource.deleted) &&
        Objects.equals(this._finally, flowWithSource._finally) &&
        Objects.equals(this.taskDefaults, flowWithSource.taskDefaults) &&
        Objects.equals(this.description, flowWithSource.description) &&
        Objects.equals(this.tasks, flowWithSource.tasks) &&
        Objects.equals(this.errors, flowWithSource.errors) &&
        Objects.equals(this.listeners, flowWithSource.listeners) &&
        Objects.equals(this.afterExecution, flowWithSource.afterExecution) &&
        Objects.equals(this.triggers, flowWithSource.triggers) &&
        Objects.equals(this.pluginDefaults, flowWithSource.pluginDefaults) &&
        Objects.equals(this.concurrency, flowWithSource.concurrency) &&
        Objects.equals(this.retry, flowWithSource.retry) &&
        Objects.equals(this.sla, flowWithSource.sla);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, namespace, revision, inputs, outputs, disabled, labels, variables, workerGroup, deleted, _finally, taskDefaults, description, tasks, errors, listeners, afterExecution, triggers, pluginDefaults, concurrency, retry, sla);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowWithSource {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
    sb.append("    workerGroup: ").append(toIndentedString(workerGroup)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _finally: ").append(toIndentedString(_finally)).append("\n");
    sb.append("    taskDefaults: ").append(toIndentedString(taskDefaults)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    listeners: ").append(toIndentedString(listeners)).append("\n");
    sb.append("    afterExecution: ").append(toIndentedString(afterExecution)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
    sb.append("    pluginDefaults: ").append(toIndentedString(pluginDefaults)).append("\n");
    sb.append("    concurrency: ").append(toIndentedString(concurrency)).append("\n");
    sb.append("    retry: ").append(toIndentedString(retry)).append("\n");
    sb.append("    sla: ").append(toIndentedString(sla)).append("\n");
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

    // add `id` to the URL query string
    if (getId() != null) {
      try {
        joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `revision` to the URL query string
    if (getRevision() != null) {
      try {
        joiner.add(String.format("%srevision%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getRevision()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `inputs` to the URL query string
    if (getInputs() != null) {
      for (int i = 0; i < getInputs().size(); i++) {
        if (getInputs().get(i) != null) {
          joiner.add(getInputs().get(i).toUrlQueryString(String.format("%sinputs%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `outputs` to the URL query string
    if (getOutputs() != null) {
      for (int i = 0; i < getOutputs().size(); i++) {
        if (getOutputs().get(i) != null) {
          joiner.add(getOutputs().get(i).toUrlQueryString(String.format("%soutputs%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `disabled` to the URL query string
    if (getDisabled() != null) {
      try {
        joiner.add(String.format("%sdisabled%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDisabled()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `labels` to the URL query string
    if (getLabels() != null) {
      joiner.add(getLabels().toUrlQueryString(prefix + "labels" + suffix));
    }

    // add `variables` to the URL query string
    if (getVariables() != null) {
      for (String _key : getVariables().keySet()) {
        try {
          joiner.add(String.format("%svariables%s%s=%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, _key, containerSuffix),
              getVariables().get(_key), URLEncoder.encode(String.valueOf(getVariables().get(_key)), "UTF-8").replaceAll("\\+", "%20")));
        } catch (UnsupportedEncodingException e) {
          // Should never happen, UTF-8 is always supported
          throw new RuntimeException(e);
        }
      }
    }

    // add `workerGroup` to the URL query string
    if (getWorkerGroup() != null) {
      joiner.add(getWorkerGroup().toUrlQueryString(prefix + "workerGroup" + suffix));
    }

    // add `deleted` to the URL query string
    if (getDeleted() != null) {
      try {
        joiner.add(String.format("%sdeleted%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDeleted()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `finally` to the URL query string
    if (getFinally() != null) {
      for (int i = 0; i < getFinally().size(); i++) {
        if (getFinally().get(i) != null) {
          joiner.add(getFinally().get(i).toUrlQueryString(String.format("%sfinally%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `taskDefaults` to the URL query string
    if (getTaskDefaults() != null) {
      for (int i = 0; i < getTaskDefaults().size(); i++) {
        if (getTaskDefaults().get(i) != null) {
          joiner.add(getTaskDefaults().get(i).toUrlQueryString(String.format("%staskDefaults%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `description` to the URL query string
    if (getDescription() != null) {
      try {
        joiner.add(String.format("%sdescription%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDescription()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `tasks` to the URL query string
    if (getTasks() != null) {
      for (int i = 0; i < getTasks().size(); i++) {
        if (getTasks().get(i) != null) {
          joiner.add(getTasks().get(i).toUrlQueryString(String.format("%stasks%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `errors` to the URL query string
    if (getErrors() != null) {
      for (int i = 0; i < getErrors().size(); i++) {
        if (getErrors().get(i) != null) {
          joiner.add(getErrors().get(i).toUrlQueryString(String.format("%serrors%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `listeners` to the URL query string
    if (getListeners() != null) {
      for (int i = 0; i < getListeners().size(); i++) {
        if (getListeners().get(i) != null) {
          joiner.add(getListeners().get(i).toUrlQueryString(String.format("%slisteners%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `afterExecution` to the URL query string
    if (getAfterExecution() != null) {
      for (int i = 0; i < getAfterExecution().size(); i++) {
        if (getAfterExecution().get(i) != null) {
          joiner.add(getAfterExecution().get(i).toUrlQueryString(String.format("%safterExecution%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `triggers` to the URL query string
    if (getTriggers() != null) {
      for (int i = 0; i < getTriggers().size(); i++) {
        if (getTriggers().get(i) != null) {
          joiner.add(getTriggers().get(i).toUrlQueryString(String.format("%striggers%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `pluginDefaults` to the URL query string
    if (getPluginDefaults() != null) {
      for (int i = 0; i < getPluginDefaults().size(); i++) {
        if (getPluginDefaults().get(i) != null) {
          joiner.add(getPluginDefaults().get(i).toUrlQueryString(String.format("%spluginDefaults%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `concurrency` to the URL query string
    if (getConcurrency() != null) {
      joiner.add(getConcurrency().toUrlQueryString(prefix + "concurrency" + suffix));
    }

    // add `retry` to the URL query string
    if (getRetry() != null) {
      try {
        joiner.add(String.format("%sretry%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getRetry()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `sla` to the URL query string
    if (getSla() != null) {
      for (int i = 0; i < getSla().size(); i++) {
        if (getSla().get(i) != null) {
          joiner.add(getSla().get(i).toUrlQueryString(String.format("%ssla%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

