package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CasesApiTest {

    static CasesApi api() {
        return client().cases();
    }

    static CasesControllerCaseFromTaskRequest request(String flowNamespace, String flowId, String taskId, boolean linkMatchingExecutions) {
        return new CasesControllerCaseFromTaskRequest()
                .namespace(flowNamespace)
                .title("Case for " + flowId)
                .flowNamespace(flowNamespace)
                .flowId(flowId)
                .taskId(taskId)
                .linkMatchingExecutions(linkMatchingExecutions);
    }

    @Test
    void createFromTask_basic() throws ApiException {
        String flowId = randomId();

        var result = api().createFromTask(TENANT, request(randomId(), flowId, randomId(), false));

        assertThat(result).isNotNull();
        assertThat(result.get("caseId")).isNotNull();
        assertThat(result.get("created")).isEqualTo(true);
    }

    @Test
    void createFromTask_dedupesActiveCaseWithSameOrigin() throws ApiException {
        String flowNamespace = randomId();
        String flowId = randomId();
        String taskId = randomId();

        var first = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, true));
        var second = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, true));

        assertThat(first.get("created")).isEqualTo(true);
        assertThat(second.get("created")).isEqualTo(false);
        assertThat(second.get("caseId")).isEqualTo(first.get("caseId"));
    }

    @Test
    void createFromTask_noDedupeWithoutLinkMatchingExecutions() throws ApiException {
        String flowNamespace = randomId();
        String flowId = randomId();
        String taskId = randomId();

        var first = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, false));
        var second = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, false));

        assertThat(first.get("created")).isEqualTo(true);
        assertThat(second.get("created")).isEqualTo(true);
        assertThat(second.get("caseId")).isNotEqualTo(first.get("caseId"));
    }
}
