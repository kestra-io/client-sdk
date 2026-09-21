package io.kestra.sdk.internal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterLogical;
import io.kestra.sdk.model.QueryFilterOp;
import io.kestra.sdk.query.Query;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Offline (no live Kestra) serializer test driving the shared golden vectors at
 * {@code test-utils/query-filter-golden.json}. It asserts the PRE-ESCAPE raw pairs
 * (via the package-private {@link ApiClient#collectFilterPairs(java.util.Collection, boolean)}
 * with {@code escape=false}) because the golden {@code expected} values are un-encoded.
 */
class QueryFilterGoldenTest {

    private final ApiClient apiClient = new ApiClient();
    private final ObjectMapper mapper = new ObjectMapper();

    @TestFactory
    Iterable<DynamicTest> goldenVectors() throws Exception {
        JsonNode root = mapper.readTree(goldenFile());
        JsonNode cases = root.get("cases");

        List<DynamicTest> tests = new ArrayList<>();
        for (JsonNode c : cases) {
            String name = c.get("name").asText();
            JsonNode input = c.get("input");

            List<QueryFilter> filters;
            if (input.has("where")) {
                filters = Query.where(buildNode(input.get("where")));
            } else if (input.has("list")) {
                filters = new ArrayList<>();
                for (JsonNode n : input.get("list")) {
                    filters.add(buildNode(n));
                }
            } else {
                throw new IllegalStateException("case " + name + " has neither 'where' nor 'list'");
            }

            List<String> expected = new ArrayList<>();
            for (JsonNode e : c.get("expected")) {
                expected.add(e.asText());
            }

            tests.add(DynamicTest.dynamicTest(name, () -> {
                List<String> actual = render(apiClient.collectFilterPairs(filters, false));
                assertEquals(expected, actual, "golden case '" + name + "'");
            }));
        }
        return tests;
    }

    /* ------------------------------------------------------------------ */
    /* Per-SDK cases                                                       */
    /* ------------------------------------------------------------------ */

    @Test
    void minLevelFieldMapsToLevel() {
        List<QueryFilter> filters = Query.where(
            Query.eq(QueryFilterField.MIN_LEVEL, "INFO")
        );
        assertEquals(
            List.of("filters[level][EQUALS]=INFO"),
            render(apiClient.collectFilterPairs(filters, false))
        );
    }

    @Test
    void nestedGroupsDeeperThanOneLevelThrow() {
        // AND[ ns, OR[ scope, AND[ flow, ns ] ] ]  -> the inner AND is a group inside a group.
        List<QueryFilter> filters = Query.where(
            Query.and(
                Query.eq(QueryFilterField.NAMESPACE, "ns"),
                Query.or(
                    Query.eq(QueryFilterField.SCOPE, "s1"),
                    Query.and(
                        Query.eq(QueryFilterField.FLOW_ID, "f"),
                        Query.eq(QueryFilterField.NAMESPACE, "ns2")
                    )
                )
            )
        );
        ApiException ex = assertThrows(ApiException.class,
            () -> apiClient.collectFilterPairs(filters, false));
        assertEquals(400, ex.getCode());
        assertTrue(ex.getMessage().contains("nested groups are limited to one level"),
            "message was: " + ex.getMessage());
    }

    @Test
    void nodeThatIsBothLeafAndGroupThrows() {
        QueryFilter ambiguous = new QueryFilter()
            .field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.EQUALS)
            .value("ns")
            .logical(QueryFilterLogical.OR)
            .children(List.of(new QueryFilter().field(QueryFilterField.SCOPE).operation(QueryFilterOp.EQUALS).value("s1")));

        ApiException ex = assertThrows(ApiException.class,
            () -> apiClient.collectFilterPairs(List.of(ambiguous), false));
        assertEquals(400, ex.getCode());
        assertTrue(ex.getMessage().contains("cannot be both a leaf and a group"),
            "message was: " + ex.getMessage());
    }

    /* ------------------------------------------------------------------ */
    /* Helpers                                                            */
    /* ------------------------------------------------------------------ */

    private List<String> render(List<Pair> pairs) {
        return pairs.stream().map(p -> p.getName() + "=" + p.getValue()).collect(Collectors.toList());
    }

    private QueryFilter buildNode(JsonNode node) {
        if (node.has("logical")) {
            List<QueryFilter> children = new ArrayList<>();
            if (node.has("children")) {
                for (JsonNode child : node.get("children")) {
                    children.add(buildNode(child));
                }
            }
            return new QueryFilter()
                .logical(QueryFilterLogical.valueOf(node.get("logical").asText()))
                .children(children);
        }
        return new QueryFilter()
            .field(QueryFilterField.valueOf(node.get("field").asText()))
            .operation(QueryFilterOp.valueOf(node.get("op").asText()))
            .value(parseValue(node.get("value")));
    }

    private Object parseValue(JsonNode value) {
        if (value == null || value.isNull()) {
            return null;
        }
        if (value.isArray()) {
            List<String> list = new ArrayList<>();
            for (JsonNode item : value) {
                list.add(item.asText());
            }
            return list;
        }
        if (value.isObject()) {
            Map<String, String> map = new LinkedHashMap<>();
            Iterator<Map.Entry<String, JsonNode>> it = value.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                map.put(entry.getKey(), entry.getValue().asText());
            }
            return map;
        }
        return value.asText();
    }

    private File goldenFile() {
        File dir = new File(System.getProperty("user.dir")).getAbsoluteFile();
        while (dir != null) {
            File candidate = new File(dir, "test-utils/query-filter-golden.json");
            if (candidate.isFile()) {
                return candidate;
            }
            dir = dir.getParentFile();
        }
        throw new IllegalStateException("could not locate test-utils/query-filter-golden.json from " + System.getProperty("user.dir"));
    }
}
