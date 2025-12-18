# Fixtures

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Inputs** | Pointer to **map[string]interface{}** |  | [optional] 
**Files** | Pointer to **map[string]string** |  | [optional] 
**Tasks** | Pointer to [**[]TaskFixture**](TaskFixture.md) |  | [optional] 
**Trigger** | Pointer to [**TriggerFixture**](TriggerFixture.md) |  | [optional] 

## Methods

### NewFixtures

`func NewFixtures() *Fixtures`

NewFixtures instantiates a new Fixtures object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFixturesWithDefaults

`func NewFixturesWithDefaults() *Fixtures`

NewFixturesWithDefaults instantiates a new Fixtures object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetInputs

`func (o *Fixtures) GetInputs() map[string]interface{}`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *Fixtures) GetInputsOk() (*map[string]interface{}, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *Fixtures) SetInputs(v map[string]interface{})`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *Fixtures) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetFiles

`func (o *Fixtures) GetFiles() map[string]string`

GetFiles returns the Files field if non-nil, zero value otherwise.

### GetFilesOk

`func (o *Fixtures) GetFilesOk() (*map[string]string, bool)`

GetFilesOk returns a tuple with the Files field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFiles

`func (o *Fixtures) SetFiles(v map[string]string)`

SetFiles sets Files field to given value.

### HasFiles

`func (o *Fixtures) HasFiles() bool`

HasFiles returns a boolean if a field has been set.

### GetTasks

`func (o *Fixtures) GetTasks() []TaskFixture`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *Fixtures) GetTasksOk() (*[]TaskFixture, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *Fixtures) SetTasks(v []TaskFixture)`

SetTasks sets Tasks field to given value.

### HasTasks

`func (o *Fixtures) HasTasks() bool`

HasTasks returns a boolean if a field has been set.

### GetTrigger

`func (o *Fixtures) GetTrigger() TriggerFixture`

GetTrigger returns the Trigger field if non-nil, zero value otherwise.

### GetTriggerOk

`func (o *Fixtures) GetTriggerOk() (*TriggerFixture, bool)`

GetTriggerOk returns a tuple with the Trigger field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTrigger

`func (o *Fixtures) SetTrigger(v TriggerFixture)`

SetTrigger sets Trigger field to given value.

### HasTrigger

`func (o *Fixtures) HasTrigger() bool`

HasTrigger returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


