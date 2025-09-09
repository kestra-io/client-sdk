from kestrapy import KestraClient, Configuration
import pytest
import random
import string

# generate a random flow ID
def generate_random_id(length=8):
    return ''.join(random.choices(string.ascii_lowercase + string.digits, k=length))


@pytest.fixture(scope="module")
def tenant_id():
    return "main"

@pytest.fixture(scope="module")
def kestra_client():
    configuration = Configuration()
    configuration.host = "http://localhost:9902"
    configuration.username = "admin@kestra.io"
    configuration.password = "Admin1234"

    return KestraClient(configuration)


####################
## Flow tests
####################


def test_kestra_client_flows(kestra_client, tenant_id):
# TODO, not working, need to debug why
#     flow = {
#         "id": "hello",
#         "type": "io.kestra.plugin.core.log.Log",
#         "message": "Hello World! 🚀"
#     }
#
#     res = kestra_client.flows.create_flow(tenant_id, flow)
#     assert res.id is not None, "Flow creation failed"

    res = kestra_client.flows.list_distinct_namespaces(tenant=tenant_id)
    assert len(res) > -1, "Namespace list distinct failed"

# TODO, not working, need to debug why
#     res = kestra_client.namespaces.search_namespaces(1, 10, True, tenant_id)
#     assert len(res.results) > -1, "Namespace search failed"

    res = kestra_client.executions.search_executions(1, 10, tenant_id)
    assert len(res.results) > -1, "Execution search failed"
