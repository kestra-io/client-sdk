package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NamespacesApiTest {

    @Test
    public void autocompleteNamespacesTest() throws ApiException {
        String prefix = "test_autocomplete_namespaces_" + randomId();
        Namespace ns = new Namespace().id(prefix).deleted(false);

        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        ApiAutocomplete ac = new ApiAutocomplete().q(prefix);
        List<String> results = kestraClient().namespaces().autocompleteNamespaces(MAIN_TENANT, ac);

        assertTrue(results.stream().anyMatch(r -> r.equals(created.getId())),
            "Autocomplete should include the created namespace id");
    }

    @Test
    public void createNamespaceTest() throws ApiException {
        String nsId = "test_create_namespace_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);

        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        assertEquals(nsId, created.getId());
        assertNotNull(created);
    }

    @Test
    public void deleteNamespaceTest() throws ApiException {
        String nsId = "test_delete_namespace_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);

        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        kestraClient().namespaces().deleteNamespace(created.getId(), MAIN_TENANT);

        assertThrows(ApiException.class,
            () -> kestraClient().namespaces().namespace(created.getId(), MAIN_TENANT),
            "Fetching a deleted namespace should throw");
    }

    @Test
    public void getInheritedSecretsTest() throws ApiException {
        String nsId = "test_get_inherited_secrets_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        Map<String, List<String>> inherited =
            kestraClient().namespaces().inheritedSecrets(created.getId(), MAIN_TENANT);

        assertNotNull(inherited);
        // Python only asserted it's a dict; here we just ensure non-null map.
    }

    @Test
    public void getNamespaceTest() throws ApiException {
        String nsId = "test_get_namespace_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        Namespace fetched = kestraClient().namespaces().namespace(created.getId(), MAIN_TENANT);

        assertEquals(created.getId(), fetched.getId());
    }

    @Test
    public void inheritedPluginDefaultsTest() throws ApiException {
        String nsId = "test_inherited_plugin_defaults_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        List<PluginDefault> defaults =
            kestraClient().namespaces().inheritedPluginDefaults(created.getId(), MAIN_TENANT);

        assertNotNull(defaults);
        // Python only checked it's a list.
    }

    @Test
    public void inheritedVariablesTest() throws ApiException {
        String nsId = "test_inherited_variables_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        Map<String, Object> variables =
            kestraClient().namespaces().inheritedVariables(created.getId(), MAIN_TENANT);

        assertNotNull(variables);
        // Python only checked it's a dict.
    }

    @Test
    public void listNamespaceSecretsTest() throws ApiException {
        String nsId = "test_list_namespace_secrets_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);
        String key = "list_keys_key_" + randomId();
        String unwantedKey = "unwanted_" + randomId();

        // Create one secret so the list call has something to return

        kestraClient().namespaces().putSecrets(
            created.getId(), MAIN_TENANT,
            new ApiSecretValue().key(key).value("list-value"));
        kestraClient().namespaces().putSecrets(
            created.getId(), MAIN_TENANT,
            new ApiSecretValue().key(unwantedKey).value("list-value"));

        QueryFilter queryFilter = new QueryFilter();
        queryFilter.setField(QueryFilterField.QUERY);
        queryFilter.setOperation(QueryFilterOp.CONTAINS);
        queryFilter.setValue("keys");

        ApiSecretListResponseApiSecretMeta entries =
            kestraClient().namespaces().listNamespaceSecrets(created.getId(), 1, 10, List.of(queryFilter), MAIN_TENANT, null);

        assertNotNull(entries);
        assertNotNull(entries.getResults(), "Results should not be null");
        assertThat(entries.getResults().stream().map(ApiSecretMetaEE::getKey)).contains(key);
        assertThat(entries.getResults().stream().map(ApiSecretMetaEE::getKey)).doesNotContain(unwantedKey);
    }

    @Test
    public void patchSecretTest() throws ApiException {
        String nsId = "test_patch_secret_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        // Create the secret first (Python used put_secrets in this test)
        String key = "test_patch_secret_key_" + randomId();
        kestraClient().namespaces().putSecrets(
            created.getId(), MAIN_TENANT,
            new ApiSecretValue().key(key).value("secretValue"));

        // Now patch its metadata (description, tags, etc. as supported by your SDK)
        ApiSecretMetaEE meta = new ApiSecretMetaEE();
        meta.setKey(key);
        List<ApiSecretMetaEE> metas =
            kestraClient().namespaces().patchSecret(created.getId(), key, MAIN_TENANT, meta);

        assertNotNull(metas, "Patch response metas should not be null");
    }

    @Test
    public void putSecretsTest() throws ApiException {
        String nsId = "test_put_secrets_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        List<ApiSecretMetaEE> metas = kestraClient().namespaces().putSecrets(
            created.getId(),
            MAIN_TENANT,
            new ApiSecretValue().key("test_put_secrets_key_" + randomId()).value("value-put"));

        assertNotNull(metas);
    }

    @Test
    public void searchNamespacesTest() throws ApiException {
        String nsId = "test_search_namespaces_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        // page=1, size=10 like Python
        PagedResultsNamespace results =
            kestraClient().namespaces().searchNamespaces(1, 10, false, MAIN_TENANT, nsId, null);

        assertNotNull(results);
        assertNotNull(results.getResults());
        assertTrue(results.getResults().stream().anyMatch(r -> created.getId().equals(r.getId())),
            "Search should return the created namespace");
    }

    @Test
    public void updateNamespaceTest() throws ApiException {
        String nsId = "test_update_namespace_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        // Python test only fetched; here we call update with the same payload (id/deleted) then verify id.
        Namespace updateBody = new Namespace().id(created.getId()).deleted(false);
        Namespace updated = kestraClient().namespaces().updateNamespace(created.getId(), MAIN_TENANT, updateBody);

        assertEquals(created.getId(), updated.getId());
    }

    /** Optional extra derived from Java skeleton (not present in Python): deleteSecret */
    @Test
    public void deleteSecretTest() throws ApiException {
        String nsId = "test_delete_secret_" + randomId();
        Namespace ns = new Namespace().id(nsId).deleted(false);
        Namespace created = kestraClient().namespaces().createNamespace(MAIN_TENANT, ns);

        String key = "to_delete_key_" + randomId();
        kestraClient().namespaces().putSecrets(
            created.getId(), MAIN_TENANT, new ApiSecretValue().key(key).value("to-delete"));

        kestraClient().namespaces().deleteSecret(created.getId(), key, MAIN_TENANT);

        ApiSecretListResponseApiSecretMeta list =
            kestraClient().namespaces().listNamespaceSecrets(created.getId(), 1, 10, List.of(), MAIN_TENANT, null);

        boolean stillPresent = list != null && list.getResults() != null
            && list.getResults().stream().anyMatch(m -> key.equals(m.getKey()));
        assertFalse(stillPresent, "Deleted secret should not be listed anymore");
    }
}
