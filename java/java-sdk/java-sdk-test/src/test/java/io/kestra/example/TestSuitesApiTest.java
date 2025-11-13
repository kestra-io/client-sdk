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
    static final String FAILING_SIMPLE_TEST_SUITE = """
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
                inputA: "another value"
            assertions:
              - value: "{{ outputs.return.value }}"
                description: 'making this assertion always false'
                equalTo: 'Hi there'
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
        assertThat(response.getTestCases()).extracting(UnitTest::getId).containsExactlyInAnyOrder("test_case_1");
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
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, testSuiteYaml);
        assertTestSuiteExists(testSuite);

        // delete it
        kestraClient().testSuites().deleteTestSuite(namespace, testSuiteId, MAIN_TENANT);
        assertTestSuiteDoesNotExist(testSuite);
    }

    @Test
    public void updateTestSuiteTest() throws ApiException {
        var testSuiteId = randomId();
        var namespace = randomId();
        var flowId = randomId();
        var testSuiteYaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        createSimpleFlow(flowId, namespace);

        // create it
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, testSuiteYaml);
        assertTestSuiteExists(testSuite);

        // update it
        testSuiteYaml = testSuiteYaml
            .replace("assert flow is returning the input value as output", "updated testsuite description")
            .replace("test_case_1 description", "updated testcase description");

        kestraClient().testSuites().updateTestSuite(namespace, testSuiteId, MAIN_TENANT, testSuiteYaml);

        var fetchedTestSuite = kestraClient().testSuites().testSuite(namespace, testSuiteId, MAIN_TENANT);
        assertThat(fetchedTestSuite.getId()).isEqualTo(testSuiteId);
        assertThat(fetchedTestSuite.getDescription()).isEqualTo("updated testsuite description");
        assertThat(fetchedTestSuite.getTestCases()).first().extracting(UnitTest::getDescription).isEqualTo("updated testcase description");
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

    @Test
    public void deleteTestSuiteByIdsTest() throws ApiException {
        var flowId = randomId();
        var namespace = randomId();
        var flow = createSimpleFlow(LOG_FLOW.formatted(flowId, namespace));
        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));

        assertTestSuiteExists(testSuite2);
        assertTestSuiteExists(testSuite1);
        assertTestSuiteExists(testSuite3);

        var idsToDelete = List.of(
            new TestSuiteControllerTestSuiteApiId().id(testSuite1.getId()).namespace(testSuite1.getNamespace()),
            new TestSuiteControllerTestSuiteApiId().id(testSuite3.getId()).namespace(testSuite3.getNamespace())
        );
        kestraClient().testSuites().deleteTestSuitesByIds(MAIN_TENANT, new TestSuiteControllerTestSuiteBulkRequest().ids(idsToDelete));

        assertTestSuiteExists(testSuite2);
        assertTestSuiteDoesNotExist(testSuite1);
        assertTestSuiteDoesNotExist(testSuite3);
    }

    private void assertTestSuiteExists(TestSuite testSuite) {
        assertThatCode(() -> kestraClient().testSuites().testSuite(testSuite.getNamespace(), testSuite.getId(), MAIN_TENANT))
            .as("test suite should exist")
            .doesNotThrowAnyException();
    }

    private void assertTestSuiteDoesNotExist(TestSuite testSuite) {
        ApiException apiException = assertThrows(ApiException.class,
            () -> kestraClient().testSuites().testSuite(testSuite.getNamespace(), testSuite.getId(), MAIN_TENANT));
        assertThat(apiException.getCode()).isEqualTo(404);
    }

    @Test
    public void disableTestSuiteByIdsTest() throws ApiException {
        var flowId = randomId();
        var namespace = randomId();
        var flow = createSimpleFlow(LOG_FLOW.formatted(flowId, namespace));
        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));

        assertThat(isTestSuiteDisabled(testSuite1)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite2)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite3)).isFalse();

        var idsToDisable = List.of(
            new TestSuiteControllerTestSuiteApiId().id(testSuite1.getId()).namespace(testSuite1.getNamespace()),
            new TestSuiteControllerTestSuiteApiId().id(testSuite3.getId()).namespace(testSuite3.getNamespace())
        );
        kestraClient().testSuites().disableTestSuitesByIds(MAIN_TENANT, new TestSuiteControllerTestSuiteBulkRequest().ids(idsToDisable));

        assertThat(isTestSuiteDisabled(testSuite1)).isTrue();
        assertThat(isTestSuiteDisabled(testSuite2)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite3)).isTrue();
    }

    private boolean isTestSuiteDisabled(TestSuite testSuite) {
        return kestraClient().testSuites().testSuite(testSuite.getNamespace(), testSuite.getId(), MAIN_TENANT).getDisabled();
    }

    @Test
    public void enableTestSuiteByIdsTest() throws ApiException {
        var flowId = randomId();
        var namespace = randomId();
        var flow = createSimpleFlow(LOG_FLOW.formatted(flowId, namespace));
        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));
        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.getId()));

        assertThat(isTestSuiteDisabled(testSuite1)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite2)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite3)).isFalse();

        // disabling
        var idsToDisable = List.of(
            new TestSuiteControllerTestSuiteApiId().id(testSuite1.getId()).namespace(testSuite1.getNamespace()),
            new TestSuiteControllerTestSuiteApiId().id(testSuite3.getId()).namespace(testSuite3.getNamespace())
        );
        kestraClient().testSuites().disableTestSuitesByIds(MAIN_TENANT, new TestSuiteControllerTestSuiteBulkRequest().ids(idsToDisable));

        assertThat(isTestSuiteDisabled(testSuite1)).isTrue();
        assertThat(isTestSuiteDisabled(testSuite2)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite3)).isTrue();

        // re enabling the first one
        var idsToEnable = List.of(
            new TestSuiteControllerTestSuiteApiId().id(testSuite1.getId()).namespace(testSuite1.getNamespace())
        );
        kestraClient().testSuites().enableTestSuitesByIds(MAIN_TENANT, new TestSuiteControllerTestSuiteBulkRequest().ids(idsToEnable));

        assertThat(isTestSuiteDisabled(testSuite1)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite2)).isFalse();
        assertThat(isTestSuiteDisabled(testSuite3)).isTrue();
    }

    @Test
    public void searchTestSuiteTest() throws ApiException {
        var namespaceXXX = "namespacexxx_" + randomId();
        var namespaceYYY = "namespaceyyy_" + randomId();
        var flowAAA = createSimpleFlow(LOG_FLOW.formatted("flowaaa_" + randomId(), namespaceXXX));
        var flowBBB = createSimpleFlow(LOG_FLOW.formatted("flowbbb_" + randomId(), namespaceXXX));
        var flowCCC = createSimpleFlow(LOG_FLOW.formatted("flowccc_" + randomId(), namespaceYYY));

        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite111_" + randomId(), namespaceXXX, flowAAA.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite222_" + randomId(), namespaceXXX, flowAAA.getId()));

        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite333_" + randomId(), namespaceXXX, flowBBB.getId()));

        var testSuite4 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite444_" + randomId(), namespaceYYY, flowCCC.getId()));

        var page = 1;
        var size = 1000;
        var includeChildNamespaces = false;
        List<String> sort = null;

        var flowIdToSearch = flowAAA.getId();
        var searchByFlowResult = kestraClient().testSuites().searchTestSuites(page, size, includeChildNamespaces, MAIN_TENANT, sort, null, flowIdToSearch);
        assertThat(searchByFlowResult.getResults())
            .as("search by flow id: " + flowIdToSearch)
            .usingRecursiveFieldByFieldElementComparatorOnFields("id").containsExactlyInAnyOrder(testSuite1, testSuite2);

        var namespaceToSearch = namespaceYYY;
        var searchByNamespaceResult = kestraClient().testSuites().searchTestSuites(page, size, includeChildNamespaces, MAIN_TENANT, sort, namespaceToSearch, null);
        assertThat(searchByNamespaceResult.getResults())
            .as("search by namespace: " + namespaceToSearch)
            .usingRecursiveFieldByFieldElementComparatorOnFields("id").containsExactlyInAnyOrder(testSuite4);
    }

    @Test
    public void runTestSuiteTest() throws ApiException {
        var namespace = randomId();
        var flowId = randomId();
        createSimpleFlow(flowId, namespace);
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId));

        var runResult = kestraClient().testSuites().runTestSuite(namespace, testSuite.getId(), MAIN_TENANT, null);

        assertThat(runResult.getTestSuiteId()).isEqualTo(testSuite.getId());
        assertThat(runResult.getState()).isEqualTo(TestState.SUCCESS);
        assertThat(runResult.getEndDate()).isNotNull();
    }

    @Test
    public void runTestSuiteTest_failed() throws ApiException {
        var namespace = randomId();
        var flowId = randomId();
        createSimpleFlow(flowId, namespace);
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(FAILING_SIMPLE_TEST_SUITE, randomId(), namespace, flowId));

        var runResult = kestraClient().testSuites().runTestSuite(namespace, testSuite.getId(), MAIN_TENANT, null);

        assertThat(runResult.getTestSuiteId()).isEqualTo(testSuite.getId());
        assertThat(runResult.getState()).isEqualTo(TestState.FAILED);
        assertThat(runResult.getResults()).hasSize(1);
        assertThat(runResult.getResults()).first().satisfies(result -> {
            assertThat(result.getTestId()).isEqualTo("test_case_1");
            assertThat(result.getAssertionResults()).hasSize(1);
            assertThat(result.getAssertionResults()).first().satisfies(assertionResult -> {
                assertThat(assertionResult.getExpected()).isEqualTo("Hi there");
                assertThat(assertionResult.getActual()).isEqualTo("another value");
                assertThat(assertionResult.getOperator()).isEqualTo("equalTo");
                assertThat(assertionResult.getIsSuccess()).isFalse();
            });
        });
    }

    @Test
    public void runTestSuiteByQueryTest() throws ApiException {
        var namespaceXXX = "namespacexxx_" + randomId();
        var namespaceYYY = "namespaceyyy_" + randomId();
        var flowAAA = createSimpleFlow(LOG_FLOW.formatted("flowaaa_" + randomId(), namespaceXXX));
        var flowBBB = createSimpleFlow(LOG_FLOW.formatted("flowbbb_" + randomId(), namespaceXXX));
        var flowCCC = createSimpleFlow(LOG_FLOW.formatted("flowccc_" + randomId(), namespaceYYY));

        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite111_" + randomId(), namespaceXXX, flowAAA.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite222_" + randomId(), namespaceXXX, flowAAA.getId()));

        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite333_" + randomId(), namespaceXXX, flowBBB.getId()));

        var testSuite4 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite444_" + randomId(), namespaceYYY, flowCCC.getId()));

        var flowIdToRun = flowAAA.getId();
        var runByFlowIdResult = kestraClient().testSuites().runTestSuitesByQuery(
            MAIN_TENANT,
            new TestSuiteServiceRunByQueryRequest().flowId(flowIdToRun)
        );
        assertThat(runByFlowIdResult.getResults())
            .as("run by flow id: " + flowIdToRun)
            .extracting(TestSuiteRunResult::getTestSuiteId).containsExactlyInAnyOrder(testSuite1.getId(), testSuite2.getId());


        var namespaceToRun = namespaceYYY;
        var runByNamespacedResult = kestraClient().testSuites().runTestSuitesByQuery(
            MAIN_TENANT,
            new TestSuiteServiceRunByQueryRequest().namespace(namespaceToRun)
        );
        assertThat(runByNamespacedResult.getResults())
            .as("run by namespace: " + namespaceToRun)
            .extracting(TestSuiteRunResult::getTestSuiteId).containsExactlyInAnyOrder(testSuite4.getId());
    }

    @Test
    public void searchTestSuitesResultsTest() throws ApiException {
        var namespaceXXX = "namespacexxx_" + randomId();
        var namespaceYYY = "namespaceyyy_" + randomId();
        var flowAAA = createSimpleFlow(LOG_FLOW.formatted("flowaaa_" + randomId(), namespaceXXX));
        var flowBBB = createSimpleFlow(LOG_FLOW.formatted("flowbbb_" + randomId(), namespaceXXX));
        var flowCCC = createSimpleFlow(LOG_FLOW.formatted("flowccc_" + randomId(), namespaceYYY));

        var testSuite1 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite111_" + randomId(), namespaceXXX, flowAAA.getId()));
        var testSuite2 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite222_" + randomId(), namespaceXXX, flowAAA.getId()));

        var testSuite3 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite333_" + randomId(), namespaceXXX, flowBBB.getId()));

        var testSuite4 = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, "testsuite444_" + randomId(), namespaceYYY, flowCCC.getId()));

        // run all of them
        kestraClient().testSuites().runTestSuite(testSuite1.getNamespace(), testSuite1.getId(), MAIN_TENANT, new TestSuiteControllerRunRequest());
        kestraClient().testSuites().runTestSuite(testSuite1.getNamespace(), testSuite1.getId(), MAIN_TENANT, new TestSuiteControllerRunRequest());
        kestraClient().testSuites().runTestSuite(testSuite2.getNamespace(), testSuite2.getId(), MAIN_TENANT, new TestSuiteControllerRunRequest());
        kestraClient().testSuites().runTestSuite(testSuite3.getNamespace(), testSuite3.getId(), MAIN_TENANT, new TestSuiteControllerRunRequest());
        kestraClient().testSuites().runTestSuite(testSuite4.getNamespace(), testSuite4.getId(), MAIN_TENANT, new TestSuiteControllerRunRequest());


        var page = 1;
        var size = 1000;
        var includeChildNamespaces = false;
        List<String> sort = null;

        var testsuiteIdToSearch = testSuite1.getId();
        assertThat(kestraClient().testSuites().searchTestSuitesResults(page, size, MAIN_TENANT, sort, testsuiteIdToSearch, null, null).getResults())
            .as("search results by test suite id: " + testsuiteIdToSearch)
            .allMatch(result -> result.getTestSuiteId().equals(testSuite1.getId()))
            .hasSize(2);


        var flowIdToSearch = flowAAA.getId();
        assertThat(kestraClient().testSuites().searchTestSuitesResults(page, size,  MAIN_TENANT, sort, null, null, flowIdToSearch).getResults())
            .as("search results by flow id: " + flowIdToSearch)
            .allMatch(result -> result.getFlowId().equals(flowIdToSearch))
            .extracting(TestSuiteRunResult::getTestSuiteId)
            .containsExactlyInAnyOrder(testSuite1.getId(), testSuite1.getId(), testSuite2.getId());


        var namespaceToSearch = namespaceYYY;
        assertThat(kestraClient().testSuites().searchTestSuitesResults(page, size, MAIN_TENANT, sort, null, namespaceToSearch, null).getResults())
            .as("search results by namespace: " + namespaceToSearch)
            .allMatch(result -> result.getNamespace().equals(namespaceToSearch))
            .extracting(TestSuiteRunResult::getTestSuiteId)
            .containsExactlyInAnyOrder(testSuite4.getId());
    }

    @Test
    public void getTestResult() throws ApiException {
        var namespace = randomId();
        var flowId = randomId();
        createSimpleFlow(flowId, namespace);
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId));

        var testResult = kestraClient().testSuites().runTestSuite(namespace, testSuite.getId(), MAIN_TENANT, null);

        var fetchedResult = kestraClient().testSuites().testResult(testResult.getId(), MAIN_TENANT);
        assertThat(fetchedResult.getId()).isEqualTo(testResult.getId());
    }

    @Test
    public void getTestsLastResultTest() throws ApiException {
        var namespace = randomId();
        var flowId = randomId();
        createSimpleFlow(flowId, namespace);
        var testSuite = kestraClient().testSuites().createTestSuite(MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId));

        var testResult1 = kestraClient().testSuites().runTestSuite(namespace, testSuite.getId(), MAIN_TENANT, null);
        var testResult2 = kestraClient().testSuites().runTestSuite(namespace, testSuite.getId(), MAIN_TENANT, null);

        var fetchedResult = kestraClient().testSuites().testsLastResult(
            MAIN_TENANT,
            new TestSuiteControllerSearchTestsLastResult().addTestSuiteIdsItem(new TestSuiteControllerTestSuiteApiId().id(testSuite.getId()).namespace(testSuite.getNamespace()))
        );
        assertThat(fetchedResult.getResults()).usingRecursiveFieldByFieldElementComparatorOnFields("id").containsExactly(testResult2);
    }

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
