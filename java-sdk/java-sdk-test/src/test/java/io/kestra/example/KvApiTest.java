package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.KVControllerApiDeleteBulkRequest;
import io.kestra.sdk.model.KVControllerApiDeleteBulkResponse;
import io.kestra.sdk.model.KVControllerTypedValue;
import io.kestra.sdk.model.KVEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.kestraClient;

public class KvApiTest {

    /**
     * Delete a key-value pair
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteKeyValueTest() throws ApiException {
        String namespace = null;
        String key = null;
        String tenant = null;
        Boolean response = kestraClient().kv().deleteKeyValue(namespace, key, tenant);

        // TODO: test validations
    }
    /**
     * Bulk-delete multiple key/value pairs from the given namespace.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteKeyValuesTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        KVControllerApiDeleteBulkRequest kvControllerApiDeleteBulkRequest = null;
        KVControllerApiDeleteBulkResponse response = kestraClient().kv().deleteKeyValues(namespace, tenant, kvControllerApiDeleteBulkRequest);

        // TODO: test validations
    }
    /**
     * Get value for a key
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getKeyValueTest() throws ApiException {
        String namespace = null;
        String key = null;
        String tenant = null;
        KVControllerTypedValue response = kestraClient().kv().getKeyValue(namespace, key, tenant);

        // TODO: test validations
    }
    /**
     * List all keys for a namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listKeysTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        List<KVEntry> response = kestraClient().kv().listKeys(namespace, tenant);

        // TODO: test validations
    }
    /**
     * List all keys for inherited namespaces
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listKeysWithInheritenceTest() throws ApiException {
        String namespace = null;
        String tenant = null;
        List<KVEntry> response = kestraClient().kv().listKeysWithInheritence(namespace, tenant);

        // TODO: test validations
    }
    /**
     * Puts a key-value pair in store
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setKeyValueTest() throws ApiException {
        String namespace = null;
        String key = null;
        String tenant = null;
        String body = null;
        kestraClient().kv().setKeyValue(namespace, key, tenant, body);

        // TODO: test validations
    }
}
