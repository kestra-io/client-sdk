package test

import (
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
		ctx := GetAuthContext()

		name := "test-create-service-account-" + randomId()
		req := kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{
			Name:        name,
			Description: strPtr("service account created by tests"),
		}

		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(req).
			Execute()
		require.NoError(t, err)
		require.NotEmpty(t, created.GetId())
	})

	t.Run("createServiceAccountForTenantTest", func(t *testing.T) {
		ctx := GetAuthContext()

		fullName := "test-create-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		req := kestra_api_client.IAMServiceAccountControllerApiServiceAccountRequest{
			Name:        name,
			Description: strPtr("service account for tenant"),
		}

		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccountForTenant(ctx, MAIN_TENANT).
			IAMServiceAccountControllerApiServiceAccountRequest(req).
			Execute()
		require.NoError(t, err)
		require.NotEmpty(t, created.GetId())
	})

	t.Run("deleteServiceAccountTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test-delete-service-account-" + randomId()
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().ServiceAccountAPI.DeleteServiceAccount(ctx, created.GetId()).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().ServiceAccountAPI.ServiceAccount(ctx, created.GetId()).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("deleteServiceAccountForTenantTest", func(t *testing.T) {
		ctx := GetAuthContext()

		fullName := "test-delete-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccountForTenant(ctx, MAIN_TENANT).
			IAMServiceAccountControllerApiServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		_, err = KestraTestApiClient().ServiceAccountAPI.DeleteServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)

		_, httpResp, err := KestraTestApiClient().ServiceAccountAPI.ServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.Error(t, err)
		if httpResp != nil {
			require.Equal(t, 404, httpResp.StatusCode)
		}
	})

	t.Run("getServiceAccountTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test-get-service-account-" + randomId()
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().ServiceAccountAPI.ServiceAccount(ctx, created.GetId()).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("getServiceAccountForTenantTest", func(t *testing.T) {
		ctx := GetAuthContext()

		fullName := "test-get-service-account-for-tenant-" + randomId()
		name := truncateServiceAccountName(fullName)
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccountForTenant(ctx, MAIN_TENANT).
			IAMServiceAccountControllerApiServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().ServiceAccountAPI.ServiceAccountForTenant(ctx, created.GetId(), MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
	})

	t.Run("listServiceAccountsTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test-list-service-accounts-" + randomId()
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		page, _, err := KestraTestApiClient().ServiceAccountAPI.ListServiceAccounts(ctx).
			Page(1).
			Size(50).
			Execute()
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
		ctx := GetAuthContext()

		fullName := "test-patch-service-account-details-" + randomId()
		name := truncateServiceAccountName(fullName)
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name, Description: strPtr("old")},
			).
			Execute()
		require.NoError(t, err)

		patchReq := kestra_api_client.IAMServiceAccountControllerApiPatchServiceAccountRequest{
			Name:        name,
			Description: strPtr("new"),
		}
		patched, _, err := KestraTestApiClient().ServiceAccountAPI.PatchServiceAccountDetails(ctx, created.GetId()).
			IAMServiceAccountControllerApiPatchServiceAccountRequest(patchReq).
			Execute()
		require.NoError(t, err)
		require.Equal(t, "new", patched.GetDescription())
	})

	t.Run("patchServiceAccountSuperAdminTest", func(t *testing.T) {
		ctx := GetAuthContext()

		fullName := "test-patch-service-account-super-admin-" + randomId()
		name := truncateServiceAccountName(fullName)
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name},
			).
			Execute()
		require.NoError(t, err)

		patch := kestra_api_client.ApiPatchSuperAdminRequest{SuperAdmin: true}
		_, err = KestraTestApiClient().ServiceAccountAPI.PatchServiceAccountSuperAdmin(ctx, created.GetId()).
			ApiPatchSuperAdminRequest(patch).
			Execute()
		require.NoError(t, err)

		fetched, _, err := KestraTestApiClient().ServiceAccountAPI.ServiceAccount(ctx, created.GetId()).Execute()
		require.NoError(t, err)
		require.True(t, fetched.GetSuperAdmin())
	})

	t.Run("updateServiceAccountTest", func(t *testing.T) {
		ctx := GetAuthContext()

		name := "test-update-service-account-" + randomId()
		created, _, err := KestraTestApiClient().ServiceAccountAPI.CreateServiceAccount(ctx).
			IAMServiceAccountControllerApiCreateServiceAccountRequest(
				kestra_api_client.IAMServiceAccountControllerApiCreateServiceAccountRequest{Name: name, Description: strPtr("Before")},
			).
			Execute()
		require.NoError(t, err)

		updateReq := kestra_api_client.IAMServiceAccountControllerApiServiceAccountRequest{
			Name:        created.GetName(),
			Description: strPtr("After"),
		}
		updated, _, err := KestraTestApiClient().ServiceAccountAPI.UpdateServiceAccount(ctx, created.GetId(), MAIN_TENANT).
			IAMServiceAccountControllerApiServiceAccountRequest(updateReq).
			Execute()
		require.NoError(t, err)
		require.Equal(t, "After", updated.GetDescription())
	})
}
