import base64

import requests

from kestrapy.api.bindings_api import BindingsApi
from kestrapy.api.kv_api import KVApi
from kestrapy.api.roles_api import RolesApi
from kestrapy.api.groups_api import GroupsApi
from kestrapy.api.users_api import UsersApi
from kestrapy.api.service_account_api import ServiceAccountApi
from kestrapy.api.namespaces_api import NamespacesApi
from kestrapy.api.triggers_api import TriggersApi
from kestrapy.api.flows_api import FlowsApi
from kestrapy.api.executions_api import ExecutionsApi
from kestrapy.api.invitations_api import InvitationsApi
from kestrapy.api.logs_api import LogsApi
from kestrapy.api.tenant_access_api import TenantAccessApi
from kestrapy.api.files_api import FilesApi
from kestrapy.api.assets_api import AssetsApi
from kestrapy.api.blueprints_api import BlueprintsApi
from kestrapy.api.dashboards_api import DashboardsApi
from kestrapy.api.apps_api import AppsApi
from kestrapy.api.test_suites_api import TestSuitesApi


class KestraClient:
    def __init__(self, configuration=None, *, host=None, username=None, password=None, token=None, timeout=None):
        """Create a KestraClient.

        Args:
            timeout: Request timeout in seconds. Accepts a float (applied to both connect
                and read), a ``(connect, read)`` tuple, or ``None`` for no timeout (infinite).
                Defaults to ``None``.
        """
        self._session = requests.Session()

        if configuration is not None:
            host = host or getattr(configuration, 'host', None) or "http://localhost:8080"
            username = username or getattr(configuration, 'username', None)
            password = password or getattr(configuration, 'password', None)
            api_key = getattr(configuration, 'api_key', None)
            if api_key and isinstance(api_key, dict) and api_key.get('Authorization'):
                self._session.headers["Authorization"] = api_key['Authorization']
            elif username and password:
                creds = base64.b64encode(f"{username}:{password}".encode()).decode()
                self._session.headers["Authorization"] = f"Basic {creds}"
        else:
            host = host or "http://localhost:8080"
            if token:
                self._session.headers["Authorization"] = f"Bearer {token}"
            elif username and password:
                creds = base64.b64encode(f"{username}:{password}".encode()).decode()
                self._session.headers["Authorization"] = f"Basic {creds}"

        self._base_url = host.rstrip("/")
        self._timeout = timeout
        self._apis = {}

    def _get_api(self, cls):
        if cls not in self._apis:
            self._apis[cls] = cls(self._session, self._base_url, timeout=self._timeout)
        return self._apis[cls]

    @property
    def flows(self): return self._get_api(FlowsApi)
    @property
    def executions(self): return self._get_api(ExecutionsApi)
    @property
    def apps(self): return self._get_api(AppsApi)
    @property
    def assets(self): return self._get_api(AssetsApi)
    @property
    def blueprints(self): return self._get_api(BlueprintsApi)
    @property
    def dashboards(self): return self._get_api(DashboardsApi)
    @property
    def files(self): return self._get_api(FilesApi)
    @property
    def logs(self): return self._get_api(LogsApi)
    @property
    def test_suites(self): return self._get_api(TestSuitesApi)
    @property
    def kv(self): return self._get_api(KVApi)
    @property
    def namespaces(self): return self._get_api(NamespacesApi)
    @property
    def triggers(self): return self._get_api(TriggersApi)
    @property
    def groups(self): return self._get_api(GroupsApi)
    @property
    def roles(self): return self._get_api(RolesApi)
    @property
    def users(self): return self._get_api(UsersApi)
    @property
    def service_account(self): return self._get_api(ServiceAccountApi)
    @property
    def bindings(self): return self._get_api(BindingsApi)
    @property
    def invitations(self): return self._get_api(InvitationsApi)
    @property
    def tenant_access(self): return self._get_api(TenantAccessApi)

    def close(self):
        self._session.close()

    def __enter__(self):
        return self

    def __exit__(self, *args):
        self.close()
