package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvitationsApiTest {

    static InvitationsApi api() {
        return client().invitations();
    }

    // Creates an actual invitation (201) — omitting createUserIfNotExist so the
    // server does not short-circuit to a direct access grant (204).
    static void createTestInvitation(String email) throws ApiException {
        IAMInvitationControllerApiInvitationCreateRequest request =
                new IAMInvitationControllerApiInvitationCreateRequest()
                        .email(email);
        api().createInvitation(TENANT, request);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createInvitation_basic() throws ApiException {
        String email = "invite-" + randomId() + "@test.com";
        assertThatCode(() -> createTestInvitation(email)).doesNotThrowAnyException();
    }

    @Test
    void deleteInvitation_basic() throws ApiException {
        String email = "invite-del-" + randomId() + "@test.com";
        createTestInvitation(email);

        List<IAMInvitationControllerApiInvitationDetail> invitations =
                api().listInvitationsByEmail(TENANT, email);
        assertThat(invitations).isNotNull().isNotEmpty();

        String id = invitations.get(0).getId();
        assertThatCode(() -> api().deleteInvitation(id, TENANT))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchInvitations_basic() throws ApiException {
        createTestInvitation("invite-search-" + randomId() + "@test.com");

        PagedResultsIAMInvitationControllerApiInvitationDetail result =
                api().searchInvitations(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull().isNotEmpty();
    }

    @Test
    void searchInvitations_withPagination() throws ApiException {
        PagedResultsIAMInvitationControllerApiInvitationDetail result =
                api().searchInvitations(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchInvitations_withSort() throws ApiException {
        PagedResultsIAMInvitationControllerApiInvitationDetail result =
                api().searchInvitations(TENANT, 1, 10, java.util.List.of("email:asc"), null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }
}
