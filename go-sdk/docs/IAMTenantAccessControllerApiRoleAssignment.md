# IAMTenantAccessControllerApiRoleAssignment

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Name** | **string** |  | 
**Namespace** | **string** |  | 
**Origin** | [**RBACServiceRoleAssignmentRoleOrigin**](RBACServiceRoleAssignmentRoleOrigin.md) |  | 
**SourceId** | **string** |  | 
**Permissions** | [**[]IAMTenantAccessControllerApiUserPermission**](IAMTenantAccessControllerApiUserPermission.md) |  | 

## Methods

### NewIAMTenantAccessControllerApiRoleAssignment

`func NewIAMTenantAccessControllerApiRoleAssignment(id string, name string, namespace string, origin RBACServiceRoleAssignmentRoleOrigin, sourceId string, permissions []IAMTenantAccessControllerApiUserPermission, ) *IAMTenantAccessControllerApiRoleAssignment`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


