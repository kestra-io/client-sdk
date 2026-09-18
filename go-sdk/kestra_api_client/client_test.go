package kestra_api_client

import (
	"bytes"
	"context"
	"encoding/base64"
	"net/http"
	"net/http/httptest"
	"strings"
	"testing"
)

// captureRequest spins up a test server that records the headers of the
// incoming request and returns the configured client baseURL plus a pointer to
// the captured headers.
func captureRequest(t *testing.T, opts ...ClientOption) (*KestraClient, *http.Header) {
	t.Helper()
	var captured http.Header
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		captured = r.Header.Clone()
		w.WriteHeader(http.StatusOK)
	}))
	t.Cleanup(srv.Close)
	client := NewClient(srv.URL, opts...)
	return client, &captured
}

func TestWithHeaders_MergesIntoEveryRequest(t *testing.T) {
	client, captured := captureRequest(t,
		WithHeaders(map[string]string{
			"X-Proxy":  "gateway",
			"X-Tenant": "acme",
		}),
		WithHeader("X-Single", "one"),
	)

	if _, err := client.Misc().baseAPI.doText(context.Background(), "GET", "/", nil); err != nil {
		t.Fatalf("request failed: %v", err)
	}

	if got := captured.Get("X-Proxy"); got != "gateway" {
		t.Errorf("X-Proxy = %q, want %q", got, "gateway")
	}
	if got := captured.Get("X-Tenant"); got != "acme" {
		t.Errorf("X-Tenant = %q, want %q", got, "acme")
	}
	if got := captured.Get("X-Single"); got != "one" {
		t.Errorf("X-Single = %q, want %q", got, "one")
	}
}

func TestWithTokenAuth_OverridesUserAuthorizationHeader(t *testing.T) {
	// Option order intentionally puts WithHeaders last to prove that the
	// explicit auth option wins regardless of ordering.
	client, captured := captureRequest(t,
		WithTokenAuth("real-token"),
		WithHeaders(map[string]string{"Authorization": "Bearer user-supplied"}),
	)

	if _, err := client.Misc().baseAPI.doText(context.Background(), "GET", "/", nil); err != nil {
		t.Fatalf("request failed: %v", err)
	}

	if got := captured.Get("Authorization"); got != "Bearer real-token" {
		t.Errorf("Authorization = %q, want %q", got, "Bearer real-token")
	}
}

func TestWithBasicAuth_OverridesUserAuthorizationHeader(t *testing.T) {
	client, captured := captureRequest(t,
		WithHeaders(map[string]string{"Authorization": "Bearer user-supplied"}),
		WithBasicAuth("user", "pass"),
	)

	if _, err := client.Misc().baseAPI.doText(context.Background(), "GET", "/", nil); err != nil {
		t.Fatalf("request failed: %v", err)
	}

	want := "Basic " + base64.StdEncoding.EncodeToString([]byte("user:pass"))
	if got := captured.Get("Authorization"); got != want {
		t.Errorf("Authorization = %q, want %q", got, want)
	}
}

func TestWithLogger_RedactsSensitiveHeaders(t *testing.T) {
	var buf bytes.Buffer
	client, _ := captureRequest(t,
		WithTokenAuth("super-secret-token"),
		WithHeader("Cookie", "session=topsecret"),
		WithHeader("X-Proxy", "gateway"),
		WithLogger(&buf),
	)

	if _, err := client.Misc().baseAPI.doText(context.Background(), "GET", "/", nil); err != nil {
		t.Fatalf("request failed: %v", err)
	}

	out := buf.String()

	// Diagnostics are present.
	if !strings.Contains(out, "> GET ") {
		t.Errorf("debug output missing request line:\n%s", out)
	}
	if !strings.Contains(out, "< 200") {
		t.Errorf("debug output missing response status:\n%s", out)
	}
	// Non-sensitive header value is shown.
	if !strings.Contains(out, "X-Proxy: gateway") {
		t.Errorf("debug output missing non-sensitive header:\n%s", out)
	}
	// Sensitive values are redacted and never leak.
	if strings.Contains(out, "super-secret-token") {
		t.Errorf("Authorization token leaked into debug output:\n%s", out)
	}
	if strings.Contains(out, "topsecret") {
		t.Errorf("Cookie value leaked into debug output:\n%s", out)
	}
	if !strings.Contains(out, "Authorization: "+redactedValue) {
		t.Errorf("Authorization header not redacted:\n%s", out)
	}
	if !strings.Contains(out, "Cookie: "+redactedValue) {
		t.Errorf("Cookie header not redacted:\n%s", out)
	}
}

func TestWithoutDebug_ProducesNoOutput(t *testing.T) {
	var buf bytes.Buffer
	client, _ := captureRequest(t, WithTokenAuth("token"))
	client.logger = &buf // debug stays false, so nothing should be written

	if _, err := client.Misc().baseAPI.doText(context.Background(), "GET", "/", nil); err != nil {
		t.Fatalf("request failed: %v", err)
	}

	if buf.Len() != 0 {
		t.Errorf("expected no debug output when debug disabled, got:\n%s", buf.String())
	}
}
