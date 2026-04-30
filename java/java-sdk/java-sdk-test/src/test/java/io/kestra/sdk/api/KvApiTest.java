package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KvApiTest {

    static KvApi api() {
        return client().kv();
    }

    // ========================================================================
    // Set & Get
    // ========================================================================

    @Test
    void setAndGetKeyValue_string() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().setKeyValue(ns, "mykey", TENANT, "\"hello world\"");

        KVControllerKvDetail detail = api().keyValue(ns, "mykey", TENANT);
        assertThat(detail).isNotNull();
    }

    @Test
    void setAndGetKeyValue_number() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().setKeyValue(ns, "count", TENANT, "42");

        KVControllerKvDetail detail = api().keyValue(ns, "count", TENANT);
        assertThat(detail).isNotNull();
    }

    @Test
    void setKeyValue_overwrite() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().setKeyValue(ns, "key1", TENANT, "\"first\"");
        api().setKeyValue(ns, "key1", TENANT, "\"second\"");

        KVControllerKvDetail detail = api().keyValue(ns, "key1", TENANT);
        assertThat(detail).isNotNull();
    }

    @Test
    void keyValue_notFound() {
        assertThatThrownBy(() -> api().keyValue("nonexistent_ns_" + randomId(), "nonexistent", TENANT))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Delete
    // ========================================================================

    @Test
    void deleteKeyValue_existing() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().setKeyValue(ns, "todelete", TENANT, "\"value\"");
        Boolean result = api().deleteKeyValue(ns, "todelete", TENANT);
        assertThat(result).isTrue();
    }

    @Test
    void deleteKeyValue_nonexistent() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        Boolean result = api().deleteKeyValue(ns, "nonexistent", TENANT);
        assertThat(result).isFalse();
    }

    @Test
    void deleteKeyValues_bulk() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        api().setKeyValue(ns, "k1", TENANT, "\"v1\"");
        api().setKeyValue(ns, "k2", TENANT, "\"v2\"");

        KVControllerApiDeleteBulkRequest request = new KVControllerApiDeleteBulkRequest()
                .keys(List.of("k1", "k2"));
        KVControllerApiDeleteBulkResponse resp = api().deleteKeyValues(ns, TENANT, request);
        assertThat(resp).isNotNull();
    }

    // ========================================================================
    // List & Search
    // ========================================================================

    @Test
    void listAllKeys_basic() throws ApiException {
        PagedResultsKVEntry result = api().listAllKeys(TENANT, 1, 10, null, null);
        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void listAllKeys_withPagination() throws ApiException {
        PagedResultsKVEntry result = api().listAllKeys(TENANT, 1, 5, null, null);
        assertThat(result).isNotNull();
    }

    @Test
    void listKeysWithInheritance_basic() throws ApiException {
        String parentNs = randomId();
        String childNs = parentNs + "." + randomId();
        createFlow(logFlowYaml(randomId(), parentNs));
        createFlow(logFlowYaml(randomId(), childNs));

        api().setKeyValue(parentNs, "parent_key", TENANT, "\"value\"");

        List<KVEntry> keys = api().listKeysWithInheritance(childNs, TENANT);
        assertThat(keys).isNotNull();
        assertThat(keys).anyMatch(k -> "parent_key".equals(k.getKey()));
    }

    @Test
    void listKeysWithInheritance_emptyNamespace() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        List<KVEntry> keys = api().listKeysWithInheritance(ns, TENANT);
        assertThat(keys).isNotNull();
    }
}
