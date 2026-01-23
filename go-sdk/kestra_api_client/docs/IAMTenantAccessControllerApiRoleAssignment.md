# IAMTenantAccessControllerApiRoleAssignment

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**Origin** | Pointer to [**RBACServiceRoleAssignmentRoleOrigin**](RBACServiceRoleAssignmentRoleOrigin.md) |  | [optional] 
**SourceId** | Pointer to **string** |  | [optional] 
**Permissions** | Pointer to [**[]IAMTenantAccessControllerApiUserPermission**](IAMTenantAccessControllerApiUserPermission.md) |  | [optional] 

## Methods

### NewIAMTenantAccessControllerApiRoleAssignment

`func NewIAMTenantAccessControllerApiRoleAssignment() *IAMTenantAccessControllerApiRoleAssignment`

NewIAMTenantAccessControllerApiRoleAssignment instantiates a new IAMTenantAccessControllerApiRoleAssignment object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMTenantAccessControllerApiRoleAssignmentWithDefaults

`func NewIAMTenantAccessControllerApiRoleAssignmentWithDefaults() *IAMTenantAccessControllerApiRoleAssignment`

NewIAMTenantAccessControllerApiRoleAssignmentWithDefaults instantiates a new IAMTenantAccessControllerApiRoleAssignment object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasName() bool`

HasName returns a boolean if a field has been set.

### GetNamespace

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetOrigin

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetOrigin() RBACServiceRoleAssignmentRoleOrigin`

GetOrigin returns the Origin field if non-nil, zero value otherwise.

### GetOriginOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetOriginOk() (*RBACServiceRoleAssignmentRoleOrigin, bool)`

GetOriginOk returns a tuple with the Origin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOrigin

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetOrigin(v RBACServiceRoleAssignmentRoleOrigin)`

SetOrigin sets Origin field to given value.

### HasOrigin

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasOrigin() bool`

HasOrigin returns a boolean if a field has been set.

### GetSourceId

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetSourceId() string`

GetSourceId returns the SourceId field if non-nil, zero value otherwise.

### GetSourceIdOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetSourceIdOk() (*string, bool)`

GetSourceIdOk returns a tuple with the SourceId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSourceId

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetSourceId(v string)`

SetSourceId sets SourceId field to given value.

### HasSourceId

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasSourceId() bool`

HasSourceId returns a boolean if a field has been set.

### GetPermissions

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetPermissions() []IAMTenantAccessControllerApiUserPermission`

GetPermissions returns the Permissions field if non-nil, zero value otherwise.

### GetPermissionsOk

`func (o *IAMTenantAccessControllerApiRoleAssignment) GetPermissionsOk() (*[]IAMTenantAccessControllerApiUserPermission, bool)`

GetPermissionsOk returns a tuple with the Permissions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermissions

`func (o *IAMTenantAccessControllerApiRoleAssignment) SetPermissions(v []IAMTenantAccessControllerApiUserPermission)`

SetPermissions sets Permissions field to given value.

### HasPermissions

`func (o *IAMTenantAccessControllerApiRoleAssignment) HasPermissions() bool`

HasPermissions returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


