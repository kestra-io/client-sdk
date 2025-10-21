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

import static io.kestra.example.CommonTestSetup.*;

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

        ApiAutocomplete apiAutocomplete = null;
        List<String> response = kestraClient().namespaces().autocompleteNamespaces(MAIN_TENANT, apiAutocomplete);

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

        Namespace namespace = null;
        Namespace response = kestraClient().namespaces().createNamespace(MAIN_TENANT, namespace);

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
        String id = randomId();

        kestraClient().namespaces().deleteNamespace(id, MAIN_TENANT);

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
        String namespace = randomId();
        String key = null;

        List<String> response = kestraClient().namespaces().deleteSecret(namespace, key, MAIN_TENANT);

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
        String namespace = randomId();

        Map<String, List<String>> response = kestraClient().namespaces().getInheritedSecrets(namespace, MAIN_TENANT);

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
        String id = randomId();

        Namespace response = kestraClient().namespaces().getNamespace(id, MAIN_TENANT);

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
        String id = randomId();

        List<PluginDefault> response = kestraClient().namespaces().inheritedPluginDefaults(id, MAIN_TENANT);

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
        String id = randomId();

        Map<String, Object> response = kestraClient().namespaces().inheritedVariables(id, MAIN_TENANT);

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
        String namespace = randomId();
        Integer page = null;
        Integer size = null;
        List<QueryFilter> filters = null;

        List<String> sort = null;
        ApiSecretListResponse response = kestraClient().namespaces().listNamespaceSecrets(namespace, page, size, filters, MAIN_TENANT, sort);

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
        String namespace = randomId();

        String key = null;
        ApiSecretMetaEE apiSecretMetaEE = null;
        List<ApiSecretMeta> response = kestraClient().namespaces().patchSecret(namespace, MAIN_TENANT, key, apiSecretMetaEE);

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
        String namespace = randomId();

        ApiSecretValue apiSecretValue = null;
        List<ApiSecretMeta> response = kestraClient().namespaces().putSecrets(namespace, MAIN_TENANT, apiSecretValue);

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

        String q = null;
        List<String> sort = null;
        PagedResultsNamespace response = kestraClient().namespaces().searchNamespaces(page, size, existing, MAIN_TENANT, q, sort);

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
        String id = randomId();

        Namespace namespace = null;
        Namespace response = kestraClient().namespaces().updateNamespace(id, MAIN_TENANT, namespace);

        // TODO: test validations
    }
}
