# FlowTopologyGraphEdge

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Source** | **string** |  | 
**Target** | **string** |  | 
**Relation** | [**FlowRelation**](FlowRelation.md) |  | 

## Methods

### NewFlowTopologyGraphEdge

`func NewFlowTopologyGraphEdge(source string, target string, relation FlowRelation, ) *FlowTopologyGraphEdge`

NewFlowTopologyGraphEdge instantiates a new FlowTopologyGraphEdge object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowTopologyGraphEdgeWithDefaults

`func NewFlowTopologyGraphEdgeWithDefaults() *FlowTopologyGraphEdge`

NewFlowTopologyGraphEdgeWithDefaults instantiates a new FlowTopologyGraphEdge object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSource

`func (o *FlowTopologyGraphEdge) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *FlowTopologyGraphEdge) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *FlowTopologyGraphEdge) SetSource(v string)`

SetSource sets Source field to given value.


### GetTarget

`func (o *FlowTopologyGraphEdge) GetTarget() string`

GetTarget returns the Target field if non-nil, zero value otherwise.

### GetTargetOk

`func (o *FlowTopologyGraphEdge) GetTargetOk() (*string, bool)`

GetTargetOk returns a tuple with the Target field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTarget

`func (o *FlowTopologyGraphEdge) SetTarget(v string)`

SetTarget sets Target field to given value.


### GetRelation

`func (o *FlowTopologyGraphEdge) GetRelation() FlowRelation`

GetRelation returns the Relation field if non-nil, zero value otherwise.

### GetRelationOk

`func (o *FlowTopologyGraphEdge) GetRelationOk() (*FlowRelation, bool)`

GetRelationOk returns a tuple with the Relation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRelation

`func (o *FlowTopologyGraphEdge) SetRelation(v FlowRelation)`

SetRelation sets Relation field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


