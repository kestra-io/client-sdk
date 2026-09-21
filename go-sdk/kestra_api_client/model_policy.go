package kestra_api_client

// Policy is an EE governance policy. It is created and updated from a YAML
// source; the parsed form is returned by the read and write endpoints. Scope,
// tenant and namespace are derived from the request path, not the body.
type Policy struct {
	Id          string                   `json:"id"`
	DisplayName string                   `json:"displayName,omitempty"`
	Description string                   `json:"description,omitempty"`
	Scope       string                   `json:"scope,omitempty"`
	TenantId    string                   `json:"tenantId,omitempty"`
	Namespace   string                   `json:"namespace,omitempty"`
	Enforcement string                   `json:"enforcement,omitempty"`
	Target      *PolicyTarget            `json:"target,omitempty"`
	Rules       []map[string]interface{} `json:"rules,omitempty"`
	Source      string                   `json:"source,omitempty"`
	Deleted     bool                     `json:"deleted,omitempty"`
}

func (o *Policy) GetId() string                     { return o.Id }
func (o *Policy) GetDisplayName() string            { return o.DisplayName }
func (o *Policy) GetScope() string                  { return o.Scope }
func (o *Policy) GetEnforcement() string            { return o.Enforcement }
func (o *Policy) GetSource() string                 { return o.Source }
func (o *Policy) GetRules() []map[string]interface{} { return o.Rules }

// PolicyTarget scopes a policy to specific tenants and/or namespaces.
type PolicyTarget struct {
	Tenants    []string `json:"tenants,omitempty"`
	Namespaces []string `json:"namespaces,omitempty"`
}

func (o *PolicyTarget) GetTenants() []string    { return o.Tenants }
func (o *PolicyTarget) GetNamespaces() []string { return o.Namespaces }

// ApiPolicySummary is a policy as returned by the search endpoints, with rule
// counts instead of the full rule list.
type ApiPolicySummary struct {
	Id          string            `json:"id"`
	DisplayName string            `json:"displayName,omitempty"`
	Description string            `json:"description,omitempty"`
	Scope       string            `json:"scope,omitempty"`
	Namespace   string            `json:"namespace,omitempty"`
	Target      *PolicyTarget     `json:"target,omitempty"`
	Enforcement string            `json:"enforcement,omitempty"`
	Rules       PolicyRuleSummary `json:"rules"`
}

func (o *ApiPolicySummary) GetId() string                { return o.Id }
func (o *ApiPolicySummary) GetScope() string             { return o.Scope }
func (o *ApiPolicySummary) GetRules() PolicyRuleSummary  { return o.Rules }

// PolicyRuleSummary counts a policy's rules by kind.
type PolicyRuleSummary struct {
	Mutate   int32 `json:"mutate"`
	Validate int32 `json:"validate"`
}

// PagedResultsApiPolicySummary is a page of policy summaries.
type PagedResultsApiPolicySummary struct {
	Results []ApiPolicySummary `json:"results"`
	Total   int64              `json:"total"`
}

func (o *PagedResultsApiPolicySummary) GetResults() []ApiPolicySummary { return o.Results }
func (o *PagedResultsApiPolicySummary) GetTotal() int64                { return o.Total }

// ApiPolicyEvaluation is the dry-run result of evaluating a policy against the
// flows it targets.
type ApiPolicyEvaluation struct {
	Counts  PolicyEvaluationCounts   `json:"counts"`
	Total   int64                    `json:"total"`
	Results []map[string]interface{} `json:"results,omitempty"`
}

func (o *ApiPolicyEvaluation) GetCounts() PolicyEvaluationCounts { return o.Counts }
func (o *ApiPolicyEvaluation) GetTotal() int64                   { return o.Total }

// PolicyEvaluationCounts tallies a policy evaluation.
type PolicyEvaluationCounts struct {
	Scanned     int64 `json:"scanned"`
	Mutated     int64 `json:"mutated"`
	Violating   int64 `json:"violating"`
	Conflicting int64 `json:"conflicting"`
}
