from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.query_filter import QueryFilter


class AuditLogsApi(BaseApi):
    """Audit logs (`/api/v1/{tenant}/auditlogs` and the instance-owner
    cross-tenant variants under `/api/v1/auditlogs`).

    The controller is gated by the ``AUDITLOG`` resource plus a licence feature,
    so routes answer 403 otherwise.
    """

    def search_audit_logs(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Dict[str, Any]:
        """A page of a tenant's audit log. GET /api/v1/{tenant}/auditlogs/search."""
        path = self._tenant_path(tenant, "auditlogs", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def search_all_audit_logs(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Dict[str, Any]:
        """A page of the audit log across every tenant (instance-owner only).
        GET /api/v1/auditlogs/search."""
        path = self._superadmin_path("auditlogs", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def export_audit_logs(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None
    ) -> str:
        """Stream a tenant's audit log as CSV.
        GET /api/v1/{tenant}/auditlogs/export."""
        path = self._tenant_path(tenant, "auditlogs", "export")
        params = []
        self._append_filter_params(params, filters)
        return self._text_request("GET", path, params=params, accept=self.CSV)

    def export_all_audit_logs(
        self, filters: Optional[List[QueryFilter]] = None
    ) -> str:
        """Stream the cross-tenant audit log as CSV (instance-owner only).
        GET /api/v1/auditlogs/export."""
        path = self._superadmin_path("auditlogs", "export")
        params = []
        self._append_filter_params(params, filters)
        return self._text_request("GET", path, params=params, accept=self.CSV)

    def audit_log_diff(
        self, id: str, tenant: str, previous_id: Optional[str] = None
    ) -> Dict[str, Any]:
        """The before/after diff captured by an audit-log entry.
        GET /api/v1/{tenant}/auditlogs/{id}/diff."""
        path = self._tenant_path(tenant, "auditlogs", id, "diff")
        params = self._build_query_params(previousId=previous_id)
        return self._raw_json_request("GET", path, params=params)

    def global_audit_log_diff(
        self, id: str, previous_id: Optional[str] = None
    ) -> Dict[str, Any]:
        """The diff for a global (non-tenant) resource audit entry
        (instance-owner only). GET /api/v1/auditlogs/{id}/diff."""
        path = self._superadmin_path("auditlogs", id, "diff")
        params = self._build_query_params(previousId=previous_id)
        return self._raw_json_request("GET", path, params=params)

    def find_audit_log(
        self, tenant: str, body: Dict[str, Any]
    ) -> Dict[str, Any]:
        """Find a single audit-log entry matching a resource/action/detail query.
        ``body`` is a FindRequest ({resource, type?, detail}).
        POST /api/v1/{tenant}/auditlogs/find."""
        path = self._tenant_path(tenant, "auditlogs", "find")
        return self._raw_json_request("POST", path, body=body)

    def audit_log_history(
        self, detail_id: str, tenant: str
    ) -> List[Dict[str, Any]]:
        """The audit-log entries recorded for a single resource id.
        GET /api/v1/{tenant}/auditlogs/history/{detailId}."""
        path = self._tenant_path(tenant, "auditlogs", "history", detail_id)
        return self._raw_json_request("GET", path)
