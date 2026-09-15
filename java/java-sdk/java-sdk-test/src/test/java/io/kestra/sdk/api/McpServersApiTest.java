package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the MCP-server endpoints under {@code /api/v1/{tenant}/mcp-servers/**}.
 * Listing returns a paged envelope; an unknown id is a plain 404, which guards the binding.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class McpServersApiTest {

    static McpServersApi api() {
        return client().mcpServers();
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
}
