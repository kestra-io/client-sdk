from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi


class PluginsApi(BaseApi):
    """Instance-level plugin catalog (`/api/v1/plugins`).

    Exposes the installed plugin catalog: documentation, JSON schemas, icons,
    input types and the OSS auto-install flow. None of these routes are
    tenant-scoped. The install/detect routes are OSS-only (EE answers 403).
    Responses are returned as raw JSON (dict/list) since the catalog payloads
    are dynamic and untyped.
    """

    def list_plugins(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
    ) -> Dict[str, Any]:
        path = self._superadmin_path("plugins")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    def list_plugins_by_subgroups(self) -> List[Dict[str, Any]]:
        path = self._superadmin_path("plugins", "groups", "subgroups")
        return self._raw_json_request("GET", path)

    def plugin_icons(self) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "icons")
        return self._raw_json_request("GET", path)

    def plugin_group_icons(self) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "icons", "groups")
        return self._raw_json_request("GET", path)

    def plugin_icon(self, cls: str) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "icons", cls)
        return self._raw_json_request("GET", path)

    def plugin_icon_svg(self, cls: str) -> str:
        path = self._superadmin_path("plugins", "icons", cls, "icon.svg")
        return self._text_request("GET", path, accept="image/svg+xml")

    def plugin_input_types(self) -> List[Dict[str, Any]]:
        path = self._superadmin_path("plugins", "inputs")
        return self._raw_json_request("GET", path)

    def plugin_input_schema(self, input_type: str) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "inputs", input_type)
        return self._raw_json_request("GET", path)

    def plugin_install_job(self, job_id: str) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "install", job_id)
        return self._raw_json_request("GET", path)

    def plugin_properties(self, schema_type: str) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "properties", schema_type)
        return self._raw_json_request("GET", path)

    def plugin_schema(
        self,
        schema_type: str,
        array_of: Optional[bool] = None,
        include_catalog: Optional[bool] = None,
    ) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "schemas", schema_type)
        params = self._build_query_params(arrayOf=array_of, includeCatalog=include_catalog)
        return self._raw_json_request("GET", path, params=params)

    def plugin_triggers(self) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "triggers")
        return self._raw_json_request("GET", path)

    def plugin_documentation(self, cls: str, all_properties: Optional[bool] = None) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", cls)
        params = self._build_query_params(all=all_properties)
        return self._raw_json_request("GET", path, params=params)

    def plugin_ui(self, group: str, path_segment: str) -> str:
        path = self._superadmin_path("plugins", group, "pluginUi", path_segment)
        return self._text_request("GET", path)

    def plugin_versions(self, cls: str) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", cls, "versions")
        return self._raw_json_request("GET", path)

    def plugin_documentation_for_version(
        self, cls: str, version: str, all_properties: Optional[bool] = None
    ) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", cls, "versions", version)
        params = self._build_query_params(all=all_properties)
        return self._raw_json_request("GET", path, params=params)

    def detect_missing_plugins(self, flow_yaml: str) -> Dict[str, Any]:
        """Parse a flow YAML and map its unregistered task/trigger types to their
        Maven artifacts (OSS only; EE returns 403)."""
        path = self._superadmin_path("plugins", "auto-install", "detect")
        return self._raw_json_request("POST", path, body=flow_yaml, content_type=self.TEXT)

    def install_plugins(self, artifacts: Any) -> Dict[str, Any]:
        """Enqueue installation of the given plugin artifacts and return the
        install job (OSS only; EE returns 403)."""
        path = self._superadmin_path("plugins", "install")
        return self._raw_json_request("POST", path, body=artifacts)

    def plugin_ui_manifest(self, task_with_versions: Any) -> Dict[str, Any]:
        path = self._superadmin_path("plugins", "pluginUiManifest")
        return self._raw_json_request("POST", path, body=task_with_versions)
