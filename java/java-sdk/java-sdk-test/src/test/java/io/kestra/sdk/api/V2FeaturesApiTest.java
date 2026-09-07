package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

/**
 * Covers the Kestra 2.0 surface the SDK did not expose: namespace/tenant concurrency
 * and quotas, worker selectors, execution outputs, and the superAdmin -> instanceOwner
 * rename. Each test asserts a value round-trips, so a silently-dropped field fails here
 * rather than in a caller.
 *
 * <p>The deprecated {@code patchUserSuperAdmin} / {@code patchServiceAccountSuperAdmin}
 * routes are deliberately not covered: whether the server still honours a legacy
 * {@code superAdmin} body depends on the build. kestra-ee 355fd940d added that fallback
 * on 2026-08-25 15:12, three hours after v2.0.0-rc11 was cut, so it no-ops on rc11 and
 * applies on develop. That is Kestra's behaviour to pin, not the SDK's.
 */
public class V2FeaturesApiTest {

    // ========================================================================
    // Namespace concurrency + quotas
    // ========================================================================

    @Test
    void namespace_concurrencyAndQuotas_roundTrip() throws ApiException {
        String id = randomId();
        client().namespaces().createNamespace(TENANT, new Namespace().id(id));

        Namespace updated = client().namespaces().updateNamespace(id, TENANT, new Namespace()
                .id(id)
                .concurrency(new Concurrency().limit(3).behavior(ConcurrencyBehavior.QUEUE))
                .quotas(List.of(new Quota().duration("PT1H").limit(10L).behavior(QuotaBehavior.FAIL))));

        assertThat(updated.getConcurrency()).isNotNull();
        assertThat(updated.getConcurrency().getLimit()).isEqualTo(3);
        assertThat(updated.getConcurrency().getBehavior()).isEqualTo(ConcurrencyBehavior.QUEUE);

        Namespace fetched = client().namespaces().namespace(id, TENANT);
        assertThat(fetched.getConcurrency()).isNotNull();
        assertThat(fetched.getConcurrency().getLimit()).isEqualTo(3);
        assertThat(fetched.getQuotas()).isNotNull();
        assertThat(fetched.getQuotas()).anySatisfy(q -> {
            assertThat(q.getDuration()).isEqualTo("PT1H");
            assertThat(q.getLimit()).isEqualTo(10L);
            assertThat(q.getBehavior()).isEqualTo(QuotaBehavior.FAIL);
        });
    }

    @Test
    void namespace_defaultWorkerSelector_roundTrip() throws ApiException {
        String id = randomId();
        client().namespaces().createNamespace(TENANT, new Namespace().id(id));

        client().namespaces().updateNamespace(id, TENANT, new Namespace()
                .id(id)
                .defaultWorkerSelector(new WorkerSelector()
                        .tags(List.of("gpu"))
                        .match(WorkerSelectorMatch.ALL)
                        .fallback(WorkerQueueFallback.FAIL)));

        Namespace fetched = client().namespaces().namespace(id, TENANT);
        assertThat(fetched.getDefaultWorkerSelector()).isNotNull();
        assertThat(fetched.getDefaultWorkerSelector().getTags()).contains("gpu");
        assertThat(fetched.getDefaultWorkerSelector().getMatch()).isEqualTo(WorkerSelectorMatch.ALL);
    }

    // ========================================================================
    // Flow-level worker selector + draft
    // ========================================================================

    @Test
    void flow_workerSelectorAndDraft_roundTrip() throws ApiException {
        String ns = randomId();
        String id = randomId();
        FlowWithSource created = client().flows().createFlow(TENANT, """
                id: %s
                namespace: %s
                workerSelector:
                  tags:
                    - gpu
                  match: ALL
                tasks:
                  - id: h
                    type: io.kestra.plugin.core.log.Log
                    message: hi
                """.formatted(id, ns));

        assertThat(created.getWorkerSelector()).isNotNull();
        assertThat(created.getWorkerSelector().getTags()).contains("gpu");
        // draft is a 2.0 addition and is always present on the payload
        assertThat(created.getDraft()).isNotNull();
        assertThat(created.getDraft()).isFalse();
    }

    // ========================================================================
    // Execution outputs (moved off the Execution payload in 2.0)
    // ========================================================================

    @Test
    void executionOutputs_areFetchableFromTheOutputsApi() throws ApiException {
        String ns = randomId();
        String id = randomId();
        client().flows().createFlow(TENANT, """
                id: %s
                namespace: %s
                outputs:
                  - id: greeting
                    type: STRING
                    value: "hello"
                tasks:
                  - id: h
                    type: io.kestra.plugin.core.log.Log
                    message: hi
                """.formatted(id, ns));

        String executionId = client().executions()
                .createExecution(TENANT, ns, id, null, null, null, null, null, null).getId();

        await().atMost(60, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            StateType s = client().executions().execution(executionId, TENANT).getState().getCurrent();
            return s == StateType.SUCCESS || s == StateType.FAILED || s == StateType.WARNING;
        });

        Map<String, Object> outputs = client().outputs().getExecutionOutputs(executionId, TENANT);
        assertThat(outputs).containsEntry("greeting", "hello");

        assertThat(client().outputs().getTaskOutputsInformation(executionId, TENANT)).isNotNull();
    }

    // ========================================================================
    // superAdmin -> instanceOwner
    // ========================================================================

    @Test
    void patchUserInstanceOwner_readsBackOnTheRenamedField() throws ApiException {
        IAMUserControllerApiUser created = client().users().createUser(
                new IAMUserControllerApiCreateOrUpdateUserRequest()
                        .email("instanceowner-" + randomId() + "@test.com")
                        .password("TestPass!1234"));

        client().users().patchUserInstanceOwner(created.getId(),
                new ApiPatchInstanceOwnerRequest().instanceOwner(true));
        assertThat(client().users().user(created.getId()).getInstanceOwner()).isTrue();

        client().users().patchUserInstanceOwner(created.getId(),
                new ApiPatchInstanceOwnerRequest().instanceOwner(false));
        assertThat(client().users().user(created.getId()).getInstanceOwner()).isFalse();

        client().users().deleteUser(created.getId());
    }

    @Test
    void patchServiceAccountInstanceOwner_readsBackOnTheRenamedField() throws ApiException {
        IAMServiceAccountControllerApiServiceAccountDetail sa = client().serviceAccount()
                .createServiceAccount(new IAMServiceAccountControllerApiCreateServiceAccountRequest()
                        .name("sa-io-" + randomId().substring(0, 8)));

        client().serviceAccount().patchServiceAccountInstanceOwner(sa.getId(),
                new ApiPatchInstanceOwnerRequest().instanceOwner(true));
        assertThat(client().serviceAccount().serviceAccount(sa.getId()).getInstanceOwner()).isTrue();

        client().serviceAccount().deleteServiceAccount(sa.getId());
    }

}
