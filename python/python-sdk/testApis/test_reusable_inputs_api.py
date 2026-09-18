import pytest

from test_helpers import TENANT, random_id, random_namespace, register_namespace
from kestrapy.exceptions import ConflictException, NotFoundException


def reusable_inputs_source(namespace, block_id, description="shared inputs"):
    return (
        f"id: {block_id}\n"
        f"namespace: {namespace}\n"
        f"description: {description}\n"
        "inputs:\n"
        "  - id: name\n"
        "    type: STRING\n"
        "    defaults: world\n"
        "  - id: count\n"
        "    type: INT\n"
    )


def create_block(client, namespace, block_id, **kwargs):
    return client.reusable_inputs.create_or_update_reusable_inputs(
        namespace, block_id, TENANT, reusable_inputs_source(namespace, block_id, **kwargs)
    )


def test_create_or_update_reusable_inputs(client):
    namespace, block_id = random_namespace(), random_id()

    created = create_block(client, namespace, block_id)

    assert created.id == block_id
    assert created.namespace == namespace
    assert created.description == "shared inputs"
    assert [i.id for i in created.inputs] == ["name", "count"]
    assert created.source == reusable_inputs_source(namespace, block_id)
    assert created.revision == 1
    assert created.last is True
    assert created.deleted is False
    assert created.created is not None


def test_create_or_update_reusable_inputs_fail_if_exists(client):
    namespace, block_id = random_namespace(), random_id()
    create_block(client, namespace, block_id)

    with pytest.raises(ConflictException) as exc_info:
        client.reusable_inputs.create_or_update_reusable_inputs(
            namespace, block_id, TENANT, reusable_inputs_source(namespace, block_id), fail_if_exists=True
        )
    assert exc_info.value.status == 409


def test_reusable_inputs(client):
    namespace, block_id = random_namespace(), random_id()
    create_block(client, namespace, block_id)

    found = client.reusable_inputs.reusable_inputs(namespace, block_id, TENANT)

    assert found.id == block_id
    assert len(found.inputs) == 2


def test_reusable_inputs_resolves_namespace_inheritance(client):
    parent = random_namespace()
    child = register_namespace(f"{parent}.child")
    block_id = random_id()
    create_block(client, parent, block_id)

    inherited = client.reusable_inputs.reusable_inputs(child, block_id, TENANT)
    assert inherited.namespace == parent

    listed = client.reusable_inputs.list_reusable_inputs(child, TENANT)
    assert listed.total == 1
    assert listed.results[0].id == block_id


def test_list_reusable_inputs(client):
    namespace = random_namespace()
    for _ in range(3):
        create_block(client, namespace, random_id())

    all_blocks = client.reusable_inputs.list_reusable_inputs(namespace, TENANT)
    assert all_blocks.total == 3

    first_page = client.reusable_inputs.list_reusable_inputs(namespace, TENANT, page=1, size=2)
    assert first_page.total == 3
    assert len(first_page.results) == 2


def test_list_reusable_inputs_revisions(client):
    namespace, block_id = random_namespace(), random_id()
    create_block(client, namespace, block_id)
    create_block(client, namespace, block_id, description="updated inputs")

    revisions = client.reusable_inputs.list_reusable_inputs_revisions(namespace, block_id, TENANT)
    assert len(revisions) == 2
    assert [r.revision for r in revisions] == [1, 2], "revisions come back oldest first"

    latest = client.reusable_inputs.reusable_inputs(namespace, block_id, TENANT)
    assert latest.description == "updated inputs"
    assert latest.revision == 2
    assert latest.source == reusable_inputs_source(namespace, block_id, description="updated inputs")
    assert latest.last is True

    first = client.reusable_inputs.reusable_inputs(namespace, block_id, TENANT, revision=1)
    assert first.description == "shared inputs"
    assert first.revision == 1
    assert first.last is False, "a pinned older revision is no longer the current one"


def test_delete_reusable_inputs(client):
    namespace, block_id = random_namespace(), random_id()
    create_block(client, namespace, block_id)

    client.reusable_inputs.delete_reusable_inputs(namespace, block_id, TENANT)

    with pytest.raises(NotFoundException):
        client.reusable_inputs.reusable_inputs(namespace, block_id, TENANT)


def test_list_reusable_inputs_namespaces(client):
    namespace, block_id = random_namespace(), random_id()
    create_block(client, namespace, block_id)

    namespaces = client.reusable_inputs.list_reusable_inputs_namespaces(TENANT)

    assert namespace in namespaces
