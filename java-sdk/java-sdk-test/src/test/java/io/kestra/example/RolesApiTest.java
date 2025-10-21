package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ApiAutocomplete;
import io.kestra.sdk.model.ApiIds;
import io.kestra.sdk.model.ApiRoleSummary;
import io.kestra.sdk.model.IAMRoleControllerApiRoleCreateOrUpdateRequest;
import io.kestra.sdk.model.IAMRoleControllerApiRoleDetail;
import io.kestra.sdk.model.PagedResultsApiRoleSummary;
import io.kestra.sdk.model.Role;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.*;

public class RolesApiTest {

    /**
     * List roles for autocomplete
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void autocompleteRolesTest() throws ApiException {

        ApiAutocomplete apiAutocomplete = null;
        List<ApiRoleSummary> response = kestraClient().roles().autocompleteRoles(MAIN_TENANT, apiAutocomplete);

        // TODO: test validations
    }
    /**
     * Create a role
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createRoleTest() throws ApiException {

        IAMRoleControllerApiRoleCreateOrUpdateRequest iaMRoleControllerApiRoleCreateOrUpdateRequest = null;
        IAMRoleControllerApiRoleDetail response =  kestraClient().roles().createRole(MAIN_TENANT, iaMRoleControllerApiRoleCreateOrUpdateRequest);

        // TODO: test validations
    }
    /**
     * Delete a role
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteRoleTest() throws ApiException {
        String id = randomId();

         kestraClient().roles().deleteRole(id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Retrieve a role
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRoleTest() throws ApiException {
        String id = randomId();

        IAMRoleControllerApiRoleDetail response =  kestraClient().roles().getRole(id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * List roles by ids
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listRolesFromGivenIdsTest() throws ApiException {

        ApiIds apiIds = null;
        List<Role> response =  kestraClient().roles().listRolesFromGivenIds(MAIN_TENANT, apiIds);

        // TODO: test validations
    }
    /**
     * Search for roles
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchRolesTest() throws ApiException {
        Integer page = null;
        Integer size = null;

        String q = null;
        List<String> sort = null;
        PagedResultsApiRoleSummary response =  kestraClient().roles().searchRoles(page, size, MAIN_TENANT, q, sort);

        // TODO: test validations
    }
    /**
     * Update a role
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateRoleTest() throws ApiException {
        String id = randomId();

        IAMRoleControllerApiRoleCreateOrUpdateRequest iaMRoleControllerApiRoleCreateOrUpdateRequest = null;
        IAMRoleControllerApiRoleDetail response =  kestraClient().roles().updateRole(id, MAIN_TENANT, iaMRoleControllerApiRoleCreateOrUpdateRequest);

        // TODO: test validations
    }
}
