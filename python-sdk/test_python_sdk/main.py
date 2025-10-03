from kestra_api_client import KestraClient, Configuration

import random
import string

# generate a random flow ID
def generate_random_id(length=8):
    return ''.join(random.choices(string.ascii_lowercase + string.digits, k=length))


tenant_id = "main"

configuration = Configuration()
configuration.host = "http://localhost:8080"
configuration.username = "ycoornaert@kestra.io"
configuration.password = "Root!1234"

kestra_client = KestraClient(configuration)


####################
## Flow tests
####################


res = kestra_client.flows.search_flows(1, 10, tenant_id)

print("Found flows:", len(res.results))

flow = f"""
id: {generate_random_id()}
namespace: {generate_random_id()}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
"""

res = kestra_client.flows.create_flow(tenant_id, flow)

print("Created flow with ID:", res.id)

res = kestra_client.flows.list_distinct_namespaces(tenant=tenant_id)

print("Distinct namespaces size:", len(res))


####################
## Namespace tests
####################

res = kestra_client.namespaces.search_namespaces(1, 10, tenant_id)

print("Namespaces found: ", len(res.results))

####################
## Executions tests
####################

res = kestra_client.executions.search_executions(1, 10, tenant_id)

print("Executions found: ", len(res.results))