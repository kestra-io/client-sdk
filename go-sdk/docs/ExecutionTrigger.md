# ExecutionTrigger

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Variables** | **map[string]map[string]interface{}** |  | 
**LogFile** | **string** |  | 

## Methods

### NewExecutionTrigger

`func NewExecutionTrigger(id string, type_ string, variables map[string]map[string]interface{}, logFile string, ) *ExecutionTrigger`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


