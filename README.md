<p align="center">
  <a href="https://www.kestra.io">
    <img src="https://kestra.io/banner.png"  alt="Kestra workflow orchestrator" />
  </a>
</p>

<h1 align="center" style="border-bottom: none">
    Event-Driven Declarative Orchestrator
</h1>

<div align="center">
 <a href="https://github.com/kestra-io/kestra/releases"><img src="https://img.shields.io/github/tag-pre/kestra-io/kestra.svg?color=blueviolet" alt="Last Version" /></a>
  <a href="https://github.com/kestra-io/kestra/blob/develop/LICENSE"><img src="https://img.shields.io/github/license/kestra-io/kestra?color=blueviolet" alt="License" /></a>
  <a href="https://github.com/kestra-io/kestra/stargazers"><img src="https://img.shields.io/github/stars/kestra-io/kestra?color=blueviolet&logo=github" alt="Github star" /></a> <br>
<a href="https://kestra.io"><img src="https://img.shields.io/badge/Website-kestra.io-192A4E?color=blueviolet" alt="Kestra infinitely scalable orchestration and scheduling platform"></a>
<a href="https://kestra.io/slack"><img src="https://img.shields.io/badge/Slack-Join%20Community-blueviolet?logo=slack" alt="Slack"></a>
</div>

<br />

<p align="center">
    <a href="https://twitter.com/kestra_io"><img height="25" src="https://kestra.io/twitter.svg" alt="twitter" /></a> &nbsp;
    <a href="https://www.linkedin.com/company/kestra/"><img height="25" src="https://kestra.io/linkedin.svg" alt="linkedin" /></a> &nbsp;
<a href="https://www.youtube.com/@kestra-io"><img height="25" src="https://kestra.io/youtube.svg" alt="youtube" /></a> &nbsp;
</p>

<br />
<p align="center">
    <a href="https://go.kestra.io/video/product-overview" target="_blank">
        <img src="https://kestra.io/startvideo.png" alt="Get started in 4 minutes with Kestra" width="640px" />
    </a>
</p>
<p align="center" style="color:grey;"><i>Get started with Kestra in 4 minutes.</i></p>


# Kestra client SDK

Kestra client SDK in various language to interact with a running Kestra instance.

Documention is avaible on https://kestra.io/docs/api-reference/kestra-sdk

## SDK usage by language

The repository currently ships SDKs for Python, Java, JavaScript, and Go. The snippets below show how to install each package, authenticate with either Basic credentials or a service account API key, and perform a basic flow lifecycle: create a flow, update it, then trigger a new execution.

### Python (`kestrapy`)

- Install with `pip install kestrapy` (Python 3.9+).
- Configure `Configuration.host` with the URL of your Kestra instance.
- For Basic authentication set `configuration.username` and `configuration.password`. For service accounts set `configuration.access_token` to the API key and omit the username/password fields.

```python
from kestrapy import KestraClient, Configuration
from kestrapy.exceptions import ApiException

tenant = "main"
namespace = "demo"
flow_id = "hello_from_sdk"

flow_yaml = """id: hello_from_sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK
"""

configuration = Configuration()
configuration.host = "https://<kestra-host>"
configuration.username = "user@kestra.io"
configuration.password = "password"  # replace with your Basic auth secrets
# Service account alternative:
# configuration = Configuration(host="https://<kestra-host>")
# configuration.access_token = "<service-account-api-key>"

client = KestraClient(configuration)

try:
    client.flows.create_flow(tenant, flow_yaml)

    updated_flow_yaml = """id: hello_from_sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello after update
"""

    client.flows.update_flow(
        id=flow_id,
        namespace=namespace,
        tenant=tenant,
        body=updated_flow_yaml,
    )

    executions = client.executions.create_execution(
        namespace=namespace,
        id=flow_id,
        wait=True,
        tenant=tenant,
    )
    print("Execution ID:", executions[0].execution.id)
except ApiException as err:
    print("Kestra API error:", err)
```

### Java (`io.kestra:kestra-api-client`)

- Add the dependency to your build: `io.kestra:kestra-api-client:1.0.0`.
- Basic authentication uses the builder method `.basicAuth(username, password)`. Service accounts call `.tokenAuth("<service-account-api-key>")` instead.

<details>
<summary>Maven</summary>

