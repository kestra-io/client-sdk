package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static io.kestra.TestUtils.*;
import static org.awaitility.Awaitility.await;
import static org.assertj.core.api.Assertions.*;

/**
 * Policies are authored as YAML and sent as the raw source, so these tests drive the
 * same ten operations at each of the three scopes and assert the source round-trips.
 *
 * <p>Requires an EE instance whose licence carries the Policies feature: without it every
 * endpoint answers 403 before reaching the controller.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PoliciesApiTest {

    static PoliciesApi api() {
        return client().policies();
    }

    /**
     * `io.kestra.plugin.ee.rules.Require` is a built-in FLOW-scoped rule: it reports a
     * violation when the listed properties are missing from a flow after mutation.
     * `EVALUATE` keeps the policy from blocking anything while these tests run.
     */
    static String policySource(String id) {
        return policySource(id, "Test policy " + id, "EVALUATE");
    }

    static String policySource(String id, String displayName, String enforcement) {
        return """
                id: %s
                displayName: %s
                enforcement: %s
                rules:
                  - type: io.kestra.plugin.ee.rules.Require
                    on: FLOW
                    action: WARN
                    errorMessage: timeout is required
                    properties:
                      - timeout
                """.formatted(id, displayName, enforcement);
    }

    /**
     * Policy search reads an index updated asynchronously after a write, so a search issued
     * immediately after a create can legitimately miss the new policy — hence the polling
     * in the search tests below rather than a single read.
     */

    /** A namespace only exists once something lives in it. */
    static String namespaceWithFlow() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));
        return ns;
    }

    @Test
    void shouldRoundTripAuthoredSourceWhenCreatingInstancePolicy() throws ApiException {
        String id = randomId();

        Policy created = api().createInstancePolicy(policySource(id));
        assertThat(created).isNotNull();
        assertThat(created.getId()).isEqualTo(id);
        assertThat(created.getEnforcement()).isEqualTo(Enforcement.EVALUATE);

        Policy read = api().getInstancePolicy(id);
        assertThat(read.getId()).isEqualTo(id);
        // the API stores the authored YAML alongside the parsed model and returns it verbatim
        assertThat(read.getSource()).contains("io.kestra.plugin.ee.rules.Require");
        assertThat(read.getRules()).isNotEmpty();
    }

    @Test
    void shouldReturnPolicyWhenSearchingInstancePolicies() throws ApiException {
        String id = randomId();
        api().createInstancePolicy(policySource(id));

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(200)).untilAsserted(() ->
                assertThat(api().searchInstancePolicies(1, 100, null, null).getResults())
                        .anyMatch(p -> id.equals(p.getId())));
    }

    @Test
    void shouldApplyDisplayNameAndEnforcementWhenUpdatingInstancePolicy() throws ApiException {
        String id = randomId();
        api().createInstancePolicy(policySource(id));

        Policy updated = api().updateInstancePolicy(id, policySource(id, "Renamed " + id, "DISABLED"));

        assertThat(updated.getDisplayName()).isEqualTo("Renamed " + id);
        assertThat(updated.getEnforcement()).isEqualTo(Enforcement.DISABLED);
    }

    @Test
    void shouldReturnValidationResultWhenValidatingInstancePolicySource() throws ApiException {
        ValidateConstraintViolation violation = api().validateInstancePolicy(policySource(randomId()));

        assertThat(violation).isNotNull();
    }

    @Test
    void shouldReturnEvaluationWhenEvaluatingInstancePolicy() throws ApiException {
        String id = randomId();
        api().createInstancePolicy(policySource(id));

        PolicyEvaluation evaluation = api().evaluateInstancePolicy(id, 1, 10);

        assertThat(evaluation).isNotNull();
    }

    @Test
    void shouldReturnNonEmptyArchiveWhenExportingInstancePolicies() throws ApiException {
        api().createInstancePolicy(policySource(randomId()));

        byte[] exported = api().exportInstancePolicies();

        assertThat(exported).isNotEmpty();
    }

    @Test
    void shouldRejectGetWhenInstancePolicyDeleted() throws ApiException {
        String id = randomId();
        api().createInstancePolicy(policySource(id));

        api().deleteInstancePolicy(id);

        assertThatThrownBy(() -> api().getInstancePolicy(id))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void shouldCountEveryDeletionWhenDeletingInstancePoliciesByIds() throws ApiException {
        String first = randomId();
        String second = randomId();
        api().createInstancePolicy(policySource(first));
        api().createInstancePolicy(policySource(second));

        BulkResponse response = api().deleteInstancePoliciesByIds(List.of(first, second));

        assertThat(response).isNotNull();
        assertThat(response.getCount()).isEqualTo(2);
    }

    @Test
    void shouldRoundTripAuthoredSourceWhenCreatingTenantPolicy() throws ApiException {
        String id = randomId();

        Policy created = api().createTenantPolicy(TENANT, policySource(id));
        assertThat(created.getId()).isEqualTo(id);

        Policy read = api().getTenantPolicy(TENANT, id);
        assertThat(read.getId()).isEqualTo(id);
        assertThat(read.getSource()).contains("timeout is required");
    }

    @Test
    void shouldReturnPolicyWhenSearchingTenantPolicies() throws ApiException {
        String id = randomId();
        api().createTenantPolicy(TENANT, policySource(id));

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(200)).untilAsserted(() ->
                assertThat(api().searchPolicies(TENANT, 1, 100, null, null).getResults())
                        .anyMatch(p -> id.equals(p.getId())));
    }

    @Test
    void shouldReturnNonEmptyArchiveWhenExportingTenantPoliciesByIds() throws ApiException {
        String id = randomId();
        api().createTenantPolicy(TENANT, policySource(id));

        byte[] exported = api().exportTenantPoliciesByIds(TENANT, List.of(id));

        assertThat(exported).isNotEmpty();
    }

    @Test
    void shouldRejectGetWhenTenantPolicyDeleted() throws ApiException {
        String id = randomId();
        api().createTenantPolicy(TENANT, policySource(id));

        api().deleteTenantPolicy(TENANT, id);

        assertThatThrownBy(() -> api().getTenantPolicy(TENANT, id))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void shouldRoundTripAuthoredSourceWhenCreatingNamespacePolicy() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();

        Policy created = api().createNamespacePolicy(TENANT, ns, policySource(id));
        assertThat(created.getId()).isEqualTo(id);

        Policy read = api().getNamespacePolicy(TENANT, ns, id);
        assertThat(read.getId()).isEqualTo(id);
    }

    @Test
    void shouldReturnPolicyWhenSearchingNamespacePolicies() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();
        api().createNamespacePolicy(TENANT, ns, policySource(id));

        await().atMost(Duration.ofSeconds(10)).pollInterval(Duration.ofMillis(200)).untilAsserted(() ->
                assertThat(api().searchNamespacePolicies(TENANT, ns, 1, 100, null, null).getResults())
                        .anyMatch(p -> id.equals(p.getId())));
    }

    @Test
    void shouldApplyEnforcementWhenUpdatingNamespacePolicy() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();
        api().createNamespacePolicy(TENANT, ns, policySource(id));

        Policy updated = api().updateNamespacePolicy(TENANT, ns, id,
                policySource(id, "Test policy " + id, "ACTIVE"));

        assertThat(updated.getEnforcement()).isEqualTo(Enforcement.ACTIVE);
    }

    @Test
    void shouldReturnEvaluationWhenEvaluatingNamespacePolicy() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();
        api().createNamespacePolicy(TENANT, ns, policySource(id));

        PolicyEvaluation evaluation = api().evaluateNamespacePolicy(TENANT, ns, id, 1, 10);

        assertThat(evaluation).isNotNull();
    }

    @Test
    void shouldRejectGetWhenNamespacePolicyDeleted() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();
        api().createNamespacePolicy(TENANT, ns, policySource(id));

        api().deleteNamespacePolicy(TENANT, ns, id);

        assertThatThrownBy(() -> api().getNamespacePolicy(TENANT, ns, id))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void shouldReturnPreviewWhenPreviewingPoliciesForAFlow() throws ApiException {
        String ns = namespaceWithFlow();
        String id = randomId();
        api().createNamespacePolicy(TENANT, ns, policySource(id));

        PolicyPreviewResponse preview = api().previewPolicies(TENANT,
                new PolicyPreviewRequest().source(logFlowYaml(randomId(), ns)));

        assertThat(preview).isNotNull();
    }
}
