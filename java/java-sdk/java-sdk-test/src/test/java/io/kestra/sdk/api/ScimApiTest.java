package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ResourceType;
import io.kestra.sdk.model.Schema;
import io.kestra.sdk.model.ScimResource;
import io.kestra.sdk.model.ServiceProviderConfiguration;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Live tests for the SCIM v2 endpoints under
 * {@code /api/v1/{tenant}/integrations/{integration}/scim/v2/**}. The CI image licenses
 * {@code FEATURE_SCIM}, so a freshly created (and, on create, already enabled) SCIM security
 * integration lets the read-only discovery/query endpoints answer with real SCIM documents.
 * Provisioning writes (create/update/patch a user or group) are driven by an external IdP with
 * the integration's own service-account token, so they are exercised for binding/coverage only.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScimApiTest {

    static ScimApi api() {
        return client().scim();
    }

    static SecurityIntegrationsApi integrations() {
        return client().securityIntegrations();
    }

    /**
     * Creates an enabled SCIM security integration and returns its uid. The create request only
     * accepts name/description/type, so the integration starts disabled; the SCIM v2 endpoints
     * answer 403 "Access denied" for a disabled integration, so we enable it through the dedicated
     * endpoint before returning.
     */
    static String createScimIntegration() throws ApiException {
        Map<String, Object> created = integrations().createSecurityIntegration(
                TENANT, Map.of(
                        "name", "scim-" + randomId(),
                        "type", "SCIM",
                        "description", "SCIM integration created by sdk test"));
        String uid = (String) created.get("uid");
        integrations().enableSecurityIntegration(TENANT, uid);
        return uid;
    }

    static void deleteQuietly(String id) {
        try {
            integrations().deleteSecurityIntegration(TENANT, id);
        } catch (ApiException ignored) {
        }
    }

    @Test
    void serviceProviderConfig_isReturnedForEnabledIntegration() throws ApiException {
        String integration = createScimIntegration();

        try {
            ServiceProviderConfiguration config = api().getServiceProviderConfiguration(TENANT, integration);

            assertThat(config).isNotNull();
            // The server advertises PATCH support in its provider config — a real document, not
            // an empty envelope.
            assertThat(config.getPatch()).isNotNull();
        } finally {
            deleteQuietly(integration);
        }
    }

    @Test
    void resourceTypesAndSchemas_areDiscoverable() throws ApiException {
        String integration = createScimIntegration();

        try {
            List<ResourceType> resourceTypes = api().getAllResourceTypes(TENANT, integration);
            assertThat(resourceTypes).isNotNull().isNotEmpty();

            List<Schema> schemas = api().getAllSchemas(TENANT, integration);
            assertThat(schemas).isNotNull().isNotEmpty();
        } finally {
            deleteQuietly(integration);
        }
    }

    @Test
    void queryUsersAndGroups_returnListEnvelopes() throws ApiException {
        String integration = createScimIntegration();

        try {
            ScimResource users = api().queryUsers(TENANT, integration, null, null, null, null, null, null, null);
            assertThat(users).isNotNull();
            assertThat(users.getSchemas()).isNotNull();

            ScimResource groups = api().queryGroups(TENANT, integration, null, null, null, null, null, null, null);
            assertThat(groups).isNotNull();
            assertThat(groups.getSchemas()).isNotNull();
        } finally {
            deleteQuietly(integration);
        }
    }

    @Test
    void getUser_unknownId_reachesController() throws ApiException {
        String integration = createScimIntegration();

        try {
            // A missing user id must reach the SCIM controller (a not-found / bad-request SCIM
            // error), never the EE catch-all 403 a mis-routed produces mismatch would give.
            assertThatThrownBy(() -> api().getUser(TENANT, integration, "does-not-exist-" + randomId(), null, null))
                    .isInstanceOf(ApiException.class)
                    .satisfies(e -> assertThat(((ApiException) e).getCode()).isNotEqualTo(403));
        } finally {
            deleteQuietly(integration);
        }
    }
}
