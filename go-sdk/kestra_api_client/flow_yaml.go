package kestra_api_client

import (
	"bytes"
	"encoding/json"
	"fmt"
	"reflect"
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
// deleted, draft, tenantId, source, updated) are stripped, and null-valued map
// keys are dropped at every depth (matching the typed path's omitempty).
//
// Key order: Go cannot preserve the caller's key order here. A map input is
// emitted by encoding/json in sorted order, and the generated models' own
// MarshalJSON also goes through a map (ToMap), so a typed *Flow comes out
// sorted too. The serialized source is what the server stores and the UI
// shows, so keys are reordered canonically after marshalling: at the flow
// root, id, namespace, description, labels, inputs, variables, tasks, errors,
// finally, afterExecution, triggers come first; in any nested mapping that has
// both `id` and `type` (tasks, triggers, inputs at any depth), id and type come
// first. All other keys keep their (alphabetical) order after those. The YAML
// is emitted with 2-space indentation, the Kestra convention.
func flowToYAML(flow interface{}) (string, error) {
	if flow == nil {
		return "", fmt.Errorf("flow must not be nil")
	}
	// A typed but nil pointer (e.g. (*Flow)(nil)) marshals to JSON "null"; reject
	// it so a nil object is never POSTed as flow source.
	if rv := reflect.ValueOf(flow); rv.Kind() == reflect.Ptr && rv.IsNil() {
		return "", fmt.Errorf("flow must not be nil")
	}

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
	reorderKeys(node, flowRootKeyOrder)
	reorderNestedKeys(node)

	var buf bytes.Buffer
	enc := yaml.NewEncoder(&buf)
	enc.SetIndent(2)
	if err := enc.Encode(node); err != nil {
		return "", fmt.Errorf("serialize flow to yaml: %w", err)
	}
	if err := enc.Close(); err != nil {
		return "", fmt.Errorf("serialize flow to yaml: %w", err)
	}
	return buf.String(), nil
}

// flowRootKeyOrder is the canonical key order of a flow source's root mapping.
var flowRootKeyOrder = []string{
	"id", "namespace", "description", "labels", "inputs", "variables",
	"tasks", "errors", "finally", "afterExecution", "triggers",
}

// pluginKeyOrder is the canonical leading key order of any nested mapping that
// carries both `id` and `type` (tasks, triggers, inputs at any depth).
var pluginKeyOrder = []string{"id", "type"}

// reorderKeys moves the given keys (when present) to the front of a mapping
// node, in the given order; the remaining keys keep their existing order.
func reorderKeys(m *yaml.Node, order []string) {
	if m == nil || m.Kind != yaml.MappingNode {
		return
	}
	front := make([]*yaml.Node, 0, len(m.Content))
	used := make(map[int]bool, len(order))
	for _, key := range order {
		for i := 0; i+1 < len(m.Content); i += 2 {
			if !used[i] && m.Content[i].Value == key {
				front = append(front, m.Content[i], m.Content[i+1])
				used[i] = true
				break
			}
		}
	}
	for i := 0; i+1 < len(m.Content); i += 2 {
		if !used[i] {
			front = append(front, m.Content[i], m.Content[i+1])
		}
	}
	m.Content = front
}

// reorderNestedKeys walks every node below the root and puts `id`, `type`
// first in each mapping that has both keys.
func reorderNestedKeys(n *yaml.Node) {
	if n == nil {
		return
	}
	switch n.Kind {
	case yaml.MappingNode:
		for i := 1; i < len(n.Content); i += 2 {
			child := n.Content[i]
			if child.Kind == yaml.MappingNode && hasKeys(child, pluginKeyOrder...) {
				reorderKeys(child, pluginKeyOrder)
			}
			reorderNestedKeys(child)
		}
	case yaml.SequenceNode:
		for _, child := range n.Content {
			if child.Kind == yaml.MappingNode && hasKeys(child, pluginKeyOrder...) {
				reorderKeys(child, pluginKeyOrder)
			}
			reorderNestedKeys(child)
		}
	}
}

// hasKeys reports whether a mapping node contains every given key.
func hasKeys(m *yaml.Node, keys ...string) bool {
	for _, key := range keys {
		found := false
		for i := 0; i+1 < len(m.Content); i += 2 {
			if m.Content[i].Value == key {
				found = true
				break
			}
		}
		if !found {
			return false
		}
	}
	return true
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
				// Drop keys whose value is null at every depth, so the map/dict
				// path matches the typed *Flow path (omitempty) and JS/Java.
				if valNode.Kind == yaml.ScalarNode && valNode.Tag == "!!null" {
					continue
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
		// A value above math.MaxInt64 is still an integer in the uint64 range;
		// keep it an int rather than losing precision as a float.
		if _, err := strconv.ParseUint(s, 10, 64); err == nil {
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
