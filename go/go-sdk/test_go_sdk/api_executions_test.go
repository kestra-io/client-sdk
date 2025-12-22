package main

import (
	"context"
	"fmt"
	"github.com/stretchr/testify/require"
	"testing"
)

func FAILED_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: fail
    type: io.kestra.plugin.core.execution.Fail
`, id, ns)
}

func SLEEP_CONCURRENCY_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

concurrency:
  behavior: QUEUE
  limit: 1

tasks:
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT2S
`, id, ns)
}

func FILE_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: write
    type: io.kestra.plugin.core.storage.Write
    content: "Hello from file"
    extension: .txt
`, id, ns)
}

func LOG_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
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
`, id, ns)
}

func PAUSE_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: pause_flow
    type: io.kestra.plugin.core.flow.Pause
    delay: PT2S
`, id, ns)
}

func WEBHOOK_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
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
`, id, ns)
}

func createFlow(ctx context.Context, id string, ns string, flowTemplate func(id string, ns string) string) {
	flowYaml := flowTemplate(id, ns)
	_, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(flowYaml).Execute()
	if err != nil {
		panic(fmt.Sprintf("error while inserting test flow with id: '%s', error: %s", id, err))
	}
}
func createSimpleFlow(ctx context.Context, id string, ns string) {
	createFlow(ctx, id, ns, LOG_FLOW)
}
func TestExecutionsAPI_All(t *testing.T) {

	t.Run("createExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		user, _, err := KestraTestApiClient().ExecutionsAPI.
			CreateExecution(ctx, namespace, flowId, MAIN_TENANT).
			Labels([]string{"label1:created"}).
			Execute()

		require.NoError(t, err)
		require.NotNil(t, user)

	})
}
