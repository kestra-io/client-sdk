package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.MAIN_TENANT;
import static io.kestra.example.CommonTestSetup.kestraClient;
import static io.kestra.example.CommonTestSetup.randomId;
import static org.junit.jupiter.api.Assertions.*;

public class RolesApiTest {

    @Test
    public void autocompleteRolesTest() throws ApiException {
        // create a role with a unique, searchable prefix
        String prefix = "test_autocomplete_roles_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest roleReq =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(prefix + "_complete_roles")
                .description("An example role")
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, roleReq);

        ApiAutocomplete ac = new ApiAutocomplete().q(prefix);

        List<ApiRoleSummary> results =
            kestraClient().roles().autocompleteRoles(MAIN_TENANT, ac);

        assertTrue(
            results.stream().anyMatch(r ->
                created.getId().equals(r.getId()) ||
                    created.getName().equals(r.getName())),
            "Autocomplete should include the created role"
        );
    }

    @Test
    public void createRoleTest() throws ApiException {
        String name = "test_create_role_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest req =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .description("An example role")
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, req);

        assertEquals(name, created.getName());
        assertNotNull(created.getId());
    }

    @Test
    public void deleteRoleTest() throws ApiException {
        String name = "test_delete_role_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest req =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, req);

        kestraClient().roles().deleteRole(created.getId(), MAIN_TENANT);

        assertThrows(ApiException.class, () ->
                kestraClient().roles().role(created.getId(), MAIN_TENANT),
            "Getting a deleted role should throw ApiException"
        );
    }

    @Test
    public void getRoleTest() throws ApiException {
        String name = "test_get_role_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest req =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, req);

        IAMRoleControllerApiRoleDetail fetched =
            kestraClient().roles().role(created.getId(), MAIN_TENANT);

        assertEquals(created.getId(), fetched.getId());
        assertEquals(created.getName(), fetched.getName());
    }

    @Test
    public void listRolesFromGivenIdsTest() throws ApiException {
        String name = "test_list_roles_from_given_ids_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest req =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, req);

        ApiIds ids = new ApiIds().ids(List.of(created.getId()));

        List<Role> fetched =
            kestraClient().roles().listRolesFromGivenIds(MAIN_TENANT, ids);

        assertFalse(fetched.isEmpty(), "Should return at least the created role");
        assertTrue(fetched.stream().anyMatch(r -> created.getId().equals(r.getId())));
    }

    @Test
    public void searchRolesTest() throws ApiException {
        String name = "test_search_roles_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest req =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, req);

        // page=1, size=10 to mirror Python defaults; adjust if your API is 0- or 1-based
        PagedResultsApiRoleSummary page =
            kestraClient().roles().searchRoles(1, 10, MAIN_TENANT, name, null);

        assertNotNull(page);
        assertNotNull(page.getResults());
        assertTrue(page.getResults().stream().anyMatch(r -> created.getId().equals(r.getId())));
    }

    @Test
    public void updateRoleTest() throws ApiException {
        String name = "test_update_role_" + randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions perms =
            new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                .FLOW(List.of("READ"));

        IAMRoleControllerApiRoleCreateOrUpdateRequest createReq =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(name)
                .description("Before")
                .permissions(perms);

        IAMRoleControllerApiRoleDetail created =
            kestraClient().roles().createRole(MAIN_TENANT, createReq);

        String updatedDesc = "Updated description";
        IAMRoleControllerApiRoleCreateOrUpdateRequest updateReq =
            new IAMRoleControllerApiRoleCreateOrUpdateRequest()
                .name(created.getName())
                .description(updatedDesc)
                .permissions(perms);

        IAMRoleControllerApiRoleDetail updated =
            kestraClient().roles().updateRole(created.getId(), MAIN_TENANT, updateReq);

        assertEquals(updatedDesc, updated.getDescription());
    }
}
