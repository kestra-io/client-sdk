package kestra_api_client

import (
	"bufio"
	"bytes"
	"context"
	"encoding/json"
	"fmt"
	"io"
	"mime/multipart"
	"net/http"
	"net/url"
	"os"
	"path/filepath"
	"strings"
)

const (
	contentJSON      = "application/json"
	contentYAML      = "application/x-yaml"
	contentPlainText = "text/plain"
	contentOctet     = "application/octet-stream"
	contentMultipart = "multipart/form-data"
	contentCSV       = "text/csv"
)

type baseAPI struct {
	client *KestraClient
}

func tenantPath(tenant string, segments ...string) string {
	var sb strings.Builder
	sb.WriteString("/api/v1/")
	sb.WriteString(url.PathEscape(tenant))
	for _, s := range segments {
		sb.WriteString("/")
		sb.WriteString(url.PathEscape(s))
	}
	return sb.String()
}

func superadminPath(segments ...string) string {
	var sb strings.Builder
	sb.WriteString("/api/v1")
	for _, s := range segments {
		sb.WriteString("/")
		sb.WriteString(url.PathEscape(s))
	}
	return sb.String()
}

func buildQueryParams(keyValues ...interface{}) url.Values {
	params := url.Values{}
	for i := 0; i+1 < len(keyValues); i += 2 {
		key, ok := keyValues[i].(string)
		if !ok {
			continue
		}
		val := keyValues[i+1]
		if val == nil {
			continue
		}
		switch v := val.(type) {
		case *int:
			if v != nil {
				params.Set(key, fmt.Sprintf("%d", *v))
			}
		case *int32:
			if v != nil {
				params.Set(key, fmt.Sprintf("%d", *v))
			}
		case *int64:
			if v != nil {
				params.Set(key, fmt.Sprintf("%d", *v))
			}
		case *bool:
			if v != nil {
				params.Set(key, fmt.Sprintf("%t", *v))
			}
		case *string:
			if v != nil {
				params.Set(key, *v)
			}
		case string:
			if v != "" {
				params.Set(key, v)
			}
		case int:
			params.Set(key, fmt.Sprintf("%d", v))
		case int32:
			params.Set(key, fmt.Sprintf("%d", v))
		case int64:
			params.Set(key, fmt.Sprintf("%d", v))
		case bool:
			params.Set(key, fmt.Sprintf("%t", v))
		default:
			params.Set(key, fmt.Sprintf("%v", v))
		}
	}
	return params
}

func appendRepeatedParam(params url.Values, key string, values []string) {
	if len(values) == 0 {
		return
	}
	for _, v := range values {
		params.Add(key, v)
	}
}

func (b *baseAPI) doRequest(ctx context.Context, method, path string, body io.Reader, params url.Values, accept, contentType string) (*http.Response, error) {
	u := b.client.baseURL + path
	if len(params) > 0 {
		u += "?" + params.Encode()
	}

	req, err := http.NewRequestWithContext(ctx, method, u, body)
	if err != nil {
		return nil, err
	}

	for k, v := range b.client.headers {
		req.Header.Set(k, v)
	}
	if b.client.authHeader != "" {
		req.Header.Set("Authorization", b.client.authHeader)
	}
	if contentType != "" {
		req.Header.Set("Content-Type", contentType)
	}
	if accept != "" {
		req.Header.Set("Accept", accept)
	}

	b.client.logRequest(req)

	resp, err := b.client.httpClient.Do(req)
	if err != nil {
		return nil, err
	}

	b.client.logResponse(resp)

	if resp.StatusCode >= 400 {
		defer resp.Body.Close()
		respBody, _ := io.ReadAll(resp.Body)
		return nil, &ApiError{
			StatusCode: resp.StatusCode,
			Body:       respBody,
		}
	}

	return resp, nil
}

func doJSON[T any](b *baseAPI, ctx context.Context, method, path string, body interface{}, params url.Values) (T, error) {
	var zero T
	var bodyReader io.Reader
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return zero, err
		}
		bodyReader = bytes.NewReader(data)
	}

	resp, err := b.doRequest(ctx, method, path, bodyReader, params, contentJSON, contentJSON)
	if err != nil {
		return zero, err
	}
	defer resp.Body.Close()

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return zero, err
	}
	if len(data) == 0 {
		return zero, nil
	}

	var result T
	if err := json.Unmarshal(data, &result); err != nil {
		return zero, err
	}
	return result, nil
}

func doJSONWithYAMLBody[T any](b *baseAPI, ctx context.Context, method, path string, yamlBody string, params url.Values) (T, error) {
	var zero T
	resp, err := b.doRequest(ctx, method, path, strings.NewReader(yamlBody), params, contentJSON, contentYAML)
	if err != nil {
		return zero, err
	}
	defer resp.Body.Close()

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return zero, err
	}
	if len(data) == 0 {
		return zero, nil
	}

	var result T
	if err := json.Unmarshal(data, &result); err != nil {
		return zero, err
	}
	return result, nil
}

