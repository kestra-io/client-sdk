from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_autocomplete import ApiAutocomplete
from kestrapy.models.api_secret_meta_ee import ApiSecretMetaEE
from kestrapy.models.api_secret_value import ApiSecretValue
from kestrapy.models.namespace import Namespace
from kestrapy.models.namespace_controller_api_inherited_plugin_default_from_namespace import NamespaceControllerApiInheritedPluginDefaultFromNamespace
from kestrapy.models.paged_results_namespace import PagedResultsNamespace


class NamespacesApi(BaseApi):

    # ---- CRUD ----

    def create_namespace(self, tenant: str, namespace: Namespace) -> Namespace:
        path = self._tenant_path(tenant, "namespaces")
        return self._json_request("POST", path, Namespace, body=namespace)

    def namespace(self, id: str, tenant: str) -> Namespace:
        path = self._tenant_path(tenant, "namespaces", id)
        return self._json_request("GET", path, Namespace)

    def update_namespace(self, id: str, tenant: str, namespace: Namespace) -> Namespace:
        path = self._tenant_path(tenant, "namespaces", id)
        return self._json_request("PUT", path, Namespace, body=namespace)

    def delete_namespace(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "namespaces", id)
        self._void_request("DELETE", path)

    # ---- Search & Autocomplete ----

    def search_namespaces(
        self,
        tenant: str,
        q: Optional[str] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        existing: Optional[bool] = None,
    ) -> PagedResultsNamespace:
        path = self._tenant_path(tenant, "namespaces", "search")
        params = list(self._build_query_params(q=q, page=page, size=size, existing=existing).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsNamespace, params=params)

    def autocomplete_namespaces(self, tenant: str, request: ApiAutocomplete) -> List[str]:
        path = self._tenant_path(tenant, "namespaces", "autocomplete")
        return self._json_list_request("POST", path, str, body=request)

    # ---- Secrets ----

    def put_secrets(self, namespace: str, tenant: str, secret_value: ApiSecretValue) -> List[ApiSecretMetaEE]:
        path = self._tenant_path(tenant, "namespaces", namespace, "secrets")
        return self._json_list_request("PUT", path, ApiSecretMetaEE, body=secret_value)

    def patch_secret(self, namespace: str, key: str, tenant: str, meta: ApiSecretMetaEE) -> List[ApiSecretMetaEE]:
        path = self._tenant_path(tenant, "namespaces", namespace, "secrets", key)
        return self._json_list_request("PATCH", path, ApiSecretMetaEE, body=meta)

    def delete_secret(self, namespace: str, key: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "namespaces", namespace, "secrets", key)
        self._void_request("DELETE", path)

    def inherited_secrets(self, namespace: str, tenant: str) -> Dict[str, List[str]]:
        path = self._tenant_path(tenant, "namespaces", namespace, "inherited-secrets")
        return self._raw_json_request("GET", path)

    # ---- Variables ----

    def inherited_variables(self, id: str, tenant: str) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "namespaces", id, "inherited-variables")
        return self._raw_json_request("GET", path)

    # ---- Plugin Defaults ----

    def inherited_plugin_defaults(self, id: str, tenant: str) -> List[NamespaceControllerApiInheritedPluginDefaultFromNamespace]:
        path = self._tenant_path(tenant, "namespaces", id, "inherited-plugindefaults")
        return self._json_list_request("GET", path, NamespaceControllerApiInheritedPluginDefaultFromNamespace)

    def export_plugin_defaults(self, id: str, tenant: str) -> bytes:
        path = self._tenant_path(tenant, "namespaces", id, "plugindefaults", "export")
        return self._download_request("POST", path, accept=self.OCTET)

    def import_plugin_defaults(self, id: str, tenant: str, file_content: Any = None) -> List[str]:
        path = self._tenant_path(tenant, "namespaces", id, "plugindefaults", "import")
        return self._multipart_upload_list("POST", path, str, field_name="fileUpload", file_content=file_content, file_name="fileUpload")
