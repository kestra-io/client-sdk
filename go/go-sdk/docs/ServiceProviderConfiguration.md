# ServiceProviderConfiguration

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Schemas** | Pointer to **[]string** |  | [optional] 
**BaseUrn** | Pointer to **string** |  | [optional] 
**Extensions** | Pointer to [**map[string]ScimExtension**](ScimExtension.md) |  | [optional] 
**Meta** | [**Meta**](Meta.md) |  | 
**Id** | Pointer to **string** |  | [optional] 
**ExternalId** | Pointer to **string** |  | [optional] 
**ResourceType** | Pointer to **string** |  | [optional] 
**DocumentationUrl** | Pointer to **string** |  | [optional] 
**Patch** | Pointer to [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**Bulk** | Pointer to [**ServiceProviderConfigurationBulkConfiguration**](ServiceProviderConfigurationBulkConfiguration.md) |  | [optional] 
**Filter** | Pointer to [**ServiceProviderConfigurationFilterConfiguration**](ServiceProviderConfigurationFilterConfiguration.md) |  | [optional] 
**ChangePassword** | Pointer to [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**Sort** | Pointer to [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**Etag** | Pointer to [**ServiceProviderConfigurationSupportedConfiguration**](ServiceProviderConfigurationSupportedConfiguration.md) |  | [optional] 
**AuthenticationSchemes** | Pointer to [**[]ServiceProviderConfigurationAuthenticationSchema**](ServiceProviderConfigurationAuthenticationSchema.md) |  | [optional] 

## Methods

### NewServiceProviderConfiguration

`func NewServiceProviderConfiguration(meta Meta, ) *ServiceProviderConfiguration`

NewServiceProviderConfiguration instantiates a new ServiceProviderConfiguration object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServiceProviderConfigurationWithDefaults

`func NewServiceProviderConfigurationWithDefaults() *ServiceProviderConfiguration`

NewServiceProviderConfigurationWithDefaults instantiates a new ServiceProviderConfiguration object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *ServiceProviderConfiguration) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *ServiceProviderConfiguration) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *ServiceProviderConfiguration) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *ServiceProviderConfiguration) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetBaseUrn

`func (o *ServiceProviderConfiguration) GetBaseUrn() string`

GetBaseUrn returns the BaseUrn field if non-nil, zero value otherwise.

### GetBaseUrnOk

`func (o *ServiceProviderConfiguration) GetBaseUrnOk() (*string, bool)`

GetBaseUrnOk returns a tuple with the BaseUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUrn

`func (o *ServiceProviderConfiguration) SetBaseUrn(v string)`

SetBaseUrn sets BaseUrn field to given value.

### HasBaseUrn

`func (o *ServiceProviderConfiguration) HasBaseUrn() bool`

HasBaseUrn returns a boolean if a field has been set.

### GetExtensions

`func (o *ServiceProviderConfiguration) GetExtensions() map[string]ScimExtension`

GetExtensions returns the Extensions field if non-nil, zero value otherwise.

### GetExtensionsOk

`func (o *ServiceProviderConfiguration) GetExtensionsOk() (*map[string]ScimExtension, bool)`

GetExtensionsOk returns a tuple with the Extensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtensions

`func (o *ServiceProviderConfiguration) SetExtensions(v map[string]ScimExtension)`

SetExtensions sets Extensions field to given value.

### HasExtensions

`func (o *ServiceProviderConfiguration) HasExtensions() bool`

HasExtensions returns a boolean if a field has been set.

### GetMeta

`func (o *ServiceProviderConfiguration) GetMeta() Meta`

GetMeta returns the Meta field if non-nil, zero value otherwise.

### GetMetaOk

`func (o *ServiceProviderConfiguration) GetMetaOk() (*Meta, bool)`

GetMetaOk returns a tuple with the Meta field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMeta

`func (o *ServiceProviderConfiguration) SetMeta(v Meta)`

SetMeta sets Meta field to given value.


### GetId

`func (o *ServiceProviderConfiguration) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ServiceProviderConfiguration) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ServiceProviderConfiguration) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ServiceProviderConfiguration) HasId() bool`

HasId returns a boolean if a field has been set.

### GetExternalId

