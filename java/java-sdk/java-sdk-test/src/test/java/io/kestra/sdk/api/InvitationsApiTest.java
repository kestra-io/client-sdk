package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvitationsApiTest {

    static InvitationsApi api() {
        return client().invitations();
    }

    static IAMInvitationControllerApiInvitationDetail createTestInvitation(String email) throws ApiException {
        IAMInvitationControllerApiInvitationCreateRequest request =
                new IAMInvitationControllerApiInvitationCreateRequest()
                        .email(email)
                        .createUserIfNotExist(true);
        return api().createInvitation(TENANT, request);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createInvitation_basic() throws ApiException {
        String email = "invite-" + randomId() + "@test.com";
        IAMInvitationControllerApiInvitationDetail result = createTestInvitation(email);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
        assertThat(result.getEmail()).isEqualTo(email);
    }

    @Test
    void deleteInvitation_basic() throws ApiException {
        String email = "invite-del-" + randomId() + "@test.com";
        IAMInvitationControllerApiInvitationDetail created = createTestInvitation(email);

        assertThatCode(() -> api().deleteInvitation(created.getId(), TENANT))
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
