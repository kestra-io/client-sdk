# Asset

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Namespace** | Pointer to **string** |  | [optional] 
**Id** | **string** |  | 
**Type** | **string** |  | 
**DisplayName** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Metadata** | Pointer to **map[string]map[string]interface{}** |  | [optional] 

## Methods

### NewAsset

`func NewAsset(id string, type_ string, ) *Asset`

NewAsset instantiates a new Asset object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetWithDefaults

`func NewAssetWithDefaults() *Asset`

NewAssetWithDefaults instantiates a new Asset object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNamespace

`func (o *Asset) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *Asset) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *Asset) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *Asset) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetId

`func (o *Asset) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Asset) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Asset) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *Asset) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *Asset) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *Asset) SetType(v string)`

SetType sets Type field to given value.


### GetDisplayName

`func (o *Asset) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *Asset) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *Asset) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *Asset) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetDescription

`func (o *Asset) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Asset) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Asset) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Asset) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetMetadata

`func (o *Asset) GetMetadata() map[string]map[string]interface{}`

GetMetadata returns the Metadata field if non-nil, zero value otherwise.

### GetMetadataOk

`func (o *Asset) GetMetadataOk() (*map[string]map[string]interface{}, bool)`

GetMetadataOk returns a tuple with the Metadata field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetadata

`func (o *Asset) SetMetadata(v map[string]map[string]interface{})`

SetMetadata sets Metadata field to given value.

### HasMetadata

`func (o *Asset) HasMetadata() bool`

HasMetadata returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


