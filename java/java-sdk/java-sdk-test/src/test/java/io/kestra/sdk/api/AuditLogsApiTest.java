package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the audit-log endpoints. Audit logs need the EE
 * {@code FEATURE_AUDIT_LOGS} license feature; on a CI image without it the resource is
 * gated (403), so the read-only tests accept either the real payload or that gate.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditLogsApiTest {

    static AuditLogsApi api() {
        return client().auditLogs();
    }

    @Test
    void searchAuditLogs_isPagedOrGated() throws ApiException {
        try {
            Map<String, Object> result = api().searchAuditLogs(TENANT, 1, 10, null, null);
            assertThat(result).containsKey("results");
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(403, 404);
        }
    }

    @Test
    void searchAllAuditLogs_isPagedOrGated() throws ApiException {
        try {
            Map<String, Object> result = api().searchAllAuditLogs(1, 10, null, null);
            assertThat(result).containsKey("results");
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(403, 404);
        }
    }
}
