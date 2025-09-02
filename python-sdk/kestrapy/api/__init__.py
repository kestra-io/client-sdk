# flake8: noqa

if __import__("typing").TYPE_CHECKING:
    # import apis into api package
    from kestrapy.api.ai_api import AIApi
    from kestrapy.api.apps_api import AppsApi
    from kestrapy.api.audit_logs_api import AuditLogsApi
    from kestrapy.api.auths_api import AuthsApi
    from kestrapy.api.banners_api import BannersApi
    from kestrapy.api.bindings_api import BindingsApi
    from kestrapy.api.blueprint_tags_api import BlueprintTagsApi
    from kestrapy.api.blueprints_api import BlueprintsApi
    from kestrapy.api.cluster_api import ClusterApi
    from kestrapy.api.dashboards_api import DashboardsApi
    from kestrapy.api.executions_api import ExecutionsApi
    from kestrapy.api.files_api import FilesApi
    from kestrapy.api.flows_api import FlowsApi
    from kestrapy.api.groups_api import GroupsApi
    from kestrapy.api.invitations_api import InvitationsApi
    from kestrapy.api.kv_api import KVApi
    from kestrapy.api.logs_api import LogsApi
    from kestrapy.api.maintenance_api import MaintenanceApi
    from kestrapy.api.metrics_api import MetricsApi
    from kestrapy.api.misc_api import MiscApi
    from kestrapy.api.namespaces_api import NamespacesApi
    from kestrapy.api.plugins_api import PluginsApi
    from kestrapy.api.roles_api import RolesApi
    from kestrapy.api.scim_configuration_api import SCIMConfigurationApi
    from kestrapy.api.scim_groups_api import SCIMGroupsApi
    from kestrapy.api.scim_users_api import SCIMUsersApi
    from kestrapy.api.security_integrations_api import SecurityIntegrationsApi
    from kestrapy.api.service_account_api import ServiceAccountApi
    from kestrapy.api.services_api import ServicesApi
    from kestrapy.api.tenant_access_api import TenantAccessApi
    from kestrapy.api.tenants_api import TenantsApi
    from kestrapy.api.test_suites_api import TestSuitesApi
    from kestrapy.api.triggers_api import TriggersApi
    from kestrapy.api.users_api import UsersApi
    from kestrapy.api.worker_groups_api import WorkerGroupsApi
    from kestrapy.api.default_api import DefaultApi
    
else:
    from lazy_imports import LazyModule, as_package, load

    load(
        LazyModule(
            *as_package(__file__),
            """# import apis into api package
from kestrapy.api.ai_api import AIApi
from kestrapy.api.apps_api import AppsApi
from kestrapy.api.audit_logs_api import AuditLogsApi
from kestrapy.api.auths_api import AuthsApi
from kestrapy.api.banners_api import BannersApi
from kestrapy.api.bindings_api import BindingsApi
from kestrapy.api.blueprint_tags_api import BlueprintTagsApi
from kestrapy.api.blueprints_api import BlueprintsApi
from kestrapy.api.cluster_api import ClusterApi
from kestrapy.api.dashboards_api import DashboardsApi
from kestrapy.api.executions_api import ExecutionsApi
from kestrapy.api.files_api import FilesApi
from kestrapy.api.flows_api import FlowsApi
from kestrapy.api.groups_api import GroupsApi
from kestrapy.api.invitations_api import InvitationsApi
from kestrapy.api.kv_api import KVApi
from kestrapy.api.logs_api import LogsApi
from kestrapy.api.maintenance_api import MaintenanceApi
from kestrapy.api.metrics_api import MetricsApi
from kestrapy.api.misc_api import MiscApi
from kestrapy.api.namespaces_api import NamespacesApi
from kestrapy.api.plugins_api import PluginsApi
from kestrapy.api.roles_api import RolesApi
from kestrapy.api.scim_configuration_api import SCIMConfigurationApi
from kestrapy.api.scim_groups_api import SCIMGroupsApi
from kestrapy.api.scim_users_api import SCIMUsersApi
from kestrapy.api.security_integrations_api import SecurityIntegrationsApi
from kestrapy.api.service_account_api import ServiceAccountApi
from kestrapy.api.services_api import ServicesApi
from kestrapy.api.tenant_access_api import TenantAccessApi
from kestrapy.api.tenants_api import TenantsApi
from kestrapy.api.test_suites_api import TestSuitesApi
from kestrapy.api.triggers_api import TriggersApi
from kestrapy.api.users_api import UsersApi
from kestrapy.api.worker_groups_api import WorkerGroupsApi
from kestrapy.api.default_api import DefaultApi

""",
            name=__name__,
            doc=__doc__,
        )
    )