func doJSONWithTextBody[T any](b *baseAPI, ctx context.Context, method, path string, textBody string, params url.Values) (T, error) {
	var zero T
	resp, err := b.doRequest(ctx, method, path, strings.NewReader(textBody), params, contentJSON, contentPlainText)
	if err != nil {
		return zero, err
	}
	defer resp.Body.Close()

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return zero, err
	}
	if len(data) == 0 {
		return zero, nil
	}

	var result T
	if err := json.Unmarshal(data, &result); err != nil {
		return zero, err
	}
	return result, nil
}

func (b *baseAPI) doVoid(ctx context.Context, method, path string, body interface{}, params url.Values) error {
	var bodyReader io.Reader
	contentType := ""
	if body != nil {
		switch v := body.(type) {
		case string:
			bodyReader = strings.NewReader(v)
			contentType = contentYAML
		default:
			data, err := json.Marshal(body)
			if err != nil {
				return err
			}
			bodyReader = bytes.NewReader(data)
			contentType = contentJSON
		}
	}

	resp, err := b.doRequest(ctx, method, path, bodyReader, params, "", contentType)
	if err != nil {
		return err
	}
	resp.Body.Close()
	return nil
}

func (b *baseAPI) doVoidJSON(ctx context.Context, method, path string, body interface{}, params url.Values) error {
	var bodyReader io.Reader
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return err
		}
		bodyReader = bytes.NewReader(data)
	}

	resp, err := b.doRequest(ctx, method, path, bodyReader, params, "", contentJSON)
	if err != nil {
		return err
	}
	resp.Body.Close()
	return nil
}

func (b *baseAPI) doVoidYAML(ctx context.Context, method, path string, yamlBody string, params url.Values) error {
	resp, err := b.doRequest(ctx, method, path, strings.NewReader(yamlBody), params, "", contentYAML)
	if err != nil {
		return err
	}
	resp.Body.Close()
	return nil
}

func (b *baseAPI) doVoidText(ctx context.Context, method, path string, textBody string, params url.Values) error {
	resp, err := b.doRequest(ctx, method, path, strings.NewReader(textBody), params, "", contentPlainText)
	if err != nil {
		return err
	}
	resp.Body.Close()
	return nil
}

func (b *baseAPI) doDownload(ctx context.Context, method, path string, body interface{}, params url.Values, acceptOverrides ...string) (*os.File, error) {
	var bodyReader io.Reader
	contentType := ""
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return nil, err
		}
		bodyReader = bytes.NewReader(data)
		contentType = contentJSON
	}

	accept := contentOctet
	if len(acceptOverrides) > 0 && acceptOverrides[0] != "" {
		accept = acceptOverrides[0]
	}

	resp, err := b.doRequest(ctx, method, path, bodyReader, params, accept, contentType)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	tmpFile, err := os.CreateTemp("", "kestra-download-*")
	if err != nil {
		return nil, err
	}
	if _, err := io.Copy(tmpFile, resp.Body); err != nil {
		tmpFile.Close()
		os.Remove(tmpFile.Name())
		return nil, err
	}
	tmpFile.Seek(0, 0)
	return tmpFile, nil
}

func (b *baseAPI) doDownloadBytes(ctx context.Context, method, path string, body interface{}, params url.Values) ([]byte, error) {
	var bodyReader io.Reader
	contentType := ""
	if body != nil {
		data, err := json.Marshal(body)
		if err != nil {
			return nil, err
		}
		bodyReader = bytes.NewReader(data)
		contentType = contentJSON
	}

	resp, err := b.doRequest(ctx, method, path, bodyReader, params, contentOctet, contentType)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	return io.ReadAll(resp.Body)
}

func (b *baseAPI) doText(ctx context.Context, method, path string, params url.Values, acceptOverrides ...string) (string, error) {
	accept := contentPlainText
	if len(acceptOverrides) > 0 && acceptOverrides[0] != "" {
		accept = acceptOverrides[0]
	}
	resp, err := b.doRequest(ctx, method, path, nil, params, accept, "")
	if err != nil {
		return "", err
	}
	defer resp.Body.Close()

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return "", err
	}
	return string(data), nil
}

func (b *baseAPI) doCSV(ctx context.Context, path string, params url.Values) (string, error) {
	resp, err := b.doRequest(ctx, "GET", path, nil, params, contentCSV, "")
	if err != nil {
		return "", err
	}
	defer resp.Body.Close()

	data, err := io.ReadAll(resp.Body)
	if err != nil {
		return "", err
	}
	return string(data), nil
}

