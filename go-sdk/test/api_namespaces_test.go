package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestNamespacesAPI_All(t *testing.T) {
	t.Run("autocompleteNamespacesTest", func(t *testing.T) {
		ctx := context.Background()

		prefix := "test_autocomplete_namespaces_" + randomId()
		ns := kestra_api_client.Namespace{Id: prefix, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		ac := map[string]interface{}{"q": prefix}
		results, err := KestraTestClient().Namespaces().AutocompleteNamespaces(ctx, MAIN_TENANT, ac)
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
		ctx := context.Background()

		nsId := "test_create_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		require.Equal(t, nsId, created.GetId())
		require.NotNil(t, created)
	})

	t.Run("deleteNamespaceTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_delete_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		err = KestraTestClient().Namespaces().DeleteNamespace(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Namespaces().Namespace(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("getInheritedSecretsTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_get_inherited_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		inherited, err := KestraTestClient().Namespaces().InheritedSecrets(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, inherited)
	})

	t.Run("getNamespaceTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_get_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		fetched, err := KestraTestClient().Namespaces().Namespace(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("inheritedPluginDefaultsTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_inherited_plugin_defaults_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		defaults, err := KestraTestClient().Namespaces().InheritedPluginDefaults(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, defaults)
	})

	t.Run("inheritedVariablesTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_inherited_variables_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		variables, err := KestraTestClient().Namespaces().InheritedVariables(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, variables)
	})

	t.Run("putSecretsTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_put_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		secret := kestra_api_client.ApiSecretValue{
			Key:   "test_put_secrets_key_" + randomId(),
			Value: "value-put",
		}
		metas, err := KestraTestClient().Namespaces().PutSecrets(ctx, created.GetId(), MAIN_TENANT, secret)
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("patchSecretTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_patch_secret_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		key := "test_patch_secret_key_" + randomId()
		secret := kestra_api_client.ApiSecretValue{
			Key:   key,
			Value: "secretValue",
		}
		_, err = KestraTestClient().Namespaces().PutSecrets(ctx, created.GetId(), MAIN_TENANT, secret)
		require.NoError(t, err)

		meta := map[string]interface{}{
			"key":         key,
			"description": "patch secret",
			"tags":        []map[string]string{{"key": "env", "value": "test"}},
		}
		metas, err := KestraTestClient().Namespaces().PatchSecret(ctx, created.GetId(), key, MAIN_TENANT, meta)
		require.NoError(t, err)
		require.NotNil(t, metas)
	})

	t.Run("deleteSecretTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_delete_secret_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		key := "to_delete_key_" + randomId()
		secret := kestra_api_client.ApiSecretValue{
			Key:   key,
			Value: "to-delete",
		}
		_, err = KestraTestClient().Namespaces().PutSecrets(ctx, created.GetId(), MAIN_TENANT, secret)
		require.NoError(t, err)

		err = KestraTestClient().Namespaces().DeleteSecret(ctx, created.GetId(), key, MAIN_TENANT)
		require.NoError(t, err)
	})

	t.Run("searchNamespacesTest", func(t *testing.T) {
		t.Skip("Kestra 2.0 moved q into the `filters` array; see #252")
		ctx := context.Background()

		nsId := "test_search_namespaces_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		results, err := KestraTestClient().Namespaces().SearchNamespaces(ctx, MAIN_TENANT, kestra_api_client.PtrString(nsId), kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrBool(false))
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

	t.Run("exportPluginDefaultsTest", func(t *testing.T) {
		t.Skip("Server returns 500 when namespace has no pluginDefaults configured")
	})

	t.Run("importPluginDefaultsTest", func(t *testing.T) {
		t.Skip("Requires a pre-built plugin defaults file")
	})

	t.Run("updateNamespaceTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_update_namespace_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		updateBody := kestra_api_client.Namespace{Id: created.GetId(), Deleted: false}
		updated, err := KestraTestClient().Namespaces().UpdateNamespace(ctx, created.GetId(), MAIN_TENANT, updateBody)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), updated.GetId())
	})
}
