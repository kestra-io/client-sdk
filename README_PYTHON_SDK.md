# Python SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.

   - As of 13/06/25, `the kestra-ee.yml` has been generated and used without modifications.
   - Micronaut OpenAPI version `6.16.2` was used, as of 13/06.25, this has not been committed into the core yet (only modified locally).
2. Generate the SDK using the script `generate-sdks.sh` that uses the openapi-generator-cli docker image.

3. Then multiple files changes are needed to be done manually in the generated SDK:
   - In the pyproject.toml file, set the following values (you need to replace the current one):
     ```toml
     license = "Apache-2.0"
     requires-python = ">=3.9"
     ```
   - In the `executions_api.py`, delete the following import, this is an wrong generation from Micronaut OpenAPI generator:
     ```python
     from kestra_api_client.models.list[label] import List[Label]
     ```

## Step to use

The openapi generator will generate 1 Api per controller, so we create a custom Kestra Client that need to be instantiated once for every API.
Use the `from kestra_api_client import KestraClient` manually written that gather everything in one client.

Then you can create a Configuration, configure it and instantiate the client:
```python
configuration = Configuration()
configuration.host = "http://localhost:8080"
configuration.username = "root@root.com"
configuration.password = "Root!1234"

kestra_client = KestraClient(configuration)
```

Then simply use the client to call the API:

```python
res = kestra_client.flows.search_flows(1, 10, tenant_id)

print("Found flows:", len(res.results))
```