# FlowGraphCluster

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Cluster** | [**AbstractGraph**](AbstractGraph.md) |  | 
**Nodes** | **[]string** |  | 
**Parents** | **[]string** |  | 
**Start** | **string** |  | 
**End** | **string** |  | 

## Methods

### NewFlowGraphCluster

`func NewFlowGraphCluster(cluster AbstractGraph, nodes []string, parents []string, start string, end string, ) *FlowGraphCluster`

NewFlowGraphCluster instantiates a new FlowGraphCluster object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowGraphClusterWithDefaults

`func NewFlowGraphClusterWithDefaults() *FlowGraphCluster`

NewFlowGraphClusterWithDefaults instantiates a new FlowGraphCluster object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetCluster

`func (o *FlowGraphCluster) GetCluster() AbstractGraph`

GetCluster returns the Cluster field if non-nil, zero value otherwise.

### GetClusterOk

`func (o *FlowGraphCluster) GetClusterOk() (*AbstractGraph, bool)`

GetClusterOk returns a tuple with the Cluster field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCluster

`func (o *FlowGraphCluster) SetCluster(v AbstractGraph)`

SetCluster sets Cluster field to given value.


### GetNodes

`func (o *FlowGraphCluster) GetNodes() []string`

GetNodes returns the Nodes field if non-nil, zero value otherwise.

### GetNodesOk

`func (o *FlowGraphCluster) GetNodesOk() (*[]string, bool)`

GetNodesOk returns a tuple with the Nodes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNodes

`func (o *FlowGraphCluster) SetNodes(v []string)`

SetNodes sets Nodes field to given value.


### GetParents

`func (o *FlowGraphCluster) GetParents() []string`

GetParents returns the Parents field if non-nil, zero value otherwise.

### GetParentsOk

`func (o *FlowGraphCluster) GetParentsOk() (*[]string, bool)`

GetParentsOk returns a tuple with the Parents field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetParents

`func (o *FlowGraphCluster) SetParents(v []string)`

SetParents sets Parents field to given value.


### GetStart

`func (o *FlowGraphCluster) GetStart() string`

GetStart returns the Start field if non-nil, zero value otherwise.

### GetStartOk

`func (o *FlowGraphCluster) GetStartOk() (*string, bool)`

GetStartOk returns a tuple with the Start field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStart

`func (o *FlowGraphCluster) SetStart(v string)`

SetStart sets Start field to given value.


### GetEnd

`func (o *FlowGraphCluster) GetEnd() string`

GetEnd returns the End field if non-nil, zero value otherwise.

### GetEndOk

`func (o *FlowGraphCluster) GetEndOk() (*string, bool)`

GetEndOk returns a tuple with the End field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnd

`func (o *FlowGraphCluster) SetEnd(v string)`

SetEnd sets End field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


