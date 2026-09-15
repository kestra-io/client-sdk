package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the announcement-banner endpoints under {@code /api/v1/banners/**}. These
 * are instance-owner-only and not tenant-scoped; the CI super-admin token owns the instance.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BannersApiTest {

    static BannersApi api() {
        return client().banners();
    }

    @Test
    void createSearchDelete_roundTrip() throws ApiException {
        String message = "banner-" + randomId();

        Map<String, Object> created = api().createBanner(Map.of("message", message));
        assertThat(created.get("message")).isEqualTo(message);
        assertThat(created.get("active")).isEqualTo(true);
        String id = (String) created.get("id");
        assertThat(id).isNotBlank();

        try {
            List<Map<String, Object>> all = api().searchBanners(null);
            assertThat(all)
                    .anySatisfy(b -> assertThat(b.get("id")).isEqualTo(id));
        } finally {
            api().deleteBanner(id);
        }

        List<Map<String, Object>> afterDelete = api().searchBanners(null);
        assertThat(afterDelete).noneSatisfy(b -> assertThat(b.get("id")).isEqualTo(id));
    }
}
