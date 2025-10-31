from .api_client import ApiClient
from .api.flows_api import FlowsApi
from .api.executions_api import ExecutionsApi
from .api.groups_api import GroupsApi
from .api.kv_api import KVApi
from .api.namespaces_api import NamespacesApi
from .api.roles_api import RolesApi
from .api.service_account_api import ServiceAccountApi
from .api.triggers_api import TriggersApi
from .api.users_api import UsersApi


class KestraClient:
    flows: FlowsApi = None
    executions: ExecutionsApi = None
    groups: GroupsApi = None
    kv: KVApi = None
    namespaces: NamespacesApi = None
    roles: RolesApi = None
    serviceAccount: ServiceAccountApi = None
    triggers: TriggersApi = None
    users: UsersApi = None

    def __init__(self, configuration=None):
        if configuration is None:
            configuration = ApiClient().configuration
        self.api_client = ApiClient(configuration=configuration)

        self.flows = FlowsApi(self.api_client)
        self.executions = ExecutionsApi(self.api_client)
        self.groups = GroupsApi(self.api_client)
        self.kv = KVApi(self.api_client)
        self.namespaces = NamespacesApi(self.api_client)
        self.roles = RolesApi(self.api_client)
        self.service_account = ServiceAccountApi(self.api_client)
        self.triggers = TriggersApi(self.api_client)
        self.users = UsersApi(self.api_client)