```xml
<dependency>
  <groupId>io.kestra</groupId>
  <artifactId>kestra-api-client</artifactId>
  <version>1.0.0</version>
</dependency>
```

</details>

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("io.kestra:kestra-api-client:1.0.0")
```

</details>

Build a client, then perform a basic flow lifecycle:

```java
import io.kestra.sdk.KestraClient;

KestraClient client = KestraClient.builder()
    .url("https://<kestra-host>")
    .basicAuth("user@kestra.io", "password")
    .build();
// Service account alternative:
// KestraClient client = KestraClient.builder()
//     .url("https://<kestra-host>")
//     .tokenAuth("<service-account-api-key>")
//     .build();

String tenant = "main";
```

The block below is injected from the CI-tested example
`java/java-sdk/java-sdk-test/src/main/java/io/kestra/example/BasicSDKUsageExample.java`
(issue #144). Do not edit it by hand — change the example and re-run
`java test-utils/EmbedSnippets.java --write README.md`.

<!-- snippet:flow-lifecycle src=java/java-sdk/java-sdk-test/src/main/java/io/kestra/example/BasicSDKUsageExample.java lang=java -->
```java
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
```
<!-- /snippet -->

### JavaScript (`@kestra-io/kestra-sdk`)

- Install with `npm install @kestra-io/kestra-sdk` or `yarn add @kestra-io/kestra-sdk`.
- Instantiate `KestraClient` with `(host, accessToken, username, password)`. Supply either an access token for service accounts or username/password for Basic auth.

```javascript
import KestraClient from "@kestra-io/kestra-sdk";

const tenantId = "main";
const namespace = "demo";
const flowId = "hello_from_sdk";

const flowYaml = `id: hello_from_sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK
`;

const client = new KestraClient(
  "https://<kestra-host>",
  null,
  "user@kestra.io",
  "password"
);
// Service account alternative:
// const client = new KestraClient("https://<kestra-host>", "<service-account-api-key>");

await new Promise((resolve, reject) =>
  client.flowsApi.createFlow(tenantId, flowYaml, (err, data) => (err ? reject(err) : resolve(data)))
);

const updatedFlowYaml = `id: hello_from_sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello after update
`;

await new Promise((resolve, reject) =>
  client.flowsApi.updateFlow(flowId, namespace, tenantId, updatedFlowYaml, (err, data) => (err ? reject(err) : resolve(data)))
);

await new Promise((resolve, reject) =>
  client.executionsApi.createExecution(namespace, flowId, true, tenantId, {}, (err, data) => (err ? reject(err) : resolve(data)))
);
```

### Go (`github.com/kestra-io/client-sdk/go-sdk`)

- Pull the module into your project with `go get github.com/kestra-io/client-sdk/go-sdk@latest`.
- Build a `KestraClient` with `NewClient`, pointing it at your Kestra host.
- Authenticate with Basic credentials via `WithBasicAuth`, or with a service-account token via `WithTokenAuth`.

Build a client, then perform a basic flow lifecycle:

```go
package main

