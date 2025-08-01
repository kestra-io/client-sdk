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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * Template
 */
@JsonPropertyOrder({
  Template.JSON_PROPERTY_FINALLY,
  Template.JSON_PROPERTY_ID,
  Template.JSON_PROPERTY_NAMESPACE,
  Template.JSON_PROPERTY_DESCRIPTION,
  Template.JSON_PROPERTY_TASKS,
  Template.JSON_PROPERTY_ERRORS,
  Template.JSON_PROPERTY_DELETED
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-09T14:00:04.441521653Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class Template {
  public static final String JSON_PROPERTY_FINALLY = "finally";
  @javax.annotation.Nullable
  private List<Task> _finally = new ArrayList<>();

  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nonnull
  private String id;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @javax.annotation.Nonnull
  private String namespace;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nonnull
  private String description;

  public static final String JSON_PROPERTY_TASKS = "tasks";
  @javax.annotation.Nonnull
  private List<Task> tasks = new ArrayList<>();

  public static final String JSON_PROPERTY_ERRORS = "errors";
  @javax.annotation.Nonnull
  private List<Task> errors = new ArrayList<>();

  public static final String JSON_PROPERTY_DELETED = "deleted";
  @javax.annotation.Nonnull
  private Boolean deleted;

  public Template() {
  }

  public Template _finally(@javax.annotation.Nullable List<Task> _finally) {

    this._finally = _finally;
    return this;
  }

  public Template addFinallyItem(Task _finallyItem) {
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

  public Template id(@javax.annotation.Nonnull String id) {

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

  public Template namespace(@javax.annotation.Nonnull String namespace) {

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

  public Template description(@javax.annotation.Nonnull String description) {

    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(@javax.annotation.Nonnull String description) {
    this.description = description;
  }

  public Template tasks(@javax.annotation.Nonnull List<Task> tasks) {

    this.tasks = tasks;
    return this;
  }

  public Template addTasksItem(Task tasksItem) {
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

  public Template errors(@javax.annotation.Nonnull List<Task> errors) {

    this.errors = errors;
    return this;
  }

  public Template addErrorsItem(Task errorsItem) {
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
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Task> getErrors() {
    return errors;
  }


  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setErrors(@javax.annotation.Nonnull List<Task> errors) {
    this.errors = errors;
  }

  public Template deleted(@javax.annotation.Nonnull Boolean deleted) {

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Template template = (Template) o;
    return Objects.equals(this._finally, template._finally) &&
        Objects.equals(this.id, template.id) &&
        Objects.equals(this.namespace, template.namespace) &&
        Objects.equals(this.description, template.description) &&
        Objects.equals(this.tasks, template.tasks) &&
        Objects.equals(this.errors, template.errors) &&
        Objects.equals(this.deleted, template.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_finally, id, namespace, description, tasks, errors, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Template {\n");
    sb.append("    _finally: ").append(toIndentedString(_finally)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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

    // add `finally` to the URL query string
    if (getFinally() != null) {
      for (int i = 0; i < getFinally().size(); i++) {
        if (getFinally().get(i) != null) {
          joiner.add(getFinally().get(i).toUrlQueryString(String.format("%sfinally%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

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

    // add `deleted` to the URL query string
    if (getDeleted() != null) {
      try {
        joiner.add(String.format("%sdeleted%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDeleted()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

