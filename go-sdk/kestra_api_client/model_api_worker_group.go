package kestra_api_client

import "time"

// ApiWorkerGroup is the API representation of a worker group returned by the
// /api/v1/instance/worker-groups endpoints (Kestra 2.0 shape).
type ApiWorkerGroup struct {
	Id            string                       `json:"id"`
	Name          string                       `json:"name"`
	Description   string                       `json:"description,omitempty"`
	Subscriptions []ApiSubscriptionResponse    `json:"subscriptions,omitempty"`
	Tokens        []ApiWorkerGroupTokenSummary `json:"tokens,omitempty"`
	Deletable     bool                         `json:"deletable"`
	CreatedAt     *time.Time                   `json:"createdAt,omitempty"`
	UpdatedAt     *time.Time                   `json:"updatedAt,omitempty"`
}

func (o *ApiWorkerGroup) GetId() string                           { return o.Id }
func (o *ApiWorkerGroup) GetName() string                         { return o.Name }
func (o *ApiWorkerGroup) GetDescription() string                  { return o.Description }
func (o *ApiWorkerGroup) GetSubscriptions() []ApiSubscriptionResponse { return o.Subscriptions }
func (o *ApiWorkerGroup) GetTokens() []ApiWorkerGroupTokenSummary { return o.Tokens }
func (o *ApiWorkerGroup) GetDeletable() bool                      { return o.Deletable }
func (o *ApiWorkerGroup) GetCreatedAt() *time.Time                { return o.CreatedAt }
func (o *ApiWorkerGroup) GetUpdatedAt() *time.Time                { return o.UpdatedAt }

// ApiWorkerGroupList wraps the worker groups returned by the list endpoint.
type ApiWorkerGroupList struct {
	WorkerGroups []ApiWorkerGroup `json:"workerGroups,omitempty"`
}

func (o *ApiWorkerGroupList) GetWorkerGroups() []ApiWorkerGroup { return o.WorkerGroups }

// ApiWorkerGroupTokenSummary describes a worker-group registration token without
// exposing its secret value.
type ApiWorkerGroupTokenSummary struct {
	Uid         string     `json:"uid"`
	Name        string     `json:"name"`
	Description string     `json:"description,omitempty"`
	TokenPrefix string     `json:"tokenPrefix,omitempty"`
	CreatedAt   *time.Time `json:"createdAt,omitempty"`
	ExpiresAt   *time.Time `json:"expiresAt,omitempty"`
	UseCount    int32      `json:"useCount"`
	Revoked     bool       `json:"revoked"`
	Valid       bool       `json:"valid"`
}

func (o *ApiWorkerGroupTokenSummary) GetUid() string      { return o.Uid }
func (o *ApiWorkerGroupTokenSummary) GetName() string     { return o.Name }
func (o *ApiWorkerGroupTokenSummary) GetTokenPrefix() string { return o.TokenPrefix }
func (o *ApiWorkerGroupTokenSummary) GetRevoked() bool    { return o.Revoked }
func (o *ApiWorkerGroupTokenSummary) GetValid() bool      { return o.Valid }

// ApiGenerateTokenRequest is the body of POST worker-groups/{id}/tokens. A nil
// ExpiresAt creates a token that never expires.
type ApiGenerateTokenRequest struct {
	Name        string     `json:"name"`
	Description string     `json:"description,omitempty"`
	ExpiresAt   *time.Time `json:"expiresAt,omitempty"`
}

// ApiGenerateTokenResponse carries the plaintext token, returned exactly once.
type ApiGenerateTokenResponse struct {
	Token   string                     `json:"token"`
	Details ApiWorkerGroupTokenSummary `json:"details"`
}

func (o *ApiGenerateTokenResponse) GetToken() string                      { return o.Token }
func (o *ApiGenerateTokenResponse) GetDetails() ApiWorkerGroupTokenSummary { return o.Details }

// ApiCreateWorkerGroupRequest is the body of the worker-group create endpoint.
// Subscriptions must be non-nil (it may be empty).
type ApiCreateWorkerGroupRequest struct {
	Id            string                    `json:"id"`
	Name          string                    `json:"name"`
	Description   string                    `json:"description,omitempty"`
	Subscriptions []ApiSubscriptionRequest  `json:"subscriptions"`
}

// ApiUpdateWorkerGroupRequest is the body of the worker-group update endpoint.
type ApiUpdateWorkerGroupRequest struct {
	Name          string                   `json:"name"`
	Description   string                   `json:"description,omitempty"`
	Subscriptions []ApiSubscriptionRequest `json:"subscriptions"`
}

// ApiSubscriptionRequest subscribes a worker group to a worker queue.
// ReservedPercent is -1 (unset) or 1..100. Mode is STRICT (default) or ELASTIC.
type ApiSubscriptionRequest struct {
	WorkerQueueId   string `json:"workerQueueId"`
	ReservedPercent int32  `json:"reservedPercent"`
	Mode            string `json:"mode,omitempty"`
}

// ApiUpdateSubscriptionRequest changes a subscription's reserved capacity.
type ApiUpdateSubscriptionRequest struct {
	ReservedPercent int32 `json:"reservedPercent"`
}

// ApiSubscriptionResponse is a worker group's subscription to a worker queue.
type ApiSubscriptionResponse struct {
	Queue           ApiWorkerQueueSummary `json:"queue"`
	ReservedPercent int32                 `json:"reservedPercent"`
	Mode            string                `json:"mode,omitempty"`
}

func (o *ApiSubscriptionResponse) GetQueue() ApiWorkerQueueSummary { return o.Queue }
func (o *ApiSubscriptionResponse) GetReservedPercent() int32       { return o.ReservedPercent }
func (o *ApiSubscriptionResponse) GetMode() string                 { return o.Mode }

// ApiWorkerQueueSummary is the compact worker-queue reference embedded in a
// subscription.
type ApiWorkerQueueSummary struct {
	Id             string   `json:"id"`
	Name           string   `json:"name,omitempty"`
	Tags           []string `json:"tags,omitempty"`
	AllowedTenants []string `json:"allowedTenants,omitempty"`
}

func (o *ApiWorkerQueueSummary) GetId() string   { return o.Id }
func (o *ApiWorkerQueueSummary) GetName() string { return o.Name }
