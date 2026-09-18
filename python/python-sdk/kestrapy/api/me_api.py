from typing import Any, Dict

from kestrapy.base_api import BaseApi
from kestrapy.models.api_token_list import ApiTokenList
from kestrapy.models.create_api_token_request import CreateApiTokenRequest
from kestrapy.models.create_api_token_response import CreateApiTokenResponse
from kestrapy.models.me_controller_api_user_details_request import (
    MeControllerApiUserDetailsRequest,
)


class MeApi(BaseApi):
    """`/api/v1/me` — endpoints that act on the currently authenticated user.

    None of these paths carry a tenant segment. The profile payload is returned
    as a raw dict (id, instanceOwner, restricted, profile, auths, tenants, ...).
    """

    def current_user(self) -> Dict[str, Any]:
        path = self._superadmin_path("me")
        return self._raw_json_request("GET", path)

    def update_current_user(self, details: MeControllerApiUserDetailsRequest) -> Dict[str, Any]:
        path = self._superadmin_path("me")
        return self._raw_json_request("PATCH", path, body=details)

    def list_api_tokens(self) -> ApiTokenList:
        path = self._superadmin_path("me", "api-tokens")
        return self._json_request("GET", path, ApiTokenList)

    def create_api_token(self, request: CreateApiTokenRequest) -> CreateApiTokenResponse:
        """Mint a new API token for the authenticated user. The full token secret
        is only present in this response."""
        path = self._superadmin_path("me", "api-tokens")
        return self._json_request("POST", path, CreateApiTokenResponse, body=request)

    def delete_api_token(self, token_id: str) -> None:
        path = self._superadmin_path("me", "api-tokens", token_id)
        self._void_request("DELETE", path)
