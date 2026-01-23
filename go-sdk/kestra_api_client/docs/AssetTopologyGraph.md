# AssetTopologyGraph

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Nodes** | Pointer to [**[]AssetTopologyGraphNode**](AssetTopologyGraphNode.md) |  | [optional] 
**Edges** | Pointer to [**[]AssetTopologyGraphEdge**](AssetTopologyGraphEdge.md) |  | [optional] 

## Methods

### NewAssetTopologyGraph

`func NewAssetTopologyGraph() *AssetTopologyGraph`

NewAssetTopologyGraph instantiates a new AssetTopologyGraph object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssetTopologyGraphWithDefaults

`func NewAssetTopologyGraphWithDefaults() *AssetTopologyGraph`

NewAssetTopologyGraphWithDefaults instantiates a new AssetTopologyGraph object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNodes

`func (o *AssetTopologyGraph) GetNodes() []AssetTopologyGraphNode`

GetNodes returns the Nodes field if non-nil, zero value otherwise.

### GetNodesOk

`func (o *AssetTopologyGraph) GetNodesOk() (*[]AssetTopologyGraphNode, bool)`

GetNodesOk returns a tuple with the Nodes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNodes

`func (o *AssetTopologyGraph) SetNodes(v []AssetTopologyGraphNode)`

SetNodes sets Nodes field to given value.

### HasNodes

`func (o *AssetTopologyGraph) HasNodes() bool`

HasNodes returns a boolean if a field has been set.

### GetEdges

`func (o *AssetTopologyGraph) GetEdges() []AssetTopologyGraphEdge`

GetEdges returns the Edges field if non-nil, zero value otherwise.

### GetEdgesOk

`func (o *AssetTopologyGraph) GetEdgesOk() (*[]AssetTopologyGraphEdge, bool)`

GetEdgesOk returns a tuple with the Edges field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEdges

`func (o *AssetTopologyGraph) SetEdges(v []AssetTopologyGraphEdge)`

SetEdges sets Edges field to given value.

### HasEdges

`func (o *AssetTopologyGraph) HasEdges() bool`

HasEdges returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


