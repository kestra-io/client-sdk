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

        // the test client authenticates as the bootstrap super-admin, so /me carries a
        // real id and the instance-owner flag.
        assertThat(result).containsKey("id");
        assertThat(result).containsEntry("instanceOwner", true);
    }

    @Test
    void listApiTokens_returnsPagedEnvelope() throws ApiException {
        // the CI bootstrap minted the token this very client authenticates with, so the
        // list is never empty.
        Map<String, Object> result = api().listApiTokens();

        assertThat(result).containsKeys("results", "total");
        assertThat(result.get("results")).asInstanceOf(org.assertj.core.api.InstanceOfAssertFactories.LIST).isNotEmpty();
    }

    @Test
    void listInvitations_returnsAList() throws ApiException {
        List<Map<String, Object>> result = api().listInvitations();

        // no invitations are addressed to the super-admin, so this is genuinely an
        // (often empty) list — the point is that it deserializes as one.
        assertThat(result).isNotNull();
    }
}
