# ScimResourceWithOptionalId

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

## Methods

### NewScimResourceWithOptionalId

`func NewScimResourceWithOptionalId(meta Meta, ) *ScimResourceWithOptionalId`

NewScimResourceWithOptionalId instantiates a new ScimResourceWithOptionalId object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewScimResourceWithOptionalIdWithDefaults

`func NewScimResourceWithOptionalIdWithDefaults() *ScimResourceWithOptionalId`

NewScimResourceWithOptionalIdWithDefaults instantiates a new ScimResourceWithOptionalId object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *ScimResourceWithOptionalId) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *ScimResourceWithOptionalId) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *ScimResourceWithOptionalId) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *ScimResourceWithOptionalId) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetBaseUrn

`func (o *ScimResourceWithOptionalId) GetBaseUrn() string`

GetBaseUrn returns the BaseUrn field if non-nil, zero value otherwise.

### GetBaseUrnOk

`func (o *ScimResourceWithOptionalId) GetBaseUrnOk() (*string, bool)`

GetBaseUrnOk returns a tuple with the BaseUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUrn

`func (o *ScimResourceWithOptionalId) SetBaseUrn(v string)`

SetBaseUrn sets BaseUrn field to given value.

### HasBaseUrn

`func (o *ScimResourceWithOptionalId) HasBaseUrn() bool`

HasBaseUrn returns a boolean if a field has been set.

### GetExtensions

`func (o *ScimResourceWithOptionalId) GetExtensions() map[string]ScimExtension`

GetExtensions returns the Extensions field if non-nil, zero value otherwise.

### GetExtensionsOk

`func (o *ScimResourceWithOptionalId) GetExtensionsOk() (*map[string]ScimExtension, bool)`

GetExtensionsOk returns a tuple with the Extensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtensions

`func (o *ScimResourceWithOptionalId) SetExtensions(v map[string]ScimExtension)`

SetExtensions sets Extensions field to given value.

### HasExtensions

`func (o *ScimResourceWithOptionalId) HasExtensions() bool`

HasExtensions returns a boolean if a field has been set.

### GetMeta

`func (o *ScimResourceWithOptionalId) GetMeta() Meta`

GetMeta returns the Meta field if non-nil, zero value otherwise.

### GetMetaOk

`func (o *ScimResourceWithOptionalId) GetMetaOk() (*Meta, bool)`

GetMetaOk returns a tuple with the Meta field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMeta

`func (o *ScimResourceWithOptionalId) SetMeta(v Meta)`

SetMeta sets Meta field to given value.


### GetId

`func (o *ScimResourceWithOptionalId) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ScimResourceWithOptionalId) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ScimResourceWithOptionalId) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ScimResourceWithOptionalId) HasId() bool`

HasId returns a boolean if a field has been set.

### GetExternalId

`func (o *ScimResourceWithOptionalId) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *ScimResourceWithOptionalId) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *ScimResourceWithOptionalId) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.

### HasExternalId

`func (o *ScimResourceWithOptionalId) HasExternalId() bool`

HasExternalId returns a boolean if a field has been set.

### GetResourceType

`func (o *ScimResourceWithOptionalId) GetResourceType() string`

GetResourceType returns the ResourceType field if non-nil, zero value otherwise.

### GetResourceTypeOk

`func (o *ScimResourceWithOptionalId) GetResourceTypeOk() (*string, bool)`

GetResourceTypeOk returns a tuple with the ResourceType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceType

`func (o *ScimResourceWithOptionalId) SetResourceType(v string)`

SetResourceType sets ResourceType field to given value.

### HasResourceType

`func (o *ScimResourceWithOptionalId) HasResourceType() bool`

HasResourceType returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


