package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestTenantAccessAPI_All(t *testing.T) {
	// A user created without tenants has no access to the tenant, which is the
	// state the grant has to fix.
	createUserWithoutTenantAccess := func(t *testing.T, ctx context.Context, prefix string) string {
		t.Helper()
		created, err := KestraTestClient().Users().CreateUser(ctx, map[string]interface{}{
			"email": prefix + randomId() + "@kestra.io",
		})
		require.NoError(t, err)
		return created.GetId()
	}

	t.Run("createTenantAccessByIdTest", func(t *testing.T) {
		ctx := context.Background()
		userId := createUserWithoutTenantAccess(t, ctx, "test_tenant_access_")

		require.NoError(t, KestraTestClient().TenantAccess().CreateTenantAccess(ctx, userId, MAIN_TENANT))

		access, err := KestraTestClient().TenantAccess().TenantAccess(ctx, userId, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, access)

		require.NoError(t, KestraTestClient().Users().DeleteUser(ctx, userId))
	})

	t.Run("createTenantAccessByEmailTest", func(t *testing.T) {
		ctx := context.Background()
		email := "test_tenant_access_email_" + randomId() + "@kestra.io"
		created, err := KestraTestClient().Users().CreateUser(ctx, map[string]interface{}{"email": email})
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().TenantAccess().CreateTenantAccessByEmail(ctx, MAIN_TENANT,
			map[string]interface{}{"email": email}))

		access, err := KestraTestClient().TenantAccess().TenantAccess(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, access)

		require.NoError(t, KestraTestClient().Users().DeleteUser(ctx, created.GetId()))
	})

	t.Run("listTenantAccessTest", func(t *testing.T) {
		ctx := context.Background()
		userId := createUserWithoutTenantAccess(t, ctx, "test_tenant_access_list_")
		require.NoError(t, KestraTestClient().TenantAccess().CreateTenantAccess(ctx, userId, MAIN_TENANT))

		page, size := 1, 100
		results, err := KestraTestClient().TenantAccess().ListTenantAccess(ctx, MAIN_TENANT, &page, &size, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, results)

		found := false
		for _, item := range results.GetResults() {
			if item.GetId() == userId {
				found = true
				break
			}
		}
		assert.True(t, found, "the granted user should be listed as having tenant access")

		require.NoError(t, KestraTestClient().Users().DeleteUser(ctx, userId))
	})

	t.Run("deleteTenantAccessTest", func(t *testing.T) {
		ctx := context.Background()
		userId := createUserWithoutTenantAccess(t, ctx, "test_tenant_access_delete_")
		require.NoError(t, KestraTestClient().TenantAccess().CreateTenantAccess(ctx, userId, MAIN_TENANT))

		require.NoError(t, KestraTestClient().TenantAccess().DeleteTenantAccess(ctx, userId, MAIN_TENANT))

		_, err := KestraTestClient().TenantAccess().TenantAccess(ctx, userId, MAIN_TENANT)
		assert.Error(t, err, "the access should be gone once revoked")

		require.NoError(t, KestraTestClient().Users().DeleteUser(ctx, userId))
	})

	// The reason this API matters: since Kestra 2.0 a group add resolves the user
	// through a hasTenantAccess filter, so granting access first is what makes it
	// work for a user created without tenants.
	t.Run("grantThenAddToGroupTest", func(t *testing.T) {
		ctx := context.Background()
		userId := createUserWithoutTenantAccess(t, ctx, "test_tenant_access_group_")

		group, err := KestraTestClient().Groups().CreateGroup(ctx, MAIN_TENANT, map[string]interface{}{
			"name": "test_tenant_access_group_" + randomId(),
		})
		require.NoError(t, err)

		_, err = KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), userId, MAIN_TENANT)
		require.Error(t, err, "without tenant access the group add is rejected")

		require.NoError(t, KestraTestClient().TenantAccess().CreateTenantAccess(ctx, userId, MAIN_TENANT))

		member, err := KestraTestClient().Groups().AddUserToGroup(ctx, group.GetId(), userId, MAIN_TENANT)
		require.NoError(t, err, "the group add should succeed once tenant access is granted")
		require.NotNil(t, member)

		require.NoError(t, KestraTestClient().Groups().DeleteGroup(ctx, group.GetId(), MAIN_TENANT))
		require.NoError(t, KestraTestClient().Users().DeleteUser(ctx, userId))
	})
}
