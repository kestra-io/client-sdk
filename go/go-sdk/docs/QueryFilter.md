# QueryFilter

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Field** | Pointer to [**QueryFilterField**](QueryFilterField.md) |  | [optional] 
**Operation** | Pointer to [**QueryFilterOp**](QueryFilterOp.md) |  | [optional] 
**Value** | Pointer to **map[string]interface{}** |  | [optional] 

## Methods

### NewQueryFilter

`func NewQueryFilter() *QueryFilter`

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

### HasField

`func (o *QueryFilter) HasField() bool`

HasField returns a boolean if a field has been set.

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

### HasOperation

`func (o *QueryFilter) HasOperation() bool`

HasOperation returns a boolean if a field has been set.

### GetValue

`func (o *QueryFilter) GetValue() map[string]interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *QueryFilter) GetValueOk() (*map[string]interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *QueryFilter) SetValue(v map[string]interface{})`

SetValue sets Value field to given value.

### HasValue

`func (o *QueryFilter) HasValue() bool`

HasValue returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


