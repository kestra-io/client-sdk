# Python SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.
2. Generate the SDK using the script `generate-sdks.sh` that uses the openapi-generator-cli docker image.

3.THESE CHANGES ARE DONE AT GENERATION, BUT IF THERE IS AN ERROR, DOUBLE CHECK
  Then multiples files changes are needed to be done manually in the generated SDK:
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

### More informations

- SSE methods are injected from templates
- Openapi spec is modified during generation through a custom TS script
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