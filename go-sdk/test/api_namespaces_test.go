package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
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

	// Namespace-level concurrency limits and quotas are Kestra 2.0 features; the
	// Go models predated them, so a limit set through the SDK used to be dropped
	// on the way out and never read back.
	t.Run("namespaceConcurrencyAndQuotasTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_namespace_concurrency_" + randomId()
		ns := kestra_api_client.Namespace{
			Id:      nsId,
			Deleted: false,
			Concurrency: &kestra_api_client.Concurrency{
				Limit:    3,
				Behavior: kestra_api_client.CONCURRENCYBEHAVIOR_QUEUE,
			},
			Quotas: []kestra_api_client.Quota{{
				Duration: "PT1H",
				Limit:    10,
				Behavior: kestra_api_client.QUOTABEHAVIOR_FAIL,
			}},
		}

		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)
		require.Equal(t, int32(3), created.GetConcurrency().Limit)
		require.Equal(t, kestra_api_client.CONCURRENCYBEHAVIOR_QUEUE, created.GetConcurrency().Behavior)
		require.Len(t, created.GetQuotas(), 1)
		require.Equal(t, int64(10), created.GetQuotas()[0].Limit)

		read, err := KestraTestClient().Namespaces().Namespace(ctx, nsId, MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, int32(3), read.GetConcurrency().Limit)
		require.Len(t, read.GetQuotas(), 1)
		require.Equal(t, kestra_api_client.QUOTABEHAVIOR_FAIL, read.GetQuotas()[0].Behavior)

		read.SetConcurrency(kestra_api_client.Concurrency{
			Limit:    7,
			Behavior: kestra_api_client.CONCURRENCYBEHAVIOR_CANCEL,
		})
		updated, err := KestraTestClient().Namespaces().UpdateNamespace(ctx, nsId, MAIN_TENANT, *read)
		require.NoError(t, err)
		require.Equal(t, int32(7), updated.GetConcurrency().Limit)
		require.Equal(t, kestra_api_client.CONCURRENCYBEHAVIOR_CANCEL, updated.GetConcurrency().Behavior)
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

	t.Run("listNamespaceSecretsTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_list_namespace_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		key := "test_list_secret_key_" + randomId()
		secret := kestra_api_client.ApiSecretValue{
			Key:   key,
			Value: "value-list",
		}
		_, err = KestraTestClient().Namespaces().PutSecrets(ctx, created.GetId(), MAIN_TENANT, secret)
		require.NoError(t, err)

		// Namespace-scoped convenience: filters[namespace][EQUALS]=<ns> under the hood.
		resp, err := KestraTestClient().Namespaces().ListNamespaceSecrets(ctx, created.GetId(), MAIN_TENANT, nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, resp)

		found := false
		for _, m := range resp.GetResults() {
			if m.GetKey() == key {
				found = true
				require.Equal(t, created.GetId(), m.GetNamespace(), "secret should be scoped to the created namespace")
				break
			}
		}
		require.True(t, found, "ListNamespaceSecrets should include the seeded secret key")
	})

	t.Run("listSecretsTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_list_secrets_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		key := "test_cross_secret_key_" + randomId()
		secret := kestra_api_client.ApiSecretValue{
			Key:   key,
			Value: "value-cross",
		}
		_, err = KestraTestClient().Namespaces().PutSecrets(ctx, created.GetId(), MAIN_TENANT, secret)
		require.NoError(t, err)

		// Cross-namespace list scoped with an explicit namespace filter (the endpoint
		// requires at least one filter).
		filters := []kestra_api_client.SearchFilter{{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     created.GetId(),
		}}
		resp, err := KestraTestClient().Namespaces().ListSecrets(ctx, MAIN_TENANT, nil, nil, nil, filters)
		require.NoError(t, err)
		require.NotNil(t, resp)
		require.GreaterOrEqual(t, resp.GetTotal(), int64(1), "at least the seeded secret should be counted")

		found := false
		for _, m := range resp.GetResults() {
			if m.GetKey() == key {
				found = true
				break
			}
		}
		require.True(t, found, "ListSecrets should include the seeded secret key")
	})

	t.Run("searchNamespacesTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_search_namespaces_" + randomId()
		ns := kestra_api_client.Namespace{Id: nsId, Deleted: false}
		created, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, ns)
		require.NoError(t, err)

		results, err := KestraTestClient().Namespaces().SearchNamespaces(ctx, MAIN_TENANT, kestra_api_client.PtrString(nsId), kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, kestra_api_client.PtrBool(false), nil)
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

	// oauth2CredentialBody builds a valid ApiCreateOAuth2CredentialRequest body.
	oauth2CredentialBody := func(namespace, name string) map[string]interface{} {
		return map[string]interface{}{
			"type":          "OAUTH2",
			"name":          name,
			"description":   "created by go sdk test",
			"namespace":     namespace,
			"tokenEndpoint": "https://login.example.com/oauth2/token",
			"scopes":        []string{"read"},
			"authConfig": map[string]interface{}{
				"type":     "CLIENT_CREDENTIALS",
				"clientId": map[string]interface{}{"type": "VALUE", "value": "the-client-id"},
				"clientSecret": map[string]interface{}{
					"type":      "SECRET",
					"secretKey": "MY_CLIENT_SECRET",
				},
			},
		}
	}

	t.Run("namespaceCredentialsCrudTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_ns_credentials_" + randomId()
		_, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, kestra_api_client.Namespace{Id: nsId})
		require.NoError(t, err)

		// list (empty is fine, but the paged envelope must be present)
		list, err := KestraTestClient().Namespaces().NamespaceCredentials(ctx, nsId, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		_, hasTotal := list["total"]
		require.True(t, hasTotal, "credentials listing should carry a paged total")

		// inherited credentials
		inherited, err := KestraTestClient().Namespaces().InheritedNamespaceCredentials(ctx, nsId, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, inherited)

		name := "cred_" + randomId()
		created, err := KestraTestClient().Namespaces().CreateNamespaceCredential(ctx, nsId, MAIN_TENANT, oauth2CredentialBody(nsId, name))
		if err != nil {
			t.Skipf("namespace credentials not available on this instance: %v", err)
		}
		require.Equal(t, name, created["name"])
		require.Equal(t, nsId, created["namespace"])

		got, err := KestraTestClient().Namespaces().NamespaceCredential(ctx, nsId, name, MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, name, got["name"])

		updateBody := oauth2CredentialBody(nsId, name)
		updateBody["description"] = "updated by go sdk test"
		updated, err := KestraTestClient().Namespaces().UpdateNamespaceCredential(ctx, nsId, name, MAIN_TENANT, updateBody)
		require.NoError(t, err)
		require.Equal(t, "updated by go sdk test", updated["description"])

		// test connection (a failed connection is still a 200 ApiTestConnectionResponse)
		testRes, err := KestraTestClient().Namespaces().TestNamespaceCredential(ctx, nsId, name, MAIN_TENANT)
		require.NoError(t, err)
		_, hasSuccess := testRes["success"]
		require.True(t, hasSuccess, "test connection response should carry a success flag")

		err = KestraTestClient().Namespaces().DeleteNamespaceCredential(ctx, nsId, name, MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Namespaces().NamespaceCredential(ctx, nsId, name, MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("namespaceKvDetailTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_ns_kv_detail_" + randomId()
		_, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, kestra_api_client.Namespace{Id: nsId})
		require.NoError(t, err)

		key := "detail_key_" + randomId()
		err = KestraTestClient().Kv().SetKeyValue(ctx, nsId, key, MAIN_TENANT, `"detail-value"`)
		require.NoError(t, err)

		detail, err := KestraTestClient().Namespaces().NamespaceKvDetail(ctx, nsId, key, MAIN_TENANT)
		require.NoError(t, err)
		// KvDetail carries the stored value, type and revision (not the key itself).
		require.Equal(t, "detail-value", detail["value"], "the detail response echoes the stored value")
		require.NotNil(t, detail["type"], "the detail response reports the value type")
	})

	t.Run("namespacePoliciesCrudTest", func(t *testing.T) {
		ctx := context.Background()

		nsId := "test_ns_policies_" + randomId()
		_, err := KestraTestClient().Namespaces().CreateNamespace(ctx, MAIN_TENANT, kestra_api_client.Namespace{Id: nsId})
		require.NoError(t, err)

		// search over the resolution chain always answers (empty chain is a valid paged envelope)
		search, err := KestraTestClient().Namespaces().SearchNamespacePolicies(ctx, nsId, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil)
		if err != nil {
			t.Skipf("namespace policies not available on this instance: %v", err)
		}
		_, hasTotal := search["total"]
		require.True(t, hasTotal, "policy search should carry a paged total")

		policyId := "pol_" + randomId()
		source := "id: " + policyId + "\n" +
			"displayName: Go SDK test policy\n" +
			"rules:\n" +
			"  - type: io.kestra.ee.policies.models.ValidateRule\n" +
			"    id: require-desc\n" +
			"    conditions: []\n"

		// validate the source (a validation response is returned whether or not it is valid)
		validation, err := KestraTestClient().Namespaces().ValidateNamespacePolicy(ctx, nsId, MAIN_TENANT, source)
		if err != nil {
			t.Skipf("namespace policy validate rejected on this instance: %v", err)
		}
		require.NotNil(t, validation)

		created, err := KestraTestClient().Namespaces().CreateNamespacePolicy(ctx, nsId, MAIN_TENANT, source)
		if err != nil {
			t.Skipf("could not create a namespace policy (schema/license dependent): %v", err)
		}
		require.Equal(t, policyId, created["id"])

		got, err := KestraTestClient().Namespaces().NamespacePolicy(ctx, nsId, policyId, MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, policyId, got["id"])

		eval, err := KestraTestClient().Namespaces().EvaluateNamespacePolicy(ctx, nsId, policyId, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(25))
		require.NoError(t, err)
		require.NotNil(t, eval)

		updated, err := KestraTestClient().Namespaces().UpdateNamespacePolicy(ctx, nsId, policyId, MAIN_TENANT, source)
		require.NoError(t, err)
		require.Equal(t, policyId, updated["id"])

		export, err := KestraTestClient().Namespaces().ExportNamespacePolicies(ctx, nsId, MAIN_TENANT)
		require.NoError(t, err)
		require.NotEmpty(t, export)

		exportByIds, err := KestraTestClient().Namespaces().ExportNamespacePoliciesByIds(ctx, nsId, MAIN_TENANT, []string{policyId})
		require.NoError(t, err)
		require.NotEmpty(t, exportByIds)

		bulk, err := KestraTestClient().Namespaces().DeleteNamespacePoliciesByIds(ctx, nsId, MAIN_TENANT, []string{policyId})
		require.NoError(t, err)
		require.NotNil(t, bulk)

		// recreate then delete singly to cover the by-id delete route
		_, err = KestraTestClient().Namespaces().CreateNamespacePolicy(ctx, nsId, MAIN_TENANT, source)
		require.NoError(t, err)
		err = KestraTestClient().Namespaces().DeleteNamespacePolicy(ctx, nsId, policyId, MAIN_TENANT)
		require.NoError(t, err)
	})
}
