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
import io.kestra.sdk.model.TestSuiteControllerTestSuiteApiId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * TestSuiteControllerSearchTestsLastResult
 */
@JsonPropertyOrder({
  TestSuiteControllerSearchTestsLastResult.JSON_PROPERTY_TEST_SUITE_IDS
})
@JsonTypeName("TestSuiteController.SearchTestsLastResult")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-28T12:15:52.743487342Z[Etc/UTC]", comments = "Generator version: 7.14.0-SNAPSHOT")
public class TestSuiteControllerSearchTestsLastResult {
  public static final String JSON_PROPERTY_TEST_SUITE_IDS = "testSuiteIds";
  @javax.annotation.Nullable
  private List<TestSuiteControllerTestSuiteApiId> testSuiteIds = new ArrayList<>();

  public TestSuiteControllerSearchTestsLastResult() {
  }

  public TestSuiteControllerSearchTestsLastResult testSuiteIds(@javax.annotation.Nullable List<TestSuiteControllerTestSuiteApiId> testSuiteIds) {
    
    this.testSuiteIds = testSuiteIds;
    return this;
  }

  public TestSuiteControllerSearchTestsLastResult addTestSuiteIdsItem(TestSuiteControllerTestSuiteApiId testSuiteIdsItem) {
    if (this.testSuiteIds == null) {
      this.testSuiteIds = new ArrayList<>();
    }
    this.testSuiteIds.add(testSuiteIdsItem);
    return this;
  }

  /**
   * Get testSuiteIds
   * @return testSuiteIds
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TEST_SUITE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TestSuiteControllerTestSuiteApiId> getTestSuiteIds() {
    return testSuiteIds;
  }


  @JsonProperty(JSON_PROPERTY_TEST_SUITE_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTestSuiteIds(@javax.annotation.Nullable List<TestSuiteControllerTestSuiteApiId> testSuiteIds) {
    this.testSuiteIds = testSuiteIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestSuiteControllerSearchTestsLastResult testSuiteControllerSearchTestsLastResult = (TestSuiteControllerSearchTestsLastResult) o;
    return Objects.equals(this.testSuiteIds, testSuiteControllerSearchTestsLastResult.testSuiteIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(testSuiteIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestSuiteControllerSearchTestsLastResult {\n");
    sb.append("    testSuiteIds: ").append(toIndentedString(testSuiteIds)).append("\n");
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

    // add `testSuiteIds` to the URL query string
    if (getTestSuiteIds() != null) {
      for (int i = 0; i < getTestSuiteIds().size(); i++) {
        if (getTestSuiteIds().get(i) != null) {
          joiner.add(getTestSuiteIds().get(i).toUrlQueryString(String.format("%stestSuiteIds%s%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }

}

