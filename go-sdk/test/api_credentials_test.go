package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestCredentialsAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	page, size := 1, 10

	t.Run("list", func(t *testing.T) {
		res, err := client.Credentials().ListCredentials(ctx, MAIN_TENANT, &page, &size, nil, nil)
		if skipIfGated(t, err, "the CREDENTIAL feature") != nil {
			require.NoError(t, err)
		}
		require.NotNil(t, res)
		_, ok := res["results"]
		require.True(t, ok, "a credentials page carries a results array")
		_, ok = res["total"]
		require.True(t, ok, "a credentials page carries a total")
	})

	t.Run("getUnknownCredential", func(t *testing.T) {
		_, err := client.Credentials().Credential(ctx, "does-not-exist-"+randomId(), MAIN_TENANT)
		require.Error(t, err, "fetching a missing credential is an error, not a nil credential")
	})

	t.Run("createUpdateDeleteTestRequireAProviderConfig", func(t *testing.T) {
		// Create/update take a polymorphic OAuth2/GitHub-App request whose auth
		// config and token endpoint must be valid to pass server validation, and
		// the whole controller is gated by the CREDENTIAL feature; exercising the
		// mutating paths for real needs a configured provider.
		t.Skip("credential create/update/delete/test need a valid provider config and the CREDENTIAL feature; wrappers are compile-and-coverage only")
	})
}
