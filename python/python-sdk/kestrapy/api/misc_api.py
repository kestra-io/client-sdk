from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_user import ApiUser
from kestrapy.models.basic_auth_credentials import BasicAuthCredentials
from kestrapy.models.misc_controller_ee_configuration import MiscControllerEEConfiguration
from kestrapy.models.misc_controller_license_info import MiscControllerLicenseInfo
from kestrapy.models.misc_controller_login_configuration import MiscControllerLoginConfiguration
from kestrapy.models.misc_controller_worker_selector_tags import MiscControllerWorkerSelectorTags
from kestrapy.models.setup_configuration import SetupConfiguration
from kestrapy.models.setup_configuration_setup_data import SetupConfigurationSetupData


class MiscApi(BaseApi):
    """Instance configuration, licensing, setup, auth and cluster miscellany."""

    # ---- Configuration ----

    def configuration(self) -> MiscControllerEEConfiguration:
        path = self._superadmin_path("configs")
        return self._json_request("GET", path, MiscControllerEEConfiguration)

    def login_configuration(self) -> MiscControllerLoginConfiguration:
        path = self._superadmin_path("configs", "login")
        return self._json_request("GET", path, MiscControllerLoginConfiguration)

    def auths(self) -> Any:
        path = self._superadmin_path("auths")
        return self._raw_json_request("GET", path)

    def basic_auth_validation_errors(self) -> List[str]:
        path = self._superadmin_path("basicAuthValidationErrors")
        return self._json_list_request("GET", path, str)

    def create_basic_auth(self, tenant: str, credentials: BasicAuthCredentials) -> Any:
        path = self._tenant_path(tenant, "basicAuth")
        return self._raw_json_request("POST", path, body=credentials)

    # ---- Setup ----

    def setup_configuration(self) -> SetupConfiguration:
        path = self._superadmin_path("setup")
        return self._json_request("GET", path, SetupConfiguration)

    def setup_kestra(self, data: SetupConfigurationSetupData) -> ApiUser:
        path = self._superadmin_path("setup")
        return self._json_request("POST", path, ApiUser, body=data)

    # ---- Licensing ----

    def license_info(self) -> MiscControllerLicenseInfo:
        path = self._superadmin_path("license-info")
        return self._json_request("GET", path, MiscControllerLicenseInfo)

    def refresh_license(self) -> None:
        path = self._superadmin_path("license", "refresh")
        self._void_request("GET", path)

    # ---- Reporting / tags (tenant-scoped) ----

    def worker_selector_tags(self, tenant: str) -> MiscControllerWorkerSelectorTags:
        path = self._tenant_path(tenant, "worker-selectors", "tags")
        return self._json_request("GET", path, MiscControllerWorkerSelectorTags)

    def generate_reports(self, tenant: str, date_from: Optional[str] = None) -> bytes:
        path = self._tenant_path(tenant, "stats", "generate-reports")
        params = self._build_query_params(**{"from": date_from})
        return self._download_request("GET", path, params=params)
