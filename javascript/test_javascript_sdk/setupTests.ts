import { beforeAll } from "vitest";
import fixtures from "./fixtures.json" with { type: "json" };

const { baseURL, username, password, tenantId } = fixtures;

const sleep = (ms: number) => new Promise(resolve => setTimeout(resolve, ms));

async function setup() {

    for (let attempt = 1; attempt <= 20; attempt++) {
        try {
            const configResponse = await fetch(`${baseURL}/api/v1/setup`);

            if (configResponse.status !== 200) {
                console.log("Setup already completed.");
                return;
            }
            break; // If we got a 200, break out of the loop and run setup
        } catch (error) {
            console.error("Error checking setup status, retrying...");
            await sleep(500); // Wait for 2 seconds before retrying
            continue;
        }
    }

    console.log("Running setup...");
    const res = await fetch(`${baseURL}/api/v1/setup`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            username,
            password,
            tenant: {
                id: tenantId,
                name: tenantId,
            }
        }),
    })
    console.log("Setup response:", res.status, res.statusText);
}

beforeAll(async () => {
    await setup();
});