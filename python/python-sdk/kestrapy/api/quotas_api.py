from typing import Any, List

from kestrapy.base_api import BaseApi
from kestrapy.models.quota_limit import QuotaLimit
from kestrapy.models.quota_limit_controller_api_quota_limit_reset_request import QuotaLimitControllerApiQuotaLimitResetRequest


class QuotasApi(BaseApi):

    def search_quota_limits(self, tenant: str) -> List[QuotaLimit]:
        path = self._tenant_path(tenant, "quota-limits")
        return self._json_list_request("GET", path, QuotaLimit)

    def reset_quota_limit(self, tenant: str, request: QuotaLimitControllerApiQuotaLimitResetRequest) -> Any:
        path = self._tenant_path(tenant, "quota-limits", "reset")
        return self._raw_json_request("POST", path, body=request)
