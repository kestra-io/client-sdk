from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.instance_controller_api_active_service_list import InstanceControllerApiActiveServiceList
from kestrapy.models.instance_controller_api_plugin_artifact_list_plugin_artifact import InstanceControllerApiPluginArtifactListPluginArtifact
from kestrapy.models.instance_controller_api_plugin_artifact_list_plugin_resolution_result import InstanceControllerApiPluginArtifactListPluginResolutionResult
from kestrapy.models.instance_controller_api_plugin_version_details import InstanceControllerApiPluginVersionDetails
from kestrapy.models.instance_controller_api_plugin_versions import InstanceControllerApiPluginVersions
from kestrapy.models.instance_controller_api_service_instance import InstanceControllerApiServiceInstance
from kestrapy.models.maintenance_status_response import MaintenanceStatusResponse
from kestrapy.models.paged_results_instance_controller_api_plugin_artifact import PagedResultsInstanceControllerApiPluginArtifact
from kestrapy.models.paged_results_instance_controller_api_service_instance import PagedResultsInstanceControllerApiServiceInstance
from kestrapy.models.plugin_artifact import PluginArtifact
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.service_instance import ServiceInstance
from kestrapy.models.worker_credential_controller_api_worker_credential import WorkerCredentialControllerApiWorkerCredential
from kestrapy.models.worker_credential_controller_api_worker_list import WorkerCredentialControllerApiWorkerList


class InstanceApi(BaseApi):
    """Instance-wide administration (`/api/v1/instance`). Instance-owner-only.

    Covers running services, maintenance mode, versioned-plugin management,
    worker credentials and the cross-tenant MCP-server listing.
    """


    # ---- Services ----

    def search_services(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsInstanceControllerApiServiceInstance:
        path = self._superadmin_path("instance", "services", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsInstanceControllerApiServiceInstance, params=params)

    def active_services(self) -> InstanceControllerApiActiveServiceList:
        path = self._superadmin_path("instance", "services", "active")
        return self._json_request("GET", path, InstanceControllerApiActiveServiceList)

    def service(self, id: str) -> InstanceControllerApiServiceInstance:
        path = self._superadmin_path("instance", "services", id)
        return self._json_request("GET", path, InstanceControllerApiServiceInstance)

    # ---- Maintenance ----

    def enter_maintenance(self) -> Any:
        path = self._superadmin_path("instance", "maintenance", "enter")
        return self._raw_json_request("POST", path)

    def exit_maintenance(self) -> Any:
        path = self._superadmin_path("instance", "maintenance", "exit")
        return self._raw_json_request("POST", path)

    def maintenance_status(self) -> MaintenanceStatusResponse:
        path = self._superadmin_path("instance", "maintenance", "status")
        return self._json_request("GET", path, MaintenanceStatusResponse)

    # ---- Versioned plugins ----

    def list_available_versioned_plugins(self) -> Any:
        path = self._superadmin_path("instance", "versioned-plugins", "available")
        return self._raw_json_request("GET", path)

    def list_available_versioned_plugins_for_storage(self) -> Any:
        path = self._superadmin_path("instance", "versioned-plugins", "available", "storages")
        return self._raw_json_request("GET", path)

    def list_available_versioned_plugins_for_secret_manager(self) -> Any:
        path = self._superadmin_path("instance", "versioned-plugins", "available", "secrets-managers")
        return self._raw_json_request("GET", path)

    def list_versioned_plugins(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsInstanceControllerApiPluginArtifact:
        path = self._superadmin_path("instance", "versioned-plugins")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsInstanceControllerApiPluginArtifact, params=params)

    def versioned_plugin_details(self, group_id: str, artifact_id: str) -> InstanceControllerApiPluginVersions:
        path = self._superadmin_path("instance", "versioned-plugins", group_id, artifact_id)
        return self._json_request("GET", path, InstanceControllerApiPluginVersions)

    def versioned_plugin_icon(self, group_id: str, artifact_id: str) -> bytes:
        path = self._superadmin_path("instance", "versioned-plugins", group_id, artifact_id, "icon.svg")
        return self._download_request("GET", path, accept="image/svg+xml")

    def versioned_plugin_details_for_version(self, group_id: str, artifact_id: str, version: str) -> InstanceControllerApiPluginVersionDetails:
        path = self._superadmin_path("instance", "versioned-plugins", group_id, artifact_id, version)
        return self._json_request("GET", path, InstanceControllerApiPluginVersionDetails)

    def versioned_plugin_release_notes(self, group_id: str, artifact_id: str) -> str:
        path = self._superadmin_path("instance", "versioned-plugins", group_id, artifact_id, "release-notes")
        return self._text_request("GET", path)

    def resolve_versioned_plugins(self, artifacts: List[PluginArtifact]) -> InstanceControllerApiPluginArtifactListPluginResolutionResult:
        path = self._superadmin_path("instance", "versioned-plugins", "resolve")
        return self._json_request("POST", path, InstanceControllerApiPluginArtifactListPluginResolutionResult, body=artifacts)

    def install_versioned_plugins(self, artifacts: List[PluginArtifact]) -> InstanceControllerApiPluginArtifactListPluginArtifact:
        path = self._superadmin_path("instance", "versioned-plugins", "install")
        return self._json_request("POST", path, InstanceControllerApiPluginArtifactListPluginArtifact, body=artifacts)

    def upload_versioned_plugin(self, file_content: Any, file_name: str = "plugin.jar") -> Optional[PluginArtifact]:
        path = self._superadmin_path("instance", "versioned-plugins", "upload")
        return self._multipart_upload("POST", path, PluginArtifact, file_content=file_content, file_name=file_name)

    def uninstall_versioned_plugins(self, artifacts: List[PluginArtifact]) -> InstanceControllerApiPluginArtifactListPluginArtifact:
        path = self._superadmin_path("instance", "versioned-plugins", "uninstall")
        return self._json_request("DELETE", path, InstanceControllerApiPluginArtifactListPluginArtifact, body=artifacts)

    # ---- MCP servers (cross-tenant) ----

    def list_all_mcp_servers(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
    ) -> Any:
        path = self._superadmin_path("instance", "mcp-servers")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    # ---- Worker credentials ----

    def list_worker_credentials(self) -> WorkerCredentialControllerApiWorkerList:
        path = self._superadmin_path("instance", "workers", "credentials")
        return self._json_request("GET", path, WorkerCredentialControllerApiWorkerList)

    def worker_credential(self, id: str) -> WorkerCredentialControllerApiWorkerCredential:
        path = self._superadmin_path("instance", "workers", "credentials", id)
        return self._json_request("GET", path, WorkerCredentialControllerApiWorkerCredential)

    def revoke_worker_credential(self, id: str) -> WorkerCredentialControllerApiWorkerCredential:
        path = self._superadmin_path("instance", "workers", "credentials", id, "revoke")
        return self._json_request("POST", path, WorkerCredentialControllerApiWorkerCredential)
