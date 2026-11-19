// The `@kestra-io/kestra-sdk/executions` subpath: the generated Executions operations
// plus typed overloads for the two bulk deletes whose success body depends on `async`.
//
// `DELETE /executions/by-ids` and `/executions/by-query` are the only operations in the
// spec whose 2xx responses carry different bodies (200 -> BulkResponse when `async` is
// false, 202 -> ApiAsyncOperationResponse when `async` is true). hey-api types the wrapper
// as the union of both, which forces every caller to narrow it. The overloads below
// narrow the return type on the `async` flag instead, and the `*InBackground` variants
// give the same split as the Java/Python/Go SDKs (#512). There is no runtime change:
// every call is passed through unchanged to the generated wrapper. The generated module
// can't carry this (src/openapi/ is regenerated), so this wrapper replaces the generated
// `executions` entry in tsdown.config.ts.
import * as gen from "./openapi/sdk/Executions.gen"
import type { ApiAsyncOperationResponse, BulkResponse } from "./openapi/types.gen"

// An explicit local export wins over this `export *`.
export * from "./openapi/sdk/Executions.gen"

type ByIdsParams = Parameters<typeof gen.deleteExecutionsByIds>[0]
type ByIdsOptions = Parameters<typeof gen.deleteExecutionsByIds>[1]
type ByQueryParams = Parameters<typeof gen.deleteExecutionsByQuery>[0]
type ByQueryOptions = Parameters<typeof gen.deleteExecutionsByQuery>[1]

/**
 * Delete executions by id.
 *
 * Resolves with a `BulkResponse` (the deletion is done when it returns) unless
 * `async: true` is passed, in which case it resolves with an `ApiAsyncOperationResponse`
 * and the deletion runs in the background. `async` needs Kestra 2.1 or later; older
 * servers ignore it and answer synchronously.
 */
export function deleteExecutionsByIds(parameters: ByIdsParams & { async?: false }, options?: ByIdsOptions): Promise<BulkResponse>
export function deleteExecutionsByIds(parameters: ByIdsParams & { async: true }, options?: ByIdsOptions): Promise<ApiAsyncOperationResponse>
export function deleteExecutionsByIds(parameters: ByIdsParams & { async?: boolean }, options?: ByIdsOptions): Promise<BulkResponse | ApiAsyncOperationResponse>
export function deleteExecutionsByIds(parameters: ByIdsParams, options?: ByIdsOptions): Promise<BulkResponse | ApiAsyncOperationResponse> {
    return gen.deleteExecutionsByIds(parameters, options)
}

/**
 * Delete executions matching query filters.
 *
 * Resolves with a `BulkResponse` (the deletion is done when it returns) unless
 * `async: true` is passed, in which case it resolves with an `ApiAsyncOperationResponse`
 * and the deletion runs in the background. `async` needs Kestra 2.1 or later; older
 * servers ignore it and answer synchronously.
 */
export function deleteExecutionsByQuery(parameters?: ByQueryParams & { async?: false }, options?: ByQueryOptions): Promise<BulkResponse>
export function deleteExecutionsByQuery(parameters: ByQueryParams & { async: true }, options?: ByQueryOptions): Promise<ApiAsyncOperationResponse>
export function deleteExecutionsByQuery(parameters?: ByQueryParams & { async?: boolean }, options?: ByQueryOptions): Promise<BulkResponse | ApiAsyncOperationResponse>
export function deleteExecutionsByQuery(parameters?: ByQueryParams, options?: ByQueryOptions): Promise<BulkResponse | ApiAsyncOperationResponse> {
    return gen.deleteExecutionsByQuery(parameters, options)
}

/**
 * Delete executions by id in the background: sends `async: true` and resolves with an
 * `ApiAsyncOperationResponse` (`operationId`, `totalItems`) as soon as the deletion is
 * queued. The executions disappear later, so poll to observe it. Needs Kestra 2.1 or
 * later; older servers delete synchronously and answer with a `BulkResponse`.
 */
export function deleteExecutionsByIdsInBackground(parameters: Omit<ByIdsParams, "async">, options?: ByIdsOptions): Promise<ApiAsyncOperationResponse> {
    return gen.deleteExecutionsByIds({ ...parameters, async: true }, options) as Promise<ApiAsyncOperationResponse>
}

/**
 * Delete executions matching query filters in the background: sends `async: true` and
 * resolves with an `ApiAsyncOperationResponse` (`operationId`, `totalItems`) as soon as
 * the deletion is queued. The executions disappear later, so poll to observe it. Needs
 * Kestra 2.1 or later; older servers delete synchronously and answer with a `BulkResponse`.
 */
export function deleteExecutionsByQueryInBackground(parameters?: Omit<NonNullable<ByQueryParams>, "async">, options?: ByQueryOptions): Promise<ApiAsyncOperationResponse> {
    return gen.deleteExecutionsByQuery({ ...parameters, async: true }, options) as Promise<ApiAsyncOperationResponse>
}
