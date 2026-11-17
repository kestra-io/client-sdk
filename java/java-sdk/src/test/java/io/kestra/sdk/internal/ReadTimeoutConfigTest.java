package io.kestra.sdk.internal;

import com.sun.net.httpserver.HttpServer;
import org.apache.hc.core5.util.Timeout;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class ReadTimeoutConfigTest {

    @Test
    void unsetReadTimeout_disablesSocketAndResponseTimeout() {
        assertEquals(Timeout.DISABLED, ApiClient.connectionConfig(0, 0).getSocketTimeout());
        assertEquals(Timeout.DISABLED, ApiClient.requestConfig(0).getResponseTimeout());
        assertEquals(Timeout.DISABLED, ApiClient.requestConfig(-1).getResponseTimeout());
    }

    @Test
    void setReadTimeout_appliesToSocketAndResponse() {
        assertEquals(Timeout.ofMilliseconds(500), ApiClient.connectionConfig(0, 500).getSocketTimeout());
        assertEquals(Timeout.ofMilliseconds(500), ApiClient.requestConfig(500).getResponseTimeout());
    }

    @Test
    void readTimeout_failsOnSlowServer() throws Exception {
        var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.setExecutor(Executors.newCachedThreadPool());
        server.createContext("/", ex -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ex.sendResponseHeaders(200, -1);
            ex.close();
        });
        server.start();
        try (var client = new ApiClient().setReadTimeout(200).getHttpClient()) {
            var url = "http://127.0.0.1:" + server.getAddress().getPort();
            var ex = assertThrows(Exception.class,
                () -> client.execute(new HttpGet(url), r -> r.getCode()));
            assertTrue(ex instanceof SocketTimeoutException || ex.getCause() instanceof SocketTimeoutException);
        } finally {
            server.stop(0);
        }
    }
}
