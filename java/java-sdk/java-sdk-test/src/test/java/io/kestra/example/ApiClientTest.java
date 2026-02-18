package io.kestra.example;

import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.internal.Pair;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for ApiClient helpers.
 */
public class ApiClientTest {
    @Test
    void parameterToPairs_shouldExpandMapValue_forAnyQueryFilterField() {
        var client = new ApiClient();

        List<Pair> pairs = client.parameterToPairs(
            "csv",
            "filters",
            List.of(new QueryFilter()
                .field(QueryFilterField.ID)
                .operation(QueryFilterOp.EQUALS)
                .value(Map.of(
                    "a", "b",
                    "c", "d"
                ))
            )
        );

        assertThat(pairs)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactlyInAnyOrder(
                new Pair("filters[id][EQUALS][a]", "b"),
                new Pair("filters[id][EQUALS][c]", "d")
            );
    }

    @Test
    void parameterToPairs_shouldTransformQueryFieldToQ() {
        var client = new ApiClient();

        List<Pair> pairs = client.parameterToPairs(
            "csv",
            "filters",
            List.of(new QueryFilter()
                .field(QueryFilterField.QUERY)
                .operation(QueryFilterOp.EQUALS)
                .value("hello")
            )
        );

        assertThat(pairs)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Pair("filters[q][EQUALS]", "hello"));
    }

    @Test
    void parameterToPairs_shouldCamelCaseFieldWithUnderscore() {
        var client = new ApiClient();

        List<Pair> pairs = client.parameterToPairs(
            "csv",
            "filters",
            List.of(new QueryFilter()
                .field(QueryFilterField.ASSET_ID)
                .operation(QueryFilterOp.EQUALS)
                .value("asset")
            )
        );

        assertThat(pairs)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Pair("filters[assetId][EQUALS]", "asset"));
    }
}
