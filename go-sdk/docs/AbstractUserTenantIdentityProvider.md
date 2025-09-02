# AbstractUserTenantIdentityProvider

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Attributes** | **map[string]map[string]interface{}** |  | 
**ExternalId** | **string** |  | 
**SecurityIntegrationId** | **string** |  | 
**SecurityIntegrationName** | **string** |  | 
**TenantId** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewAbstractUserTenantIdentityProvider

`func NewAbstractUserTenantIdentityProvider(attributes map[string]map[string]interface{}, externalId string, securityIntegrationId string, securityIntegrationName string, ) *AbstractUserTenantIdentityProvider`

NewAbstractUserTenantIdentityProvider instantiates a new AbstractUserTenantIdentityProvider object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractUserTenantIdentityProviderWithDefaults

`func NewAbstractUserTenantIdentityProviderWithDefaults() *AbstractUserTenantIdentityProvider`

NewAbstractUserTenantIdentityProviderWithDefaults instantiates a new AbstractUserTenantIdentityProvider object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAttributes

`func (o *AbstractUserTenantIdentityProvider) GetAttributes() map[string]map[string]interface{}`

GetAttributes returns the Attributes field if non-nil, zero value otherwise.

### GetAttributesOk

`func (o *AbstractUserTenantIdentityProvider) GetAttributesOk() (*map[string]map[string]interface{}, bool)`

GetAttributesOk returns a tuple with the Attributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributes

`func (o *AbstractUserTenantIdentityProvider) SetAttributes(v map[string]map[string]interface{})`

SetAttributes sets Attributes field to given value.


### GetExternalId

`func (o *AbstractUserTenantIdentityProvider) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *AbstractUserTenantIdentityProvider) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *AbstractUserTenantIdentityProvider) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.


### GetSecurityIntegrationId

`func (o *AbstractUserTenantIdentityProvider) GetSecurityIntegrationId() string`

GetSecurityIntegrationId returns the SecurityIntegrationId field if non-nil, zero value otherwise.

### GetSecurityIntegrationIdOk

`func (o *AbstractUserTenantIdentityProvider) GetSecurityIntegrationIdOk() (*string, bool)`

GetSecurityIntegrationIdOk returns a tuple with the SecurityIntegrationId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecurityIntegrationId

`func (o *AbstractUserTenantIdentityProvider) SetSecurityIntegrationId(v string)`

SetSecurityIntegrationId sets SecurityIntegrationId field to given value.


### GetSecurityIntegrationName

`func (o *AbstractUserTenantIdentityProvider) GetSecurityIntegrationName() string`

GetSecurityIntegrationName returns the SecurityIntegrationName field if non-nil, zero value otherwise.

### GetSecurityIntegrationNameOk

`func (o *AbstractUserTenantIdentityProvider) GetSecurityIntegrationNameOk() (*string, bool)`

GetSecurityIntegrationNameOk returns a tuple with the SecurityIntegrationName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecurityIntegrationName

`func (o *AbstractUserTenantIdentityProvider) SetSecurityIntegrationName(v string)`

SetSecurityIntegrationName sets SecurityIntegrationName field to given value.


### GetTenantId

`func (o *AbstractUserTenantIdentityProvider) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *AbstractUserTenantIdentityProvider) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *AbstractUserTenantIdentityProvider) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *AbstractUserTenantIdentityProvider) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### SetTenantIdNil

`func (o *AbstractUserTenantIdentityProvider) SetTenantIdNil(b bool)`

 SetTenantIdNil sets the value for TenantId to be an explicit nil

### UnsetTenantId
`func (o *AbstractUserTenantIdentityProvider) UnsetTenantId()`

UnsetTenantId ensures that no value is present for TenantId, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


