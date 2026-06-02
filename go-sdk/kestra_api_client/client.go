package kestra_api_client

import (
	"encoding/base64"
	"io"
	"net/http"
)

type KestraClient struct {
	baseURL    string
	httpClient *http.Client
	headers    map[string]string
	// authHeader holds the Authorization value set by WithBasicAuth/WithTokenAuth.
	// It is applied after the default headers on every request, so an explicit
	// auth option always takes precedence over an Authorization entry supplied
	// through WithHeaders/WithHeader, regardless of option ordering.
	authHeader string
	debug      bool
	logger     io.Writer
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
		c.authHeader = "Basic " + encoded
	}
}

func WithTokenAuth(token string) ClientOption {
	return func(c *KestraClient) {
		c.authHeader = "Bearer " + token
	}
}

func WithHTTPClient(hc *http.Client) ClientOption {
	return func(c *KestraClient) {
		c.httpClient = hc
	}
}

// WithHeaders merges the given headers into the client's default headers, which
// are applied to every request. Existing entries with the same key are
// overwritten.
//
// Precedence: an Authorization entry supplied here is overridden on the wire by
// an explicit WithBasicAuth/WithTokenAuth option (whenever one is set),
// independent of the order in which the options are passed to NewClient.
func WithHeaders(headers map[string]string) ClientOption {
	return func(c *KestraClient) {
		for k, v := range headers {
			c.headers[k] = v
		}
	}
}

// WithHeader sets a single default header, applied to every request. See
// WithHeaders for the Authorization precedence rule.
func WithHeader(key, value string) ClientOption {
	return func(c *KestraClient) {
		c.headers[key] = value
	}
}

// WithDebug toggles HTTP request/response logging to os.Stderr. Logged output
// covers the method, URL, status and headers; sensitive headers (Authorization,
// Proxy-Authorization, Cookie, Set-Cookie) are redacted. Request and response
// bodies are not logged. Use WithLogger to send the output elsewhere.
func WithDebug(enabled bool) ClientOption {
	return func(c *KestraClient) {
		c.debug = enabled
	}
}

// WithLogger directs debug output to w and enables debug logging. It is the
// preferred option when you need to capture or redirect diagnostics (e.g. in
// tests). See WithDebug for what is logged and which headers are redacted.
func WithLogger(w io.Writer) ClientOption {
	return func(c *KestraClient) {
		c.logger = w
		c.debug = true
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

func (c *KestraClient) Invitations() *InvitationsAPI {
	return &InvitationsAPI{baseAPI{client: c}}
}
