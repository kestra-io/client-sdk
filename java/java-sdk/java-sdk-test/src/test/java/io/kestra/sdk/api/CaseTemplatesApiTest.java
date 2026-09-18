package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the case-template endpoints under {@code /api/v1/{tenant}/case-templates/**}.
 * The CI image licenses the EE Cases feature (see {@link CasesApiTest}), so a template round
 * trip works with the super-admin token.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CaseTemplatesApiTest {

    static CaseTemplatesApi api() {
        return client().caseTemplates();
    }

    @Test
    void createGetUpdateDelete_roundTrip() throws ApiException {
        String name = "template-" + randomId();

        Map<String, Object> created = api().createCaseTemplate(TENANT, Map.of("name", name));
        assertThat(created.get("name")).isEqualTo(name);
        String id = (String) created.get("id");
        assertThat(id).isNotBlank();

        try {
            Map<String, Object> fetched = api().getCaseTemplate(TENANT, id);
            assertThat(fetched.get("id")).isEqualTo(id);
            assertThat(fetched.get("name")).isEqualTo(name);

            String renamed = name + "-v2";
            Map<String, Object> updated = api().updateCaseTemplate(TENANT, id, Map.of("name", renamed));
            assertThat(updated.get("name")).isEqualTo(renamed);
        } finally {
            api().deleteCaseTemplate(TENANT, id);
        }
    }

    @Test
    void search_returnsPagedEnvelope() throws ApiException {
        Map<String, Object> result = api().searchCaseTemplates(TENANT, 1, 10, null, null);

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).isInstanceOf(java.util.List.class);
    }

    @Test
    void getCaseTemplate_unknownId_isNotFound() {
        assertThatThrownBy(() -> api().getCaseTemplate(TENANT, "does-not-exist-" + randomId()))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }
}
