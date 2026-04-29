import NProgress from "nprogress"
import { client } from "./openapi/client.gen"
import type { Config, ClientOptions } from "./openapi/client"

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

function canBeJsonified(str: any): boolean {
    if (typeof str !== "string" && typeof str !== "object") return false;
    try {
        const type = str.toString();
        return type === "[object Object]" || type === "[object Array]";
    } catch (err) {
        return false;
    }
}

function serializeQueryValue(val: unknown) {
    if (canBeJsonified(val)) {
        return JSON.stringify(val);
    }
    return val?.toString();
}

export type FetchClient = typeof client

export function configureClient(clientConfig: Config<ClientOptions> = {}): FetchClient {
    client.setConfig({
        credentials: "include",
        headers: { "Content-Type": "application/json" },
        querySerializer(query) {
            const queryParameters = new URLSearchParams();
            for (const key in query) {
                const param = query[key];
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
                    "value" in param[0];

                if (looksLikeQueryFilterArray) {
                    const toCamel = (s: string) => {
                        const parts = String(s || "")
                            .trim()
                            .split(/[^A-Za-z0-9]+/g)
                            .filter(Boolean);

                        if (parts.length === 0) return "";

                        const [first, ...rest] = parts;
                        return (
                            first.toLowerCase() +
                            rest
                                .map(
                                    (p) =>
                                        p.charAt(0).toUpperCase() +
                                        p.slice(1).toLowerCase(),
                                )
                                .join("")
                        );
                    };

                    for (const qf of param) {
                        const fieldStr = String(qf.field);
                        const op = String(qf.operation);
                        const keyField =
                            fieldStr.toLowerCase() === "query"
                                ? "q"
                                : toCamel(fieldStr);

                        if (
                            typeof qf.value === "object" &&
                            qf.value != null &&
                            !Array.isArray(qf.value)
                        ) {
                            for (const [k, v] of Object.entries(qf.value)) {
                                const ser = serializeQueryValue(v);
                                if (ser !== undefined) {
                                    queryParameters.append(`filters[${keyField}][${op}][${k}]`, ser);
                                }
                            }
                        } else {
                            const ser = serializeQueryValue(qf.value);
                            if (ser !== undefined) {
                                queryParameters.append(`filters[${keyField}][${op}]`, ser);
                            }
                        }
                    }
                } else if (param instanceof Array) {
                    param.forEach((value: any) => {
                        const ser = serializeQueryValue(value)
                        if (ser !== undefined) {
                            queryParameters.append(key, ser);
                        }
                    });
                } else {
                    const ser = serializeQueryValue(param)
                    if (ser !== undefined) {
                        queryParameters.append(key, ser);
                    }
                }
            }
            return queryParameters.toString();
        },
        ...clientConfig,
    })

    // Force Content-Type: application/json for body-less POST/PUT/PATCH so Kestra
    // doesn't reject them with 401/415. Also fix empty multipart sentinels.
    client.interceptors.request.use((request) => {
        const method = request.method
        const ct = request.headers.get("Content-Type") ?? ""

        if (ct.startsWith("multipart/form-data") && request.body === null) {
            const headers = new Headers(request.headers)
            // Remove the header so the browser can set it with the correct boundary
            headers.delete("Content-Type")
            return new Request(request, { body: new FormData(), headers })
        }

        if (["POST", "PUT", "PATCH"].includes(method) && request.body === null) {
            const headers = new Headers(request.headers)
            headers.set("Content-Type", "application/json")
            return new Request(request, { headers })
        }

        return request
    })

    // Per-request 15 s timeout via AbortController
    client.interceptors.request.use((request) => {
        if (request.signal) return request
        const controller = new AbortController()
        setTimeout(() => controller.abort(), 15000)
        return new Request(request, { signal: controller.signal })
    })

    return client
}

