package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func truncateServiceAccountName(name string) string {
	if len(name) > 62 {
		return name[:62]
	}
	return name
}

func TestServiceAccountAPI_All(t *testing.T) {
	t.Run("createServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test-create-service-account-" + randomId()
		req := map[string]interface{}{
			"name":        name,
			"description": "service account created by tests",
		}

		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)
		require.NotEmpty(t, created.GetId())
	})

	t.Run("createServiceAccountForTenantTest", func(t *testing.T) {
		ctx := context.Background()

		fullName := "test-create-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{
			"name":        name,
			"description": "service account for tenant",
		}

		created, err := KestraTestClient().ServiceAccount().CreateServiceAccountForTenant(ctx, MAIN_TENANT, req)
		require.NoError(t, err)
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test-delete-service-account-" + randomId()
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		err = KestraTestClient().ServiceAccount().DeleteServiceAccount(ctx, created.GetId())
		require.NoError(t, err)

		_, err = KestraTestClient().ServiceAccount().ServiceAccount(ctx, created.GetId())
		require.Error(t, err)
	})

	t.Run("deleteServiceAccountForTenantTest", func(t *testing.T) {
		ctx := context.Background()

		fullName := "test-delete-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccountForTenant(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		err = KestraTestClient().ServiceAccount().DeleteServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().ServiceAccount().ServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})

	t.Run("getServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test-get-service-account-" + randomId()
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		fetched, err := KestraTestClient().ServiceAccount().ServiceAccount(ctx, created.GetId())
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("getServiceAccountForTenantTest", func(t *testing.T) {
		ctx := context.Background()

		fullName := "test-get-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccountForTenant(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		fetched, err := KestraTestClient().ServiceAccount().ServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("listServiceAccountsTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test-list-service-accounts-" + randomId()
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		page, err := KestraTestClient().ServiceAccount().ListServiceAccounts(ctx, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(50), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, page)
		require.NotNil(t, page.GetResults())

		found := false
		for _, sa := range page.GetResults() {
			if sa.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found)
	})

	t.Run("patchServiceAccountDetailsTest", func(t *testing.T) {
		ctx := context.Background()

		fullName := "test-patch-service-account-details-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{
			"name":        name,
			"description": "old",
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		patchReq := map[string]interface{}{
			"name":        name,
			"description": "new",
		}
		patched, err := KestraTestClient().ServiceAccount().PatchServiceAccountDetails(ctx, created.GetId(), patchReq)
		require.NoError(t, err)
		require.Equal(t, "new", patched.GetDescription())
	})

	t.Run("patchServiceAccountSuperAdminTest", func(t *testing.T) {
		ctx := context.Background()

		fullName := "test-patch-service-account-super-admin-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{
			"name": name,
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		patch := map[string]interface{}{"superAdmin": true}
		err = KestraTestClient().ServiceAccount().PatchServiceAccountSuperAdmin(ctx, created.GetId(), patch)
		require.NoError(t, err)

		fetched, err := KestraTestClient().ServiceAccount().ServiceAccount(ctx, created.GetId())
		require.NoError(t, err)
		require.True(t, fetched.GetSuperAdmin())
	})

	t.Run("updateServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()

		name := "test-update-service-account-" + randomId()
		req := map[string]interface{}{
			"name":        name,
			"description": "Before",
		}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		updateReq := map[string]interface{}{
			"name":        created.GetName(),
			"description": "After",
		}
		updated, err := KestraTestClient().ServiceAccount().UpdateServiceAccount(ctx, created.GetId(), MAIN_TENANT, updateReq)
		require.NoError(t, err)
		require.Equal(t, "After", updated.GetDescription())
	})

	t.Run("createAndListApiTokensForServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()
		name := "test-api-tokens-sa-" + randomId()
		req := map[string]interface{}{"name": name}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name":        "test-token-" + randomId(),
			"description": "test token",
		}
		tokenResp, err := KestraTestClient().ServiceAccount().CreateApiTokensForServiceAccount(ctx, created.GetId(), tokenReq)
		require.NoError(t, err)
		require.NotNil(t, tokenResp)

		tokens, err := KestraTestClient().ServiceAccount().ListApiTokensForServiceAccount(ctx, created.GetId())
		require.NoError(t, err)
		require.NotNil(t, tokens)
	})

	t.Run("deleteApiTokenForServiceAccountTest", func(t *testing.T) {
		ctx := context.Background()
		name := "test-delete-api-token-sa-" + randomId()
		req := map[string]interface{}{"name": name}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccount(ctx, req)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name": "test-token-" + randomId(),
		}
		tokenResp, err := KestraTestClient().ServiceAccount().CreateApiTokensForServiceAccount(ctx, created.GetId(), tokenReq)
		require.NoError(t, err)

		tokenId, ok := tokenResp["id"].(string)
		require.True(t, ok, "token response should contain string id")

		err = KestraTestClient().ServiceAccount().DeleteApiTokenForServiceAccount(ctx, created.GetId(), tokenId)
		require.NoError(t, err)
	})

	t.Run("createAndListApiTokensForServiceAccountWithTenantTest", func(t *testing.T) {
		ctx := context.Background()
		fullName := "test-api-tokens-sa-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{"name": name}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccountForTenant(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name":        "test-token-" + randomId(),
			"description": "test token",
		}
		tokenResp, err := KestraTestClient().ServiceAccount().CreateApiTokensForServiceAccountWithTenant(ctx, created.GetId(), MAIN_TENANT, tokenReq)
		require.NoError(t, err)
		require.NotNil(t, tokenResp)

		tokens, err := KestraTestClient().ServiceAccount().ListApiTokensForServiceAccountWithTenant(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, tokens)
	})

	t.Run("deleteApiTokenForServiceAccountWithTenantTest", func(t *testing.T) {
		ctx := context.Background()
		fullName := "test-delete-api-token-sa-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := map[string]interface{}{"name": name}
		created, err := KestraTestClient().ServiceAccount().CreateServiceAccountForTenant(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		tokenReq := map[string]interface{}{
			"name": "test-token-" + randomId(),
		}
		tokenResp, err := KestraTestClient().ServiceAccount().CreateApiTokensForServiceAccountWithTenant(ctx, created.GetId(), MAIN_TENANT, tokenReq)
		require.NoError(t, err)

		tokenId, ok := tokenResp["id"].(string)
		require.True(t, ok, "token response should contain string id")

		err = KestraTestClient().ServiceAccount().DeleteApiTokenForServiceAccountWithTenant(ctx, created.GetId(), tokenId, MAIN_TENANT)
		require.NoError(t, err)
	})
}