import (
	"context"
	"fmt"
	"log"

	kestra "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

func main() {
	client := kestra.NewClient(
		"https://<kestra-host>",
		kestra.WithBasicAuth("user@kestra.io", "password"),
	)
	// Service account alternative:
	// client := kestra.NewClient(
	// 	"https://<kestra-host>",
	// 	kestra.WithTokenAuth("<service-account-api-key>"),
	// )

	if _, err := flowLifecycle(context.Background(), client, "main"); err != nil {
		log.Fatal(err)
	}
}
```

The `flowLifecycle` function below is injected from the CI-tested example
`go-sdk/test/basic_sdk_usage_example.go` (issue #144). Do not edit it by hand —
change the example and re-run `java test-utils/EmbedSnippets.java --write README.md`.

<!-- snippet:flow-lifecycle src=go-sdk/test/basic_sdk_usage_example.go lang=go -->
```go
// flowLifecycle lists the tenant's flows, creates one from YAML, updates it,
// then triggers an execution and waits for it to finish, returning its id.
func flowLifecycle(ctx context.Context, client *kestra.KestraClient, tenant string) (string, error) {
	namespace := "company.team"
	flowID := "hello_from_sdk"

	// List the first page of flows in the tenant.
	flows, err := client.Flows().SearchFlows(ctx, tenant, kestra.PtrInt(1), kestra.PtrInt(10), nil, nil)
	if err != nil {
		return "", err
	}
	fmt.Printf("Found %d flows\n", flows.GetTotal())

	// Create a flow from its YAML source.
	flowYAML := `id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the Kestra Go SDK!
`
	created, err := client.Flows().CreateFlow(ctx, tenant, flowYAML)
	if err != nil {
		return "", err
	}
	fmt.Printf("Created flow %s.%s (revision %d)\n", created.GetNamespace(), created.GetId(), created.GetRevision())

	// Update the flow — UpdateFlow takes (namespace, id, tenant, body).
	updatedYAML := `id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello after update!
`
	if _, err := client.Flows().UpdateFlow(ctx, namespace, flowID, tenant, updatedYAML); err != nil {
		return "", err
	}

	// Trigger an execution and wait for it to complete.
	execution, err := client.Executions().CreateExecution(ctx, tenant, namespace, flowID, nil, kestra.PtrBool(true), nil, nil, nil, nil)
	if err != nil {
		return "", err
	}
	state := execution.GetState()
	fmt.Printf("Execution %s finished in state %s\n", execution.GetId(), state.GetCurrent())

	return execution.GetId(), nil
}
```
<!-- /snippet -->

## How to update the SDK
- Generate openapi from Kestra-EE: `./gradlew clean build updateOpenapiVersion -xtest`
- Move `kestra-ee.yml` from `webserver-ee/build/classes/java/main/META-INF/swagger` to the root of the SDK repository
- If you introduced a new controller with a new kind of entity and it has a new OpenAPI / Swagger tag, you should add it there `java/configuration/java-config.yml` (and for all SDK that must support it) in openapiNormalizer.FILTER (it's an opt-in for each tag)
- Generate the SDKs using `TMP=$(pwd) && $TMP/generate-sdks.sh 1.0.10 java && $TMP/generate-sdks.sh 1.0.12 javascript && $TMP/generate-sdks.sh 1.0.10 python && $TMP/generate-sdks.sh 1.0.1 go` (change the version to SDK-current-version + 1)
- Create the tests for the added functionality in each SDK tests folder
- Run tests of all SDKs: `TMP=~/IdeaProjects/client-sdk && cd $TMP/java/java-sdk && chmod 755 gradlew && ./run-tests.sh develop && cd $TMP/go-sdk && bash ./run-tests.sh develop && cd $TMP/javascript && bash ./run-tests.sh develop && cd $TMP/python/python-sdk && bash ./run-tests.sh develop`
- ⚠ If an existing test fails, you're probably introducing a breaking change (or someone's prior commit did). If that's the case, make sure it's safe to introduce that before merging
- Commit and make a PR

## CI: weekly SDK freshness check

The per-PR pipelines test each SDK against the Kestra version resolved for the
branch and only run when that SDK's files change. To catch upstream API
breaking changes early, `.github/workflows/sdk-freshness-check.yml` runs **every
Sunday (14:00 UTC)** — and on manual `workflow_dispatch` — exercising all four
SDK test suites against a Kestra server built from the **latest line**
(`develop`).

The job is **non-blocking**: it only runs on a schedule / manual trigger, never
on PRs, and must not be added to branch-protection required checks. A red run is
an early-warning signal, not a merge gate. On failure it posts to Slack
(`#_int_alert-ecosystem-build`, via the `SLACK_WEBHOOK_URL` secret) naming the
SDK that broke, the Kestra version under test, and a link to the run.

**Triaging an alert** — when a leg goes red, decide which case applies:
- *The committed spec is stale* — `develop` added/changed an endpoint the SDK
  doesn't know about yet. Regenerate from the latest spec (see *How to update
  the SDK* above) and update tests.
- *A real upstream breaking change* — `develop` removed or altered behaviour the
  SDK relies on. Surface it to the plugin squad / upstream; the SDK (and
  downstream consumers like `kestractl`) will need to absorb it before the next
  major.

## License
Apache 2.0 © [Kestra Technologies](https://kestra.io)


## Stay up to date

We release new versions every month. Give the [main repository](https://github.com/kestra-io/kestra) a star to stay up to date with the latest releases and get notified about future updates.

![Star the repo](https://kestra.io/star.gif)
