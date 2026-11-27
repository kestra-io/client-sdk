# kestrapy — Kestra Python SDK

Official Python SDK for the [Kestra](https://kestra.io) API. Use it to manage
flows, executions and other resources programmatically from a Python
application.

All API operations, except for Instance-owner-only endpoints, require a tenant
identifier in the HTTP path. Endpoints designated as Instance-owner-only are not
tenant-scoped.

- Package: [`kestrapy`](https://pypi.org/project/kestrapy/)
- Source: <https://github.com/kestra-io/client-sdk> (`python/python-sdk`)
- Requires Python 3.9+

> This SDK is hand-written. Do not regenerate it — edit the sources under
> `python/python-sdk` directly.

## Installation

```sh
pip install kestrapy
```

## Getting started

Create a `Configuration`, configure the host and authentication, then
instantiate the single `KestraClient` that gathers every API:

```python
from kestrapy import Configuration, KestraClient

configuration = Configuration()
configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

kestra_client = KestraClient(configuration)
tenant = "main"

# List the first page of flows in the tenant.
flows = kestra_client.flows.search_flows(tenant, page=1, size=10)
print(f"Found {len(flows.results)} flows")

# Create a new flow from its YAML source.
flow = """
id: hello_from_sdk
namespace: company.team

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the Kestra Python SDK!
"""
created = kestra_client.flows.create_flow(tenant, flow)
print(f"Created flow {created.namespace}.{created.id} (revision {created.revision})")
```

### Authentication

The client supports HTTP basic auth and bearer tokens. Prefer reading
credentials from the environment rather than hard-coding them:

```python
import os

from kestrapy import Configuration, KestraClient

# HTTP basic authentication
configuration = Configuration(
    host="http://localhost:8080",
    username=os.environ["KESTRA_USERNAME"],
    password=os.environ["KESTRA_PASSWORD"],
)
kestra_client = KestraClient(configuration)

# ...or a bearer token (service-account API token / JWT)
kestra_client = KestraClient(
    host="http://localhost:8080",
    token=os.environ["KESTRA_TOKEN"],
)
```

Pass bearer tokens with the `token=` keyword: `KestraClient` does not read
`Configuration.access_token`.

## Errors

API calls raise `kestrapy.rest.ApiException` on non-2xx responses:

```python
from kestrapy.rest import ApiException

try:
    kestra_client.flows.flow("company.team", "does_not_exist", tenant)
except ApiException as e:
    print(f"Kestra API returned {e.status}: {e.reason}")
```

## Documentation for API Endpoints

Per-method reference (signatures, parameters, examples) for the most-used APIs.
Every `KestraClient` accessor is documented by its docstrings.

Accessor | Reference
------------- | -------------
`kestra_client.executions` | [ExecutionsApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/ExecutionsApi.md)
`kestra_client.flows` | [FlowsApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/FlowsApi.md)
`kestra_client.groups` | [GroupsApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/GroupsApi.md)
`kestra_client.kv` | [KVApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/KVApi.md)
`kestra_client.logs` | [LogsApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/LogsApi.md)
`kestra_client.namespaces` | [NamespacesApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/NamespacesApi.md)
`kestra_client.roles` | [RolesApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/RolesApi.md)
`kestra_client.service_account` | [ServiceAccountApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/ServiceAccountApi.md)
`kestra_client.triggers` | [TriggersApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/TriggersApi.md)
`kestra_client.users` | [UsersApi](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/UsersApi.md)

## Documentation for Models

Each model has a page under [`docs/`](https://github.com/kestra-io/client-sdk/tree/main/python/python-sdk/docs) named after the class, for
example [`FlowWithSource`](https://github.com/kestra-io/client-sdk/blob/main/python/python-sdk/docs/FlowWithSource.md).

## Documentation for Authorization

<a id="basicAuth"></a>
### basicAuth

HTTP basic authentication: set `username` and `password` on the
`Configuration` (or pass them to `KestraClient`).

<a id="bearerAuth"></a>
### bearerAuth

Bearer token (service-account API token / JWT): `KestraClient(host=..., token=...)`.

## Development

Run the test suite with `pytest`. See
[`AGENTS.md`](https://github.com/kestra-io/client-sdk/blob/main/AGENTS.md) in the
repository root for contribution notes.
