import ky from "ky"
import NProgress from "nprogress"
import { client } from "./openapi/client.gen"
import type { ClientOptions, Config } from "./openapi/client"

export * from "./openapi/index"

declare global {
    interface Window {
        KESTRA_BASE_PATH: string
    }
}

let pendingRoute = false
let requestsTotal = 0
let requestsCompleted = 0
const latencyThreshold = 0

const REFRESHED_HEADER = "X-JWT-Refreshed"

const progressComplete = () => {
    pendingRoute = false
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

const wrapResponseWithProgress = (response: Response): Response => {
    if (!response.body) {
        increaseProgress()
        return response
    }

    const contentLength = response.headers.get("Content-Length")
    const total = contentLength ? parseInt(contentLength, 10) : null
    const reader = response.body.getReader()
    let loaded = 0

    const stream = new ReadableStream<Uint8Array>({
        async pull(controller) {
            const { done, value } = await reader.read()
            if (done) {
                increaseProgress()
                controller.close()
                return
            }
            loaded += value.byteLength
            if (total) {
                NProgress.inc(loaded / total)
            }
            controller.enqueue(value)
        },
        cancel() {
            reader.cancel()
            increaseProgress()
        },
    })

    return new Response(stream, {
        headers: response.headers,
        status: response.status,
        statusText: response.statusText,
    })
}

function canBeJsonified(str: any): boolean {
    if (typeof str !== "string" && typeof str !== "object") return false
    try {
        const type = str.toString()
        return type === "[object Object]" || type === "[object Array]"
    } catch {
        return false
    }
}

function serializeQueryValue(val: unknown) {
    if (canBeJsonified(val)) {
        return JSON.stringify(val)
    }
    return val?.toString()
}

interface QueueItem {
    request: Request
    resolve: (value: Response) => void
    reject: (reason: unknown) => void
}

export const configureAxios = (
    clientConfig: Config<ClientOptions> = {},
    options: {
        oss?: boolean,
        router?: {
            push: (location: { name: string, query?: Record<string, string> }) => void;
            beforeEach: (callback: (to: any, from: any, next: () => void) => void) => void;
            afterEach: (callback: () => void) => void;
        },
        coreStore?: {
            message?: {
                variant?: string;
                response?: any;
                content?: any;
            };
            error?: any;
        },
        authStore?: {
            isLogged?: boolean;
            logout: () => Promise<void>;
        },
        beforeLogout?: () => void
        isImpersonating?: () => boolean
        onAuthTimeout?: () => void
    } = {}
) => {
    const { oss = false, router, coreStore, authStore, beforeLogout, isImpersonating, onAuthTimeout } = options

    // Clear any previously registered interceptors before re-configuring
    client.interceptors.request.clear()
    client.interceptors.response.clear()
    client.interceptors.error.clear()

    let toRefreshQueue: QueueItem[] = []
    let refreshing = false

    const doLogout = () => {
        beforeLogout?.()
        authStore?.logout().catch(() => {})
        const currentPath = window.location.pathname
        router?.push({
            name: "login",
            query: currentPath.includes("/login") ? {} : { from: currentPath }
        })
    }

    // kyInstance is declared before use so the afterResponse hook can reference it for retries
    let kyInstance: typeof ky

    kyInstance = ky.extend({
        hooks: {
            afterResponse: [
                async (request, kyOpts, response) => {
                    if (response.status !== 401) return

                    if (oss || !authStore?.isLogged) {
                        onAuthTimeout?.()
                        return
                    }

                    const impersonate = isImpersonating?.() ?? false
                    const hasJWT = typeof document !== "undefined"
                        && document.cookie.split("; ").map(c => c.split("=")[0]).includes("JWT")

                    if (hasJWT || impersonate) return

                    // The refresh endpoint itself returned 401 → bail out and logout
                    if (request.url.includes("/oauth/access_token")) {
                        refreshing = false
                        toRefreshQueue = []
                        doLogout()
                        return
                    }

                    // Already retried once after a successful refresh → let it through
                    if (request.headers.get(REFRESHED_HEADER) === "1") return

                    if (!refreshing) {
                        refreshing = true
                        try {
                            const refreshUrl = clientConfig.baseUrl
                                ? `${String(clientConfig.baseUrl).replace(/\/$/, "")}/oauth/access_token?grant_type=refresh_token`
                                : `/oauth/access_token?grant_type=refresh_token`

                            await ky.post(refreshUrl, {
                                credentials: "include",
                                timeout: 5000,
                                retry: 0,
                            })

                            // Replay queued requests through our kyInstance so they benefit from hooks
                            const pending = toRefreshQueue.splice(0)
                            await Promise.allSettled(
                                pending.map(({ request: qReq, resolve, reject }) =>
                                    kyInstance(qReq).then(resolve).catch(reject)
                                )
                            )
                            refreshing = false

                            // Retry the original request, marking it so the hook won't loop
                            const retryHeaders = new Headers(request.headers)
                            retryHeaders.set(REFRESHED_HEADER, "1")
                            return kyInstance(new Request(request, { headers: retryHeaders }), kyOpts)

                        } catch {
                            refreshing = false
                            toRefreshQueue = []
                            doLogout()
                        }
                    } else {
                        // Another refresh is in-flight — queue and wait
                        return new Promise<Response>((resolve, reject) => {
                            toRefreshQueue.push({ request: request.clone(), resolve, reject })
                            setTimeout(() => reject(new Error("Token refresh timeout")), 10000)
                        })
                    }
                }
            ]
        }
    })

    configureClient({ ...clientConfig, ky: kyInstance } as Config<ClientOptions>)

    // Request interceptor: progress + content-type fixes for body-less mutations
    client.interceptors.request.use(async (request) => {
        initProgress()

        const method = request.method.toUpperCase()

        // Force application/json for POST/PUT/PATCH when body is absent so servers
        // that require a Content-Type (e.g. Kestra returning 401/415) accept the request.
        if (["POST", "PUT", "PATCH"].includes(method) && !request.body) {
            const headers = new Headers(request.headers)
            headers.set("Content-Type", "application/json")
            return new Request(request, { headers })
        }

        // Replace the empty multipart sentinel ({}) with a real empty FormData so
        // the server receives a well-formed multipart body with a proper boundary.
        if (request.headers.get("Content-Type")?.startsWith("multipart/form-data") && !request.body) {
            const headers = new Headers(request.headers)
            headers.delete("Content-Type") // let the browser set boundary automatically
            return new Request(request, { body: new FormData(), headers } as RequestInit)
        }

        return request
    })

    // Response interceptor: wrap the body in a ReadableStream so NProgress tracks
    // download progress byte-by-byte when Content-Length is available.
    client.interceptors.response.use(async (response) => {
        return wrapResponseWithProgress(response)
    })

    // Error interceptor: surface HTTP errors to coreStore and re-throw
    client.interceptors.error.use(async (error, response) => {
        increaseProgress()

        if (!response) {
            if (coreStore) {
                coreStore.message = { variant: "error", content: error }
            }
            throw error
        }

        if (response.status === 404) {
            if (coreStore) coreStore.error = response.status
            throw error
        }

        if (response.status === 400) {
            throw error
        }

        if (error) {
            if (coreStore) {
                coreStore.message = { variant: "error", response, content: error }
            }
        }

        throw error
    })

    router?.beforeEach((_to, _from, next) => {
        if (pendingRoute) {
            requestsTotal--
        }
        pendingRoute = true
        initProgress()
        next()
    })

    router?.afterEach(() => {
        if (pendingRoute) {
            increaseProgress()
            pendingRoute = false
        }
    })

    isClientConfigured = true
    return client
}

export function configureClient(clientConfig: Config<ClientOptions> = {}) {
    client.setConfig({
        credentials: "include" as RequestCredentials,
        timeout: 15000,
        retry: 0,
        querySerializer(query) {
            const queryParameters = new URLSearchParams()
            for (const key in query) {
                const param = query[key]
                if (query[key] === undefined) {
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
                                .map(p => p.charAt(0).toUpperCase() + p.slice(1).toLowerCase())
                                .join("")
                        )
                    }

                    for (const qf of param) {
                        const fieldStr = String(qf.field)
                        const op = String(qf.operation)
                        const keyField = fieldStr.toLowerCase() === "query" ? "q" : toCamel(fieldStr)

                        if (typeof qf.value === "object" && qf.value != null && !Array.isArray(qf.value)) {
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

    return client
}

let isClientConfigured = false

export function useClient() {
    return new Proxy({} as typeof client, {
        get(_target, prop) {
            if (!isClientConfigured) {
                throw new Error("HTTP client not initialized. Please call configureAxios first.")
            }
            const value = (client as any)[prop]
            return typeof value === "function" ? value.bind(client) : value
        }
    })
}
