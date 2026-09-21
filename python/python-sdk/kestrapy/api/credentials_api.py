from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_test_connection_response import ApiTestConnectionResponse
from kestrapy.models.query_filter import QueryFilter


class CredentialsApi(BaseApi):
    """Tenant-level credentials (`/api/v1/{tenant}/credentials`).

    Guarded by the ``CREDENTIAL`` resource, so every route answers 403 when the
    caller lacks it or the feature is off. Request and response bodies are
    polymorphic (discriminated on ``type``: ``OAUTH2`` | ``GITHUB_APP``), so
    create/update take a free-form body and reads return a decoded dict.
    """

    def list_credentials(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "credentials")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def credential(self, id: str, tenant: str) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "credentials", id)
        return self._raw_json_request("GET", path)

    def create_credential(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "credentials")
        return self._raw_json_request("POST", path, body=body)

    def update_credential(self, id: str, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "credentials", id)
        return self._raw_json_request("PUT", path, body=body)

    def delete_credential(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "credentials", id)
        self._void_request("DELETE", path)

    def test_credential(self, id: str, tenant: str) -> ApiTestConnectionResponse:
        path = self._tenant_path(tenant, "credentials", id, "test")
        return self._json_request("POST", path, ApiTestConnectionResponse)
