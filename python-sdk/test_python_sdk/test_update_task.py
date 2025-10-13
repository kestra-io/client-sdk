from kestrapy import KestraClient, Configuration, Task
from pprint import pprint

def kestra_client():
    configuration = Configuration()
    configuration.host = "http://localhost:9902"
    configuration.username = "root@root.com"
    configuration.password = "Root!1234"

    return KestraClient(configuration)

def test_update_task():
    api_client = kestra_client()

    tenant = 'main'
    flow_id = 'update_task'
    namespace = 'company.team'

    body = f"""
    id: {flow_id}
    namespace: {namespace}
    tenantId: main
    
    tasks:
    - id: hello
      type: io.kestra.plugin.core.log.Log
      message: Hello from the SDK1
    
    triggers:
      - id: schedule_trigger
        type: io.kestra.plugin.core.trigger.Schedule
        cron: 0 10 * * *
    """

    api_client.flows.create_flow(tenant, body)
    task_id = 'hello'
    revision = 1
    task = Task(
        id='hello',
        type='io.kestra.plugin.core.log.Log',
        additional_properties={'message': 'Hello from the SDK1!'}
    )
    api_client.flows.update_task(
        namespace=namespace,
        id=flow_id,
        task_id=task_id,
        tenant=tenant,
        task=task,
    )
