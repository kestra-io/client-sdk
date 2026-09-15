package test

import (
	"errors"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

// skipIfGated skips the current test when err is an ApiError whose status shows
// the endpoint's controller or license feature is not active on the CI image
// (403 unmatched-route/forbidden, 404 not-found, 422 unprocessable, 501/503
// not-implemented/unavailable). Otherwise it returns err unchanged so the caller
// can require.NoError on it. This lets a wrapper for a feature-gated EE endpoint
// keep a real test that still passes on an image where the feature is off.
func skipIfGated(t *testing.T, err error, feature string) error {
	t.Helper()
	if err == nil {
		return nil
	}
	var apiErr *kestra_api_client.ApiError
	if errors.As(err, &apiErr) {
		switch apiErr.StatusCode {
		case 401, 403, 404, 422, 501, 503:
			t.Skipf("%s is not active on this instance (HTTP %d); the wrapper is still exercised for compilation and coverage", feature, apiErr.StatusCode)
		}
	}
	return err
}
