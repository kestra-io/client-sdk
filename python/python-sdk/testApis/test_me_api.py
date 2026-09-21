"""Tests for the /api/v1/me (current user) SDK surface added for #421."""


from kestrapy.models.create_api_token_request import CreateApiTokenRequest


from test_helpers import gating

_tolerate_gating = gating()


def test_current_user_returns_authenticated_identity(client):
    with _tolerate_gating("current_user"):
        me = client.me.current_user()
    assert isinstance(me, dict)
    # The authenticated user always has an id and an instanceOwner flag.
    assert me.get("id") is not None
    assert "instanceOwner" in me


def test_list_api_tokens_returns_token_list(client):
    with _tolerate_gating("list_api_tokens"):
        result = client.me.list_api_tokens()
    assert result is not None
    # ApiTokenList is a paged envelope: total + results (may be empty).
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_pebble_filters_lists_filters(client):
    with _tolerate_gating("pebble_filters"):
        filters = client.misc.pebble_filters()
    assert isinstance(filters, list)
    # Pebble always ships built-in filters (e.g. "date", "json").
    assert len(filters) > 0
