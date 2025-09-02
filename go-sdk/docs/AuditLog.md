# AuditLog

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | **string** |  | 
**Id** | **string** |  | 
**Type** | [**CrudEventType**](CrudEventType.md) |  | 
**Detail** | [**AuditLogDetail**](AuditLogDetail.md) |  | 
**Date** | **time.Time** |  | 
**UserId** | **string** |  | 
**IpAddress** | **string** |  | 
**ImpersonatedBy** | **string** |  | 
**Deleted** | **bool** |  | 
**AppliedPatch** | **[]map[string]interface{}** |  | 
**RevertPatch** | **[]map[string]interface{}** |  | 

## Methods

### NewAuditLog

`func NewAuditLog(tenantId string, id string, type_ CrudEventType, detail AuditLogDetail, date time.Time, userId string, ipAddress string, impersonatedBy string, deleted bool, appliedPatch []map[string]interface{}, revertPatch []map[string]interface{}, ) *AuditLog`

NewAuditLog instantiates a new AuditLog object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAuditLogWithDefaults

`func NewAuditLogWithDefaults() *AuditLog`

NewAuditLogWithDefaults instantiates a new AuditLog object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *AuditLog) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *AuditLog) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *AuditLog) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.


### GetId

`func (o *AuditLog) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AuditLog) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AuditLog) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *AuditLog) GetType() CrudEventType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AuditLog) GetTypeOk() (*CrudEventType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AuditLog) SetType(v CrudEventType)`

SetType sets Type field to given value.


### GetDetail

`func (o *AuditLog) GetDetail() AuditLogDetail`

GetDetail returns the Detail field if non-nil, zero value otherwise.

### GetDetailOk

`func (o *AuditLog) GetDetailOk() (*AuditLogDetail, bool)`

GetDetailOk returns a tuple with the Detail field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDetail

`func (o *AuditLog) SetDetail(v AuditLogDetail)`

SetDetail sets Detail field to given value.


### GetDate

`func (o *AuditLog) GetDate() time.Time`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *AuditLog) GetDateOk() (*time.Time, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *AuditLog) SetDate(v time.Time)`

SetDate sets Date field to given value.


### GetUserId

`func (o *AuditLog) GetUserId() string`

GetUserId returns the UserId field if non-nil, zero value otherwise.

### GetUserIdOk

`func (o *AuditLog) GetUserIdOk() (*string, bool)`

GetUserIdOk returns a tuple with the UserId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserId

`func (o *AuditLog) SetUserId(v string)`

SetUserId sets UserId field to given value.


### GetIpAddress

`func (o *AuditLog) GetIpAddress() string`

GetIpAddress returns the IpAddress field if non-nil, zero value otherwise.

### GetIpAddressOk

`func (o *AuditLog) GetIpAddressOk() (*string, bool)`

GetIpAddressOk returns a tuple with the IpAddress field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIpAddress

`func (o *AuditLog) SetIpAddress(v string)`

SetIpAddress sets IpAddress field to given value.


### GetImpersonatedBy

`func (o *AuditLog) GetImpersonatedBy() string`

GetImpersonatedBy returns the ImpersonatedBy field if non-nil, zero value otherwise.

### GetImpersonatedByOk

`func (o *AuditLog) GetImpersonatedByOk() (*string, bool)`

GetImpersonatedByOk returns a tuple with the ImpersonatedBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetImpersonatedBy

`func (o *AuditLog) SetImpersonatedBy(v string)`

SetImpersonatedBy sets ImpersonatedBy field to given value.


### GetDeleted

`func (o *AuditLog) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *AuditLog) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *AuditLog) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetAppliedPatch

`func (o *AuditLog) GetAppliedPatch() []map[string]interface{}`

GetAppliedPatch returns the AppliedPatch field if non-nil, zero value otherwise.

### GetAppliedPatchOk

`func (o *AuditLog) GetAppliedPatchOk() (*[]map[string]interface{}, bool)`

GetAppliedPatchOk returns a tuple with the AppliedPatch field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAppliedPatch

`func (o *AuditLog) SetAppliedPatch(v []map[string]interface{})`

SetAppliedPatch sets AppliedPatch field to given value.


### GetRevertPatch

`func (o *AuditLog) GetRevertPatch() []map[string]interface{}`

GetRevertPatch returns the RevertPatch field if non-nil, zero value otherwise.

### GetRevertPatchOk

`func (o *AuditLog) GetRevertPatchOk() (*[]map[string]interface{}, bool)`

GetRevertPatchOk returns a tuple with the RevertPatch field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevertPatch

`func (o *AuditLog) SetRevertPatch(v []map[string]interface{})`

SetRevertPatch sets RevertPatch field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


