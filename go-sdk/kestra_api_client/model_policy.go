/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the Policy type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &Policy{}

// Policy struct for Policy
type Policy struct {
	Id                   string        `json:"id"`
	DisplayName          *string       `json:"displayName,omitempty"`
	Description          *string       `json:"description,omitempty"`
	Enforcement          Enforcement   `json:"enforcement"`
	Target               *PolicyTarget `json:"target,omitempty"`
	Rules                []Rule        `json:"rules"`
	Source               *string       `json:"source,omitempty"`
	Deleted              bool          `json:"deleted"`
	AdditionalProperties map[string]interface{}
}

type _Policy Policy

// NewPolicy instantiates a new Policy object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicy(id string, enforcement Enforcement, rules []Rule, deleted bool) *Policy {
	this := Policy{}
	this.Id = id
	this.Enforcement = enforcement
	this.Rules = rules
	this.Deleted = deleted
	return &this
}

// NewPolicyWithDefaults instantiates a new Policy object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyWithDefaults() *Policy {
	this := Policy{}
	return &this
}

// GetId returns the Id field value
func (o *Policy) GetId() string {
	if o == nil {
		var ret string
		return ret
	}
	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *Policy) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *Policy) SetId(v string) {
	o.Id = v
}

// GetDisplayName returns the DisplayName field value if set, zero value otherwise.
func (o *Policy) GetDisplayName() string {
	if o == nil || IsNil(o.DisplayName) {
		var ret string
		return ret
	}
	return *o.DisplayName
}

// GetDisplayNameOk returns a tuple with the DisplayName field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Policy) GetDisplayNameOk() (*string, bool) {
	if o == nil || IsNil(o.DisplayName) {
		return nil, false
	}
	return o.DisplayName, true
}

// HasDisplayName returns a boolean if a field has been set.
func (o *Policy) HasDisplayName() bool {
	if o != nil && !IsNil(o.DisplayName) {
		return true
	}

	return false
}

// SetDisplayName gets a reference to the given string and assigns it to the DisplayName field.
func (o *Policy) SetDisplayName(v string) {
	o.DisplayName = &v
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *Policy) GetDescription() string {
	if o == nil || IsNil(o.Description) {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Policy) GetDescriptionOk() (*string, bool) {
	if o == nil || IsNil(o.Description) {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *Policy) HasDescription() bool {
	if o != nil && !IsNil(o.Description) {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *Policy) SetDescription(v string) {
	o.Description = &v
}

// GetEnforcement returns the Enforcement field value
func (o *Policy) GetEnforcement() Enforcement {
	if o == nil {
		var ret Enforcement
		return ret
	}
	return o.Enforcement
}

// GetEnforcementOk returns a tuple with the Enforcement field value
// and a boolean to check if the value has been set.
func (o *Policy) GetEnforcementOk() (*Enforcement, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Enforcement, true
}

// SetEnforcement sets field value
func (o *Policy) SetEnforcement(v Enforcement) {
	o.Enforcement = v
}

// GetTarget returns the Target field value if set, zero value otherwise.
func (o *Policy) GetTarget() PolicyTarget {
	if o == nil || IsNil(o.Target) {
		var ret PolicyTarget
		return ret
	}
	return *o.Target
}

// GetTargetOk returns a tuple with the Target field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Policy) GetTargetOk() (*PolicyTarget, bool) {
	if o == nil || IsNil(o.Target) {
		return nil, false
	}
	return o.Target, true
}

// HasTarget returns a boolean if a field has been set.
func (o *Policy) HasTarget() bool {
	if o != nil && !IsNil(o.Target) {
		return true
	}

	return false
}

// SetTarget gets a reference to the given PolicyTarget and assigns it to the Target field.
func (o *Policy) SetTarget(v PolicyTarget) {
	o.Target = &v
}

// GetRules returns the Rules field value
func (o *Policy) GetRules() []Rule {
	if o == nil {
		var ret []Rule
		return ret
	}
	return o.Rules
}

// GetRulesOk returns a tuple with the Rules field value
// and a boolean to check if the value has been set.
func (o *Policy) GetRulesOk() (*[]Rule, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Rules, true
}

// SetRules sets field value
func (o *Policy) SetRules(v []Rule) {
	o.Rules = v
}

// GetSource returns the Source field value if set, zero value otherwise.
func (o *Policy) GetSource() string {
	if o == nil || IsNil(o.Source) {
		var ret string
		return ret
	}
	return *o.Source
}

// GetSourceOk returns a tuple with the Source field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Policy) GetSourceOk() (*string, bool) {
	if o == nil || IsNil(o.Source) {
		return nil, false
	}
	return o.Source, true
}

// HasSource returns a boolean if a field has been set.
func (o *Policy) HasSource() bool {
	if o != nil && !IsNil(o.Source) {
		return true
	}

	return false
}

// SetSource gets a reference to the given string and assigns it to the Source field.
func (o *Policy) SetSource(v string) {
	o.Source = &v
}

// GetDeleted returns the Deleted field value
func (o *Policy) GetDeleted() bool {
	if o == nil {
		var ret bool
		return ret
	}
	return o.Deleted
}

// GetDeletedOk returns a tuple with the Deleted field value
// and a boolean to check if the value has been set.
func (o *Policy) GetDeletedOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Deleted, true
}

// SetDeleted sets field value
func (o *Policy) SetDeleted(v bool) {
	o.Deleted = v
}

func (o Policy) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o Policy) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["id"] = o.Id
	if !IsNil(o.DisplayName) {
		toSerialize["displayName"] = o.DisplayName
	}
	if !IsNil(o.Description) {
		toSerialize["description"] = o.Description
	}
	toSerialize["enforcement"] = o.Enforcement
	if !IsNil(o.Target) {
		toSerialize["target"] = o.Target
	}
	toSerialize["rules"] = o.Rules
	if !IsNil(o.Source) {
		toSerialize["source"] = o.Source
	}
	toSerialize["deleted"] = o.Deleted

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *Policy) UnmarshalJSON(data []byte) (err error) {
	varPolicy := _Policy{}

	err = json.Unmarshal(data, &varPolicy)

	if err != nil {
		return err
	}

	*o = Policy(varPolicy)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "displayName")
		delete(additionalProperties, "description")
		delete(additionalProperties, "enforcement")
		delete(additionalProperties, "target")
		delete(additionalProperties, "rules")
		delete(additionalProperties, "source")
		delete(additionalProperties, "deleted")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicy struct {
	value *Policy
	isSet bool
}

func (v NullablePolicy) Get() *Policy {
	return v.value
}

func (v *NullablePolicy) Set(val *Policy) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicy) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicy) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicy(val *Policy) *NullablePolicy {
	return &NullablePolicy{value: val, isSet: true}
}

func (v NullablePolicy) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicy) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
