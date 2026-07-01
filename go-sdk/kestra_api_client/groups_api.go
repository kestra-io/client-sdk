package kestra_api_client

import "context"

type GroupsAPI struct {
	baseAPI
}

func (a *GroupsAPI) CreateGroup(ctx context.Context, tenant string, request interface{}) (*IAMGroupControllerApiGroupDetail, error) {
	return doJSON[*IAMGroupControllerApiGroupDetail](&a.baseAPI, ctx, "POST", tenantPath(tenant, "groups"), request, nil)
}

func (a *GroupsAPI) Group(ctx context.Context, id, tenant string) (*IAMGroupControllerApiGroupDetail, error) {
	return doJSON[*IAMGroupControllerApiGroupDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "groups", id), nil, nil)
}

func (a *GroupsAPI) UpdateGroup(ctx context.Context, id, tenant string, request interface{}) (*IAMGroupControllerApiGroupDetail, error) {
	return doJSON[*IAMGroupControllerApiGroupDetail](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "groups", id), request, nil)
}

func (a *GroupsAPI) DeleteGroup(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "groups", id), nil, nil)
}

func (a *GroupsAPI) AddUserToGroup(ctx context.Context, id, userId, tenant string) (*IAMGroupControllerApiGroupMember, error) {
	return doJSON[*IAMGroupControllerApiGroupMember](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "groups", id, "members", userId), nil, nil)
}

func (a *GroupsAPI) DeleteUserFromGroup(ctx context.Context, id, userId, tenant string) (*IAMGroupControllerApiGroupMember, error) {
	return doJSON[*IAMGroupControllerApiGroupMember](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "groups", id, "members", userId), nil, nil)
}

func (a *GroupsAPI) SetUserMembershipForGroup(ctx context.Context, id, userId, tenant string, membership *string) (*IAMGroupControllerApiGroupMember, error) {
	params := buildQueryParams("membership", membership)
	return doJSON[*IAMGroupControllerApiGroupMember](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "groups", id, "members", "membership", userId), nil, params)
}

func (a *GroupsAPI) SearchGroupMembers(ctx context.Context, id, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsIAMGroupControllerApiGroupMember, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMGroupControllerApiGroupMember](&a.baseAPI, ctx, "GET", tenantPath(tenant, "groups", id, "members"), nil, params)
}

func (a *GroupsAPI) SearchGroups(ctx context.Context, tenant string, page, size *int, sort []string, q *string) (*PagedResultsApiGroupSummary, error) {
	params := buildQueryParams("q", q, "page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsApiGroupSummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "groups", "search"), nil, params)
}

func (a *GroupsAPI) AutocompleteGroups(ctx context.Context, tenant string, request interface{}, filters []SearchFilter) ([]ApiGroupSummary, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[[]ApiGroupSummary](&a.baseAPI, ctx, "POST", tenantPath(tenant, "groups", "autocomplete"), request, params)
}

func (a *GroupsAPI) ListGroupIds(ctx context.Context, tenant string, ids []string) ([]ApiGroupSummary, error) {
	return doJSON[[]ApiGroupSummary](&a.baseAPI, ctx, "POST", tenantPath(tenant, "groups", "ids"), ApiIds{Ids: ids}, nil)
}
