/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicySummary type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicySummary{}

// PolicySummary struct for PolicySummary
type PolicySummary struct {
	Id                   *string            `json:"id,omitempty"`
	DisplayName          *string            `json:"displayName,omitempty"`
	Description          *string            `json:"description,omitempty"`
	Scope                *Scope             `json:"scope,omitempty"`
	Namespace            *string            `json:"namespace,omitempty"`
	Target               *PolicyTarget      `json:"target,omitempty"`
	Enforcement          *Enforcement       `json:"enforcement,omitempty"`
	Rules                *PolicyRuleSummary `json:"rules,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicySummary PolicySummary

// NewPolicySummary instantiates a new PolicySummary object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicySummary() *PolicySummary {
	this := PolicySummary{}

	return &this
}

// NewPolicySummaryWithDefaults instantiates a new PolicySummary object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicySummaryWithDefaults() *PolicySummary {
	this := PolicySummary{}
	return &this
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *PolicySummary) GetId() string {
	if o == nil || IsNil(o.Id) {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetIdOk() (*string, bool) {
	if o == nil || IsNil(o.Id) {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *PolicySummary) HasId() bool {
	if o != nil && !IsNil(o.Id) {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *PolicySummary) SetId(v string) {
	o.Id = &v
}

// GetDisplayName returns the DisplayName field value if set, zero value otherwise.
func (o *PolicySummary) GetDisplayName() string {
	if o == nil || IsNil(o.DisplayName) {
		var ret string
		return ret
	}
	return *o.DisplayName
}

// GetDisplayNameOk returns a tuple with the DisplayName field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetDisplayNameOk() (*string, bool) {
	if o == nil || IsNil(o.DisplayName) {
		return nil, false
	}
	return o.DisplayName, true
}

// HasDisplayName returns a boolean if a field has been set.
func (o *PolicySummary) HasDisplayName() bool {
	if o != nil && !IsNil(o.DisplayName) {
		return true
	}

	return false
}

// SetDisplayName gets a reference to the given string and assigns it to the DisplayName field.
func (o *PolicySummary) SetDisplayName(v string) {
	o.DisplayName = &v
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *PolicySummary) GetDescription() string {
	if o == nil || IsNil(o.Description) {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetDescriptionOk() (*string, bool) {
	if o == nil || IsNil(o.Description) {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *PolicySummary) HasDescription() bool {
	if o != nil && !IsNil(o.Description) {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *PolicySummary) SetDescription(v string) {
	o.Description = &v
}

// GetScope returns the Scope field value if set, zero value otherwise.
func (o *PolicySummary) GetScope() Scope {
	if o == nil || IsNil(o.Scope) {
		var ret Scope
		return ret
	}
	return *o.Scope
}

// GetScopeOk returns a tuple with the Scope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetScopeOk() (*Scope, bool) {
	if o == nil || IsNil(o.Scope) {
		return nil, false
	}
	return o.Scope, true
}

// HasScope returns a boolean if a field has been set.
func (o *PolicySummary) HasScope() bool {
	if o != nil && !IsNil(o.Scope) {
		return true
	}

	return false
}

// SetScope gets a reference to the given Scope and assigns it to the Scope field.
func (o *PolicySummary) SetScope(v Scope) {
	o.Scope = &v
}

// GetNamespace returns the Namespace field value if set, zero value otherwise.
func (o *PolicySummary) GetNamespace() string {
	if o == nil || IsNil(o.Namespace) {
		var ret string
		return ret
	}
	return *o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetNamespaceOk() (*string, bool) {
	if o == nil || IsNil(o.Namespace) {
		return nil, false
	}
	return o.Namespace, true
}

// HasNamespace returns a boolean if a field has been set.
func (o *PolicySummary) HasNamespace() bool {
	if o != nil && !IsNil(o.Namespace) {
		return true
	}

	return false
}

// SetNamespace gets a reference to the given string and assigns it to the Namespace field.
func (o *PolicySummary) SetNamespace(v string) {
	o.Namespace = &v
}

// GetTarget returns the Target field value if set, zero value otherwise.
func (o *PolicySummary) GetTarget() PolicyTarget {
	if o == nil || IsNil(o.Target) {
		var ret PolicyTarget
		return ret
	}
	return *o.Target
}

// GetTargetOk returns a tuple with the Target field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetTargetOk() (*PolicyTarget, bool) {
	if o == nil || IsNil(o.Target) {
		return nil, false
	}
	return o.Target, true
}

// HasTarget returns a boolean if a field has been set.
func (o *PolicySummary) HasTarget() bool {
	if o != nil && !IsNil(o.Target) {
		return true
	}

	return false
}

// SetTarget gets a reference to the given PolicyTarget and assigns it to the Target field.
func (o *PolicySummary) SetTarget(v PolicyTarget) {
	o.Target = &v
}

// GetEnforcement returns the Enforcement field value if set, zero value otherwise.
func (o *PolicySummary) GetEnforcement() Enforcement {
	if o == nil || IsNil(o.Enforcement) {
		var ret Enforcement
		return ret
	}
	return *o.Enforcement
}

// GetEnforcementOk returns a tuple with the Enforcement field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetEnforcementOk() (*Enforcement, bool) {
	if o == nil || IsNil(o.Enforcement) {
		return nil, false
	}
	return o.Enforcement, true
}

// HasEnforcement returns a boolean if a field has been set.
func (o *PolicySummary) HasEnforcement() bool {
	if o != nil && !IsNil(o.Enforcement) {
		return true
	}

	return false
}

// SetEnforcement gets a reference to the given Enforcement and assigns it to the Enforcement field.
func (o *PolicySummary) SetEnforcement(v Enforcement) {
	o.Enforcement = &v
}

// GetRules returns the Rules field value if set, zero value otherwise.
func (o *PolicySummary) GetRules() PolicyRuleSummary {
	if o == nil || IsNil(o.Rules) {
		var ret PolicyRuleSummary
		return ret
	}
	return *o.Rules
}

// GetRulesOk returns a tuple with the Rules field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicySummary) GetRulesOk() (*PolicyRuleSummary, bool) {
	if o == nil || IsNil(o.Rules) {
		return nil, false
	}
	return o.Rules, true
}

// HasRules returns a boolean if a field has been set.
func (o *PolicySummary) HasRules() bool {
	if o != nil && !IsNil(o.Rules) {
		return true
	}

	return false
}

// SetRules gets a reference to the given PolicyRuleSummary and assigns it to the Rules field.
func (o *PolicySummary) SetRules(v PolicyRuleSummary) {
	o.Rules = &v
}

func (o PolicySummary) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicySummary) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Id) {
		toSerialize["id"] = o.Id
	}
	if !IsNil(o.DisplayName) {
		toSerialize["displayName"] = o.DisplayName
	}
	if !IsNil(o.Description) {
		toSerialize["description"] = o.Description
	}
	if !IsNil(o.Scope) {
		toSerialize["scope"] = o.Scope
	}
	if !IsNil(o.Namespace) {
		toSerialize["namespace"] = o.Namespace
	}
	if !IsNil(o.Target) {
		toSerialize["target"] = o.Target
	}
	if !IsNil(o.Enforcement) {
		toSerialize["enforcement"] = o.Enforcement
	}
	if !IsNil(o.Rules) {
		toSerialize["rules"] = o.Rules
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicySummary) UnmarshalJSON(data []byte) (err error) {
	varPolicySummary := _PolicySummary{}

	err = json.Unmarshal(data, &varPolicySummary)

	if err != nil {
		return err
	}

	*o = PolicySummary(varPolicySummary)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "displayName")
		delete(additionalProperties, "description")
		delete(additionalProperties, "scope")
		delete(additionalProperties, "namespace")
		delete(additionalProperties, "target")
		delete(additionalProperties, "enforcement")
		delete(additionalProperties, "rules")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicySummary struct {
	value *PolicySummary
	isSet bool
}

func (v NullablePolicySummary) Get() *PolicySummary {
	return v.value
}

func (v *NullablePolicySummary) Set(val *PolicySummary) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicySummary) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicySummary) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicySummary(val *PolicySummary) *NullablePolicySummary {
	return &NullablePolicySummary{value: val, isSet: true}
}

func (v NullablePolicySummary) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicySummary) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
