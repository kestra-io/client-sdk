package io.kestra.sdk;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import io.kestra.sdk.internal.ApiException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
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
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class KestraClientSslContextTest {
    private static final char[] PASSWORD = "changeit".toCharArray();

    private static HttpsServer server;
    private static HttpsServer localhostOnlyServer;
    private static SSLContext trusting;
    private static SSLContext localhostOnlyTrusting;
    private static String url;

    private record TestServer(HttpsServer server, SSLContext trusting) {}

    @BeforeAll
    static void startServers(@TempDir Path dir) throws Exception {
        var both = startServer(dir.resolve("both.p12"), "dns:localhost,ip:127.0.0.1");
        server = both.server();
        trusting = both.trusting();
        url = "https://localhost:" + server.getAddress().getPort();

        var localhostOnly = startServer(dir.resolve("localhost.p12"), "dns:localhost");
        localhostOnlyServer = localhostOnly.server();
        localhostOnlyTrusting = localhostOnly.trusting();
    }

    // Self-signed cert generated at runtime with the JDK's keytool; nothing checked in.
    private static TestServer startServer(Path keystore, String san) throws Exception {
        var process = new ProcessBuilder(
            Path.of(System.getProperty("java.home"), "bin", "keytool").toString(),
            "-genkeypair", "-alias", "server", "-keyalg", "RSA", "-keysize", "2048",
            "-dname", "CN=localhost", "-ext", "SAN=" + san,
            "-validity", "2", "-storetype", "PKCS12",
            "-keystore", keystore.toString(), "-storepass", new String(PASSWORD)
        ).redirectErrorStream(true).start();
        if (!process.waitFor(60, TimeUnit.SECONDS)) {
            process.destroyForcibly();
            fail("keytool did not finish within 60s");
        }
        assertThat(process.exitValue()).as(new String(process.getInputStream().readAllBytes())).isZero();

        var keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream in = Files.newInputStream(keystore)) {
            keyStore.load(in, PASSWORD);
        }

        var kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, PASSWORD);
        var serverContext = SSLContext.getInstance("TLS");
        serverContext.init(kmf.getKeyManagers(), null, null);

        // Trust store holding only the certificate, no private key.
        var trustStore = KeyStore.getInstance("PKCS12");
        trustStore.load(null, null);
        trustStore.setCertificateEntry("server", keyStore.getCertificate("server"));
        var tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        var clientContext = SSLContext.getInstance("TLS");
        clientContext.init(null, tmf.getTrustManagers(), null);

        var httpsServer = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(serverContext));
        httpsServer.createContext("/", exchange -> {
            exchange.sendResponseHeaders(404, -1);
            exchange.close();
        });
        httpsServer.start();
        return new TestServer(httpsServer, clientContext);
    }

    @AfterAll
    static void stopServers() {
        server.stop(0);
        localhostOnlyServer.stop(0);
    }

    private static Throwable callFailure(KestraClient client) {
        try {
            client.flows().listFlowsByNamespace("ns", "main");
            return null;
        } catch (Throwable e) {
            return e;
        }
    }

    private static boolean hasCause(Throwable failure, Class<? extends Throwable> type) {
        List<Throwable> seen = new ArrayList<>();
        for (var t = failure; t != null && !seen.contains(t); t = t.getCause()) {
            seen.add(t);
            if (type.isInstance(t)) {
                return true;
            }
        }
        return false;
    }

    /** The stub answers 404, so reaching it proves both the handshake and the hostname check passed. */
    private static void assertReachedServer(Throwable failure) {
        assertThat(failure).isInstanceOfSatisfying(ApiException.class, e -> assertThat(e.getCode()).isEqualTo(404));
    }

    @Test
    void withoutSslContext_handshakeFails() {
        var failure = callFailure(KestraClient.builder().url(url).build());
        assertThat(failure).isNotNull();
        assertThat(hasCause(failure, SSLHandshakeException.class)).as("cause chain of %s", failure).isTrue();
    }

    @Test
    void withTrustingSslContext_handshakeSucceeds() {
        assertReachedServer(callFailure(KestraClient.builder().url(url).sslContext(trusting).build()));
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
        assertReachedServer(callFailure(client));
    }

    @Test
    void hostnameVerification_staysStrict() {
        var ipUrl = "https://127.0.0.1:" + localhostOnlyServer.getAddress().getPort();
        var failure = callFailure(KestraClient.builder().url(ipUrl).sslContext(localhostOnlyTrusting).build());
        assertThat(failure).isNotNull();
        assertThat(hasCause(failure, SSLPeerUnverifiedException.class)).as("cause chain of %s", failure).isTrue();
    }

    @Test
    void jvmDefaultSslContext_doesNotApplyToClient() throws Exception {
        var previous = SSLContext.getDefault();
        try {
            SSLContext.setDefault(trusting);
            var failure = callFailure(KestraClient.builder().url(url).build());
            assertThat(failure).isNotNull();
            assertThat(hasCause(failure, SSLHandshakeException.class)).as("cause chain of %s", failure).isTrue();
        } finally {
            SSLContext.setDefault(previous);
        }
    }
}
