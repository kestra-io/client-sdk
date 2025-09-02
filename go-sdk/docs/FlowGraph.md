# FlowGraph

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Nodes** | [**[]AbstractGraph**](AbstractGraph.md) |  | 
**Edges** | [**[]FlowGraphEdge**](FlowGraphEdge.md) |  | 
**Clusters** | [**[]FlowGraphCluster**](FlowGraphCluster.md) |  | 
**Flowables** | **[]string** |  | 

## Methods

### NewFlowGraph

`func NewFlowGraph(nodes []AbstractGraph, edges []FlowGraphEdge, clusters []FlowGraphCluster, flowables []string, ) *FlowGraph`

NewFlowGraph instantiates a new FlowGraph object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowGraphWithDefaults

`func NewFlowGraphWithDefaults() *FlowGraph`

NewFlowGraphWithDefaults instantiates a new FlowGraph object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNodes

`func (o *FlowGraph) GetNodes() []AbstractGraph`

GetNodes returns the Nodes field if non-nil, zero value otherwise.

### GetNodesOk

`func (o *FlowGraph) GetNodesOk() (*[]AbstractGraph, bool)`

GetNodesOk returns a tuple with the Nodes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNodes

`func (o *FlowGraph) SetNodes(v []AbstractGraph)`

SetNodes sets Nodes field to given value.


### GetEdges

`func (o *FlowGraph) GetEdges() []FlowGraphEdge`

GetEdges returns the Edges field if non-nil, zero value otherwise.

### GetEdgesOk

`func (o *FlowGraph) GetEdgesOk() (*[]FlowGraphEdge, bool)`

GetEdgesOk returns a tuple with the Edges field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEdges

`func (o *FlowGraph) SetEdges(v []FlowGraphEdge)`

SetEdges sets Edges field to given value.


### GetClusters

`func (o *FlowGraph) GetClusters() []FlowGraphCluster`

GetClusters returns the Clusters field if non-nil, zero value otherwise.

### GetClustersOk

`func (o *FlowGraph) GetClustersOk() (*[]FlowGraphCluster, bool)`

GetClustersOk returns a tuple with the Clusters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetClusters

`func (o *FlowGraph) SetClusters(v []FlowGraphCluster)`

SetClusters sets Clusters field to given value.


### GetFlowables

`func (o *FlowGraph) GetFlowables() []string`

GetFlowables returns the Flowables field if non-nil, zero value otherwise.

### GetFlowablesOk

`func (o *FlowGraph) GetFlowablesOk() (*[]string, bool)`

GetFlowablesOk returns a tuple with the Flowables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowables

`func (o *FlowGraph) SetFlowables(v []string)`

SetFlowables sets Flowables field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


