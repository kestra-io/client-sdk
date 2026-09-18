package io.kestra.sdk.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Serialization guards for the role permissions payload. These run without a
 * Kestra server.
 * <p>
 * Kestra 2.0 rejects a role create/update request whose {@code permissions} map
 * contains unknown or non-assignable permission keys. Because the permission
 * fields are nullable with no default value and the client mapper serializes
 * with {@code NON_NULL}, an "empty" permissions object must serialize to an
 * empty JSON object rather than emitting every permission key as {@code []}.
 */
class RolePermissionsSerializationTest {

    private final ObjectMapper mapper = new ApiClient().getObjectMapper();

    @Test
    void emptyPermissions_serializeToEmptyObject() throws Exception {
        String json = mapper.writeValueAsString(new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions());

        assertThat(json).isEqualTo("{}");
    }

    @Test
    void setPermission_serializesOnlyThatKey() throws Exception {
        IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions permissions =
                new IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions()
                        .FLOW(List.of("CREATE", "VIEW"));

        String json = mapper.writeValueAsString(permissions);

        assertThat(json).isEqualTo("{\"FLOW\":[\"CREATE\",\"VIEW\"]}");
    }
}
