package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssetsApiTest {

    static AssetsApi api() {
        return client().assets();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchAssets_basic() throws ApiException {
        PagedResultsAssetsControllerApiAsset result = api().searchAssets(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchAssets_withPagination() throws ApiException {
        PagedResultsAssetsControllerApiAsset result = api().searchAssets(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    @Disabled("lineage-events routes were removed in Kestra develop (kestra-ee 091e7d441); the deprecated method only works against 2.0.x")
    void searchAssetLineageEvents_basic() throws ApiException {
        PagedResultsAssetsControllerApiAssetLineageEvent result =
                api().searchAssetLineageEvents(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchAssetUsages_basic() throws ApiException {
        PagedResultsAssetsControllerApiAssetUsage result =
                api().searchAssetUsages(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchAssets_withTypeFilter() throws ApiException {
        String id = randomId();
        api().createAsset(TENANT, assetYaml(id));

        PagedResultsAssetsControllerApiAsset result =
                api().searchAssets(TENANT, 1, 10, null, List.of(typeFilter("TABLE")));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
    }

    @Test
    void searchAssets_withSort() throws ApiException {
        String id1 = "aaa" + randomId();
        String id2 = "zzz" + randomId();
        api().createAsset(TENANT, assetYaml(id2));
        api().createAsset(TENANT, assetYaml(id1));

        PagedResultsAssetsControllerApiAsset result =
                api().searchAssets(TENANT, 1, 100, List.of("id:asc"), List.of(typeFilter("TABLE")));

        assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
        List<String> ids = result.getResults().stream()
                .map(AssetsControllerApiAsset::getId)
                .toList();
        assertThat(ids).contains(id1, id2);
        assertThat(ids.indexOf(id1)).isLessThan(ids.indexOf(id2));
    }

    @Test
    @Disabled("lineage-events routes were removed in Kestra develop (kestra-ee 091e7d441); the deprecated method only works against 2.0.x")
    void searchAssetLineageEvents_withFilters() throws ApiException {
        PagedResultsAssetsControllerApiAssetLineageEvent result =
                api().searchAssetLineageEvents(TENANT, 1, 10, null, List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    @Test
    void searchAssetUsages_withFilters() throws ApiException {
        PagedResultsAssetsControllerApiAssetUsage result =
                api().searchAssetUsages(TENANT, 1, 10, null, List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    @Test
    void searchAssets_noResults() throws ApiException {
        PagedResultsAssetsControllerApiAsset result =
                api().searchAssets(TENANT, 1, 10, null, List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    static String assetYaml(String id) {
        return """
                id: %s
                name: Test Asset %s
                type: TABLE
                """.formatted(id, id);
    }

    @Test
    void createAsset_basic() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset result = api().createAsset(TENANT, assetYaml(id));

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void asset_getById() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        AssetsControllerApiAsset result = api().asset(created.getId(), TENANT, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void updateAsset_existing() throws ApiException {
        String id = randomId();
        api().createAsset(TENANT, """
                id: %s
                type: TABLE
                description: kept
                metadata:
                  a: 1
                """.formatted(id));

        AssetsControllerApiAsset result = api().updateAsset(id, TENANT, """
                id: %s
                type: TABLE
                displayName: Updated %s
                metadata:
                  b: 2
                """.formatted(id, id));

        String displayName = "Updated %s".formatted(id);
        for (AssetsControllerApiAsset asset : List.of(result, api().asset(id, TENANT, null))) {
            assertThat(asset.getId()).isEqualTo(id);
            assertThat(asset.getDisplayName()).isEqualTo(displayName);
            assertThat(asset.getDescription()).isEqualTo("kept");
            assertThat(asset.getMetadata()).containsExactlyInAnyOrderEntriesOf(Map.of("a", 1, "b", 2));
        }
    }

    @Test
    void updateAsset_missingIsNotFound() {
        String id = randomId();

        assertThatThrownBy(() -> api().updateAsset(id, TENANT, assetYaml(id)))
                .isInstanceOfSatisfying(ApiException.class, e -> assertThat(e.getCode()).isEqualTo(404));
    }

    @Test
    void deleteAsset_basic() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        assertThatCode(() -> api().deleteAsset(created.getId(), TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Lock
    // ========================================================================

    @Test
    void lockAsset_manual() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        AssetsControllerApiAssetLock lock = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H"));

        assertThat(lock).isNotNull();
        assertThat(lock.getOwnerType()).isEqualTo("USER");
        assertThat(lock.getLockedUntil()).isNotNull();

        api().unlockAsset(created.getId(), TENANT, null);
    }

    @Test
    void lockAsset_heldByAnotherOwnerIsRejected() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));
        FlowWithSource flow = createLogFlow();
        ExecutionControllerExecutionResponse execution = client().executions()
                .createExecution(TENANT, flow.getNamespace(), flow.getId(), null, null, null, null, null, null);
        AssetsControllerApiAssetLock lock = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H").executionId(execution.getId()));
        assertThat(lock.getOwnerType()).isEqualTo("EXECUTION");

        // held by an EXECUTION owner: a manual USER lock attempt is a different owner and must be rejected
        assertThatThrownBy(() -> api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H")))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void lockAsset_sameOwnerReacquireExtends() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));
        AssetsControllerApiAssetLock first = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1M"));

        AssetsControllerApiAssetLock second = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H"));

        assertThat(second.getOwnerType()).isEqualTo("USER");
        assertThat(second.getLockedUntil()).isAfter(first.getLockedUntil());

        api().unlockAsset(created.getId(), TENANT, null);
    }

    @Test
    void unlockAsset_thenRelock() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));
        api().lockAsset(created.getId(), TENANT, new AssetsControllerAssetLockRequest().ttl("PT1H"));

        assertThatCode(() -> api().unlockAsset(created.getId(), TENANT, null))
                .doesNotThrowAnyException();

        AssetsControllerApiAssetLock relock = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H"));
        assertThat(relock).isNotNull();

        api().unlockAsset(created.getId(), TENANT, null);
    }

    @Test
    void unlockAsset_executionOwnedLock_releasedByMatchingExecutionId() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));
        FlowWithSource flow = createLogFlow();
        ExecutionControllerExecutionResponse execution = client().executions()
                .createExecution(TENANT, flow.getNamespace(), flow.getId(), null, null, null, null, null, null);

        AssetsControllerApiAssetLock lock = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest()
                        .ttl("PT1H")
                        .executionId(execution.getId())
                        .flowId(flow.getId())
                        .flowNamespace(flow.getNamespace())
                        .taskRunId(randomId()));
        assertThat(lock.getOwnerType()).isEqualTo("EXECUTION");

        // matching executionId is the owner-checked release path: the execution releases its own lock
        assertThatCode(() -> api().unlockAsset(created.getId(), TENANT, execution.getId()))
                .doesNotThrowAnyException();

        AssetsControllerApiAssetLock relock = api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H"));
        assertThat(relock.getOwnerType()).isEqualTo("USER");

        api().unlockAsset(created.getId(), TENANT, null);
    }

    @Test
    void unlockAsset_executionOwnedLock_mismatchedExecutionIdIsNoop() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));
        FlowWithSource flow = createLogFlow();
        ExecutionControllerExecutionResponse owner = client().executions()
                .createExecution(TENANT, flow.getNamespace(), flow.getId(), null, null, null, null, null, null);
        ExecutionControllerExecutionResponse other = client().executions()
                .createExecution(TENANT, flow.getNamespace(), flow.getId(), null, null, null, null, null, null);

        api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H").executionId(owner.getId()));

        // a different execution's unlock is owner-checked against the lock holder: no-op, does not throw
        assertThatCode(() -> api().unlockAsset(created.getId(), TENANT, other.getId()))
                .doesNotThrowAnyException();

        // lock is still held by the original owner: a manual USER lock attempt is rejected
        assertThatThrownBy(() -> api().lockAsset(created.getId(), TENANT,
                new AssetsControllerAssetLockRequest().ttl("PT1H")))
                .isInstanceOf(ApiException.class);

        api().unlockAsset(created.getId(), TENANT, owner.getId());
    }

    // ========================================================================
    // Dependencies
    // ========================================================================

    @Test
    void assetDependencies_basic() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        AssetTopologyGraph result = api().assetDependencies(created.getId(), TENANT, null, null);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Bulk delete
    // ========================================================================

    @Test
    void deleteAssetsByIds_basic() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        BulkResponse result = api().deleteAssetsByIds(TENANT, List.of(created.getId()));

        assertThat(result).isNotNull();
    }

    @Test
    void deleteAssetsByQuery_basic() throws ApiException {
        QueryFilter filter = nsFilter("nonexistent");

        BulkResponse result = api().deleteAssetsByQuery(TENANT, List.of(filter), null);

        assertThat(result).isNotNull();
    }

    @Test
    @Disabled("lineage-events routes were removed in Kestra develop (kestra-ee 091e7d441); the deprecated method only works against 2.0.x")
    void deleteAssetLineageEventsByQuery_basic() throws ApiException {
        QueryFilter filter = nsFilter("nonexistent");

        BulkResponse result = api().deleteAssetLineageEventsByQuery(TENANT, List.of(filter));

        assertThat(result).isNotNull();
    }

    @Test
    void deleteAssetUsagesByQuery_basic() throws ApiException {
        QueryFilter filter = nsFilter("nonexistent");

        BulkResponse result = api().deleteAssetUsagesByQuery(TENANT, List.of(filter));

        assertThat(result).isNotNull();
    }
}
