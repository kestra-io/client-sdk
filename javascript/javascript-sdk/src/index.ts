import NProgress from "nprogress"
import { client } from "./openapi/client.gen"
import { formDataBodySerializer } from "./openapi/client"
import type { Client, ClientOptions, Config, ResolvedRequestOptions } from "./openapi/client"

export * from "./openapi/index"

declare global {
    interface Window {
        KESTRA_BASE_PATH: string
    }
}

let requestsTotal = 0
let requestsCompleted = 0
const latencyThreshold = 0

const REFRESHED_HEADER = "X-JWT-Refreshed"

const progressComplete = () => {
    requestsTotal = 0
    requestsCompleted = 0
    NProgress.done()
}

const initProgress = () => {
    requestsTotal++
    if (requestsTotal === 1) {
        setTimeout(() => {
            NProgress.start()
            NProgress.set(requestsCompleted / requestsTotal)
        }, latencyThreshold)
    } else {
        NProgress.set(requestsCompleted / requestsTotal)
    }
}

const increaseProgress = () => {
    setTimeout(() => {
        requestsCompleted++
        if (requestsCompleted >= requestsTotal) {
            progressComplete()
        } else {
            NProgress.set((requestsCompleted / requestsTotal) - 0.1)
        }
    }, latencyThreshold + 50)
}

function canBeJsonified(str: any): boolean {
    if (typeof str !== "string" && typeof str !== "object") return false
    try {
        const type = str.toString()
        return type === "[object Object]" || type === "[object Array]"
    } catch (err) {
        return false
    }
}

function serializeQueryValue(val: unknown) {
    if (canBeJsonified(val)) {
        return JSON.stringify(val)
    }
    return val?.toString()
}

interface AxiosLikeConfig {
    headers?: Record<string, string>
    validateStatus?: (status: number) => boolean
    [key: string]: any
}

interface AxiosLikeResponse<T = any> {
    data: T
    status: number
    headers: Record<string, string>
}

const commonHeaders: Record<string, string> = {}

async function axiosLikeRequest<T>(
    method: string,
    url: string,
    data?: any,
    config: AxiosLikeConfig = {}
): Promise<AxiosLikeResponse<T>> {
    const headers = new Headers({ ...commonHeaders, ...(config.headers ?? {}) })

    let body: BodyInit | undefined
    if (data !== undefined) {
        if (typeof data === "string") {
            body = data
        } else {
            body = JSON.stringify(data)
            if (!headers.has("content-type")) {
                headers.set("content-type", "application/json")
            }
        }
    }

    const response = await fetch(url, { method, headers, body, credentials: "include" })

    const { validateStatus } = config
    const isSuccess = validateStatus ? validateStatus(response.status) : response.status < 400

    let responseData: T
    const contentType = response.headers.get("content-type") ?? ""
    if (response.status === 204 || response.headers.get("content-length") === "0") {
        responseData = null as T
    } else if (contentType.includes("application/json")) {
        responseData = await response.json() as T
    } else {
        responseData = await response.text() as unknown as T
    }

    const headersObj: Record<string, string> = {}
    response.headers.forEach((value, key) => { headersObj[key] = value })

    const result: AxiosLikeResponse<T> = { data: responseData, status: response.status, headers: headersObj }

    if (!isSuccess) {
        const error = new Error(`Request failed with status ${response.status}`) as Error & { response: AxiosLikeResponse<T> }
        error.response = result
        throw error
    }

    return result
}

const axiosLikeClient = {
    defaults: { headers: { common: commonHeaders } },
    get: <T>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("GET", url, undefined, config),
    post: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("POST", url, data, config),
    put: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PUT", url, data, config),
    delete: <T>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("DELETE", url, undefined, config),
    patch: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PATCH", url, data, config),
} as const

