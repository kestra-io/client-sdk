import ApiClient from "./ApiClient"

import AppsApi from './api/AppsApi';
import AuditLogsApi from './api/AuditLogsApi';
import AuthsApi from './api/AuthsApi';
import BannersApi from './api/BannersApi';
import BindingsApi from './api/BindingsApi';
import BlueprintTagsApi from './api/BlueprintTagsApi';
import BlueprintsApi from './api/BlueprintsApi';
import ClusterApi from './api/ClusterApi';
import DashboardsApi from './api/DashboardsApi';
import DefaultApi from './api/DefaultApi';
import ExecutionsApi from './api/ExecutionsApi';
import FilesApi from './api/FilesApi';
import FlowsApi from './api/FlowsApi';
import GroupsApi from './api/GroupsApi';
import InvitationsApi from './api/InvitationsApi';
import KVApi from './api/KVApi';
import LogsApi from './api/LogsApi';
import MaintenanceApi from './api/MaintenanceApi';
import MetricsApi from './api/MetricsApi';
import MiscApi from './api/MiscApi';
import NamespacesApi from './api/NamespacesApi';
import PluginsApi from './api/PluginsApi';
import RolesApi from './api/RolesApi';
import SCIMApi from './api/SCIMApi';
import SCIMConfigurationApi from './api/SCIMConfigurationApi';
import SecurityIntegrationsApi from './api/SecurityIntegrationsApi';
import ServicesApi from './api/ServicesApi';
import TenantsApi from './api/TenantsApi';
import TestSuitesApi from './api/TestSuitesApi';
import TriggersApi from './api/TriggersApi';
import UsersApi from './api/UsersApi';
import WorkerGroupsApi from './api/WorkerGroupsApi';


class KestraClient {

    constructor(host, accessToken, username, password) {
        this.apiClient = ApiClient.instance;

        this.apiClient.basePath = host;
        if (accessToken) {
            this.apiClient.authentications.bearerAuth.accessToken = accessToken
        }
        if (username && password) {
            this.apiClient.authentications.basicAuth.username = username;
            this.apiClient.authentications.basicAuth.password = password;
        } else {
            if (username || password) {
                console.error("Username or password is provided, but not both.");
            }
        }

        // Initialize all APIs
        this.appsApi = new AppsApi(this.apiClient);
        this.auditLogsApi = new AuditLogsApi(this.apiClient);
        this.authsApi = new AuthsApi(this.apiClient);
        this.bannersApi = new BannersApi(this.apiClient);
        this.bindingsApi = new BindingsApi(this.apiClient);
        this.blueprintTagsApi = new BlueprintTagsApi(this.apiClient);
        this.blueprintsApi = new BlueprintsApi(this.apiClient);
        this.clusterApi = new ClusterApi(this.apiClient);
        this.dashboardsApi = new DashboardsApi(this.apiClient);
        this.defaultApi = new DefaultApi(this.apiClient);
        this.executionsApi = new ExecutionsApi(this.apiClient);
        this.filesApi = new FilesApi(this.apiClient);
        this.flowsApi = new FlowsApi(this.apiClient);
        this.groupsApi = new GroupsApi(this.apiClient);
        this.invitationsApi = new InvitationsApi(this.apiClient);
        this.kvApi = new KVApi(this.apiClient);
        this.logsApi = new LogsApi(this.apiClient);
        this.maintenanceApi = new MaintenanceApi(this.apiClient);
        this.metricsApi = new MetricsApi(this.apiClient);
        this.miscApi = new MiscApi(this.apiClient);
        this.namespacesApi = new NamespacesApi(this.apiClient);
        this.pluginsApi = new PluginsApi(this.apiClient);
        this.rolesApi = new RolesApi(this.apiClient);
        this.scimConfigurationApi = new SCIMConfigurationApi(this.apiClient);
        this.scimApi = new SCIMApi(this.apiClient);
        this.securityIntegrationsApi = new SecurityIntegrationsApi(this.apiClient);
        this.servicesApi = new ServicesApi(this.apiClient);
        this.tenantsApi = new TenantsApi(this.apiClient);
        this.testSuitesApi = new TestSuitesApi(this.apiClient);
        this.triggersApi = new TriggersApi(this.apiClient);
        this.usersApi = new UsersApi(this.apiClient);
        this.workerGroupsApi = new WorkerGroupsApi(this.apiClient);

    }

}

export default KestraClient;