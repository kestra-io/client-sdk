package kestra_api_client

import "context"

type MiscAPI struct {
	baseAPI
}

func (a *MiscAPI) Configuration(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", "/api/v1/configs", nil, nil)
}

func (a *MiscAPI) Ping(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", "/api/v1/configs", nil, nil)
}
