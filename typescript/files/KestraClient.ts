
import {
    Configuration,
    ExecutionsApi,
    FlowsApi,
    GroupsApi,
    KVApi,
    NamespacesApi,
    RolesApi,
    ServiceAccountApi,
    TestSuitesApi,
    TriggersApi,
    UsersApi,
    type ConfigurationParameters
} from "./index";


class KestraClient {
    config: Configuration;
    executionsApi: ExecutionsApi;
    flowsApi: FlowsApi;
    groupsApi: GroupsApi;
    kvApi: KVApi;
    namespacesApi: NamespacesApi;
    rolesApi: RolesApi;
    serviceAccountApi: ServiceAccountApi;
    triggersApi: TriggersApi;
    usersApi: UsersApi;
    testSuitesApi: TestSuitesApi;

    constructor(options: ConfigurationParameters)
     {
        this.config = new Configuration(options);

        // Initialize all APIs
        this.executionsApi = new ExecutionsApi(this.config);
        this.flowsApi = new FlowsApi(this.config);
        this.groupsApi = new GroupsApi(this.config);
        this.kvApi = new KVApi(this.config);
        this.namespacesApi = new NamespacesApi(this.config);
        this.rolesApi = new RolesApi(this.config);
        this.serviceAccountApi = new ServiceAccountApi(this.config);
        this.triggersApi = new TriggersApi(this.config);
        this.usersApi = new UsersApi(this.config);
        this.testSuitesApi = new TestSuitesApi(this.config);
    }

}

export default KestraClient;