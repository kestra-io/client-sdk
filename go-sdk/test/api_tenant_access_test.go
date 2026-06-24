package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestTenantAccessAPI_All(t *testing.T) {
	t.Run("createAndListTenantAccessTest", func(t *testing.T) {
		ctx := context.Background()
		email := "sdktest_ta_" + randomId() + "@kestra.io"
		req := kestra_api_client.NewIAMTenantAccessControllerApiCreateTenantAccessRequest(email)

		err := KestraTestClient().TenantAccess().CreateTenantAccess(ctx, MAIN_TENANT, *req)
		require.NoError(t, err)

		page, err := KestraTestClient().TenantAccess().ListTenantAccess(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100))
		require.NoError(t, err)
		require.NotNil(t, page)
		require.Greater(t, len(page.GetResults()), 0)
	})

	t.Run("deleteTenantAccessTest", func(t *testing.T) {
		ctx := context.Background()
		email := "sdktest_ta_del_" + randomId() + "@kestra.io"
		req := kestra_api_client.NewIAMTenantAccessControllerApiCreateTenantAccessRequest(email)

		err := KestraTestClient().TenantAccess().CreateTenantAccess(ctx, MAIN_TENANT, *req)
		require.NoError(t, err)

		page, err := KestraTestClient().TenantAccess().ListTenantAccess(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(100))
		require.NoError(t, err)

		var userId string
		for _, entry := range page.GetResults() {
			if entry.GetId() != "" {
				userId = entry.GetId()
				break
			}
		}
		if userId == "" {
			t.Skip("no tenant access entry found to delete")
		}

		err = KestraTestClient().TenantAccess().DeleteTenantAccess(ctx, userId, MAIN_TENANT)
		require.NoError(t, err)
	})
}
