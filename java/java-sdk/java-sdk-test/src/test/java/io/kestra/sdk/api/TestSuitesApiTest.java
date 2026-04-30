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
    void searchTestSuites_withNamespace() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(randomId(), ns, flowId));

        PagedResultsTestSuite result = api().searchTestSuites(TENANT, 1, 10, null, ns, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    // ========================================================================
    // Results
    // ========================================================================

    @Test
    void searchTestSuitesResults_basic() throws ApiException {
        PagedResultsTestSuiteRunResult result =
                api().searchTestSuitesResults(TENANT, 1, 10, null, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
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
    void enableTestSuitesByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuiteControllerTestSuiteBulkRequest request = new TestSuiteControllerTestSuiteBulkRequest()
                .ids(List.of(new TestSuiteControllerTestSuiteApiId().namespace(ns).id(suiteId)));

        BulkResponse result = api().enableTestSuitesByIds(TENANT, request);

        assertThat(result).isNotNull();
    }

    @Test
    void disableTestSuitesByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String suiteId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        api().createTestSuite(TENANT, testSuiteYaml(suiteId, ns, flowId));

        TestSuiteControllerTestSuiteBulkRequest request = new TestSuiteControllerTestSuiteBulkRequest()
                .ids(List.of(new TestSuiteControllerTestSuiteApiId().namespace(ns).id(suiteId)));

        BulkResponse result = api().disableTestSuitesByIds(TENANT, request);

        assertThat(result).isNotNull();
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
