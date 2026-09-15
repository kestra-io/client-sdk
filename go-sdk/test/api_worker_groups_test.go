package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestWorkerGroupsAPI_ReadAndTokens(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	list, err := client.WorkerGroups().ListWorkerGroups(ctx, nil)
	require.NoError(t, err, "listing worker groups should succeed as instance owner")
	require.NotEmpty(t, list.GetWorkerGroups(), "a plain EE instance exposes at least the default worker group")

	group := list.GetWorkerGroups()[0]
	require.NotEmpty(t, group.GetId(), "each worker group has an id")

	t.Run("get worker group by id", func(t *testing.T) {
		fetched, err := client.WorkerGroups().WorkerGroup(ctx, group.GetId())
		require.NoError(t, err)
		require.Equal(t, group.GetId(), fetched.GetId(), "fetching by id returns the same group")
		require.NotEmpty(t, fetched.GetName(), "a worker group has a name")
	})

	t.Run("generate, revoke and delete a registration token", func(t *testing.T) {
		tokenName := "sdk-token-" + randomId()
		generated, err := client.WorkerGroups().GenerateWorkerGroupToken(ctx, group.GetId(), kestra_api_client.ApiGenerateTokenRequest{
			Name: tokenName,
		})
		require.NoError(t, err, "generating a registration token should succeed")
		require.NotEmpty(t, generated.GetToken(), "the plaintext token is returned exactly once")
		details := generated.GetDetails()
		uid := details.GetUid()
		require.NotEmpty(t, uid, "the generated token has a uid")
		require.Equal(t, tokenName, details.GetName())

		revoked, err := client.WorkerGroups().RevokeWorkerGroupToken(ctx, group.GetId(), uid)
		require.NoError(t, err, "revoking the token should succeed")
		require.True(t, tokenRevoked(revoked, uid), "the revoked token must be marked revoked on the group")

		require.NoError(t, client.WorkerGroups().DeleteWorkerGroupToken(ctx, group.GetId(), uid),
			"deleting the token should succeed")
	})
}

func tokenRevoked(group *kestra_api_client.ApiWorkerGroup, uid string) bool {
	for _, tok := range group.GetTokens() {
		if tok.GetUid() == uid {
			return tok.GetRevoked()
		}
	}
	return false
}
