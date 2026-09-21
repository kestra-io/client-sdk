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

# ...or a bearer token (API token / JWT)
configuration = Configuration(
    host="http://localhost:8080",
    access_token=os.environ["KESTRA_TOKEN"],
)

kestra_client = KestraClient(configuration)
```

## Errors

API calls raise `kestrapy.rest.ApiException` on non-2xx responses:

```python
from kestrapy.rest import ApiException

try:
    kestra_client.flows.get_flow(tenant, "company.team", "does_not_exist")
except ApiException as e:
    print(f"Kestra API returned {e.status}: {e.reason}")
```

## Development

Run the test suite with `pytest`. See
[`AGENTS.md`](https://github.com/kestra-io/client-sdk/blob/main/AGENTS.md) in the
repository root for contribution notes.
