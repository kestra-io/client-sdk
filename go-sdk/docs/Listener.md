# Listener

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Description** | Pointer to **string** |  | [optional] 
**Conditions** | Pointer to [**[]Condition**](Condition.md) |  | [optional] 
**Tasks** | [**[]Task**](Task.md) |  | 

## Methods

### NewListener

`func NewListener(tasks []Task, ) *Listener`

NewListener instantiates a new Listener object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewListenerWithDefaults

`func NewListenerWithDefaults() *Listener`

NewListenerWithDefaults instantiates a new Listener object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDescription

`func (o *Listener) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Listener) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Listener) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Listener) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetConditions

`func (o *Listener) GetConditions() []Condition`

GetConditions returns the Conditions field if non-nil, zero value otherwise.

### GetConditionsOk

`func (o *Listener) GetConditionsOk() (*[]Condition, bool)`

GetConditionsOk returns a tuple with the Conditions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConditions

`func (o *Listener) SetConditions(v []Condition)`

SetConditions sets Conditions field to given value.

### HasConditions

`func (o *Listener) HasConditions() bool`

HasConditions returns a boolean if a field has been set.

### GetTasks

`func (o *Listener) GetTasks() []Task`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *Listener) GetTasksOk() (*[]Task, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *Listener) SetTasks(v []Task)`

SetTasks sets Tasks field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


