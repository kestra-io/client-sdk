package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.EvaluationType;
import io.kestra.sdk.model.KillSwitch;
import org.junit.jupiter.api.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

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

    static KillSwitch request(String name) {
        return new KillSwitch()
                .name(name)
                .startDate(OffsetDateTime.of(2999, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC))
                .evaluationType(EvaluationType.KILL);
    }

    static void deleteQuietly(String id) {
        try {
            api().deleteKillSwitch(id);
        } catch (ApiException ignored) {
        }
    }

    @Test
    void createSearchDelete_roundTrip() throws ApiException {
        String name = "ks-" + randomId();
        String id = null;

        try {
            KillSwitch created = api().createKillSwitch(request(name));
            assertThat(created.getName()).isEqualTo(name);
            assertThat(created.getEvaluationType()).isEqualTo(EvaluationType.KILL);
            id = created.getId();
            assertThat(id).isNotBlank();

            final String createdId = id;
            List<KillSwitch> all = api().searchKillSwitches();
            assertThat(all).anySatisfy(k -> assertThat(k.getId()).isEqualTo(createdId));

            // update requires the full kill switch with its id unchanged
            KillSwitch updated = api().updateKillSwitch(id, created.description("updated by sdk test"));
            assertThat(updated.getId()).isEqualTo(id);
            assertThat(updated.getDescription()).isEqualTo("updated by sdk test");
        } finally {
            if (id != null) {
                deleteQuietly(id);
            }
        }
    }
}
