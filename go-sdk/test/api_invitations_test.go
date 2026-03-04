package test

import (
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func invPtr[T any](v T) *T { return &v }

func TestInvitationsAPI_All(t *testing.T) {
	t.Run("searchInvitationsByEmailFilterTest", func(t *testing.T) {
		ctx := GetAuthContext()
		email := "test_invitation_filter_" + randomId() + "@kestra.io"

		_, err := KestraTestApiClient().InvitationsAPI.CreateInvitation(ctx, MAIN_TENANT).
			IAMInvitationControllerApiInvitationCreateRequest(
				kestra_api_client.IAMInvitationControllerApiInvitationCreateRequest{Email: email},
			).
			Execute()
		require.NoError(t, err)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     invPtr(kestra_api_client.QUERYFILTERFIELD_EMAIL),
				Operation: invPtr(kestra_api_client.QUERYFILTEROP_EQUALS),
				Value:     email,
			},
		}
		page, _, err := KestraTestApiClient().InvitationsAPI.SearchInvitations(ctx, MAIN_TENANT).
			Page(1).
			Size(50).
			Filters(filters).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, page)
		require.NotNil(t, page.GetResults())
		assert.True(t, func() bool {
			for _, invitation := range page.GetResults() {
				if invitation.GetEmail() == email {
					return true
				}
			}
			return false
		}(), "Search should include the invitation created for the filtered email")

		invitations, _, err := KestraTestApiClient().InvitationsAPI.ListInvitationsByEmail(ctx, email, MAIN_TENANT).Execute()
		require.NoError(t, err)
		for _, invitation := range invitations {
			_, _ = KestraTestApiClient().InvitationsAPI.DeleteInvitation(ctx, invitation.GetId(), MAIN_TENANT).Execute()
		}
	})
}
