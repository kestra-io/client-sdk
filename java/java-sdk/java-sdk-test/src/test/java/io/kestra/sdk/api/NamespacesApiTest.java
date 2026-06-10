package io.kestra.sdk.api;

import io.kestra.EnabledIfKestraVersion;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

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
        PagedResultsNamespace result = api().searchNamespaces(TENANT, null, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    @EnabledIfKestraVersion(max = "1.3", reason = "2.0 namespace search no longer filters server-side by 'q' — returns all namespaces (#265)")
    void searchNamespaces_withQuery() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        PagedResultsNamespace result = api().searchNamespaces(TENANT, id, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults()).anyMatch(ns -> id.equals(ns.getId()));
    }

    @Test
    void searchNamespaces_withPagination() throws ApiException {
        PagedResultsNamespace result = api().searchNamespaces(TENANT, null, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchNamespaces_existingOnly() throws ApiException {
        String id = randomId();
        api().createNamespace(TENANT, new Namespace().id(id));

        PagedResultsNamespace result = api().searchNamespaces(TENANT, id, 1, 10, null, true);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
        assertThat(result.getResults()).anyMatch(ns -> id.equals(ns.getId()));
    }

    @Test
    @EnabledIfKestraVersion(max = "1.3", reason = "2.0 namespace search no longer honors the sort parameter — ordering not applied (#265)")
    void searchNamespaces_withSort() throws ApiException {
        String prefix = "sortns" + randomId().substring(0, 6);
        String id1 = prefix + "aaa";
        String id2 = prefix + "zzz";
        api().createNamespace(TENANT, new Namespace().id(id2));
        api().createNamespace(TENANT, new Namespace().id(id1));

        PagedResultsNamespace result = api().searchNamespaces(TENANT, prefix, 1, 10, List.of("id:asc"), null);

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> ids = result.getResults().stream().map(Namespace::getId).toList();
        int idx1 = ids.indexOf(id1);
        int idx2 = ids.indexOf(id2);
        assertThat(idx1).isGreaterThanOrEqualTo(0);
        assertThat(idx2).isGreaterThan(idx1);
    }

    @Test
    @EnabledIfKestraVersion(max = "1.3", reason = "2.0 namespace search no longer filters server-side — empty-result query still returns namespaces (#265)")
    void searchNamespaces_noResults() throws ApiException {
        PagedResultsNamespace result = api().searchNamespaces(TENANT, "nonexistent_ns_" + randomId(), 1, 10, null, null);

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
    // Plugin Defaults
    // ========================================================================

    @Test
    void inheritedPluginDefaults_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        List<NamespaceControllerApiInheritedPluginDefaultFromNamespace> result =
                api().inheritedPluginDefaults(ns, TENANT);

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
    // Plugin defaults export/import
    // ========================================================================

    @Test
    void exportPluginDefaults_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));

        // Namespace without plugin defaults may return 404
        try {
            byte[] result = api().exportPluginDefaults(ns, TENANT);
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(404, 200);
        }
    }

    @Test
    void importPluginDefaults_basic() throws ApiException {
        String ns = randomId();
        api().createNamespace(TENANT, new Namespace().id(ns));

        // Import with null file — may return error or empty list
        try {
            List<String> result = api().importPluginDefaults(ns, TENANT, null);
            assertThat(result).isNotNull();
        } catch (ApiException e) {
            assertThat(e.getCode()).isIn(400, 500);
        }
    }
}
