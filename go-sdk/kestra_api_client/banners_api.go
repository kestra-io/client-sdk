package kestra_api_client

import "context"

// BannersAPI covers the instance-level /api/v1/banners routes. Banners are
// instance-wide announcements; every endpoint requires the caller to be an
// instance owner and is therefore not tenant-scoped.
type BannersAPI struct {
	baseAPI
}

// SearchBanners returns every banner. The optional filters use the BANNER query
// filter format; pass nil to list them all.
func (a *BannersAPI) SearchBanners(ctx context.Context, filters []SearchFilter) ([]Banner, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[[]Banner](&a.baseAPI, ctx, "GET", superadminPath("banners", "search"), nil, params)
}

// CreateBanner creates a banner. The server forces it active and clears any
// tenantId in the body, so the returned banner carries the server-assigned id.
func (a *BannersAPI) CreateBanner(ctx context.Context, banner Banner) (*Banner, error) {
	result, err := doJSON[Banner](&a.baseAPI, ctx, "POST", superadminPath("banners"), banner, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateBanner updates the banner with the given id. The body id must match the
// path id or the server answers 422.
func (a *BannersAPI) UpdateBanner(ctx context.Context, id string, banner Banner) (*Banner, error) {
	result, err := doJSON[Banner](&a.baseAPI, ctx, "PUT", superadminPath("banners", id), banner, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteBanner deletes the banner with the given id.
func (a *BannersAPI) DeleteBanner(ctx context.Context, id string) error {
	return a.doVoid(ctx, "DELETE", superadminPath("banners", id), nil, nil)
}
