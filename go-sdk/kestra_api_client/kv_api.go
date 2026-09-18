package kestra_api_client

import (
	"context"
	"net/url"
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
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsKVEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "kv"), nil, params)
}

func (a *KvAPI) ListKeysWithInheritance(ctx context.Context, namespace, tenant string) ([]KVEntry, error) {
	return doJSON[[]KVEntry](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "kv", "inheritance"), nil, nil)
}

func (a *KvAPI) SetKeyValueWithTTL(ctx context.Context, namespace, key, tenant, body string, ttl *string) error {
	var params url.Values
	if ttl != nil {
		params = buildQueryParams("ttl", ttl)
	}
	return a.doVoidText(ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "kv", key), body, params)
}
