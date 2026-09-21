package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// newCase creates a simple OPEN case in the given namespace and returns it.
func newCase(t *testing.T, ctx context.Context, namespace, title string) *kestra_api_client.Case {
	t.Helper()
	c, err := KestraTestClient().Cases().CreateCase(ctx, MAIN_TENANT, kestra_api_client.CaseCreateRequest{
		Namespace:   namespace,
		Title:       title,
		Description: "created by go sdk test",
		Severity:    "MEDIUM",
	})
	require.NoError(t, err)
	require.NotNil(t, c)
	require.NotEmpty(t, c.Id)
	// Clean up so repeated runs against a shared CI tenant don't accumulate
	// orphaned cases that inflate search/counts result sets. Ignore the error:
	// a test that deletes the case itself would otherwise fail cleanup here.
	t.Cleanup(func() { _ = KestraTestClient().Cases().DeleteCase(ctx, MAIN_TENANT, c.Id) })
	return c
}

func TestCasesAPI_All(t *testing.T) {
	t.Run("createCaseFromTaskTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, namespace)

		res, err := KestraTestClient().Cases().CreateCaseFromTask(ctx, MAIN_TENANT, map[string]interface{}{
			"namespace":     namespace,
			"flowNamespace": namespace,
			"flowId":        flowId,
			"taskId":        "hello",
			"title":         "case from " + flowId,
		})
		require.NoError(t, err)
		require.NotNil(t, res)
	})
}

func TestCasesAPI_CRUDAndSearch(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()

	created := newCase(t, ctx, namespace, "crud case")
	require.Equal(t, namespace, created.Namespace)
	require.Equal(t, "crud case", created.Title)
	require.Equal(t, "MEDIUM", created.Severity)
	require.Equal(t, "OPEN", created.Status)
	id := created.Id

	t.Run("get", func(t *testing.T) {
		got, err := client.Cases().GetCase(ctx, MAIN_TENANT, id, nil)
		require.NoError(t, err)
		require.Equal(t, id, got.Id)
		require.Equal(t, "crud case", got.Title)
	})

	t.Run("update", func(t *testing.T) {
		updated, err := client.Cases().UpdateCase(ctx, MAIN_TENANT, id, kestra_api_client.CaseUpdateRequest{
			Namespace:   namespace,
			Title:       "crud case renamed",
			Severity:    "HIGH",
			Description: "updated by go sdk test",
		})
		require.NoError(t, err)
		require.Equal(t, "crud case renamed", updated.Title)
		require.Equal(t, "HIGH", updated.Severity)
	})

	t.Run("search", func(t *testing.T) {
		page, err := client.Cases().SearchCases(ctx, MAIN_TENANT, intPtr(1), intPtr(200), nil, nil, nil)
		require.NoError(t, err)
		require.GreaterOrEqual(t, page.Total, int64(1))
		found := false
		for _, c := range page.Results {
			if c.Id == id {
				found = true
			}
		}
		require.True(t, found, "created case should appear in search results")
	})

	t.Run("counts", func(t *testing.T) {
		counts, err := client.Cases().CaseCounts(ctx, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, counts)
		require.GreaterOrEqual(t, counts["OPEN"], int64(1))
	})

	t.Run("assignees", func(t *testing.T) {
		res, err := client.Cases().CaseAssignees(ctx, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, res)
		// Total is authoritative even when no cases have assignees yet.
		require.GreaterOrEqual(t, res.Total, int64(0))
		require.Len(t, res.Results, int(res.Total))
	})

	t.Run("delete", func(t *testing.T) {
		require.NoError(t, client.Cases().DeleteCase(ctx, MAIN_TENANT, id))
	})
}

