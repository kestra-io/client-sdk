import type { AxiosInstance } from "axios"
import { client } from "./openapi/client.gen"
// Block-1 — the universal axios setup (Content-Type/Accept fixes, the QueryFilter query serializer,
// Blob/string error normalization) — now comes from the shared @kestra-io/hey-api-plugin/runtime,
// so it is not duplicated across the OSS SDK, the EE SDK and this published SDK. It is bundled into
// dist at build time (see tsdown.config), so the published package has no runtime dependency on it.
import { createConfigureClient } from "@kestra-io/hey-api-plugin/runtime"

export * from "./openapi/index"

const configure = createConfigureClient(client)

export function configureClient(...args: Parameters<typeof configure>): AxiosInstance {
    const instance = configure(...args)
    axiosInstance = instance
    return instance
}

let axiosInstance: AxiosInstance | null = null;

/**
 * Set a mock instance of axios controlled in tests
 * @param mockClient
 */
export function setMockClient(mockClient: any) {
    axiosInstance = mockClient;
}

/**
 * Get the current Axios client instance
 * @returns AxiosInstance
 */
export function useClient(): AxiosInstance {
    return new Proxy({} as AxiosInstance, {
        get(_target, prop) {
            if (!axiosInstance) {
                throw new Error("Axios instance not initialized. Please call configureClient first.")
            }
            const value = (axiosInstance as any)[prop]
            return typeof value === "function" ? value.bind(axiosInstance) : value
        }
    })
}
