package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

const (
	childNamespace  = "test.namespace"
	parentNamespace = "test"
)

func kvValue(typed *kestra_api_client.KvDetail) interface{} {
	if typed == nil {
		return nil
	}
	return typed.Value
}

func assertKVValue(t *testing.T, fetched *kestra_api_client.KvDetail, err error, expectedType kestra_api_client.KVType, expectedValue interface{}) {
	t.Helper()
	require.NoError(t, err)
	require.NotNil(t, fetched)
	require.Equal(t, expectedType, fetched.GetType())
	require.Equal(t, expectedValue, kvValue(fetched))
}

func TestKVAPI_All(t *testing.T) {
	t.Run("setKeyValueTest_string", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "\"hello-kestra\""

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_STRING, "hello-kestra")
	})

	t.Run("setKeyValueTest_boolean", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "true"

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_BOOLEAN, true)
	})

	t.Run("setKeyValueTest_number", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "42"

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, fetched)
		require.Equal(t, kestra_api_client.KVTYPE_NUMBER, fetched.GetType())
		actual := kvValue(fetched)
		switch v := actual.(type) {
		case float64:
			require.Equal(t, float64(42), v)
		case int:
			require.Equal(t, 42, v)
		default:
			require.Equal(t, float64(42), v)
		}
	})

	t.Run("setKeyValueTest_duration", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "PT15M"

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_DURATION, "PT15M")
	})

	t.Run("setKeyValueTest_date", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "2025-10-13"

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_DATE, "2025-10-13")
	})

	t.Run("setKeyValueTest_datetime", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "2025-10-14T18:02:08.000Z"

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_DATETIME, "2025-10-14T18:02:08Z")
	})

	t.Run("getKeyValueTest", func(t *testing.T) {
		ctx := context.Background()

		key := "test_get_key_value_" + randomId()
		value := "\"value-get\""

		err := KestraTestClient().Kv().SetKeyValue(ctx, childNamespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, childNamespace, key, MAIN_TENANT)
		assertKVValue(t, fetched, err, kestra_api_client.KVTYPE_STRING, "value-get")
	})

	t.Run("listKeysWithInheritenceTest", func(t *testing.T) {
		t.Skip("re-enable when new Kestra EE is available")
	})

	t.Run("deleteKeyValueTest", func(t *testing.T) {
		ctx := context.Background()

		key := "test_delete_key_value_" + randomId()
		value := "to-delete"

		err := KestraTestClient().Kv().SetKeyValue(ctx, childNamespace, key, MAIN_TENANT, value)
		require.NoError(t, err)

		deleted, err := KestraTestClient().Kv().DeleteKeyValue(ctx, childNamespace, key, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, deleted)
		require.True(t, *deleted)

		_, err = KestraTestClient().Kv().KeyValue(ctx, childNamespace, key, MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("deleteKeyValuesTest", func(t *testing.T) {
		ctx := context.Background()

		key1 := "test_delete_key_values_1_" + randomId()
		key2 := "test_delete_key_values_2_" + randomId()

		err := KestraTestClient().Kv().SetKeyValue(ctx, childNamespace, key1, MAIN_TENANT, "v1")
		require.NoError(t, err)
		err = KestraTestClient().Kv().SetKeyValue(ctx, childNamespace, key2, MAIN_TENANT, "v2")
		require.NoError(t, err)

		req := kestra_api_client.KVControllerApiDeleteBulkRequest{Keys: []string{key1, key2}}
		resp, err := KestraTestClient().Kv().DeleteKeyValues(ctx, childNamespace, MAIN_TENANT, req)
		require.NoError(t, err)
		require.NotNil(t, resp)

		for _, k := range []string{key1, key2} {
			_, err := KestraTestClient().Kv().KeyValue(ctx, childNamespace, k, MAIN_TENANT)
			require.Error(t, err)
		}
	})

	t.Run("listAllKeysTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		key := "test_list_all_keys_" + randomId()

		err := KestraTestClient().Kv().SetKeyValue(ctx, namespace, key, MAIN_TENANT, "\"test-value\"")
		require.NoError(t, err)

		result, err := KestraTestClient().Kv().ListAllKeys(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("setKeyValueWithTTLTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		key := "test_set_key_value_ttl_" + randomId()

		err := KestraTestClient().Kv().SetKeyValueWithTTL(ctx, namespace, key, MAIN_TENANT, "\"ttl-value\"", kestra_api_client.PtrString("PT1H"))
		require.NoError(t, err)

		fetched, err := KestraTestClient().Kv().KeyValue(ctx, namespace, key, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, fetched)
		require.Equal(t, kestra_api_client.KVTYPE_STRING, fetched.GetType())
	})
}
