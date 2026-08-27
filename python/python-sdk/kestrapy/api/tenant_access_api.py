from kestrapy.base_api import BaseApi
from kestrapy.models.iam_tenant_access_controller_api_create_tenant_access_request import IAMTenantAccessControllerApiCreateTenantAccessRequest


class TenantAccessApi(BaseApi):

    def create_tenant_access(
        self,
        tenant: str,
        request: IAMTenantAccessControllerApiCreateTenantAccessRequest,
    ) -> None:
        """Grant a user access to the tenant.

        Users created through POST /api/v1/users exist instance-wide but hold no
        tenant access, and the tenant-scoped IAM endpoints reject them with
        404 "User does not exist" until this is called. The user is identified by
        email, not id.
        """
        path = self._tenant_path(tenant, "tenant-access")
        self._void_request("POST", path, body=request, content_type=self.JSON)
