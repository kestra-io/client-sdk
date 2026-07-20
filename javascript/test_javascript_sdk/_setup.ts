import { beforeAll } from "vitest";
import { setSelectedTenant } from "@kestra-io/kestra-sdk/shared";
import { configureClient } from "@kestra-io/kestra-sdk";

import fixtures from "./fixtures.json" with { type: "json" };

const { baseURL, username, password, tenantId } = fixtures;

export { tenantId };

beforeAll(async () => {
    const instance = configureClient({
        auth: () => {
            return username + ":" + password;
        },
        baseUrl: baseURL,
    });

    if (process.env.DEBUG) {
        instance.interceptors.request.use((request: Request) => {
            console.log(`[${request.method?.toUpperCase()}] ${request.url}`, request.headers.get("Content-Type"));
            return request;
        });

        instance.interceptors.response.use((response: Response) => {
            return response;
        });

        instance.interceptors.error.use((error: unknown, response: Response | undefined) => {
            if (response) {
                console.error(`[${response.status}] ${response.url}`);
                console.error("Error data:", error);
            } else {
                console.error("Error:", error instanceof Error ? error.message : error);
            }
            return error;
        });
    }

    setSelectedTenant(tenantId);
});


