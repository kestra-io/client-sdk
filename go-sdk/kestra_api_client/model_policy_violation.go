/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyViolation type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyViolation{}

// PolicyViolation struct for PolicyViolation
type PolicyViolation struct {
	Severity             *RuleAction `json:"severity,omitempty"`
	RuleType             *string     `json:"ruleType,omitempty"`
	Target               *string     `json:"target,omitempty"`
	Message              *string     `json:"message,omitempty"`
	PolicyId             *string     `json:"policyId,omitempty"`
	Scope                *Scope      `json:"scope,omitempty"`
	TaskId               *string     `json:"taskId,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyViolation PolicyViolation

// NewPolicyViolation instantiates a new PolicyViolation object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyViolation() *PolicyViolation {
	this := PolicyViolation{}

	return &this
}

// NewPolicyViolationWithDefaults instantiates a new PolicyViolation object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyViolationWithDefaults() *PolicyViolation {
	this := PolicyViolation{}
	return &this
}

// GetSeverity returns the Severity field value if set, zero value otherwise.
func (o *PolicyViolation) GetSeverity() RuleAction {
	if o == nil || IsNil(o.Severity) {
		var ret RuleAction
		return ret
	}
	return *o.Severity
}

// GetSeverityOk returns a tuple with the Severity field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetSeverityOk() (*RuleAction, bool) {
	if o == nil || IsNil(o.Severity) {
		return nil, false
	}
	return o.Severity, true
}

// HasSeverity returns a boolean if a field has been set.
func (o *PolicyViolation) HasSeverity() bool {
	if o != nil && !IsNil(o.Severity) {
		return true
	}

	return false
}

// SetSeverity gets a reference to the given RuleAction and assigns it to the Severity field.
func (o *PolicyViolation) SetSeverity(v RuleAction) {
	o.Severity = &v
}

// GetRuleType returns the RuleType field value if set, zero value otherwise.
func (o *PolicyViolation) GetRuleType() string {
	if o == nil || IsNil(o.RuleType) {
		var ret string
		return ret
	}
	return *o.RuleType
}

// GetRuleTypeOk returns a tuple with the RuleType field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetRuleTypeOk() (*string, bool) {
	if o == nil || IsNil(o.RuleType) {
		return nil, false
	}
	return o.RuleType, true
}

// HasRuleType returns a boolean if a field has been set.
func (o *PolicyViolation) HasRuleType() bool {
	if o != nil && !IsNil(o.RuleType) {
		return true
	}

	return false
}

// SetRuleType gets a reference to the given string and assigns it to the RuleType field.
func (o *PolicyViolation) SetRuleType(v string) {
	o.RuleType = &v
}

// GetTarget returns the Target field value if set, zero value otherwise.
func (o *PolicyViolation) GetTarget() string {
	if o == nil || IsNil(o.Target) {
		var ret string
		return ret
	}
	return *o.Target
}

// GetTargetOk returns a tuple with the Target field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetTargetOk() (*string, bool) {
	if o == nil || IsNil(o.Target) {
		return nil, false
	}
	return o.Target, true
}

// HasTarget returns a boolean if a field has been set.
func (o *PolicyViolation) HasTarget() bool {
	if o != nil && !IsNil(o.Target) {
		return true
	}

	return false
}

// SetTarget gets a reference to the given string and assigns it to the Target field.
func (o *PolicyViolation) SetTarget(v string) {
	o.Target = &v
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *PolicyViolation) GetMessage() string {
	if o == nil || IsNil(o.Message) {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetMessageOk() (*string, bool) {
	if o == nil || IsNil(o.Message) {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *PolicyViolation) HasMessage() bool {
	if o != nil && !IsNil(o.Message) {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *PolicyViolation) SetMessage(v string) {
	o.Message = &v
}

// GetPolicyId returns the PolicyId field value if set, zero value otherwise.
func (o *PolicyViolation) GetPolicyId() string {
	if o == nil || IsNil(o.PolicyId) {
		var ret string
		return ret
	}
	return *o.PolicyId
}

// GetPolicyIdOk returns a tuple with the PolicyId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetPolicyIdOk() (*string, bool) {
	if o == nil || IsNil(o.PolicyId) {
		return nil, false
	}
	return o.PolicyId, true
}

// HasPolicyId returns a boolean if a field has been set.
func (o *PolicyViolation) HasPolicyId() bool {
	if o != nil && !IsNil(o.PolicyId) {
		return true
	}

	return false
}

// SetPolicyId gets a reference to the given string and assigns it to the PolicyId field.
func (o *PolicyViolation) SetPolicyId(v string) {
	o.PolicyId = &v
}

// GetScope returns the Scope field value if set, zero value otherwise.
func (o *PolicyViolation) GetScope() Scope {
	if o == nil || IsNil(o.Scope) {
		var ret Scope
		return ret
	}
	return *o.Scope
}

// GetScopeOk returns a tuple with the Scope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetScopeOk() (*Scope, bool) {
	if o == nil || IsNil(o.Scope) {
		return nil, false
	}
	return o.Scope, true
}

// HasScope returns a boolean if a field has been set.
func (o *PolicyViolation) HasScope() bool {
	if o != nil && !IsNil(o.Scope) {
		return true
	}

	return false
}

// SetScope gets a reference to the given Scope and assigns it to the Scope field.
func (o *PolicyViolation) SetScope(v Scope) {
	o.Scope = &v
}

// GetTaskId returns the TaskId field value if set, zero value otherwise.
func (o *PolicyViolation) GetTaskId() string {
	if o == nil || IsNil(o.TaskId) {
		var ret string
		return ret
	}
	return *o.TaskId
}

// GetTaskIdOk returns a tuple with the TaskId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyViolation) GetTaskIdOk() (*string, bool) {
	if o == nil || IsNil(o.TaskId) {
		return nil, false
	}
	return o.TaskId, true
}

// HasTaskId returns a boolean if a field has been set.
func (o *PolicyViolation) HasTaskId() bool {
	if o != nil && !IsNil(o.TaskId) {
		return true
	}

	return false
}

// SetTaskId gets a reference to the given string and assigns it to the TaskId field.
func (o *PolicyViolation) SetTaskId(v string) {
	o.TaskId = &v
}

func (o PolicyViolation) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyViolation) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Severity) {
		toSerialize["severity"] = o.Severity
	}
	if !IsNil(o.RuleType) {
		toSerialize["ruleType"] = o.RuleType
	}
	if !IsNil(o.Target) {
		toSerialize["target"] = o.Target
	}
	if !IsNil(o.Message) {
		toSerialize["message"] = o.Message
	}
	if !IsNil(o.PolicyId) {
		toSerialize["policyId"] = o.PolicyId
	}
	if !IsNil(o.Scope) {
		toSerialize["scope"] = o.Scope
	}
	if !IsNil(o.TaskId) {
		toSerialize["taskId"] = o.TaskId
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyViolation) UnmarshalJSON(data []byte) (err error) {
	varPolicyViolation := _PolicyViolation{}

	err = json.Unmarshal(data, &varPolicyViolation)

	if err != nil {
		return err
	}

	*o = PolicyViolation(varPolicyViolation)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "severity")
		delete(additionalProperties, "ruleType")
		delete(additionalProperties, "target")
		delete(additionalProperties, "message")
		delete(additionalProperties, "policyId")
		delete(additionalProperties, "scope")
		delete(additionalProperties, "taskId")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyViolation struct {
	value *PolicyViolation
	isSet bool
}

func (v NullablePolicyViolation) Get() *PolicyViolation {
	return v.value
}

func (v *NullablePolicyViolation) Set(val *PolicyViolation) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyViolation) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyViolation) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyViolation(val *PolicyViolation) *NullablePolicyViolation {
	return &NullablePolicyViolation{value: val, isSet: true}
}

func (v NullablePolicyViolation) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyViolation) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
