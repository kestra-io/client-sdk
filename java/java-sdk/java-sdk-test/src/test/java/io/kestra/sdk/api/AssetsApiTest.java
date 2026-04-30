package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

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
}
