from .api_client import ApiClient
from .api.flows_api import FlowsApi
from .api.apps_api import AppsApi
from .api.audit_logs_api import AuditLogsApi
from .api.auths_api import AuthsApi
from .api.banners_api import BannersApi
from .api.bindings_api import BindingsApi
from .api.blueprint_tags_api import BlueprintTagsApi
from .api.blueprints_api import BlueprintsApi
from .api.cluster_api import ClusterApi
from .api.dashboards_api import DashboardsApi
from .api.default_api import DefaultApi
from .api.executions_api import ExecutionsApi
from .api.files_api import FilesApi
from .api.groups_api import GroupsApi
from .api.invitations_api import InvitationsApi
from .api.kv_api import KVApi
from .api.logs_api import LogsApi
from .api.maintenance_api import MaintenanceApi
from .api.metrics_api import MetricsApi
from .api.misc_api import MiscApi
from .api.namespaces_api import NamespacesApi
from .api.plugins_api import PluginsApi
from .api.roles_api import RolesApi
from .api.security_integrations_api import SecurityIntegrationsApi
from .api.services_api import ServicesApi
from .api.tenants_api import TenantsApi
from .api.test_suites_api import TestSuitesApi
from .api.triggers_api import TriggersApi
from .api.users_api import UsersApi
from .api.worker_groups_api import WorkerGroupsApi


class KestraClient:
    flows: FlowsApi = None
    apps: AppsApi = None
    audit_logs: AuditLogsApi = None
    auths: AuthsApi = None
    banners: BannersApi = None
    bindings: BindingsApi = None
    blueprint_tags: BlueprintTagsApi = None
    blueprints: BlueprintsApi = None
    cluster: ClusterApi = None
    dashboards: DashboardsApi = None
    default: DefaultApi = None
    executions: ExecutionsApi = None
    files: FilesApi = None
    groups: GroupsApi = None
    invitations: InvitationsApi = None
    kv: KVApi = None
    logs: LogsApi = None
    maintenance: MaintenanceApi = None
    metrics: MetricsApi = None
    misc: MiscApi = None
    namespaces: NamespacesApi = None
    plugins: PluginsApi = None
    roles: RolesApi = None
    security_integrations: SecurityIntegrationsApi = None
    services: ServicesApi = None
    tenants: TenantsApi = None
    test_suites: TestSuitesApi = None
    triggers: TriggersApi = None
    users: UsersApi = None
    worker_groups: WorkerGroupsApi = None

    def __init__(self, configuration=None):
        if configuration is None:
            configuration = ApiClient().configuration
        self.api_client = ApiClient(configuration=configuration)

        self.flows = FlowsApi(self.api_client)
        self.apps = AppsApi(self.api_client)
        self.audit_logs = AuditLogsApi(self.api_client)
        self.auths = AuthsApi(self.api_client)
        self.banners = BannersApi(self.api_client)
        self.bindings = BindingsApi(self.api_client)
        self.blueprint_tags = BlueprintTagsApi(self.api_client)
        self.blueprints = BlueprintsApi(self.api_client)
        self.cluster = ClusterApi(self.api_client)
        self.dashboards = DashboardsApi(self.api_client)
        self.default = DefaultApi(self.api_client)
        self.executions = ExecutionsApi(self.api_client)
        self.files = FilesApi(self.api_client)
        self.groups = GroupsApi(self.api_client)
        self.invitations = InvitationsApi(self.api_client)
        self.kv = KVApi(self.api_client)
        self.logs = LogsApi(self.api_client)
        self.maintenance = MaintenanceApi(self.api_client)
        self.metrics = MetricsApi(self.api_client)
        self.namespaces = NamespacesApi(self.api_client)
        self.plugins = PluginsApi(self.api_client)
        self.roles = RolesApi(self.api_client)
        self.security_integrations = SecurityIntegrationsApi(self.api_client)
        self.services = ServicesApi(self.api_client)
        self.tenants = TenantsApi(self.api_client)
        self.test_suites = TestSuitesApi(self.api_client)
        self.triggers = TriggersApi(self.api_client)
        self.users = UsersApi(self.api_client)
        self.worker_groups = WorkerGroupsApi(self.api_client)