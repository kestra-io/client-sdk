# TriggerControllerSetDisabledRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Triggers** | Pointer to [**[]Trigger**](Trigger.md) |  | [optional] 
**Disabled** | Pointer to **bool** |  | [optional] 

## Methods

### NewTriggerControllerSetDisabledRequest

`func NewTriggerControllerSetDisabledRequest() *TriggerControllerSetDisabledRequest`

NewTriggerControllerSetDisabledRequest instantiates a new TriggerControllerSetDisabledRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTriggerControllerSetDisabledRequestWithDefaults

`func NewTriggerControllerSetDisabledRequestWithDefaults() *TriggerControllerSetDisabledRequest`

NewTriggerControllerSetDisabledRequestWithDefaults instantiates a new TriggerControllerSetDisabledRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTriggers

`func (o *TriggerControllerSetDisabledRequest) GetTriggers() []Trigger`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *TriggerControllerSetDisabledRequest) GetTriggersOk() (*[]Trigger, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *TriggerControllerSetDisabledRequest) SetTriggers(v []Trigger)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *TriggerControllerSetDisabledRequest) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.

### GetDisabled

`func (o *TriggerControllerSetDisabledRequest) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *TriggerControllerSetDisabledRequest) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *TriggerControllerSetDisabledRequest) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *TriggerControllerSetDisabledRequest) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


