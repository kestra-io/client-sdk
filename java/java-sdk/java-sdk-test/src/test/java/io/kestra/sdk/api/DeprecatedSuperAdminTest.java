package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.model.IAMUserControllerApiCreateOrUpdateUserRequest;
import io.kestra.sdk.model.IAMUserControllerApiUser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * getSuperAdmin() is kept as a deprecated alias of getInstanceOwner() so callers written
 * against the 1.x SDK keep compiling. It must not leak back into the wire format.
 */
public class DeprecatedSuperAdminTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    @SuppressWarnings("deprecation")
    void getSuperAdmin_delegatesToInstanceOwner() {
        IAMUserControllerApiUser u = new IAMUserControllerApiUser().instanceOwner(true);
        assertThat(u.getSuperAdmin()).isTrue();
        assertThat(u.getSuperAdmin()).isEqualTo(u.getInstanceOwner());

        u.setInstanceOwner(false);
        assertThat(u.getSuperAdmin()).isFalse();
    }

    @Test
    void deprecatedAliasIsNotSerialised() throws Exception {
        String json = MAPPER.writeValueAsString(
                new IAMUserControllerApiCreateOrUpdateUserRequest().email("a@b.com").instanceOwner(true));

        assertThat(json).contains("\"instanceOwner\":true");
        assertThat(json).doesNotContain("superAdmin");
    }

    @Test
    void deserialisingInstanceOwnerFeedsTheDeprecatedAlias() throws Exception {
        IAMUserControllerApiUser u = MAPPER.readValue(
                "{\"id\":\"u1\",\"instanceOwner\":true}", IAMUserControllerApiUser.class);

        assertThat(u.getInstanceOwner()).isTrue();
        @SuppressWarnings("deprecation") Boolean legacy = u.getSuperAdmin();
        assertThat(legacy).isTrue();
    }
}
