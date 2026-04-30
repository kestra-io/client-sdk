package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

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
}
