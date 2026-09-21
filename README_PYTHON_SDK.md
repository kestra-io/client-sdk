# Python SDK

## History: how the SDK was originally generated (before #237)

> **This SDK is hand-written since #237.** `./generate-sdks.sh` refuses to run
> for it, and the generator apparatus (templates, `.openapi-generator/`
> metadata) has been removed from this repository. Edit the sources under
> `python/python-sdk` directly. The steps below describe how the SDK was
> generated before that change, kept for historical context only. (Doc
> examples are validated by `scripts/validate_doc_examples.py`, run in CI.)

1. The `kestra-ee.yml` was updated as needed with the latest openapi spec changes.
2. The SDK was generated using the (now-removed) `generate-sdks.sh` script, which used the openapi-generator-cli docker image.

3. These changes were applied at generation time, but if there was an error, they were double-checked:
  Then multiples files changes were needed to be done manually in the generated SDK:
   - In the pyproject.toml file, set the following values (you need to replace the current one):
     ```toml
     license = "Apache-2.0"
     requires-python = ">=3.9"
     ```
   - In the `executions_api.py`, delete the following import, this is an wrong generation from Micronaut OpenAPI generator:
     ```python
     from kestrapy.models.list[label] import List[Label]
     ```

  - In the `__init__.py` add the following import, its the custom kestra client that gather all API clients:
     ```python
     from kestrapy.kestra_client import KestraClient as KestraClient
     ```

### More informations (historical)

- SSE methods were injected from templates (now removed)
- Openapi spec was modified during generation through a custom TS script
- KestraClient is manually written to gather all API clients in one client
- Method with Multipart form need an annotation on Kestra side to generate properly the SDK method


## Step to use

The openapi generator will generate 1 Api per controller, so we create a custom Kestra Client that need to be instantiated once for every API.
Use the `from kestrapy import KestraClient` manually written that gather everything in one client.

Then you can create a Configuration, configure it and instantiate the client:
```python
configuration = Configuration()
configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

kestra_client = KestraClient(configuration)
tenant = "main"
```

Then simply use the client to call the API. The snippet below is injected from
`python/python-sdk/testApis/basic_sdk_usage_example.py`, which runs in CI — so
it stays in sync with the SDK. Edit the example there (not this block) and run
`python test-utils/embed_snippets.py --write README_PYTHON_SDK.md`.

<!-- snippet:search-and-create src=python/python-sdk/testApis/basic_sdk_usage_example.py lang=python -->
```python
# List the first page of flows in the tenant.
flows = kestra_client.flows.search_flows(tenant, page=1, size=10)
print(f"Found {len(flows.results)} flows")

# Create a new flow from its YAML source.
flow = dedent(
    """
    id: hello_from_sdk
    namespace: company.team

    tasks:
      - id: hello
        type: io.kestra.plugin.core.log.Log
        message: Hello from the Kestra Python SDK!
    """
)
created = kestra_client.flows.create_flow(tenant, flow)
print(f"Created flow {created.namespace}.{created.id} (revision {created.revision})")
```
<!-- /snippet -->

## Complex queries (AND / OR filters)

Every `*_by_query` / `search_*` endpoint accepts grouped filters. Build them with the `query`
DSL instead of hand-encoding `filters[...]` strings:

```python
from kestrapy import where, and_, or_, eq
from kestrapy import QueryFilterField as F

filters = where(
    and_(
        eq(F.NAMESPACE, "company.team"),
        or_(
            eq(F.STATE, "SUCCESS"),
            eq(F.STATE, "WARNING"),
        ),
    )
)
# filters is a list[QueryFilter] — pass it to the search / *_by_query methods' filters argument.
```

- Helpers: `where`, `and_`, `or_`, `filter_`, `eq`, `not_eq`, `in_`, `not_in`, `contains`,
  `starts_with`, `ends_with`, `regex`, `prefix`, `gt`, `gte`, `lt`, `lte`.
- **Backward compatible:** a plain `list[QueryFilter]` (or `where(and_(...leaves))`) serializes to the
  same flat `filters[field][OP]=value` wire format as before.
- Nesting is **one level deep** (an `and_` containing an `or_`, or vice-versa); deeper nesting raises
  `ValueError`.