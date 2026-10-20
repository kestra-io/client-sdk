from unittest.mock import MagicMock, patch
import pytest

from kestrapy.kestra_client import KestraClient
from kestrapy.api.kv_api import KVApi


@pytest.fixture
def client_and_mock_session():
    """Fixture providing a KestraClient instance with a mocked HTTP session."""
    with patch("requests.Session") as mock_session_cls:
        mock_session = MagicMock()
        mock_session_cls.return_value = mock_session
        c = KestraClient("http://localhost:8080")
        c._session = mock_session
        yield c, mock_session


def test_kv_property_returns_kv_api(client_and_mock_session):
    """Test that accessing client.kv returns an instance of KVApi."""
    client, _ = client_and_mock_session
    kv = client.kv
    assert isinstance(kv, KVApi)


def test_set_key_value(client_and_mock_session):
    """Test that set_key_value sends a PUT request with correct path and body."""
    client, mock_session = client_and_mock_session

    mock_resp = MagicMock()
    mock_resp.status_code = 200
    mock_session.request.return_value = mock_resp

    client.kv.set_key_value(
        namespace="test-namespace",
        key="test-key",
        tenant="test-tenant",
        body="test-value",
    )

    assert mock_session.request.called
    call_args, call_kwargs = mock_session.request.call_args

    # Verify HTTP method and endpoint path
    assert call_args[0].upper() == "PUT"
    assert "namespaces" in call_args[1]
    assert "test-namespace" in call_args[1]
    assert "test-key" in call_args[1]
    assert call_kwargs.get("data") == "test-value" or call_kwargs.get("body") == "test-value" or call_kwargs.get("content") == "test-value"


def test_get_key_value(client_and_mock_session):
    """Test that key_value sends a GET request to the KV endpoint."""
    client, mock_session = client_and_mock_session

    mock_resp = MagicMock()
    mock_resp.status_code = 200
    mock_resp.json.return_value = {"key": "test-key", "value": "test-val"}
    mock_session.request.return_value = mock_resp

    client.kv.key_value(
        namespace="test-namespace",
        key="test-key",
        tenant="test-tenant",
    )

    assert mock_session.request.called
    call_args, _ = mock_session.request.call_args

    assert call_args[0].upper() == "GET"
    assert "test-namespace" in call_args[1]
    assert "test-key" in call_args[1]