func TestCasesAPI_Lifecycle(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()

	t.Run("acknowledgeAndResolve", func(t *testing.T) {
		c := newCase(t, ctx, namespace, "to resolve")
		acked, err := client.Cases().AcknowledgeCase(ctx, MAIN_TENANT, c.Id)
		require.NoError(t, err)
		require.Equal(t, "ACKNOWLEDGED", acked.Status)
		require.NotNil(t, acked.AcknowledgedAt)

		resolved, err := client.Cases().ResolveCase(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseResolveRequest{
			Reason: "fixed",
			Note:   "resolved by go sdk test",
		})
		require.NoError(t, err)
		require.Equal(t, "RESOLVED", resolved.Status)
		require.NotNil(t, resolved.ResolvedAt)
	})

	t.Run("cancel", func(t *testing.T) {
		c := newCase(t, ctx, namespace, "to cancel")
		cancelled, err := client.Cases().CancelCase(ctx, MAIN_TENANT, c.Id, &kestra_api_client.CaseCancelRequest{Reason: "not needed"})
		require.NoError(t, err)
		require.Equal(t, "CANCELLED", cancelled.Status)
	})

	t.Run("changeStatus", func(t *testing.T) {
		c := newCase(t, ctx, namespace, "to investigate")
		updated, err := client.Cases().ChangeCaseStatus(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseStatusRequest{
			Status: "INVESTIGATING",
		})
		require.NoError(t, err)
		require.Equal(t, "INVESTIGATING", updated.Status)
	})

	t.Run("followAndUnfollow", func(t *testing.T) {
		c := newCase(t, ctx, namespace, "to follow")
		followed, err := client.Cases().FollowCase(ctx, MAIN_TENANT, c.Id)
		require.NoError(t, err)
		require.Equal(t, c.Id, followed.Id)

		unfollowed, err := client.Cases().UnfollowCase(ctx, MAIN_TENANT, c.Id)
		require.NoError(t, err)
		require.Equal(t, c.Id, unfollowed.Id)
	})

	t.Run("bulkAcknowledgeAndDeleteByIds", func(t *testing.T) {
		c1 := newCase(t, ctx, namespace, "bulk 1")
		c2 := newCase(t, ctx, namespace, "bulk 2")

		ack, err := client.Cases().AcknowledgeCasesByIds(ctx, MAIN_TENANT, []string{c1.Id, c2.Id})
		require.NoError(t, err)
		require.NotNil(t, ack.Count)
		require.Equal(t, int32(2), *ack.Count)

		del, err := client.Cases().DeleteCasesByIds(ctx, MAIN_TENANT, []string{c1.Id, c2.Id})
		require.NoError(t, err)
		require.NotNil(t, del.Count)
		require.Equal(t, int32(2), *del.Count)
	})
}

func TestCasesAPI_CommentsAndEvents(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	c := newCase(t, ctx, namespace, "commented case")

	event, err := client.Cases().AddCaseComment(ctx, MAIN_TENANT, c.Id, "first comment", nil)
	require.NoError(t, err)
	require.NotNil(t, event)
	require.Equal(t, "first comment", event.Body)

	page, err := client.Cases().CaseEvents(ctx, MAIN_TENANT, c.Id, intPtr(1), intPtr(50))
	require.NoError(t, err)
	require.GreaterOrEqual(t, page.Total, int64(1))
}

