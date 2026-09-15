package io.kestra.sdk.internal;

import io.kestra.sdk.api.FlowsApi;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseApiFilterParamsTest {

    private final FlowsApi api = new FlowsApi();

    @Test
    public void nullAndEmptyFiltersProduceNoParams() {
        assertTrue(api.filterParams(null).isEmpty());
        assertTrue(api.filterParams(List.of()).isEmpty());
    }

    @Test
    public void namespaceFilterUsesPhpNestedStyle() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.EQUALS).value("system")
        ));

        assertEquals(1, params.size());
        assertEquals("filters[namespace][EQUALS]", params.get(0).getName());
        assertEquals("system", params.get(0).getValue());
    }

    @Test
    public void screamingCaseFieldsBecomeCamelCase() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.FLOW_ID).operation(QueryFilterOp.CONTAINS).value("order")
        ));

        assertEquals("filters[flowId][CONTAINS]", params.get(0).getName());
    }

    @Test
    public void queryFieldShortensToQ() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.QUERY).operation(QueryFilterOp.EQUALS).value("hello")
        ));

        assertEquals("filters[q][EQUALS]", params.get(0).getName());
    }

    @Test
    public void mapValuesExpandWithNestedKey() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.LABELS).operation(QueryFilterOp.EQUALS).value(Map.of("team", "data"))
        ));

        assertEquals(1, params.size());
        assertEquals("filters[labels][EQUALS][team]", params.get(0).getName());
        assertEquals("data", params.get(0).getValue());
    }

    @Test
    public void listValuesJoinAsCsvForInOperations() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.IN).value(List.of("a", "b"))
        ));

        assertEquals("filters[namespace][IN]", params.get(0).getName());
        // The comma is escaped on the wire; the server URL-decodes before splitting IN values on ",".
        assertEquals("a%2Cb", params.get(0).getValue());
    }

    @Test
    public void valuesAreEscapedOnce() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.EQUALS).value("a b")
        ));

        assertEquals("filters[namespace][EQUALS]", params.get(0).getName());
        // Escaped exactly once at pair creation; invokeAPI does not escape values again.
        assertTrue(params.get(0).getValue().equals("a+b") || params.get(0).getValue().equals("a%20b"));
    }

    @Test
    public void noParamUsesTheDroppedCsvShape() {
        List<Pair> params = api.filterParams(List.of(
            new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.EQUALS).value("system")
        ));

        for (Pair param : params) {
            assertTrue("filter params must use the filters[...] nested shape", param.getName().startsWith("filters["));
        }
    }
}
