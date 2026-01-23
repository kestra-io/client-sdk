package main

import (
	"testing"

	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
	"github.com/stretchr/testify/require"
)

func TestNamespacesAPI_All(t *testing.T) {

	t.Run("autocompleteNamespacesTest", func(t *testing.T) {
		prefix := "test_autocomplete_namespaces_" + randomId()
		ctx := GetAuthContext()

		// create namespace
		ns := *openapiclient.NewNamespace(prefix, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)
		require.NotNil(t, created)

		// autocomplete
		ac := *openapiclient.NewApiAutocomplete()
		ac.SetQ(prefix)
		results, _, err := KestraTestApiClient().NamespacesAPI.AutocompleteNamespaces(ctx, MAIN_TENANT).ApiAutocomplete(ac).Execute()
		require.NoError(t, err)
		require.NotNil(t, results)

		found := false
		for _, r := range results {
			if r == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "Autocomplete should include the created namespace id")
	})

	t.Run("createNamespaceTest", func(t *testing.T) {
		nsId := "test_create_namespace_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)
		require.NotNil(t, created)
		require.Equal(t, nsId, created.GetId())
	})

	t.Run("deleteNamespaceTest", func(t *testing.T) {
		nsId := "test_delete_namespace_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().NamespacesAPI.DeleteNamespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		_, _, err = KestraTestApiClient().NamespacesAPI.Namespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.Error(t, err, "Fetching a deleted namespace should return an error")
	})

	t.Run("getInheritedSecretsTest", func(t *testing.T) {
		nsId := "test_get_inherited_secrets_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		inherited, _, err := KestraTestApiClient().NamespacesAPI.InheritedSecrets(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, inherited)
	})

	t.Run("getNamespaceTest", func(t *testing.T) {
		nsId := "test_get_namespace_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().NamespacesAPI.Namespace(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("inheritedPluginDefaultsTest", func(t *testing.T) {
		nsId := "test_inherited_plugin_defaults_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		defaults, _, err := KestraTestApiClient().NamespacesAPI.InheritedPluginDefaults(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, defaults)
	})

	t.Run("inheritedVariablesTest", func(t *testing.T) {
		nsId := "test_inherited_variables_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		vars, _, err := KestraTestApiClient().NamespacesAPI.InheritedVariables(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, vars)
	})

	t.Run("listNamespaceSecretsTest", func(t *testing.T) {
		nsId := "test_list_namespace_secrets_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "list_keys_key_" + randomId()
		unwantedKey := "unwanted_" + randomId()

		// Create one secret so the list call has something to return

		value := openapiclient.NewApiSecretValue(key, "list-value")
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).ApiSecretValue(*value).Execute()
		require.NoError(t, err)
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).ApiSecretValue(*openapiclient.NewApiSecretValue(unwantedKey, "list-value")).Execute()
		require.NoError(t, err)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_QUERY),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     key,
			},
		}

		entries, _, err := KestraTestApiClient().NamespacesAPI.ListNamespaceSecrets(ctx, created.GetId(), MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
		require.NotNil(t, entries)
		require.NotNil(t, entries.GetResults())

		found := false
		for _, e := range entries.GetResults() {
			if e.GetKey() == key {
				found = true
			}
			require.NotEqual(t, unwantedKey, e.GetKey())
		}
		require.True(t, found, "Results should contain the expected secret key")
	})

	t.Run("patchSecretTest", func(t *testing.T) {
		nsId := "test_patch_secret_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "test_patch_secret_key_" + randomId()
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).ApiSecretValue(*openapiclient.NewApiSecretValue(key, "secretValue")).Execute()
		require.NoError(t, err)

		var meta openapiclient.ApiSecretMetaEE
		meta.SetKey(key)
		metas, _, err := KestraTestApiClient().NamespacesAPI.PatchSecret(ctx, created.GetId(), key, MAIN_TENANT).ApiSecretMetaEE(meta).Execute()
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("putSecretsTest", func(t *testing.T) {
		nsId := "test_put_secrets_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		value := openapiclient.NewApiSecretValue("test_put_secrets_key_"+randomId(), "value-put")
		metas, _, err := KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).ApiSecretValue(*value).Execute()
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("searchNamespacesTest", func(t *testing.T) {
		nsId := "test_search_namespaces_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		results, _, err := KestraTestApiClient().NamespacesAPI.SearchNamespaces(ctx, MAIN_TENANT).Q(nsId).Execute()
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
		require.True(t, found, "Search should return the created namespace")
	})

	t.Run("updateNamespaceTest", func(t *testing.T) {
		nsId := "test_update_namespace_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		updateBody := *openapiclient.NewNamespace(created.GetId(), false)
		updated, _, err := KestraTestApiClient().NamespacesAPI.UpdateNamespace(ctx, created.GetId(), MAIN_TENANT).Namespace(updateBody).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), updated.GetId())
	})

	t.Run("deleteSecretTest", func(t *testing.T) {
		nsId := "test_delete_secret_" + randomId()
		ctx := GetAuthContext()

		ns := *openapiclient.NewNamespace(nsId, false)
		created, _, err := KestraTestApiClient().NamespacesAPI.CreateNamespace(ctx, MAIN_TENANT).Namespace(ns).Execute()
		require.NoError(t, err)

		key := "to_delete_key_" + randomId()
		value := openapiclient.NewApiSecretValue(key, "to-delete")
		_, _, err = KestraTestApiClient().NamespacesAPI.PutSecrets(ctx, created.GetId(), MAIN_TENANT).ApiSecretValue(*value).Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().NamespacesAPI.DeleteSecret(ctx, created.GetId(), key, MAIN_TENANT).Execute()
		require.NoError(t, err)

		list, _, err := KestraTestApiClient().NamespacesAPI.ListNamespaceSecrets(ctx, created.GetId(), MAIN_TENANT).Filters([]openapiclient.QueryFilter{}).Execute()
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
		require.False(t, stillPresent, "Deleted secret should not be listed anymore")
	})
}

// ptr helper is defined in other test files (queryfilters_test.go)
