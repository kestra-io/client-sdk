package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the instance-owner endpoints under {@code /api/v1/instance/**}.
 * <p>
 * Only read-only and safely-reversible endpoints are exercised here. The
 * cluster-wide mutating endpoints — {@code enterMaintenance}/{@code exitMaintenance},
 * versioned-plugin install/uninstall/upload and worker-credential revoke — are
 * intentionally NOT called: they would disrupt the shared CI instance for every
 * other test running against it.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstanceApiTest {

    static InstanceApi api() {
        return client().instance();
    }

    // ========================================================================
    // Worker groups
    // ========================================================================

    @Test
    void listWorkerGroups_returnsAList() throws ApiException {
        InstanceControllerApiWorkerGroupList result = api().listWorkerGroups(null);

        // the list is server-managed and may be empty on a fresh instance, but the
        // envelope itself is always present.
        assertThat(result).isNotNull();
        assertThat(result.getWorkerGroups()).isNotNull();
    }

    // ========================================================================
    // Worker queues
    // ========================================================================

    @Test
    void listWorkerQueues_hasWorkerQueuesKey() throws ApiException {
        Map<String, Object> result = api().listWorkerQueues();

        assertThat(result).containsKey("workerQueues");
    }

    // ========================================================================
    // Versioned plugins
    // ========================================================================

    @Test
    void listVersionedPlugins_isPaged() throws ApiException {
        PagedResultsInstanceControllerApiPluginArtifact result =
                api().listVersionedPlugins(1, MAX_PAGE_SIZE, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void listAvailableVersionedPlugins_notNull() throws ApiException {
        Map<String, Object> result = api().listAvailableVersionedPlugins();

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Services
    // ========================================================================

    @Test
    void getActiveServices_containsWebserver() throws ApiException {
        InstanceControllerApiActiveServiceList result = api().getActiveServices();

        // the very instance answering this request is a running WEBSERVER, so the
        // active-services roll-up always reports at least one.
        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isPositive();
        assertThat(result.getServices()).isNotEmpty();
    }

    @Test
    void searchServices_isPaged() throws ApiException {
        PagedResultsInstanceControllerApiServiceInstance result =
                api().searchServices(1, 100, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
    }

    // ========================================================================
    // Maintenance
    // ========================================================================

    @Test
    void getMaintenanceStatus_reportsState() throws ApiException {
        Map<String, Object> result = api().getMaintenanceStatus();

        // read-only: a healthy CI instance is not in maintenance.
        assertThat(result).isNotNull();
    }

    // ========================================================================
    // MCP servers
    // ========================================================================

    @Test
    void listMcpServers_isPaged() throws ApiException {
        Map<String, Object> result = api().listMcpServers(1, 100, null);

        assertThat(result).containsKey("results");
    }

    // ========================================================================
    // Not-found behaviour (typed error path)
    // ========================================================================

    @Test
    void getWorkerGroup_unknownId_throws() {
        assertThatThrownBy(() -> api().getWorkerGroup("does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isIn(403, 404));
    }
}
