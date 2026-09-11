package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NamespacesApiTest {

    static NamespacesApi api() {
        return client().namespaces();
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createNamespace_basic() throws ApiException {
        String id = randomId();
        Namespace ns = new Namespace().id(id).description("Test namespace");

        Namespace result = api().createNamespace(TENANT, ns);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getDescription()).isEqualTo("Test namespace");
    }

    @Test
    void namespace_getById() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        Namespace result = api().namespace(id, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void updateNamespace_changeDescription() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id).description("original"));

        Namespace updated = api().updateNamespace(id, TENANT,
                new Namespace().id(id).description("updated"));

        assertThat(updated.getDescription()).isEqualTo("updated");
    }

    @Test
    void deleteNamespace_basic() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        assertThatCode(() -> api().deleteNamespace(id, TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search & Autocomplete
    // ========================================================================

    @Test
    void searchNamespaces_basic() throws ApiException {
        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 10, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchNamespaces_withQuery() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 10, null, null, List.of(queryFilter(id)));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults()).anyMatch(ns -> id.equals(ns.getId()));
    }

    @Test
    void searchNamespaces_withPagination() throws ApiException {
        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 2, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchNamespaces_existingOnly() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        // existing=true routes to the namespace repository, which has no QUERY-filter
        // support; NAMESPACE maps to the id column and works on both search paths.
        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 10, null, true, List.of(nsFilter(id)));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults()).anyMatch(ns -> id.equals(ns.getId()));
    }

    @Test
    void searchNamespaces_withSort() throws ApiException {
        String prefix = "sortns" + randomId().substring(0, 6);
        String id1 = prefix + "aaa";
        String id2 = prefix + "zzz";
        api().createNamespace(TENANT, new Namespace().id(id2));
        api().createNamespace(TENANT, new Namespace().id(id1));

        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 10, List.of("id:asc"), null, List.of(queryFilter(prefix)));

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> ids = result.getResults().stream().map(Namespace::getId).toList();
        int idx1 = ids.indexOf(id1);
        int idx2 = ids.indexOf(id2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    void searchNamespaces_noResults() throws ApiException {
        PagedResultsNamespace result = api().searchNamespaces(TENANT, 1, 10, null, null, List.of(queryFilter("nonexistent_ns_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    @Test
    void autocompleteNamespaces_basic() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        ApiAutocomplete request = new ApiAutocomplete().q(id.substring(0, 8));
        List<String> result = api().autocompleteNamespaces(TENANT, request);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Secrets
    // ========================================================================

    @Test
    void putSecrets_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        ApiSecretValue secret = new ApiSecretValue().key("MY_SECRET").value("secret_value");
        List<ApiSecretMetaEE> result = api().putSecrets(ns, TENANT, secret);

        assertThat(result).isNotNull();
    }

    @Test
    void deleteSecret_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().putSecrets(ns, TENANT, new ApiSecretValue().key("TO_DELETE").value("val"));

        assertThatCode(() -> api().deleteSecret(ns, "TO_DELETE", TENANT))
                .doesNotThrowAnyException();
    }

    @Test
    void inheritedSecrets_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));

        Map<String, List<String>> result = api().inheritedSecrets(ns, TENANT);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Variables
    // ========================================================================

    @Test
    void inheritedVariables_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        Map<String, Object> result = api().inheritedVariables(ns, TENANT);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Patch secret
    // ========================================================================

    @Test
    void patchSecret_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().putSecrets(ns, TENANT, new ApiSecretValue().key("PATCH_ME").value("original"));

        ApiSecretMetaEE meta = new ApiSecretMetaEE().description("patched description");
        List<ApiSecretMetaEE> result = api().patchSecret(ns, "PATCH_ME", TENANT, meta);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Policies (EE)
    // ========================================================================

    private static String policyYaml(String id) {
        return """
                id: %s
                enforcement: EVALUATE
                rules:
                  - type: io.kestra.plugin.ee.rules.Deny
                    on: PLUGIN
                """.formatted(id);
    }

    @Test
    void createNamespacePolicy_thenGetThenDelete() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();

        Map<String, Object> created = api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));
        assertThat(created.get("id")).isEqualTo(policyId);
        assertThat(created.get("enforcement")).isEqualTo("EVALUATE");

        Map<String, Object> fetched = api().getNamespacePolicy(ns, policyId, TENANT);
        assertThat(fetched.get("id")).isEqualTo(policyId);

        assertThatCode(() -> api().deleteNamespacePolicy(ns, policyId, TENANT)).doesNotThrowAnyException();
    }

    @Test
    void updateNamespacePolicy_changesEnforcement() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();
        api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));

        String updatedYaml = """
                id: %s
                enforcement: ACTIVE
                rules:
                  - type: io.kestra.plugin.ee.rules.Deny
                    on: PLUGIN
                """.formatted(policyId);
        Map<String, Object> updated = api().updateNamespacePolicy(ns, policyId, TENANT, updatedYaml);

        assertThat(updated.get("enforcement")).isEqualTo("ACTIVE");
    }

    @Test
    void searchNamespacePolicies_findsCreatedPolicy() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();
        api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            Map<String, Object> result = api().searchNamespacePolicies(ns, TENANT, 1, 10, null);
            assertThat(((Number) result.get("total")).longValue()).isGreaterThanOrEqualTo(1L);
        });
    }

    @Test
    void deleteNamespacePoliciesByIds_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();
        api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));

        BulkResponse result = api().deleteNamespacePoliciesByIds(ns, TENANT, List.of(policyId));

        assertThat(result).isNotNull();
    }

    @Test
    void validateNamespacePolicy_missingRequiredFields_reportsViolation() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));

        ValidateConstraintViolation result = api().validateNamespacePolicy(ns, TENANT, "id: incomplete-policy");

        assertThat(result.getConstraints()).isNotBlank();
    }

    @Test
    void exportNamespacePolicies_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        api().createNamespacePolicy(ns, TENANT, policyYaml(randomId()));

        byte[] result = api().exportNamespacePolicies(ns, TENANT);

        assertThat(result).isNotEmpty();
    }

    @Test
    void exportNamespacePoliciesByIds_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();
        api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));

        byte[] result = api().exportNamespacePoliciesByIds(ns, TENANT, List.of(policyId));

        assertThat(result).isNotEmpty();
    }

    @Test
    void evaluateNamespacePolicy_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));
        String policyId = randomId();
        api().createNamespacePolicy(ns, TENANT, policyYaml(policyId));

        Map<String, Object> result = api().evaluateNamespacePolicy(ns, policyId, TENANT, 1, 10);

        assertThat(result).isNotNull();
    }

    // Reusable inputs (EE) are covered by ReusableInputsApiTest, not here.
}
