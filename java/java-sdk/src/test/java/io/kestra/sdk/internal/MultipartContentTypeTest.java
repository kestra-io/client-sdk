package io.kestra.sdk.internal;

import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultipartContentTypeTest {
    private final ApiClient apiClient = new ApiClient();

    @Test
    void shouldEmitFormDataContentTypeWhenMultipartBodyIsEmpty() throws Exception {
        HttpEntity entity = apiClient.serialize(null, new LinkedHashMap<>(), ContentType.MULTIPART_FORM_DATA);

        assertNotNull(entity.getContentType(), "multipart entity must carry a Content-Type");
        assertTrue(
            entity.getContentType().startsWith(ContentType.MULTIPART_FORM_DATA.getMimeType()),
            "an empty multipart body must still be multipart/form-data (Apache defaults to multipart/mixed with no parts, which the server does not @Consumes), got: " + entity.getContentType()
        );
    }

    @Test
    void shouldEmitFormDataContentTypeWhenMultipartHasParts() throws Exception {
        Map<String, Object> formParams = new LinkedHashMap<>();
        formParams.put("field", "value");

        HttpEntity entity = apiClient.serialize(null, formParams, ContentType.MULTIPART_FORM_DATA);

        assertNotNull(entity.getContentType());
        assertTrue(
            entity.getContentType().startsWith(ContentType.MULTIPART_FORM_DATA.getMimeType()),
            "got: " + entity.getContentType()
        );
    }
}
