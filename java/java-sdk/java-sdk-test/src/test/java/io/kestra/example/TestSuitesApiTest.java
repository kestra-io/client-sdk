package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSuitesApiTest {
    static final String SIMPLE_TEST_SUITE = """
        id: %testSuiteId%
        namespace: %namespace%
        description: assert flow is returning the input value as output
        flowId: %flowId%
        testCases:
          - id: test_case_1
            description: test_case_1 description
            type: io.kestra.core.tests.flow.UnitTest
            fixtures:
              inputs:
                inputA: "Hi there"
            assertions:
              - value: "{{ outputs.return.value }}"
                equalTo: 'Hi there'
        """;
    static final String INVALID_TEST_SUITE = """
        id: %testSuiteId%
        namespace: %namespace%
        description: assert flow is returning the input value as output
        # missing flow id
        # missing test cases
        """;

    private String getTestSuiteYaml(String testSuiteYaml, String testSuiteId, String namespace, String flowId) {
        return testSuiteYaml
            .replace("%testSuiteId%", testSuiteId)
            .replace("%namespace%", namespace)
            .replace("%flowId%", flowId);
    }

    @Test
    public void createTestSuiteTest() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        var response = kestraClient().testSuites().createTestSuite(MAIN_TENANT, testSuiteYaml);

        assertThat(response.getId()).isEqualTo(testSuiteId);
        assertThat(response.getFlowId()).isEqualTo(flowId);
        assertThat(response.getNamespace()).isEqualTo(namespace);
        assertThat(response.getDescription()).isEqualTo("assert flow is returning the input value as output");
        assertThat(response.getTestCases()).extracting(UnitTest::getId).containsExactly("test_case_1");
        assertThat(response.getTestCases()).first().satisfies(unitTest -> {
            assertThat(unitTest).extracting(UnitTest::getDescription).isEqualTo("test_case_1 description");
            assertThat(unitTest).extracting(UnitTest::getType).isEqualTo("io.kestra.core.tests.flow.UnitTest");
            assertThat(unitTest).extracting(UnitTest::getDisabled).isEqualTo(false);
            assertThat(unitTest).extracting(UnitTest::getFixtures).extracting(Fixtures::getInputs).isEqualTo(Map.of("inputA", "Hi there"));
            assertThat(unitTest.getAssertions()).hasSize(1);
            assertThat(unitTest.getAssertions()).first().satisfies(assertion -> {
                assertThat(assertion).extracting(Assertion::getEqualTo).isEqualTo("Hi there");
                assertThat(assertion).extracting(Assertion::getValue).isEqualTo("{{ outputs.return.value }}");
            });
        });
    }

    @Test
    public void getTestSuiteTest() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        kestraClient().testSuites().createTestSuite(MAIN_TENANT, testSuiteYaml);
        var fetched = kestraClient().testSuites().testSuite(namespace, testSuiteId, MAIN_TENANT);

        assertThat(fetched.getId()).isEqualTo(testSuiteId);
        assertThat(fetched.getFlowId()).isEqualTo(flowId);
        assertThat(fetched.getNamespace()).isEqualTo(namespace);
        assertThat(fetched.getDescription()).isEqualTo("assert flow is returning the input value as output");
    }

    @Test
    public void deleteTestSuiteTest() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        // create it
        kestraClient().testSuites().createTestSuite(MAIN_TENANT, testSuiteYaml);
        assertThatCode(() -> kestraClient().testSuites().testSuite(namespace, testSuiteId, MAIN_TENANT))
            .as("test suite should exist")
            .doesNotThrowAnyException();
        // delete it
        kestraClient().testSuites().deleteTestSuite(namespace, testSuiteId, MAIN_TENANT);
        ApiException apiException = assertThrows(ApiException.class,
            () -> kestraClient().testSuites().testSuite(namespace, testSuiteId, MAIN_TENANT));
        assertThat(apiException.getCode()).isEqualTo(404);
    }

    @Test
    public void validateTestSuiteTest_ok() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        // create it
        var validationResult = kestraClient().testSuites().validateTestSuite(MAIN_TENANT, testSuiteYaml);

        assertThat(validationResult.getWarnings()).hasSize(0);
        assertThat(validationResult.getInfos()).hasSize(0);
        assertThat(validationResult.getDeprecationPaths()).hasSize(0);
        assertThat(validationResult.getConstraints()).isEqualTo(null);
    }

    @Test
    public void validateTestSuiteTest_invalid() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(INVALID_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        var validationResult = kestraClient().testSuites().validateTestSuite(MAIN_TENANT, testSuiteYaml);

        assertThat(validationResult.getConstraints()).contains("testCases: must not be empty", "flowId: must not be null");
    }