func doMultipartUpload[T any](b *baseAPI, ctx context.Context, method, path string, params url.Values, fieldName string, filePath string) (T, error) {
	var zero T

	file, err := os.Open(filePath)
	if err != nil {
		return zero, err
	}
	defer file.Close()

	var buf bytes.Buffer
	writer := multipart.NewWriter(&buf)
	part, err := writer.CreateFormFile(fieldName, filepath.Base(filePath))
	if err != nil {
		return zero, err
	}
	if _, err := io.Copy(part, file); err != nil {
		return zero, err
	}
	writer.Close()

	resp, err := b.doRequest(ctx, method, path, &buf, params, contentJSON, writer.FormDataContentType())
	if err != nil {
		return zero, err
	}
	defer resp.Body.Close()

	var result T
	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		return zero, err
	}
	return result, nil
}

func (b *baseAPI) doMultipartUploadVoid(ctx context.Context, method, path string, params url.Values, fieldName string, fileContent io.Reader, fileName string) error {
	var buf bytes.Buffer
	writer := multipart.NewWriter(&buf)
	part, err := writer.CreateFormFile(fieldName, fileName)
	if err != nil {
		return err
	}
	if _, err := io.Copy(part, fileContent); err != nil {
		return err
	}
	writer.Close()

	resp, err := b.doRequest(ctx, method, path, &buf, params, "", writer.FormDataContentType())
	if err != nil {
		return err
	}
	resp.Body.Close()
	return nil
}

func (b *baseAPI) doMultipartJSON(ctx context.Context, method, path string, params url.Values, formParams map[string]interface{}) (*http.Response, error) {
	var buf bytes.Buffer
	writer := multipart.NewWriter(&buf)

	for key, val := range formParams {
		switch v := val.(type) {
		case *os.File:
			part, err := writer.CreateFormFile(key, filepath.Base(v.Name()))
			if err != nil {
				return nil, err
			}
			if _, err := io.Copy(part, v); err != nil {
				return nil, err
			}
		case string:
			writer.WriteField(key, v)
		}
	}
	writer.Close()

	return b.doRequest(ctx, method, path, &buf, params, contentJSON, writer.FormDataContentType())
}

func (b *baseAPI) openSSEStream(ctx context.Context, path string, params url.Values) (*http.Response, error) {
	u := b.client.baseURL + path
	if len(params) > 0 {
		u += "?" + params.Encode()
	}

	req, err := http.NewRequestWithContext(ctx, "GET", u, nil)
	if err != nil {
		return nil, err
	}

	for k, v := range b.client.headers {
		req.Header.Set(k, v)
	}
	if b.client.authHeader != "" {
		req.Header.Set("Authorization", b.client.authHeader)
	}
	req.Header.Set("Accept", "text/event-stream")

	b.client.logRequest(req)

	resp, err := b.client.httpClient.Do(req)
	if err != nil {
		return nil, err
	}

	b.client.logResponse(resp)

	if resp.StatusCode >= 400 {
		defer resp.Body.Close()
		respBody, _ := io.ReadAll(resp.Body)
		return nil, &ApiError{
			StatusCode: resp.StatusCode,
			Body:       respBody,
		}
	}

	return resp, nil
}

// followSSE opens an SSE stream at path and decodes each event payload into T.
// The returned channel is closed when the stream ends or the context is cancelled.
func followSSE[T any](b *baseAPI, ctx context.Context, path string, params url.Values) (<-chan *T, error) {
	resp, err := b.openSSEStream(ctx, path, params)
	if err != nil {
		return nil, err
	}

	ch := make(chan *T)
	go func() {
		defer close(ch)
		defer resp.Body.Close()

		// emit decodes a buffered event payload and sends it on the channel.
		// It returns false when the context is cancelled.
		emit := func(payload string) bool {
			var ev T
			if err := json.Unmarshal([]byte(payload), &ev); err != nil {
				b.client.logDebugf("! sse: dropping undecodable event: %v", err)
				return true
			}
			select {
			case ch <- &ev:
				return true
			case <-ctx.Done():
				return false
			}
		}

		scanner := bufio.NewScanner(resp.Body)
		// raise the line limit above bufio's 64KB default: a single log message
		// (stack trace, dumped payload) can easily exceed it and would otherwise
		// silently terminate the stream with ErrTooLong
		scanner.Buffer(make([]byte, 0, 64*1024), 1024*1024)
		var dataBuffer strings.Builder

		for scanner.Scan() {
			line := scanner.Text()

			if line == "" {
				if dataBuffer.Len() > 0 {
					if !emit(dataBuffer.String()) {
						return
					}
					dataBuffer.Reset()
				}
				continue
			}

			if strings.HasPrefix(line, "data:") {
				payload := line[5:]
				if strings.HasPrefix(payload, " ") {
					payload = payload[1:]
				}
				dataBuffer.WriteString(payload)
				dataBuffer.WriteByte('\n')
			}
		}

		// surface abnormal terminations (read error, line over the buffer limit);
		// skip deliberate cancellations, which also fail the body read
		if err := scanner.Err(); err != nil && ctx.Err() == nil {
			b.client.logDebugf("! sse: stream terminated: %v", err)
		}

		// Flush any remaining data
		if dataBuffer.Len() > 0 {
			emit(dataBuffer.String())
		}
	}()

	return ch, nil
}
