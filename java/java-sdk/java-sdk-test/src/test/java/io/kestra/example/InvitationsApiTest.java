package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.IAMInvitationControllerApiInvitationCreateRequest;
import io.kestra.sdk.model.IAMInvitationControllerApiInvitationDetail;
import io.kestra.sdk.model.PagedResultsIAMInvitationControllerApiInvitationDetail;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvitationsApiTest {
    @Test
    public void searchInvitationsByEmailFilterTest() throws ApiException {
        String email = "test_invitation_filter_" + randomId() + "@kestra.io";

        kestraClient().invitations().createInvitation(
            MAIN_TENANT,
            new IAMInvitationControllerApiInvitationCreateRequest().email(email)
        );

        PagedResultsIAMInvitationControllerApiInvitationDetail page =
            kestraClient().invitations().searchInvitations(
                1, 50,
                List.of(new QueryFilter().field(QueryFilterField.EMAIL).operation(QueryFilterOp.EQUALS).value(email)),
                MAIN_TENANT,
                null
            );

        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(
            page.getResults().stream().anyMatch(i -> email.equals(i.getEmail())),
            "Search should include the invitation created for the filtered email"
        );

        for (IAMInvitationControllerApiInvitationDetail invitation : kestraClient().invitations().listInvitationsByEmail(email, MAIN_TENANT)) {
            kestraClient().invitations().deleteInvitation(invitation.getId(), MAIN_TENANT);
        }
    }
}
