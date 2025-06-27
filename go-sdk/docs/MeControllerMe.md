# MeControllerMe

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**User** | [**ApiUser**](ApiUser.md) |  | 
**Roles** | [**[]AclServiceNamespaceRole**](AclServiceNamespaceRole.md) |  | 
**Tenants** | [**[]ApiTenant**](ApiTenant.md) |  | 

## Methods

### NewMeControllerMe

`func NewMeControllerMe(user ApiUser, roles []AclServiceNamespaceRole, tenants []ApiTenant, ) *MeControllerMe`

NewMeControllerMe instantiates a new MeControllerMe object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMeControllerMeWithDefaults

`func NewMeControllerMeWithDefaults() *MeControllerMe`

NewMeControllerMeWithDefaults instantiates a new MeControllerMe object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUser

`func (o *MeControllerMe) GetUser() ApiUser`

GetUser returns the User field if non-nil, zero value otherwise.

### GetUserOk

`func (o *MeControllerMe) GetUserOk() (*ApiUser, bool)`

GetUserOk returns a tuple with the User field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUser

`func (o *MeControllerMe) SetUser(v ApiUser)`

SetUser sets User field to given value.


### GetRoles

`func (o *MeControllerMe) GetRoles() []AclServiceNamespaceRole`

GetRoles returns the Roles field if non-nil, zero value otherwise.

### GetRolesOk

`func (o *MeControllerMe) GetRolesOk() (*[]AclServiceNamespaceRole, bool)`

GetRolesOk returns a tuple with the Roles field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoles

`func (o *MeControllerMe) SetRoles(v []AclServiceNamespaceRole)`

SetRoles sets Roles field to given value.


### GetTenants

`func (o *MeControllerMe) GetTenants() []ApiTenant`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *MeControllerMe) GetTenantsOk() (*[]ApiTenant, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *MeControllerMe) SetTenants(v []ApiTenant)`

SetTenants sets Tenants field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