export const configureBrowserClient = (
    clientConfig: Config<ClientOptions>,
    options: {
        logout?: () => void
        isImpersonating?: () => boolean
        isLoggedIn?: () => boolean
        onAuthTimeout?: () => boolean | void
        onError?: (type: "message" | "error", response: Response & { data?: any }) => void
    }
) => {
    const {
        logout,
        isImpersonating = () => false,
        isLoggedIn = () => false,
        onAuthTimeout,
        onError = (type, response: Response & { data?: any }) => {
            // eslint-disable-next-line no-console
            console.error(`Request ${type === "error" ? "error" : "failed with status " + response.status}:`, response.data ?? response)
        }
    } = options

    configureClient({
        credentials: "include",
        headers: { "Content-Type": "application/json" },
        ...clientConfig,
    })

    // Track outgoing requests for NProgress
    client.interceptors.request.use((request: Request): Request => {
        if (typeof document !== "undefined") {
            initProgress()
        }
        return request
    })

    // NProgress: count completed responses (non-error path)
    client.interceptors.response.use((response: Response): Response => {
        increaseProgress()
        return response
    })

    // NProgress: count completed responses (error path) + error messages
    client.interceptors.error.use((error: unknown, response: Response | undefined): unknown => {
        // Response interceptors didn't fire for network errors (no response object)
        if (!response) {
            increaseProgress()
            return error
        }

        if (response.status === 404) {
            onError("message", response as any)
            return error
        }

        if (response.status === 400) {
            return error
        }

        if (error) {
            onError("message", error as any)
        }

        return error
    })

    // Token refresh: intercept 401 responses before the error path runs
    let refreshPromise: Promise<void> | null = null

    client.interceptors.response.use(async (response: Response, request: Request, opts: ResolvedRequestOptions): Promise<Response> => {
        if (response.status !== 401) {
            return response
        }

        if (!isLoggedIn()) {
            onAuthTimeout?.()
            return response
        }

        const impersonate = isImpersonating ? isImpersonating() : false
        const hasJwtCookie = document.cookie.split("; ").some(c => c.split("=")[0] === "JWT")

        if (hasJwtCookie || impersonate) {
            return response
        }

        // Already retried once — don't loop
        if (request.headers.get(REFRESHED_HEADER)) {
            logout?.()

            return response
        }

        // Don't attempt to refresh when the refresh endpoint itself returns 401
        if (request.url.includes("/oauth/access_token")) {
            logout?.()

            return response
        }

        // Deduplicate concurrent refreshes: all 401s wait on the same promise
        if (!refreshPromise) {
            const baseUrl = ((opts.baseUrl as string | undefined) ?? "").replace(/\/$/, "")
            refreshPromise = fetch(`${baseUrl}/oauth/access_token?grant_type=refresh_token`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                credentials: "include",
                signal: AbortSignal.timeout(5000),
            }).then((r) => {
                if (!r.ok) throw new Error("Token refresh failed")
            }).finally(() => {
                refreshPromise = null
            })
        }

        try {
            await refreshPromise
        } catch {
            logout?.()

            return response
        }

        // Retry the original request, marking it so we don't loop
        const retryHeaders = new Headers(request.headers)
        retryHeaders.set(REFRESHED_HEADER, "1")
        const _fetch = opts.fetch ?? globalThis.fetch
        return _fetch(new Request(request, { headers: retryHeaders }))
    })

    fetchClient = client

    return { client, initProgress, progressComplete, increaseProgress }
}

