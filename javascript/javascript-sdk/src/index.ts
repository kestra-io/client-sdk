import axios from "axios"
import type { AxiosRequestConfig, AxiosResponse, AxiosError, AxiosProgressEvent, AxiosInstance } from "axios"
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

const isEmptyBody = (data: unknown): boolean => {
    if (data == null) return true
    if (data instanceof FormData) return [...data.keys()].length === 0
    if (typeof data === "object") return Object.keys(data as object).length === 0
    return false
}

const responseInterceptor = (response: AxiosResponse): AxiosResponse => {
    increaseProgress()
    return response
}

const errorResponseInterceptor = (error: AxiosError): Promise<AxiosError> => {
    increaseProgress()
    return Promise.reject(error)
}

const progressInterceptor = (progressEvent: AxiosProgressEvent) => {
    if (progressEvent?.loaded && progressEvent?.total && typeof document !== "undefined") {
        NProgress.inc(Math.floor(progressEvent.loaded * 1.0) / progressEvent.total)
    }
}

interface QueueItem {
    config: AxiosRequestConfig
    resolve: (value: AxiosResponse | Promise<AxiosResponse>) => void
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
): AxiosInstance => {
    const { oss = false, router, coreStore, authStore, beforeLogout, isImpersonating, onAuthTimeout } = options

    const instance = configureClient(clientConfig, {
        timeout: 15000,
        headers: { "Content-Type": "application/json" },
        withCredentials: true,
        onDownloadProgress: progressInterceptor,
        onUploadProgress: progressInterceptor
    })

    instance.interceptors.request.use((config) => {
        initProgress()
        // The plugin defaults multipart/form-data bodies to {} so hey-api preserves
        // the Content-Type header. Replace that empty sentinel with a real empty
        // FormData so the server receives a well-formed empty multipart body.
        if (String(config.headers?.["Content-Type"]).startsWith("multipart/form-data") && isEmptyBody(config.data)) {
            config.data = new FormData()
        }
        return config
    })

    instance.interceptors.response.use(responseInterceptor, errorResponseInterceptor)

    let toRefreshQueue: QueueItem[] = []
    let refreshing = false

    instance.interceptors.response.use(
        (response) => response,
        async (errorResponse: AxiosError & QueueItem & { config: { showMessageOnError: boolean } }) => {

            if (errorResponse?.code === "ERR_BAD_RESPONSE" && !errorResponse?.response?.data) {
                if (coreStore) {
                    coreStore.message = {
                        variant: "error",
                        response: errorResponse.response,
                        content: errorResponse,
                    }
                }
                return Promise.reject(errorResponse)
            }

            if (errorResponse.response === undefined) {
                return Promise.reject(errorResponse)
            }

            if (errorResponse.response.status === 404) {
                if (coreStore) {
                    coreStore.error = errorResponse.response.status
                }
                return Promise.reject(errorResponse)
            }

            if (errorResponse.response.status === 401
                && (oss || !authStore?.isLogged)) {
                onAuthTimeout?.()
                return Promise.reject(errorResponse)
            }

            const impersonate = isImpersonating ? isImpersonating() : false

            // Authentication expired
            if (errorResponse.response.status === 401 &&
                authStore?.isLogged && !oss &&
                !document.cookie.split("; ").map(cookie => cookie.split("=")[0]).includes("JWT")
                && !impersonate) {

                // Keep original request
                const originalRequest = errorResponse.config

                if (!originalRequest) {
                    return Promise.reject(errorResponse)
                }

                // Prevent refresh attempts on refresh token endpoint itself
                if (originalRequest.url?.includes("/oauth/access_token")) {
                    refreshing = false
                    toRefreshQueue = []

                    beforeLogout?.()

                    delete instance.defaults.headers.common["Authorization"]
                    authStore?.logout().catch(() => { })

                    const currentPath = window.location.pathname
                    const isLoginPath = currentPath.includes("/login")

                    router?.push({
                        name: "login",
                        query: (isLoginPath ? {} : { from: currentPath })
                    })

                    return Promise.reject(errorResponse)
                }

                if (!refreshing) {

                    // if we already tried refreshing the token,
                    // the user simply does not have access to this feature
                    if (originalRequest.headers[REFRESHED_HEADER] === "1") {
                        return Promise.reject(errorResponse)
                    }

                    refreshing = true

                    try {
                        await instance.post("/oauth/access_token?grant_type=refresh_token", null, {
                            headers: { "Content-Type": "application/json" },
                            timeout: 5000
                        })

                        // Process queued requests
                        const queuePromises = toRefreshQueue.map(({ config, resolve }) =>
                            instance.request(config).then(resolve).catch(error => {
                                console.warn("Queued request failed after token refresh:", error)
                                throw error
                            })
                        )

                        await Promise.allSettled(queuePromises)
                        toRefreshQueue = []
                        refreshing = false

                        // Retry original request
                        originalRequest.headers[REFRESHED_HEADER] = "1"

                        return instance(originalRequest)

                    } catch (refreshError) {
                        console.warn("Token refresh failed:", refreshError)

                        refreshing = false
                        toRefreshQueue = []

                        beforeLogout?.()
                        delete instance.defaults.headers.common["Authorization"]
                        authStore?.logout().catch(() => { })

                        const currentPath = window.location.pathname
                        const isLoginPath = currentPath.includes("/login")

                        router?.push({
                            name: "login",
                            query: (isLoginPath ? {} : { from: currentPath })
                        })

                        return Promise.reject(errorResponse)
                    }
                } else {
                    // Add request to queue with a Promise that resolves when refresh is complete
                    return new Promise((resolve, reject) => {
                        toRefreshQueue.push({
                            config: originalRequest,
                            resolve: (response) => resolve(response)
                        })

                        // Set a timeout for queued requests
                        setTimeout(() => {
                            reject(new Error("Token refresh timeout"))
                        }, 10000)
                    })
                }
            }

            if (errorResponse.response.status === 400) {
                return Promise.reject(errorResponse.response.data)
            }

            if (errorResponse.response.data && errorResponse?.config?.showMessageOnError !== false) {
                if (coreStore) {
                    coreStore.message = {
                        variant: "error",
                        response: errorResponse.response,
                        content: errorResponse.response.data
                    }
                }
                return Promise.reject(errorResponse)
            }

            return Promise.reject(errorResponse);
        });

    router?.beforeEach((_to, _from, next) => {
        if (pendingRoute) {
            requestsTotal--;
        }
        pendingRoute = true;
        initProgress();

        next();
    });

    router?.afterEach(() => {
        if (pendingRoute) {
            increaseProgress();
            pendingRoute = false;
        }
    })

    axiosInstance = instance

    return instance;
};

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

