# QueryFilter

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Field** | [**QueryFilterField**](QueryFilterField.md) |  | 
**Operation** | [**QueryFilterOp**](QueryFilterOp.md) |  | 
**Value** | **interface{}** |  | 

## Methods

### NewQueryFilter

`func NewQueryFilter(field QueryFilterField, operation QueryFilterOp, value interface{}, ) *QueryFilter`

NewQueryFilter instantiates a new QueryFilter object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewQueryFilterWithDefaults

`func NewQueryFilterWithDefaults() *QueryFilter`

NewQueryFilterWithDefaults instantiates a new QueryFilter object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetField

`func (o *QueryFilter) GetField() QueryFilterField`

GetField returns the Field field if non-nil, zero value otherwise.

### GetFieldOk

`func (o *QueryFilter) GetFieldOk() (*QueryFilterField, bool)`

GetFieldOk returns a tuple with the Field field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetField

`func (o *QueryFilter) SetField(v QueryFilterField)`

SetField sets Field field to given value.


### GetOperation

`func (o *QueryFilter) GetOperation() QueryFilterOp`

GetOperation returns the Operation field if non-nil, zero value otherwise.

### GetOperationOk

`func (o *QueryFilter) GetOperationOk() (*QueryFilterOp, bool)`

GetOperationOk returns a tuple with the Operation field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOperation

`func (o *QueryFilter) SetOperation(v QueryFilterOp)`

SetOperation sets Operation field to given value.


### GetValue

`func (o *QueryFilter) GetValue() interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *QueryFilter) GetValueOk() (*interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *QueryFilter) SetValue(v interface{})`

SetValue sets Value field to given value.


### SetValueNil

`func (o *QueryFilter) SetValueNil(b bool)`

 SetValueNil sets the value for Value to be an explicit nil

### UnsetValue
`func (o *QueryFilter) UnsetValue()`

UnsetValue ensures that no value is present for Value, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