export function configureClient(clientConfig: Config<ClientOptions> = {}): Client {
    client.interceptors.request.clear()
    client.interceptors.response.clear()
    client.interceptors.error.clear()

    client.setConfig({
        // The default jsonBodySerializer JSON-stringifies everything, including plain string
        // bodies (YAML, text/plain). Override to pass strings through as-is.
        bodySerializer: (body: unknown): unknown => {
            if (typeof body === "string") return body
            // buildClientParams initialises params.body as {} even for no-body operations.
            // Return '' so the client treats it as an absent body (no Content-Type, no body sent).
            if (body !== null && typeof body === "object" && !Array.isArray(body) && Object.keys(body as Record<string, unknown>).length === 0) return ""
            return JSON.stringify(body, (_key, value) => (typeof value === "bigint" ? value.toString() : value))
        },
        querySerializer(query) {
            const queryParameters = new URLSearchParams()
            for (const key in query) {
                const param = query[key]
                if (param === undefined) {
                    continue
                }
                const looksLikeQueryFilterArray =
                    Array.isArray(param) &&
                    param.length > 0 &&
                    typeof param[0] === "object" &&
                    param[0] != null &&
                    "field" in param[0] &&
                    "operation" in param[0] &&
                    "value" in param[0]

                if (looksLikeQueryFilterArray) {
                    const toCamel = (s: string) => {
                        const parts = String(s || "")
                            .trim()
                            .split(/[^A-Za-z0-9]+/g)
                            .filter(Boolean)

                        if (parts.length === 0) return ""

                        const [first, ...rest] = parts
                        return (
                            first.toLowerCase() +
                            rest
                                .map(
                                    (p) =>
                                        p.charAt(0).toUpperCase() +
                                        p.slice(1).toLowerCase(),
                                )
                                .join("")
                        )
                    }

                    for (const qf of param) {
                        const fieldStr = String(qf.field)
                        const op = String(qf.operation)
                        const keyField =
                            fieldStr.toLowerCase() === "query"
                                ? "q"
                                : toCamel(fieldStr)

                        if (
                            typeof qf.value === "object" &&
                            qf.value != null &&
                            !Array.isArray(qf.value)
                        ) {
                            for (const [k, v] of Object.entries(qf.value)) {
                                const ser = serializeQueryValue(v)
                                if (ser !== undefined) {
                                    queryParameters.append(`filters[${keyField}][${op}][${k}]`, ser)
                                }
                            }
                        } else {
                            const ser = serializeQueryValue(qf.value)
                            if (ser !== undefined) {
                                queryParameters.append(`filters[${keyField}][${op}]`, ser)
                            }
                        }
                    }
                } else if (param instanceof Array) {
                    param.forEach((value: any) => {
                        const ser = serializeQueryValue(value)
                        if (ser !== undefined) {
                            queryParameters.append(key, ser)
                        }
                    })
                } else {
                    const ser = serializeQueryValue(param)
                    if (ser !== undefined) {
                        queryParameters.append(key, ser)
                    }
                }
            }
            return queryParameters.toString()
        },
        ...clientConfig,
    })

    // Restore Content-Type for POST/PUT/PATCH and set Accept for non-JSON responses.
    // The fetch client deletes Content-Type for body-less requests (opts.body === undefined),
    // but Kestra requires Content-Type: application/json on all POST/PUT/PATCH, even without a body.
    // Exception: endpoints that use formDataBodySerializer (e.g. createExecution, resumeExecution)
    // set 'Content-Type: null' to let the browser supply the multipart boundary automatically.
    // When no body is provided for those endpoints, we must not inject application/json —
    // Kestra will reject the request with 401 if Content-Type doesn't match multipart/form-data.
    client.interceptors.request.use((request: Request, opts: ResolvedRequestOptions): Request => {
        const headers = new Headers(request.headers)
        let modified = false

        const method = request.method.toLowerCase()
        const isFormDataEndpoint = opts.bodySerializer === formDataBodySerializer.bodySerializer
        if (["post", "put", "patch"].includes(method) && !headers.has("content-type") && !isFormDataEndpoint) {
            headers.set("content-type", "application/json")
            modified = true
        }

        if (!headers.has("accept")) {
            if (opts.parseAs === "blob") {
                headers.set("accept", "application/octet-stream")
                modified = true
            } else if (opts.parseAs === "text") {
                headers.set("accept", "text/plain, text/json, application/json")
                modified = true
            }
        }

        return modified ? new Request(request, { headers }) : request
    })

    // Enrich thrown errors with the HTTP status while preserving Error semantics.
    // The fetch client throws parsed response data (often plain objects/strings),
    // but many existing call sites and tests expect thrown values to be Error instances.
    client.interceptors.error.use((error: unknown, response: Response | undefined): unknown => {
        if (!response) return error

        const status = response.status
        const asObject = error !== null && typeof error === "object" ? error as Record<string, unknown> : undefined
        const rawMessage =
            (error instanceof Error && error.message) ||
            (typeof error === "string" ? error : undefined) ||
            (typeof asObject?.message === "string" ? asObject.message : undefined) ||
            (typeof asObject?.detail === "string" ? asObject.detail : undefined) ||
            (typeof asObject?.title === "string" ? asObject.title : undefined) ||
            response.statusText ||
            "Request failed"

        const hasStatusPrefix =
            rawMessage === String(status) ||
            rawMessage.startsWith(`${status} `) ||
            rawMessage.startsWith(`${status}:`)
        const message = hasStatusPrefix ? rawMessage : `${status} ${rawMessage}`
        const normalizedError = error instanceof Error ? error : new Error(message)
        normalizedError.message = message

        if (asObject) {
            Object.assign(normalizedError as Error & Record<string, unknown>, asObject)
        }

        const normalizedWithStatus = normalizedError as Error & { status: number }
        normalizedWithStatus.status = status
        return normalizedWithStatus
    })

    fetchClient = client

    return client
}

let fetchClient: Client | null = null

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