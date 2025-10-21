package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ApiAutocomplete;
import io.kestra.sdk.model.ApiSecretListResponse;
import io.kestra.sdk.model.ApiSecretMeta;
import io.kestra.sdk.model.ApiSecretMetaEE;
import io.kestra.sdk.model.ApiSecretValue;
import io.kestra.sdk.model.Namespace;
import io.kestra.sdk.model.PagedResultsNamespace;
import io.kestra.sdk.model.PluginDefault;
import io.kestra.sdk.model.QueryFilter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.kestra.example.CommonTestSetup.kestraClient;

public class NamespacesApiTest {

    /**
     * List namespaces for autocomplete
     *
     * Returns a list of namespaces for use in autocomplete fields, optionally allowing to filter by query and ids. Used especially for binding creation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void autocompleteNamespacesTest() throws ApiException {
        String tenant = null;
        ApiAutocomplete apiAutocomplete = null;
        List<String> response = kestraClient().namespaces().autocompleteNamespaces(tenant, apiAutocomplete);

        // TODO: test validations
    }
    /**
     * Create a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createNamespaceTest() throws ApiException {
        String tenant = null;
        Namespace namespace = null;
        Namespace response = kestraClient().namespaces().createNamespace(tenant, namespace);

        // TODO: test validations
    }
    /**
     * Delete a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteNamespaceTest() throws ApiException {
        String id = null;
        String tenant = null;
        kestraClient().namespaces().deleteNamespace(id, tenant);

        // TODO: test validations
    }
    /**
     * Delete a secret for a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteSecretTest() throws ApiException {
        String namespace = null;
        String key = null;
        String tenant = null;
        List<String> response = kestraClient().namespaces().deleteSecret(namespace, key, tenant);

        // TODO: test validations
    }
    /**
     * List inherited secrets
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getInheritedSecretsTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        Map<String, List<String>> response = kestraClient().namespaces().getInheritedSecrets(namespace, tenant);

        // TODO: test validations
    }
    /**
     * Get a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNamespaceTest() throws ApiException {
        String id = null;
        String tenant = null;
        Namespace response = kestraClient().namespaces().getNamespace(id, tenant);

        // TODO: test validations
    }
    /**
     * List inherited plugin defaults
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void inheritedPluginDefaultsTest() throws ApiException {
        String id = null;
        String tenant = null;
        List<PluginDefault> response = kestraClient().namespaces().inheritedPluginDefaults(id, tenant);

        // TODO: test validations
    }
    /**
     * List inherited variables
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void inheritedVariablesTest() throws ApiException {
        String id = null;
        String tenant = null;
        Map<String, Object> response = kestraClient().namespaces().inheritedVariables(id, tenant);

        // TODO: test validations
    }
    /**
     * Get secrets for a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listNamespaceSecretsTest() throws ApiException {
        String namespace = null;
        Integer page = null;
        Integer size = null;
        List<QueryFilter> filters = null;
        String tenant = null;
        List<String> sort = null;
        ApiSecretListResponse response = kestraClient().namespaces().listNamespaceSecrets(namespace, page, size, filters, tenant, sort);

        // TODO: test validations
    }
    /**
     * Patch a secret metadata for a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchSecretTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        String key = null;
        ApiSecretMetaEE apiSecretMetaEE = null;
        List<ApiSecretMeta> response = kestraClient().namespaces().patchSecret(namespace, tenant, key, apiSecretMetaEE);

        // TODO: test validations
    }
    /**
     * Update secrets for a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void putSecretsTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        ApiSecretValue apiSecretValue = null;
        List<ApiSecretMeta> response = kestraClient().namespaces().putSecrets(namespace, tenant, apiSecretValue);

        // TODO: test validations
    }
    /**
     * Search for namespaces
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchNamespacesTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        Boolean existing = null;
        String tenant = null;
        String q = null;
        List<String> sort = null;
        PagedResultsNamespace response = kestraClient().namespaces().searchNamespaces(page, size, existing, tenant, q, sort);

        // TODO: test validations
    }
    /**
     * Update a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateNamespaceTest() throws ApiException {
        String id = null;
        String tenant = null;
        Namespace namespace = null;
        Namespace response = kestraClient().namespaces().updateNamespace(id, tenant, namespace);

        // TODO: test validations
    }
}
