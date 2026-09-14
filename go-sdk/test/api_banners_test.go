package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestBannersAPI_All(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	message := "sdk-banner-" + randomId()
	created, err := client.Banners().CreateBanner(ctx, kestra_api_client.Banner{
		Message: message,
		Type:    ptr(kestra_api_client.BANNERTYPE_WARNING),
	})
	require.NoError(t, err, "creating a banner as instance owner should succeed")
	require.NotEmpty(t, created.GetId(), "the server assigns an id")
	require.Equal(t, message, created.GetMessage())
	require.Equal(t, kestra_api_client.BANNERTYPE_WARNING, created.GetType())
	require.True(t, created.GetActive(), "the server forces new banners active")
	id := created.GetId()

	t.Cleanup(func() {
		_ = client.Banners().DeleteBanner(context.Background(), id)
	})

	t.Run("update", func(t *testing.T) {
		newMessage := message + "-updated"
		updated, err := client.Banners().UpdateBanner(ctx, id, kestra_api_client.Banner{
			Id:      &id,
			Message: newMessage,
			Type:    ptr(kestra_api_client.BANNERTYPE_INFO),
			Active:  ptr(true),
		})
		require.NoError(t, err)
		require.Equal(t, id, updated.GetId(), "the id is preserved across the update")
		require.Equal(t, newMessage, updated.GetMessage())
		require.Equal(t, kestra_api_client.BANNERTYPE_INFO, updated.GetType())
	})

	t.Run("search finds the banner", func(t *testing.T) {
		banners, err := client.Banners().SearchBanners(ctx, nil)
		require.NoError(t, err)
		found := false
		for _, b := range banners {
			if b.GetId() == id {
				found = true
				break
			}
		}
		require.True(t, found, "the created banner must appear in the search results")
	})

	t.Run("delete", func(t *testing.T) {
		require.NoError(t, client.Banners().DeleteBanner(ctx, id))
		banners, err := client.Banners().SearchBanners(ctx, nil)
		require.NoError(t, err)
		for _, b := range banners {
			require.NotEqual(t, id, b.GetId(), "the deleted banner must be gone from search results")
		}
	})
}
