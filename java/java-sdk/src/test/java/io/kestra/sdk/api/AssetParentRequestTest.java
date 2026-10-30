package io.kestra.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import io.kestra.sdk.internal.ApiClient;
import io.kestra.sdk.model.AssetsControllerApiParentRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AssetParentRequestTest {

    @Test
    void setAssetParentBodySerializesParentId() throws Exception {
        String json = new ApiClient().getObjectMapper()
            .writeValueAsString(new AssetsControllerApiParentRequest().parentId("parent_asset"));
        JsonNode body = new ApiClient().getObjectMapper().readTree(json);

        assertEquals("parent_asset", body.get("parentId").asText(), json);
        assertFalse(body.has("id"), json);
    }
}