export function configureClient(clientConfig: Config<ClientOptions> = {}, axiosConfig: AxiosRequestConfig = {}) {
    const instance = axios.create(axiosConfig)

    // Axios omits Content-Type for body-less requests, which causes servers that
    // expect application/json (e.g. Kestra) to reject them with 401/415.
    // Force application/json for POST/PUT/PATCH when the body is strictly absent.
    instance.interceptors.request.use((config) => {
        const method = config.method?.toLowerCase()
        if (method === "post" || method === "put" || method === "patch") {
            if (config.data == null) {
                config.headers["Content-Type"] = "application/json"
            }
        }
        return config
    })

    client.setConfig({
        axios: instance,
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
                            .split(/[^A-Za-z0-9]+/g) // split on any non-alphanumeric: _, -, spaces, etc.
                            .filter(Boolean); // remove empties from multiple separators

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
                            const ser = serializeQueryValue(
                                qf.value,
                            );
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

    instance.defaults.paramsSerializer = {
        indexes: null
    };

    return instance
}

let axiosInstance: AxiosInstance | null = null;

export function useAxios(): AxiosInstance {
    return new Proxy({} as AxiosInstance, {
        get(_target, prop) {
            if (!axiosInstance) {
                throw new Error("Axios instance not initialized. Please call configureAxios first.")
            }
            const value = (axiosInstance as any)[prop]
            return typeof value === "function" ? value.bind(axiosInstance) : value
        }
    })
}
