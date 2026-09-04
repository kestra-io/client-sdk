package test

import (
	"context"
	"fmt"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func reusableInputsSource(namespace, id string) string {
	return fmt.Sprintf(`id: %s
namespace: %s
description: shared inputs
inputs:
  - id: name
    type: STRING
    defaults: world
  - id: count
    type: INT
`, id, namespace)
}

func TestReusableInputsAPI_All(t *testing.T) {
	t.Run("createOrUpdateReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()

		created, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
		require.NoError(t, err)
		require.Equal(t, id, created.GetId())
		require.Equal(t, namespace, created.GetNamespace())
		require.Equal(t, "shared inputs", created.GetDescription())
		require.Len(t, created.GetInputs(), 2)
		require.Equal(t, "name", created.GetInputs()[0].GetId())
	})

	t.Run("createOrUpdateReusableInputsTest_failIfExists", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		source := reusableInputsSource(namespace, id)

		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, source, nil)
		require.NoError(t, err)

		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, source, kestra_api_client.PtrBool(true))
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "failIfExists should reject an existing block")
		require.Equal(t, 409, apiErr.StatusCode)
	})

	t.Run("reusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
		require.NoError(t, err)

		found, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.Equal(t, id, found.GetId())
		require.Len(t, found.GetInputs(), 2)
	})

	// Listing and getting resolve namespace inheritance: a block defined in a
	// parent namespace is visible from its children.
	t.Run("reusableInputsTest_namespaceInheritance", func(t *testing.T) {
		ctx := context.Background()
		parent := randomId()
		child := parent + ".child"
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, parent, id, MAIN_TENANT, reusableInputsSource(parent, id), nil)
		require.NoError(t, err)

		inherited, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, child, id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.Equal(t, parent, inherited.GetNamespace())

		listed, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, child, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.Equal(t, int64(1), listed.GetTotal())
		require.Equal(t, id, listed.GetResults()[0].GetId())
	})

	t.Run("listReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		for i := 0; i < 3; i++ {
			id := randomId()
			_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
			require.NoError(t, err)
		}

		all, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.Equal(t, int64(3), all.GetTotal())

		firstPage, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(2))
		require.NoError(t, err)
		require.Equal(t, int64(3), firstPage.GetTotal())
		require.Len(t, firstPage.GetResults(), 2)
	})

	t.Run("listReusableInputsRevisionsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
		require.NoError(t, err)

		updated := fmt.Sprintf(`id: %s
namespace: %s
description: updated inputs
inputs:
  - id: name
    type: STRING
`, id, namespace)
		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, updated, nil)
		require.NoError(t, err)

		revisions, err := KestraTestClient().ReusableInputs().ListReusableInputsRevisions(ctx, namespace, id, MAIN_TENANT)
		require.NoError(t, err)
		require.Len(t, revisions, 2)

		latest, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.Equal(t, "updated inputs", latest.GetDescription())

		first, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, kestra_api_client.PtrInt(1))
		require.NoError(t, err)
		require.Equal(t, "shared inputs", first.GetDescription())
	})

	t.Run("deleteReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().ReusableInputs().DeleteReusableInputs(ctx, namespace, id, MAIN_TENANT))

		_, err = KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr)
		require.Equal(t, 404, apiErr.StatusCode)
	})

	t.Run("listReusableInputsNamespacesTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil)
		require.NoError(t, err)

		namespaces, err := KestraTestClient().ReusableInputs().ListReusableInputsNamespaces(ctx, MAIN_TENANT)
		require.NoError(t, err)
		require.Contains(t, namespaces, namespace)
	})
}
