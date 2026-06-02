package kestra_api_client

import (
	"encoding/base64"
	"net/http"
)

type KestraClient struct {
	baseURL    string
	httpClient *http.Client
	headers    map[string]string
}

type ClientOption func(*KestraClient)

func NewClient(baseURL string, opts ...ClientOption) *KestraClient {
	c := &KestraClient{
		baseURL:    baseURL,
		httpClient: http.DefaultClient,
		headers:    make(map[string]string),
	}
	for _, opt := range opts {
		opt(c)
	}
	return c
}

func WithBasicAuth(username, password string) ClientOption {
	return func(c *KestraClient) {
		encoded := base64.StdEncoding.EncodeToString([]byte(username + ":" + password))
		c.headers["Authorization"] = "Basic " + encoded
	}
}

func WithTokenAuth(token string) ClientOption {
	return func(c *KestraClient) {
		c.headers["Authorization"] = "Bearer " + token
	}
}

func WithHTTPClient(hc *http.Client) ClientOption {
	return func(c *KestraClient) {
		c.httpClient = hc
	}
}

func (c *KestraClient) Executions() *ExecutionsAPI {
	return &ExecutionsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Flows() *FlowsAPI {
	return &FlowsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Groups() *GroupsAPI {
	return &GroupsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Kv() *KvAPI {
	return &KvAPI{baseAPI{client: c}}
}

func (c *KestraClient) Namespaces() *NamespacesAPI {
	return &NamespacesAPI{baseAPI{client: c}}
}

func (c *KestraClient) Roles() *RolesAPI {
	return &RolesAPI{baseAPI{client: c}}
}

func (c *KestraClient) Bindings() *BindingsAPI {
	return &BindingsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Triggers() *TriggersAPI {
	return &TriggersAPI{baseAPI{client: c}}
}

func (c *KestraClient) Users() *UsersAPI {
	return &UsersAPI{baseAPI{client: c}}
}

func (c *KestraClient) ServiceAccount() *ServiceAccountAPI {
	return &ServiceAccountAPI{baseAPI{client: c}}
}

func (c *KestraClient) TestSuites() *TestSuitesAPI {
	return &TestSuitesAPI{baseAPI{client: c}}
}

func (c *KestraClient) Files() *FilesAPI {
	return &FilesAPI{baseAPI{client: c}}
}

func (c *KestraClient) Misc() *MiscAPI {
	return &MiscAPI{baseAPI{client: c}}
}

func (c *KestraClient) Dashboards() *DashboardsAPI {
	return &DashboardsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Apps() *AppsAPI {
	return &AppsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Assets() *AssetsAPI {
	return &AssetsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Logs() *LogsAPI {
	return &LogsAPI{baseAPI{client: c}}
}

func (c *KestraClient) Blueprints() *BlueprintsAPI {
	return &BlueprintsAPI{baseAPI{client: c}}
}
