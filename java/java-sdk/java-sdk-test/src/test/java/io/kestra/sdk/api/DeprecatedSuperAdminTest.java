package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.model.IAMUserControllerApiCreateOrUpdateUserRequest;
import io.kestra.sdk.model.IAMUserControllerApiUser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Kestra 2.0 renamed superAdmin to instanceOwner. Two separate aliases keep callers
 * working, and each is pinned here because they fail in different ways:
 *
 * <ul>
 *   <li>Java level — deprecated getSuperAdmin/setSuperAdmin/superAdmin(...) delegate to
 *       the instanceOwner field, so 1.x source keeps compiling. They are @JsonIgnore'd so
 *       they never become a second wire property.</li>
 *   <li>Wire level — @JsonAlias("superAdmin") on setInstanceOwner, so a payload from a
 *       pre-2.0 server still populates the field.</li>
 * </ul>
 */
@SuppressWarnings("deprecation")
public class DeprecatedSuperAdminTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void readAlias_delegatesToInstanceOwner() {
        IAMUserControllerApiUser u = new IAMUserControllerApiUser().instanceOwner(true);
        assertThat(u.getSuperAdmin()).isTrue().isEqualTo(u.getInstanceOwner());

        u.setInstanceOwner(false);
        assertThat(u.getSuperAdmin()).isFalse();
    }

    @Test
    void writeAliases_setTheInstanceOwnerField() {
        IAMUserControllerApiUser viaSetter = new IAMUserControllerApiUser();
        viaSetter.setSuperAdmin(true);
        assertThat(viaSetter.getInstanceOwner()).isTrue();

        // the deprecated builder returns the same fluent type
        IAMUserControllerApiUser viaBuilder = new IAMUserControllerApiUser().superAdmin(true);
        assertThat(viaBuilder.getInstanceOwner()).isTrue();
    }

    @Test
    void deprecatedAliasesNeverBecomeASecondWireProperty() throws Exception {
        String json = MAPPER.writeValueAsString(
                new IAMUserControllerApiCreateOrUpdateUserRequest().email("a@b.com").superAdmin(true));

        assertThat(json).contains("\"instanceOwner\":true");
        assertThat(json).doesNotContain("superAdmin");
    }

    @Test
    void jsonAlias_acceptsAPreTwoZeroPayload() throws Exception {
        // what a 1.x server sends
        IAMUserControllerApiUser legacy = MAPPER.readValue(
                "{\"id\":\"u1\",\"superAdmin\":true}", IAMUserControllerApiUser.class);
        assertThat(legacy.getInstanceOwner()).isTrue();

        // what a 2.0 server sends
        IAMUserControllerApiUser current = MAPPER.readValue(
                "{\"id\":\"u1\",\"instanceOwner\":true}", IAMUserControllerApiUser.class);
        assertThat(current.getInstanceOwner()).isTrue();
    }
}
