# AssetTopologyGraphNode

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uid** | **string** |  | 
**Namespace** | Pointer to **string** |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**AssetTopologyGraphNodeNodeType**](AssetTopologyGraphNodeNodeType.md) |  | [optional] 

## Methods

### NewAssetTopologyGraphNode

`func NewAssetTopologyGraphNode(uid string, ) *AssetTopologyGraphNode`

NewAssetTopologyGraphNode instantiates a new AssetTopologyGraphNode object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetTopologyGraphNodeWithDefaults

`func NewAssetTopologyGraphNodeWithDefaults() *AssetTopologyGraphNode`

NewAssetTopologyGraphNodeWithDefaults instantiates a new AssetTopologyGraphNode object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUid

`func (o *AssetTopologyGraphNode) GetUid() string`

GetUid returns the Uid field if non-nil, zero value otherwise.

### GetUidOk

`func (o *AssetTopologyGraphNode) GetUidOk() (*string, bool)`

GetUidOk returns a tuple with the Uid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUid

`func (o *AssetTopologyGraphNode) SetUid(v string)`

SetUid sets Uid field to given value.


### GetNamespace

`func (o *AssetTopologyGraphNode) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *AssetTopologyGraphNode) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *AssetTopologyGraphNode) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *AssetTopologyGraphNode) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetId

`func (o *AssetTopologyGraphNode) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AssetTopologyGraphNode) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AssetTopologyGraphNode) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *AssetTopologyGraphNode) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *AssetTopologyGraphNode) GetType() AssetTopologyGraphNodeNodeType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AssetTopologyGraphNode) GetTypeOk() (*AssetTopologyGraphNodeNodeType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AssetTopologyGraphNode) SetType(v AssetTopologyGraphNodeNodeType)`

SetType sets Type field to given value.

### HasType

`func (o *AssetTopologyGraphNode) HasType() bool`

HasType returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


