package test

import (
	"encoding/json"
	"io"
	"net/http"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

const (
	childNamespace  = "test.namespace"
	parentNamespace = "test"
)

func kvValue(typed *kestra_api_client.KVControllerTypedValue) interface{} {
	if typed == nil {
		return nil
	}
	if typed.Value != nil {
		if v, ok := typed.Value["value"]; ok {
			return v
		}
		if v, ok := typed.Value["Value"]; ok {
			return v
		}
	}
	if typed.AdditionalProperties != nil {
		if v, ok := typed.AdditionalProperties["value"]; ok {
			return v
		}
	}
	return nil
}

func parseKVResponse(t *testing.T, resp *http.Response) (string, interface{}) {
	t.Helper()
	if resp == nil {
		return "", nil
	}
	body, err := io.ReadAll(resp.Body)
	require.NoError(t, err)

	var payload map[string]interface{}
	require.NoError(t, json.Unmarshal(body, &payload))

	var typ string
	if v, ok := payload["type"].(string); ok {
		typ = v
	}
	return typ, payload["value"]
}

func assertKVValue(t *testing.T, fetched *kestra_api_client.KVControllerTypedValue, httpResp *http.Response, err error, expectedType kestra_api_client.KVType, expectedValue interface{}) {
	t.Helper()
	if err != nil {
		typ, value := parseKVResponse(t, httpResp)
		require.Equal(t, string(expectedType), typ)
		require.Equal(t, expectedValue, value)
		return
	}

	require.Equal(t, expectedType, fetched.GetType())
	require.Equal(t, expectedValue, kvValue(fetched))
}

func TestKVAPI_All(t *testing.T) {
	t.Run("setKeyValueTest_string", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "\"hello-kestra\""

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_STRING, "hello-kestra")
	})

	t.Run("setKeyValueTest_boolean", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "true"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_BOOLEAN, true)
	})

	t.Run("setKeyValueTest_number", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "42"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		if err != nil {
			assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_NUMBER, float64(42))
			return
		}
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
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "PT15M"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_DURATION, "PT15M")
	})

	t.Run("setKeyValueTest_date", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "2025-10-13"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_DATE, "2025-10-13")
	})

	t.Run("setKeyValueTest_datetime", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		key := "test_set_key_value_" + randomId()
		value := "2025-10-14T18:02:08.000Z"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, namespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, namespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_DATETIME, "2025-10-14T18:02:08Z")
	})

	t.Run("getKeyValueTest", func(t *testing.T) {
		ctx := GetAuthContext()

		key := "test_get_key_value_" + randomId()
		value := "\"value-get\""

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, childNamespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		fetched, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, childNamespace, key, MAIN_TENANT).Execute()
		assertKVValue(t, fetched, httpResp, err, kestra_api_client.KVTYPE_STRING, "value-get")
	})

	t.Run("listKeysWithInheritenceTest", func(t *testing.T) {
		t.Skip("re-enable when new Kestra EE is available")
	})

	t.Run("deleteKeyValueTest", func(t *testing.T) {
		ctx := GetAuthContext()

		key := "test_delete_key_value_" + randomId()
		value := "to-delete"

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, childNamespace, key, MAIN_TENANT).Body(value).Execute()
		require.NoError(t, err)

		deleted, _, err := KestraTestApiClient().KVAPI.DeleteKeyValue(ctx, childNamespace, key, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.True(t, deleted)

		_, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, childNamespace, key, MAIN_TENANT).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("deleteKeyValuesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		key1 := "test_delete_key_values_1_" + randomId()
		key2 := "test_delete_key_values_2_" + randomId()

		_, err := KestraTestApiClient().KVAPI.SetKeyValue(ctx, childNamespace, key1, MAIN_TENANT).Body("v1").Execute()
		require.NoError(t, err)
		_, err = KestraTestApiClient().KVAPI.SetKeyValue(ctx, childNamespace, key2, MAIN_TENANT).Body("v2").Execute()
		require.NoError(t, err)

		req := kestra_api_client.KVControllerApiDeleteBulkRequest{Keys: []string{key1, key2}}
		resp, _, err := KestraTestApiClient().KVAPI.DeleteKeyValues(ctx, childNamespace, MAIN_TENANT).
			KVControllerApiDeleteBulkRequest(req).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)

		for _, k := range []string{key1, key2} {
			_, httpResp, err := KestraTestApiClient().KVAPI.KeyValue(ctx, childNamespace, k, MAIN_TENANT).Execute()
			require.Error(t, err)
			if httpResp != nil {
				require.Equal(t, 404, httpResp.StatusCode)
			}
		}
	})
}
