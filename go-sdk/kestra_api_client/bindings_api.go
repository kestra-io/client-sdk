package kestra_api_client

import "context"

type BindingsAPI struct {
	baseAPI
}

func (a *BindingsAPI) CreateBinding(ctx context.Context, tenant string, request interface{}) (*IAMBindingControllerApiBindingDetail, error) {
	return doJSON[*IAMBindingControllerApiBindingDetail](&a.baseAPI, ctx, "POST", tenantPath(tenant, "bindings"), request, nil)
}

func (a *BindingsAPI) BulkCreateBinding(ctx context.Context, tenant string, requests interface{}) ([]IAMBindingControllerApiBindingDetail, error) {
	return doJSON[[]IAMBindingControllerApiBindingDetail](&a.baseAPI, ctx, "POST", tenantPath(tenant, "bindings", "bulk"), requests, nil)
}

func (a *BindingsAPI) Binding(ctx context.Context, id, tenant string) (*IAMBindingControllerApiBindingDetail, error) {
	return doJSON[*IAMBindingControllerApiBindingDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "bindings", id), nil, nil)
}

func (a *BindingsAPI) DeleteBinding(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "bindings", id), nil, nil)
}

func (a *BindingsAPI) SearchBindings(ctx context.Context, tenant string, page, size *int, sort []string, bindingType *BindingType, externalId, namespace *string, filters []SearchFilter) (*PagedResultsIAMBindingControllerApiBindingDetail, error) {
	params := buildQueryParams("page", page, "size", size, "id", externalId, "namespace", namespace)
	if bindingType != nil {
		// Set explicitly: buildQueryParams' default branch would print a *BindingType as a pointer address.
		params.Set("type", string(*bindingType))
	}
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMBindingControllerApiBindingDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "bindings", "search"), nil, params)
}
