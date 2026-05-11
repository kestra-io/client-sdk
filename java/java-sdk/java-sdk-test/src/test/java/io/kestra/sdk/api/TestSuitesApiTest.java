package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSuitesApiTest {

    static TestSuitesApi api() {
        return client().testSuites();
    }

    static String testSuiteYaml(String id, String namespace, String flowId) {
        return """
                id: %s
                namespace: %s
                flowId: %s
                disabled: false
                testCases:
                  - id: test_case_1
                    type: io.kestra.core.test.flow.UnitTest
                    description: Basic test case
                    assertions:
                      - taskId: hello
                        value: "{{ outputs.hello }}"
                        isNotNull: true
                """.formatted(id, namespace, flowId);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createTestSuite_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        TestSuite result = api().createTestSuite(TENANT, testSuiteYaml(randomId(), ns, flowId));

        assertThat(result).isNotNull();
        assertThat(result.getNamespace()).isEqualTo(ns);
    }

    @Test
    void testSuite_getByNamespaceAndId() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuite result = api().testSuite(ns, suiteId, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(suiteId);
    }

    @Test
    void deleteTestSuite_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        assertThatCode(() -> api().deleteTestSuite(ns, suiteId, TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchTestSuites_basic() throws ApiException {
        PagedResultsTestSuite result = api().searchTestSuites(TENANT, 1, 10, null, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchTestSuites_withNamespaceAndFlowId() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(randomId(), ns, flowId));

        PagedResultsTestSuite byNs = api().searchTestSuites(TENANT, 1, 10, null, ns, null, null);
        assertThat(byNs).isNotNull();
        assertThat(byNs.getResults()).isNotNull();

        PagedResultsTestSuite byFlowId = api().searchTestSuites(TENANT, 1, 10, null, ns, flowId, null);
        assertThat(byFlowId).isNotNull();
        assertThat(byFlowId.getResults()).isNotNull().isNotEmpty();
        assertThat(byFlowId.getResults()).allSatisfy(ts ->
                assertThat(ts.getFlowId()).isEqualTo(flowId));
    }

    @Test
    void searchTestSuites_withSort() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        String suiteId1 = "aaa" + randomId();
        String suiteId2 = "zzz" + randomId();
        api().createTestSuite(TENANT, testSuiteYaml(suiteId2, ns, flowId));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId1, ns, flowId));

        PagedResultsTestSuite sorted = api().searchTestSuites(TENANT, 1, 10, List.of("id:asc"), ns, null, null);
        assertThat(sorted.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> ids = sorted.getResults().stream().map(TestSuite::getId).toList();
        assertThat(ids.indexOf(suiteId1)).isLessThan(ids.indexOf(suiteId2));
    }

    @Test
    void searchTestSuites_noResults() throws ApiException {
        PagedResultsTestSuite result = api().searchTestSuites(TENANT, 1, 10, null, "nonexistent_ns_" + randomId(), null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // Results
    // ========================================================================

    @Test
    void searchTestSuitesResults_allParams() throws ApiException {
        PagedResultsTestSuiteRunResult result =
                api().searchTestSuitesResults(TENANT, 1, 10, null, null, null, null);
        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();

        PagedResultsTestSuiteRunResult sorted =
                api().searchTestSuitesResults(TENANT, 1, 10, List.of("id:asc"), null, null, null);
        assertThat(sorted).isNotNull();
        assertThat(sorted.getResults()).isNotNull();

        PagedResultsTestSuiteRunResult byNs =
                api().searchTestSuitesResults(TENANT, 1, 10, null, null, "nonexistent_ns", null);
        assertThat(byNs).isNotNull();
        assertThat(byNs.getResults()).isEmpty();

        PagedResultsTestSuiteRunResult byTestSuiteId =
                api().searchTestSuitesResults(TENANT, 1, 10, null, "nonexistent_suite", null, null);
        assertThat(byTestSuiteId).isNotNull();
        assertThat(byTestSuiteId.getResults()).isEmpty();

        PagedResultsTestSuiteRunResult byFlowId =
                api().searchTestSuitesResults(TENANT, 1, 10, null, null, null, "nonexistent_flow");
        assertThat(byFlowId).isNotNull();
        assertThat(byFlowId.getResults()).isEmpty();
    }


    // ========================================================================
    // Validation
    // ========================================================================

    @Test
    void validateTestSuite_valid() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        ValidateConstraintViolation result = api().validateTestSuite(TENANT,
                testSuiteYaml(randomId(), ns, flowId));

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Update
    // ========================================================================

    @Test
    void updateTestSuite_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        String updatedYaml = testSuiteYaml(suiteId, ns, flowId).replace("Basic test case", "Updated test case");
        TestSuite result = api().updateTestSuite(ns, suiteId, TENANT, updatedYaml);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(suiteId);
    }

    // ========================================================================
    // Bulk operations
    // ========================================================================

    @Test
    void deleteTestSuitesByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuiteControllerTestSuiteBulkRequest request = new TestSuiteControllerTestSuiteBulkRequest()
                .ids(List.of(new TestSuiteControllerTestSuiteApiId().namespace(ns).id(suiteId)));

        BulkResponse result = api().deleteTestSuitesByIds(TENANT, request);

        assertThat(result).isNotNull();
    }

    @Test
    void enableDisableTestSuitesByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuiteControllerTestSuiteBulkRequest request = new TestSuiteControllerTestSuiteBulkRequest()
                .ids(List.of(new TestSuiteControllerTestSuiteApiId().namespace(ns).id(suiteId)));

        BulkResponse disabled = api().disableTestSuitesByIds(TENANT, request);
        assertThat(disabled).isNotNull();

        BulkResponse enabled = api().enableTestSuitesByIds(TENANT, request);
        assertThat(enabled).isNotNull();
    }

    // ========================================================================
    // Run
    // ========================================================================

    @Test
    void runTestSuite_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuiteRunResult result = api().runTestSuite(ns, suiteId, TENANT, null);

        assertThat(result).isNotNull();
    }

    @Test
    void runTestSuitesByQuery_basic() throws ApiException {
        TestSuiteServiceRunByQueryRequest request = new TestSuiteServiceRunByQueryRequest();

        TestSuiteServiceTestRunByQueryResult result = api().runTestSuitesByQuery(TENANT, request);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Results details
    // ========================================================================

    @Test
    void testsLastResult_basic() throws ApiException {
        TestSuiteControllerSearchTestsLastResult request = new TestSuiteControllerSearchTestsLastResult();

        TestSuiteControllerTestsLastResultResponse result = api().testsLastResult(TENANT, request);

        assertThat(result).isNotNull();
    }
}