export const configureFetch = (
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
): FetchClient => {
    const { oss = false, router, coreStore, authStore, beforeLogout, isImpersonating, onAuthTimeout } = options

    configureClient(clientConfig)

    // NProgress: start on every request
    client.interceptors.request.use((request) => {
        initProgress()
        return request
    })

    // NProgress: track download progress via ReadableStream, complete on done
    client.interceptors.response.use((response) => {
        const total = parseInt(response.headers.get("Content-Length") ?? "0", 10)

        if (!response.body) {
            increaseProgress()
            return response
        }

        const reader = response.body.getReader()
        let loaded = 0
        const stream = new ReadableStream({
            start(controller) {
                function read() {
                    reader.read().then(({ done, value }) => {
                        if (done) {
                            controller.close()
                            increaseProgress()
                            return
                        }
                        loaded += value.byteLength
                        if (total > 0) {
                            NProgress.set(loaded / total)
                        } else {
                            NProgress.inc()
                        }
                        controller.enqueue(value)
                        read()
                    }).catch((err) => {
                        controller.error(err)
                        increaseProgress()
                    })
                }
                read()
            },
        })

        return new Response(stream, {
            headers: response.headers,
            status: response.status,
            statusText: response.statusText,
        })
    })

    interface QueueItem {
        retry: () => Promise<Response>
        resolve: (value: Response) => void
    }

    let toRefreshQueue: QueueItem[] = []
    let refreshing = false

    client.interceptors.error.use(async (error, response, request) => {
        increaseProgress()

        if (!response) {
            // Network error or response-less failure
            if (coreStore && error) {
                coreStore.message = {
                    variant: "error",
                    response,
                    content: error,
                }
            }
            return Promise.reject(error)
        }

        const status = response.status

        if (status === 404) {
            if (coreStore) {
                coreStore.error = status
            }
            return Promise.reject(error)
        }

        if (status === 401 && (oss || !authStore?.isLogged)) {
            onAuthTimeout?.()
            return Promise.reject(error)
        }

        const impersonate = isImpersonating ? isImpersonating() : false

        if (
            status === 401 &&
            authStore?.isLogged &&
            !oss &&
            !document.cookie.split("; ").map((c) => c.split("=")[0]).includes("JWT") &&
            !impersonate
        ) {
            if (!request) return Promise.reject(error)

            // Already retried after a token refresh — give up
            if (request.headers.get(REFRESHED_HEADER) === "1") {
                return Promise.reject(error)
            }

            // Refresh token endpoint itself failed — log out
            if (request.url?.includes("/oauth/access_token")) {
                refreshing = false
                toRefreshQueue = []

                beforeLogout?.()
                authStore?.logout().catch(() => {})

                const currentPath = window.location.pathname
                const isLoginPath = currentPath.includes("/login")
                router?.push({
                    name: "login",
                    query: isLoginPath ? {} : { from: currentPath },
                })

                return Promise.reject(error)
            }

            if (!refreshing) {
                refreshing = true

                try {
                    await fetch("/oauth/access_token?grant_type=refresh_token", {
                        method: "POST",
                        headers: { "Content-Type": "application/json" },
                        credentials: "include",
                        signal: AbortSignal.timeout(5000),
                    })

                    // Replay queued requests
                    const queuePromises = toRefreshQueue.map(({ retry, resolve }) =>
                        retry().then(resolve).catch((err) => {
                            console.warn("Queued request failed after token refresh:", err)
                            throw err
                        })
                    )
                    await Promise.allSettled(queuePromises)
                    toRefreshQueue = []
                    refreshing = false

                    // Retry original request, flagged to prevent infinite refresh loop
                    const retryHeaders = new Headers(request.headers)
                    retryHeaders.set(REFRESHED_HEADER, "1")
                    return fetch(new Request(request, { headers: retryHeaders }))

                } catch (refreshError) {
                    console.warn("Token refresh failed:", refreshError)
                    refreshing = false
                    toRefreshQueue = []

                    beforeLogout?.()
                    authStore?.logout().catch(() => {})

                    const currentPath = window.location.pathname
                    const isLoginPath = currentPath.includes("/login")
                    router?.push({
                        name: "login",
                        query: isLoginPath ? {} : { from: currentPath },
                    })

                    return Promise.reject(refreshError)
                }
            } else {
                return new Promise<Response>((resolve, reject) => {
                    toRefreshQueue.push({
                        retry: () => fetch(request.clone()),
                        resolve,
                    })
                    setTimeout(() => reject(new Error("Token refresh timeout")), 10000)
                })
            }
        }

        if (status === 400) {
            const data = await response.clone().json().catch(() => null)
            return Promise.reject(data)
        }

        // Generic error: show message in UI
        const data = await response.clone().json().catch(() => null)
        if (data && coreStore) {
            coreStore.message = {
                variant: "error",
                response,
                content: data,
            }
        }

        return Promise.reject(error)
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

    fetchClientInstance = client
    return client
}

let fetchClientInstance: FetchClient | null = null

export function useClient(): FetchClient {
    return new Proxy({} as FetchClient, {
        get(_target, prop) {
            if (!fetchClientInstance) {
                throw new Error("Fetch client not initialized. Please call configureFetch first.")
            }
            const value = (fetchClientInstance as any)[prop]
            return typeof value === "function" ? value.bind(fetchClientInstance) : value
        },
    })
}