`func (o *ServiceProviderConfiguration) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *ServiceProviderConfiguration) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *ServiceProviderConfiguration) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.

### HasExternalId

`func (o *ServiceProviderConfiguration) HasExternalId() bool`

HasExternalId returns a boolean if a field has been set.

### GetResourceType

`func (o *ServiceProviderConfiguration) GetResourceType() string`

GetResourceType returns the ResourceType field if non-nil, zero value otherwise.

### GetResourceTypeOk

`func (o *ServiceProviderConfiguration) GetResourceTypeOk() (*string, bool)`

GetResourceTypeOk returns a tuple with the ResourceType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceType

`func (o *ServiceProviderConfiguration) SetResourceType(v string)`

SetResourceType sets ResourceType field to given value.

### HasResourceType

`func (o *ServiceProviderConfiguration) HasResourceType() bool`

HasResourceType returns a boolean if a field has been set.

### GetDocumentationUrl

`func (o *ServiceProviderConfiguration) GetDocumentationUrl() string`

GetDocumentationUrl returns the DocumentationUrl field if non-nil, zero value otherwise.

### GetDocumentationUrlOk

`func (o *ServiceProviderConfiguration) GetDocumentationUrlOk() (*string, bool)`

GetDocumentationUrlOk returns a tuple with the DocumentationUrl field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDocumentationUrl

`func (o *ServiceProviderConfiguration) SetDocumentationUrl(v string)`

SetDocumentationUrl sets DocumentationUrl field to given value.

### HasDocumentationUrl

`func (o *ServiceProviderConfiguration) HasDocumentationUrl() bool`

HasDocumentationUrl returns a boolean if a field has been set.

### GetPatch

`func (o *ServiceProviderConfiguration) GetPatch() ServiceProviderConfigurationSupportedConfiguration`

GetPatch returns the Patch field if non-nil, zero value otherwise.

### GetPatchOk

`func (o *ServiceProviderConfiguration) GetPatchOk() (*ServiceProviderConfigurationSupportedConfiguration, bool)`

GetPatchOk returns a tuple with the Patch field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPatch

`func (o *ServiceProviderConfiguration) SetPatch(v ServiceProviderConfigurationSupportedConfiguration)`

SetPatch sets Patch field to given value.

### HasPatch

`func (o *ServiceProviderConfiguration) HasPatch() bool`

HasPatch returns a boolean if a field has been set.

### GetBulk

`func (o *ServiceProviderConfiguration) GetBulk() ServiceProviderConfigurationBulkConfiguration`

GetBulk returns the Bulk field if non-nil, zero value otherwise.

### GetBulkOk

`func (o *ServiceProviderConfiguration) GetBulkOk() (*ServiceProviderConfigurationBulkConfiguration, bool)`

GetBulkOk returns a tuple with the Bulk field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBulk

`func (o *ServiceProviderConfiguration) SetBulk(v ServiceProviderConfigurationBulkConfiguration)`

SetBulk sets Bulk field to given value.

### HasBulk

`func (o *ServiceProviderConfiguration) HasBulk() bool`

HasBulk returns a boolean if a field has been set.

### GetFilter

`func (o *ServiceProviderConfiguration) GetFilter() ServiceProviderConfigurationFilterConfiguration`

GetFilter returns the Filter field if non-nil, zero value otherwise.

### GetFilterOk

`func (o *ServiceProviderConfiguration) GetFilterOk() (*ServiceProviderConfigurationFilterConfiguration, bool)`

GetFilterOk returns a tuple with the Filter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilter

`func (o *ServiceProviderConfiguration) SetFilter(v ServiceProviderConfigurationFilterConfiguration)`

SetFilter sets Filter field to given value.

### HasFilter

`func (o *ServiceProviderConfiguration) HasFilter() bool`

HasFilter returns a boolean if a field has been set.

### GetChangePassword

`func (o *ServiceProviderConfiguration) GetChangePassword() ServiceProviderConfigurationSupportedConfiguration`

GetChangePassword returns the ChangePassword field if non-nil, zero value otherwise.

### GetChangePasswordOk

`func (o *ServiceProviderConfiguration) GetChangePasswordOk() (*ServiceProviderConfigurationSupportedConfiguration, bool)`

GetChangePasswordOk returns a tuple with the ChangePassword field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetChangePassword

`func (o *ServiceProviderConfiguration) SetChangePassword(v ServiceProviderConfigurationSupportedConfiguration)`

SetChangePassword sets ChangePassword field to given value.

### HasChangePassword

`func (o *ServiceProviderConfiguration) HasChangePassword() bool`

HasChangePassword returns a boolean if a field has been set.

### GetSort

`func (o *ServiceProviderConfiguration) GetSort() ServiceProviderConfigurationSupportedConfiguration`

GetSort returns the Sort field if non-nil, zero value otherwise.

### GetSortOk

`func (o *ServiceProviderConfiguration) GetSortOk() (*ServiceProviderConfigurationSupportedConfiguration, bool)`

GetSortOk returns a tuple with the Sort field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSort

`func (o *ServiceProviderConfiguration) SetSort(v ServiceProviderConfigurationSupportedConfiguration)`

SetSort sets Sort field to given value.

### HasSort

`func (o *ServiceProviderConfiguration) HasSort() bool`

HasSort returns a boolean if a field has been set.

### GetEtag

`func (o *ServiceProviderConfiguration) GetEtag() ServiceProviderConfigurationSupportedConfiguration`

GetEtag returns the Etag field if non-nil, zero value otherwise.

### GetEtagOk

`func (o *ServiceProviderConfiguration) GetEtagOk() (*ServiceProviderConfigurationSupportedConfiguration, bool)`

GetEtagOk returns a tuple with the Etag field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEtag

`func (o *ServiceProviderConfiguration) SetEtag(v ServiceProviderConfigurationSupportedConfiguration)`

SetEtag sets Etag field to given value.

### HasEtag

`func (o *ServiceProviderConfiguration) HasEtag() bool`

HasEtag returns a boolean if a field has been set.

### GetAuthenticationSchemes

`func (o *ServiceProviderConfiguration) GetAuthenticationSchemes() []ServiceProviderConfigurationAuthenticationSchema`

GetAuthenticationSchemes returns the AuthenticationSchemes field if non-nil, zero value otherwise.

### GetAuthenticationSchemesOk

`func (o *ServiceProviderConfiguration) GetAuthenticationSchemesOk() (*[]ServiceProviderConfigurationAuthenticationSchema, bool)`

GetAuthenticationSchemesOk returns a tuple with the AuthenticationSchemes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuthenticationSchemes

`func (o *ServiceProviderConfiguration) SetAuthenticationSchemes(v []ServiceProviderConfigurationAuthenticationSchema)`

SetAuthenticationSchemes sets AuthenticationSchemes field to given value.

### HasAuthenticationSchemes

`func (o *ServiceProviderConfiguration) HasAuthenticationSchemes() bool`

HasAuthenticationSchemes returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


