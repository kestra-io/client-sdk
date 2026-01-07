# TaskFixture

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Value** | Pointer to **string** |  | [optional] 
**State** | Pointer to [**StateType**](StateType.md) |  | [optional] 
**Outputs** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**Assets** | Pointer to [**[]Asset**](Asset.md) |  | [optional] 
**Description** | Pointer to [**string**](PropertyString.md) |  | [optional] 

## Methods

### NewTaskFixture

`func NewTaskFixture(id string, ) *TaskFixture`

NewTaskFixture instantiates a new TaskFixture object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTaskFixtureWithDefaults

`func NewTaskFixtureWithDefaults() *TaskFixture`

NewTaskFixtureWithDefaults instantiates a new TaskFixture object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *TaskFixture) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *TaskFixture) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *TaskFixture) SetId(v string)`

SetId sets Id field to given value.


### GetValue

`func (o *TaskFixture) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *TaskFixture) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *TaskFixture) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *TaskFixture) HasValue() bool`

HasValue returns a boolean if a field has been set.

### GetState

`func (o *TaskFixture) GetState() StateType`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *TaskFixture) GetStateOk() (*StateType, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *TaskFixture) SetState(v StateType)`

SetState sets State field to given value.

### HasState

`func (o *TaskFixture) HasState() bool`

HasState returns a boolean if a field has been set.

### GetOutputs

`func (o *TaskFixture) GetOutputs() map[string]map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *TaskFixture) GetOutputsOk() (*map[string]map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *TaskFixture) SetOutputs(v map[string]map[string]interface{})`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *TaskFixture) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetAssets

`func (o *TaskFixture) GetAssets() []Asset`

GetAssets returns the Assets field if non-nil, zero value otherwise.

### GetAssetsOk

`func (o *TaskFixture) GetAssetsOk() (*[]Asset, bool)`

GetAssetsOk returns a tuple with the Assets field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAssets

`func (o *TaskFixture) SetAssets(v []Asset)`

SetAssets sets Assets field to given value.

### HasAssets

`func (o *TaskFixture) HasAssets() bool`

HasAssets returns a boolean if a field has been set.

### GetDescription

`func (o *TaskFixture) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *TaskFixture) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *TaskFixture) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *TaskFixture) HasDescription() bool`

HasDescription returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


