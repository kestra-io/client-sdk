# QueryFilterResourceField

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | Pointer to **string** |  | [optional] 
**Fields** | Pointer to [**[]QueryFilterFieldOp**](QueryFilterFieldOp.md) |  | [optional] 

## Methods

### NewQueryFilterResourceField

`func NewQueryFilterResourceField() *QueryFilterResourceField`

NewQueryFilterResourceField instantiates a new QueryFilterResourceField object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewQueryFilterResourceFieldWithDefaults

`func NewQueryFilterResourceFieldWithDefaults() *QueryFilterResourceField`

NewQueryFilterResourceFieldWithDefaults instantiates a new QueryFilterResourceField object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *QueryFilterResourceField) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *QueryFilterResourceField) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *QueryFilterResourceField) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *QueryFilterResourceField) HasName() bool`

HasName returns a boolean if a field has been set.

### GetFields

`func (o *QueryFilterResourceField) GetFields() []QueryFilterFieldOp`

GetFields returns the Fields field if non-nil, zero value otherwise.

### GetFieldsOk

`func (o *QueryFilterResourceField) GetFieldsOk() (*[]QueryFilterFieldOp, bool)`

GetFieldsOk returns a tuple with the Fields field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFields

`func (o *QueryFilterResourceField) SetFields(v []QueryFilterFieldOp)`

SetFields sets Fields field to given value.

### HasFields

`func (o *QueryFilterResourceField) HasFields() bool`

HasFields returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


