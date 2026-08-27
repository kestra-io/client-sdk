/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyTarget type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyTarget{}

// PolicyTarget struct for PolicyTarget
type PolicyTarget struct {
	Tenants              []string `json:"tenants,omitempty"`
	Namespaces           []string `json:"namespaces,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyTarget PolicyTarget

// NewPolicyTarget instantiates a new PolicyTarget object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyTarget() *PolicyTarget {
	this := PolicyTarget{}

	return &this
}

// NewPolicyTargetWithDefaults instantiates a new PolicyTarget object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyTargetWithDefaults() *PolicyTarget {
	this := PolicyTarget{}
	return &this
}

// GetTenants returns the Tenants field value if set, zero value otherwise.
func (o *PolicyTarget) GetTenants() []string {
	if o == nil || IsNil(o.Tenants) {
		var ret []string
		return ret
	}
	return o.Tenants
}

// GetTenantsOk returns a tuple with the Tenants field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyTarget) GetTenantsOk() (*[]string, bool) {
	if o == nil || IsNil(o.Tenants) {
		return nil, false
	}
	return &o.Tenants, true
}

// HasTenants returns a boolean if a field has been set.
func (o *PolicyTarget) HasTenants() bool {
	if o != nil && !IsNil(o.Tenants) {
		return true
	}

	return false
}

// SetTenants gets a reference to the given []string and assigns it to the Tenants field.
func (o *PolicyTarget) SetTenants(v []string) {
	o.Tenants = v
}

// GetNamespaces returns the Namespaces field value if set, zero value otherwise.
func (o *PolicyTarget) GetNamespaces() []string {
	if o == nil || IsNil(o.Namespaces) {
		var ret []string
		return ret
	}
	return o.Namespaces
}

// GetNamespacesOk returns a tuple with the Namespaces field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyTarget) GetNamespacesOk() (*[]string, bool) {
	if o == nil || IsNil(o.Namespaces) {
		return nil, false
	}
	return &o.Namespaces, true
}

// HasNamespaces returns a boolean if a field has been set.
func (o *PolicyTarget) HasNamespaces() bool {
	if o != nil && !IsNil(o.Namespaces) {
		return true
	}

	return false
}

// SetNamespaces gets a reference to the given []string and assigns it to the Namespaces field.
func (o *PolicyTarget) SetNamespaces(v []string) {
	o.Namespaces = v
}

func (o PolicyTarget) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyTarget) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Tenants) {
		toSerialize["tenants"] = o.Tenants
	}
	if !IsNil(o.Namespaces) {
		toSerialize["namespaces"] = o.Namespaces
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyTarget) UnmarshalJSON(data []byte) (err error) {
	varPolicyTarget := _PolicyTarget{}

	err = json.Unmarshal(data, &varPolicyTarget)

	if err != nil {
		return err
	}

	*o = PolicyTarget(varPolicyTarget)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "tenants")
		delete(additionalProperties, "namespaces")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyTarget struct {
	value *PolicyTarget
	isSet bool
}

func (v NullablePolicyTarget) Get() *PolicyTarget {
	return v.value
}

func (v *NullablePolicyTarget) Set(val *PolicyTarget) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyTarget) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyTarget) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyTarget(val *PolicyTarget) *NullablePolicyTarget {
	return &NullablePolicyTarget{value: val, isSet: true}
}

func (v NullablePolicyTarget) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyTarget) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
