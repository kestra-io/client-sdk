/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"bytes"
	"encoding/json"
	"strings"
)

// checks if the WorkerSelector type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &WorkerSelector{}

// WorkerSelector Routing requirements for a Worker Queue.
//
// On a Flow, Task or Trigger, Kestra 2.0.11+ types tags as a property: the server returns it as a
// string, either the JSON text of a literal list (["gpu"]) or a Pebble expression. Kestra
// 2.0.0-2.0.10, and namespace / tenant defaults, use a plain list. To work with every 2.0.x server,
// a literal list is always read into Tags and any other string into TagsExpression. On write,
// TagsExpression is sent as the tags string when set (Kestra 2.0.11+ only), otherwise Tags is sent
// as a list. SetTags and SetTagsExpression clear the other field.
type WorkerSelector struct {
	// Required tags used to route to a matching Worker Queue. Each tag is an RFC 1123 label: lowercase alphanumerics and hyphens, must start and end with alphanumeric, max 64 chars per tag, max 20 tags.
	Tags []string `json:"tags,omitempty"`
	// Pebble expression rendering to the tags (Flow, Task and Trigger only, Kestra 2.0.11+), e.g. {{ inputs.workers }}. Sent as the tags string and takes precedence over Tags when set.
	TagsExpression *string `json:"-"`
	// How selector tags are matched against a Worker Queue's tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null.
	Match *WorkerSelectorMatch `json:"match,omitempty"`
	// Strategy when no worker is available. Defaults to FAIL when null.
	Fallback *WorkerQueueFallback `json:"fallback,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _WorkerSelector WorkerSelector

// NewWorkerSelector instantiates a new WorkerSelector object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewWorkerSelector() *WorkerSelector {
	this := WorkerSelector{}
	return &this
}

// NewWorkerSelectorWithDefaults instantiates a new WorkerSelector object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewWorkerSelectorWithDefaults() *WorkerSelector {
	this := WorkerSelector{}
	return &this
}

// GetTags returns the Tags field value if set, zero value otherwise.
func (o *WorkerSelector) GetTags() []string {
	if o == nil || IsNil(o.Tags) {
		var ret []string
		return ret
	}
	return o.Tags
}

// GetTagsOk returns a tuple with the Tags field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *WorkerSelector) GetTagsOk() ([]string, bool) {
	if o == nil || IsNil(o.Tags) {
		return nil, false
	}
	return o.Tags, true
}

// HasTags returns a boolean if a field has been set.
func (o *WorkerSelector) HasTags() bool {
	if o != nil && !IsNil(o.Tags) {
		return true
	}

	return false
}

// SetTags gets a reference to the given []string and assigns it to the Tags field.
func (o *WorkerSelector) SetTags(v []string) {
	o.Tags = v
	o.TagsExpression = nil
}

// GetTagsExpression returns the TagsExpression field value if set, zero value otherwise.
func (o *WorkerSelector) GetTagsExpression() string {
	if o == nil || IsNil(o.TagsExpression) {
		var ret string
		return ret
	}
	return *o.TagsExpression
}

// GetTagsExpressionOk returns a tuple with the TagsExpression field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *WorkerSelector) GetTagsExpressionOk() (*string, bool) {
	if o == nil || IsNil(o.TagsExpression) {
		return nil, false
	}
	return o.TagsExpression, true
}

// HasTagsExpression returns a boolean if a field has been set.
func (o *WorkerSelector) HasTagsExpression() bool {
	if o != nil && !IsNil(o.TagsExpression) {
		return true
	}

	return false
}

// SetTagsExpression gets a reference to the given string and assigns it to the TagsExpression field, clearing Tags.
func (o *WorkerSelector) SetTagsExpression(v string) {
	o.TagsExpression = &v
	o.Tags = nil
}

// GetMatch returns the Match field value if set, zero value otherwise.
func (o *WorkerSelector) GetMatch() WorkerSelectorMatch {
	if o == nil || IsNil(o.Match) {
		var ret WorkerSelectorMatch
		return ret
	}
	return *o.Match
}

// GetMatchOk returns a tuple with the Match field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *WorkerSelector) GetMatchOk() (*WorkerSelectorMatch, bool) {
	if o == nil || IsNil(o.Match) {
		return nil, false
	}
	return o.Match, true
}

// HasMatch returns a boolean if a field has been set.
func (o *WorkerSelector) HasMatch() bool {
	if o != nil && !IsNil(o.Match) {
		return true
	}

	return false
}

// SetMatch gets a reference to the given WorkerSelectorMatch and assigns it to the Match field.
func (o *WorkerSelector) SetMatch(v WorkerSelectorMatch) {
	o.Match = &v
}

// GetFallback returns the Fallback field value if set, zero value otherwise.
func (o *WorkerSelector) GetFallback() WorkerQueueFallback {
	if o == nil || IsNil(o.Fallback) {
		var ret WorkerQueueFallback
		return ret
	}
	return *o.Fallback
}

// GetFallbackOk returns a tuple with the Fallback field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *WorkerSelector) GetFallbackOk() (*WorkerQueueFallback, bool) {
	if o == nil || IsNil(o.Fallback) {
		return nil, false
	}
	return o.Fallback, true
}

// HasFallback returns a boolean if a field has been set.
func (o *WorkerSelector) HasFallback() bool {
	if o != nil && !IsNil(o.Fallback) {
		return true
	}

	return false
}

// SetFallback gets a reference to the given WorkerQueueFallback and assigns it to the Fallback field.
func (o *WorkerSelector) SetFallback(v WorkerQueueFallback) {
	o.Fallback = &v
}

func (o WorkerSelector) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o WorkerSelector) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.TagsExpression) {
		toSerialize["tags"] = *o.TagsExpression
	} else if !IsNil(o.Tags) {
		toSerialize["tags"] = o.Tags
	}
	if !IsNil(o.Match) {
		toSerialize["match"] = o.Match
	}
	if !IsNil(o.Fallback) {
		toSerialize["fallback"] = o.Fallback
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *WorkerSelector) UnmarshalJSON(data []byte) (err error) {
	// tags is decoded separately: it is an array before Kestra 2.0.11 and a string after.
	varWorkerSelector := struct {
		Tags     json.RawMessage      `json:"tags,omitempty"`
		Match    *WorkerSelectorMatch `json:"match,omitempty"`
		Fallback *WorkerQueueFallback `json:"fallback,omitempty"`
	}{}

	err = json.Unmarshal(data, &varWorkerSelector)

	if err != nil {
		return err
	}

	tags, tagsExpression, err := decodeWorkerSelectorTags(varWorkerSelector.Tags)
	if err != nil {
		return err
	}
	*o = WorkerSelector{
		Tags:           tags,
		TagsExpression: tagsExpression,
		Match:          varWorkerSelector.Match,
		Fallback:       varWorkerSelector.Fallback,
	}

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "tags")
		delete(additionalProperties, "match")
		delete(additionalProperties, "fallback")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

// decodeWorkerSelectorTags splits a tags JSON value into (tags, tagsExpression). An array (Kestra
// before 2.0.11, namespace / tenant defaults) is read as the list. A string (Kestra 2.0.11+ flows,
// tasks and triggers) holding the JSON text of a list of strings is read as that list; any other
// string is an expression.
func decodeWorkerSelectorTags(raw json.RawMessage) ([]string, *string, error) {
	trimmed := bytes.TrimSpace(raw)
	if len(trimmed) == 0 || bytes.Equal(trimmed, []byte("null")) {
		return nil, nil, nil
	}
	if trimmed[0] != '"' {
		var tags []string
		if err := json.Unmarshal(trimmed, &tags); err != nil {
			return nil, nil, err
		}
		return tags, nil, nil
	}
	var text string
	if err := json.Unmarshal(trimmed, &text); err != nil {
		return nil, nil, err
	}
	if strings.HasPrefix(strings.TrimSpace(text), "[") {
		var tags []string
		if err := json.Unmarshal([]byte(text), &tags); err == nil && tags != nil {
			return tags, nil, nil
		}
	}
	return nil, &text, nil
}

type NullableWorkerSelector struct {
	value *WorkerSelector
	isSet bool
}

func (v NullableWorkerSelector) Get() *WorkerSelector {
	return v.value
}

func (v *NullableWorkerSelector) Set(val *WorkerSelector) {
	v.value = val
	v.isSet = true
}

func (v NullableWorkerSelector) IsSet() bool {
	return v.isSet
}

func (v *NullableWorkerSelector) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableWorkerSelector(val *WorkerSelector) *NullableWorkerSelector {
	return &NullableWorkerSelector{value: val, isSet: true}
}

func (v NullableWorkerSelector) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableWorkerSelector) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
