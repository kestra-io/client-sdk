package kestra_api_client

import (
	"strings"
	"time"
)

// LocalDateTime represents a Kestra zone-less LocalDateTime timestamp such as
// "2026-09-14T14:32:15.018993964". Go's time.Time only unmarshals RFC 3339
// (zoned) values, so fields backed by a Java LocalDateTime must use this type.
// For robustness it also accepts RFC 3339 values that carry a zone.
type LocalDateTime struct {
	time.Time
}

const localDateTimeLayout = "2006-01-02T15:04:05.999999999"

// NewLocalDateTime wraps a time.Time as a LocalDateTime.
func NewLocalDateTime(t time.Time) LocalDateTime { return LocalDateTime{Time: t} }

// MarshalJSON serializes the value without a zone, matching the server format.
func (t LocalDateTime) MarshalJSON() ([]byte, error) {
	if t.Time.IsZero() {
		return []byte("null"), nil
	}
	return []byte(`"` + t.Time.Format(localDateTimeLayout) + `"`), nil
}

// UnmarshalJSON accepts the zone-less LocalDateTime layout first, then falls
// back to RFC 3339 with a zone.
func (t *LocalDateTime) UnmarshalJSON(data []byte) error {
	s := strings.Trim(string(data), `"`)
	if s == "" || s == "null" {
		t.Time = time.Time{}
		return nil
	}
	if parsed, err := time.Parse(localDateTimeLayout, s); err == nil {
		t.Time = parsed
		return nil
	}
	parsed, err := time.Parse(time.RFC3339Nano, s)
	if err != nil {
		return err
	}
	t.Time = parsed
	return nil
}
