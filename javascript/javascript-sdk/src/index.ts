import { client } from "./openapi/client.gen"
import { formDataBodySerializer } from "./openapi/client"
import type { ResolvedRequestOptions } from "./openapi/client"
import { createConfigureClient } from "@kestra-io/hey-api-plugin/runtime"
import { stringify as stringifyYaml } from "yaml"
import { createFlow, updateFlow } from "./openapi/sdk/Flows.gen"
import type { Flow } from "./openapi/types.gen"

// Types only: the operations live on their per-tag subpaths, or all together on `./all`.
export type * from "./openapi/types.gen"

declare global {
    interface Window {
        KESTRA_BASE_PATH: string
    }
}

export interface AxiosLikeConfig {
    params?: Record<string, unknown>
    headers?: Record<string, string>
    responseType?: "json" | "text" | "blob"
    timeout?: number
    validateStatus?: (status: number) => boolean
    [key: string]: any
}

export interface AxiosLikeResponse<T = any> {
    data: T
    status: number
    headers: Record<string, string>
    // Optional so existing setMockClient()/test mocks aren't forced to fabricate one.
    request?: { responseURL: string }
}

const commonHeaders: Record<string, string> = {}

function withQuery(url: string, params?: Record<string, unknown>): string {
    if (!params) return url
    const search = new URLSearchParams()
    for (const [key, value] of Object.entries(params)) {
        if (value === undefined || value === null) continue
        if (Array.isArray(value)) {
            value.forEach(v => search.append(key, String(v)))
        } else {
            search.append(key, typeof value === "object" ? JSON.stringify(value) : String(value))
        }
    }
    const query = search.toString()
    if (!query) return url
    return url.includes("?") ? `${url}&${query}` : `${url}?${query}`
}

/** Shares client.interceptors.* with configureClient() so ad-hoc useClient() calls get the same behavior as generated endpoint calls. */
async function axiosLikeRequest<T>(
    method: string,
    url: string,
    data?: any,
    config: AxiosLikeConfig = {}
): Promise<AxiosLikeResponse<T>> {
    const fullUrl = withQuery(url, config.params)
    const headers = new Headers({ ...commonHeaders, ...(config.headers ?? {}) })
    const isFormData = data instanceof FormData

    let body: BodyInit | undefined
    if (isFormData || data instanceof Blob) {
        body = data
    } else if (data !== undefined) {
        if (typeof data === "string") {
            body = data
        } else {
            body = JSON.stringify(data)
            if (!headers.has("content-type")) {
                headers.set("content-type", "application/json")
            }
        }
    }

    const requestInit: RequestInit = { method, headers, body, credentials: "include", redirect: "follow" }
    if (config.timeout) requestInit.signal = AbortSignal.timeout(config.timeout)

    // bodySerializer identity marks a multipart endpoint for the shared request interceptor.
    const interceptorOptions = {
        ...config,
        bodySerializer: isFormData ? formDataBodySerializer.bodySerializer : undefined,
        parseAs: config.responseType,
    } as unknown as ResolvedRequestOptions

    let request = new Request(fullUrl, requestInit)
    for (const fn of client.interceptors.request.fns) {
        if (fn) request = await fn(request, interceptorOptions)
    }

    let response = await fetch(request)
    for (const fn of client.interceptors.response.fns) {
        if (fn) response = await fn(response, request, interceptorOptions)
    }

    const { validateStatus } = config
    const isSuccess = validateStatus ? validateStatus(response.status) : response.status < 400

    const headersObj: Record<string, string> = {}
    response.headers.forEach((value, key) => { headersObj[key] = value })

    if (!isSuccess) {
        const textError = await response.text()
        let parsedError: unknown
        try {
            parsedError = JSON.parse(textError)
        } catch {
            parsedError = textError
        }

        let finalError: unknown = parsedError
        for (const fn of client.interceptors.error.fns) {
            if (fn) finalError = await fn(finalError, response, request, interceptorOptions)
        }
        if (finalError && typeof finalError === "object") {
            (finalError as Record<string, unknown>).response = {
                data: parsedError, status: response.status, headers: headersObj, request: { responseURL: response.url },
            }
        }
        throw finalError
    }

    let responseData: T
    if (config.responseType === "blob") {
        responseData = await response.blob() as T
    } else if (response.status === 204 || response.headers.get("content-length") === "0") {
        responseData = null as T
    } else if (config.responseType !== "text" && (response.headers.get("content-type") ?? "").includes("application/json")) {
        responseData = await response.json() as T
    } else {
        responseData = await response.text() as unknown as T
    }

    return { data: responseData, status: response.status, headers: headersObj, request: { responseURL: response.url } }
}

const axiosLikeClient = {
    defaults: { headers: { common: commonHeaders } },
    get: <T = any>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("GET", url, undefined, config),
    post: <T = any>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("POST", url, data, config),
    put: <T = any>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PUT", url, data, config),
    delete: <T = any>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("DELETE", url, undefined, config),
    patch: <T = any>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PATCH", url, data, config),
} as const

export const configureClient = createConfigureClient(client, formDataBodySerializer)

/**
 * Set a mock client instance controlled in tests
 */
export function setMockClient(mockClient: Partial<typeof axiosLikeClient> = {}) {
    for (const method of ["get", "post", "put", "delete", "patch"] as const) {
        if (mockClient[method]) {
            (axiosLikeClient as any)[method] = mockClient[method] as any
        }
    }
}

/**
 * Get the current fetch client instance
 */
export function useClient() {
    return axiosLikeClient
}

/**
 * A flow described as a native object rather than a YAML source string.
 *
 * Accepts the typed {@link Flow} model or a plain object. The loose
 * `Record<string, unknown>` member is deliberate: the generated `Task` type is a
 * closed object with no index signature, so plugin-specific task properties
 * (e.g. `message` on a Log task, `commands` on a Shell task) would otherwise be
 * rejected by TypeScript. They are carried through verbatim into the emitted YAML.
 */
export type FlowObjectInput = Flow | Record<string, unknown>

/**
 * Serialize a flow object to a YAML source string (block style, no anchors,
 * `null` fields omitted). Kestra expressions like `{{ inputs.foo }}` are quoted
 * by the YAML emitter and multi-line strings become literal block scalars.
 */
export function flowToYaml(flow: FlowObjectInput): string {
    return stringifyYaml(
        flow,
        (_key, value) => (value === null ? undefined : value),
        { aliasDuplicateObjects: false },
    )
}

/**
 * Create a flow from a native object (typed {@link Flow} model or plain object).
 *
 * The flow-write endpoint is YAML-only (it does not accept JSON), so the object
 * is serialized to a YAML source string client-side and delegated to the
 * generated `createFlow`. `draft` stays a query parameter, not a body field.
 */
export function createFlowFromObject(
    parameters: { flow: FlowObjectInput; tenant?: string; draft?: boolean },
    options?: Parameters<typeof createFlow>[1],
) {
    const { flow, ...rest } = parameters
    return createFlow({ ...rest, body: flowToYaml(flow) }, options)
}

/**
 * Update a flow from a native object (typed {@link Flow} model or plain object).
 *
 * The object is serialized to a YAML source string client-side (the write
 * endpoint is YAML-only) and delegated to the generated `updateFlow`. `draft`
 * stays a query parameter, not a body field.
 */
export function updateFlowFromObject(
    parameters: { flow: FlowObjectInput; namespace: string; id: string; tenant?: string; draft?: boolean },
    options?: Parameters<typeof updateFlow>[1],
) {
    const { flow, ...rest } = parameters
    return updateFlow({ ...rest, body: flowToYaml(flow) }, options)
}