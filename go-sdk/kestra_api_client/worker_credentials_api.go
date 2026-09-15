package kestra_api_client

import (
	"context"
	"time"
)

// WorkerCredentialsAPI covers /api/v1/instance/workers/credentials. The whole
// controller only loads when worker authentication is enabled
// (kestra.ee.worker.auth.enabled=true); otherwise every route answers 403.
type WorkerCredentialsAPI struct {
	baseAPI
}

// ApiWorkerCredential is a registered worker's credential.
type ApiWorkerCredential struct {
	Id         string     `json:"id"`
	WorkerId   string     `json:"workerId,omitempty"`
	WorkerName string     `json:"workerName,omitempty"`
	TokenUid   string     `json:"tokenUid,omitempty"`
	CreatedAt  *time.Time `json:"createdAt,omitempty"`
	LastSeenAt *time.Time `json:"lastSeenAt,omitempty"`
}

func (o *ApiWorkerCredential) GetId() string       { return o.Id }
func (o *ApiWorkerCredential) GetWorkerId() string { return o.WorkerId }
func (o *ApiWorkerCredential) GetTokenUid() string { return o.TokenUid }

// ApiWorkerCredentialList wraps the worker credentials returned by the list endpoint.
type ApiWorkerCredentialList struct {
	Workers []ApiWorkerCredential `json:"workers,omitempty"`
}

func (o *ApiWorkerCredentialList) GetWorkers() []ApiWorkerCredential { return o.Workers }

// ListWorkerCredentials returns every registered worker credential.
func (a *WorkerCredentialsAPI) ListWorkerCredentials(ctx context.Context) (*ApiWorkerCredentialList, error) {
	return doJSON[*ApiWorkerCredentialList](&a.baseAPI, ctx, "GET", superadminPath("instance", "workers", "credentials"), nil, nil)
}

// WorkerCredential returns a single worker credential by id.
func (a *WorkerCredentialsAPI) WorkerCredential(ctx context.Context, id string) (*ApiWorkerCredential, error) {
	return doJSON[*ApiWorkerCredential](&a.baseAPI, ctx, "GET", superadminPath("instance", "workers", "credentials", id), nil, nil)
}

// RevokeWorkerCredential revokes a registered worker's credential.
func (a *WorkerCredentialsAPI) RevokeWorkerCredential(ctx context.Context, id string) (*ApiWorkerCredential, error) {
	return doJSON[*ApiWorkerCredential](&a.baseAPI, ctx, "POST", superadminPath("instance", "workers", "credentials", id, "revoke"), nil, nil)
}
