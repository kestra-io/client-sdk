package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestPluginsAPI_All(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	// firstClassWithIcon derives a real plugin class name that ships an icon
	// (hash != nil) from the icons index, so downstream per-class tests exercise
	// a class that actually exists in the running instance's registry.
	firstClassWithIcon := func(t *testing.T) string {
		icons, err := client.Plugins().Icons(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, icons, "the icons index must not be empty")
		for cls, meta := range icons {
			if m, ok := meta.(map[string]interface{}); ok && m["hash"] != nil {
				return cls
			}
		}
		t.Skip("no plugin class with a bundled icon is registered")
		return ""
	}

	t.Run("List", func(t *testing.T) {
		res, err := client.Plugins().List(ctx, nil, nil, nil)
		require.NoError(t, err)
		results, ok := res["results"].([]interface{})
		require.True(t, ok, "the plugins list is a paged result with a results array: %+v", res)
		require.NotEmpty(t, results, "a running instance registers at least the core plugins")
		hasGroup := false
		for _, raw := range results {
			if p, ok := raw.(map[string]interface{}); ok {
				if g, _ := p["group"].(string); g != "" {
					hasGroup = true
					break
				}
			}
		}
		require.True(t, hasGroup, "at least one plugin description reports its group: %+v", results)
	})

	t.Run("ListBySubgroups", func(t *testing.T) {
		plugins, err := client.Plugins().ListBySubgroups(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, plugins, "the subgroup-expanded listing is non-empty")
		require.NotEmpty(t, plugins[0]["group"], "each subgroup entry reports its group")
	})

	t.Run("Icons", func(t *testing.T) {
		icons, err := client.Plugins().Icons(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, icons, "the icons metadata index is non-empty")
	})

	t.Run("GroupIcons", func(t *testing.T) {
		icons, err := client.Plugins().GroupIcons(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, icons, "the group icons metadata index is non-empty")
	})

	t.Run("Icon", func(t *testing.T) {
		cls := firstClassWithIcon(t)
		res, err := client.Plugins().Icon(ctx, cls)
		require.NoError(t, err)
		require.Contains(t, res, "icon", "the single-icon response wraps an icon field")
		require.NotNil(t, res["icon"], "a class selected for having an icon returns a non-null icon")
	})

	t.Run("IconSvg", func(t *testing.T) {
		cls := firstClassWithIcon(t)
		svg, err := client.Plugins().IconSvg(ctx, cls)
		require.NoError(t, err)
		require.Contains(t, svg, "<svg", "the raw icon resource is an SVG document")
	})

	t.Run("InputTypes", func(t *testing.T) {
		types, err := client.Plugins().InputTypes(ctx)
		require.NoError(t, err)
		require.NotEmpty(t, types, "at least the built-in input types are listed")
		require.NotEmpty(t, types[0]["type"], "each input type reports its type name")

		t.Run("InputSchema", func(t *testing.T) {
			inputType, _ := types[0]["type"].(string)
			require.NotEmpty(t, inputType)
			res, err := client.Plugins().InputSchema(ctx, inputType)
			require.NoError(t, err)
			require.Contains(t, res, "schema", "the input documentation carries a schema")
		})
	})

	t.Run("Properties", func(t *testing.T) {
		res, err := client.Plugins().Properties(ctx, "FLOW")
		require.NoError(t, err)
		require.NotEmpty(t, res, "the FLOW properties schema is non-empty")
	})

	t.Run("Schema", func(t *testing.T) {
		res, err := client.Plugins().Schema(ctx, "FLOW", nil, nil)
		require.NoError(t, err)
		require.NotEmpty(t, res, "the FLOW JSON schema is non-empty")
	})

	t.Run("Triggers", func(t *testing.T) {
		res, err := client.Plugins().Triggers(ctx)
		require.NoError(t, err)
		results, ok := res["results"].([]interface{})
		require.True(t, ok, "the trigger catalog is a paged result with a results array: %+v", res)
		require.NotEmpty(t, results, "the trigger catalog lists at least the core triggers")
		hasType := false
		for _, raw := range results {
			if tr, ok := raw.(map[string]interface{}); ok {
				if ty, _ := tr["type"].(string); ty != "" {
					hasType = true
					break
				}
			}
		}
		require.True(t, hasType, "at least one trigger entry reports its type: %+v", results)
	})

	t.Run("Documentation", func(t *testing.T) {
		// io.kestra.plugin.core.log.Log is bundled with Kestra core and always registered.
		res, err := client.Plugins().Documentation(ctx, "io.kestra.plugin.core.log.Log", nil)
		require.NoError(t, err)
		require.Contains(t, res, "schema", "the plugin documentation carries a schema")

		t.Run("Versions", func(t *testing.T) {
			res, err := client.Plugins().Versions(ctx, "io.kestra.plugin.core.log.Log")
			require.NoError(t, err)
			require.Equal(t, "io.kestra.plugin.core.log.Log", res["type"], "the versions response echoes the requested type")
			versions, ok := res["versions"].([]interface{})
			require.True(t, ok, "the versions response lists versions")
			require.NotEmpty(t, versions, "a registered core plugin reports at least one version")

			t.Run("DocumentationForVersion", func(t *testing.T) {
				version, _ := versions[0].(string)
				require.NotEmpty(t, version)
				res, err := client.Plugins().DocumentationForVersion(ctx, "io.kestra.plugin.core.log.Log", version, nil)
				require.NoError(t, err)
				require.Contains(t, res, "schema", "the versioned documentation carries a schema")
			})
		})
	})

	t.Run("PluginUiManifest", func(t *testing.T) {
		// No task is required to resolve a (possibly empty) manifest; an empty
		// request yields an empty manifest object rather than an error.
		res, err := client.Plugins().PluginUiManifest(ctx, []map[string]interface{}{})
		require.NoError(t, err)
		require.NotNil(t, res, "the manifest response is a (possibly empty) object")
	})

	t.Run("InstallJob", func(t *testing.T) {
		t.Skip("plugin auto-install is OSS-only and forbidden on EE; no install job id can be created here")
	})

	t.Run("DetectMissingPlugins", func(t *testing.T) {
		t.Skip("plugin auto-install detect is OSS-only and returns 403 on EE")
	})

	t.Run("Install", func(t *testing.T) {
		t.Skip("plugin auto-install is OSS-only and returns 403 on EE; installing arbitrary artifacts is not exercised")
	})

	t.Run("PluginUi", func(t *testing.T) {
		// The plugin UI resource path depends on a plugin actually shipping a
		// bundled plugin-ui asset; core plugins ship none, so there is no stable
		// (group, path) pair to fetch on a vanilla instance.
		t.Skip("no core plugin ships a bundled plugin-ui resource to fetch by a stable path")
	})
}
