"""Basic, runnable usage example for the Kestra Python SDK.

The region between the `region:`/`endregion` markers below is the *single
source of truth* for the usage snippet in `README_PYTHON_SDK.md`: it is
injected verbatim by `test-utils/embed_snippets.py` and exercised against a
live Kestra by `test_basic_sdk_usage_example.py`. Keeping the README snippet
identical to tested code is what stops the docs from drifting (issue #144), so
edit the example here — never the README block — and re-run the injector.

`kestra_client` and `tenant` are provided by the caller; the README shows how
to build the client just above the injected block.
"""
from textwrap import dedent

from kestrapy import KestraClient


def search_and_create_flow(kestra_client: KestraClient, tenant: str):
    # region:search-and-create
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
    # endregion
    return created
