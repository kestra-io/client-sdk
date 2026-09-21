package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.ValidateConstraintViolation;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the policy endpoints under {@code /api/v1/{tenant}/policies/**} and
 * {@code /api/v1/instance/policies/**}. Policies are authored as YAML; the controller sets the
 * scope from the path, so the source only needs an id and a non-empty rule list.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PoliciesApiTest {

    static PoliciesApi api() {
        return client().policies();
    }

    /** A minimal, valid policy: deny the Log plugin. {@code id} must be an RFC 1123 label. */
    static String policySource(String id, String description) {
        return """
                id: %s
                description: %s
                rules:
                  - type: io.kestra.plugin.ee.rules.Deny
                    on: PLUGIN
                    action: BLOCK
                    errorMessage: denied by sdk test
                    where:
                      - field: type
                        operator: EQUAL_TO
                        value: io.kestra.plugin.core.log.Log
                """.formatted(id, description);
    }

    static String policyId() {
        return "p" + randomId();
    }

    static File bytesToTempFile(byte[] content) throws IOException {
        File f = Files.createTempFile("policy", ".yaml").toFile();
        Files.write(f.toPath(), content);
        f.deleteOnExit();
        return f;
    }

    static void deleteQuietly(String id) {
        try {
            api().deletePolicy(TENANT, id);
        } catch (ApiException ignored) {
        }
    }

    static void deleteInstanceQuietly(String id) {
        try {
            api().deleteInstancePolicy(id);
        } catch (ApiException ignored) {
        }
    }

    // ========================================================================
    // Read / binding guards
    // ========================================================================

    @Test
    void searchPolicies_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchPolicies(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void searchInstancePolicies_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchInstancePolicies(1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getPolicy_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getPolicy(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    @Test
    void getInstancePolicy_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getInstancePolicy("does-not-exist-" + randomId(), null))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    // ========================================================================
    // Validate
    // ========================================================================

    @Test
    void validatePolicy_invalidSource_reportsViolation() throws ApiException {
        // An empty rule list violates @NotEmpty; the validate endpoint surfaces that as a
        // constraint violation payload rather than throwing.
        ValidateConstraintViolation result = api().validatePolicy(TENANT, "id: bad-" + randomId() + "\nrules: []\n");

        assertThat(result.getConstraints()).isNotNull();
    }

    @Test
    void validateInstancePolicy_validSource_hasNoViolation() throws ApiException {
        ValidateConstraintViolation result = api().validateInstancePolicy(policySource(policyId(), "valid"));

        assertThat(result.getConstraints()).isNull();
    }

    // ========================================================================
    // Tenant-scoped lifecycle
    // ========================================================================

    @Test
    void tenantPolicy_createGetUpdateEvaluateExportDelete() throws ApiException {
        String id = policyId();

        try {
            Map<String, Object> created = api().createPolicy(TENANT, policySource(id, "sdk test policy"));
            assertThat(created.get("id")).isEqualTo(id);
            assertThat(created.get("scope")).isEqualTo("TENANT");

            Map<String, Object> got = api().getPolicy(TENANT, id);
            assertThat(got.get("id")).isEqualTo(id);
            assertThat(got.get("description")).isEqualTo("sdk test policy");

            Map<String, Object> updated = api().updatePolicy(TENANT, id, policySource(id, "sdk test policy v2"));
            assertThat(updated.get("description")).isEqualTo("sdk test policy v2");

            Map<String, Object> evaluation = api().evaluatePolicy(TENANT, id, 1, 10);
            assertThat(evaluation).containsKeys("total", "results");
            assertThat(evaluation.get("results")).isInstanceOf(List.class);

            byte[] export = api().exportPolicies(TENANT);
            assertThat(export).isNotEmpty();

            byte[] exportByIds = api().exportPoliciesByIds(TENANT, List.of(id));
            assertThat(exportByIds).isNotEmpty();
        } finally {
            deleteQuietly(id);
        }

        assertThatThrownBy(() -> api().getPolicy(TENANT, id))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    @Test
    void tenantPolicy_deleteByIdsAndReimport() throws ApiException, IOException {
        String id = policyId();

        try {
            api().createPolicy(TENANT, policySource(id, "to be re-imported"));

            byte[] exported = api().exportPoliciesByIds(TENANT, List.of(id));
            assertThat(exported).isNotEmpty();

            BulkResponse deleted = api().deletePoliciesByIds(TENANT, List.of(id));
            assertThat(deleted.getCount()).isGreaterThanOrEqualTo(1);
            assertThatThrownBy(() -> api().getPolicy(TENANT, id))
                    .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));

            Map<String, Object> imported = api().importPolicies(TENANT, bytesToTempFile(exported));
            assertThat(((Number) imported.get("imported")).intValue()).isGreaterThanOrEqualTo(1);
            assertThat(api().getPolicy(TENANT, id).get("id")).isEqualTo(id);
        } finally {
            deleteQuietly(id);
        }
    }

    // ========================================================================
    // Instance-scoped lifecycle (IsInstanceOwner)
    // ========================================================================

    @Test
    void instancePolicy_createGetUpdateEvaluateExportDelete() throws ApiException {
        String id = policyId();

        try {
            Map<String, Object> created = api().createInstancePolicy(policySource(id, "instance policy"));
            assertThat(created.get("id")).isEqualTo(id);
            assertThat(created.get("scope")).isEqualTo("INSTANCE");

            Map<String, Object> got = api().getInstancePolicy(id, null);
            assertThat(got.get("id")).isEqualTo(id);

            Map<String, Object> updated = api().updateInstancePolicy(id, policySource(id, "instance policy v2"));
            assertThat(updated.get("description")).isEqualTo("instance policy v2");

            Map<String, Object> evaluation = api().evaluateInstancePolicy(id, 1, 10, null);
            assertThat(evaluation).containsKeys("total", "results");

            assertThat(api().exportInstancePolicies()).isNotEmpty();
            assertThat(api().exportInstancePoliciesByIds(List.of(id))).isNotEmpty();
        } finally {
            deleteInstanceQuietly(id);
        }

        assertThatThrownBy(() -> api().getInstancePolicy(id, null))
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    @Test
    void instancePolicy_deleteByIds() throws ApiException {
        String id = policyId();

        try {
            api().createInstancePolicy(policySource(id, "instance delete-by-ids"));

            BulkResponse deleted = api().deleteInstancePoliciesByIds(List.of(id));
            assertThat(deleted.getCount()).isGreaterThanOrEqualTo(1);

            assertThatThrownBy(() -> api().getInstancePolicy(id, null))
                    .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
        } finally {
            deleteInstanceQuietly(id);
        }
    }
}
