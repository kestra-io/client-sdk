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
import io.kestra.sdk.model.PropertyBoolean;
import io.kestra.sdk.model.PropertyDouble;
import io.kestra.sdk.model.PropertyListString;
import io.kestra.sdk.model.PropertyObject;
import io.kestra.sdk.model.PropertyString;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * Assertion
 */
@JsonPropertyOrder({
  Assertion.JSON_PROPERTY_VALUE,
  Assertion.JSON_PROPERTY_TASK_ID,
  Assertion.JSON_PROPERTY_ERROR_MESSAGE,
  Assertion.JSON_PROPERTY_DESCRIPTION,
  Assertion.JSON_PROPERTY_ENDS_WITH,
  Assertion.JSON_PROPERTY_STARTS_WITH,
  Assertion.JSON_PROPERTY_CONTAINS,
  Assertion.JSON_PROPERTY_EQUAL_TO,
  Assertion.JSON_PROPERTY_NOT_EQUAL_TO,
  Assertion.JSON_PROPERTY_GREATER_THAN,
  Assertion.JSON_PROPERTY_GREATER_THAN_OR_EQUAL_TO,
  Assertion.JSON_PROPERTY_LESS_THAN,
  Assertion.JSON_PROPERTY_LESS_THAN_OR_EQUAL_TO,
  Assertion.JSON_PROPERTY_IN,
  Assertion.JSON_PROPERTY_NOT_IN,
  Assertion.JSON_PROPERTY_IS_NULL,
  Assertion.JSON_PROPERTY_IS_NOT_NULL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class Assertion {
  public static final String JSON_PROPERTY_VALUE = "value";
  @javax.annotation.Nonnull
  private PropertyObject value;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @javax.annotation.Nullable
  private String taskId;

  public static final String JSON_PROPERTY_ERROR_MESSAGE = "errorMessage";
  @javax.annotation.Nullable
  private PropertyString errorMessage;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nullable
  private PropertyString description;

  public static final String JSON_PROPERTY_ENDS_WITH = "endsWith";
  @javax.annotation.Nullable
  private PropertyString endsWith;

  public static final String JSON_PROPERTY_STARTS_WITH = "startsWith";
  @javax.annotation.Nullable
  private PropertyString startsWith;

  public static final String JSON_PROPERTY_CONTAINS = "contains";
  @javax.annotation.Nullable
  private PropertyString contains;

  public static final String JSON_PROPERTY_EQUAL_TO = "equalTo";
  @javax.annotation.Nullable
  private PropertyObject equalTo;

  public static final String JSON_PROPERTY_NOT_EQUAL_TO = "notEqualTo";
  @javax.annotation.Nullable
  private PropertyObject notEqualTo;

  public static final String JSON_PROPERTY_GREATER_THAN = "greaterThan";
  @javax.annotation.Nullable
  private PropertyDouble greaterThan;

  public static final String JSON_PROPERTY_GREATER_THAN_OR_EQUAL_TO = "greaterThanOrEqualTo";
  @javax.annotation.Nullable
  private PropertyDouble greaterThanOrEqualTo;

  public static final String JSON_PROPERTY_LESS_THAN = "lessThan";
  @javax.annotation.Nullable
  private PropertyDouble lessThan;

  public static final String JSON_PROPERTY_LESS_THAN_OR_EQUAL_TO = "lessThanOrEqualTo";
  @javax.annotation.Nullable
  private PropertyDouble lessThanOrEqualTo;

  public static final String JSON_PROPERTY_IN = "in";
  @javax.annotation.Nullable
  private PropertyListString in;

  public static final String JSON_PROPERTY_NOT_IN = "notIn";
  @javax.annotation.Nullable
  private PropertyListString notIn;

  public static final String JSON_PROPERTY_IS_NULL = "isNull";
  @javax.annotation.Nullable
  private PropertyBoolean isNull;

  public static final String JSON_PROPERTY_IS_NOT_NULL = "isNotNull";
  @javax.annotation.Nullable
  private PropertyBoolean isNotNull;

  public Assertion() {
  }

  public Assertion value(@javax.annotation.Nonnull PropertyObject value) {
    
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PropertyObject getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(@javax.annotation.Nonnull PropertyObject value) {
    this.value = value;
  }

  public Assertion taskId(@javax.annotation.Nullable String taskId) {
    
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskId() {
    return taskId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskId(@javax.annotation.Nullable String taskId) {
    this.taskId = taskId;
  }

  public Assertion errorMessage(@javax.annotation.Nullable PropertyString errorMessage) {
    
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   * @return errorMessage
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyString getErrorMessage() {
    return errorMessage;
  }


  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorMessage(@javax.annotation.Nullable PropertyString errorMessage) {
    this.errorMessage = errorMessage;
  }

  public Assertion description(@javax.annotation.Nullable PropertyString description) {
    
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

  public PropertyString getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@javax.annotation.Nullable PropertyString description) {
    this.description = description;
  }

  public Assertion endsWith(@javax.annotation.Nullable PropertyString endsWith) {
    
    this.endsWith = endsWith;
    return this;
  }

  /**
   * Get endsWith
   * @return endsWith
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENDS_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyString getEndsWith() {
    return endsWith;
  }


  @JsonProperty(JSON_PROPERTY_ENDS_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndsWith(@javax.annotation.Nullable PropertyString endsWith) {
    this.endsWith = endsWith;
  }

  public Assertion startsWith(@javax.annotation.Nullable PropertyString startsWith) {
    
    this.startsWith = startsWith;
    return this;
  }

  /**
   * Get startsWith
   * @return startsWith
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STARTS_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyString getStartsWith() {
    return startsWith;
  }


  @JsonProperty(JSON_PROPERTY_STARTS_WITH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartsWith(@javax.annotation.Nullable PropertyString startsWith) {
    this.startsWith = startsWith;
  }

  public Assertion contains(@javax.annotation.Nullable PropertyString contains) {
    
    this.contains = contains;
    return this;
  }

  /**
   * Get contains
   * @return contains
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTAINS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyString getContains() {
    return contains;
  }


  @JsonProperty(JSON_PROPERTY_CONTAINS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContains(@javax.annotation.Nullable PropertyString contains) {
    this.contains = contains;
  }

  public Assertion equalTo(@javax.annotation.Nullable PropertyObject equalTo) {
    
    this.equalTo = equalTo;
    return this;
  }

  /**
   * Get equalTo
   * @return equalTo
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyObject getEqualTo() {
    return equalTo;
  }


  @JsonProperty(JSON_PROPERTY_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEqualTo(@javax.annotation.Nullable PropertyObject equalTo) {
    this.equalTo = equalTo;
  }

  public Assertion notEqualTo(@javax.annotation.Nullable PropertyObject notEqualTo) {
    
    this.notEqualTo = notEqualTo;
    return this;
  }

  /**
   * Get notEqualTo
   * @return notEqualTo
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NOT_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyObject getNotEqualTo() {
    return notEqualTo;
  }


  @JsonProperty(JSON_PROPERTY_NOT_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotEqualTo(@javax.annotation.Nullable PropertyObject notEqualTo) {
    this.notEqualTo = notEqualTo;
  }

  public Assertion greaterThan(@javax.annotation.Nullable PropertyDouble greaterThan) {
    
    this.greaterThan = greaterThan;
    return this;
  }

  /**
   * Get greaterThan
   * @return greaterThan
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GREATER_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyDouble getGreaterThan() {
    return greaterThan;
  }


  @JsonProperty(JSON_PROPERTY_GREATER_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGreaterThan(@javax.annotation.Nullable PropertyDouble greaterThan) {
    this.greaterThan = greaterThan;
  }

  public Assertion greaterThanOrEqualTo(@javax.annotation.Nullable PropertyDouble greaterThanOrEqualTo) {
    
    this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    return this;
  }

  /**
   * Get greaterThanOrEqualTo
   * @return greaterThanOrEqualTo
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GREATER_THAN_OR_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyDouble getGreaterThanOrEqualTo() {
    return greaterThanOrEqualTo;
  }


  @JsonProperty(JSON_PROPERTY_GREATER_THAN_OR_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGreaterThanOrEqualTo(@javax.annotation.Nullable PropertyDouble greaterThanOrEqualTo) {
    this.greaterThanOrEqualTo = greaterThanOrEqualTo;
  }

  public Assertion lessThan(@javax.annotation.Nullable PropertyDouble lessThan) {
    
    this.lessThan = lessThan;
    return this;
  }

  /**
   * Get lessThan
   * @return lessThan
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LESS_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyDouble getLessThan() {
    return lessThan;
  }


  @JsonProperty(JSON_PROPERTY_LESS_THAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLessThan(@javax.annotation.Nullable PropertyDouble lessThan) {
    this.lessThan = lessThan;
  }

  public Assertion lessThanOrEqualTo(@javax.annotation.Nullable PropertyDouble lessThanOrEqualTo) {
    
    this.lessThanOrEqualTo = lessThanOrEqualTo;
    return this;
  }

  /**
   * Get lessThanOrEqualTo
   * @return lessThanOrEqualTo
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LESS_THAN_OR_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyDouble getLessThanOrEqualTo() {
    return lessThanOrEqualTo;
  }


  @JsonProperty(JSON_PROPERTY_LESS_THAN_OR_EQUAL_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLessThanOrEqualTo(@javax.annotation.Nullable PropertyDouble lessThanOrEqualTo) {
    this.lessThanOrEqualTo = lessThanOrEqualTo;
  }

  public Assertion in(@javax.annotation.Nullable PropertyListString in) {
    
    this.in = in;
    return this;
  }

  /**
   * Get in
   * @return in
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_IN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyListString getIn() {
    return in;
  }


  @JsonProperty(JSON_PROPERTY_IN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIn(@javax.annotation.Nullable PropertyListString in) {
    this.in = in;
  }

  public Assertion notIn(@javax.annotation.Nullable PropertyListString notIn) {
    
    this.notIn = notIn;
    return this;
  }

  /**
   * Get notIn
   * @return notIn
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NOT_IN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyListString getNotIn() {
    return notIn;
  }


  @JsonProperty(JSON_PROPERTY_NOT_IN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotIn(@javax.annotation.Nullable PropertyListString notIn) {
    this.notIn = notIn;
  }

  public Assertion isNull(@javax.annotation.Nullable PropertyBoolean isNull) {
    
    this.isNull = isNull;
    return this;
  }

  /**
   * Get isNull
   * @return isNull
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_IS_NULL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyBoolean getIsNull() {
    return isNull;
  }


  @JsonProperty(JSON_PROPERTY_IS_NULL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsNull(@javax.annotation.Nullable PropertyBoolean isNull) {
    this.isNull = isNull;
  }

  public Assertion isNotNull(@javax.annotation.Nullable PropertyBoolean isNotNull) {
    
    this.isNotNull = isNotNull;
    return this;
  }

  /**
   * Get isNotNull
   * @return isNotNull
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_IS_NOT_NULL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PropertyBoolean getIsNotNull() {
    return isNotNull;
  }


  @JsonProperty(JSON_PROPERTY_IS_NOT_NULL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsNotNull(@javax.annotation.Nullable PropertyBoolean isNotNull) {
    this.isNotNull = isNotNull;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Assertion assertion = (Assertion) o;
    return Objects.equals(this.value, assertion.value) &&
        Objects.equals(this.taskId, assertion.taskId) &&
        Objects.equals(this.errorMessage, assertion.errorMessage) &&
        Objects.equals(this.description, assertion.description) &&
        Objects.equals(this.endsWith, assertion.endsWith) &&
        Objects.equals(this.startsWith, assertion.startsWith) &&
        Objects.equals(this.contains, assertion.contains) &&
        Objects.equals(this.equalTo, assertion.equalTo) &&
        Objects.equals(this.notEqualTo, assertion.notEqualTo) &&
        Objects.equals(this.greaterThan, assertion.greaterThan) &&
        Objects.equals(this.greaterThanOrEqualTo, assertion.greaterThanOrEqualTo) &&
        Objects.equals(this.lessThan, assertion.lessThan) &&
        Objects.equals(this.lessThanOrEqualTo, assertion.lessThanOrEqualTo) &&
        Objects.equals(this.in, assertion.in) &&
        Objects.equals(this.notIn, assertion.notIn) &&
        Objects.equals(this.isNull, assertion.isNull) &&
        Objects.equals(this.isNotNull, assertion.isNotNull);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, taskId, errorMessage, description, endsWith, startsWith, contains, equalTo, notEqualTo, greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo, in, notIn, isNull, isNotNull);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Assertion {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endsWith: ").append(toIndentedString(endsWith)).append("\n");
    sb.append("    startsWith: ").append(toIndentedString(startsWith)).append("\n");
    sb.append("    contains: ").append(toIndentedString(contains)).append("\n");
    sb.append("    equalTo: ").append(toIndentedString(equalTo)).append("\n");
    sb.append("    notEqualTo: ").append(toIndentedString(notEqualTo)).append("\n");
    sb.append("    greaterThan: ").append(toIndentedString(greaterThan)).append("\n");
    sb.append("    greaterThanOrEqualTo: ").append(toIndentedString(greaterThanOrEqualTo)).append("\n");
    sb.append("    lessThan: ").append(toIndentedString(lessThan)).append("\n");
    sb.append("    lessThanOrEqualTo: ").append(toIndentedString(lessThanOrEqualTo)).append("\n");
    sb.append("    in: ").append(toIndentedString(in)).append("\n");
    sb.append("    notIn: ").append(toIndentedString(notIn)).append("\n");
    sb.append("    isNull: ").append(toIndentedString(isNull)).append("\n");
    sb.append("    isNotNull: ").append(toIndentedString(isNotNull)).append("\n");
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

    // add `value` to the URL query string
    if (getValue() != null) {
      joiner.add(getValue().toUrlQueryString(prefix + "value" + suffix));
    }

    // add `taskId` to the URL query string
    if (getTaskId() != null) {
      try {
        joiner.add(String.format("%staskId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTaskId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `errorMessage` to the URL query string
    if (getErrorMessage() != null) {
      joiner.add(getErrorMessage().toUrlQueryString(prefix + "errorMessage" + suffix));
    }

    // add `description` to the URL query string
    if (getDescription() != null) {
      joiner.add(getDescription().toUrlQueryString(prefix + "description" + suffix));
    }

    // add `endsWith` to the URL query string
    if (getEndsWith() != null) {
      joiner.add(getEndsWith().toUrlQueryString(prefix + "endsWith" + suffix));
    }

    // add `startsWith` to the URL query string
    if (getStartsWith() != null) {
      joiner.add(getStartsWith().toUrlQueryString(prefix + "startsWith" + suffix));
    }

    // add `contains` to the URL query string
    if (getContains() != null) {
      joiner.add(getContains().toUrlQueryString(prefix + "contains" + suffix));
    }

    // add `equalTo` to the URL query string
    if (getEqualTo() != null) {
      joiner.add(getEqualTo().toUrlQueryString(prefix + "equalTo" + suffix));
    }

    // add `notEqualTo` to the URL query string
    if (getNotEqualTo() != null) {
      joiner.add(getNotEqualTo().toUrlQueryString(prefix + "notEqualTo" + suffix));
    }

    // add `greaterThan` to the URL query string
    if (getGreaterThan() != null) {
      joiner.add(getGreaterThan().toUrlQueryString(prefix + "greaterThan" + suffix));
    }

    // add `greaterThanOrEqualTo` to the URL query string
    if (getGreaterThanOrEqualTo() != null) {
      joiner.add(getGreaterThanOrEqualTo().toUrlQueryString(prefix + "greaterThanOrEqualTo" + suffix));
    }

    // add `lessThan` to the URL query string
    if (getLessThan() != null) {
      joiner.add(getLessThan().toUrlQueryString(prefix + "lessThan" + suffix));
    }

    // add `lessThanOrEqualTo` to the URL query string
    if (getLessThanOrEqualTo() != null) {
      joiner.add(getLessThanOrEqualTo().toUrlQueryString(prefix + "lessThanOrEqualTo" + suffix));
    }

    // add `in` to the URL query string
    if (getIn() != null) {
      joiner.add(getIn().toUrlQueryString(prefix + "in" + suffix));
    }

    // add `notIn` to the URL query string
    if (getNotIn() != null) {
      joiner.add(getNotIn().toUrlQueryString(prefix + "notIn" + suffix));
    }

    // add `isNull` to the URL query string
    if (getIsNull() != null) {
      joiner.add(getIsNull().toUrlQueryString(prefix + "isNull" + suffix));
    }

    // add `isNotNull` to the URL query string
    if (getIsNotNull() != null) {
      joiner.add(getIsNotNull().toUrlQueryString(prefix + "isNotNull" + suffix));
    }

    return joiner.toString();
  }

}

