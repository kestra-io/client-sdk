import fixtures from "./fixtures.json" with { type: "json" };

const { baseURL, username, password, tenantId } = fixtures;

async function setup() {
    const config = await fetch(`${baseURL}/api/v1/setup`);
    if (config.status !== 200 || (!(await config.json())?.done)) {
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
}

setup().catch((error) => {
    console.error("Error during setup:", error);
    process.exit(1);
});