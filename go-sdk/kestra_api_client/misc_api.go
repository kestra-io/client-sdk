package kestra_api_client

import "context"

type MiscAPI struct {
	baseAPI
}

// Configuration returns the instance UI/runtime configuration. Backs GET /api/v1/configs.
func (a *MiscAPI) Configuration(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("configs"), nil, nil)
}

// LoginConfiguration returns the configuration needed to render the login page
// (enabled auth methods, SSO providers). Backs GET /api/v1/configs/login.
func (a *MiscAPI) LoginConfiguration(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("configs", "login"), nil, nil)
}

// Ping returns the instance configuration; used as a lightweight reachability
// check. Backs GET /api/v1/configs.
func (a *MiscAPI) Ping(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("configs"), nil, nil)
}

// PebbleFilters lists the available Pebble template filters. Backs GET /api/v1/pebble/filters.
func (a *MiscAPI) PebbleFilters(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("pebble", "filters"), nil, nil)
}

// PebbleFunctions lists the available Pebble template functions. Backs GET /api/v1/pebble/functions.
func (a *MiscAPI) PebbleFunctions(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("pebble", "functions"), nil, nil)
}
