package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func intPtr(i int) *int { return &i }

func TestCaseTemplatesAPI_All(t *testing.T) {
	client := KestraTestClient()
	ctx := context.Background()

	t.Run("crudAndSearch", func(t *testing.T) {
		namespace := randomId()
		name := "tmpl-" + randomId()

		created, err := client.CaseTemplates().CreateCaseTemplate(ctx, MAIN_TENANT, kestra_api_client.CaseTemplateRequest{
			Name:                  name,
			Namespace:             namespace,
			DefaultSeverity:       "MEDIUM",
			Description:           "created by go sdk test",
			RequireResolutionNote: true,
		})
		require.NoError(t, err)
		require.NotNil(t, created)
		require.NotEmpty(t, created.Id)
		require.Equal(t, name, created.Name)
		require.Equal(t, namespace, created.Namespace)
		require.Equal(t, "MEDIUM", created.DefaultSeverity)
		require.True(t, created.RequireResolutionNote)

		id := created.Id
		defer func() {
			require.NoError(t, client.CaseTemplates().DeleteCaseTemplate(ctx, MAIN_TENANT, id))
		}()

		got, err := client.CaseTemplates().GetCaseTemplate(ctx, MAIN_TENANT, id)
		require.NoError(t, err)
		require.Equal(t, id, got.Id)
		require.Equal(t, name, got.Name)

		updated, err := client.CaseTemplates().UpdateCaseTemplate(ctx, MAIN_TENANT, id, kestra_api_client.CaseTemplateRequest{
			Name:            name,
			Namespace:       namespace,
			DefaultSeverity: "HIGH",
			Description:     "updated by go sdk test",
		})
		require.NoError(t, err)
		require.Equal(t, "HIGH", updated.DefaultSeverity)
		require.Equal(t, "updated by go sdk test", updated.Description)

		page, err := client.CaseTemplates().SearchCaseTemplates(ctx, MAIN_TENANT, intPtr(1), intPtr(100), nil, nil)
		require.NoError(t, err)
		require.GreaterOrEqual(t, page.Total, int64(1))
		found := false
		for _, tmpl := range page.Results {
			if tmpl.Id == id {
				found = true
				require.Equal(t, name, tmpl.Name)
			}
		}
		require.True(t, found, "created case template should appear in search results")
	})
}
