import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
)
from kestrapy import (
    BlueprintControllerFlowBlueprintCreateOrUpdate,
    BlueprintControllerKind,
    BlueprintControllerUseBlueprintTemplateRequest,
    ApiException,
)


# ========================================================================
# Community Blueprints
# ========================================================================


def test_search_blueprints_flow(client):
    result = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=5
    )

    assert result is not None
    assert result.results is not None


def test_search_blueprints_with_query(client):
    result = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, q="hello", page=1, size=5
    )

    assert result is not None


def test_search_blueprints_with_sort(client):
    result = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW,
        tenant=TENANT,
        sort="title:asc",
        page=1,
        size=10,
    )

    assert result is not None
    assert result.results is not None
    if len(result.results) >= 2:
        first = result.results[0].title
        second = result.results[1].title
        assert first.lower() <= second.lower()


def test_search_blueprints_with_tags(client):
    all_results = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
    )

    if (
        all_results.results
        and len(all_results.results) > 0
        and all_results.results[0].tags
        and len(all_results.results[0].tags) > 0
    ):
        tag = all_results.results[0].tags[0]

        result = client.blueprints.search_blueprints(
            kind=BlueprintControllerKind.FLOW,
            tenant=TENANT,
            tags=[tag],
            page=1,
            size=10,
        )

        assert len(result.results) > 0
        for bp in result.results:
            assert tag in bp.tags


# ========================================================================
# Flow Blueprints
# ========================================================================


def test_create_flow_blueprint_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"test-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
        description="Test blueprint",
    )

    result = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    assert result is not None
    assert result.id is not None and result.id != ""


def test_flow_blueprint_by_id_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"get-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    result = client.blueprints.flow_blueprint_by_id(id=created.id, tenant=TENANT)

    assert result is not None
    assert result.id == created.id


def test_update_flow_blueprint_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"update-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    new_title = f"updated-bp-{random_id()}"
    update = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=new_title,
        source=log_flow_yaml(random_id(), random_id()),
    )

    updated = client.blueprints.update_flow_blueprint(
        id=created.id, tenant=TENANT, request=update
    )

    assert updated.title == new_title


def test_delete_flow_blueprints_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"delete-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    # Should not raise
    client.blueprints.delete_flow_blueprints(id=created.id, tenant=TENANT)


# ========================================================================
# Internal/Custom Blueprints
# ========================================================================


def test_search_internal_blueprints_with_sort(client):
    title1 = f"aaa-bp-{random_id()}"
    title2 = f"zzz-bp-{random_id()}"
    client.blueprints.create_flow_blueprint(
        tenant=TENANT,
        request=BlueprintControllerFlowBlueprintCreateOrUpdate(
            title=title2, source=log_flow_yaml(random_id(), random_id())
        ),
    )
    client.blueprints.create_flow_blueprint(
        tenant=TENANT,
        request=BlueprintControllerFlowBlueprintCreateOrUpdate(
            title=title1, source=log_flow_yaml(random_id(), random_id())
        ),
    )

    result = client.blueprints.search_internal_blueprints(
        tenant=TENANT, sort="title:asc", page=1, size=100
    )

    assert len(result.results) >= 2
    titles = [bp.title for bp in result.results]
    idx1 = titles.index(title1)
    idx2 = titles.index(title2)
    assert idx1 >= 0
    assert idx2 > idx1


def test_search_internal_blueprints_with_tags(client):
    tag = f"sdktest{random_id()[:8]}"
    client.blueprints.create_flow_blueprint(
        tenant=TENANT,
        request=BlueprintControllerFlowBlueprintCreateOrUpdate(
            title=f"tagged-bp-{random_id()}",
            source=log_flow_yaml(random_id(), random_id()),
            tags=[tag],
        ),
    )
    client.blueprints.create_flow_blueprint(
        tenant=TENANT,
        request=BlueprintControllerFlowBlueprintCreateOrUpdate(
            title=f"untagged-bp-{random_id()}",
            source=log_flow_yaml(random_id(), random_id()),
        ),
    )

    result = client.blueprints.search_internal_blueprints(
        tenant=TENANT, tags=[tag], page=1, size=10
    )

    assert len(result.results) > 0
    for bp in result.results:
        assert tag in bp.tags


def test_search_internal_blueprints_with_source(client):
    client.blueprints.create_flow_blueprint(
        tenant=TENANT,
        request=BlueprintControllerFlowBlueprintCreateOrUpdate(
            title=f"source-bp-{random_id()}",
            source=log_flow_yaml(random_id(), random_id()),
        ),
    )

    result = client.blueprints.search_internal_blueprints(
        tenant=TENANT, page=1, size=10, source=True
    )

    assert result is not None
    assert result.results is not None


def test_search_internal_blueprints_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"internal-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
        description="Internal blueprint for search test",
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    result = client.blueprints.search_internal_blueprints(
        tenant=TENANT, q=created.title, page=1, size=10
    )

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


# ========================================================================
# Community blueprint details
# ========================================================================


def test_blueprint_basic(client):
    search = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
    )

    if search.results and len(search.results) > 0:
        bp_id = search.results[0].id

        result = client.blueprints.blueprint(
            id=bp_id, kind=BlueprintControllerKind.FLOW, tenant=TENANT
        )

        assert result is not None
        assert result.id == bp_id


def test_blueprint_graph_basic(client):
    search = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
    )

    if search.results and len(search.results) > 0:
        bp_id = search.results[0].id

        result = client.blueprints.blueprint_graph(
            id=bp_id, kind=BlueprintControllerKind.FLOW, tenant=TENANT
        )

        assert result is not None


@pytest.mark.skip(reason="Community blueprint source requires external access")
def test_blueprint_source_basic(client):
    search = client.blueprints.search_blueprints(
        kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
    )

    if search.results and len(search.results) > 0:
        bp_id = search.results[0].id

        result = client.blueprints.blueprint_source(
            id=bp_id, kind=BlueprintControllerKind.FLOW, tenant=TENANT
        )

        assert result is not None
        assert len(result) > 0


# ========================================================================
# Use template
# ========================================================================


def test_use_blueprint_template_not_template(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"use-tpl-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    use_request = BlueprintControllerUseBlueprintTemplateRequest()

    # Non-template blueprints cannot be used as templates -> 422
    with pytest.raises(ApiException):
        client.blueprints.use_blueprint_template(
            id=created.id, tenant=TENANT, request=use_request
        )


# ========================================================================
# flowBlueprint (singular path)
# ========================================================================


def test_flow_blueprint_basic(client):
    request = BlueprintControllerFlowBlueprintCreateOrUpdate(
        title=f"flow-bp-{random_id()}",
        source=log_flow_yaml(random_id(), random_id()),
    )

    created = client.blueprints.create_flow_blueprint(tenant=TENANT, request=request)

    result = client.blueprints.flow_blueprint(id=created.id, tenant=TENANT)

    assert result is not None
    assert result.id == created.id
