import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
)
from kestrapy import (
    BlueprintControllerApiBlueprintItemWithSource,
    BlueprintControllerFlowBlueprintCreateOrUpdate,
    BlueprintControllerKind,
    BlueprintControllerUseBlueprintTemplateRequest,
    ApiException,
)


# ========================================================================
# Community Blueprints
# ========================================================================


def _community_search(client, **kwargs):
    """Search community blueprints, skipping when the upstream is unreachable.

    The /blueprints/community/* endpoints proxy to the external api.kestra.io.
    When CI can't reach it the server answers 5xx (observed: 502 Bad Gateway).
    That's an infra condition, not an SDK fault, so skip rather than fail —
    matching how test_blueprint_source_basic and the internal-blueprint tests
    already treat unavailable endpoints.
    """
    try:
        return client.blueprints.search_blueprints(**kwargs)
    except ApiException as e:
        if e.status in (502, 503, 504):
            pytest.skip(f"community blueprints upstream unavailable: {e.status}")
        raise


def test_search_blueprints_flow(client):
    result = _community_search(
        client, kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=5
    )

    assert result is not None
    assert result.results is not None


def test_search_blueprints_with_query(client):
    result = _community_search(
        client, kind=BlueprintControllerKind.FLOW, tenant=TENANT, q="hello", page=1, size=5
    )

    assert result is not None


def test_search_blueprints_with_tags(client):
    all_results = _community_search(
        client, kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
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


@pytest.mark.xfail(
    reason="kestra-ee 2.0 returns no tags for internal blueprints, so the "
    "tag-filtered search yields an empty list",
    strict=False,
)
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
    search = _community_search(
        client, kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
    )

    if search.results and len(search.results) > 0:
        bp_id = search.results[0].id

        result = client.blueprints.blueprint(
            id=bp_id, kind=BlueprintControllerKind.FLOW, tenant=TENANT
        )

        assert result is not None
        assert result.id == bp_id


def test_blueprint_graph_basic(client):
    search = _community_search(
        client, kind=BlueprintControllerKind.FLOW, tenant=TENANT, page=1, size=1
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


# ========================================================================
# Internal/custom blueprints (deprecated CRUD path: /blueprints/custom)
# ========================================================================


def _internal_blueprint_request(title=None):
    return BlueprintControllerApiBlueprintItemWithSource(
        title=title or f"int-bp-{random_id()}",
        description="internal blueprint test",
        source=log_flow_yaml(random_id(), random_id()),
        tags=[],
        included_tasks=[],
        kind=BlueprintControllerKind.FLOW,
    )


def test_create_internal_blueprints_basic(client):
    request = _internal_blueprint_request()

    try:
        created = client.blueprints.create_internal_blueprints(tenant=TENANT, request=request)
    except ApiException as e:
        # Endpoint is marked deprecated and may be gated behind a feature
        # flag in some EE configs — accept the standard "feature unavailable"
        # responses without failing.
        if e.status in (404, 405, 501):
            pytest.skip(f"Internal blueprint create not available: {e.status}")
        raise

    assert created is not None
    assert created.title == request.title


def test_internal_blueprint_get_by_id(client):
    try:
        created = client.blueprints.create_internal_blueprints(
            tenant=TENANT, request=_internal_blueprint_request(),
        )
    except ApiException as e:
        if e.status in (404, 405, 501):
            pytest.skip(f"Internal blueprint create not available: {e.status}")
        raise

    result = client.blueprints.internal_blueprint(id=created.id, tenant=TENANT)

    assert result is not None
    assert result.id == created.id


def test_internal_blueprint_flow_source(client):
    try:
        created = client.blueprints.create_internal_blueprints(
            tenant=TENANT, request=_internal_blueprint_request(),
        )
    except ApiException as e:
        if e.status in (404, 405, 501):
            pytest.skip(f"Internal blueprint create not available: {e.status}")
        raise

    try:
        source = client.blueprints.internal_blueprint_flow(id=created.id, tenant=TENANT)
    except ApiException as e:
        # The source endpoint has stricter ACLs than the others on the
        # custom-blueprints surface and may 403 in some EE configs even
        # when the create path succeeded.
        if e.status in (403, 404, 405, 501):
            pytest.skip(f"Internal blueprint source not available: {e.status}")
        raise

    assert source is not None
    assert len(source) > 0


def test_update_internal_blueprints_basic(client):
    try:
        created = client.blueprints.create_internal_blueprints(
            tenant=TENANT, request=_internal_blueprint_request(title=f"before-{random_id()}"),
        )
    except ApiException as e:
        if e.status in (404, 405, 501):
            pytest.skip(f"Internal blueprint create not available: {e.status}")
        raise

    updated_request = _internal_blueprint_request(title=f"after-{random_id()}")
    result = client.blueprints.update_internal_blueprints(
        id=created.id, tenant=TENANT, request=updated_request,
    )

    assert result is not None


def test_delete_internal_blueprints_basic(client):
    try:
        created = client.blueprints.create_internal_blueprints(
            tenant=TENANT, request=_internal_blueprint_request(),
        )
    except ApiException as e:
        if e.status in (404, 405, 501):
            pytest.skip(f"Internal blueprint create not available: {e.status}")
        raise

    # Should not raise
    client.blueprints.delete_internal_blueprints(id=created.id, tenant=TENANT)

    # Subsequent fetch should 4xx
    with pytest.raises(ApiException) as exc_info:
        client.blueprints.internal_blueprint(id=created.id, tenant=TENANT)
    assert exc_info.value.status in (400, 404)
