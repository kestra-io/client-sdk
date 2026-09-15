package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the MCP-server endpoints under {@code /api/v1/{tenant}/mcp-servers/**}. A
 * minimal server needs only an id (a lowercase {@code [a-z0-9][a-z0-9_-]*} label); leaving
 * {@code authType} unset keeps the body valid without OAuth/API-token configuration.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class McpServersApiTest {

    static McpServersApi api() {
        return client().mcpServers();
    }

    static String mcpId() {
        return "mcp" + randomId();
    }

    @Test
    void listMcpServers_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().listMcpServers(TENANT, 1, 10, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getMcpServer_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getMcpServer(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    @Test
    void mcpServer_createGetToolsUpdateToggleDelete() throws ApiException {
        String id = mcpId();

        Map<String, Object> created = api().createMcpServer(TENANT, Map.of("id", id, "description", "sdk test"));
        assertThat(created.get("id")).isEqualTo(id);
        assertThat(created.get("description")).isEqualTo("sdk test");

        try {
            Map<String, Object> got = api().getMcpServer(TENANT, id);
            assertThat(got.get("id")).isEqualTo(id);

            // A brand-new server has no flows binding an McpToolTrigger to it, so no tools yet.
            List<Map<String, Object>> tools = api().listMcpServerTools(TENANT, id);
            assertThat(tools).isNotNull().isEmpty();

            Map<String, Object> updated = api().updateMcpServer(TENANT, id, Map.of("id", id, "description", "sdk test v2"));
            assertThat(updated.get("description")).isEqualTo("sdk test v2");

            Map<String, Object> toggled = api().toggleMcpServer(TENANT, id);
            assertThat(toggled.get("disabled")).isEqualTo(true);
        } finally {
            api().deleteMcpServer(TENANT, id);
        }

        assertThatThrownBy(() -> api().getMcpServer(TENANT, id))
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
