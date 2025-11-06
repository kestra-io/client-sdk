# Relation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**RelationType** | Pointer to [**RelationType**](RelationType.md) |  | [optional] 
**Value** | Pointer to **string** |  | [optional] 

## Methods

### NewRelation

`func NewRelation() *Relation`

NewRelation instantiates a new Relation object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewRelationWithDefaults

`func NewRelationWithDefaults() *Relation`

NewRelationWithDefaults instantiates a new Relation object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetRelationType

`func (o *Relation) GetRelationType() RelationType`

GetRelationType returns the RelationType field if non-nil, zero value otherwise.

### GetRelationTypeOk

`func (o *Relation) GetRelationTypeOk() (*RelationType, bool)`

GetRelationTypeOk returns a tuple with the RelationType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRelationType

`func (o *Relation) SetRelationType(v RelationType)`

SetRelationType sets RelationType field to given value.

### HasRelationType

`func (o *Relation) HasRelationType() bool`

HasRelationType returns a boolean if a field has been set.

### GetValue

`func (o *Relation) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *Relation) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *Relation) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *Relation) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


