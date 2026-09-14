package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the current-user endpoints under {@code /api/v1/me/**}. These are core
 * (any authenticated user), so they return real payloads on the CI instance.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeApiTest {

    static MeApi api() {
        return client().me();
    }

    @Test
    void getCurrentUser_returnsTheAuthenticatedUser() throws ApiException {
        Map<String, Object> result = api().getCurrentUser();

        // the test client authenticates as the bootstrap super-admin, so /me is populated.
        assertThat(result).isNotEmpty();
        assertThat(result).containsKey("id");
    }

    @Test
    void listApiTokens_returnsAList() throws ApiException {
        Map<String, Object> result = api().listApiTokens();

        assertThat(result).isNotNull();
    }

    @Test
    void listInvitations_returnsAList() throws ApiException {
        List<Map<String, Object>> result = api().listInvitations();

        // no invitations are addressed to the super-admin, so this is genuinely an
        // (often empty) list — the point is that it deserializes as one.
        assertThat(result).isNotNull();
    }
}
