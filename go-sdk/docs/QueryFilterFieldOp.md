# QueryFilterFieldOp

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Value** | **string** |  | 
**Operations** | [**[]QueryFilterOperation**](QueryFilterOperation.md) |  | 

## Methods

### NewQueryFilterFieldOp

`func NewQueryFilterFieldOp(name string, value string, operations []QueryFilterOperation, ) *QueryFilterFieldOp`

NewQueryFilterFieldOp instantiates a new QueryFilterFieldOp object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewQueryFilterFieldOpWithDefaults

`func NewQueryFilterFieldOpWithDefaults() *QueryFilterFieldOp`

NewQueryFilterFieldOpWithDefaults instantiates a new QueryFilterFieldOp object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *QueryFilterFieldOp) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *QueryFilterFieldOp) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *QueryFilterFieldOp) SetName(v string)`

SetName sets Name field to given value.


### GetValue

`func (o *QueryFilterFieldOp) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *QueryFilterFieldOp) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *QueryFilterFieldOp) SetValue(v string)`

SetValue sets Value field to given value.


### GetOperations

`func (o *QueryFilterFieldOp) GetOperations() []QueryFilterOperation`

GetOperations returns the Operations field if non-nil, zero value otherwise.

### GetOperationsOk

`func (o *QueryFilterFieldOp) GetOperationsOk() (*[]QueryFilterOperation, bool)`

GetOperationsOk returns a tuple with the Operations field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOperations

`func (o *QueryFilterFieldOp) SetOperations(v []QueryFilterOperation)`

SetOperations sets Operations field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


