package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

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

        AssetRelationGraph result = api().assetDependencies(created.getId(), TENANT, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getNodes()).extracting(AssetRelationGraphNode::getId).contains(created.getId());
    }

    @Test
    void assetDependencies_withSeveralKinds() throws ApiException {
        String source = api().createAsset(TENANT, assetYaml(randomId())).getId();
        String target = api().createAsset(TENANT, assetYaml(randomId())).getId();
        createUpstreamRelation(source, target);

        // UPSTREAM_OF second: a server only reading the first kind would miss the target node
        AssetRelationGraph graph = api().assetDependencies(source, TENANT,
                List.of(RelationKind.RELATED, RelationKind.UPSTREAM_OF), null, null);

        assertThat(graph.getNodes()).extracting(AssetRelationGraphNode::getId).contains(source, target);
        assertThat(graph.getEdges()).anySatisfy(edge -> assertThat(edge.getKind()).isEqualTo(RelationKind.UPSTREAM_OF));
    }

    @Test
    void flowAssetDependencies_basic() throws ApiException {
        FlowWithSource flow = createLogFlow();

        AssetRelationGraph graph = api().flowAssetDependencies(flow.getNamespace(), flow.getId(), TENANT,
                List.of(RelationKind.PRODUCES, RelationKind.CONSUMED_BY), null, null);

        assertThat(graph).isNotNull();
        assertThat(graph.getNodes()).isNotNull();
    }

    // ========================================================================
    // Relations
    // ========================================================================

    static AssetsControllerApiRelation createUpstreamRelation(String source, String target) throws ApiException {
        return api().createAssetRelation(source, TENANT, new AssetsControllerApiRelationRequest()
                .kind(RelationKind.UPSTREAM_OF)
                .direction(RelationDirection.OUTBOUND)
                .targetId(target));
    }

    static Optional<AssetsControllerApiRelationGroup> upstreamGroup(String id) throws ApiException {
        return api().assetRelationSummary(id, TENANT, null).getGroups().stream()
                .filter(group -> group.getKind() == RelationKind.UPSTREAM_OF)
                .findFirst();
    }

    @Test
    void createAssetRelation_listedInSummaryAndPage() throws ApiException {
        String source = api().createAsset(TENANT, assetYaml(randomId())).getId();
        String target = api().createAsset(TENANT, assetYaml(randomId())).getId();

        AssetsControllerApiRelation relation = createUpstreamRelation(source, target);

        assertThat(relation.getUid()).isNotBlank();
        assertThat(relation.getKind()).isEqualTo(RelationKind.UPSTREAM_OF);
        assertThat(relation.getOrigin()).isEqualTo(RelationOrigin.MANUAL);
        assertThat(relation.getSource().getId()).isEqualTo(source);
        assertThat(relation.getTarget().getId()).isEqualTo(target);

        AssetsControllerApiRelationGroup group = upstreamGroup(source).orElseThrow();
        assertThat(group.getTotal()).isGreaterThanOrEqualTo(1L);
        assertThat(group.getResults()).extracting(item -> item.getRelation().getUid()).contains(relation.getUid());

        AssetsControllerApiRelationPage page = api().assetRelations(source, TENANT,
                group.getKind(), group.getDirection(), null, 10);
        assertThat(page.getTotal()).isGreaterThanOrEqualTo(1L);
        assertThat(page.getResults()).anySatisfy(item -> {
            assertThat(item.getRelation().getUid()).isEqualTo(relation.getUid());
            assertThat(item.getNode().getId()).isEqualTo(target);
        });
    }

    @Test
    void deleteAssetRelation_removesItFromSummary() throws ApiException {
        String source = api().createAsset(TENANT, assetYaml(randomId())).getId();
        String target = api().createAsset(TENANT, assetYaml(randomId())).getId();
        AssetsControllerApiRelation relation = createUpstreamRelation(source, target);
        long before = upstreamGroup(source).orElseThrow().getTotal();

        api().deleteAssetRelation(source, relation.getUid(), TENANT);

        assertThat(upstreamGroup(source).map(AssetsControllerApiRelationGroup::getTotal).orElse(0L))
                .isLessThan(before);
    }

    @Test
    void setAssetParent_thenClear() throws ApiException {
        String child = api().createAsset(TENANT, assetYaml(randomId())).getId();
        String parent = api().createAsset(TENANT, assetYaml(randomId())).getId();

        AssetsControllerApiAsset updated = api().setAssetParent(child, TENANT, new AssetsControllerApiParentRequest().parentId(parent));
        assertThat(updated.getPartOf()).isNotNull();
        assertThat(updated.getPartOf().getId()).isEqualTo(parent);
        assertThat(api().asset(child, TENANT, null).getPartOf().getId()).isEqualTo(parent);

        AssetsControllerApiAsset cleared = api().clearAssetParent(child, TENANT);
        assertThat(cleared.getPartOf()).isNull();
        assertThat(api().asset(child, TENANT, null).getPartOf()).isNull();
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
    void deleteAssetUsagesByQuery_basic() throws ApiException {
        QueryFilter filter = nsFilter("nonexistent");

        BulkResponse result = api().deleteAssetUsagesByQuery(TENANT, List.of(filter));

        assertThat(result).isNotNull();
    }
}
