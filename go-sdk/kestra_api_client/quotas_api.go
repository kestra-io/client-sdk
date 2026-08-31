package kestra_api_client

import "context"

type QuotasAPI struct {
	baseAPI
}

// SearchQuotaLimits returns the current quota limit counters of the tenant.
func (a *QuotasAPI) SearchQuotaLimits(ctx context.Context, tenant string) ([]QuotaLimit, error) {
	return doJSON[[]QuotaLimit](&a.baseAPI, ctx, "GET", tenantPath(tenant, "quota-limits"), nil, nil)
}

// ResetQuotaLimit resets one quota limit counter. Namespace and flowId narrow
// the reset to a namespace- or flow-scoped counter; nil targets the
// tenant-wide one.
func (a *QuotasAPI) ResetQuotaLimit(ctx context.Context, tenant, id string, namespace, flowId *string) error {
	request := map[string]interface{}{
		"id":        id,
		"namespace": namespace,
		"flowId":    flowId,
	}
	return a.doVoidJSON(ctx, "POST", tenantPath(tenant, "quota-limits", "reset"), request, nil)
}
