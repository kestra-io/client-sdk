# FlowTopologyGraph

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Nodes** | [**[]FlowNode**](FlowNode.md) |  | 
**Edges** | [**[]FlowTopologyGraphEdge**](FlowTopologyGraphEdge.md) |  | 

## Methods

### NewFlowTopologyGraph

`func NewFlowTopologyGraph(nodes []FlowNode, edges []FlowTopologyGraphEdge, ) *FlowTopologyGraph`

NewFlowTopologyGraph instantiates a new FlowTopologyGraph object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowTopologyGraphWithDefaults

`func NewFlowTopologyGraphWithDefaults() *FlowTopologyGraph`

NewFlowTopologyGraphWithDefaults instantiates a new FlowTopologyGraph object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNodes

`func (o *FlowTopologyGraph) GetNodes() []FlowNode`

GetNodes returns the Nodes field if non-nil, zero value otherwise.

### GetNodesOk

`func (o *FlowTopologyGraph) GetNodesOk() (*[]FlowNode, bool)`

GetNodesOk returns a tuple with the Nodes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNodes

`func (o *FlowTopologyGraph) SetNodes(v []FlowNode)`

SetNodes sets Nodes field to given value.


### GetEdges

`func (o *FlowTopologyGraph) GetEdges() []FlowTopologyGraphEdge`

GetEdges returns the Edges field if non-nil, zero value otherwise.

### GetEdgesOk

`func (o *FlowTopologyGraph) GetEdgesOk() (*[]FlowTopologyGraphEdge, bool)`

GetEdgesOk returns a tuple with the Edges field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEdges

`func (o *FlowTopologyGraph) SetEdges(v []FlowTopologyGraphEdge)`

SetEdges sets Edges field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


