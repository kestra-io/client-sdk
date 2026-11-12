/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"bytes"
	"encoding/json"
)

// checks if the FlowWorkerSelector type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &FlowWorkerSelector{}

// FlowWorkerSelector holds the routing requirements of a Flow, Task or Trigger. Unlike
// WorkerSelector (namespace and tenant defaults), Tags is a Kestra property: a JSON array
// literal such as ["gpu"] or a Pebble expression rendered when the job is routed. The
// server returns it as a string in both cases.
type FlowWorkerSelector struct {
	// Required tags used to route to a matching Worker Queue, as a JSON array literal (e.g. ["gpu"]) or a Pebble expression rendering to the tags. Each tag is an RFC 1123 label, max 63 chars per tag, max 20 tags; a tag rendering to an empty value is ignored.
	Tags *string `json:"tags,omitempty"`
	// How selector tags are matched against a Worker Queue's tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null.
	Match *WorkerSelectorMatch `json:"match,omitempty"`
	// Strategy when no worker is available. Defaults to FAIL when null.
	Fallback             *WorkerQueueFallback `json:"fallback,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _FlowWorkerSelector FlowWorkerSelector

// NewFlowWorkerSelector instantiates a new FlowWorkerSelector object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewFlowWorkerSelector() *FlowWorkerSelector {
	this := FlowWorkerSelector{}
	return &this
}

// NewFlowWorkerSelectorWithDefaults instantiates a new FlowWorkerSelector object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewFlowWorkerSelectorWithDefaults() *FlowWorkerSelector {
	this := FlowWorkerSelector{}
	return &this
}

// GetTags returns the Tags field value if set, zero value otherwise.
func (o *FlowWorkerSelector) GetTags() string {
	if o == nil || IsNil(o.Tags) {
		var ret string
		return ret
	}
	return *o.Tags
}

// GetTagsOk returns a tuple with the Tags field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowWorkerSelector) GetTagsOk() (*string, bool) {
	if o == nil || IsNil(o.Tags) {
		return nil, false
	}
	return o.Tags, true
}

// HasTags returns a boolean if a field has been set.
func (o *FlowWorkerSelector) HasTags() bool {
	if o != nil && !IsNil(o.Tags) {
		return true
	}

	return false
}

// SetTags gets a reference to the given string and assigns it to the Tags field.
func (o *FlowWorkerSelector) SetTags(v string) {
	o.Tags = &v
}

// GetMatch returns the Match field value if set, zero value otherwise.
func (o *FlowWorkerSelector) GetMatch() WorkerSelectorMatch {
	if o == nil || IsNil(o.Match) {
		var ret WorkerSelectorMatch
		return ret
	}
	return *o.Match
}

// GetMatchOk returns a tuple with the Match field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowWorkerSelector) GetMatchOk() (*WorkerSelectorMatch, bool) {
	if o == nil || IsNil(o.Match) {
		return nil, false
	}
	return o.Match, true
}

// HasMatch returns a boolean if a field has been set.
func (o *FlowWorkerSelector) HasMatch() bool {
	if o != nil && !IsNil(o.Match) {
		return true
	}

	return false
}

// SetMatch gets a reference to the given WorkerSelectorMatch and assigns it to the Match field.
func (o *FlowWorkerSelector) SetMatch(v WorkerSelectorMatch) {
	o.Match = &v
}

// GetFallback returns the Fallback field value if set, zero value otherwise.
func (o *FlowWorkerSelector) GetFallback() WorkerQueueFallback {
	if o == nil || IsNil(o.Fallback) {
		var ret WorkerQueueFallback
		return ret
	}
	return *o.Fallback
}

// GetFallbackOk returns a tuple with the Fallback field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowWorkerSelector) GetFallbackOk() (*WorkerQueueFallback, bool) {
	if o == nil || IsNil(o.Fallback) {
		return nil, false
	}
	return o.Fallback, true
}

// HasFallback returns a boolean if a field has been set.
func (o *FlowWorkerSelector) HasFallback() bool {
	if o != nil && !IsNil(o.Fallback) {
		return true
	}

	return false
}

// SetFallback gets a reference to the given WorkerQueueFallback and assigns it to the Fallback field.
func (o *FlowWorkerSelector) SetFallback(v WorkerQueueFallback) {
	o.Fallback = &v
}

func (o FlowWorkerSelector) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o FlowWorkerSelector) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Tags) {
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

func (o *FlowWorkerSelector) UnmarshalJSON(data []byte) (err error) {
	// The spec types tags as object-or-string: keep a string as is, and turn an array (or
	// any other JSON value) into its compact JSON text so both shapes read into Tags.
	varFlowWorkerSelector := struct {
		_FlowWorkerSelector
		Tags json.RawMessage `json:"tags,omitempty"`
	}{}

	err = json.Unmarshal(data, &varFlowWorkerSelector)

	if err != nil {
		return err
	}

	*o = FlowWorkerSelector(varFlowWorkerSelector._FlowWorkerSelector)
	o.Tags = nil
	if raw := varFlowWorkerSelector.Tags; len(raw) > 0 && string(raw) != "null" {
		var tags string
		if err = json.Unmarshal(raw, &tags); err != nil {
			var compact bytes.Buffer
			if err = json.Compact(&compact, raw); err != nil {
				return err
			}
			tags = compact.String()
		}
		o.Tags = &tags
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

type NullableFlowWorkerSelector struct {
	value *FlowWorkerSelector
	isSet bool
}

func (v NullableFlowWorkerSelector) Get() *FlowWorkerSelector {
	return v.value
}

func (v *NullableFlowWorkerSelector) Set(val *FlowWorkerSelector) {
	v.value = val
	v.isSet = true
}

func (v NullableFlowWorkerSelector) IsSet() bool {
	return v.isSet
}

func (v *NullableFlowWorkerSelector) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFlowWorkerSelector(val *FlowWorkerSelector) *NullableFlowWorkerSelector {
	return &NullableFlowWorkerSelector{value: val, isSet: true}
}

func (v NullableFlowWorkerSelector) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFlowWorkerSelector) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
