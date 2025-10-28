package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class KvApiTest {

    private static final String CHILD_NAMESPACE = "test.namespace";
    private static final String PARENT_NAMESPACE = "test";

    /**
     * Puts a key-value pair in store
     */
    @Test
    public void setKeyValueTest() throws ApiException {
        String key = "test_set_key_value_" + randomId();
        String value = "hello-kestra";

        // set value
        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);

        // get & assert
        var fetched = kestraClient().kv().getKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT);
        assertThat(fetched).extracting(KVControllerTypedValue::getType).isEqualTo(KVType.STRING);
        assertThat(fetched).extracting(KVControllerTypedValue::getValue).isEqualTo("hello-kestra");

        // cleanup (best-effort)
        try {
            kestraClient().kv().deleteKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT);
        } catch (Exception ignored) {}
    }

    /**
     * Get value for a key
     */
    @Test
    public void getKeyValueTest() throws ApiException {
        String key = "test_get_key_value_" + randomId();
        String value = "value-get";

        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);

        var fetched = kestraClient().kv().getKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT);
        assertThat(fetched).extracting(KVControllerTypedValue::getType).isEqualTo(KVType.STRING);
        assertThat(fetched).extracting(KVControllerTypedValue::getValue).isEqualTo("value-get");
    }

    // TODO more tests on differents types
    // TODO test json
    // TODO test date
    // TODO test number

    /**
     * List all keys for a namespace
     */
    @Test
    @Disabled // FIXME re-enable when new Kestra EE is available
    public void listKeysTest() throws ApiException {
        String key = "test_list_keys_" + randomId();
        String value = "value-list";

        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);

        List<KVEntry> entries = kestraClient().kv().listKeys(CHILD_NAMESPACE, MAIN_TENANT);
        assertTrue(entries.stream().anyMatch(e -> key.equals(e.getKey())),
            "List should contain the inserted key");
    }

    /**
     * List all keys for inherited namespaces
     */
    @Test
    public void listKeysWithInheritenceTest() throws ApiException {
        String key = "test_list_keys_with_inheritence_" + randomId();
        String value = "value-inherited";

        // Put in parent namespace
        kestraClient().kv().setKeyValue(PARENT_NAMESPACE, key, MAIN_TENANT, value);

        // List from child namespace (should inherit)
        List<KVEntry> entries = kestraClient().kv().listKeysWithInheritence(CHILD_NAMESPACE, MAIN_TENANT);
        assertTrue(entries.stream().anyMatch(e -> key.equals(e.getKey())),
            "Inherited list should include key from parent namespace");
    }

    /**
     * Delete a key-value pair
     */
    @Test
    public void deleteKeyValueTest() throws ApiException {
        String key = "test_delete_key_value_" + randomId();
        String value = "to-delete";

        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);

        Boolean deleted = kestraClient().kv().deleteKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT);
        // API may return true or null on success depending on impl
        assertTrue(deleted == null || deleted, "Delete should succeed");

        assertThrows(ApiException.class,
            () -> kestraClient().kv().getKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT),
            "Fetching a deleted key should throw");
    }

    /**
     * Bulk-delete multiple key/value pairs from the given namespace.
     */
    @Test
    public void deleteKeyValuesTest() throws ApiException {
        String key1 = "test_delete_key_values_1_" + randomId();
        String key2 = "test_delete_key_values_2_" + randomId();

        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key1, MAIN_TENANT, "v1");
        kestraClient().kv().setKeyValue(CHILD_NAMESPACE, key2, MAIN_TENANT, "v2");

        KVControllerApiDeleteBulkRequest req = new KVControllerApiDeleteBulkRequest()
            .keys(List.of(key1, key2));

        KVControllerApiDeleteBulkResponse resp =
            kestraClient().kv().deleteKeyValues(CHILD_NAMESPACE, MAIN_TENANT, req);

        assertNotNull(resp, "Bulk delete response should not be null");

        for (String k : List.of(key1, key2)) {
            assertThrows(ApiException.class,
                () -> kestraClient().kv().getKeyValue(CHILD_NAMESPACE, k, MAIN_TENANT),
                "Fetching a bulk-deleted key should throw");
        }
    }
}
