package io.kestra.sdk.model;

import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IAMTenantAccessControllerApiUserPermissionTest {
    @Test
    void shouldReadTheResourceAndActionsOfAPermissionTheServerSends() throws Exception {
        IAMTenantAccessControllerApiUserPermission permission = new ApiClient().getObjectMapper().readValue(
            "{\"resource\":\"CASE\",\"actions\":[\"VIEW\",\"LIST\",\"LOCK\",\"PROMOTE\"]}",
            IAMTenantAccessControllerApiUserPermission.class
        );

        assertEquals(Resource.CASE, permission.getResource());
        assertEquals(List.of(Action.VIEW, Action.LIST, Action.LOCK, Action.PROMOTE), permission.getActions());
    }
}
