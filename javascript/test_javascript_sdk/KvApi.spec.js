// @ts-check
// testApis/test_kv_api_typed.test.js
import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

const CHILD_NAMESPACE = 'test.namespace';
const PARENT_NAMESPACE = 'test';

describe('KVApi (typed)', () => {
    it('setKeyValue: STRING', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;

        const value = '"hello-kestra"';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);

        const fetched =
            (await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT))

        expect(fetched?.type ?? 'STRING').toBe('STRING');
        expect(fetched?.value ?? fetched).toBe('hello-kestra');
    });

    it('setKeyValue: BOOLEAN', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = 'true';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT)

        expect(fetched?.type ?? 'BOOLEAN').toBe('BOOLEAN');
        expect(fetched?.value ?? fetched).toBe(true);
    });

    it('setKeyValue: NUMBER', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '42';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT)

        expect(fetched?.type ?? 'NUMBER').toBe('NUMBER');
        expect(fetched?.value ?? fetched).toBe(42);
    });

    it('setKeyValue: DURATION', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = 'PT15M';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT)

        expect(fetched?.type ?? 'DURATION').toBe('DURATION');
        expect(fetched?.value ?? fetched).toBe('PT15M');
    });

    it('setKeyValue: DATE', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '2025-10-13';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT)

        expect(fetched?.type ?? 'DATE').toBe('DATE');
        expect(fetched?.value ?? fetched).toBe('2025-10-13');
    });

    it('setKeyValue: DATETIME', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '2025-10-14T18:02:08.000Z';

        await kestraClient().kvApi.setKeyValue(namespace, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(namespace, key, MAIN_TENANT)

        // server often normalizes fractional seconds
        expect(fetched?.type ?? 'DATETIME').toBe('DATETIME');
        expect(fetched?.value ?? fetched).toBe('2025-10-14T18:02:08Z');
    });

    it('getKeyValue: typed string from child namespace', async () => {
        const key = `test_get_key_value_${randomId()}`;
        const value = '"value-get"';

        await kestraClient().kvApi.setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);
        const fetched = await kestraClient().kvApi.keyValue?.(CHILD_NAMESPACE, key, MAIN_TENANT)

        expect(fetched?.type ?? 'STRING').toBe('STRING');
        expect(fetched?.value ?? fetched).toBe('value-get');
    });

    it('list_keys_with_inheritence: List keys for inherited namespaces', async () => {
        const key = `test_list_keys_with_inheritence_${randomId()}`;
        const value = 'value-inherited';

        await kestraClient().kvApi.setKeyValue(PARENT_NAMESPACE, key, MAIN_TENANT, value);
        const entries = await kestraClient().kvApi.listKeysWithInheritence(CHILD_NAMESPACE, MAIN_TENANT);

        expect(entries.some(e => e.key === key)).toBeTruthy();
    });

    it('delete_key_value: Delete a key-value pair', async () => {
        const key = `test_delete_key_value_${randomId()}`;
        const value = 'to-delete';

        await kestraClient().kvApi.setKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT, value);
        const deleted = await kestraClient().kvApi.deleteKeyValue(CHILD_NAMESPACE, key, MAIN_TENANT);

        expect(deleted === true || deleted === null).toBeTruthy();

        await expect(
            kestraClient().kvApi.keyValue(CHILD_NAMESPACE, key, MAIN_TENANT)
        ).rejects.toThrow();
    });

    it('delete_key_values: Bulk-delete multiple key/value pairs', async () => {
        const key1 = `test_delete_key_values_1_${randomId()}`;
        const key2 = `test_delete_key_values_2_${randomId()}`;

        await kestraClient().kvApi.setKeyValue(CHILD_NAMESPACE, key1, MAIN_TENANT, 'v1');
        await kestraClient().kvApi.setKeyValue(CHILD_NAMESPACE, key2, MAIN_TENANT, 'v2');

        const req = { keys: [key1, key2] };
        const resp = await kestraClient().kvApi.deleteKeyValues(CHILD_NAMESPACE, MAIN_TENANT, req);
        expect(resp).not.toBeNull();

        for (const k of [key1, key2]) {
            await expect(
                kestraClient().kvApi.keyValue(CHILD_NAMESPACE, k, MAIN_TENANT)
            ).rejects.toThrow();
        }
    });
});
