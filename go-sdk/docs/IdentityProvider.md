# IdentityProvider

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Attributes** | **map[string]interface{}** |  | 
**ExternalId** | **string** |  | 
**SecurityIntegrationId** | **string** |  | 
**SecurityIntegrationName** | **string** |  | 

## Methods

### NewIdentityProvider

`func NewIdentityProvider(attributes map[string]interface{}, externalId string, securityIntegrationId string, securityIntegrationName string, ) *IdentityProvider`

NewIdentityProvider instantiates a new IdentityProvider object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIdentityProviderWithDefaults

`func NewIdentityProviderWithDefaults() *IdentityProvider`

NewIdentityProviderWithDefaults instantiates a new IdentityProvider object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAttributes

`func (o *IdentityProvider) GetAttributes() map[string]interface{}`

GetAttributes returns the Attributes field if non-nil, zero value otherwise.

### GetAttributesOk

`func (o *IdentityProvider) GetAttributesOk() (*map[string]interface{}, bool)`

GetAttributesOk returns a tuple with the Attributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributes

`func (o *IdentityProvider) SetAttributes(v map[string]interface{})`

SetAttributes sets Attributes field to given value.


### GetExternalId

`func (o *IdentityProvider) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *IdentityProvider) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *IdentityProvider) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.


### GetSecurityIntegrationId

`func (o *IdentityProvider) GetSecurityIntegrationId() string`

GetSecurityIntegrationId returns the SecurityIntegrationId field if non-nil, zero value otherwise.

### GetSecurityIntegrationIdOk

`func (o *IdentityProvider) GetSecurityIntegrationIdOk() (*string, bool)`

GetSecurityIntegrationIdOk returns a tuple with the SecurityIntegrationId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecurityIntegrationId

`func (o *IdentityProvider) SetSecurityIntegrationId(v string)`

SetSecurityIntegrationId sets SecurityIntegrationId field to given value.


### GetSecurityIntegrationName

`func (o *IdentityProvider) GetSecurityIntegrationName() string`

GetSecurityIntegrationName returns the SecurityIntegrationName field if non-nil, zero value otherwise.

### GetSecurityIntegrationNameOk

`func (o *IdentityProvider) GetSecurityIntegrationNameOk() (*string, bool)`

GetSecurityIntegrationNameOk returns a tuple with the SecurityIntegrationName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecurityIntegrationName

`func (o *IdentityProvider) SetSecurityIntegrationName(v string)`

SetSecurityIntegrationName sets SecurityIntegrationName field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


