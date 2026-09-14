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
		require.NotNil(t, followed)

		unfollowed, err := client.Cases().UnfollowCase(ctx, MAIN_TENANT, c.Id)
		require.NoError(t, err)
		require.NotNil(t, unfollowed)
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
		res, err := client.Cases().CasesByExecutions(ctx, MAIN_TENANT, []string{exec.Id})
		require.NoError(t, err)
		require.NotNil(t, res)
	})
}

func TestCasesAPI_AutoAttach(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()
	namespace := randomId()
	flowId := randomId()
	createSimpleFlow(ctx, flowId, namespace)
	c := newCase(t, ctx, namespace, "auto-attach case")

	enabled, err := client.Cases().EnableCaseAutoAttach(ctx, MAIN_TENANT, c.Id, kestra_api_client.CaseAutoAttachRequest{
		Namespace: namespace,
		FlowId:    flowId,
		States:    []string{"SUCCESS"},
	})
	require.NoError(t, err)
	require.NotEmpty(t, enabled.AutoAttach)

	disabled, err := client.Cases().DisableCaseAutoAttach(ctx, MAIN_TENANT, c.Id)
	require.NoError(t, err)
	require.NotNil(t, disabled)
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
	})
}
