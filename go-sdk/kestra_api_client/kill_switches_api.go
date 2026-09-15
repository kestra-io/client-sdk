package kestra_api_client

import "context"

// KillSwitchesAPI covers the instance-level /api/v1/kill-switches routes. Kill
// switches pause execution evaluation across the instance; every endpoint
// requires the caller to be an instance owner and is not tenant-scoped.
type KillSwitchesAPI struct {
	baseAPI
}

// SearchKillSwitches returns every kill switch across all tenants.
func (a *KillSwitchesAPI) SearchKillSwitches(ctx context.Context) ([]KillSwitch, error) {
	return doJSON[[]KillSwitch](&a.baseAPI, ctx, "GET", superadminPath("kill-switches", "search"), nil, nil)
}

// CreateKillSwitch creates a kill switch and broadcasts it to the cluster.
func (a *KillSwitchesAPI) CreateKillSwitch(ctx context.Context, killSwitch KillSwitch) (*KillSwitch, error) {
	result, err := doJSON[KillSwitch](&a.baseAPI, ctx, "POST", superadminPath("kill-switches"), killSwitch, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateKillSwitch updates the kill switch with the given id. The body id must
// match the path id or the server answers 422.
func (a *KillSwitchesAPI) UpdateKillSwitch(ctx context.Context, id string, killSwitch KillSwitch) (*KillSwitch, error) {
	result, err := doJSON[KillSwitch](&a.baseAPI, ctx, "PUT", superadminPath("kill-switches", id), killSwitch, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteKillSwitch deletes the kill switch with the given id.
func (a *KillSwitchesAPI) DeleteKillSwitch(ctx context.Context, id string) error {
	return a.doVoid(ctx, "DELETE", superadminPath("kill-switches", id), nil, nil)
}
