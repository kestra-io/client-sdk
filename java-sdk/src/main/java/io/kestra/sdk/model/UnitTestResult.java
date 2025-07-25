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
 * UnitTestResult
 */
@JsonPropertyOrder({
  UnitTestResult.JSON_PROPERTY_UNIT_TEST_ID,
  UnitTestResult.JSON_PROPERTY_UNIT_TEST_TYPE,
  UnitTestResult.JSON_PROPERTY_EXECUTION_ID,
  UnitTestResult.JSON_PROPERTY_STATE,
  UnitTestResult.JSON_PROPERTY_ASSERTION_RESULTS,
  UnitTestResult.JSON_PROPERTY_ERRORS,
  UnitTestResult.JSON_PROPERTY_FIXTURES
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-05T07:35:23.657005690Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class UnitTestResult {
  public static final String JSON_PROPERTY_UNIT_TEST_ID = "unitTestId";
  @javax.annotation.Nonnull
  private String unitTestId;

  public static final String JSON_PROPERTY_UNIT_TEST_TYPE = "unitTestType";
  @javax.annotation.Nonnull
  private String unitTestType;

  public static final String JSON_PROPERTY_EXECUTION_ID = "executionId";
  @javax.annotation.Nonnull
  private String executionId;

  public static final String JSON_PROPERTY_STATE = "state";
  @javax.annotation.Nonnull
  private TestState state;

  public static final String JSON_PROPERTY_ASSERTION_RESULTS = "assertionResults";
  @javax.annotation.Nonnull
  private List<AssertionResult> assertionResults = new ArrayList<>();

  public static final String JSON_PROPERTY_ERRORS = "errors";
  @javax.annotation.Nonnull
  private List<AssertionRunError> errors = new ArrayList<>();

  public static final String JSON_PROPERTY_FIXTURES = "fixtures";
  @javax.annotation.Nonnull
  private Fixtures fixtures;

  public UnitTestResult() {
  }

  public UnitTestResult unitTestId(@javax.annotation.Nonnull String unitTestId) {

    this.unitTestId = unitTestId;
    return this;
  }

  /**
   * Get unitTestId
   * @return unitTestId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_UNIT_TEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUnitTestId() {
    return unitTestId;
  }


  @JsonProperty(JSON_PROPERTY_UNIT_TEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnitTestId(@javax.annotation.Nonnull String unitTestId) {
    this.unitTestId = unitTestId;
  }

  public UnitTestResult unitTestType(@javax.annotation.Nonnull String unitTestType) {

    this.unitTestType = unitTestType;
    return this;
  }

  /**
   * Get unitTestType
   * @return unitTestType
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_UNIT_TEST_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUnitTestType() {
    return unitTestType;
  }


  @JsonProperty(JSON_PROPERTY_UNIT_TEST_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnitTestType(@javax.annotation.Nonnull String unitTestType) {
    this.unitTestType = unitTestType;
  }

  public UnitTestResult executionId(@javax.annotation.Nonnull String executionId) {

    this.executionId = executionId;
    return this;
  }

  /**
   * Get executionId
   * @return executionId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExecutionId() {
    return executionId;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExecutionId(@javax.annotation.Nonnull String executionId) {
    this.executionId = executionId;
  }

  public UnitTestResult state(@javax.annotation.Nonnull TestState state) {

    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TestState getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(@javax.annotation.Nonnull TestState state) {
    this.state = state;
  }

  public UnitTestResult assertionResults(@javax.annotation.Nonnull List<AssertionResult> assertionResults) {

    this.assertionResults = assertionResults;
    return this;
  }

  public UnitTestResult addAssertionResultsItem(AssertionResult assertionResultsItem) {
    if (this.assertionResults == null) {
      this.assertionResults = new ArrayList<>();
    }
    this.assertionResults.add(assertionResultsItem);
    return this;
  }

  /**
   * Get assertionResults
   * @return assertionResults
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ASSERTION_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<AssertionResult> getAssertionResults() {
    return assertionResults;
  }


  @JsonProperty(JSON_PROPERTY_ASSERTION_RESULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAssertionResults(@javax.annotation.Nonnull List<AssertionResult> assertionResults) {
    this.assertionResults = assertionResults;
  }

  public UnitTestResult errors(@javax.annotation.Nonnull List<AssertionRunError> errors) {

    this.errors = errors;
    return this;
  }

  public UnitTestResult addErrorsItem(AssertionRunError errorsItem) {
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

  public List<AssertionRunError> getErrors() {
    return errors;
  }


  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setErrors(@javax.annotation.Nonnull List<AssertionRunError> errors) {
    this.errors = errors;
  }

  public UnitTestResult fixtures(@javax.annotation.Nonnull Fixtures fixtures) {

    this.fixtures = fixtures;
    return this;
  }

  /**
   * Get fixtures
   * @return fixtures
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FIXTURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Fixtures getFixtures() {
    return fixtures;
  }


  @JsonProperty(JSON_PROPERTY_FIXTURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFixtures(@javax.annotation.Nonnull Fixtures fixtures) {
    this.fixtures = fixtures;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnitTestResult unitTestResult = (UnitTestResult) o;
    return Objects.equals(this.unitTestId, unitTestResult.unitTestId) &&
        Objects.equals(this.unitTestType, unitTestResult.unitTestType) &&
        Objects.equals(this.executionId, unitTestResult.executionId) &&
        Objects.equals(this.state, unitTestResult.state) &&
        Objects.equals(this.assertionResults, unitTestResult.assertionResults) &&
        Objects.equals(this.errors, unitTestResult.errors) &&
        Objects.equals(this.fixtures, unitTestResult.fixtures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unitTestId, unitTestType, executionId, state, assertionResults, errors, fixtures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnitTestResult {\n");
    sb.append("    unitTestId: ").append(toIndentedString(unitTestId)).append("\n");
    sb.append("    unitTestType: ").append(toIndentedString(unitTestType)).append("\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    assertionResults: ").append(toIndentedString(assertionResults)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    fixtures: ").append(toIndentedString(fixtures)).append("\n");
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

    // add `unitTestId` to the URL query string
    if (getUnitTestId() != null) {
      try {
        joiner.add(String.format("%sunitTestId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getUnitTestId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `unitTestType` to the URL query string
    if (getUnitTestType() != null) {
      try {
        joiner.add(String.format("%sunitTestType%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getUnitTestType()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
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

    // add `state` to the URL query string
    if (getState() != null) {
      try {
        joiner.add(String.format("%sstate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getState()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `assertionResults` to the URL query string
    if (getAssertionResults() != null) {
      for (int i = 0; i < getAssertionResults().size(); i++) {
        if (getAssertionResults().get(i) != null) {
          joiner.add(getAssertionResults().get(i).toUrlQueryString(String.format("%sassertionResults%s%s", prefix, suffix,
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

    // add `fixtures` to the URL query string
    if (getFixtures() != null) {
      joiner.add(getFixtures().toUrlQueryString(prefix + "fixtures" + suffix));
    }

    return joiner.toString();
  }

}

