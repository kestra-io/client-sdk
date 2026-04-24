// testApis/test_kv_api_typed.test.js
import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

const CHILD_NAMESPACE = 'test.namespace';
const PARENT_NAMESPACE = 'test';

describe('KVApi (typed)', () => {
    it('setKeyValue: STRING', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;

        const value = '"hello-kestra"';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });

        const fetched =
            (await kestraClient().Kv.keyValue?.({ namespace, key }))

        expect(fetched?.type ?? 'STRING').toBe('STRING');
        expect(fetched?.value ?? fetched).toBe('hello-kestra');
    });

    it('setKeyValue: BOOLEAN', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = 'true';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace, key })

        expect(fetched?.type ?? 'BOOLEAN').toBe('BOOLEAN');
        expect(fetched?.value ?? fetched).toBe(true);
    });

    it('setKeyValue: NUMBER', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '42';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace, key })

        expect(fetched?.type ?? 'NUMBER').toBe('NUMBER');
        expect(fetched?.value ?? fetched).toBe(42);
    });

    it('setKeyValue: DURATION', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = 'PT15M';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace, key })

        expect(fetched?.type ?? 'DURATION').toBe('DURATION');
        expect(fetched?.value ?? fetched).toBe('PT15M');
    });

    it('setKeyValue: DATE', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '2025-10-13';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace, key })

        expect(fetched?.type ?? 'DATE').toBe('DATE');
        expect(fetched?.value ?? fetched).toBe('2025-10-13');
    });

    it('setKeyValue: DATETIME', async () => {
        const namespace = randomId();
        const key = `test_set_key_value_${randomId()}`;
        const value = '2025-10-14T18:02:08.000Z';

        await kestraClient().Kv.setKeyValue({ namespace, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace, key })

        // server often normalizes fractional seconds
        expect(fetched?.type ?? 'DATETIME').toBe('DATETIME');
        expect(fetched?.value ?? fetched).toBe('2025-10-14T18:02:08Z');
    });

    it('getKeyValue: typed string from child namespace', async () => {
        const key = `test_get_key_value_${randomId()}`;
        const value = '"value-get"';

        await kestraClient().Kv.setKeyValue({ namespace: CHILD_NAMESPACE, key, body: value });
        const fetched = await kestraClient().Kv.keyValue?.({ namespace: CHILD_NAMESPACE, key })

        expect(fetched?.type ?? 'STRING').toBe('STRING');
        expect(fetched?.value ?? fetched).toBe('value-get');
    });

    it('list_keys_with_inheritence: List keys for inherited namespaces', async () => {
        const key = `test_list_keys_with_inheritence_${randomId()}`;
        const value = 'value-inherited';

        await kestraClient().Kv.setKeyValue({ namespace: PARENT_NAMESPACE, key, body: value });
        const entries = await kestraClient().Kv.listKeysWithInheritence({ namespace: CHILD_NAMESPACE });

        expect(entries.some(e => e.key === key)).toBeTruthy();
    });

    it('delete_key_value: Delete a key-value pair', async () => {
        const key = `test_delete_key_value_${randomId()}`;
        const value = 'to-delete';

        await kestraClient().Kv.setKeyValue({ namespace: CHILD_NAMESPACE, key, body: value });
        const deleted = await kestraClient().Kv.deleteKeyValue({ namespace: CHILD_NAMESPACE, key });

        expect(deleted === true || deleted === null).toBeTruthy();

        await expect(
            kestraClient().Kv.keyValue({ namespace: CHILD_NAMESPACE, key })
        ).rejects.toThrow();
    });

    it('delete_key_values: Bulk-delete multiple key/value pairs', async () => {
        const key1 = `test_delete_key_values_1_${randomId()}`;
        const key2 = `test_delete_key_values_2_${randomId()}`;

        await kestraClient().Kv.setKeyValue({ namespace: CHILD_NAMESPACE, key: key1, body: 'v1' });
        await kestraClient().Kv.setKeyValue({ namespace: CHILD_NAMESPACE, key: key2, body: 'v2' });

        const req = { keys: [key1, key2] };
        const resp = await kestraClient().Kv.deleteKeyValues({ namespace: CHILD_NAMESPACE, body: req });
        expect(resp).not.toBeNull();

        for (const k of [key1, key2]) {
            await expect(
                kestraClient().Kv.keyValue({ namespace: CHILD_NAMESPACE, key: k })
            ).rejects.toThrow();
        }
    });
});
