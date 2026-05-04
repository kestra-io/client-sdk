package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

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
    void deleteAsset_basic() throws ApiException {
        String id = randomId();
        AssetsControllerApiAsset created = api().createAsset(TENANT, assetYaml(id));

        assertThatCode(() -> api().deleteAsset(created.getId(), TENANT))
                .doesNotThrowAnyException();
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
