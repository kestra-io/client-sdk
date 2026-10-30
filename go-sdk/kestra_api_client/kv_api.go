package kestra_api_client

import (
	"context"
)

type KvAPI struct {
	baseAPI
}

func (a *KvAPI) SetKeyValue(ctx context.Context, namespace, key, tenant, body string) error {
	return a.doVoidText(ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "kv", key), body, nil)
}

func (a *KvAPI) KeyValue(ctx context.Context, namespace, key, tenant string) (*KvDetail, error) {
	return doJSON[*KvDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "kv", key), nil, nil)
}

func (a *KvAPI) DeleteKeyValue(ctx context.Context, namespace, key, tenant string) (*bool, error) {
	return doJSON[*bool](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "kv", key), nil, nil)
}

func (a *KvAPI) DeleteKeyValues(ctx context.Context, namespace, tenant string, request KVControllerApiDeleteBulkRequest) (*KVControllerApiDeleteBulkResponse, error) {
	return doJSON[*KVControllerApiDeleteBulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "kv"), request, nil)
}

func (a *KvAPI) ListAllKeys(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsKVEntry, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsKVEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "kv"), nil, params)
}

func (a *KvAPI) ListKeysWithInheritance(ctx context.Context, namespace, tenant string) ([]KVEntry, error) {
	return doJSON[[]KVEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "kv", "inheritance"), nil, nil)
}

func (a *KvAPI) SetKeyValueWithTTL(ctx context.Context, namespace, key, tenant, body string, ttl *string) error {
	return a.SetKeyValueWithOptions(ctx, namespace, key, tenant, body, ttl, nil)
}

func (a *KvAPI) SetKeyValueWithOptions(ctx context.Context, namespace, key, tenant, body string, ttl, description *string) error {
	headers := map[string]string{}
	if ttl != nil {
		headers["ttl"] = *ttl
	}
	if description != nil {
		headers["description"] = *description
	}
	return a.doVoidTextWithHeaders(ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "kv", key), body, nil, headers)
}
