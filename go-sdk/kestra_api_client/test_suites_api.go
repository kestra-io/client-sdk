package kestra_api_client

import "context"

type TestSuitesAPI struct {
	baseAPI
}

func (a *TestSuitesAPI) CreateTestSuite(ctx context.Context, tenant, yamlBody string) (*TestSuite, error) {
	return doJSONWithYAMLBody[*TestSuite](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests"), yamlBody, nil)
}

func (a *TestSuitesAPI) TestSuite(ctx context.Context, namespace, id, tenant string) (*TestSuite, error) {
	return doJSON[*TestSuite](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tests", namespace, id), nil, nil)
}

func (a *TestSuitesAPI) UpdateTestSuite(ctx context.Context, namespace, id, tenant, yamlBody string) (*TestSuite, error) {
	return doJSONWithYAMLBody[*TestSuite](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "tests", namespace, id), yamlBody, nil)
}

func (a *TestSuitesAPI) DeleteTestSuite(ctx context.Context, namespace, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "tests", namespace, id), nil, nil)
}

func (a *TestSuitesAPI) DeleteTestSuitesByIds(ctx context.Context, tenant string, request interface{}) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "tests", "by-ids"), request, nil)
}

func (a *TestSuitesAPI) EnableTestSuitesByIds(ctx context.Context, tenant string, request interface{}) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", "enable", "by-ids"), request, nil)
}

func (a *TestSuitesAPI) DisableTestSuitesByIds(ctx context.Context, tenant string, request interface{}) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", "disable", "by-ids"), request, nil)
}

func (a *TestSuitesAPI) RunTestSuite(ctx context.Context, namespace, id, tenant string, request interface{}) (*TestSuiteRunResult, error) {
	return doJSON[*TestSuiteRunResult](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", namespace, id, "run"), request, nil)
}

func (a *TestSuitesAPI) RunTestSuitesByQuery(ctx context.Context, tenant string, request interface{}) (*TestSuiteServiceTestRunByQueryResult, error) {
	return doJSON[*TestSuiteServiceTestRunByQueryResult](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", "run"), request, nil)
}

func (a *TestSuitesAPI) SearchTestSuites(ctx context.Context, tenant string, page, size *int, sort []string, namespace, flowId *string, includeChildNamespaces *bool) (*PagedResultsTestSuite, error) {
	params := buildQueryParams("page", page, "size", size, "namespace", namespace, "flowId", flowId, "includeChildNamespaces", includeChildNamespaces)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsTestSuite](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tests", "search"), nil, params)
}

func (a *TestSuitesAPI) TestResult(ctx context.Context, id, tenant string) (*TestSuiteRunResult, error) {
	return doJSON[*TestSuiteRunResult](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tests", "results", id), nil, nil)
}

func (a *TestSuitesAPI) SearchTestSuitesResults(ctx context.Context, tenant string, page, size *int, sort []string, testSuiteId, namespace, flowId *string) (*PagedResultsTestSuiteRunResult, error) {
	params := buildQueryParams("page", page, "size", size, "testSuiteId", testSuiteId, "namespace", namespace, "flowId", flowId)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsTestSuiteRunResult](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tests", "results", "search"), nil, params)
}

func (a *TestSuitesAPI) TestsLastResult(ctx context.Context, tenant string, request interface{}) (*TestSuiteControllerTestsLastResultResponse, error) {
	return doJSON[*TestSuiteControllerTestsLastResultResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", "results", "search", "last"), request, nil)
}

func (a *TestSuitesAPI) ValidateTestSuite(ctx context.Context, tenant, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tests", "validate"), yamlBody, nil)
}
