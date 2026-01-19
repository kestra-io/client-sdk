package io.kestra;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static io.kestra.example.CommonTestSetup.*;
import static org.awaitility.Awaitility.await;

public class TestUtils {
    public static final String FAILED_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: fail
            type: io.kestra.plugin.core.execution.Fail
        """;
    public static final String SLEEP_CONCURRENCY_FLOW = """
        id: %s
        namespace: %s

        concurrency:
          behavior: QUEUE
          limit: 1

        tasks:
          - id: sleep
            type: io.kestra.plugin.core.flow.Sleep
            duration: PT2S
        """;
    public static final String FILE_FLOW = """
        id: %s
        namespace: %s

        tasks:
            - id: write
              type: io.kestra.plugin.core.storage.Write
              content: "Hello from file"
              extension: .txt
        """;
    public static final String LOG_FLOW = """
        id: %s
        namespace: %s
        
        inputs:
          - id: key
            type: STRING
            defaults: 'empty'

        tasks:
          - id: hello
            type: io.kestra.plugin.core.log.Log
            message: Hello World! 🚀
        """;
    public static final String PAUSE_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: pause_flow
            type: io.kestra.plugin.core.flow.Pause
            delay: PT2S
        """;
    public static final String WEBHOOK_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: out
            type: io.kestra.plugin.core.debug.Return
            format: "{{trigger | json }}"

        triggers:
          - id: webhook
            type: io.kestra.plugin.core.trigger.Webhook
            key: a-secret-key
        """;

    public static final String SLEEP_THEN_LOG_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: sleep
            type: io.kestra.plugin.core.flow.Sleep
            duration: PT5S

          - id: log
            type: io.kestra.plugin.core.log.Log
            message: Hello World!
        """;

    public static FlowWithSource createSimpleFlow(String flow) throws ApiException {
        FlowWithSource flowWithSource = kestraClient().flows().createFlow(MAIN_TENANT, flow);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flowWithSource;
    }

    public static void createSimpleFlow(String flowId, String namespace) throws ApiException {
        String flow = LOG_FLOW.formatted(flowId, namespace);
        createSimpleFlow(flow);
    }

    public static ExecutionControllerExecutionResponse createFlowWithExecution(String flowId, String namespace) throws ApiException {
        createSimpleFlow(flowId, namespace);
        return kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
    }

    public static ExecutionControllerExecutionResponse createFlowWithExecutionFromFlow(String flow) throws ApiException {
        FlowWithSource simpleFlow = createSimpleFlow(flow);
        return kestraClient().executions().createExecution(simpleFlow.getNamespace(), simpleFlow.getId(), false, MAIN_TENANT, null, null, null, null, null);
    }

    public static Execution getExecutionWithFile(String flowId, String namespace) throws ApiException {
        String flow = FILE_FLOW.formatted(flowId, namespace);
        ExecutionControllerExecutionResponse execution = createFlowWithExecutionFromFlow(flow);

        AtomicReference<Execution> executionAtomic = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(5)).until(() -> {
            executionAtomic.set(kestraClient().executions().execution(execution.getId(), MAIN_TENANT));
            return executionAtomic.get().getState().getCurrent().equals(StateType.SUCCESS);
        });
        return executionAtomic.get();
    }

    public static void createSleepConcurrencyFlow(String flowId, String namespace) throws ApiException {
        String flow = SLEEP_CONCURRENCY_FLOW.formatted(flowId, namespace);
        createSimpleFlow(flow);
    }

    public static Execution createdExecution(String flow, StateType state) throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        ExecutionControllerExecutionResponse execution = createFlowWithExecutionFromFlow(flow.formatted(flowId, namespace));
        return awaitExecution(state, execution.getId());
    }
    public static ExecutionControllerExecutionResponse createExecution(String flow) {
        String namespace = randomId();
        String flowId = randomId();
        return createFlowWithExecutionFromFlow(flow.formatted(flowId, namespace));
    }

    public static Execution awaitExecution(StateType state,String executionId) throws ApiException {
        AtomicReference<Execution> executionAtomicReference = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(5)).until(() -> {
            executionAtomicReference.set(kestraClient().executions().execution(executionId, MAIN_TENANT));
            return executionAtomicReference.get().getState().getCurrent().equals(state);
        });
        return executionAtomicReference.get();
    }

    public static Execution createFlowAndDependentFlowAndExecute(String baseFlowId, String dependentFlowId, String namespace) throws ApiException {
        createSimpleFlow(baseFlowId, namespace);

        String DEPENDENT_FLOW = """
        id: %s
        namespace: %s

        triggers:
          - id: upstream_dependancy
            type: io.kestra.plugin.core.trigger.Flow
            preconditions:
                id: flow_trigger
                flows:
                  - flowId: %s
                    namespace: %s


        tasks:
          - id: hello
            type: io.kestra.plugin.core.log.Log
            message: Dependent flow triggered
        """;

        String dependentFlowYaml = DEPENDENT_FLOW.formatted(dependentFlowId, namespace, baseFlowId, namespace);
        createSimpleFlow(dependentFlowYaml);

        ExecutionControllerExecutionResponse baseExecResp = kestraClient().executions().createExecution(namespace, baseFlowId, false, MAIN_TENANT, null, null, null, null, null);
        return awaitExecution(StateType.SUCCESS, baseExecResp.getId());
    }
}
