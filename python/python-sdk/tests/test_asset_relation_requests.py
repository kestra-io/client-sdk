"""Offline tests: the asset relation endpoints send enum query params as their plain
string values, with ``kinds`` repeated once per kind. The outgoing request is captured
before it leaves the client.
"""
import json

import pytest

from kestrapy import KestraClient
from kestrapy.models.assets_controller_api_asset import AssetsControllerApiAsset
from kestrapy.models.assets_controller_api_parent_request import AssetsControllerApiParentRequest
from kestrapy.models.relation_direction import RelationDirection
from kestrapy.models.relation_kind import RelationKind


class _Captured(Exception):
    pass


def _capturing_client(captured):
    client = KestraClient(host="http://localhost:1", token="unused")

    def fake_request(method, url, **kwargs):
        captured["method"] = method
        captured["url"] = url
        captured.update(kwargs)
        raise _Captured()

    client.assets._session.request = fake_request
    return client


def test_asset_dependencies_sends_kinds_as_repeated_string_params():
    captured = {}
    client = _capturing_client(captured)

    with pytest.raises(_Captured):
        client.assets.asset_dependencies(
            "a1", "main", kinds=[RelationKind.UPSTREAM_OF, "RELATED"], expand_all=True, hub_cursor="c1",
        )

    assert captured["method"] == "GET"
    assert captured["url"].endswith("/api/v1/main/assets/a1/dependencies")
    assert sorted(captured["params"]) == sorted([
        ("expandAll", "true"),
        ("hubCursor", "c1"),
        ("kinds", "UPSTREAM_OF"),
        ("kinds", "RELATED"),
    ])
    assert all(type(v) is str for _, v in captured["params"])


def test_flow_asset_dependencies_targets_the_flow_route():
    captured = {}
    client = _capturing_client(captured)

    with pytest.raises(_Captured):
        client.assets.flow_asset_dependencies("io.kestra", "f1", "main", kinds=[RelationKind.PRODUCES])

    assert captured["url"].endswith("/api/v1/main/flows/io.kestra/f1/asset-dependencies")
    assert captured["params"] == [("kinds", "PRODUCES")]
    assert type(captured["params"][0][1]) is str


def test_asset_relations_sends_kind_and_direction_values():
    captured = {}
    client = _capturing_client(captured)

    with pytest.raises(_Captured):
        client.assets.asset_relations(
            "a1", "main", kind=RelationKind.UPSTREAM_OF, direction=RelationDirection.OUTBOUND, size=5,
        )

    assert captured["url"].endswith("/api/v1/main/assets/a1/relations")
    assert captured["params"] == {"kind": "UPSTREAM_OF", "direction": "OUTBOUND", "size": 5}
    assert type(captured["params"]["kind"]) is str
    assert type(captured["params"]["direction"]) is str


def test_api_asset_decodes_part_of():
    asset = AssetsControllerApiAsset.from_dict({"id": "child", "partOf": {"id": "parent", "role": "primary"}})

    assert asset.part_of.id == "parent"
    assert asset.part_of.role == "primary"
    assert asset.to_dict()["partOf"]["id"] == "parent"


def test_set_asset_parent_sends_parent_id_body():
    captured = {}
    client = _capturing_client(captured)

    with pytest.raises(_Captured):
        client.assets.set_asset_parent("child", "main", AssetsControllerApiParentRequest(parent_id="parent"))

    assert captured["method"] == "PUT"
    assert captured["url"].endswith("/api/v1/main/assets/child/parent")
    assert json.loads(captured["data"]) == {"parentId": "parent"}
