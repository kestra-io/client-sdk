# BaseAuditLog

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | Pointer to **string** |  | [optional] 
**Id** | **string** |  | 
**Type** | [**CrudEventType**](CrudEventType.md) |  | 
**Detail** | [**AuditLogDetail**](AuditLogDetail.md) |  | 
**Date** | **time.Time** |  | 
**UserId** | **string** |  | 
**IpAddress** | Pointer to **string** |  | [optional] 
**ImpersonatedBy** | Pointer to **string** |  | [optional] 
**Deleted** | Pointer to **bool** |  | [optional] 

## Methods

### NewBaseAuditLog

`func NewBaseAuditLog(id string, type_ CrudEventType, detail AuditLogDetail, date time.Time, userId string, ) *BaseAuditLog`

NewBaseAuditLog instantiates a new BaseAuditLog object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBaseAuditLogWithDefaults

`func NewBaseAuditLogWithDefaults() *BaseAuditLog`

NewBaseAuditLogWithDefaults instantiates a new BaseAuditLog object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *BaseAuditLog) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *BaseAuditLog) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *BaseAuditLog) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *BaseAuditLog) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetId

`func (o *BaseAuditLog) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *BaseAuditLog) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *BaseAuditLog) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *BaseAuditLog) GetType() CrudEventType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *BaseAuditLog) GetTypeOk() (*CrudEventType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *BaseAuditLog) SetType(v CrudEventType)`

SetType sets Type field to given value.


### GetDetail

`func (o *BaseAuditLog) GetDetail() AuditLogDetail`

GetDetail returns the Detail field if non-nil, zero value otherwise.

### GetDetailOk

`func (o *BaseAuditLog) GetDetailOk() (*AuditLogDetail, bool)`

GetDetailOk returns a tuple with the Detail field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDetail

`func (o *BaseAuditLog) SetDetail(v AuditLogDetail)`

SetDetail sets Detail field to given value.


### GetDate

`func (o *BaseAuditLog) GetDate() time.Time`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *BaseAuditLog) GetDateOk() (*time.Time, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *BaseAuditLog) SetDate(v time.Time)`

SetDate sets Date field to given value.


### GetUserId

`func (o *BaseAuditLog) GetUserId() string`

GetUserId returns the UserId field if non-nil, zero value otherwise.

### GetUserIdOk

`func (o *BaseAuditLog) GetUserIdOk() (*string, bool)`

GetUserIdOk returns a tuple with the UserId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserId

`func (o *BaseAuditLog) SetUserId(v string)`

SetUserId sets UserId field to given value.


### GetIpAddress

`func (o *BaseAuditLog) GetIpAddress() string`

GetIpAddress returns the IpAddress field if non-nil, zero value otherwise.

### GetIpAddressOk

`func (o *BaseAuditLog) GetIpAddressOk() (*string, bool)`

GetIpAddressOk returns a tuple with the IpAddress field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIpAddress

`func (o *BaseAuditLog) SetIpAddress(v string)`

SetIpAddress sets IpAddress field to given value.

### HasIpAddress

`func (o *BaseAuditLog) HasIpAddress() bool`

HasIpAddress returns a boolean if a field has been set.

### GetImpersonatedBy

`func (o *BaseAuditLog) GetImpersonatedBy() string`

GetImpersonatedBy returns the ImpersonatedBy field if non-nil, zero value otherwise.

### GetImpersonatedByOk

`func (o *BaseAuditLog) GetImpersonatedByOk() (*string, bool)`

GetImpersonatedByOk returns a tuple with the ImpersonatedBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetImpersonatedBy

`func (o *BaseAuditLog) SetImpersonatedBy(v string)`

SetImpersonatedBy sets ImpersonatedBy field to given value.

### HasImpersonatedBy

`func (o *BaseAuditLog) HasImpersonatedBy() bool`

HasImpersonatedBy returns a boolean if a field has been set.

### GetDeleted

`func (o *BaseAuditLog) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *BaseAuditLog) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *BaseAuditLog) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.

### HasDeleted

`func (o *BaseAuditLog) HasDeleted() bool`

HasDeleted returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


