import json
import typing
from datetime import date, datetime
from typing import Any, Dict, Generator, List, Optional, Type, TypeVar, Union, get_args, get_origin
from urllib.parse import quote

import requests
import sseclient
from pydantic import ValidationError


def _json_default(obj: Any) -> Any:
    if isinstance(obj, datetime):
        return obj.isoformat().replace("+00:00", "Z")
    if isinstance(obj, date):
        return obj.isoformat()
    raise TypeError(f"Object of type {type(obj).__name__} is not JSON serializable")

from kestrapy.exceptions import (
    ApiException,
    BadRequestException,
    ConflictException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
    UnauthorizedException,
    UnprocessableEntityException,
)

T = TypeVar('T')


class BaseApi:
    JSON = "application/json"
    YAML = "application/x-yaml"
    # Blueprint source endpoints declare `application/yaml` (no "x-" prefix) as
    # their response media type, distinct from the `application/x-yaml` request
    # bodies use elsewhere. Sending YAML as the Accept header on those routes
    # fails content negotiation and the server responds 401 instead of 200.
    YAML_ACCEPT = "application/yaml"
    TEXT = "text/plain"
    OCTET = "application/octet-stream"
    CSV = "text/csv"

    def __init__(self, session: requests.Session, base_url: str, timeout=None):
        self._session = session
        self._base_url = base_url.rstrip("/")
        self._timeout = timeout

    # Path builders
    @staticmethod
    def _tenant_path(tenant: str, *segments: str) -> str:
        parts = ["/api/v1", quote(str(tenant), safe="")]
        for s in segments:
            parts.append(quote(str(s), safe=""))
        return "/".join(parts)

    @staticmethod
    def _superadmin_path(*segments: str) -> str:
        parts = ["/api/v1"]
        for s in segments:
            parts.append(quote(str(s), safe=""))
        return "/".join(parts)

    # Query param builders
    @staticmethod
    def _build_query_params(**kwargs: Any) -> Dict[str, Any]:
        result = {}
        for k, v in kwargs.items():
            if v is None:
                continue
            if isinstance(v, bool):
                result[k] = str(v).lower()
            else:
                result[k] = v
        return result

    @staticmethod
    def _append_repeated_param(params: list, key: str, values: Optional[List[str]]) -> None:
        """Append repeated params (like sort) as multiple tuples."""
        if values:
            for v in values:
                params.append((key, v))

    @staticmethod
    def _append_filter_params(params: list, filters: Optional[list]) -> None:
        """Encode QueryFilter list into query param tuples."""
        from kestrapy.query_filter import append_filter_params
        append_filter_params(params, filters)

    # Core request
    def _request(self, method: str, path: str, *,
                 params: Any = None,
                 body: Any = None,
                 content_type: Optional[str] = None,
                 accept: Optional[str] = None,
                 files: Optional[Dict] = None,
                 stream: bool = False) -> requests.Response:
        url = self._base_url + path
        headers = {}
        data = None
        json_body = None

        if content_type and not files:
            headers["Content-Type"] = content_type
        if accept:
            headers["Accept"] = accept

        if body is not None:
            if content_type == self.JSON or content_type is None:
                if hasattr(body, 'to_dict'):
                    json_body = body.to_dict()
                elif hasattr(body, 'model_dump'):
                    json_body = body.model_dump(by_alias=True, exclude_none=True)
                elif isinstance(body, list):
                    json_body = [
                        item.to_dict() if hasattr(item, 'to_dict')
                        else item.model_dump(by_alias=True, exclude_none=True) if hasattr(item, 'model_dump')
                        else item
                        for item in body
                    ]
                elif isinstance(body, dict):
                    json_body = body
                else:
                    data = body if isinstance(body, (str, bytes)) else str(body)
            else:
                data = body if isinstance(body, (str, bytes)) else str(body)

        if json_body is not None:
            data = json.dumps(json_body, default=_json_default)
            headers["Content-Type"] = self.JSON

        resp = self._session.request(
            method, url,
            params=params,
            data=data,
            headers=headers,
            files=files,
            stream=stream,
            timeout=self._timeout
        )

        if resp.status_code >= 400:
            self._raise_for_status(resp)

        return resp

    @staticmethod
    def _raise_for_status(resp: requests.Response) -> None:
        body = resp.text
        kwargs = dict(status=resp.status_code, reason=resp.reason, body=body)
        if resp.status_code == 400:
            raise BadRequestException(**kwargs)
        elif resp.status_code == 401:
            raise UnauthorizedException(**kwargs)
        elif resp.status_code == 403:
            raise ForbiddenException(**kwargs)
        elif resp.status_code == 404:
            raise NotFoundException(**kwargs)
        elif resp.status_code == 409:
            raise ConflictException(**kwargs)
        elif resp.status_code == 422:
            raise UnprocessableEntityException(**kwargs)
        elif 500 <= resp.status_code <= 599:
            raise ServiceException(**kwargs)
        else:
            raise ApiException(**kwargs)

    # Typed convenience methods
    def _json_request(self, method: str, path: str, return_type: Type[T], *,
                      params: Any = None, body: Any = None,
                      content_type: Optional[str] = None) -> T:
        resp = self._request(method, path, params=params, body=body, content_type=content_type)
        data = resp.json()
        return self._deserialize(data, return_type)

    def _json_list_request(self, method: str, path: str, item_type: Type[T], *,
                           params: Any = None, body: Any = None,
                           content_type: Optional[str] = None) -> List[T]:
        resp = self._request(method, path, params=params, body=body, content_type=content_type)
        data = resp.json()
        if not isinstance(data, list):
            return [self._deserialize(data, item_type)]
        return [self._deserialize(item, item_type) for item in data]

    def _void_request(self, method: str, path: str, *,
                      params: Any = None, body: Any = None,
                      content_type: Optional[str] = None) -> None:
        self._request(method, path, params=params, body=body, content_type=content_type)

    def _raw_json_request(self, method: str, path: str, *,
                          params: Any = None, body: Any = None,
                          content_type: Optional[str] = None) -> Any:
        resp = self._request(method, path, params=params, body=body, content_type=content_type)
        if resp.content:
            return resp.json()
        return None

    def _download_request(self, method: str, path: str, *,
                          params: Any = None, body: Any = None,
                          accept: Optional[str] = None) -> bytes:
        resp = self._request(method, path, params=params, body=body, accept=accept or self.OCTET)
        return resp.content

    def _text_request(self, method: str, path: str, *,
                      params: Any = None, accept: Optional[str] = None) -> str:
        resp = self._request(method, path, params=params, accept=accept or self.TEXT)
        return resp.text

    def _csv_request(self, path: str, *, params: Any = None) -> str:
        resp = self._request("GET", path, params=params, accept=self.CSV)
        return resp.text

    def _multipart_upload(self, method: str, path: str, return_type: Optional[Type[T]] = None, *,
                          params: Any = None, field_name: str = "fileContent",
                          file_content: Any = None, file_name: str = "file") -> Optional[T]:
        if isinstance(file_content, str):
            file_content = file_content.encode("utf-8")
        files = {field_name: (file_name, file_content)}
        resp = self._request(method, path, params=params, files=files)
        if return_type is not None and resp.content:
            return self._deserialize(resp.json(), return_type)
        return None

    def _multipart_upload_list(self, method: str, path: str, item_type: Type[T], *,
                               params: Any = None, field_name: str = "fileContent",
                               file_content: Any = None, file_name: str = "file") -> List[T]:
        if isinstance(file_content, str):
            file_content = file_content.encode("utf-8")
        files = {field_name: (file_name, file_content)}
        resp = self._request(method, path, params=params, files=files)
        data = resp.json()
        if isinstance(data, list):
            return [self._deserialize(item, item_type) for item in data]
        return [self._deserialize(data, item_type)]

    def _sse_stream(self, path: str, event_type: Type[T], *,
                    params: Any = None) -> Generator[T, None, None]:
        url = self._base_url + path
        resp = self._session.get(url, params=params, stream=True, headers={"Accept": "text/event-stream"}, timeout=self._timeout)
        if resp.status_code >= 400:
            self._raise_for_status(resp)
        try:
            client = sseclient.SSEClient(resp)
            for event in client.events():
                if event.data:
                    try:
                        data = json.loads(event.data)
                        yield self._deserialize(data, event_type)
                    except json.JSONDecodeError:
                        continue
        finally:
            resp.close()

    @staticmethod
    def _deserialize(data: Any, return_type: Type[T]) -> T:
        if return_type is None or data is None:
            return data
        if return_type in (str, int, float, bool):
            return return_type(data)
        if return_type is dict or return_type is Any:
            return data
        if isinstance(data, dict) and hasattr(return_type, 'from_dict'):
            try:
                return return_type.from_dict(data)
            except Exception:
                return BaseApi._construct_model(data, return_type)
        if hasattr(return_type, 'model_validate'):
            try:
                return return_type.model_validate(data)
            except Exception:
                if isinstance(data, dict):
                    return BaseApi._construct_model(data, return_type)
                return data
        return data

    @staticmethod
    def _unwrap_optional(tp: Any) -> Any:
        origin = get_origin(tp)
        args = get_args(tp)
        if origin is Union and type(None) in args:
            non_none = [a for a in args if a is not type(None)]
            return non_none[0] if len(non_none) == 1 else tp
        return tp

    @staticmethod
    def _construct_model(data: dict, model_type: Type[T]) -> T:
        if not hasattr(model_type, 'model_fields'):
            return model_type.model_construct(**data) if hasattr(model_type, 'model_construct') else data
        fields = model_type.model_fields
        processed = {}
        for key, value in data.items():
            if value is None:
                processed[key] = value
                continue
            field_type = None
            for fname, finfo in fields.items():
                if fname == key or getattr(finfo, 'alias', None) == key:
                    field_type = BaseApi._unwrap_optional(finfo.annotation)
                    break
            if field_type is None:
                processed[key] = value
                continue
            if isinstance(value, dict) and hasattr(field_type, 'model_fields'):
                try:
                    processed[key] = field_type.from_dict(value) if hasattr(field_type, 'from_dict') else BaseApi._construct_model(value, field_type)
                except Exception:
                    processed[key] = BaseApi._construct_model(value, field_type)
            elif isinstance(value, dict):
                inner_origin = get_origin(field_type)
                inner_args = get_args(field_type)
                if inner_origin is dict and len(inner_args) == 2:
                    val_type = BaseApi._unwrap_optional(inner_args[1])
                    if hasattr(val_type, 'model_fields'):
                        processed[key] = {
                            k: (val_type.from_dict(v) if hasattr(val_type, 'from_dict') else BaseApi._construct_model(v, val_type))
                            if isinstance(v, dict) else v
                            for k, v in value.items()
                        }
                    else:
                        processed[key] = value
                else:
                    processed[key] = value
            elif isinstance(value, list):
                inner_origin = get_origin(field_type)
                inner_args = get_args(field_type)
                if inner_origin is list and inner_args:
                    inner_type = BaseApi._unwrap_optional(inner_args[0])
                    if hasattr(inner_type, 'model_fields'):
                        items = []
                        for item in value:
                            if isinstance(item, dict):
                                try:
                                    items.append(inner_type.from_dict(item) if hasattr(inner_type, 'from_dict') else BaseApi._construct_model(item, inner_type))
                                except Exception:
                                    items.append(BaseApi._construct_model(item, inner_type))
                            else:
                                items.append(item)
                        processed[key] = items
                    else:
                        processed[key] = value
                else:
                    processed[key] = value
            else:
                processed[key] = value
        return model_type.model_construct(**processed)
