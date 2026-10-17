from kestrapy import KestraClient


def test_kestra_client_bearer_token_auth():
    """Test that passing a token sets the correct Authorization header."""
    client = KestraClient(host="http://localhost:8080", token="test-secret-token")

    # Verify authorization header
    assert "Authorization" in client._session.headers
    assert client._session.headers["Authorization"] == "Bearer test-secret-token"

    # Verify host trailing slash is stripped
    assert client._base_url == "http://localhost:8080"


def test_kestra_client_context_manager():
    """Test that context manager enters and exits cleanly."""
    with KestraClient(host="http://localhost:8080", token="dummy") as client:
        assert client is not None
        assert client._session is not None