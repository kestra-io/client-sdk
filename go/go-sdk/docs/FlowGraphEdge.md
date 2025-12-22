# FlowGraphEdge

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Source** | Pointer to **string** |  | [optional] 
**Target** | Pointer to **string** |  | [optional] 
**Relation** | Pointer to [**Relation**](Relation.md) |  | [optional] 

## Methods

### NewFlowGraphEdge

`func NewFlowGraphEdge() *FlowGraphEdge`

NewFlowGraphEdge instantiates a new FlowGraphEdge object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowGraphEdgeWithDefaults

`func NewFlowGraphEdgeWithDefaults() *FlowGraphEdge`

NewFlowGraphEdgeWithDefaults instantiates a new FlowGraphEdge object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSource

`func (o *FlowGraphEdge) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *FlowGraphEdge) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *FlowGraphEdge) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *FlowGraphEdge) HasSource() bool`

HasSource returns a boolean if a field has been set.

### GetTarget

`func (o *FlowGraphEdge) GetTarget() string`

GetTarget returns the Target field if non-nil, zero value otherwise.

### GetTargetOk

`func (o *FlowGraphEdge) GetTargetOk() (*string, bool)`

GetTargetOk returns a tuple with the Target field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTarget

`func (o *FlowGraphEdge) SetTarget(v string)`

SetTarget sets Target field to given value.

### HasTarget

`func (o *FlowGraphEdge) HasTarget() bool`

HasTarget returns a boolean if a field has been set.

### GetRelation

`func (o *FlowGraphEdge) GetRelation() Relation`

GetRelation returns the Relation field if non-nil, zero value otherwise.

### GetRelationOk

`func (o *FlowGraphEdge) GetRelationOk() (*Relation, bool)`

GetRelationOk returns a tuple with the Relation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRelation

`func (o *FlowGraphEdge) SetRelation(v Relation)`

SetRelation sets Relation field to given value.

### HasRelation

`func (o *FlowGraphEdge) HasRelation() bool`

HasRelation returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


