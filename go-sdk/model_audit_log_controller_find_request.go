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
)

// checks if the AuditLogControllerFindRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &AuditLogControllerFindRequest{}

// AuditLogControllerFindRequest struct for AuditLogControllerFindRequest
type AuditLogControllerFindRequest struct {
	Permission           Permission             `json:"permission"`
	Type                 NullableCrudEventType  `json:"type"`
	Detail               map[string]interface{} `json:"detail"`
	AdditionalProperties map[string]interface{}
}

type _AuditLogControllerFindRequest AuditLogControllerFindRequest

// NewAuditLogControllerFindRequest instantiates a new AuditLogControllerFindRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAuditLogControllerFindRequest(permission Permission, type_ NullableCrudEventType, detail map[string]interface{}) *AuditLogControllerFindRequest {
	this := AuditLogControllerFindRequest{}
	this.Permission = permission
	this.Type = type_
	this.Detail = detail
	return &this
}

// NewAuditLogControllerFindRequestWithDefaults instantiates a new AuditLogControllerFindRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAuditLogControllerFindRequestWithDefaults() *AuditLogControllerFindRequest {
	this := AuditLogControllerFindRequest{}
	return &this
}

// GetPermission returns the Permission field value
func (o *AuditLogControllerFindRequest) GetPermission() Permission {
	if o == nil {
		var ret Permission
		return ret
	}

	return o.Permission
}

// GetPermissionOk returns a tuple with the Permission field value
// and a boolean to check if the value has been set.
func (o *AuditLogControllerFindRequest) GetPermissionOk() (*Permission, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Permission, true
}

// SetPermission sets field value
func (o *AuditLogControllerFindRequest) SetPermission(v Permission) {
	o.Permission = v
}

// GetType returns the Type field value
// If the value is explicit nil, the zero value for CrudEventType will be returned
func (o *AuditLogControllerFindRequest) GetType() CrudEventType {
	if o == nil || o.Type.Get() == nil {
		var ret CrudEventType
		return ret
	}

	return *o.Type.Get()
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *AuditLogControllerFindRequest) GetTypeOk() (*CrudEventType, bool) {
	if o == nil {
		return nil, false
	}
	return o.Type.Get(), o.Type.IsSet()
}

// SetType sets field value
func (o *AuditLogControllerFindRequest) SetType(v CrudEventType) {
	o.Type.Set(&v)
}

// GetDetail returns the Detail field value
func (o *AuditLogControllerFindRequest) GetDetail() map[string]interface{} {
	if o == nil {
		var ret map[string]interface{}
		return ret
	}

	return o.Detail
}

// GetDetailOk returns a tuple with the Detail field value
// and a boolean to check if the value has been set.
func (o *AuditLogControllerFindRequest) GetDetailOk() (map[string]interface{}, bool) {
	if o == nil {
		return map[string]interface{}{}, false
	}
	return o.Detail, true
}

// SetDetail sets field value
func (o *AuditLogControllerFindRequest) SetDetail(v map[string]interface{}) {
	o.Detail = v
}

func (o AuditLogControllerFindRequest) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o AuditLogControllerFindRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["permission"] = o.Permission
	toSerialize["type"] = o.Type.Get()
	toSerialize["detail"] = o.Detail

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *AuditLogControllerFindRequest) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"permission",
		"type",
		"detail",
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

	varAuditLogControllerFindRequest := _AuditLogControllerFindRequest{}

	err = json.Unmarshal(data, &varAuditLogControllerFindRequest)

	if err != nil {
		return err
	}

	*o = AuditLogControllerFindRequest(varAuditLogControllerFindRequest)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "permission")
		delete(additionalProperties, "type")
		delete(additionalProperties, "detail")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableAuditLogControllerFindRequest struct {
	value *AuditLogControllerFindRequest
	isSet bool
}

func (v NullableAuditLogControllerFindRequest) Get() *AuditLogControllerFindRequest {
	return v.value
}

func (v *NullableAuditLogControllerFindRequest) Set(val *AuditLogControllerFindRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableAuditLogControllerFindRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableAuditLogControllerFindRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAuditLogControllerFindRequest(val *AuditLogControllerFindRequest) *NullableAuditLogControllerFindRequest {
	return &NullableAuditLogControllerFindRequest{value: val, isSet: true}
}

func (v NullableAuditLogControllerFindRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAuditLogControllerFindRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
