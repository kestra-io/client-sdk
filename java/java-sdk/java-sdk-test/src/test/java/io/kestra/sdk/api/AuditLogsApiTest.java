package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

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
}
