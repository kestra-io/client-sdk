# MeControllerApiMe

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**SuperAdmin** | **bool** |  | 
**Restricted** | **bool** |  | 
**Profile** | [**MeControllerApiProfile**](MeControllerApiProfile.md) |  | 
**Auths** | [**[]IAMTenantAccessControllerApiAuthentication**](IAMTenantAccessControllerApiAuthentication.md) |  | 
**Tenants** | [**[]MeControllerApiTenant**](MeControllerApiTenant.md) |  | 

## Methods

### NewMeControllerApiMe

`func NewMeControllerApiMe(id string, superAdmin bool, restricted bool, profile MeControllerApiProfile, auths []IAMTenantAccessControllerApiAuthentication, tenants []MeControllerApiTenant, ) *MeControllerApiMe`

NewMeControllerApiMe instantiates a new MeControllerApiMe object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMeControllerApiMeWithDefaults

`func NewMeControllerApiMeWithDefaults() *MeControllerApiMe`

NewMeControllerApiMeWithDefaults instantiates a new MeControllerApiMe object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *MeControllerApiMe) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *MeControllerApiMe) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *MeControllerApiMe) SetId(v string)`

SetId sets Id field to given value.


### GetSuperAdmin

`func (o *MeControllerApiMe) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *MeControllerApiMe) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *MeControllerApiMe) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.


### GetRestricted

`func (o *MeControllerApiMe) GetRestricted() bool`

GetRestricted returns the Restricted field if non-nil, zero value otherwise.

### GetRestrictedOk

`func (o *MeControllerApiMe) GetRestrictedOk() (*bool, bool)`

GetRestrictedOk returns a tuple with the Restricted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRestricted

`func (o *MeControllerApiMe) SetRestricted(v bool)`

SetRestricted sets Restricted field to given value.


### GetProfile

`func (o *MeControllerApiMe) GetProfile() MeControllerApiProfile`

GetProfile returns the Profile field if non-nil, zero value otherwise.

### GetProfileOk

`func (o *MeControllerApiMe) GetProfileOk() (*MeControllerApiProfile, bool)`

GetProfileOk returns a tuple with the Profile field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetProfile

`func (o *MeControllerApiMe) SetProfile(v MeControllerApiProfile)`

SetProfile sets Profile field to given value.


### GetAuths

`func (o *MeControllerApiMe) GetAuths() []IAMTenantAccessControllerApiAuthentication`

GetAuths returns the Auths field if non-nil, zero value otherwise.

### GetAuthsOk

`func (o *MeControllerApiMe) GetAuthsOk() (*[]IAMTenantAccessControllerApiAuthentication, bool)`

GetAuthsOk returns a tuple with the Auths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuths

`func (o *MeControllerApiMe) SetAuths(v []IAMTenantAccessControllerApiAuthentication)`

SetAuths sets Auths field to given value.


### GetTenants

`func (o *MeControllerApiMe) GetTenants() []MeControllerApiTenant`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *MeControllerApiMe) GetTenantsOk() (*[]MeControllerApiTenant, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *MeControllerApiMe) SetTenants(v []MeControllerApiTenant)`

SetTenants sets Tenants field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


