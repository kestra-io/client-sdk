from kestrapy import KestraClient, Configuration

def kestra_client():
    configuration = Configuration()
    configuration.host = "http://localhost:9902"
    configuration.username = "root@root.com"
    configuration.password = "Root!1234"

    return KestraClient(configuration)

def test_execute_flow():
    kestra = kestra_client()


    tenant = 'main'
    flow_id = 'create-execution'
    namespace = 'main'
    body = f"""
    id: {flow_id}
    namespace: {namespace}
    
    tasks:
      - id: hello
        type: io.kestra.plugin.core.log.Log
        message: Hello from the SDK! 👋
      - id: hello4
        type: io.kestra.plugin.core.log.Log
        message: Hello from the SDK! 👋
      - id: hello5
        type: io.kestra.plugin.core.log.Log
        message: Hello from the SDK! 👋
      - id: hello6
        type: io.kestra.plugin.core.log.Log
        message: Hello from the SDK! 👋
      - id: hello3
        type: io.kestra.plugin.core.log.Log
        message: Bye from the SDK! 👋
    """

    try:
        flow_deleted = kestra.flows.delete_flow(
            id=flow_id,
            namespace=namespace,
            tenant=tenant,
        )
    except:
        print("Flow probably does not exist, continuing...")

    flow_created = kestra.flows.create_flow(
        tenant,
        body
    )
    print("Flow created")

    execution_created = kestra.executions.create_execution(
        namespace=namespace,
        id=flow_id,
        wait=False,
        tenant=tenant
    )

    execution_id = execution_created.id

    print(f"Created execution: {execution_id}")

    execution_fetched = kestra.executions.get_execution(
        tenant=tenant,
        execution_id=execution_id

    )
    print(f"Fetched execution: {execution_fetched.id}")

    print("execution created, following it")

    following_execution = kestra.executions.follow_execution_sse(
        execution_id=execution_id,
        tenant=tenant
    )

    print(f"\n--- Starting to follow execution ID: {execution_created.id} ---\n")
    try:
        for event in following_execution:
            print(f"\nReceived an event\n")

    except Exception as e:
        print(f"An error occurred while consuming the SSE stream: {e}")
    finally:
        print("--- SSE Stream Consumption Finished ---")


    print("Replay execution")
    replayed_execution = kestra.executions.replay_execution(
        tenant=tenant,
        execution_id=execution_id
    )

    print(f"Replayed execution: {replayed_execution.id}")


    print("Search execution by flow id")
    search_execution = kestra.executions.search_executions_by_flow_id(
        tenant=tenant,
        namespace=namespace,
        flow_id=flow_id,
        page=1,
        size=10
    )

    print(f"Search execution found: {search_execution.total} executions")