//    @Test
    public void deleteTestSuiteByIdsTest() throws ApiException {
        var flow = createSimpleFlow(LOG_FLOW);
        // FIXME flow is not in the same namespace
        var namespace = randomId();
        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), randomId(), flow.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), randomId(), flow.getId()));
        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), randomId(), flow.getId()));

        var idsToDelete = List.of(
            new TestSuiteControllerTestSuiteApiId().id(testSuite1.getId()).namespace(testSuite1.getNamespace()),
            new TestSuiteControllerTestSuiteApiId().id(testSuite3.getId()).namespace(testSuite3.getNamespace())
        );
        kestraClient().testSuites().deleteTestSuitesByIds(MAIN_TENANT,
            new TestSuiteControllerTestSuiteBulkRequest().ids(idsToDelete)
        );
        // TODO assert
    }
    /*


| [**deleteTestSuitesByIds**](TestSuitesApi.md#deleteTestSuitesByIds) | **DELETE** /api/v1/{tenant}/tests/by-ids | Delete multiple tests by id |
| [**disableTestSuitesByIds**](TestSuitesApi.md#disableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/disable/by-ids | Disable multiple tests by id |
| [**enableTestSuitesByIds**](TestSuitesApi.md#enableTestSuitesByIds) | **POST** /api/v1/{tenant}/tests/enable/by-ids | Enable multiple tests by id |
| [**runTestSuite**](TestSuitesApi.md#runTestSuite) | **POST** /api/v1/{tenant}/tests/{namespace}/{id}/run | Run a full test |
| [**runTestSuitesByQuery**](TestSuitesApi.md#runTestSuitesByQuery) | **POST** /api/v1/{tenant}/tests/run | Run multiple TestSuites by query |
| [**searchTestSuites**](TestSuitesApi.md#searchTestSuites) | **GET** /api/v1/{tenant}/tests/search | Search for tests |
| [**searchTestSuitesResults**](TestSuitesApi.md#searchTestSuitesResults) | **GET** /api/v1/{tenant}/tests/results/search | Search for tests results |
| [**testResult**](TestSuitesApi.md#testResult) | **GET** /api/v1/{tenant}/tests/results/{id} | Get a test result |
| [**testsLastResult**](TestSuitesApi.md#testsLastResult) | **POST** /api/v1/{tenant}/tests/results/search/last | Get tests last result |
| [**updateTestSuite**](TestSuitesApi.md#updateTestSuite) | **PUT** /api/v1/{tenant}/tests/{namespace}/{id} | Update a test from YAML source |
     */

    public static final String LOG_FLOW = """
        id: %s
        namespace: %s

        inputs:
          - id: inputA
            type: STRING

        tasks:
          - id: hello
            type: io.kestra.plugin.core.log.Log
            message: "inputA: {{ inputs.inputA }}"

          - id: return
            type: io.kestra.plugin.core.debug.Return
            format: "{{ inputs.inputA }}"

        outputs:
          - id: "outputA"
            type: STRING
            value: "{{ outputs.return.value }}"
        """;

    private void createSimpleFlow(String flowId, String namespace) throws ApiException {
        String flow = LOG_FLOW.formatted(flowId, namespace);
        createSimpleFlow(flow);
    }

    private FlowWithSource createSimpleFlow(String flow) throws ApiException {
        FlowWithSource flowWithSource = kestraClient().flows().createFlow(MAIN_TENANT, flow);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flowWithSource;
    }
}
