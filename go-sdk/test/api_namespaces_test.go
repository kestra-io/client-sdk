package test

import (
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestNamespacesAPI_All(t *testing.T) {
	t.Run("autocompleteNamespacesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		prefix := "test_autocomplete_namespaces_" + randomId()
		ns := kestra_api_client.Namespace{Id: prefix, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		ac := kestra_api_client.ApiAutocomplete{}
		ac.SetQ(prefix)
		results, _, err := KestraTestApiClient().NamespacesAPI.AutocompleteNamespaces(ctx, MAIN_TENANT).ApiAutocomplete(ac).Execute()
		require.NoError(t, err)

		found := false
		for _, r := range results {
			if r == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "autocomplete should include the created namespace id")
	})

	t.Run("createNamespaceTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_create_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		require.Equal(t, nsId, created.GetId())
		require.NotNil(t, created)
	})

	t.Run("deleteNamespaceTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_delete_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().NamespacesAPI.DeleteNamespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().NamespacesAPI.Namespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("getInheritedSecretsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_get_inherited_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		inherited, _, err := KestraTestApiClient().NamespacesAPI.InheritedSecrets(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, inherited)
	})

	t.Run("getNamespaceTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_get_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().NamespacesAPI.Namespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("inheritedPluginDefaultsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_inherited_plugin_defaults_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		defaults, _, err := KestraTestApiClient().NamespacesAPI.InheritedPluginDefaults(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, defaults)
	})

	t.Run("inheritedVariablesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_inherited_variables_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		variables, _, err := KestraTestApiClient().NamespacesAPI.InheritedVariables(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, variables)
	})

	t.Run("listNamespaceSecretsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_list_namespace_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "list_keys_key_" + randomId()
		unwantedKey := "unwanted_" + randomId()

		tag := kestra_api_client.ApiSecretTag{Key: "env", Value: "test"}

		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).
			ApiSecretValue(kestra_api_client.ApiSecretValue{Key: key, Value: "list-value", Description: strPtr("list secret"), Tags: []kestra_api_client.ApiSecretTag{tag}}).
			Execute()
		require.NoError(t, err)

		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).
			ApiSecretValue(kestra_api_client.ApiSecretValue{Key: unwantedKey, Value: "list-value", Description: strPtr("unwanted secret"), Tags: []kestra_api_client.ApiSecretTag{tag}}).
			Execute()
		require.NoError(t, err)

		queryFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_QUERY),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     key,
		}

		entries, _, err := KestraTestApiClient().NamespacesAPI.ListNamespaceSecrets(ctx, created.GetId(), MAIN_TENANT).
			Page(1).
			Size(10).
			Filters([]kestra_api_client.QueryFilter{queryFilter}).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, entries)
		require.NotNil(t, entries.GetResults())

		found := false
		for _, r := range entries.GetResults() {
			if r.GetKey() == key {
				found = true
			}
			require.NotEqual(t, unwantedKey, r.GetKey())
		}
		require.True(t, found)
	})

	t.Run("patchSecretTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_patch_secret_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "test_patch_secret_key_" + randomId()
		tag := kestra_api_client.ApiSecretTag{Key: "env", Value: "test"}
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).
			ApiSecretValue(kestra_api_client.ApiSecretValue{Key: key, Value: "secretValue", Description: strPtr("patch secret"), Tags: []kestra_api_client.ApiSecretTag{tag}}).
			Execute()
		require.NoError(t, err)

		meta := kestra_api_client.ApiSecretMetaEE{Key: key, Description: "patch secret", Tags: []kestra_api_client.ApiSecretTag{tag}}
		metas, _, err := KestraTestApiClient().NamespacesAPI.PatchSecret(ctx, created.GetId(), key, MAIN_TENANT).ApiSecretMetaEE(meta).Execute()
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("putSecretsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_put_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		tag := kestra_api_client.ApiSecretTag{Key: "env", Value: "test"}
		metas, _, err := KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).
			ApiSecretValue(kestra_api_client.ApiSecretValue{Key: "test_put_secrets_key_" + randomId(), Value: "value-put", Description: strPtr("put secret"), Tags: []kestra_api_client.ApiSecretTag{tag}}).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("searchNamespacesTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_search_namespaces_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		results, _, err := KestraTestApiClient().NamespacesAPI.SearchNamespaces(ctx, MAIN_TENANT).
			Page(1).
			Size(10).
			Existing(false).
			Q(nsId).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, results)
		require.NotNil(t, results.GetResults())

		found := false
		for _, r := range results.GetResults() {
			if r.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "search should return the created namespace")
	})

	t.Run("updateNamespaceTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_update_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		updateBody := kestra_api_client.Namespace{Id: created.GetId(), Deleted: false}
		updated, _, err := KestraTestApiClient().NamespacesAPI.UpdateNamespace(ctx, created.GetId(), MAIN_TENANT).Namespace(updateBody).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), updated.GetId())
	})

	t.Run("deleteSecretTest", func(t *testing.T) {
		ctx := GetAuthContext()

		nsId := "test_delete_secret_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "to_delete_key_" + randomId()
		tag := kestra_api_client.ApiSecretTag{Key: "env", Value: "test"}
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).
			ApiSecretValue(kestra_api_client.ApiSecretValue{Key: key, Value: "to-delete", Description: strPtr("delete secret"), Tags: []kestra_api_client.ApiSecretTag{tag}}).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().NamespacesAPI.DeleteSecret(ctx, created.GetId(), key, MAIN_TENANT).Execute()
		require.NoError(t, err)

		list, _, err := KestraTestApiClient().NamespacesAPI.ListNamespaceSecrets(ctx, created.GetId(), MAIN_TENANT).
			Page(1).
			Size(10).
			Filters([]kestra_api_client.QueryFilter{}).
			Execute()
		require.NoError(t, err)

		stillPresent := false
		if list != nil && list.GetResults() != nil {
			for _, m := range list.GetResults() {
				if m.GetKey() == key {
					stillPresent = true
					break
				}
			}
		}
		require.False(t, stillPresent, "deleted secret should not be listed anymore")
	})
}
