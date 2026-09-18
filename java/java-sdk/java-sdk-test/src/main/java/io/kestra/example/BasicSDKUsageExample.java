package io.kestra.example;

import io.kestra.sdk.KestraClient;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.ExecutionControllerExecutionResponse;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.PagedResultsFlow;

import java.util.List;

/**
 * Runnable usage example for the Kestra Java SDK.
 *
 * <p>The block between the {@code region:flow-lifecycle} / {@code endregion}
 * markers below is the <em>single source of truth</em> for the usage snippet in
 * the root {@code README.md}: it is injected verbatim by
 * {@code test-utils/EmbedSnippets.java} and exercised against a live Kestra by
 * {@link BasicSDKUsageExampleTest}. Keeping the README snippet physically
 * identical to tested code is what stops the docs from drifting (issue #144) —
 * so edit the example here, never the README block, then re-run the injector:
 *
 * <pre>java test-utils/EmbedSnippets.java --write README.md</pre>
 *
 * <p>{@code client} and {@code tenant} are provided by the caller; the README
 * shows how to build the client just above the injected block.
 */
public class BasicSDKUsageExample {

    public static String flowLifecycle(KestraClient client, String tenant) throws ApiException {
        // region:flow-lifecycle
        String namespace = "company.team";
        String flowId = "hello_from_sdk";

        // List the first page of flows in the tenant.
        PagedResultsFlow flows = client.flows().searchFlows(tenant, 1, 10, null, List.of());
        System.out.println("Found " + flows.getResults().size() + " flows");

        // Create a flow from its YAML source.
        String flowYaml = """
            id: hello_from_sdk
            namespace: company.team

            tasks:
              - id: hello
                type: io.kestra.plugin.core.log.Log
                message: Hello from the Kestra Java SDK!
            """;
        FlowWithSource created = client.flows().createFlow(tenant, flowYaml);
        System.out.println("Created flow " + created.getNamespace() + "." + created.getId()
            + " (revision " + created.getRevision() + ")");

        // Update the flow — updateFlow takes (namespace, id, tenant, body).
        String updatedYaml = """
            id: hello_from_sdk
            namespace: company.team

            tasks:
              - id: hello
                type: io.kestra.plugin.core.log.Log
                message: Hello after update!
            """;
        client.flows().updateFlow(namespace, flowId, tenant, updatedYaml);

        // Trigger an execution and wait for it to complete.
        ExecutionControllerExecutionResponse execution = client.executions()
            .createExecution(tenant, namespace, flowId, null, true, null, null, null, null);
        System.out.println("Execution " + execution.getId()
            + " finished in state " + execution.getState().getCurrent());
        // endregion
        return execution.getId();
    }
}
