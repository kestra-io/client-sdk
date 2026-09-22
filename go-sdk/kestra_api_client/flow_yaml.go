package kestra_api_client

import (
	"bytes"
	"encoding/json"
	"fmt"
	"strconv"
	"strings"

	"gopkg.in/yaml.v3"
)

// serverManagedFlowFields are read-only / server-managed fields that must never
// appear in a flow *source* body. The serialized YAML has to mirror what a user
// writes as flow source; `draft` in particular is a query parameter, not a body
// field.
var serverManagedFlowFields = map[string]bool{
	"deleted":  true,
	"revision": true,
	"draft":    true,
	"tenantId": true,
	"source":   true,
	"updated":  true,
}

// flowToYAML serializes a flow to a YAML source string.
//
// The flow-write endpoints only consume application/x-yaml (they do not accept
// JSON), so a native object (a *Flow / Flow value, or a map) is serialized to a
// YAML source string client-side and posted to the existing YAML endpoints.
//
// The value is first marshalled through the model's own JSON marshaller (which
// omits nil fields and re-inserts additional, plugin-specific task properties at
// every depth), then re-emitted as YAML via an explicit yaml.Node so numbers
// keep their integer/float type (no float64 coercion, so large int64 values do
// not lose precision) and multi-line strings become literal block scalars.
// yaml.v3 quotes Kestra expressions such as "{{ inputs.foo }}" and keeps
// non-ASCII characters verbatim. Server-managed top-level fields (revision,
// deleted, draft, tenantId, source, updated) are stripped.
//
// Key order: a typed *Flow marshals its struct fields in declaration order and
// that order is preserved. A map input cannot preserve insertion order because
// Go's encoding/json emits map keys in sorted order; map inputs are therefore
// emitted with alphabetically ordered keys.
func flowToYAML(flow interface{}) (string, error) {
	jsonBytes, err := json.Marshal(flow)
	if err != nil {
		return "", fmt.Errorf("serialize flow to json: %w", err)
	}

	dec := json.NewDecoder(bytes.NewReader(jsonBytes))
	dec.UseNumber()

	tok, err := dec.Token()
	if err != nil {
		return "", fmt.Errorf("normalize flow: %w", err)
	}
	node, err := jsonTokenToYAMLNode(dec, tok)
	if err != nil {
		return "", fmt.Errorf("normalize flow: %w", err)
	}

	stripServerManagedFields(node)

	out, err := yaml.Marshal(node)
	if err != nil {
		return "", fmt.Errorf("serialize flow to yaml: %w", err)
	}
	return string(out), nil
}

// jsonTokenToYAMLNode builds a *yaml.Node from a JSON token stream, preserving
// object key order and mapping json.Number to an integer or float scalar so the
// number keeps its type (and int64 precision) rather than being coerced.
func jsonTokenToYAMLNode(dec *json.Decoder, tok json.Token) (*yaml.Node, error) {
	switch t := tok.(type) {
	case json.Delim:
		switch t {
		case '{':
			node := &yaml.Node{Kind: yaml.MappingNode, Tag: "!!map"}
			for dec.More() {
				keyTok, err := dec.Token()
				if err != nil {
					return nil, err
				}
				key, ok := keyTok.(string)
				if !ok {
					return nil, fmt.Errorf("unexpected non-string object key %v", keyTok)
				}
				keyNode := &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!str", Value: key}
				valTok, err := dec.Token()
				if err != nil {
					return nil, err
				}
				valNode, err := jsonTokenToYAMLNode(dec, valTok)
				if err != nil {
					return nil, err
				}
				node.Content = append(node.Content, keyNode, valNode)
			}
			if _, err := dec.Token(); err != nil { // consume '}'
				return nil, err
			}
			return node, nil
		case '[':
			node := &yaml.Node{Kind: yaml.SequenceNode, Tag: "!!seq"}
			for dec.More() {
				valTok, err := dec.Token()
				if err != nil {
					return nil, err
				}
				valNode, err := jsonTokenToYAMLNode(dec, valTok)
				if err != nil {
					return nil, err
				}
				node.Content = append(node.Content, valNode)
			}
			if _, err := dec.Token(); err != nil { // consume ']'
				return nil, err
			}
			return node, nil
		default:
			return nil, fmt.Errorf("unexpected delimiter %q", t)
		}
	case string:
		n := &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!str", Value: t}
		if strings.Contains(t, "\n") {
			n.Style = yaml.LiteralStyle
		}
		return n, nil
	case json.Number:
		s := t.String()
		if _, err := strconv.ParseInt(s, 10, 64); err == nil {
			return &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!int", Value: s}, nil
		}
		return &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!float", Value: s}, nil
	case bool:
		return &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!bool", Value: strconv.FormatBool(t)}, nil
	case nil:
		return &yaml.Node{Kind: yaml.ScalarNode, Tag: "!!null", Value: "null"}, nil
	default:
		return nil, fmt.Errorf("unexpected token %v", tok)
	}
}

// stripServerManagedFields removes the read-only top-level flow fields from a
// mapping node (only the flow root; nested task properties are untouched).
func stripServerManagedFields(root *yaml.Node) {
	if root == nil || root.Kind != yaml.MappingNode {
		return
	}
	filtered := make([]*yaml.Node, 0, len(root.Content))
	for i := 0; i+1 < len(root.Content); i += 2 {
		if serverManagedFlowFields[root.Content[i].Value] {
			continue
		}
		filtered = append(filtered, root.Content[i], root.Content[i+1])
	}
	root.Content = filtered
}
