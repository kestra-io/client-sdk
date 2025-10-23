import {describe, expect, it} from "vitest";
import IAMUserControllerApiCreateOrUpdateUserRequest from "../src/model/IAMUserControllerApiCreateOrUpdateUserRequest";
import CreateApiTokenRequest from "../src/model/CreateApiTokenRequest";
import IAMUserControllerApiPatchUserPasswordRequest from "../src/model/IAMUserControllerApiPatchUserPasswordRequest";
import ApiPatchSuperAdminRequest from "../src/model/ApiPatchSuperAdminRequest";
import {kestraClient, randomEmail, randomId} from "./CommonTestSetup";


async function assertUserExist(userId) {
    await expect(await kestraClient().usersApi.getUser(userId)).toHaveProperty('id', userId);
}
async function assertUserDoesNotExist(userId) {
    await expect(kestraClient().usersApi.getUser(userId)).rejects.toHaveProperty('status', 404);
}
async function createUser() {
    const user = await kestraClient().usersApi.createUser(new IAMUserControllerApiCreateOrUpdateUserRequest(randomEmail()));
    await assertUserExist(user.id);
    return user;
}

describe("UsersApi tests", async () => {
    it('should call createUser successfully', async () => {
        const user = await kestraClient().usersApi.createUser(new IAMUserControllerApiCreateOrUpdateUserRequest(randomEmail()));
        await assertUserExist(user.id);
    });
    it('should call getUser successfully', async () => {
        const user = await createUser();
        await assertUserExist(user.id);
    });
    it('should call deleteUser successfully', async () => {
        const user = await createUser();

        await kestraClient().usersApi.deleteUser(user.id);

        await assertUserDoesNotExist(user.id)
    });
    it('should call updateUser successfully', async () => {
        const user = await createUser();

        const newFirstName = randomId();
        await kestraClient().usersApi.updateUser(user.id, IAMUserControllerApiCreateOrUpdateUserRequest.constructFromObject({
            firstName: newFirstName
        }, new IAMUserControllerApiCreateOrUpdateUserRequest(user.email)));

        const updatedUser = await kestraClient().usersApi.getUser(user.id);
        expect(updatedUser).toHaveProperty('firstName', newFirstName)
    });
    it('should call patchUser successfully', async () => {
        const user = await createUser();

        const newFirstName = randomId();
        await kestraClient().usersApi.patchUser(user.id, IAMUserControllerApiCreateOrUpdateUserRequest.constructFromObject({
            firstName: newFirstName
        }, new IAMUserControllerApiCreateOrUpdateUserRequest(user.email)));

        const updatedUser = await kestraClient().usersApi.getUser(user.id);
        expect(updatedUser).toHaveProperty('firstName', newFirstName)
    });
    it('should call listUsers successfully', async () => {
        const user = await createUser();

        const page = 1;
        const size = 1;
        const users = await kestraClient().usersApi.listUsers(page, size);

        expect(users.results).length(1);
    });

    /*it('should call updateUserGroups successfully', async () => { TODO
        const user = await createUser();
        await kestraClient().groupsApi.createGroup(MAIN_TENANT, new IAMGroupControllerApiCreateGroupRequest(groudName));

        const newFirstName = randomId();
        await kestraClient().usersApi.updateUserGroups(user.id, IAMUserControllerApiCreateOrUpdateUserRequest.constructFromObject({
            firstName: newFirstName
        }, new IAMUserControllerApiCreateOrUpdateUserRequest(user.email)));

        const updatedUser = await kestraClient().usersApi.getUser(user.id);
        expect(updatedUser).toHaveProperty('firstName', newFirstName)
    });*/

    it('should call autocompleteUsers successfully', async () => {
        await createUser();
        await kestraClient().usersApi.autocompleteUsers(MAIN_TENANT, {});
    });

    it('should call createApiTokensForUser successfully', async () => {
        const user = await createUser();
        const tokenName = randomId();
        await kestraClient().usersApi.createApiTokensForUser(user.id, new CreateApiTokenRequest(tokenName));
    });
    it('should call listApiTokensForUser successfully', async () => {
        const user = await createUser();
        const tokenName = randomId();
        await kestraClient().usersApi.createApiTokensForUser(user.id, new CreateApiTokenRequest(tokenName));

        await kestraClient().usersApi.listApiTokensForUser(user.id);
    });
    it('should call deleteApiToken successfully', async () => {
        const user = await createUser();
        const tokenName = randomId();
        const token = await kestraClient().usersApi.createApiTokensForUser(user.id, new CreateApiTokenRequest(tokenName));

        await kestraClient().usersApi.deleteApiTokenForUser(user.id, token.id);
    });
    it('should call deleteRefreshToken successfully', async () => {
        const user = await createUser();
        await kestraClient().usersApi.deleteRefreshToken(user.id);
    });

    // it('should call deleteUserAuthMethod successfully', async () => {
    //     //uncomment below and update the code to test deleteUserAuthMethod
    //     //instance.deleteUserAuthMethod(function(error) {
    //     //  if (error) throw error;
    //     //expect().to.be();
    //     //});
    //     done();
    // });

    // it('should call impersonate successfully', async () => {
    //     //uncomment below and update the code to test impersonate
    //     //instance.impersonate(function(error) {
    //     //  if (error) throw error;
    //     //expect().to.be();
    //     //});
    //     done();
    // });

    // it('should call patchUserDemo successfully', async () => {
    //     //uncomment below and update the code to test patchUserDemo
    //     //instance.patchUserDemo(function(error) {
    //     //  if (error) throw error;
    //     //expect().to.be();
    //     //});
    //     done();
    // });
    it('should call patchUserPassword successfully', async () => {
        const user = await createUser();

        const newPassword = randomId()+"12!KJZD";
        await kestraClient().usersApi.patchUserPassword(user.id, new IAMUserControllerApiPatchUserPasswordRequest(newPassword));

        const updatedUser = await kestraClient().usersApi.getUser(user.id);
    });
    it('should call patchUserSuperAdmin successfully', async () => {
        const user = await createUser();

        await kestraClient().usersApi.patchUserSuperAdmin(user.id, new ApiPatchSuperAdminRequest(true));

        const updatedUser = await kestraClient().usersApi.getUser(user.id);
        expect(updatedUser).toHaveProperty('superAdmin', true)
    });
    // TODO
    // it('should call updateCurrentUserPassword successfully', async () => {
    //     //uncomment below and update the code to test updateCurrentUserPassword
    //     //instance.updateCurrentUserPassword(function(error) {
    //     //  if (error) throw error;
    //     //expect().to.be();
    //     //});
    //     done();
    // });
});
