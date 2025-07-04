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

// checks if the AuditLog type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &AuditLog{}

// AuditLog struct for AuditLog
type AuditLog struct {
	Id                   string                   `json:"id"`
	Type                 CrudEventType            `json:"type"`
	Detail               AuditLogDetail           `json:"detail"`
	Date                 time.Time                `json:"date"`
	UserId               string                   `json:"userId"`
	IpAddress            string                   `json:"ipAddress"`
	ImpersonatedBy       string                   `json:"impersonatedBy"`
	Deleted              bool                     `json:"deleted"`
	AppliedPatch         []map[string]interface{} `json:"appliedPatch"`
	RevertPatch          []map[string]interface{} `json:"revertPatch"`
	AdditionalProperties map[string]interface{}
}

type _AuditLog AuditLog

// NewAuditLog instantiates a new AuditLog object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAuditLog(id string, type_ CrudEventType, detail AuditLogDetail, date time.Time, userId string, ipAddress string, impersonatedBy string, deleted bool, appliedPatch []map[string]interface{}, revertPatch []map[string]interface{}) *AuditLog {
	this := AuditLog{}
	this.Id = id
	this.Type = type_
	this.Detail = detail
	this.Date = date
	this.UserId = userId
	this.IpAddress = ipAddress
	this.ImpersonatedBy = impersonatedBy
	this.Deleted = deleted
	this.AppliedPatch = appliedPatch
	this.RevertPatch = revertPatch
	return &this
}

// NewAuditLogWithDefaults instantiates a new AuditLog object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAuditLogWithDefaults() *AuditLog {
	this := AuditLog{}
	return &this
}

// GetId returns the Id field value
func (o *AuditLog) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *AuditLog) SetId(v string) {
	o.Id = v
}

// GetType returns the Type field value
func (o *AuditLog) GetType() CrudEventType {
	if o == nil {
		var ret CrudEventType
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetTypeOk() (*CrudEventType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *AuditLog) SetType(v CrudEventType) {
	o.Type = v
}

// GetDetail returns the Detail field value
func (o *AuditLog) GetDetail() AuditLogDetail {
	if o == nil {
		var ret AuditLogDetail
		return ret
	}

	return o.Detail
}

// GetDetailOk returns a tuple with the Detail field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetDetailOk() (*AuditLogDetail, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Detail, true
}

// SetDetail sets field value
func (o *AuditLog) SetDetail(v AuditLogDetail) {
	o.Detail = v
}

// GetDate returns the Date field value
func (o *AuditLog) GetDate() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.Date
}

// GetDateOk returns a tuple with the Date field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetDateOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Date, true
}

// SetDate sets field value
func (o *AuditLog) SetDate(v time.Time) {
	o.Date = v
}

// GetUserId returns the UserId field value
func (o *AuditLog) GetUserId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserId
}

// GetUserIdOk returns a tuple with the UserId field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetUserIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserId, true
}

// SetUserId sets field value
func (o *AuditLog) SetUserId(v string) {
	o.UserId = v
}

// GetIpAddress returns the IpAddress field value
func (o *AuditLog) GetIpAddress() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IpAddress
}

// GetIpAddressOk returns a tuple with the IpAddress field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetIpAddressOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IpAddress, true
}

// SetIpAddress sets field value
func (o *AuditLog) SetIpAddress(v string) {
	o.IpAddress = v
}

// GetImpersonatedBy returns the ImpersonatedBy field value
func (o *AuditLog) GetImpersonatedBy() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ImpersonatedBy
}

// GetImpersonatedByOk returns a tuple with the ImpersonatedBy field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetImpersonatedByOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ImpersonatedBy, true
}

// SetImpersonatedBy sets field value
func (o *AuditLog) SetImpersonatedBy(v string) {
	o.ImpersonatedBy = v
}

// GetDeleted returns the Deleted field value
func (o *AuditLog) GetDeleted() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.Deleted
}

// GetDeletedOk returns a tuple with the Deleted field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetDeletedOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Deleted, true
}

// SetDeleted sets field value
func (o *AuditLog) SetDeleted(v bool) {
	o.Deleted = v
}

// GetAppliedPatch returns the AppliedPatch field value
func (o *AuditLog) GetAppliedPatch() []map[string]interface{} {
	if o == nil {
		var ret []map[string]interface{}
		return ret
	}

	return o.AppliedPatch
}

// GetAppliedPatchOk returns a tuple with the AppliedPatch field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetAppliedPatchOk() ([]map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.AppliedPatch, true
}

// SetAppliedPatch sets field value
func (o *AuditLog) SetAppliedPatch(v []map[string]interface{}) {
	o.AppliedPatch = v
}

// GetRevertPatch returns the RevertPatch field value
func (o *AuditLog) GetRevertPatch() []map[string]interface{} {
	if o == nil {
		var ret []map[string]interface{}
		return ret
	}

	return o.RevertPatch
}

// GetRevertPatchOk returns a tuple with the RevertPatch field value
// and a boolean to check if the value has been set.
func (o *AuditLog) GetRevertPatchOk() ([]map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.RevertPatch, true
}

// SetRevertPatch sets field value
func (o *AuditLog) SetRevertPatch(v []map[string]interface{}) {
	o.RevertPatch = v
}

func (o AuditLog) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o AuditLog) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["id"] = o.Id
	toSerialize["type"] = o.Type
	toSerialize["detail"] = o.Detail
	toSerialize["date"] = o.Date
	toSerialize["userId"] = o.UserId
	toSerialize["ipAddress"] = o.IpAddress
	toSerialize["impersonatedBy"] = o.ImpersonatedBy
	toSerialize["deleted"] = o.Deleted
	toSerialize["appliedPatch"] = o.AppliedPatch
	toSerialize["revertPatch"] = o.RevertPatch

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *AuditLog) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"id",
		"type",
		"detail",
		"date",
		"userId",
		"ipAddress",
		"impersonatedBy",
		"deleted",
		"appliedPatch",
		"revertPatch",
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

	varAuditLog := _AuditLog{}

	err = json.Unmarshal(data, &varAuditLog)

	if err != nil {
		return err
	}

	*o = AuditLog(varAuditLog)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "type")
		delete(additionalProperties, "detail")
		delete(additionalProperties, "date")
		delete(additionalProperties, "userId")
		delete(additionalProperties, "ipAddress")
		delete(additionalProperties, "impersonatedBy")
		delete(additionalProperties, "deleted")
		delete(additionalProperties, "appliedPatch")
		delete(additionalProperties, "revertPatch")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableAuditLog struct {
	value *AuditLog
	isSet bool
}

func (v NullableAuditLog) Get() *AuditLog {
	return v.value
}

func (v *NullableAuditLog) Set(val *AuditLog) {
	v.value = val
	v.isSet = true
}

func (v NullableAuditLog) IsSet() bool {
	return v.isSet
}

func (v *NullableAuditLog) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAuditLog(val *AuditLog) *NullableAuditLog {
	return &NullableAuditLog{value: val, isSet: true}
}

func (v NullableAuditLog) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAuditLog) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
