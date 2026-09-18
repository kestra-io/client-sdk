package kestra_api_client

import "time"

// ApiMcpServer is the request and response body of the tenant-scoped MCP server
// CRUD endpoints. Only Id is required on create; ServerType and AuthType default
// server-side, and IsDefault/Created/Updated are read-only.
type ApiMcpServer struct {
	Id                   string     `json:"id"`
	Description          string     `json:"description,omitempty"`
	Instructions         string     `json:"instructions,omitempty"`
	ServerType           string     `json:"serverType,omitempty"`
	AuthType             string     `json:"authType,omitempty"`
	OauthProvider        string     `json:"oauthProvider,omitempty"`
	OauthScopesSupported []string   `json:"oauthScopesSupported,omitempty"`
	Disabled             bool       `json:"disabled"`
	IsDefault            bool       `json:"isDefault,omitempty"`
	Created              *time.Time `json:"created,omitempty"`
	Updated              *time.Time `json:"updated,omitempty"`
}

func (o *ApiMcpServer) GetId() string          { return o.Id }
func (o *ApiMcpServer) GetDescription() string { return o.Description }
func (o *ApiMcpServer) GetServerType() string  { return o.ServerType }
func (o *ApiMcpServer) GetAuthType() string    { return o.AuthType }
func (o *ApiMcpServer) GetDisabled() bool      { return o.Disabled }
func (o *ApiMcpServer) GetIsDefault() bool      { return o.IsDefault }

// PagedResultsApiMcpServer is a page of tenant MCP servers.
type PagedResultsApiMcpServer struct {
	Results []ApiMcpServer `json:"results"`
	Total   int64          `json:"total"`
}

func (o *PagedResultsApiMcpServer) GetResults() []ApiMcpServer { return o.Results }
func (o *PagedResultsApiMcpServer) GetTotal() int64            { return o.Total }

// ApiMcpTool is a tool exposed by an MCP server (one per MCP Tool trigger).
type ApiMcpTool struct {
	ToolName     string             `json:"toolName,omitempty"`
	TriggerId    string             `json:"triggerId,omitempty"`
	Title        string             `json:"title,omitempty"`
	Description  string             `json:"description,omitempty"`
	Annotations  *ApiMcpToolAnnotations `json:"annotations,omitempty"`
	Namespace    string             `json:"namespace,omitempty"`
	FlowId       string             `json:"flowId,omitempty"`
	FlowRevision *int32             `json:"flowRevision,omitempty"`
	Disabled     bool               `json:"disabled"`
}

func (o *ApiMcpTool) GetToolName() string  { return o.ToolName }
func (o *ApiMcpTool) GetNamespace() string { return o.Namespace }

// ApiMcpToolAnnotations describes the behavioural hints of an MCP tool.
type ApiMcpToolAnnotations struct {
	ReadOnly     bool `json:"readOnly"`
	OpenWorld    bool `json:"openWorld"`
	Destructive  bool `json:"destructive"`
	Idempotent   bool `json:"idempotent"`
	ReturnDirect bool `json:"returnDirect"`
}
