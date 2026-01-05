# ResourceType1

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
**Name** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Endpoint** | Pointer to **string** |  | [optional] 
**SchemaUrn** | Pointer to **string** |  | [optional] 
**SchemaExtensions** | Pointer to [**[]ResourceTypeSchemaExtensionConfiguration**](ResourceTypeSchemaExtensionConfiguration.md) |  | [optional] 

## Methods

### NewResourceType1

`func NewResourceType1(meta Meta, ) *ResourceType1`

NewResourceType1 instantiates a new ResourceType1 object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewResourceType1WithDefaults

`func NewResourceType1WithDefaults() *ResourceType1`

NewResourceType1WithDefaults instantiates a new ResourceType1 object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *ResourceType1) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *ResourceType1) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *ResourceType1) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *ResourceType1) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetBaseUrn

`func (o *ResourceType1) GetBaseUrn() string`

GetBaseUrn returns the BaseUrn field if non-nil, zero value otherwise.

### GetBaseUrnOk

`func (o *ResourceType1) GetBaseUrnOk() (*string, bool)`

GetBaseUrnOk returns a tuple with the BaseUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUrn

`func (o *ResourceType1) SetBaseUrn(v string)`

SetBaseUrn sets BaseUrn field to given value.

### HasBaseUrn

`func (o *ResourceType1) HasBaseUrn() bool`

HasBaseUrn returns a boolean if a field has been set.

### GetExtensions

`func (o *ResourceType1) GetExtensions() map[string]ScimExtension`

GetExtensions returns the Extensions field if non-nil, zero value otherwise.

### GetExtensionsOk

`func (o *ResourceType1) GetExtensionsOk() (*map[string]ScimExtension, bool)`

GetExtensionsOk returns a tuple with the Extensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtensions

`func (o *ResourceType1) SetExtensions(v map[string]ScimExtension)`

SetExtensions sets Extensions field to given value.

### HasExtensions

`func (o *ResourceType1) HasExtensions() bool`

HasExtensions returns a boolean if a field has been set.

### GetMeta

`func (o *ResourceType1) GetMeta() Meta`

GetMeta returns the Meta field if non-nil, zero value otherwise.

### GetMetaOk

`func (o *ResourceType1) GetMetaOk() (*Meta, bool)`

GetMetaOk returns a tuple with the Meta field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMeta

`func (o *ResourceType1) SetMeta(v Meta)`

SetMeta sets Meta field to given value.


### GetId

`func (o *ResourceType1) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ResourceType1) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ResourceType1) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ResourceType1) HasId() bool`

HasId returns a boolean if a field has been set.

### GetExternalId

`func (o *ResourceType1) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *ResourceType1) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *ResourceType1) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.

### HasExternalId

`func (o *ResourceType1) HasExternalId() bool`

HasExternalId returns a boolean if a field has been set.

### GetResourceType

`func (o *ResourceType1) GetResourceType() string`

GetResourceType returns the ResourceType field if non-nil, zero value otherwise.

### GetResourceTypeOk

`func (o *ResourceType1) GetResourceTypeOk() (*string, bool)`

GetResourceTypeOk returns a tuple with the ResourceType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceType

`func (o *ResourceType1) SetResourceType(v string)`

SetResourceType sets ResourceType field to given value.

### HasResourceType

`func (o *ResourceType1) HasResourceType() bool`

HasResourceType returns a boolean if a field has been set.

### GetName

`func (o *ResourceType1) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ResourceType1) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ResourceType1) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *ResourceType1) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *ResourceType1) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ResourceType1) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ResourceType1) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *ResourceType1) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEndpoint

`func (o *ResourceType1) GetEndpoint() string`

GetEndpoint returns the Endpoint field if non-nil, zero value otherwise.

### GetEndpointOk

`func (o *ResourceType1) GetEndpointOk() (*string, bool)`

GetEndpointOk returns a tuple with the Endpoint field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndpoint

`func (o *ResourceType1) SetEndpoint(v string)`

SetEndpoint sets Endpoint field to given value.

### HasEndpoint

`func (o *ResourceType1) HasEndpoint() bool`

HasEndpoint returns a boolean if a field has been set.

### GetSchemaUrn

`func (o *ResourceType1) GetSchemaUrn() string`

GetSchemaUrn returns the SchemaUrn field if non-nil, zero value otherwise.

### GetSchemaUrnOk

`func (o *ResourceType1) GetSchemaUrnOk() (*string, bool)`

GetSchemaUrnOk returns a tuple with the SchemaUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemaUrn

`func (o *ResourceType1) SetSchemaUrn(v string)`

SetSchemaUrn sets SchemaUrn field to given value.

### HasSchemaUrn

`func (o *ResourceType1) HasSchemaUrn() bool`

HasSchemaUrn returns a boolean if a field has been set.

### GetSchemaExtensions

`func (o *ResourceType1) GetSchemaExtensions() []ResourceTypeSchemaExtensionConfiguration`

GetSchemaExtensions returns the SchemaExtensions field if non-nil, zero value otherwise.

### GetSchemaExtensionsOk

`func (o *ResourceType1) GetSchemaExtensionsOk() (*[]ResourceTypeSchemaExtensionConfiguration, bool)`

GetSchemaExtensionsOk returns a tuple with the SchemaExtensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemaExtensions

`func (o *ResourceType1) SetSchemaExtensions(v []ResourceTypeSchemaExtensionConfiguration)`

SetSchemaExtensions sets SchemaExtensions field to given value.

### HasSchemaExtensions

`func (o *ResourceType1) HasSchemaExtensions() bool`

HasSchemaExtensions returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


