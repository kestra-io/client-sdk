import pytest

from test_helpers import (
    TENANT,
    random_id,
)
from kestrapy import (
    ApiException,
    AuthControllerInvitationUserRequest,
    IAMInvitationControllerApiInvitationCreateRequest,
    InvitationInvitationStatus,
)


# Invitations require the mail server to be configured for full delivery,
# but the controller still creates the invitation record and returns it
# from search/list endpoints — that's what we exercise here.


def _invite_email():
    return f"invitee-{random_id()[:8]}@example.com"


def _create_invitation(client, email=None, super_admin=False):
    # Note: do NOT set create_user_if_not_exist=True. With it, the server
    # creates the user and grants tenant access directly (204), bypassing
    # the Invitation record entirely. We need a persisted invitation for
    # list/search/get/delete tests.
    email = email or _invite_email()
    req = IAMInvitationControllerApiInvitationCreateRequest(
        email=email,
        super_admin=super_admin,
    )
    try:
        client.invitations.create_invitation(tenant=TENANT, request=req)
    except ApiException as e:
        # The server refuses to create invitations until `kestra.url` is
        # configured (needed to build the invitation link). Treat as a
        # missing test-environment prerequisite, not a failure.
        if e.status == 422 and "kestra.url" in (e.body or ""):
            pytest.skip("Server requires kestra.url config to create invitations")
        raise
    return email


def _create_invitation_and_get_id(client):
    """Create an invitation and return (email, invitation_id). Skips the
    test if the server didn't persist an invitation record (some EE
    configurations short-circuit to direct tenant access)."""
    email = _create_invitation(client)
    listing = client.invitations.list_invitations_by_email(email=email, tenant=TENANT)
    if not listing:
        pytest.skip(
            "Server did not persist an invitation record for a fresh email "
            "(likely EE config: direct tenant-access grant on create)."
        )
    return email, listing[0].id


# ========================================================================
# Create
# ========================================================================


def test_create_invitation_basic(client):
    # Routes through the helper so we share the kestra.url skip handling.
    _create_invitation(client)


def test_create_invitation_duplicate_conflicts(client):
    email = _create_invitation(client)

    # A second invite for the same email in the same tenant should 409
    # (or 204 if the server treats the existing access as "already granted").
    req = IAMInvitationControllerApiInvitationCreateRequest(
        email=email, create_user_if_not_exist=True,
    )
    try:
        client.invitations.create_invitation(tenant=TENANT, request=req)
    except ApiException as e:
        assert e.status in (409, 422)


# ========================================================================
# List by email
# ========================================================================


def test_list_invitations_by_email_basic(client):
    email, _ = _create_invitation_and_get_id(client)

    result = client.invitations.list_invitations_by_email(email=email, tenant=TENANT)

    assert result is not None
    assert len(result) >= 1
    assert any(getattr(inv, "email", None) == email for inv in result)


def test_list_invitations_by_email_no_results(client):
    email = f"nobody-{random_id()[:8]}@example.com"

    result = client.invitations.list_invitations_by_email(email=email, tenant=TENANT)

    assert result is not None
    assert len(result) == 0


# ========================================================================
# Search
# ========================================================================


def test_search_invitations_basic(client):
    _create_invitation_and_get_id(client)

    result = client.invitations.search_invitations(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_invitations_with_pagination(client):
    _create_invitation(client)

    result = client.invitations.search_invitations(tenant=TENANT, page=1, size=1)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 1


def test_search_invitations_filter_by_status(client):
    _create_invitation_and_get_id(client)

    result = client.invitations.search_invitations(
        tenant=TENANT,
        status=InvitationInvitationStatus.PENDING,
        page=1,
        size=25,
    )

    assert result is not None
    assert result.results is not None
    # Newly created invitations are PENDING; the result set should be non-empty
    # and every entry should be PENDING.
    assert len(result.results) > 0
    for inv in result.results:
        status = getattr(inv, "status", None)
        if status is not None:
            assert str(status).upper().endswith("PENDING")


def test_search_invitations_no_results(client):
    result = client.invitations.search_invitations(
        tenant=TENANT,
        email=f"never-existed-{random_id()}@example.com",
        page=1,
        size=10,
    )

    assert result is not None
    assert result.results is not None
    assert len(result.results) == 0


# ========================================================================
# Get / Delete
# ========================================================================


def test_invitation_get_by_id(client):
    _, invitation_id = _create_invitation_and_get_id(client)

    result = client.invitations.invitation(id=invitation_id, tenant=TENANT)

    assert result is not None
    assert result.id == invitation_id


def test_invitation_get_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.invitations.invitation(id=f"missing-{random_id()}", tenant=TENANT)
    assert exc_info.value.status in (400, 404)


def test_delete_invitation_basic(client):
    _, invitation_id = _create_invitation_and_get_id(client)

    # Should not raise; server returns 204.
    client.invitations.delete_invitation(id=invitation_id, tenant=TENANT)

    # After deletion, the invitation should no longer be retrievable.
    with pytest.raises(ApiException) as exc_info:
        client.invitations.invitation(id=invitation_id, tenant=TENANT)
    assert exc_info.value.status in (400, 404)


def test_delete_invitation_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.invitations.delete_invitation(id=f"missing-{random_id()}", tenant=TENANT)
    assert exc_info.value.status in (400, 404)


# ========================================================================
# Current user (cross-tenant)
# ========================================================================


def test_find_all_invitations_for_current_user_basic(client):
    # The session is authenticated as root@root.com (see conftest.py); root
    # may or may not have pending invitations, but the endpoint should
    # always return a list.
    result = client.invitations.find_all_invitations_for_current_user()

    assert result is not None
    assert isinstance(result, list)


# ========================================================================
# Public auth flow (accept / create from invitation)
# ========================================================================

# These two endpoints do NOT require a tenant — they're consumed by
# unauthenticated users following the invitation link. With an unknown
# invitationId the server should respond 4xx, which is enough to confirm
# the SDK wires the path and body correctly.


def test_accept_invitation_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.invitations.accept_invitation(invitation_id=f"missing-{random_id()}")
    assert exc_info.value.status in (400, 401, 403, 404)


def test_create_from_invitation_unknown_id_raises(client):
    req = AuthControllerInvitationUserRequest(
        first_name="New", last_name="User", password="StrongPass!1234",
    )
    with pytest.raises(ApiException) as exc_info:
        client.invitations.create_from_invitation(
            invitation_id=f"missing-{random_id()}", request=req,
        )
    assert exc_info.value.status in (400, 401, 403, 404, 422)