func TestCasesAPI_Executions(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	flowId := randomId()
	createSimpleFlow(ctx, flowId, namespace)
	exec := createExecution(t, ctx, flowId, namespace)

	t.Run("linkListUnlink", func(t *testing.T) {
		c := newCase(t, ctx, namespace, "with executions")
		linked, err := client.Cases().LinkCaseExecutions(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseLinkExecutionsRequest{
			ExecutionIds: []string{exec.Id},
		})
		require.NoError(t, err)
		require.NotNil(t, linked)

		page, err := client.Cases().CaseExecutions(ctx, MAIN_TENANT, c.Id, intPtr(1), intPtr(50))
		require.NoError(t, err)
		require.GreaterOrEqual(t, page.Total, int64(1))
		found := false
		for _, e := range page.Results {
			if e.ExecutionId == exec.Id {
				found = true
			}
		}
		require.True(t, found, "linked execution should be listed")

		require.NoError(t, client.Cases().UnlinkCaseExecution(ctx, MAIN_TENANT, c.Id, exec.Id))
	})

	t.Run("createFromExecutions", func(t *testing.T) {
		exec2 := createExecution(t, ctx, flowId, namespace)
		created, err := client.Cases().CreateCaseFromExecutions(ctx, MAIN_TENANT, kestra_api_client.CaseFromExecutionsRequest{
			Case: &kestra_api_client.CaseCreateRequest{
				Namespace: namespace,
				Title:     "from executions",
				Severity:  "LOW",
			},
			ExecutionIds: []string{exec2.Id},
		})
		require.NoError(t, err)
		require.Equal(t, "from executions", created.Title)
		require.Equal(t, namespace, created.Namespace)
	})

	t.Run("byExecutions", func(t *testing.T) {
		// Self-contained: link a fresh execution to a case, then assert the
		// reverse lookup maps that execution id to the case. (exec is unlinked
		// by the linkListUnlink subtest, so it can't be relied on here.)
		exec3 := createExecution(t, ctx, flowId, namespace)
		c := newCase(t, ctx, namespace, "reverse-lookup case")
		_, err := client.Cases().LinkCaseExecutions(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseLinkExecutionsRequest{
			ExecutionIds: []string{exec3.Id},
		})
		require.NoError(t, err)

		res, err := client.Cases().CasesByExecutions(ctx, MAIN_TENANT, []string{exec3.Id})
		require.NoError(t, err)
		summaries, ok := res[exec3.Id]
		require.True(t, ok, "execution should map to its linked case")
		found := false
		for _, s := range summaries {
			if s.Id == c.Id {
				found = true
			}
		}
		require.True(t, found, "linked case should appear for the execution")
	})

	t.Run("linkByQuery", func(t *testing.T) {
		exec4 := createExecution(t, ctx, flowId, namespace)
		c := newCase(t, ctx, namespace, "link-by-query case")
		linked, err := client.Cases().LinkCaseExecutionsByQuery(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseLinkExecutionsByQueryRequest{
			Filters: []kestra_api_client.QueryFilter{namespaceBodyFilter(namespace)},
		})
		require.NoError(t, err)
		require.Equal(t, c.Id, linked.Id)

		page, err := client.Cases().CaseExecutions(ctx, MAIN_TENANT, c.Id, intPtr(1), intPtr(50))
		require.NoError(t, err)
		found := false
		for _, e := range page.Results {
			if e.ExecutionId == exec4.Id {
				found = true
			}
		}
		require.True(t, found, "execution matched by query should be linked")
	})

	t.Run("createFromExecutionsByQuery", func(t *testing.T) {
		// A dedicated namespace so the query matches only this subtest's executions.
		ns := randomId()
		fid := randomId()
		createSimpleFlow(ctx, fid, ns)
		createExecution(t, ctx, fid, ns)
		created, err := client.Cases().CreateCaseFromExecutionsByQuery(ctx, MAIN_TENANT, kestra_api_client.CaseFromExecutionsByQueryRequest{
			Case: &kestra_api_client.CaseCreateRequest{
				Namespace: ns,
				Title:     "from executions by query",
				Severity:  "LOW",
			},
			Filters: []kestra_api_client.QueryFilter{namespaceBodyFilter(ns)},
		})
		require.NoError(t, err)
		require.Equal(t, "from executions by query", created.Title)
	})
}

// namespaceBodyFilter builds a body QueryFilter matching a namespace.
func namespaceBodyFilter(namespace string) kestra_api_client.QueryFilter {
	field := kestra_api_client.QUERYFILTERFIELD_NAMESPACE
	op := kestra_api_client.QUERYFILTEROP_EQUALS
	return kestra_api_client.QueryFilter{Field: &field, Operation: &op, Value: namespace}
}

func TestCasesAPI_DeleteByQuery(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	// Isolate to a fresh namespace so the by-query delete only affects this test.
	namespace := randomId()
	newCase(t, ctx, namespace, "delete-by-query 1")
	newCase(t, ctx, namespace, "delete-by-query 2")

	del, err := client.Cases().DeleteCasesByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{
		{Field: kestra_api_client.FilterNamespace, Operation: kestra_api_client.OpEquals, Value: namespace},
	}, nil)
	require.NoError(t, err)
	require.NotNil(t, del.Count)
	require.Equal(t, int32(2), *del.Count)
}

