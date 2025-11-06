# Assertion

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Value** | [**string**](PropertyObject.md) |  | 
**TaskId** | Pointer to **string** |  | [optional] 
**ErrorMessage** | Pointer to [**string**](PropertyString.md) |  | [optional] 
**Description** | Pointer to [**string**](PropertyString.md) |  | [optional] 
**EndsWith** | Pointer to [**string**](PropertyString.md) |  | [optional] 
**StartsWith** | Pointer to [**string**](PropertyString.md) |  | [optional] 
**Contains** | Pointer to [**string**](PropertyString.md) |  | [optional] 
**EqualTo** | Pointer to [**string**](PropertyObject.md) |  | [optional] 
**NotEqualTo** | Pointer to [**string**](PropertyObject.md) |  | [optional] 
**GreaterThan** | Pointer to [**string**](PropertyDouble.md) |  | [optional] 
**GreaterThanOrEqualTo** | Pointer to [**string**](PropertyDouble.md) |  | [optional] 
**LessThan** | Pointer to [**string**](PropertyDouble.md) |  | [optional] 
**LessThanOrEqualTo** | Pointer to [**string**](PropertyDouble.md) |  | [optional] 
**In** | Pointer to [**string**](PropertyListString.md) |  | [optional] 
**NotIn** | Pointer to [**string**](PropertyListString.md) |  | [optional] 
**IsNull** | Pointer to [**string**](PropertyBoolean.md) |  | [optional] 
**IsNotNull** | Pointer to [**string**](PropertyBoolean.md) |  | [optional] 

## Methods

### NewAssertion

`func NewAssertion(value string, ) *Assertion`

NewAssertion instantiates a new Assertion object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssertionWithDefaults

`func NewAssertionWithDefaults() *Assertion`

NewAssertionWithDefaults instantiates a new Assertion object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetValue

`func (o *Assertion) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *Assertion) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *Assertion) SetValue(v string)`

SetValue sets Value field to given value.


### GetTaskId

`func (o *Assertion) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *Assertion) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *Assertion) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.

### HasTaskId

`func (o *Assertion) HasTaskId() bool`

HasTaskId returns a boolean if a field has been set.

### GetErrorMessage

`func (o *Assertion) GetErrorMessage() string`

GetErrorMessage returns the ErrorMessage field if non-nil, zero value otherwise.

### GetErrorMessageOk

`func (o *Assertion) GetErrorMessageOk() (*string, bool)`

GetErrorMessageOk returns a tuple with the ErrorMessage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrorMessage

`func (o *Assertion) SetErrorMessage(v string)`

SetErrorMessage sets ErrorMessage field to given value.

### HasErrorMessage

`func (o *Assertion) HasErrorMessage() bool`

HasErrorMessage returns a boolean if a field has been set.

### GetDescription

`func (o *Assertion) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Assertion) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Assertion) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Assertion) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEndsWith

`func (o *Assertion) GetEndsWith() string`

GetEndsWith returns the EndsWith field if non-nil, zero value otherwise.

### GetEndsWithOk

`func (o *Assertion) GetEndsWithOk() (*string, bool)`

GetEndsWithOk returns a tuple with the EndsWith field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndsWith

`func (o *Assertion) SetEndsWith(v string)`

SetEndsWith sets EndsWith field to given value.

### HasEndsWith

`func (o *Assertion) HasEndsWith() bool`

HasEndsWith returns a boolean if a field has been set.

### GetStartsWith

`func (o *Assertion) GetStartsWith() string`

GetStartsWith returns the StartsWith field if non-nil, zero value otherwise.

### GetStartsWithOk

`func (o *Assertion) GetStartsWithOk() (*string, bool)`

GetStartsWithOk returns a tuple with the StartsWith field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartsWith

`func (o *Assertion) SetStartsWith(v string)`

SetStartsWith sets StartsWith field to given value.

### HasStartsWith

`func (o *Assertion) HasStartsWith() bool`

HasStartsWith returns a boolean if a field has been set.

### GetContains

`func (o *Assertion) GetContains() string`

GetContains returns the Contains field if non-nil, zero value otherwise.

### GetContainsOk

`func (o *Assertion) GetContainsOk() (*string, bool)`

GetContainsOk returns a tuple with the Contains field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetContains

`func (o *Assertion) SetContains(v string)`

SetContains sets Contains field to given value.

### HasContains

`func (o *Assertion) HasContains() bool`

HasContains returns a boolean if a field has been set.

### GetEqualTo

`func (o *Assertion) GetEqualTo() string`

GetEqualTo returns the EqualTo field if non-nil, zero value otherwise.

### GetEqualToOk

`func (o *Assertion) GetEqualToOk() (*string, bool)`

GetEqualToOk returns a tuple with the EqualTo field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEqualTo

`func (o *Assertion) SetEqualTo(v string)`

SetEqualTo sets EqualTo field to given value.

### HasEqualTo

`func (o *Assertion) HasEqualTo() bool`

HasEqualTo returns a boolean if a field has been set.

### GetNotEqualTo

`func (o *Assertion) GetNotEqualTo() string`

GetNotEqualTo returns the NotEqualTo field if non-nil, zero value otherwise.

### GetNotEqualToOk

