import { client } from "./openapi/client.gen"
import { formDataBodySerializer } from "./openapi/client"
import type { ResolvedRequestOptions } from "./openapi/client"
import { createConfigureClient, EnterpriseFeatureError } from "@kestra-io/hey-api-plugin/runtime"
import type { EnterpriseFeatureConfig } from "@kestra-io/hey-api-plugin/runtime"
import { ENTERPRISE_ONLY_ROUTES_JSON } from "./openapi/sdk/enterpriseOnlyRoutes.gen"

export * from "./openapi/index"
export { EnterpriseFeatureError }

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

// Route registry baked in at generation time from the EE spec's x-kestra tags; see
// enterprise-only-routes-plugin.ts.
const enterpriseOnlyRoutes: Record<string, { feature: string }> = JSON.parse(ENTERPRISE_ONLY_ROUTES_JSON)

const featureToSlugMap: Record<string, string> = {
    "audit-logs": "/governance/audit-logs",
    "bindings": "/auth/rbac",
    "auths": "/auth/authentication",
    "banners": "/instance/announcements",
    "cluster": "/instance/maintenance-mode",
    "mcp": "",
    "services": "",
    "policies": "/governance",
    "plugins": "/instance/versioned-plugins",
    "worker-groups": "/scalability/worker-group",
    "worker-queues": "",
    "worker-auth": "/auth/credentials",
    "kill-switches": "/instance/kill-switch",
    "misc": "",
    "invitations": "/auth/invitations",
    "users": "/auth/rbac",
    "notifications": "",
    "service-account": "/auth/service-accounts",
    "tenants": "/governance/tenants",
    "ai": "",
    "apps": "/scalability/apps",
    "assets": "/governance/assets",
    "blueprints": "/governance/custom-blueprints",
    "blueprint-tags": "/governance/custom-blueprints",
    "flows": "/governance",
    "groups": "/auth/rbac",
    "scim-groups": "/auth/scim",
    "scim-configuration": "/auth/scim",
    "scim-users": "/auth/scim",
    "namespaces": "/governance/namespace-management",
    "reusable-inputs": "",
    "quotas": "",
    "roles": "/auth/rbac",
    "security-integrations": "/auth/sso",
    "tenant-access": "/auth/rbac",
    "test-suites": "/governance/unit-tests",
    "login": "/auth/authentication",
}

// TODO: re-pin @kestra-io/hey-api-plugin to >= 0.3.0 once released, for header-based disambiguation.
const enterpriseFeature: EnterpriseFeatureConfig = {
    matchRoute: (method, path) => enterpriseOnlyRoutes[`${method} ${path}`],
    docsUrl: (feature) => `https://kestra.io/docs/enterprise${featureToSlugMap[feature] ?? ""}`,
    contactSalesUrl: () => "https://kestra.io/demo",
}

export const configureClient = createConfigureClient(client, formDataBodySerializer, enterpriseFeature)

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