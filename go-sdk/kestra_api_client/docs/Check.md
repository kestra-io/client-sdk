# Check

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Condition** | **string** |  | 
**Message** | **string** |  | 
**Style** | Pointer to [**CheckStyle**](CheckStyle.md) |  | [optional] 
**Behavior** | Pointer to [**CheckBehavior**](CheckBehavior.md) |  | [optional] 

## Methods

### NewCheck

`func NewCheck(condition string, message string, ) *Check`

NewCheck instantiates a new Check object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewCheckWithDefaults

`func NewCheckWithDefaults() *Check`

NewCheckWithDefaults instantiates a new Check object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetCondition

`func (o *Check) GetCondition() string`

GetCondition returns the Condition field if non-nil, zero value otherwise.

### GetConditionOk

`func (o *Check) GetConditionOk() (*string, bool)`

GetConditionOk returns a tuple with the Condition field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCondition

`func (o *Check) SetCondition(v string)`

SetCondition sets Condition field to given value.


### GetMessage

`func (o *Check) GetMessage() string`

GetMessage returns the Message field if non-nil, zero value otherwise.

### GetMessageOk

`func (o *Check) GetMessageOk() (*string, bool)`

GetMessageOk returns a tuple with the Message field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMessage

`func (o *Check) SetMessage(v string)`

SetMessage sets Message field to given value.


### GetStyle

`func (o *Check) GetStyle() CheckStyle`

GetStyle returns the Style field if non-nil, zero value otherwise.

### GetStyleOk

`func (o *Check) GetStyleOk() (*CheckStyle, bool)`

GetStyleOk returns a tuple with the Style field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStyle

`func (o *Check) SetStyle(v CheckStyle)`

SetStyle sets Style field to given value.

### HasStyle

`func (o *Check) HasStyle() bool`

HasStyle returns a boolean if a field has been set.

### GetBehavior

`func (o *Check) GetBehavior() CheckBehavior`

GetBehavior returns the Behavior field if non-nil, zero value otherwise.

### GetBehaviorOk

`func (o *Check) GetBehaviorOk() (*CheckBehavior, bool)`

GetBehaviorOk returns a tuple with the Behavior field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBehavior

`func (o *Check) SetBehavior(v CheckBehavior)`

SetBehavior sets Behavior field to given value.

### HasBehavior

`func (o *Check) HasBehavior() bool`

HasBehavior returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


