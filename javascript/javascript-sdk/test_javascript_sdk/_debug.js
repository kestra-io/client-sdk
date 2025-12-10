// testApis/_debug.js
export async function debugCall(promise) {
    try {
        return await promise;
    } catch (e) {
        // generic
        console.error('SDK error name:', e?.name);
        console.error('SDK error message:', e?.message);

        // axios-style
        if (e?.response) {
            console.error('HTTP status:', e.response.status, e.response.statusText);
            console.error('Response headers:', e.response.headers);
            console.error('Response data:', e.response.data);
        }

        // openapi-fetch / fetch-like (ResponseError)
        if (e?.status) console.error('HTTP status:', e.status);
        if (e?.statusText) console.error('statusText:', e.statusText);
        if (e?.body) {
            try {
                console.error('Body (json):', typeof e.body === 'string' ? JSON.parse(e.body) : e.body);
            } catch {
                console.error('Body (text):', e.body);
            }
        }
        if (e?.response?.text) {
            try {
                const text = await e.response.text();
                console.error('Response text:', text);
            } catch {/* ignore */}
        }

        // last resort: dump whole object
        console.error('Raw error object:', e);
        throw e instanceof Error ? e : new Error('SDK call failed (see logs above)');
    }
}
