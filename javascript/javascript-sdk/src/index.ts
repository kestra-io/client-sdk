import { client } from "./openapi/client.gen"
import { formDataBodySerializer } from "./openapi/client"
import type { Client, ClientOptions, Config, ResolvedRequestOptions } from "./openapi/client"

export * from "./openapi/index"

declare global {
    interface Window {
        KESTRA_BASE_PATH: string
    }
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
    params?: Record<string, unknown>
    headers?: Record<string, string>
    responseType?: "json" | "text" | "blob"
    timeout?: number
    validateStatus?: (status: number) => boolean
    [key: string]: any
}

interface AxiosLikeResponse<T = any> {
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
    get: <T>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("GET", url, undefined, config),
    post: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("POST", url, data, config),
    put: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PUT", url, data, config),
    delete: <T>(url: string, config?: AxiosLikeConfig) => axiosLikeRequest<T>("DELETE", url, undefined, config),
    patch: <T>(url: string, data?: any, config?: AxiosLikeConfig) => axiosLikeRequest<T>("PATCH", url, data, config),
} as const

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
                    for (const qf of param) {
                        const keyField = String(qf.field);
                        const op = String(qf.operation);

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
                // Include application/octet-stream: some endpoints (e.g. exportPluginDefaults)
                // advertise octet-stream in the OpenAPI spec but actually return text.
                // Kestra content-negotiation returns 403 when Accept excludes the produced type.
                headers.set("accept", "text/csv, text/plain, text/json, application/json, application/octet-stream")
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
        if (asObject) {
            Object.assign(normalizedError as Error & Record<string, unknown>, asObject)
        }
        normalizedError.message = message
        const normalizedWithStatus = normalizedError as Error & { status: number }
        normalizedWithStatus.status = status
        return normalizedWithStatus
    })

    return client
}

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