func TestCasesAPI_AutoAttach(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	flowId := randomId()
	createSimpleFlow(ctx, flowId, namespace)
	c := newCase(t, ctx, namespace, "auto-attach case")

	// EnableCaseAutoAttach makes the server generate an internal system flow for
	// the case; on the plugin-less kestra-ee CI images (`develop-no-plugins` /
	// `-slim`) that generator throws
	//   InvalidTypeConstraintViolationException: Invalid type: io.kestra.plugin.kestra.ee.cases.CreateCase
	// because the EE cases plugin it needs isn't installed — a server/image
	// limitation, not an SDK request-shape issue (the body matches the documented
	// AutoAttachRequest schema exactly). Assert on the *specific* known 422 rather
	// than swallowing any error, so an unrelated regression still fails this test.
	// Mirrors the Java SDK's CasesApiTest (commit 216baff0).
	enabled, err := client.Cases().EnableCaseAutoAttach(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseAutoAttachRequest{
		Namespace: namespace,
		FlowId:    flowId,
		States:    []string{"SUCCESS"},
	})
	if err != nil {
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "expected an ApiError")
		require.Equal(t, 422, apiErr.StatusCode)
		require.Contains(t, string(apiErr.Body), "io.kestra.plugin.kestra.ee.cases.CreateCase")
	} else {
		found := false
		for _, a := range enabled.AutoAttach {
			if m, ok := a.(map[string]interface{}); ok && m["flowId"] == flowId {
				found = true
			}
		}
		require.True(t, found, "enabled case should list the auto-attach flow")
	}
}

func TestCasesAPI_DisableAutoAttach(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	c := newCase(t, ctx, namespace, "disable auto-attach case")

	// Disabling when nothing is configured is a no-op that must still return the case.
	disabled, err := client.Cases().DisableCaseAutoAttach(ctx, MAIN_TENANT, c.Id)
	require.NoError(t, err)
	require.Equal(t, c.Id, disabled.Id)
}

func TestCasesAPI_Actions(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	flowId := randomId()
	createSimpleFlow(ctx, flowId, namespace)
	c := newCase(t, ctx, namespace, "actions case")

	attached, err := client.Cases().AttachCaseAction(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseAttachActionRequest{
		Label:     "rerun",
		Namespace: namespace,
		FlowId:    flowId,
	})
	require.NoError(t, err)
	require.Len(t, attached.Actions, 1)
	require.Equal(t, flowId, attached.Actions[0].FlowId)

	updated, err := client.Cases().UpdateCaseAction(ctx, MAIN_TENANT, c.Id, namespace, flowId, kestra_api_client.CaseAttachActionRequest{
		Label:     "rerun-renamed",
		Namespace: namespace,
		FlowId:    flowId,
	})
	require.NoError(t, err)
	require.Len(t, updated.Actions, 1)
	require.Equal(t, "rerun-renamed", updated.Actions[0].Label)

	run, err := client.Cases().RunCaseAction(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseRunActionRequest{
		Namespace: namespace,
		FlowId:    flowId,
	})
	require.NoError(t, err)
	require.NotEmpty(t, run["executionId"])

	detached, err := client.Cases().DetachCaseAction(ctx, MAIN_TENANT, c.Id, namespace, flowId)
	require.NoError(t, err)
	require.Empty(t, detached.Actions)
}

func TestCasesAPI_Assets(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	c := newCase(t, ctx, namespace, "assets case")

	t.Run("listEmpty", func(t *testing.T) {
		page, err := client.Cases().CaseAssets(ctx, MAIN_TENANT, c.Id)
		require.NoError(t, err)
		require.NotNil(t, page)
		require.Equal(t, int64(0), page.Total)
	})

	t.Run("byAssetEmpty", func(t *testing.T) {
		page, err := client.Cases().CasesByAsset(ctx, MAIN_TENANT, randomId())
		require.NoError(t, err)
		require.NotNil(t, page)
		require.Equal(t, int64(0), page.Total)
	})
}
