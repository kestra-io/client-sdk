package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

/**
 * Live tests for the audit-log endpoints. The CI image ships the EE
 * {@code FEATURE_AUDIT_LOGS} license, so both scopes answer with a real paged envelope.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditLogsApiTest {

    static AuditLogsApi api() {
        return client().auditLogs();
    }

    @Test
    void searchAuditLogs_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchAuditLogs(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void searchAllAuditLogs_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchAllAuditLogs(1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getAuditLogHistory_listsTheEntriesOfOneFlow() throws ApiException {
        var flow = createLogFlow();
        var filters = List.of(
            new QueryFilter().field(QueryFilterField.RESOURCES).operation(QueryFilterOp.EQUALS).value("FLOW"),
            new QueryFilter().field(QueryFilterField.ID).operation(QueryFilterOp.EQUALS).value(flow.getId()),
            nsFilter(flow.getNamespace())
        );

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() ->
            assertThat((List<?>) api().getAuditLogHistory(TENANT, 1, 10, null, filters).get("results")).isNotEmpty()
        );
    }
}
