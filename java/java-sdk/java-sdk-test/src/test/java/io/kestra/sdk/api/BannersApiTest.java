package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.Banner;
import org.junit.jupiter.api.*;

import java.util.List;

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

    static void deleteQuietly(String id) {
        try {
            api().deleteBanner(id);
        } catch (ApiException ignored) {
        }
    }

    @Test
    void createSearchDelete_roundTrip() throws ApiException {
        String message = "banner-" + randomId();
        String id = null;

        try {
            Banner created = api().createBanner(new Banner().message(message));
            assertThat(created.getMessage()).isEqualTo(message);
            assertThat(created.getActive()).isTrue();
            id = created.getId();
            assertThat(id).isNotBlank();

            final String createdId = id;
            List<Banner> all = api().searchBanners(null);
            assertThat(all)
                    .anySatisfy(b -> assertThat(b.getId()).isEqualTo(createdId));

            // update requires the full banner with its id unchanged
            String newMessage = message + "-updated";
            Banner updated = api().updateBanner(id, created.message(newMessage));
            assertThat(updated.getId()).isEqualTo(id);
            assertThat(updated.getMessage()).isEqualTo(newMessage);
        } finally {
            if (id != null) {
                deleteQuietly(id);
            }
        }
    }
}
