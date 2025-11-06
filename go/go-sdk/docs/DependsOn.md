# DependsOn

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Inputs** | Pointer to **[]string** |  | [optional] 
**Condition** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewDependsOn

`func NewDependsOn() *DependsOn`

NewDependsOn instantiates a new DependsOn object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDependsOnWithDefaults

`func NewDependsOnWithDefaults() *DependsOn`

NewDependsOnWithDefaults instantiates a new DependsOn object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetInputs

`func (o *DependsOn) GetInputs() []string`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *DependsOn) GetInputsOk() (*[]string, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *DependsOn) SetInputs(v []string)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *DependsOn) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### SetInputsNil

`func (o *DependsOn) SetInputsNil(b bool)`

 SetInputsNil sets the value for Inputs to be an explicit nil

### UnsetInputs
`func (o *DependsOn) UnsetInputs()`

UnsetInputs ensures that no value is present for Inputs, not even an explicit nil
### GetCondition

`func (o *DependsOn) GetCondition() string`

GetCondition returns the Condition field if non-nil, zero value otherwise.

### GetConditionOk

`func (o *DependsOn) GetConditionOk() (*string, bool)`

GetConditionOk returns a tuple with the Condition field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCondition

`func (o *DependsOn) SetCondition(v string)`

SetCondition sets Condition field to given value.

### HasCondition

`func (o *DependsOn) HasCondition() bool`

HasCondition returns a boolean if a field has been set.

### SetConditionNil

`func (o *DependsOn) SetConditionNil(b bool)`

 SetConditionNil sets the value for Condition to be an explicit nil

### UnsetCondition
`func (o *DependsOn) UnsetCondition()`

UnsetCondition ensures that no value is present for Condition, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


