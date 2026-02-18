package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static io.kestra.TestUtils.awaitExecution;
import static io.kestra.TestUtils.createFlowWithExecutionFromFlow;
import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssetsApiTest {

    /**
     * Retrieve an asset
     */
    @Test
    public void assetTest() throws ApiException {
        String assetId = randomId();
        String namespace = randomId();
        String assetBody = getSimpleAsset(assetId, namespace);
        var asset = kestraClient().assets().createAsset(MAIN_TENANT, assetBody);

        assertThat(asset.getId()).isEqualTo(assetId);

        var response = kestraClient().assets().asset(assetId, MAIN_TENANT);

        assertThat(response).isNotNull();
        assertThat(response.getNamespace()).isEqualTo(namespace);
    }

    /**
     * Search for assets
     */
    @Test
    public void searchAssetTest() throws ApiException {
        String assetId = randomId();
        String namespace = randomId();
        String assetBody = getSimpleAsset(assetId, namespace);
        var asset = kestraClient().assets().createAsset(MAIN_TENANT, assetBody);

        assertThat(asset.getId()).isEqualTo(assetId);

        String anotherAssetId = randomId();
        String anotherNamespace = randomId();
        String anotherAssetBody = getSimpleAsset(anotherAssetId, anotherNamespace);
        var anotherAsset = kestraClient().assets().createAsset(MAIN_TENANT, anotherAssetBody);

        var response = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ),
            MAIN_TENANT,
            null
        );

        assertThat(response).isNotNull();
        assertThat(response.getTotal()).isEqualTo(1);
        assertThat(response.getResults().getFirst().getId()).isEqualTo(assetId);

        response = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(anotherNamespace)
            ),
            MAIN_TENANT,
            null
        );

        assertThat(response).isNotNull();
        assertThat(response.getTotal()).isEqualTo(1);
        assertThat(response.getResults().getFirst().getId()).isEqualTo(anotherAssetId);
    }

    /**
     * Delete asset by id
     */
    @Test
    public void deleteAssetByIdTest() throws ApiException {
        String assetId = randomId();
        String namespace = randomId();
        String assetBody = getSimpleAsset(assetId, namespace);
        var asset = kestraClient().assets().createAsset(MAIN_TENANT, assetBody);

        assertThat(asset.getId()).isEqualTo(assetId);

        var getAsset = kestraClient().assets().asset(
            assetId,
            MAIN_TENANT
        );
        assertThat(getAsset).isNotNull();

        kestraClient().assets().deleteAsset(assetId, MAIN_TENANT);

        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> kestraClient().assets().asset(
            assetId,
            MAIN_TENANT
        ));
        assertThat(apiException.getCode()).isEqualTo(404);
    }

    /**
     * Delete assets by ids
     */
    @Test
    public void deleteAssetsByIdTest() throws ApiException {
        String assetId = randomId();
        String namespace = randomId();
        String assetBody = getSimpleAsset(assetId, namespace);
        var asset = kestraClient().assets().createAsset(MAIN_TENANT, assetBody);

        String secondAssetId = assetId + "2";
        String secondAssetBody = getSimpleAsset(secondAssetId, namespace);
        var secondAsset = kestraClient().assets().createAsset(MAIN_TENANT, secondAssetBody);

        assertThat(asset.getId()).isEqualTo(assetId);
        assertThat(secondAsset.getId()).isEqualTo(secondAssetId);

        var searchAssets = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ),
            MAIN_TENANT,
            null
        );
        assertThat(searchAssets.getTotal()).isEqualTo(2);

        kestraClient().assets().deleteAssetsByIds(MAIN_TENANT, List.of(assetId, secondAssetId));

        searchAssets = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ),
            MAIN_TENANT,
            null
        );
        assertThat(searchAssets.getTotal()).isEqualTo(0);
    }

    /**
     * Delete assets by query
     */
    @Test
    public void deleteAssetsByQueryTest() throws ApiException {
        String assetId = randomId();
        String namespace = randomId();
        String assetBody = getSimpleAsset(assetId, namespace);
        var asset = kestraClient().assets().createAsset(MAIN_TENANT, assetBody);

        String secondAssetId = assetId + "2";
        String secondAssetBody = getSimpleAsset(secondAssetId, namespace);
        var secondAsset = kestraClient().assets().createAsset(MAIN_TENANT, secondAssetBody);

        assertThat(asset.getId()).isEqualTo(assetId);
        assertThat(secondAsset.getId()).isEqualTo(secondAssetId);

        var searchAssets = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ),
            MAIN_TENANT,
            null
        );
        assertThat(searchAssets.getTotal()).isEqualTo(2);

        kestraClient().assets().deleteAssetsByQuery(List.of(
            new QueryFilter()
                .field(QueryFilterField.NAMESPACE)
                .operation(QueryFilterOp.EQUALS)
                .value(namespace)
        ), MAIN_TENANT);

        searchAssets = kestraClient().assets().searchAssets(
            1,
            10,
            List.of(
                new QueryFilter()
                    .field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ),
            MAIN_TENANT,
            null
        );
        assertThat(searchAssets.getTotal()).isEqualTo(0);
    }

    @Test
    public void dependenciesTest() {
        String id = randomId();
        String namespace = randomId();
        String inputAssetId = randomId();
        String outputAssetId = randomId();
        awaitExecution(StateType.SUCCESS, createFlowWithExecutionFromFlow("""
            id: "%s"
            namespace: "%s"
            tasks:
                - id: hello
                  type: io.kestra.plugin.core.log.Log
                  message: Hello World! 🚀
                  assets:
                    inputs:
                      - id: %s
                    outputs:
                      - id: %s
                        type: TABLE
            """.formatted(id, namespace, inputAssetId, outputAssetId)).getId());

        AtomicReference<AssetTopologyGraph> assetTopologyGraph = new AtomicReference<>();
        Awaitility.await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> {
            assetTopologyGraph.set(kestraClient().assets().assetDependencies(outputAssetId, false, false, MAIN_TENANT));
            assertThat(assetTopologyGraph.get()).isNotNull();
            assertThat(assetTopologyGraph.get().getNodes()).isNotNull();
            assertThat(Objects.requireNonNull(assetTopologyGraph.get().getNodes()).size()).isEqualTo(3);
            assertThat(assetTopologyGraph.get().getEdges()).isNotNull();
            assertThat(Objects.requireNonNull(assetTopologyGraph.get().getEdges()).size()).isEqualTo(2);
        });

        assertThat(assetTopologyGraph.get()).isNotNull();
        assertThat(assetTopologyGraph.get().getNodes()).extracting(AssetTopologyGraphNode::getId).containsExactlyInAnyOrder(inputAssetId, outputAssetId, id);
        Map<String, String> uidByNodeId = Objects.requireNonNull(assetTopologyGraph.get().getNodes()).stream().collect(Collectors.toMap(
            AssetTopologyGraphNode::getId,
            AssetTopologyGraphNode::getUid
        ));
        assertThat(assetTopologyGraph.get().getEdges()).containsExactlyInAnyOrder(
            new AssetTopologyGraphEdge().source(uidByNodeId.get(inputAssetId)).target(uidByNodeId.get(outputAssetId)).relation(Relation1.USED_BY),
            new AssetTopologyGraphEdge().source(uidByNodeId.get(id)).target(uidByNodeId.get(outputAssetId)).relation(Relation1.UPSERT)
        );
    }

    @Test
    public void usagesTest() {
        String id = randomId();
        String namespace = randomId();
        String inputAssetId = randomId();
        String outputAssetId = randomId();
        awaitExecution(StateType.SUCCESS, createFlowWithExecutionFromFlow("""
            id: "%s"
            namespace: "%s"
            tasks:
                - id: hello
                  type: io.kestra.plugin.core.log.Log
                  message: Hello World! 🚀
                  assets:
                    inputs:
                      - id: %s
                    outputs:
                      - id: %s
                        type: TABLE
            """.formatted(id, namespace, inputAssetId, outputAssetId)).getId());

        AtomicReference<PagedResultsAssetsControllerApiAssetUsage> assetUsages = new AtomicReference<>();
        Awaitility.await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> {
            assetUsages.set(kestraClient().assets().searchAssetUsages(1, 10, List.of(
                new QueryFilter().field(QueryFilterField.NAMESPACE)
                    .operation(QueryFilterOp.EQUALS)
                    .value(namespace)
            ), MAIN_TENANT, null));
            assertThat(assetUsages.get()).isNotNull();
            assertThat(assetUsages.get().getTotal()).isEqualTo(2);
        });

        assertThat(assetUsages.get()).isNotNull();
        assertThat(assetUsages.get().getResults()).extracting(AssetsControllerApiAssetUsage::getAssetId).containsExactlyInAnyOrder(inputAssetId, outputAssetId);
    }

    private static String getSimpleAsset(String id, String namespace) {
        return String.format("""
            id: "%s"%s
            type: "TABLE"
            displayName: "Customers by Country"
            description: "A table showing the number of customers by country."
            metadata:
                system: "my-system"
                database: "my-project"
                schema: "analytics"
                name: "customers_by_country"
            """, id, namespace == null ? "" : "\nnamespace: " + namespace);
    }
}
