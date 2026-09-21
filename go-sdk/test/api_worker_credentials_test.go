package test

import (
	"context"
	"errors"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestWorkerCredentialsAPI_List(t *testing.T) {
	ctx := context.Background()
	list, err := KestraTestClient().WorkerCredentials().ListWorkerCredentials(ctx)
	if err != nil {
		var apiErr *kestra_api_client.ApiError
		if errors.As(err, &apiErr) && apiErr.StatusCode == 403 {
			t.Skip("worker authentication is disabled (kestra.ee.worker.auth.enabled=false); " +
				"the WorkerCredential controller does not load and every route answers 403")
		}
		require.NoError(t, err)
	}
	for _, w := range list.GetWorkers() {
		require.NotEmpty(t, w.GetId(), "each worker credential has an id")
	}
}
