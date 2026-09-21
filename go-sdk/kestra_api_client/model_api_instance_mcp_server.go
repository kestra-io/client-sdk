package kestra_api_client

import "time"

// ApiInstanceMcpServer is the instance-scoped API DTO for an MCP server, adding
// the owning tenant id so instance owners can tell servers apart across tenants.
type ApiInstanceMcpServer struct {
	TenantId    string     `json:"tenantId,omitempty"`
	Id          string     `json:"id"`
	Description  string    `json:"description,omitempty"`
	ServerType  string     `json:"serverType,omitempty"`
	AuthType    string     `json:"authType,omitempty"`
	Disabled    bool       `json:"disabled"`
	IsDefault   bool       `json:"isDefault"`
	Created     *time.Time `json:"created,omitempty"`
	Updated     *time.Time `json:"updated,omitempty"`
}

func (o *ApiInstanceMcpServer) GetTenantId() string  { return o.TenantId }
func (o *ApiInstanceMcpServer) GetId() string        { return o.Id }
func (o *ApiInstanceMcpServer) GetDescription() string { return o.Description }
func (o *ApiInstanceMcpServer) GetServerType() string { return o.ServerType }
func (o *ApiInstanceMcpServer) GetAuthType() string  { return o.AuthType }
func (o *ApiInstanceMcpServer) GetDisabled() bool    { return o.Disabled }
func (o *ApiInstanceMcpServer) GetIsDefault() bool   { return o.IsDefault }

// PagedResultsApiInstanceMcpServer is a page of instance-wide MCP servers.
type PagedResultsApiInstanceMcpServer struct {
	Results []ApiInstanceMcpServer `json:"results"`
	Total   int64                  `json:"total"`
}

func (o *PagedResultsApiInstanceMcpServer) GetResults() []ApiInstanceMcpServer { return o.Results }
func (o *PagedResultsApiInstanceMcpServer) GetTotal() int64                    { return o.Total }
