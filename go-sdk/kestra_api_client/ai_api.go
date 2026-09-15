package kestra_api_client

import (
	"bytes"
	"context"
	"encoding/json"
	"io"
	"net/http"
)

// AiAPI covers the AI Copilot endpoints: the one-shot generators under
// /api/v1/{tenant}/ai/generate/* and /api/v1/main/ai/*, and the conversational
// thread endpoints under /api/v1/{tenant}/ai/threads. The controllers are gated
// by the COPILOT resource and require a configured AI provider (503 otherwise).
type AiAPI struct {
	baseAPI
}

// postForYAML sends a JSON body and reads a YAML (text) response body, used by
// the one-shot generators which produce application/yaml.
func (a *AiAPI) postForYAML(ctx context.Context, method, path string, body interface{}) (string, error) {
	var reader io.Reader
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return "", err
		}
		reader = bytes.NewReader(data)
	}
	resp, err := a.doRequest(ctx, method, path, reader, nil, contentYAML, contentJSON)
	if err != nil {
		return "", err
	}
	defer resp.Body.Close()
	out, err := io.ReadAll(resp.Body)
	if err != nil {
		return "", err
	}
	return string(out), nil
}

// GenerateApp generates an app definition (YAML) from a natural-language prompt.
// `body` is an AppGenerationPrompt. Backs POST /api/v1/{tenant}/ai/generate/app.
func (a *AiAPI) GenerateApp(ctx context.Context, tenant string, body interface{}) (string, error) {
	return a.postForYAML(ctx, "POST", tenantPath(tenant, "ai", "generate", "app"), body)
}

// GenerateDashboard generates a dashboard definition (YAML). `body` is a
// DashboardGenerationPrompt. Backs POST /api/v1/{tenant}/ai/generate/dashboard.
func (a *AiAPI) GenerateDashboard(ctx context.Context, tenant string, body interface{}) (string, error) {
	return a.postForYAML(ctx, "POST", tenantPath(tenant, "ai", "generate", "dashboard"), body)
}

// GenerateTest generates a test-suite definition (YAML). `body` is a
// TestSuiteGenerationPrompt. Backs POST /api/v1/{tenant}/ai/generate/test.
func (a *AiAPI) GenerateTest(ctx context.Context, tenant string, body interface{}) (string, error) {
	return a.postForYAML(ctx, "POST", tenantPath(tenant, "ai", "generate", "test"), body)
}

// GenerateFlow generates a flow definition (YAML) from a natural-language
// prompt. `body` is a FlowGenerationPrompt. Backs POST /api/v1/main/ai/generate/flow.
func (a *AiAPI) GenerateFlow(ctx context.Context, body interface{}) (string, error) {
	return a.postForYAML(ctx, "POST", superadminPath("main", "ai", "generate", "flow"), body)
}

// ListAiProviders lists the configured AI providers. Backs GET /api/v1/main/ai/providers.
func (a *AiAPI) ListAiProviders(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("main", "ai", "providers"), nil, nil)
}

// ListThreads lists the current user's AI threads. Backs GET /api/v1/{tenant}/ai/threads.
func (a *AiAPI) ListThreads(ctx context.Context, tenant string) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "ai", "threads"), nil, nil)
}

// CreateThread opens a new AI thread. `body` is an ApiCreateThreadRequest
// ({mode?, title?}). Backs POST /api/v1/{tenant}/ai/threads.
func (a *AiAPI) CreateThread(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "ai", "threads"), body, nil)
}

// Thread returns a single AI thread with its messages. Backs GET
// /api/v1/{tenant}/ai/threads/{threadId}.
func (a *AiAPI) Thread(ctx context.Context, threadId, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "ai", "threads", threadId), nil, nil)
}

// DeleteThread deletes an AI thread. Backs DELETE /api/v1/{tenant}/ai/threads/{threadId}.
func (a *AiAPI) DeleteThread(ctx context.Context, threadId, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "ai", "threads", threadId), nil, nil)
}

// RenameThread renames an AI thread. `body` is an ApiRenameThreadRequest
// ({title}). Backs PATCH /api/v1/{tenant}/ai/threads/{threadId}/rename.
func (a *AiAPI) RenameThread(ctx context.Context, threadId, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "PATCH", tenantPath(tenant, "ai", "threads", threadId, "rename"), body, nil)
}

// ChatInThread sends a chat turn and returns the raw SSE response for the caller
// to stream (Content-Type text/event-stream). The caller must close the body.
// `body` is an ApiChatTurnRequest. Backs POST /api/v1/{tenant}/ai/threads/{threadId}/chat.
func (a *AiAPI) ChatInThread(ctx context.Context, threadId, tenant string, body interface{}) (*http.Response, error) {
	var reader io.Reader
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return nil, err
		}
		reader = bytes.NewReader(data)
	}
	return a.doRequest(ctx, "POST", tenantPath(tenant, "ai", "threads", threadId, "chat"), reader, nil, "text/event-stream", contentJSON)
}

// ConfirmThreadAction confirms (or rejects) a pending tool action and returns the
// raw SSE response for the caller to stream. `body` is an ApiConfirmActionRequest.
// Backs POST /api/v1/{tenant}/ai/threads/{threadId}/confirm.
func (a *AiAPI) ConfirmThreadAction(ctx context.Context, threadId, tenant string, body interface{}) (*http.Response, error) {
	var reader io.Reader
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return nil, err
		}
		reader = bytes.NewReader(data)
	}
	return a.doRequest(ctx, "POST", tenantPath(tenant, "ai", "threads", threadId, "confirm"), reader, nil, "text/event-stream", contentJSON)
}
