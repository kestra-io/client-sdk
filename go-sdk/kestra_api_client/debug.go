package kestra_api_client

import (
	"fmt"
	"io"
	"net/http"
	"os"
	"sort"
	"strings"
)

// redactedValue replaces the value of a sensitive header in debug output.
const redactedValue = "REDACTED"

// sensitiveHeaders are header names (lower-cased) whose values are masked in
// debug output so credentials never leak into logs.
var sensitiveHeaders = map[string]bool{
	"authorization":       true,
	"proxy-authorization": true,
	"cookie":              true,
	"set-cookie":          true,
}

// logWriter returns the destination for debug output, defaulting to os.Stderr
// when no logger was configured via WithLogger.
func (c *KestraClient) logWriter() io.Writer {
	if c.logger != nil {
		return c.logger
	}
	return os.Stderr
}

func (c *KestraClient) logRequest(req *http.Request) {
	if !c.debug {
		return
	}
	w := c.logWriter()
	fmt.Fprintf(w, "> %s %s\n", req.Method, req.URL.String())
	writeHeaders(w, ">", req.Header)
}

// logDebugf writes a formatted diagnostic line when debug logging is enabled.
func (c *KestraClient) logDebugf(format string, args ...any) {
	if !c.debug {
		return
	}
	fmt.Fprintf(c.logWriter(), format+"\n", args...)
}

func (c *KestraClient) logResponse(resp *http.Response) {
	if !c.debug {
		return
	}
	w := c.logWriter()
	fmt.Fprintf(w, "< %s\n", resp.Status)
	writeHeaders(w, "<", resp.Header)
}

// writeHeaders prints headers in sorted order (for deterministic output),
// redacting the values of sensitive headers.
func writeHeaders(w io.Writer, prefix string, h http.Header) {
	keys := make([]string, 0, len(h))
	for k := range h {
		keys = append(keys, k)
	}
	sort.Strings(keys)
	for _, k := range keys {
		value := strings.Join(h[k], ", ")
		if sensitiveHeaders[strings.ToLower(k)] {
			value = redactedValue
		}
		fmt.Fprintf(w, "%s %s: %s\n", prefix, k, value)
	}
}
