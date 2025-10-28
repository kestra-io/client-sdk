// testApis/test_kv_api.test.js
import { describe, it, beforeEach, expect } from 'vitest';
import {kestraClient, MAIN_TENANT} from "./CommonTestSetup";
import KVControllerApiDeleteBulkRequest from "../src/model/KVControllerApiDeleteBulkRequest";

let namespace = 'test.namespace';


describe('KVApi', () => {
    it('set_key_value: Puts a key-value pair in store', async () => {
        const key = 'test_set_key_value';
        const value = 'hello-kestra';

        await kestraClient().kvApi.setKeyValue( namespace, key, MAIN_TENANT, value );
        const fetched = await kestraClient().kvApi.getKeyValue( namespace, key, MAIN_TENANT );

        expect(fetched?.value ?? fetched).not.toBeNull();

        // cleanup
        try {
            await kestraClient().kvApi.deleteKeyValue( namespace, key, MAIN_TENANT );
        } catch (e) {
            // ignore
        }
    });

    it('get_key_value: Get value for a key', async () => {
        const key = 'test_get_key_value';
        const value = 'value-get';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value );
        const fetched = await kestraClient().kvApi.getKeyValue(namespace, key, MAIN_TENANT );

        expect(fetched).not.toBeNull();
    });

    it('list_keys: List all keys for a namespace', async () => {
        const key = 'test_list_keys';
        const value = 'value-list';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT,  value );
        const entries = await kestraClient().kvApi.listKeys( namespace, MAIN_TENANT );

        expect(entries.some(e => e.key === key)).toBeTruthy();
    });

    // FIXME re-enable when new Kestra EE is available
    it.skip('list_keys_with_inheritence: List all keys for inherited namespaces', async () => {
        const key = 'test_list_keys_with_inheritence';
        const value = 'value-inherited';

        await kestraClient().kvApi.setKeyValue('test', key, MAIN_TENANT,  value );
        const entries = await kestraClient().kvApi.listKeysWithInheritence( namespace, MAIN_TENANT );

        expect(entries.map(e => e.key)).toContain(key);
    });

    it('delete_key_value: Delete a key-value pair', async () => {
        const key = 'test_delete_key_value';
        const value = 'to-delete';

        await kestraClient().kvApi.setKeyValue( namespace, key, MAIN_TENANT,  value );
        const deleted = await kestraClient().kvApi.deleteKeyValue( namespace, key, MAIN_TENANT );

        expect(deleted === true || deleted === null).toBeTruthy();

        await expect(
            kestraClient().kvApi.getKeyValue( namespace, key, MAIN_TENANT )
        ).rejects.toThrow();
    });

    it('delete_key_values: Bulk-delete multiple key/value pairs', async () => {
        const key1 = 'test_delete_key_values_1';
        const key2 = 'test_delete_key_values_2';

        await kestraClient().kvApi.setKeyValue( namespace,  key1, MAIN_TENANT, 'v1' );
        await kestraClient().kvApi.setKeyValue( namespace,  key2, MAIN_TENANT,  'v2' );

        const req = new KVControllerApiDeleteBulkRequest({ keys: [key1, key2] });
        const resp = await kestraClient().kvApi.deleteKeyValues( namespace, MAIN_TENANT, req );

        expect(resp).not.toBeNull();
        var debug = await kestraClient().kvApi.getKeyValue( namespace, key1, MAIN_TENANT );
        for (const k of [key1, key2]) {
            await expect(
                kestraClient().kvApi.getKeyValue( namespace, k, MAIN_TENANT )
            ).rejects.toThrow();
        }
    });
});