package test

import (
	"bytes"
	"crypto/rand"
	"encoding/hex"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"net/http/cookiejar"
	"os"
	"path/filepath"
	"regexp"
	"strings"
	"sync"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

// StaticFilter injects the signed CSRF token the UI uses into a meta tag.
var csrfMetaRe = regexp.MustCompile(`<meta name="csrf-token" content="([^"]+)">`)

const (
	HOST           = "http://localhost:9904"
	MAIN_TENANT    = "main"
	TEST_DATA_PATH = "../../../test-utils"

	adminUsername = "root@root.com"
	adminPassword = "Root!1234"
)

var (
	bootstrapOnce sync.Once
	apiToken      string
	bootstrapErr  error
)

// KestraTestClient returns a client authenticated with an API token (Bearer).
// Kestra 2.0 dropped per-request HTTP Basic auth, so the token is bootstrapped
// once per run: create the first super-admin, log in for a JWT cookie session,
// then mint an API token for that user. Bearer auth also bypasses CSRF.
func KestraTestClient() *kestra_api_client.KestraClient {
	bootstrapOnce.Do(func() {
		apiToken, bootstrapErr = bootstrapApiToken()
	})
	if bootstrapErr != nil {
		panic(fmt.Sprintf("kestra auth bootstrap failed: %v", bootstrapErr))
	}
	return kestra_api_client.NewClient(
		HOST,
		kestra_api_client.WithTokenAuth(apiToken),
	)
}

func bootstrapApiToken() (string, error) {
	if err := setupSuperAdmin(); err != nil {
		return "", fmt.Errorf("setup: %w", err)
	}
	return mintApiToken(adminUsername, adminPassword)
}

// NewUserTokenClient logs in as the given user and returns a client
// authenticated with an API token minted for them. Endpoints that act on the
// current user (e.g. changing one's own password) need this since Kestra 2.0
// dropped per-request HTTP Basic auth.
func NewUserTokenClient(username, password string) (*kestra_api_client.KestraClient, error) {
	token, err := mintApiToken(username, password)
	if err != nil {
		return nil, err
	}
	return kestra_api_client.NewClient(HOST, kestra_api_client.WithTokenAuth(token)), nil
}

// mintApiToken authenticates as the given user and returns a freshly minted API
// token, all on one cookie jar:
//  1. login -> JWT cookie;
//  2. load the UI so StaticFilter sets the csrfToken cookie (a static GET emits
//     no JWT Set-Cookie, so the session is untouched);
//  3. create the token — the JWT cookie authenticates, and the X-CSRF-TOKEN
//     header equals the server-set csrfToken cookie (double-submit check).
func mintApiToken(username, password string) (string, error) {
	jar, err := cookiejar.New(nil)
	if err != nil {
		return "", err
	}
	httpClient := &http.Client{Jar: jar, Timeout: 30 * time.Second}

	if err := login(httpClient, username, password); err != nil {
		return "", fmt.Errorf("login(%s): %w", username, err)
	}
	csrf, err := fetchCsrfToken(httpClient)
	if err != nil {
		return "", err
	}
	return createApiToken(httpClient, csrf)
}

// setupSuperAdmin creates the first super-admin and the main tenant. It is a
// no-op (405) once a user already exists, which is the case the CI container
// never hits since it starts from an empty H2 database on every run.
func setupSuperAdmin() error {
	body, _ := json.Marshal(map[string]any{
		"username": adminUsername,
		"password": adminPassword,
		"tenant":   map[string]string{"id": MAIN_TENANT, "name": MAIN_TENANT},
	})
	resp, err := http.Post(HOST+"/api/v1/setup", "application/json", bytes.NewReader(body))
	if err != nil {
		return err
	}
	defer resp.Body.Close()
	if resp.StatusCode == http.StatusOK || resp.StatusCode == http.StatusMethodNotAllowed {
		return nil
	}
	return unexpectedStatus(resp)
}

// EE accepts the JWT only as a cookie (not a Bearer header), so the caller
// reuses this client's jar for the authenticated request that follows.
func login(httpClient *http.Client, username, password string) error {
	body, _ := json.Marshal(map[string]string{
		"username": username,
		"password": password,
	})
	resp, err := httpClient.Post(HOST+"/login", "application/json", bytes.NewReader(body))
	if err != nil {
		return err
	}
	defer resp.Body.Close()
	if resp.StatusCode != http.StatusOK {
		return unexpectedStatus(resp)
	}
	return nil
}

func createApiToken(httpClient *http.Client, csrf string) (string, error) {
	body, _ := json.Marshal(map[string]any{
		"name":   "ci-token",
		"maxAge": "P1D",
	})
	req, err := http.NewRequest(http.MethodPost, HOST+"/api/v1/me/api-tokens", bytes.NewReader(body))
	if err != nil {
		return "", err
	}
	req.Header.Set("Content-Type", "application/json")
	// Double-submit: the header must equal the csrfToken cookie the server set
	// on this jar during fetchCsrfToken; the jar sends that cookie automatically.
	req.Header.Set("X-CSRF-TOKEN", csrf)
	resp, err := httpClient.Do(req)
	if err != nil {
		return "", err
	}
	defer resp.Body.Close()
	if resp.StatusCode != http.StatusOK && resp.StatusCode != http.StatusCreated {
		return "", unexpectedStatus(resp)
	}
	var parsed struct {
		FullToken string `json:"fullToken"`
	}
	if err := json.NewDecoder(resp.Body).Decode(&parsed); err != nil {
		return "", err
	}
	if parsed.FullToken == "" {
		return "", fmt.Errorf("response had no fullToken")
	}
	return parsed.FullToken, nil
}

// fetchCsrfToken loads the UI on the given client so StaticFilter sets the
// csrfToken cookie in its jar, and returns the matching token from the meta
// tag the UI itself reads. The header (this token) and the server-set cookie
// then satisfy the double-submit CSRF check on the later write.
//
// On Kestra 1.3 the /ui/ page serves no csrf meta tag and the token endpoint
// does not enforce CSRF, so the absence of the tag is not an error: return an
// empty token and let the caller proceed with an empty X-CSRF-TOKEN header.
func fetchCsrfToken(httpClient *http.Client) (string, error) {
	resp, err := httpClient.Get(HOST + "/ui/")
	if err != nil {
		return "", err
	}
	defer resp.Body.Close()
	body, _ := io.ReadAll(io.LimitReader(resp.Body, 1<<20))

	if m := csrfMetaRe.FindSubmatch(body); m != nil {
		return string(m[1]), nil
	}
	// No csrf meta tag (e.g. Kestra 1.3): proceed without a token.
	return "", nil
}

func unexpectedStatus(resp *http.Response) error {
	b, _ := io.ReadAll(io.LimitReader(resp.Body, 2048))
	return fmt.Errorf("unexpected status %d: %s", resp.StatusCode, strings.TrimSpace(string(b)))
}

func randomId() string {
	b := make([]byte, 16)
	_, err := rand.Read(b)
	if err != nil {
		panic(err)
	}
	return hex.EncodeToString(b)
}

type FlowBodyAndId struct {
	FlowBody      string
	FlowNamespace string
	FlowId        string
}

func GetCompleteFlow() string {
	s := get(filepath.Join(TEST_DATA_PATH, "flows", "flow_complete.yml"))
	s = strings.ReplaceAll(s, "flow_complete", randomId())
	s = strings.ReplaceAll(s, "tests", randomId())
	return s
}

func GetSimpleFlow() string {
	return GetSimpleFlowAndId().FlowBody
}

func GetSimpleFlowAndId() FlowBodyAndId {
	flowId := randomId()
	namespace := randomId()
	body := get(filepath.Join(TEST_DATA_PATH, "flows", "simple_flow.yml"))
	body = strings.ReplaceAll(body, "simple_flow_id_to_replace_by_random_id", flowId)
	body = strings.ReplaceAll(body, "simple_flow_namespace_to_replace_by_random_id", namespace)
	return FlowBodyAndId{
		FlowBody:      body,
		FlowNamespace: namespace,
		FlowId:        flowId,
	}
}

func get(filePath string) string {
	if !filepath.IsAbs(filePath) {
		if wd, err := os.Getwd(); err == nil {
			filePath = filepath.Join(wd, filePath)
		}
	}
	b, err := os.ReadFile(filePath)
	if err != nil {
		panic(err)
	}
	return string(b)
}
