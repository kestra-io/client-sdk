package test

import (
	"context"
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestKillSwitchesAPI_All(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	name := "sdk-killswitch-" + randomId()
	created, err := client.KillSwitches().CreateKillSwitch(ctx, kestra_api_client.KillSwitch{
		Name:           name,
		StartDate:      kestra_api_client.NewLocalDateTime(time.Now().UTC()),
		EvaluationType: kestra_api_client.EVALUATIONTYPE_PASS,
		Namespace:      strPtr("io.kestra.sdk"),
	})
	require.NoError(t, err, "creating a kill switch as instance owner should succeed")
	require.NotEmpty(t, created.GetId(), "the server assigns an id")
	require.Equal(t, name, created.GetName())
	require.Equal(t, kestra_api_client.EVALUATIONTYPE_PASS, created.GetEvaluationType())
	id := created.GetId()

	t.Cleanup(func() {
		_ = client.KillSwitches().DeleteKillSwitch(context.Background(), id)
	})

	t.Run("update", func(t *testing.T) {
		updated, err := client.KillSwitches().UpdateKillSwitch(ctx, id, kestra_api_client.KillSwitch{
			Id:             &id,
			Name:           name,
			StartDate:      created.GetStartDate(),
			EvaluationType: kestra_api_client.EVALUATIONTYPE_CANCEL,
			Namespace:      strPtr("io.kestra.sdk"),
		})
		require.NoError(t, err)
		require.Equal(t, id, updated.GetId(), "the id is preserved across the update")
		require.Equal(t, kestra_api_client.EVALUATIONTYPE_CANCEL, updated.GetEvaluationType(),
			"the evaluation type change round-trips")
	})

	t.Run("search finds the kill switch", func(t *testing.T) {
		switches, err := client.KillSwitches().SearchKillSwitches(ctx)
		require.NoError(t, err)
		found := false
		for _, ks := range switches {
			if ks.GetId() == id {
				found = true
				break
			}
		}
		require.True(t, found, "the created kill switch must appear in the search results")
	})

	t.Run("delete", func(t *testing.T) {
		require.NoError(t, client.KillSwitches().DeleteKillSwitch(ctx, id))
		switches, err := client.KillSwitches().SearchKillSwitches(ctx)
		require.NoError(t, err)
		for _, ks := range switches {
			require.NotEqual(t, id, ks.GetId(), "the deleted kill switch must be gone from search results")
		}
	})
}
