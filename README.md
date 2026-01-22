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

```java
import io.kestra.sdk.KestraClient;
import io.kestra.sdk.api.FlowsApi;
import java.util.List;

public class KestraExample {
    public static void main(String[] args) throws Exception {
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
        String namespace = "demo";
        String flowId = "hello-from-sdk";

        String flowYaml = """
id: hello-from-sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK
""";

        FlowsApi flows = client.flows();
        flows.createFlow(tenant, flowYaml);

        String updatedFlowYaml = """
id: hello-from-sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello after update
""";

        flows.updateFlow(flowId, namespace, tenant, updatedFlowYaml);

        var executions = client.executions()
            .createExecution(namespace, flowId, true, tenant, null, null, null, null, null);
        System.out.println("Execution ID: " + executions.get(0).getExecution().getId());
    }
}
```

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

### Go (`github.com/kestra-io/client-sdk/go/go-sdk`)

- Pull the module into your project with `go get github.com/kestra-io/client-sdk/go/go-sdk@latest`.
- Update the first server entry (`cfg.Servers[0].URL`) so the client points to your Kestra host.
- For Basic authentication wrap the request context with `ContextBasicAuth`. To use a service account, set `ContextAccessToken` instead.

```go
package main

import (
    "context"
    "fmt"
    "log"

    kestra "github.com/kestra-io/client-sdk/go/go-sdk"
)

func main() {
    cfg := kestra.NewConfiguration()
    cfg.Servers[0].URL = "https://<kestra-host>"

    client := kestra.NewAPIClient(cfg)

    ctx := context.WithValue(context.Background(), kestra.ContextBasicAuth, kestra.BasicAuth{
        UserName: "user@kestra.io",
        Password: "password",
    })
    // Service account alternative:
    // ctx := context.WithValue(context.Background(), kestra.ContextAccessToken, "<service-account-api-key>")

    tenant := "main"
    namespace := "demo"
    flowID := "hello-from-sdk"

    flowYaml := `id: hello-from-sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK
`

    if _, _, err := client.FlowsAPI.CreateFlow(ctx, tenant).Body(flowYaml).Execute(); err != nil {
        log.Fatal(err)
    }

    updatedYaml := `id: hello-from-sdk
namespace: demo

tasks:
  - id: log
    type: io.kestra.plugin.core.log.Log
    message: Hello after update
`

    if _, _, err := client.FlowsAPI.UpdateFlow(ctx, flowID, namespace, tenant).Body(updatedYaml).Execute(); err != nil {
        log.Fatal(err)
    }

    executions, _, err := client.ExecutionsAPI.CreateExecution(ctx, namespace, flowID, tenant).Wait(true).Execute()
    if err != nil {
        log.Fatal(err)
    }

    fmt.Println("Execution ID:", executions[0].GetId())
}
```

## License
Apache 2.0 © [Kestra Technologies](https://kestra.io)


## Stay up to date

We release new versions every month. Give the [main repository](https://github.com/kestra-io/kestra) a star to stay up to date with the latest releases and get notified about future updates.

![Star the repo](https://kestra.io/star.gif)
