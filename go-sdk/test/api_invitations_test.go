package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// createTestInvitation sends an invitation for a freshly generated email and returns it.
// Invitations are an EE feature; these calls require an EE test image.
func createTestInvitation(t *testing.T, ctx context.Context) *kestra_api_client.IAMInvitationControllerApiInvitationDetail {
	t.Helper()

	// Use a fresh email with no existing user so the server persists an
	// Invitation and returns its detail (201). Setting CreateUserIfNotExist, or
	// reusing an existing user's email, makes the server grant access directly
	// and return 204 with no body.
	email := "sdktest_" + randomId() + "@kestra.io"
	req := kestra_api_client.NewIAMInvitationControllerApiInvitationCreateRequest(email)

	created, err := KestraTestClient().Invitations().CreateInvitation(ctx, MAIN_TENANT, *req)
	require.NoError(t, err)
	require.NotNil(t, created)
	require.NotEmpty(t, created.GetId())
	require.Equal(t, email, created.GetEmail())

	// Best-effort cleanup so repeated runs don't accumulate pending invitations.
	t.Cleanup(func() {
		_ = KestraTestClient().Invitations().DeleteInvitation(ctx, created.GetId(), MAIN_TENANT)
	})
	return created
}

func TestInvitationsAPI_All(t *testing.T) {
	t.Run("createInvitationTest", func(t *testing.T) {
		ctx := context.Background()
		created := createTestInvitation(t, ctx)
		require.Equal(t, kestra_api_client.INVITATIONINVITATIONSTATUS_PENDING, created.GetStatus())
	})

	t.Run("getInvitationTest", func(t *testing.T) {
		ctx := context.Background()
		created := createTestInvitation(t, ctx)

		fetched, err := KestraTestClient().Invitations().Invitation(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, created.GetId(), fetched.GetId())
		require.Equal(t, created.GetEmail(), fetched.GetEmail())
	})

	t.Run("listInvitationsByEmailTest", func(t *testing.T) {
		ctx := context.Background()
		created := createTestInvitation(t, ctx)

		invitations, err := KestraTestClient().Invitations().ListInvitationsByEmail(ctx, created.GetEmail(), MAIN_TENANT)
		require.NoError(t, err)
		require.NotEmpty(t, invitations)
		require.Equal(t, created.GetId(), invitations[0].GetId())
	})

	t.Run("searchInvitationsTest", func(t *testing.T) {
		ctx := context.Background()
		created := createTestInvitation(t, ctx)

		// Filter via email/status, which both Kestra 1.3 and 2.x understand.
		status := kestra_api_client.INVITATIONINVITATIONSTATUS_PENDING
		page, err := KestraTestClient().Invitations().SearchInvitations(
			ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil,
			kestra_api_client.PtrString(created.GetEmail()), &status, nil,
		)
		require.NoError(t, err)
		require.NotNil(t, page)

		found := false
		for _, inv := range page.GetResults() {
			if inv.GetId() == created.GetId() {
				found = true
				break
			}
		}
		require.True(t, found, "search should include the created invitation")
	})

	t.Run("deleteInvitationTest", func(t *testing.T) {
		ctx := context.Background()
		created := createTestInvitation(t, ctx)

		err := KestraTestClient().Invitations().DeleteInvitation(ctx, created.GetId(), MAIN_TENANT)
		require.NoError(t, err)

		_, err = KestraTestClient().Invitations().Invitation(ctx, created.GetId(), MAIN_TENANT)
		require.Error(t, err)
	})
}
