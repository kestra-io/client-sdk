from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.create_security_integration_request import CreateSecurityIntegrationRequest
from kestrapy.models.paged_results_security_integration import PagedResultsSecurityIntegration
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.security_integration import SecurityIntegration


class SecurityIntegrationsApi(BaseApi):
    """Security integrations / SCIM (`/api/v1/{tenant}/security-integrations`).

    The controller requires instance-owner access and the ``FEATURE_SCIM``
    licence feature, so every route answers 403 when the feature is disabled.
    """

    def list_security_integrations(self, tenant: str) -> PagedResultsSecurityIntegration:
        """List every security integration in an envelope ``{total, results}``.
        Deprecated server-side in favour of :meth:`search_security_integrations`."""
        path = self._tenant_path(tenant, "security-integrations")
        return self._json_request("GET", path, PagedResultsSecurityIntegration)

    def search_security_integrations(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsSecurityIntegration:
        path = self._tenant_path(tenant, "security-integrations", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsSecurityIntegration, params=params)

    def security_integration(self, id: str, tenant: str) -> SecurityIntegration:
        path = self._tenant_path(tenant, "security-integrations", id)
        return self._json_request("GET", path, SecurityIntegration)

    def create_security_integration(
        self, tenant: str, body: CreateSecurityIntegrationRequest
    ) -> Dict[str, Any]:
        """Create a security integration. The response carries the SCIM bearer
        token once, at creation — which is not modelled — so a raw dict is
        returned to preserve it."""
        path = self._tenant_path(tenant, "security-integrations")
        return self._raw_json_request("POST", path, body=body)

    def delete_security_integration(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "security-integrations", id)
        self._void_request("DELETE", path)

    def enable_security_integration(self, id: str, tenant: str) -> SecurityIntegration:
        path = self._tenant_path(tenant, "security-integrations", id, "enable")
        return self._json_request("POST", path, SecurityIntegration)

    def disable_security_integration(self, id: str, tenant: str) -> SecurityIntegration:
        path = self._tenant_path(tenant, "security-integrations", id, "disable")
        return self._json_request("POST", path, SecurityIntegration)
