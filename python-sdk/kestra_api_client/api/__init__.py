# flake8: noqa

if __import__("typing").TYPE_CHECKING:
    # import apis into api package
    from kestra_api_client.api.ai_api import AIApi
    from kestra_api_client.api.apps_api import AppsApi
    from kestra_api_client.api.audit_logs_api import AuditLogsApi
    from kestra_api_client.api.auths_api import AuthsApi
    from kestra_api_client.api.banners_api import BannersApi
    from kestra_api_client.api.bindings_api import BindingsApi
    from kestra_api_client.api.blueprint_tags_api import BlueprintTagsApi
    from kestra_api_client.api.blueprints_api import BlueprintsApi
    from kestra_api_client.api.cluster_api import ClusterApi
    from kestra_api_client.api.dashboards_api import DashboardsApi
    from kestra_api_client.api.executions_api import ExecutionsApi
    from kestra_api_client.api.files_api import FilesApi
    from kestra_api_client.api.flows_api import FlowsApi
    from kestra_api_client.api.groups_api import GroupsApi
    from kestra_api_client.api.invitations_api import InvitationsApi
    from kestra_api_client.api.kv_api import KVApi
    from kestra_api_client.api.logs_api import LogsApi
    from kestra_api_client.api.maintenance_api import MaintenanceApi
    from kestra_api_client.api.metrics_api import MetricsApi
    from kestra_api_client.api.misc_api import MiscApi
    from kestra_api_client.api.namespaces_api import NamespacesApi
    from kestra_api_client.api.plugins_api import PluginsApi
    from kestra_api_client.api.roles_api import RolesApi
    from kestra_api_client.api.scim_configuration_api import SCIMConfigurationApi
    from kestra_api_client.api.scim_groups_api import SCIMGroupsApi
    from kestra_api_client.api.scim_users_api import SCIMUsersApi
    from kestra_api_client.api.security_integrations_api import SecurityIntegrationsApi
    from kestra_api_client.api.service_account_api import ServiceAccountApi
    from kestra_api_client.api.services_api import ServicesApi
    from kestra_api_client.api.tenant_access_api import TenantAccessApi
    from kestra_api_client.api.tenants_api import TenantsApi
    from kestra_api_client.api.test_suites_api import TestSuitesApi
    from kestra_api_client.api.triggers_api import TriggersApi
    from kestra_api_client.api.users_api import UsersApi
    from kestra_api_client.api.worker_groups_api import WorkerGroupsApi
    from kestra_api_client.api.default_api import DefaultApi
    
else:
    from lazy_imports import LazyModule, as_package, load

    load(
        LazyModule(
            *as_package(__file__),
            """# import apis into api package
from kestra_api_client.api.ai_api import AIApi
from kestra_api_client.api.apps_api import AppsApi
from kestra_api_client.api.audit_logs_api import AuditLogsApi
from kestra_api_client.api.auths_api import AuthsApi
from kestra_api_client.api.banners_api import BannersApi
from kestra_api_client.api.bindings_api import BindingsApi
from kestra_api_client.api.blueprint_tags_api import BlueprintTagsApi
from kestra_api_client.api.blueprints_api import BlueprintsApi
from kestra_api_client.api.cluster_api import ClusterApi
from kestra_api_client.api.dashboards_api import DashboardsApi
from kestra_api_client.api.executions_api import ExecutionsApi
from kestra_api_client.api.files_api import FilesApi
from kestra_api_client.api.flows_api import FlowsApi
from kestra_api_client.api.groups_api import GroupsApi
from kestra_api_client.api.invitations_api import InvitationsApi
from kestra_api_client.api.kv_api import KVApi
from kestra_api_client.api.logs_api import LogsApi
from kestra_api_client.api.maintenance_api import MaintenanceApi
from kestra_api_client.api.metrics_api import MetricsApi
from kestra_api_client.api.misc_api import MiscApi
from kestra_api_client.api.namespaces_api import NamespacesApi
from kestra_api_client.api.plugins_api import PluginsApi
from kestra_api_client.api.roles_api import RolesApi
from kestra_api_client.api.scim_configuration_api import SCIMConfigurationApi
from kestra_api_client.api.scim_groups_api import SCIMGroupsApi
from kestra_api_client.api.scim_users_api import SCIMUsersApi
from kestra_api_client.api.security_integrations_api import SecurityIntegrationsApi
from kestra_api_client.api.service_account_api import ServiceAccountApi
from kestra_api_client.api.services_api import ServicesApi
from kestra_api_client.api.tenant_access_api import TenantAccessApi
from kestra_api_client.api.tenants_api import TenantsApi
from kestra_api_client.api.test_suites_api import TestSuitesApi
from kestra_api_client.api.triggers_api import TriggersApi
from kestra_api_client.api.users_api import UsersApi
from kestra_api_client.api.worker_groups_api import WorkerGroupsApi
from kestra_api_client.api.default_api import DefaultApi

""",
            name=__name__,
            doc=__doc__,
        )
    )
