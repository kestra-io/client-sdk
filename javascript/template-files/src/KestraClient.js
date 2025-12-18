import ApiClient from "./ApiClient"

import ExecutionsApi from './api/ExecutionsApi';
import FlowsApi from './api/FlowsApi';
import GroupsApi from './api/GroupsApi';
import KVApi from './api/KVApi';
import NamespacesApi from './api/NamespacesApi';
import RolesApi from './api/RolesApi';
import ServicesApi from './api/ServiceAccountApi';
import TriggersApi from './api/TriggersApi';
import UsersApi from './api/UsersApi';
import {ServiceAccountApi} from "./index";
import TestSuitesApi from "./api/TestSuitesApi";


class KestraClient {

    /**
     * Constructs a new KestraClient.
     * @param {String} host The base path to the Kestra server.
     * @param {String} accessToken The access token for bearer authentication.
     * @param {String} username The username for basic authentication.
     * @param {String} password The password for basic authentication.
     */
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
        this.executionsApi = new ExecutionsApi(this.apiClient);
        this.flowsApi = new FlowsApi(this.apiClient);
        this.groupsApi = new GroupsApi(this.apiClient);
        this.kvApi = new KVApi(this.apiClient);
        this.namespacesApi = new NamespacesApi(this.apiClient);
        this.rolesApi = new RolesApi(this.apiClient);
        this.serviceAccountApi = new ServiceAccountApi(this.apiClient);
        this.triggersApi = new TriggersApi(this.apiClient);
        this.usersApi = new UsersApi(this.apiClient);
        this.testSuitesApi = new TestSuitesApi(this.apiClient);

    }

}

export default KestraClient;