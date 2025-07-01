# QueryFilterResourceField

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Fields** | [**[]QueryFilterFieldOp**](QueryFilterFieldOp.md) |  | 

## Methods

### NewQueryFilterResourceField

`func NewQueryFilterResourceField(name string, fields []QueryFilterFieldOp, ) *QueryFilterResourceField`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


