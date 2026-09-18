package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestAppsViewsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("states", func(t *testing.T) {
		states, err := client.Apps().AppStates(ctx, MAIN_TENANT)
		if skipIfGated(t, err, "the Apps feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, states, "the app state names are a JSON array, not null")
	})

	t.Run("openUnknownAppView", func(t *testing.T) {
		_, err := client.Apps().OpenAppView(ctx, "missing-"+randomId(), MAIN_TENANT)
		require.Error(t, err, "opening a missing app view is an error")
	})

	t.Run("previewDownloadDispatchNeedAConcreteApp", func(t *testing.T) {
		// preview renders arbitrary app YAML; file download and the two dispatch
		// endpoints act on a rendered app execution and take multipart input data,
		// so they need a concrete published app to target.
		t.Skip("app preview/file-download/dispatch need a concrete app and input data; wrappers are compile-and-coverage only")
	})
}
