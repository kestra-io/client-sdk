from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.file_attributes import FileAttributes
from kestrapy.models.namespace_file_revision import NamespaceFileRevision


class FilesApi(BaseApi):

    # ── Path builder ────────────────────────────────────────────────

    def _ns_files_path(self, tenant: str, namespace: str, *segments: str) -> str:
        parts = [self._tenant_path(tenant, "namespaces", namespace, "files")]
        for s in segments:
            from urllib.parse import quote
            parts.append(quote(str(s), safe=""))
        return "/".join(parts)

    # ── Directories ─────────────────────────────────────────────────

    def create_namespace_directory(
        self,
        namespace: str,
        tenant: str,
        path: Optional[str] = None,
    ) -> None:
        url = self._ns_files_path(tenant, namespace, "directory")
        params = self._build_query_params(path=path)
        self._void_request("POST", url, params=params)

    def list_namespace_directory_files(
        self,
        namespace: str,
        tenant: str,
        path: Optional[str] = None,
    ) -> List[FileAttributes]:
        url = self._ns_files_path(tenant, namespace, "directory")
        params = self._build_query_params(path=path)
        return self._json_list_request("GET", url, FileAttributes, params=params)

    # ── Files ───────────────────────────────────────────────────────

    def create_namespace_file(
        self,
        namespace: str,
        path: str,
        tenant: str,
        file_content: Optional[bytes] = None,
    ) -> None:
        url = self._ns_files_path(tenant, namespace)
        params = self._build_query_params(path=path)
        if file_content is not None:
            self._multipart_upload("POST", url, params=params,
                                   field_name="fileContent", file_content=file_content,
                                   file_name="file")
        else:
            self._void_request("POST", url, params=params)

    def file_content(
        self,
        namespace: str,
        path: str,
        tenant: str,
        revision: Optional[int] = None,
    ) -> bytes:
        url = self._ns_files_path(tenant, namespace)
        params = self._build_query_params(path=path, revision=revision)
        return self._download_request("GET", url, params=params)

    def file_metadatas(
        self,
        namespace: str,
        tenant: str,
        path: Optional[str] = None,
    ) -> FileAttributes:
        url = self._ns_files_path(tenant, namespace, "stats")
        params = self._build_query_params(path=path)
        return self._json_request("GET", url, FileAttributes, params=params)

    def file_revisions(
        self,
        namespace: str,
        tenant: str,
        path: Optional[str] = None,
    ) -> List[NamespaceFileRevision]:
        url = self._ns_files_path(tenant, namespace, "revisions")
        params = self._build_query_params(path=path)
        return self._json_list_request("GET", url, NamespaceFileRevision, params=params)

    def move_file_directory(
        self,
        namespace: str,
        from_path: str,
        to_path: str,
        tenant: str,
    ) -> None:
        url = self._ns_files_path(tenant, namespace)
        params = self._build_query_params(**{"from": from_path, "to": to_path})
        self._void_request("PUT", url, params=params)

    def delete_file_directory(
        self,
        namespace: str,
        path: str,
        tenant: str,
    ) -> None:
        url = self._ns_files_path(tenant, namespace)
        params = self._build_query_params(path=path)
        self._void_request("DELETE", url, params=params)

    # ── Search & Export ─────────────────────────────────────────────

    def search_namespace_files(
        self,
        namespace: str,
        q: str,
        tenant: str,
    ) -> List[str]:
        url = self._ns_files_path(tenant, namespace, "search")
        params = self._build_query_params(q=q)
        return self._raw_json_request("GET", url, params=params)

    def export_namespace_files(
        self,
        namespace: str,
        tenant: str,
    ) -> bytes:
        url = self._ns_files_path(tenant, namespace, "export")
        return self._download_request("GET", url)
