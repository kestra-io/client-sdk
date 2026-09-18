package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.Test;

import static io.kestra.TestUtils.TENANT;
import static io.kestra.TestUtils.client;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runs the curated README example end-to-end against the live Kestra container.
 *
 * <p>This is the CI guarantee for the injected snippet: if the code in
 * {@link BasicSDKUsageExample} (and therefore the README block produced from it
 * by {@code test-utils/embed_snippets.py}) ever stops matching the SDK, this
 * test fails. See issue #144.
 */
class BasicSDKUsageExampleTest {

    @Test
    void flowLifecycle_runsEndToEnd() throws ApiException {
        try {
            String executionId = BasicSDKUsageExample.flowLifecycle(client(), TENANT);
            assertThat(executionId).isNotBlank();
        } finally {
            // Best-effort cleanup so the example is re-runnable within a session.
            try {
                client().flows().deleteFlow("company.team", "hello_from_sdk", TENANT);
            } catch (ApiException ignored) {
                // flow may not exist if the example failed before creating it
            }
        }
    }
}
