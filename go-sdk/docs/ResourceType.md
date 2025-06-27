# ResourceType

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Schemas** | Pointer to **[]string** |  | [optional] 
**BaseUrn** | Pointer to **string** |  | [optional] 
**Extensions** | Pointer to [**map[string]ScimExtension**](ScimExtension.md) |  | [optional] 
**Meta** | [**Meta**](Meta.md) |  | 
**Id** | Pointer to **string** |  | [optional] 
**ExternalId** | Pointer to **string** |  | [optional] 
**ResourceType** | **string** |  | 
**Name** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Endpoint** | Pointer to **string** |  | [optional] 
**SchemaUrn** | Pointer to **string** |  | [optional] 
**SchemaExtensions** | Pointer to [**[]ResourceTypeSchemaExtensionConfiguration**](ResourceTypeSchemaExtensionConfiguration.md) |  | [optional] 

## Methods

### NewResourceType

`func NewResourceType(meta Meta, resourceType string, ) *ResourceType`

NewResourceType instantiates a new ResourceType object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewResourceTypeWithDefaults

`func NewResourceTypeWithDefaults() *ResourceType`

NewResourceTypeWithDefaults instantiates a new ResourceType object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *ResourceType) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *ResourceType) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *ResourceType) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *ResourceType) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetBaseUrn

`func (o *ResourceType) GetBaseUrn() string`

GetBaseUrn returns the BaseUrn field if non-nil, zero value otherwise.

### GetBaseUrnOk

`func (o *ResourceType) GetBaseUrnOk() (*string, bool)`

GetBaseUrnOk returns a tuple with the BaseUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUrn

`func (o *ResourceType) SetBaseUrn(v string)`

SetBaseUrn sets BaseUrn field to given value.

### HasBaseUrn

`func (o *ResourceType) HasBaseUrn() bool`

HasBaseUrn returns a boolean if a field has been set.

### GetExtensions

`func (o *ResourceType) GetExtensions() map[string]ScimExtension`

GetExtensions returns the Extensions field if non-nil, zero value otherwise.

### GetExtensionsOk

`func (o *ResourceType) GetExtensionsOk() (*map[string]ScimExtension, bool)`

GetExtensionsOk returns a tuple with the Extensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtensions

`func (o *ResourceType) SetExtensions(v map[string]ScimExtension)`

SetExtensions sets Extensions field to given value.

### HasExtensions

`func (o *ResourceType) HasExtensions() bool`

HasExtensions returns a boolean if a field has been set.

### GetMeta

`func (o *ResourceType) GetMeta() Meta`

GetMeta returns the Meta field if non-nil, zero value otherwise.

### GetMetaOk

`func (o *ResourceType) GetMetaOk() (*Meta, bool)`

GetMetaOk returns a tuple with the Meta field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMeta

`func (o *ResourceType) SetMeta(v Meta)`

SetMeta sets Meta field to given value.


### GetId

`func (o *ResourceType) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ResourceType) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ResourceType) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ResourceType) HasId() bool`

HasId returns a boolean if a field has been set.

### GetExternalId

`func (o *ResourceType) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *ResourceType) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *ResourceType) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.

### HasExternalId

`func (o *ResourceType) HasExternalId() bool`

HasExternalId returns a boolean if a field has been set.

### GetResourceType

`func (o *ResourceType) GetResourceType() string`

GetResourceType returns the ResourceType field if non-nil, zero value otherwise.

### GetResourceTypeOk

`func (o *ResourceType) GetResourceTypeOk() (*string, bool)`

GetResourceTypeOk returns a tuple with the ResourceType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceType

`func (o *ResourceType) SetResourceType(v string)`

SetResourceType sets ResourceType field to given value.


### GetName

`func (o *ResourceType) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ResourceType) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ResourceType) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *ResourceType) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *ResourceType) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ResourceType) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ResourceType) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *ResourceType) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEndpoint

`func (o *ResourceType) GetEndpoint() string`

GetEndpoint returns the Endpoint field if non-nil, zero value otherwise.

### GetEndpointOk

`func (o *ResourceType) GetEndpointOk() (*string, bool)`

GetEndpointOk returns a tuple with the Endpoint field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndpoint

`func (o *ResourceType) SetEndpoint(v string)`

SetEndpoint sets Endpoint field to given value.

### HasEndpoint

`func (o *ResourceType) HasEndpoint() bool`

HasEndpoint returns a boolean if a field has been set.

### GetSchemaUrn

`func (o *ResourceType) GetSchemaUrn() string`

GetSchemaUrn returns the SchemaUrn field if non-nil, zero value otherwise.

### GetSchemaUrnOk

`func (o *ResourceType) GetSchemaUrnOk() (*string, bool)`

GetSchemaUrnOk returns a tuple with the SchemaUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemaUrn

`func (o *ResourceType) SetSchemaUrn(v string)`

SetSchemaUrn sets SchemaUrn field to given value.

### HasSchemaUrn

`func (o *ResourceType) HasSchemaUrn() bool`

HasSchemaUrn returns a boolean if a field has been set.

### GetSchemaExtensions

`func (o *ResourceType) GetSchemaExtensions() []ResourceTypeSchemaExtensionConfiguration`

GetSchemaExtensions returns the SchemaExtensions field if non-nil, zero value otherwise.

### GetSchemaExtensionsOk

`func (o *ResourceType) GetSchemaExtensionsOk() (*[]ResourceTypeSchemaExtensionConfiguration, bool)`

GetSchemaExtensionsOk returns a tuple with the SchemaExtensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemaExtensions

`func (o *ResourceType) SetSchemaExtensions(v []ResourceTypeSchemaExtensionConfiguration)`

SetSchemaExtensions sets SchemaExtensions field to given value.

### HasSchemaExtensions

`func (o *ResourceType) HasSchemaExtensions() bool`

HasSchemaExtensions returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


