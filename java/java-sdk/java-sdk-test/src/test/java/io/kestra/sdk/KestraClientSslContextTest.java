package io.kestra.sdk;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KestraClientSslContextTest {
    private static final char[] PASSWORD = "changeit".toCharArray();

    private static HttpsServer server;
    private static SSLContext trusting;
    private static String url;

    @BeforeAll
    static void startServer(@TempDir Path dir) throws Exception {
        // Self-signed cert generated at runtime with the JDK's keytool; nothing checked in.
        Path keystore = dir.resolve("server.p12");
        Process process = new ProcessBuilder(
            Path.of(System.getProperty("java.home"), "bin", "keytool").toString(),
            "-genkeypair", "-alias", "server", "-keyalg", "RSA", "-keysize", "2048",
            "-dname", "CN=localhost", "-ext", "SAN=dns:localhost,ip:127.0.0.1",
            "-validity", "2", "-storetype", "PKCS12",
            "-keystore", keystore.toString(), "-storepass", new String(PASSWORD)
        ).redirectErrorStream(true).start();
        String output = new String(process.getInputStream().readAllBytes());
        assertThat(process.waitFor()).as(output).isZero();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream in = Files.newInputStream(keystore)) {
            keyStore.load(in, PASSWORD);
        }

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, PASSWORD);
        SSLContext serverContext = SSLContext.getInstance("TLS");
        serverContext.init(kmf.getKeyManagers(), null, null);

        // Trust store holding only the certificate, no private key.
        KeyStore trustStore = KeyStore.getInstance("PKCS12");
        trustStore.load(null, null);
        trustStore.setCertificateEntry("server", keyStore.getCertificate("server"));
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        trusting = SSLContext.getInstance("TLS");
        trusting.init(null, tmf.getTrustManagers(), null);

        server = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        server.setHttpsConfigurator(new HttpsConfigurator(serverContext));
        server.createContext("/", exchange -> {
            exchange.sendResponseHeaders(404, -1);
            exchange.close();
        });
        server.start();
        url = "https://localhost:" + server.getAddress().getPort();
    }

    @AfterAll
    static void stopServer() {
        server.stop(0);
    }

    /** Any HTTP status means the TLS handshake passed; only a transport failure is reported. */
    private static Throwable callFailure(KestraClient client) {
        try {
            client.flows().listFlowsByNamespace("ns", "main");
            return null;
        } catch (Throwable e) {
            return e;
        }
    }

    private static boolean hasHandshakeFailure(Throwable failure) {
        List<Throwable> seen = new ArrayList<>();
        for (Throwable t = failure; t != null && !seen.contains(t); t = t.getCause()) {
            seen.add(t);
            if (t instanceof SSLHandshakeException) {
                return true;
            }
        }
        return false;
    }

    @Test
    void withoutSslContext_handshakeFails() {
        Throwable failure = callFailure(KestraClient.builder().url(url).build());
        assertThat(failure).isNotNull();
        assertThat(hasHandshakeFailure(failure)).as("cause chain of %s", failure).isTrue();
    }

    @Test
    void withTrustingSslContext_handshakeSucceeds() {
        Throwable failure = callFailure(KestraClient.builder().url(url).sslContext(trusting).build());
        assertThat(failure == null || !hasHandshakeFailure(failure)).as("failure: %s", failure).isTrue();
    }

    @Test
    void sslContext_survivesTimeoutRebuild() {
        var client = KestraClient.builder()
            .url(url)
            .sslContext(trusting)
            .connectTimeout(Duration.ofSeconds(5))
            .readTimeout(Duration.ofSeconds(5))
            .build();
        assertThat(client.apiClient().getSslContext()).isSameAs(trusting);

        // Setters called after the context rebuild the client again.
        client.apiClient().setReadTimeout(10_000).setConnectTimeout(2_000);
        Throwable failure = callFailure(client);
        assertThat(failure == null || !hasHandshakeFailure(failure)).as("failure: %s", failure).isTrue();
    }

    @Test
    void jvmDefaultSslContext_doesNotApplyToClient() throws Exception {
        SSLContext previous = SSLContext.getDefault();
        try {
            SSLContext.setDefault(trusting);
            Throwable failure = callFailure(KestraClient.builder().url(url).build());
            assertThat(failure).isNotNull();
            assertThat(hasHandshakeFailure(failure)).as("cause chain of %s", failure).isTrue();
        } finally {
            SSLContext.setDefault(previous);
        }
    }
}
