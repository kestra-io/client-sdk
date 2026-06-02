package kestra_api_client

import "context"

type InvitationsAPI struct {
	baseAPI
}

// CreateInvitation creates an invitation. When the invitee already has a user
// account, or when CreateUserIfNotExist is set, the server grants tenant access
// directly and responds 204 No Content — in that case the returned detail is nil
// with a nil error. A genuinely new invitation responds 201 with the detail.
func (a *InvitationsAPI) CreateInvitation(ctx context.Context, tenant string, request IAMInvitationControllerApiInvitationCreateRequest) (*IAMInvitationControllerApiInvitationDetail, error) {
	return doJSON[*IAMInvitationControllerApiInvitationDetail](&a.baseAPI, ctx, "POST", tenantPath(tenant, "invitations"), request, nil)
}

func (a *InvitationsAPI) Invitation(ctx context.Context, id, tenant string) (*IAMInvitationControllerApiInvitationDetail, error) {
	return doJSON[*IAMInvitationControllerApiInvitationDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "invitations", id), nil, nil)
}

func (a *InvitationsAPI) ListInvitationsByEmail(ctx context.Context, email, tenant string) ([]IAMInvitationControllerApiInvitationDetail, error) {
	return doJSON[[]IAMInvitationControllerApiInvitationDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "invitations", "email", email), nil, nil)
}

func (a *InvitationsAPI) DeleteInvitation(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "invitations", id), nil, nil)
}

// SearchInvitations lists invitations. The email and status params are honored
// by both Kestra 1.3 and 2.x (2.x marks them deprecated but still maps them
// internally), so prefer them for 1.3+2.x compatibility. The filters array is
// only interpreted by Kestra 2.x — the 1.3 invitation search endpoint has no
// filters parameter, so any filters passed are silently ignored there. Use it
// only for the 2.x-only fields (FilterQuery, FilterExpiredAt, FilterSuperAdmin),
// and don't combine it with email on 2.x (filters take precedence over the
// legacy email mapping there). Mirrors the hybrid shape of SearchApps.
func (a *InvitationsAPI) SearchInvitations(ctx context.Context, tenant string, page, size *int, sort []string, email *string, status *InvitationInvitationStatus, filters []QueryFilter) (*PagedResultsIAMInvitationControllerApiInvitationDetail, error) {
	params := buildQueryParams("page", page, "size", size, "email", email)
	if status != nil {
		// Set explicitly: buildQueryParams' default branch would print a *InvitationInvitationStatus as a pointer address.
		params.Set("status", string(*status))
	}
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMInvitationControllerApiInvitationDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "invitations", "search"), nil, params)
}
