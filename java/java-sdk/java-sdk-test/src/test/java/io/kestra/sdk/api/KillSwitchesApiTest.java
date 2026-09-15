package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the kill-switch endpoints under {@code /api/v1/kill-switches/**}. These are
 * instance-owner-only and not tenant-scoped. A kill switch needs a name, a start date and an
 * evaluation type ({@code PASS} or {@code KILL}).
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KillSwitchesApiTest {

    static KillSwitchesApi api() {
        return client().killSwitches();
    }

    static Map<String, Object> request(String name) {
        return Map.of(
                "name", name,
                "startDate", "2999-01-01T00:00:00",
                "evaluationType", "KILL");
    }

    @Test
    void createSearchDelete_roundTrip() throws ApiException {
        String name = "ks-" + randomId();

        Map<String, Object> created = api().createKillSwitch(request(name));
        assertThat(created.get("name")).isEqualTo(name);
        assertThat(created.get("evaluationType")).isEqualTo("KILL");
        String id = (String) created.get("id");
        assertThat(id).isNotBlank();

        try {
            List<Map<String, Object>> all = api().searchKillSwitches();
            assertThat(all).anySatisfy(k -> assertThat(k.get("id")).isEqualTo(id));

            // update requires the full kill switch with its id unchanged
            Map<String, Object> toUpdate = new java.util.HashMap<>(created);
            toUpdate.put("description", "updated by sdk test");
            Map<String, Object> updated = api().updateKillSwitch(id, toUpdate);
            assertThat(updated.get("id")).isEqualTo(id);
            assertThat(updated.get("description")).isEqualTo("updated by sdk test");
        } finally {
            api().deleteKillSwitch(id);
        }
    }
}
