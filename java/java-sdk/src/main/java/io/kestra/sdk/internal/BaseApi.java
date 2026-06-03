package io.kestra.sdk.internal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BaseApi {

  protected static final String[] AUTH = {"basicAuth", "bearerAuth"};
  protected static final String JSON = "application/json";

  protected ApiClient apiClient;

  public BaseApi() {
    this(Configuration.getDefaultApiClient());
  }

  public BaseApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  // ---- Path builders ----

  protected String tenantPath(String tenant, String... segments) {
    StringBuilder sb = new StringBuilder("/api/v1/");
    sb.append(esc(tenant));
    for (String s : segments) {
      sb.append("/").append(esc(s));
    }
    return sb.toString();
  }

  protected String esc(String value) {
    return apiClient.escapeString(apiClient.parameterToString(value));
  }

  // ---- Query param builders ----

  protected List<Pair> queryParams(Object... keyValues) {
    List<Pair> params = new ArrayList<>();
    for (int i = 0; i < keyValues.length; i += 2) {
      String key = (String) keyValues[i];
      Object value = keyValues[i + 1];
      if (value != null) {
        params.addAll(apiClient.parameterToPair(key, value));
      }
    }
    return params;
  }

  protected List<Pair> filterParams(@jakarta.annotation.Nullable List<?> filters) {
    if (filters == null || filters.isEmpty()) {
      return Collections.emptyList();
    }
    return apiClient.parameterToPairs("csv", "filters", filters);
  }

  protected List<Pair> csvParams(String name, @jakarta.annotation.Nullable List<String> values) {
    if (values == null || values.isEmpty()) {
      return Collections.emptyList();
    }
    return apiClient.parameterToPairs("csv", name, values);
  }

  // ---- HTTP helpers ----

  protected <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         TypeReference<T> returnType) throws ApiException {
    return invoke(method, path, body, queryParams, collectionQueryParams,
            accept, contentType, new HashMap<>(), returnType);
  }

  protected <T> T invoke(String method, String path, Object body,
                         List<Pair> queryParams, List<Pair> collectionQueryParams,
                         String accept, String contentType,
                         Map<String, Object> formParams,
                         TypeReference<T> returnType) throws ApiException {
    return apiClient.invokeAPI(
            path, method,
            queryParams != null ? queryParams : Collections.emptyList(),
            collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
            "",
            body,
            new HashMap<>(),
            new HashMap<>(),
            formParams != null ? formParams : new HashMap<>(),
            accept, contentType, AUTH, returnType
    );
  }

  // ---- Streaming (SSE) helpers ----

  protected CloseableHttpResponse openStream(String path, List<Pair> queryParams,
                                             List<Pair> collectionQueryParams,
                                             AtomicReference<org.apache.hc.client5.http.classic.methods.HttpUriRequestBase> requestRef) throws ApiException {
    CloseableHttpResponse response = apiClient.openEventStream(
            path,
            queryParams != null ? queryParams : Collections.emptyList(),
            collectionQueryParams != null ? collectionQueryParams : Collections.emptyList(),
            "",
            new HashMap<>(),
            new HashMap<>(),
            AUTH,
            requestRef
    );

    int statusCode = response.getCode();
    if (!apiClient.isSuccessfulStatus(statusCode)) {
      try {
        HttpEntity entity = response.getEntity();
        String message = entity != null ? EntityUtils.toString(entity) : "HTTP " + statusCode;
        throw new ApiException(message, statusCode,
                apiClient.transformResponseHeaders(response.getHeaders()), message);
      } catch (IOException | ParseException e) {
        throw new ApiException(e);
      } finally {
        try {
          response.close();
        } catch (IOException ignored) {}
      }
    }

    return response;
  }

  protected <T> Flux<T> sseFlux(String path, List<Pair> queryParams,
                                List<Pair> collectionQueryParams, Class<T> eventType) {
    return Flux.<T>create(sink -> {
      AtomicReference<org.apache.hc.client5.http.classic.methods.HttpUriRequestBase> requestRef = new AtomicReference<>();
      AtomicReference<CloseableHttpResponse> responseRef = new AtomicReference<>();
      AtomicReference<BufferedReader> readerRef = new AtomicReference<>();

      sink.onDispose(() -> {
        // Abort the exchange first: it releases the connection immediately and
        // unblocks a reader stuck in readLine(). Merely closing the response or
        // reader would try to drain the (never-ending) SSE stream to EOF and block.
        org.apache.hc.client5.http.classic.methods.HttpUriRequestBase req = requestRef.get();
        if (req != null) req.abort();
        try {
          CloseableHttpResponse resp = responseRef.get();
          if (resp != null) resp.close();
        } catch (IOException ignored) {}
        try {
          BufferedReader r = readerRef.get();
          if (r != null) r.close();
        } catch (IOException ignored) {}
      });

      try {
        CloseableHttpResponse response = openStream(path, queryParams, collectionQueryParams, requestRef);
        responseRef.set(response);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        readerRef.set(reader);

        String line;
        StringBuilder dataBuffer = new StringBuilder();

        while (!sink.isCancelled() && (line = reader.readLine()) != null) {
          if (line.isEmpty()) {
            if (dataBuffer.length() > 0) {
              T ev = apiClient.getObjectMapper().readValue(dataBuffer.toString(), eventType);
              dataBuffer.setLength(0);
              sink.next(ev);
            }
            continue;
          }
          if (line.startsWith("data:")) {
            String payload = line.substring(5);
            if (payload.startsWith(" ")) payload = payload.substring(1);
            dataBuffer.append(payload).append('\n');
          }
        }

        if (dataBuffer.length() > 0) {
          T ev = apiClient.getObjectMapper().readValue(dataBuffer.toString(), eventType);
          sink.next(ev);
        }
        sink.complete();
      } catch (IOException e) {
        if (!sink.isCancelled()) {
          sink.error(new ApiException(e));
        }
      } catch (ApiException e) {
        sink.error(e);
      }
      // Subscribe on a worker thread: the consumer above blocks reading the
      // stream, which would otherwise pin the subscriber's thread and defeat
      // blocking operators' timeouts (e.g. blockLast(timeout)).
    }).subscribeOn(reactor.core.scheduler.Schedulers.boundedElastic());
  }

  // ---- BaseApi invokeAPI overloads ----

  public void invokeAPI(String url, String method) throws ApiException {
    invokeAPI(url, method, null, null, Collections.emptyMap());
  }

  public void invokeAPI(String url, String method, Map<String, String> additionalHeaders) throws ApiException {
    invokeAPI(url, method, null, null, additionalHeaders);
  }

  public void invokeAPI(String url, String method, Object request) throws ApiException {
    invokeAPI(url, method, request, null, Collections.emptyMap());
  }

  public void invokeAPI(String url, String method, Object request, Map<String, String> additionalHeaders) throws ApiException {
    invokeAPI(url, method, request, null, additionalHeaders);
  }

  public <T> T invokeAPI(String url, String method, TypeReference<T> returnType) throws ApiException {
    return invokeAPI(url, method, null, returnType, Collections.emptyMap());
  }

  public <T> T invokeAPI(String url, String method, Object request, TypeReference<T> returnType) throws ApiException {
    return invokeAPI(url, method, request, returnType, Collections.emptyMap());
  }

  public <T> T invokeAPI(String url, String method, Object request,
                         TypeReference<T> returnType,
                         Map<String, String> additionalHeaders) throws ApiException {
    String baseUrl = apiClient.getBaseURL();
    String path = url.startsWith(baseUrl) ? url.substring(baseUrl.length()) : url;
    return apiClient.invokeAPI(
            path, method,
            Collections.emptyList(), Collections.emptyList(), "",
            request,
            additionalHeaders != null ? additionalHeaders : new HashMap<>(),
            new HashMap<>(), new HashMap<>(),
            JSON, JSON, AUTH, returnType
    );
  }
}
