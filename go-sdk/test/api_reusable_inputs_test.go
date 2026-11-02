package test

import (
	"context"
	"fmt"
	"strings"
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

func inProgressSource(namespace, id string) string {
	return strings.Replace(reusableInputsSource(namespace, id), "description: shared inputs", "description: in progress", 1)
}

func TestReusableInputsAPI_All(t *testing.T) {
	t.Run("createOrUpdateReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()

		source := reusableInputsSource(namespace, id)
		created, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, source, nil, nil)
		require.NoError(t, err)
		require.Equal(t, id, created.GetId())
		require.Equal(t, namespace, created.GetNamespace())
		require.Equal(t, "shared inputs", created.GetDescription())
		require.Len(t, created.GetInputs(), 2)
		require.Equal(t, "name", created.GetInputs()[0].GetId())
		require.Equal(t, source, created.GetSource(), "the stored source must round-trip verbatim")
		require.Equal(t, int32(1), created.GetRevision())
		require.Equal(t, kestra_api_client.PtrBool(true), created.Last)
		require.Equal(t, kestra_api_client.PtrBool(false), created.Deleted)
		require.False(t, created.GetCreated().IsZero())
	})

	t.Run("createOrUpdateReusableInputsTest_failIfExists", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		source := reusableInputsSource(namespace, id)

		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, source, nil, nil)
		require.NoError(t, err)

		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, source, kestra_api_client.PtrBool(true), nil)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "failIfExists should reject an existing block")
		require.Equal(t, 409, apiErr.StatusCode)
	})

	t.Run("reusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)

		found, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, nil)
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
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, parent, id, MAIN_TENANT, reusableInputsSource(parent, id), nil, nil)
		require.NoError(t, err)

		inherited, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, child, id, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.Equal(t, parent, inherited.GetNamespace())

		listed, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, child, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Equal(t, int64(1), listed.GetTotal())
		require.Equal(t, id, listed.GetResults()[0].GetId())
	})

	t.Run("listReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		for i := 0; i < 3; i++ {
			id := randomId()
			_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
			require.NoError(t, err)
		}

		all, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Equal(t, int64(3), all.GetTotal())

		firstPage, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(2), nil)
		require.NoError(t, err)
		require.Equal(t, int64(3), firstPage.GetTotal())
		require.Len(t, firstPage.GetResults(), 2)
	})

	t.Run("listReusableInputsRevisionsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)

		updated := fmt.Sprintf(`id: %s
namespace: %s
description: updated inputs
inputs:
  - id: name
    type: STRING
`, id, namespace)
		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, updated, nil, nil)
		require.NoError(t, err)

		revisions, err := KestraTestClient().ReusableInputs().ListReusableInputsRevisions(ctx, namespace, id, MAIN_TENANT)
		require.NoError(t, err)
		require.Len(t, revisions, 2)
		require.Equal(t, int32(1), revisions[0].GetRevision(), "revisions come back oldest first")
		require.Equal(t, int32(2), revisions[1].GetRevision())

		latest, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.Equal(t, "updated inputs", latest.GetDescription())
		require.Equal(t, int32(2), latest.GetRevision())
		require.Equal(t, updated, latest.GetSource())
		require.Equal(t, kestra_api_client.PtrBool(true), latest.Last)

		first, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, kestra_api_client.PtrInt(1), nil)
		require.NoError(t, err)
		require.Equal(t, "shared inputs", first.GetDescription())
		require.Equal(t, int32(1), first.GetRevision())
		require.Equal(t, kestra_api_client.PtrBool(false), first.Last, "a pinned older revision is no longer the current one")
	})

	t.Run("deleteReusableInputsTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)

		require.NoError(t, KestraTestClient().ReusableInputs().DeleteReusableInputs(ctx, namespace, id, MAIN_TENANT))

		_, err = KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, nil)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr)
		require.Equal(t, 404, apiErr.StatusCode)
	})

	t.Run("createOrUpdateReusableInputsTest_draft", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		published, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)

		draft, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, inProgressSource(namespace, id), nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)

		require.Equal(t, kestra_api_client.PtrBool(false), published.Draft)
		require.NotEmpty(t, published.GetUpdatedBy())
		require.Equal(t, kestra_api_client.PtrBool(true), draft.Draft)
		require.Equal(t, int32(2), draft.GetRevision())
		require.Equal(t, published.GetUpdatedBy(), draft.GetUpdatedBy())
	})

	t.Run("reusableInputsTest_skipsDraftsUnlessAllowed", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)
		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, inProgressSource(namespace, id), nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)

		forExecution, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.Equal(t, int32(1), forExecution.GetRevision())
		require.False(t, forExecution.GetDraft())

		latest, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)
		require.Equal(t, int32(2), latest.GetRevision())
		require.True(t, latest.GetDraft())
		require.Equal(t, "in progress", latest.GetDescription())
	})

	t.Run("reusableInputsTest_draftsOnly", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)

		_, err = KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, nil)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr)
		require.Equal(t, 422, apiErr.StatusCode)

		latest, err := KestraTestClient().ReusableInputs().ReusableInputs(ctx, namespace, id, MAIN_TENANT, nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)
		require.True(t, latest.GetDraft())
	})

	t.Run("listReusableInputsTest_excludesDraftsOnlyUnlessAllowed", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		published := randomId()
		draftsOnly := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, published, MAIN_TENANT, reusableInputsSource(namespace, published), nil, nil)
		require.NoError(t, err)
		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, published, MAIN_TENANT, inProgressSource(namespace, published), nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)
		_, err = KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, draftsOnly, MAIN_TENANT, reusableInputsSource(namespace, draftsOnly), nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)

		forExecution, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Len(t, forExecution.GetResults(), 1)
		require.Equal(t, published, forExecution.GetResults()[0].GetId())
		require.Equal(t, int32(1), forExecution.GetResults()[0].GetRevision())

		withDrafts, err := KestraTestClient().ReusableInputs().ListReusableInputs(ctx, namespace, MAIN_TENANT, nil, nil, kestra_api_client.PtrBool(true))
		require.NoError(t, err)
		drafts := map[string]bool{}
		for _, block := range withDrafts.GetResults() {
			drafts[block.GetId()] = block.GetDraft()
		}
		require.Equal(t, map[string]bool{published: true, draftsOnly: true}, drafts)
	})

	t.Run("listReusableInputsNamespacesTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		id := randomId()
		_, err := KestraTestClient().ReusableInputs().CreateOrUpdateReusableInputs(ctx, namespace, id, MAIN_TENANT, reusableInputsSource(namespace, id), nil, nil)
		require.NoError(t, err)

		namespaces, err := KestraTestClient().ReusableInputs().ListReusableInputsNamespaces(ctx, MAIN_TENANT)
		require.NoError(t, err)
		require.Contains(t, namespaces, namespace)
	})
}
