from kestrapy import KestraClient, Configuration, ApiException
import json

from kestrapy.exceptions import UnprocessableEntityException


def kestra_client():
    configuration = Configuration()
    configuration.host = "http://localhost:8080"
    configuration.username = "root@root.com"
    configuration.password = "Root!1234"

    return KestraClient(configuration)


api_client = kestra_client()


tenant = 'test'
flow_id = 'sdk-test-flow-abc'
namespace = 'demo'
body = f"""
id: {flow_id}
namespace: {namespace}

labels:
  mylabel: 'def'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK! 👋
"""

try:
    api_response = api_client.flows.create_flow(
        tenant,
        body
    )
    print(api_response)
except UnprocessableEntityException as e:
    print(e)
    if e.status == 422 and "Flow id already exists" in json.loads(e.body).get("message", ""):
        print("Then fetch again to see the label")
        fetched_flow = api_client.flows.get_flow(id = flow_id,namespace = namespace, tenant = tenant, allow_deleted= False, source = False)
        print(fetched_flow)
    else:
        print(e)