`func (o *Assertion) GetNotEqualToOk() (*string, bool)`

GetNotEqualToOk returns a tuple with the NotEqualTo field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNotEqualTo

`func (o *Assertion) SetNotEqualTo(v string)`

SetNotEqualTo sets NotEqualTo field to given value.

### HasNotEqualTo

`func (o *Assertion) HasNotEqualTo() bool`

HasNotEqualTo returns a boolean if a field has been set.

### GetGreaterThan

`func (o *Assertion) GetGreaterThan() string`

GetGreaterThan returns the GreaterThan field if non-nil, zero value otherwise.

### GetGreaterThanOk

`func (o *Assertion) GetGreaterThanOk() (*string, bool)`

GetGreaterThanOk returns a tuple with the GreaterThan field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGreaterThan

`func (o *Assertion) SetGreaterThan(v string)`

SetGreaterThan sets GreaterThan field to given value.

### HasGreaterThan

`func (o *Assertion) HasGreaterThan() bool`

HasGreaterThan returns a boolean if a field has been set.

### GetGreaterThanOrEqualTo

`func (o *Assertion) GetGreaterThanOrEqualTo() string`

GetGreaterThanOrEqualTo returns the GreaterThanOrEqualTo field if non-nil, zero value otherwise.

### GetGreaterThanOrEqualToOk

`func (o *Assertion) GetGreaterThanOrEqualToOk() (*string, bool)`

GetGreaterThanOrEqualToOk returns a tuple with the GreaterThanOrEqualTo field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGreaterThanOrEqualTo

`func (o *Assertion) SetGreaterThanOrEqualTo(v string)`

SetGreaterThanOrEqualTo sets GreaterThanOrEqualTo field to given value.

### HasGreaterThanOrEqualTo

`func (o *Assertion) HasGreaterThanOrEqualTo() bool`

HasGreaterThanOrEqualTo returns a boolean if a field has been set.

### GetLessThan

`func (o *Assertion) GetLessThan() string`

GetLessThan returns the LessThan field if non-nil, zero value otherwise.

### GetLessThanOk

`func (o *Assertion) GetLessThanOk() (*string, bool)`

GetLessThanOk returns a tuple with the LessThan field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLessThan

`func (o *Assertion) SetLessThan(v string)`

SetLessThan sets LessThan field to given value.

### HasLessThan

`func (o *Assertion) HasLessThan() bool`

HasLessThan returns a boolean if a field has been set.

### GetLessThanOrEqualTo

`func (o *Assertion) GetLessThanOrEqualTo() string`

GetLessThanOrEqualTo returns the LessThanOrEqualTo field if non-nil, zero value otherwise.

### GetLessThanOrEqualToOk

`func (o *Assertion) GetLessThanOrEqualToOk() (*string, bool)`

GetLessThanOrEqualToOk returns a tuple with the LessThanOrEqualTo field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLessThanOrEqualTo

`func (o *Assertion) SetLessThanOrEqualTo(v string)`

SetLessThanOrEqualTo sets LessThanOrEqualTo field to given value.

### HasLessThanOrEqualTo

`func (o *Assertion) HasLessThanOrEqualTo() bool`

HasLessThanOrEqualTo returns a boolean if a field has been set.

### GetIn

`func (o *Assertion) GetIn() string`

GetIn returns the In field if non-nil, zero value otherwise.

### GetInOk

`func (o *Assertion) GetInOk() (*string, bool)`

GetInOk returns a tuple with the In field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIn

`func (o *Assertion) SetIn(v string)`

SetIn sets In field to given value.

### HasIn

`func (o *Assertion) HasIn() bool`

HasIn returns a boolean if a field has been set.

### GetNotIn

`func (o *Assertion) GetNotIn() string`

GetNotIn returns the NotIn field if non-nil, zero value otherwise.

### GetNotInOk

`func (o *Assertion) GetNotInOk() (*string, bool)`

GetNotInOk returns a tuple with the NotIn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNotIn

`func (o *Assertion) SetNotIn(v string)`

SetNotIn sets NotIn field to given value.

### HasNotIn

`func (o *Assertion) HasNotIn() bool`

HasNotIn returns a boolean if a field has been set.

### GetIsNull

`func (o *Assertion) GetIsNull() string`

GetIsNull returns the IsNull field if non-nil, zero value otherwise.

### GetIsNullOk

`func (o *Assertion) GetIsNullOk() (*string, bool)`

GetIsNullOk returns a tuple with the IsNull field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsNull

`func (o *Assertion) SetIsNull(v string)`

SetIsNull sets IsNull field to given value.

### HasIsNull

`func (o *Assertion) HasIsNull() bool`

HasIsNull returns a boolean if a field has been set.

### GetIsNotNull

`func (o *Assertion) GetIsNotNull() string`

GetIsNotNull returns the IsNotNull field if non-nil, zero value otherwise.

### GetIsNotNullOk

`func (o *Assertion) GetIsNotNullOk() (*string, bool)`

GetIsNotNullOk returns a tuple with the IsNotNull field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsNotNull

`func (o *Assertion) SetIsNotNull(v string)`

SetIsNotNull sets IsNotNull field to given value.

### HasIsNotNull

`func (o *Assertion) HasIsNotNull() bool`

HasIsNotNull returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


