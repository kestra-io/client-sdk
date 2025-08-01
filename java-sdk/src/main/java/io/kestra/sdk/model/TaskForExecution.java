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
import io.kestra.sdk.model.ExecutableTaskSubflowId;
import io.kestra.sdk.model.InputObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * TaskForExecution
 */
@JsonPropertyOrder({
  TaskForExecution.JSON_PROPERTY_ID,
  TaskForExecution.JSON_PROPERTY_TYPE,
  TaskForExecution.JSON_PROPERTY_VERSION,
  TaskForExecution.JSON_PROPERTY_TASKS,
  TaskForExecution.JSON_PROPERTY_INPUTS,
  TaskForExecution.JSON_PROPERTY_SUBFLOW_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class TaskForExecution {
  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nonnull
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  @javax.annotation.Nonnull
  private String type;

  public static final String JSON_PROPERTY_VERSION = "version";
  @javax.annotation.Nullable
  private String version;

  public static final String JSON_PROPERTY_TASKS = "tasks";
  @javax.annotation.Nullable
  private List<TaskForExecution> tasks = new ArrayList<>();

  public static final String JSON_PROPERTY_INPUTS = "inputs";
  @javax.annotation.Nullable
  private List<InputObject> inputs = new ArrayList<>();

  public static final String JSON_PROPERTY_SUBFLOW_ID = "subflowId";
  @javax.annotation.Nullable
  private ExecutableTaskSubflowId subflowId;

  public TaskForExecution() {
  }

  public TaskForExecution id(@javax.annotation.Nonnull String id) {
    
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

  public TaskForExecution type(@javax.annotation.Nonnull String type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(@javax.annotation.Nonnull String type) {
    this.type = type;
  }

  public TaskForExecution version(@javax.annotation.Nullable String version) {
    
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVersion() {
    return version;
  }


  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(@javax.annotation.Nullable String version) {
    this.version = version;
  }

  public TaskForExecution tasks(@javax.annotation.Nullable List<TaskForExecution> tasks) {
    
    this.tasks = tasks;
    return this;
  }

  public TaskForExecution addTasksItem(TaskForExecution tasksItem) {
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
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TaskForExecution> getTasks() {
    return tasks;
  }


  @JsonProperty(JSON_PROPERTY_TASKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTasks(@javax.annotation.Nullable List<TaskForExecution> tasks) {
    this.tasks = tasks;
  }

  public TaskForExecution inputs(@javax.annotation.Nullable List<InputObject> inputs) {
    
    this.inputs = inputs;
    return this;
  }

  public TaskForExecution addInputsItem(InputObject inputsItem) {
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

  public TaskForExecution subflowId(@javax.annotation.Nullable ExecutableTaskSubflowId subflowId) {
    
    this.subflowId = subflowId;
    return this;
  }

  /**
   * Get subflowId
   * @return subflowId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBFLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ExecutableTaskSubflowId getSubflowId() {
    return subflowId;
  }


  @JsonProperty(JSON_PROPERTY_SUBFLOW_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubflowId(@javax.annotation.Nullable ExecutableTaskSubflowId subflowId) {
    this.subflowId = subflowId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskForExecution taskForExecution = (TaskForExecution) o;
    return Objects.equals(this.id, taskForExecution.id) &&
        Objects.equals(this.type, taskForExecution.type) &&
        Objects.equals(this.version, taskForExecution.version) &&
        Objects.equals(this.tasks, taskForExecution.tasks) &&
        Objects.equals(this.inputs, taskForExecution.inputs) &&
        Objects.equals(this.subflowId, taskForExecution.subflowId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, version, tasks, inputs, subflowId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskForExecution {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    subflowId: ").append(toIndentedString(subflowId)).append("\n");
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

    // add `type` to the URL query string
    if (getType() != null) {
      try {
        joiner.add(String.format("%stype%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `version` to the URL query string
    if (getVersion() != null) {
      try {
        joiner.add(String.format("%sversion%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getVersion()), "UTF-8").replaceAll("\\+", "%20")));
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

    // add `inputs` to the URL query string
    if (getInputs() != null) {
      for (int i = 0; i < getInputs().size(); i++) {
        if (getInputs().get(i) != null) {
          joiner.add(getInputs().get(i).toUrlQueryString(String.format("%sinputs%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `subflowId` to the URL query string
    if (getSubflowId() != null) {
      joiner.add(getSubflowId().toUrlQueryString(prefix + "subflowId" + suffix));
    }

    return joiner.toString();
  }

}

