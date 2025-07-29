# Python SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` if necessary with latest openspec api changes.

   - As of 29/07/25, `the kestra-ee.yml` has been generated and used without modifications.
   - Micronaut OpenAPI version `6.17.3`
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
     from kestra_api_client.models.list[label] import List[Label]
     ```

  - In the `__init__.py` add the following import, its the custom kestra client that gather all API clients:
     ```python
     from kestra_api_client.kestra_client import KestraClient as KestraClient
     ```
  - In the `task.py`, delete the following part, from the type validator:
      ```python
              if not re.match(r"\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*(\.\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*)*", value):
            raise ValueError(r"must validate the regular expression /\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*(\.\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*)*/")
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