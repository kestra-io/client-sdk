package kestra_api_client

import "context"

// MeAPI covers /api/v1/me — the endpoints that act on the currently
// authenticated user. None of these paths carry a tenant segment.
type MeAPI struct {
	baseAPI
}

// ApiProfile is the current user's profile block.
type ApiProfile struct {
	Email     string `json:"email,omitempty"`
	FirstName string `json:"firstName,omitempty"`
	LastName  string `json:"lastName,omitempty"`
	Username  string `json:"username,omitempty"`
}

func (o *ApiProfile) GetEmail() string    { return o.Email }
func (o *ApiProfile) GetUsername() string { return o.Username }

// ApiMe is the response of GET /api/v1/me.
type ApiMe struct {
	Id            string                   `json:"id"`
	InstanceOwner bool                     `json:"instanceOwner"`
	Restricted    bool                     `json:"restricted"`
	Profile       *ApiProfile              `json:"profile,omitempty"`
	Auths         []map[string]interface{} `json:"auths,omitempty"`
	Tenants       []map[string]interface{} `json:"tenants,omitempty"`
	OwnedGroups   []map[string]interface{} `json:"ownedGroups,omitempty"`
}

func (o *ApiMe) GetId() string           { return o.Id }
func (o *ApiMe) GetInstanceOwner() bool  { return o.InstanceOwner }
func (o *ApiMe) GetProfile() *ApiProfile { return o.Profile }

// The ApiToken, ApiTokenList, CreateApiTokenRequest and CreateApiTokenResponse
// models are reused from the existing generated model files.

// ApiUserDetailsRequest is the body of PATCH /api/v1/me.
type ApiUserDetailsRequest struct {
	FirstName string `json:"firstName,omitempty"`
	LastName  string `json:"lastName,omitempty"`
	Email     string `json:"email,omitempty"`
}

// ApiUpdatePasswordRequest is the body of PUT /api/v1/me/password.
type ApiUpdatePasswordRequest struct {
	OldPassword string `json:"oldPassword"`
	NewPassword string `json:"newPassword"`
}

// CurrentUser returns the authenticated user. Backs GET /api/v1/me.
func (a *MeAPI) CurrentUser(ctx context.Context) (*ApiMe, error) {
	return doJSON[*ApiMe](&a.baseAPI, ctx, "GET", superadminPath("me"), nil, nil)
}

// UpdateCurrentUser patches the authenticated user's profile. Backs PATCH /api/v1/me.
func (a *MeAPI) UpdateCurrentUser(ctx context.Context, details ApiUserDetailsRequest) (*ApiMe, error) {
	return doJSON[*ApiMe](&a.baseAPI, ctx, "PATCH", superadminPath("me"), details, nil)
}

// UpdateCurrentUserPassword changes the authenticated user's password. Backs PUT /api/v1/me/password.
func (a *MeAPI) UpdateCurrentUserPassword(ctx context.Context, request ApiUpdatePasswordRequest) error {
	return a.doVoidJSON(ctx, "PUT", superadminPath("me", "password"), request, nil)
}

// ListApiTokens lists the authenticated user's API tokens. Backs GET /api/v1/me/api-tokens.
func (a *MeAPI) ListApiTokens(ctx context.Context) (*ApiTokenList, error) {
	return doJSON[*ApiTokenList](&a.baseAPI, ctx, "GET", superadminPath("me", "api-tokens"), nil, nil)
}

// CreateApiToken mints a new API token for the authenticated user. The full
// token secret is only present in the response. Backs POST /api/v1/me/api-tokens.
func (a *MeAPI) CreateApiToken(ctx context.Context, request CreateApiTokenRequest) (*CreateApiTokenResponse, error) {
	return doJSON[*CreateApiTokenResponse](&a.baseAPI, ctx, "POST", superadminPath("me", "api-tokens"), request, nil)
}

// DeleteApiToken revokes one of the authenticated user's API tokens. Backs
// DELETE /api/v1/me/api-tokens/{tokenId}.
func (a *MeAPI) DeleteApiToken(ctx context.Context, tokenId string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("me", "api-tokens", tokenId), nil, nil)
}

// ListInvitations lists invitations addressed to the authenticated user. Backs
// GET /api/v1/me/invitations.
func (a *MeAPI) ListInvitations(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("me", "invitations"), nil, nil)
}
