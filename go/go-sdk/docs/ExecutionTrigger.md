# ExecutionTrigger

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Variables** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**LogFile** | Pointer to **string** |  | [optional] 

## Methods

### NewExecutionTrigger

`func NewExecutionTrigger(id string, type_ string, ) *ExecutionTrigger`

NewExecutionTrigger instantiates a new ExecutionTrigger object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionTriggerWithDefaults

`func NewExecutionTriggerWithDefaults() *ExecutionTrigger`

NewExecutionTriggerWithDefaults instantiates a new ExecutionTrigger object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ExecutionTrigger) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ExecutionTrigger) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ExecutionTrigger) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *ExecutionTrigger) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ExecutionTrigger) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ExecutionTrigger) SetType(v string)`

SetType sets Type field to given value.


### GetVariables

`func (o *ExecutionTrigger) GetVariables() map[string]map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *ExecutionTrigger) GetVariablesOk() (*map[string]map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *ExecutionTrigger) SetVariables(v map[string]map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *ExecutionTrigger) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetLogFile

`func (o *ExecutionTrigger) GetLogFile() string`

GetLogFile returns the LogFile field if non-nil, zero value otherwise.

### GetLogFileOk

`func (o *ExecutionTrigger) GetLogFileOk() (*string, bool)`

GetLogFileOk returns a tuple with the LogFile field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogFile

`func (o *ExecutionTrigger) SetLogFile(v string)`

SetLogFile sets LogFile field to given value.

### HasLogFile

`func (o *ExecutionTrigger) HasLogFile() bool`

HasLogFile returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


