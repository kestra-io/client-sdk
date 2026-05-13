package kestra_api_client

import "fmt"

type ApiError struct {
	StatusCode int
	Body       []byte
	Message    string
}

func (e *ApiError) Error() string {
	if e.Message != "" {
		return fmt.Sprintf("API error %d: %s", e.StatusCode, e.Message)
	}
	return fmt.Sprintf("API error %d: %s", e.StatusCode, string(e.Body))
}
