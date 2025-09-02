# AuditLogControllerApiAuditLogItem

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AuditLog** | [**AuditLog**](AuditLog.md) |  | 
**User** | [**ApiUser**](ApiUser.md) |  | 
**Permission** | [**Permission**](Permission.md) |  | 

## Methods

### NewAuditLogControllerApiAuditLogItem

`func NewAuditLogControllerApiAuditLogItem(auditLog AuditLog, user ApiUser, permission Permission, ) *AuditLogControllerApiAuditLogItem`

NewAuditLogControllerApiAuditLogItem instantiates a new AuditLogControllerApiAuditLogItem object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAuditLogControllerApiAuditLogItemWithDefaults

`func NewAuditLogControllerApiAuditLogItemWithDefaults() *AuditLogControllerApiAuditLogItem`

NewAuditLogControllerApiAuditLogItemWithDefaults instantiates a new AuditLogControllerApiAuditLogItem object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAuditLog

`func (o *AuditLogControllerApiAuditLogItem) GetAuditLog() AuditLog`

GetAuditLog returns the AuditLog field if non-nil, zero value otherwise.

### GetAuditLogOk

`func (o *AuditLogControllerApiAuditLogItem) GetAuditLogOk() (*AuditLog, bool)`

GetAuditLogOk returns a tuple with the AuditLog field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuditLog

`func (o *AuditLogControllerApiAuditLogItem) SetAuditLog(v AuditLog)`

SetAuditLog sets AuditLog field to given value.


### GetUser

`func (o *AuditLogControllerApiAuditLogItem) GetUser() ApiUser`

GetUser returns the User field if non-nil, zero value otherwise.

### GetUserOk

`func (o *AuditLogControllerApiAuditLogItem) GetUserOk() (*ApiUser, bool)`

GetUserOk returns a tuple with the User field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUser

`func (o *AuditLogControllerApiAuditLogItem) SetUser(v ApiUser)`

SetUser sets User field to given value.


### GetPermission

`func (o *AuditLogControllerApiAuditLogItem) GetPermission() Permission`

GetPermission returns the Permission field if non-nil, zero value otherwise.

### GetPermissionOk

`func (o *AuditLogControllerApiAuditLogItem) GetPermissionOk() (*Permission, bool)`

GetPermissionOk returns a tuple with the Permission field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermission

`func (o *AuditLogControllerApiAuditLogItem) SetPermission(v Permission)`

SetPermission sets Permission field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


