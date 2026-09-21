package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestMeAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("currentUser", func(t *testing.T) {
		me, err := client.Me().CurrentUser(ctx)
		require.NoError(t, err)
		require.NotNil(t, me)
		require.NotEmpty(t, me.GetId(), "the current user has an id")
		require.True(t, me.GetInstanceOwner(), "the bootstrap super-admin is the instance owner")
		require.NotNil(t, me.GetProfile(), "the current user exposes a profile")
		require.Equal(t, adminUsername, me.GetProfile().GetEmail(), "the profile email is the bootstrap admin's")
	})

	t.Run("apiTokenLifecycle", func(t *testing.T) {
		name := "sdktest" + randomId()
		created, err := client.Me().CreateApiToken(ctx, kestra_api_client.CreateApiTokenRequest{Name: name})
		require.NoError(t, err)
		require.NotNil(t, created)
		require.NotEmpty(t, created.FullToken, "the freshly minted token carries its one-time secret")
		require.NotEmpty(t, created.Id)
		tokenId := created.Id
		t.Cleanup(func() {
			_ = KestraTestClient().Me().DeleteApiToken(context.Background(), tokenId)
		})

		list, err := client.Me().ListApiTokens(ctx)
		require.NoError(t, err)
		require.NotNil(t, list)
		found := false
		for _, tok := range list.Results {
			if tok.Id != nil && *tok.Id == tokenId {
				found = true
				require.Equal(t, name, *tok.Name, "the listed token keeps the name it was created with")
			}
		}
		assert.True(t, found, "the created token is returned by the listing")

		require.NoError(t, client.Me().DeleteApiToken(ctx, tokenId))

		after, err := client.Me().ListApiTokens(ctx)
		require.NoError(t, err)
		for _, tok := range after.Results {
			if tok.Id != nil {
				assert.NotEqual(t, tokenId, *tok.Id, "the deleted token is gone from the listing")
			}
		}
	})

	t.Run("invitations", func(t *testing.T) {
		invitations, err := client.Me().ListInvitations(ctx)
		require.NoError(t, err, "listing one's own invitations is always available to an authenticated user")
		require.NotNil(t, invitations, "an empty invitation list is a JSON array, not null")
	})

	t.Run("updateProfileAndPasswordAreMutating", func(t *testing.T) {
		// PATCH /me and PUT /me/password rewrite the identity (and password) of the
		// shared bootstrap super-admin whose API token authenticates the whole suite;
		// running them for real would invalidate every subsequent test's client.
		t.Skip("PATCH /me and PUT /me/password mutate the shared bootstrap super-admin; wrappers are compile-and-coverage only")
	})
}
