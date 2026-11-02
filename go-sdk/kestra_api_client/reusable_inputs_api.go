package kestra_api_client

import "context"

// ReusableInputsAPI provides methods for managing namespace-scoped reusable
// inputs blocks: named sets of flow input definitions that flows reference via
// a REUSABLE_INPUTS input.
type ReusableInputsAPI struct {
	baseAPI
}

// ListReusableInputs lists the blocks visible from a namespace, resolving
// namespace inheritance: blocks defined in parent namespaces are included.
// Without allowDraft, only the blocks an execution can use are listed, each as
// the revision it would run.
func (a *ReusableInputsAPI) ListReusableInputs(ctx context.Context, namespace, tenant string, page, size *int, allowDraft *bool) (*PagedResultsReusableInputsWithSource, error) {
	path := tenantPath(tenant, "namespaces", namespace, "reusable-inputs")
	params := buildQueryParams("page", page, "size", size, "allowDraft", allowDraft)
	result, err := doJSON[PagedResultsReusableInputsWithSource](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ReusableInputs retrieves a single block, resolving namespace inheritance: the
// closest namespace defining it wins. Without allowDraft, a nil revision returns
// the revision an execution would use, the latest that isn't a draft; a block
// with only drafts fails with a 422.
func (a *ReusableInputsAPI) ReusableInputs(ctx context.Context, namespace, id, tenant string, revision *int, allowDraft *bool) (*ReusableInputsWithSource, error) {
	path := tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id)
	params := buildQueryParams("revision", revision, "allowDraft", allowDraft)
	result, err := doJSON[ReusableInputsWithSource](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ListReusableInputsRevisions lists all revisions of a block. Unlike the other
// read methods it does not resolve inheritance: the block must exist in the
// given namespace.
func (a *ReusableInputsAPI) ListReusableInputsRevisions(ctx context.Context, namespace, id, tenant string) ([]ReusableInputsWithSource, error) {
	path := tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id, "revisions")
	result, err := doJSON[[]ReusableInputsWithSource](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// CreateOrUpdateReusableInputs creates or updates a block from its YAML source.
// failIfExists rejects an existing block with a 409 instead of updating it.
// draft saves the revision as a draft, which executions skip and which may be
// invalid.
func (a *ReusableInputsAPI) CreateOrUpdateReusableInputs(ctx context.Context, namespace, id, tenant, yamlBody string, failIfExists, draft *bool) (*ReusableInputsWithSource, error) {
	path := tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id)
	params := buildQueryParams("failIfExists", failIfExists, "draft", draft)
	result, err := doJSONWithYAMLBody[ReusableInputsWithSource](&a.baseAPI, ctx, "PUT", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteReusableInputs deletes a block from the exact namespace it is defined
// in; inheritance is not resolved.
func (a *ReusableInputsAPI) DeleteReusableInputs(ctx context.Context, namespace, id, tenant string) error {
	path := tenantPath(tenant, "namespaces", namespace, "reusable-inputs", id)
	return a.doVoid(ctx, "DELETE", path, nil, nil)
}

// ListReusableInputsNamespaces lists the namespaces that define at least one
// block, for editor autocompletion.
func (a *ReusableInputsAPI) ListReusableInputsNamespaces(ctx context.Context, tenant string) ([]string, error) {
	path := tenantPath(tenant, "reusable-inputs", "namespaces")
	result, err := doJSON[[]string](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return result, nil
}
