/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
	"fmt"
	"time"
)

// checks if the KVEntry type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &KVEntry{}

// KVEntry struct for KVEntry
type KVEntry struct {
	Key                  string    `json:"key"`
	CreationDate         time.Time `json:"creationDate"`
	UpdateDate           time.Time `json:"updateDate"`
	ExpirationDate       time.Time `json:"expirationDate"`
	AdditionalProperties map[string]interface{}
}

type _KVEntry KVEntry

// NewKVEntry instantiates a new KVEntry object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewKVEntry(key string, creationDate time.Time, updateDate time.Time, expirationDate time.Time) *KVEntry {
	this := KVEntry{}
	this.Key = key
	this.CreationDate = creationDate
	this.UpdateDate = updateDate
	this.ExpirationDate = expirationDate
	return &this
}

// NewKVEntryWithDefaults instantiates a new KVEntry object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewKVEntryWithDefaults() *KVEntry {
	this := KVEntry{}
	return &this
}

// GetKey returns the Key field value
func (o *KVEntry) GetKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Key
}

// GetKeyOk returns a tuple with the Key field value
// and a boolean to check if the value has been set.
func (o *KVEntry) GetKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Key, true
}

// SetKey sets field value
func (o *KVEntry) SetKey(v string) {
	o.Key = v
}

// GetCreationDate returns the CreationDate field value
func (o *KVEntry) GetCreationDate() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.CreationDate
}

// GetCreationDateOk returns a tuple with the CreationDate field value
// and a boolean to check if the value has been set.
func (o *KVEntry) GetCreationDateOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreationDate, true
}

// SetCreationDate sets field value
func (o *KVEntry) SetCreationDate(v time.Time) {
	o.CreationDate = v
}

// GetUpdateDate returns the UpdateDate field value
func (o *KVEntry) GetUpdateDate() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.UpdateDate
}

// GetUpdateDateOk returns a tuple with the UpdateDate field value
// and a boolean to check if the value has been set.
func (o *KVEntry) GetUpdateDateOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdateDate, true
}

// SetUpdateDate sets field value
func (o *KVEntry) SetUpdateDate(v time.Time) {
	o.UpdateDate = v
}

// GetExpirationDate returns the ExpirationDate field value
func (o *KVEntry) GetExpirationDate() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.ExpirationDate
}

// GetExpirationDateOk returns a tuple with the ExpirationDate field value
// and a boolean to check if the value has been set.
func (o *KVEntry) GetExpirationDateOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ExpirationDate, true
}

// SetExpirationDate sets field value
func (o *KVEntry) SetExpirationDate(v time.Time) {
	o.ExpirationDate = v
}

func (o KVEntry) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o KVEntry) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["key"] = o.Key
	toSerialize["creationDate"] = o.CreationDate
	toSerialize["updateDate"] = o.UpdateDate
	toSerialize["expirationDate"] = o.ExpirationDate

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *KVEntry) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"key",
		"creationDate",
		"updateDate",
		"expirationDate",
	}

	allProperties := make(map[string]interface{})

	err = json.Unmarshal(data, &allProperties)

	if err != nil {
		return err
	}

	for _, requiredProperty := range requiredProperties {
		if _, exists := allProperties[requiredProperty]; !exists {
			return fmt.Errorf("no value given for required property %v", requiredProperty)
		}
	}

	varKVEntry := _KVEntry{}

	err = json.Unmarshal(data, &varKVEntry)

	if err != nil {
		return err
	}

	*o = KVEntry(varKVEntry)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "key")
		delete(additionalProperties, "creationDate")
		delete(additionalProperties, "updateDate")
		delete(additionalProperties, "expirationDate")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableKVEntry struct {
	value *KVEntry
	isSet bool
}

func (v NullableKVEntry) Get() *KVEntry {
	return v.value
}

func (v *NullableKVEntry) Set(val *KVEntry) {
	v.value = val
	v.isSet = true
}

func (v NullableKVEntry) IsSet() bool {
	return v.isSet
}

func (v *NullableKVEntry) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableKVEntry(val *KVEntry) *NullableKVEntry {
	return &NullableKVEntry{value: val, isSet: true}
}

func (v NullableKVEntry) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableKVEntry) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
