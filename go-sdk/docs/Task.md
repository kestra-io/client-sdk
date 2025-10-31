# Task

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Version** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Retry** | Pointer to **map[string]interface{}** |  | [optional] 
**Timeout** | Pointer to [**string**](PropertyDuration.md) |  | [optional] 
**Disabled** | Pointer to **bool** |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**LogLevel** | Pointer to [**Level**](Level.md) |  | [optional] 
**AllowFailure** | Pointer to **bool** |  | [optional] 
**LogToFile** | Pointer to **bool** |  | [optional] 
**RunIf** | Pointer to **string** |  | [optional] 
**AllowWarning** | Pointer to **bool** |  | [optional] 
**TaskCache** | Pointer to [**Cache**](Cache.md) |  | [optional] 

## Methods

### NewTask

`func NewTask(id string, type_ string, ) *Task`

NewTask instantiates a new Task object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTaskWithDefaults

`func NewTaskWithDefaults() *Task`

NewTaskWithDefaults instantiates a new Task object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Task) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Task) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Task) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *Task) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *Task) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *Task) SetType(v string)`

SetType sets Type field to given value.


### GetVersion

`func (o *Task) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *Task) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *Task) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *Task) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetDescription

`func (o *Task) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Task) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Task) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Task) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetRetry

`func (o *Task) GetRetry() map[string]interface{}`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *Task) GetRetryOk() (*map[string]interface{}, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *Task) SetRetry(v map[string]interface{})`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *Task) HasRetry() bool`

HasRetry returns a boolean if a field has been set.

### GetTimeout

`func (o *Task) GetTimeout() string`

GetTimeout returns the Timeout field if non-nil, zero value otherwise.

### GetTimeoutOk

`func (o *Task) GetTimeoutOk() (*string, bool)`

GetTimeoutOk returns a tuple with the Timeout field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimeout

`func (o *Task) SetTimeout(v string)`

SetTimeout sets Timeout field to given value.

### HasTimeout

`func (o *Task) HasTimeout() bool`

HasTimeout returns a boolean if a field has been set.

### GetDisabled

`func (o *Task) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *Task) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *Task) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *Task) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *Task) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *Task) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *Task) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *Task) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetLogLevel

`func (o *Task) GetLogLevel() Level`

GetLogLevel returns the LogLevel field if non-nil, zero value otherwise.

### GetLogLevelOk

`func (o *Task) GetLogLevelOk() (*Level, bool)`

GetLogLevelOk returns a tuple with the LogLevel field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogLevel

`func (o *Task) SetLogLevel(v Level)`

SetLogLevel sets LogLevel field to given value.

### HasLogLevel

`func (o *Task) HasLogLevel() bool`

HasLogLevel returns a boolean if a field has been set.

### GetAllowFailure

`func (o *Task) GetAllowFailure() bool`

GetAllowFailure returns the AllowFailure field if non-nil, zero value otherwise.

### GetAllowFailureOk

`func (o *Task) GetAllowFailureOk() (*bool, bool)`

GetAllowFailureOk returns a tuple with the AllowFailure field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowFailure

`func (o *Task) SetAllowFailure(v bool)`

SetAllowFailure sets AllowFailure field to given value.

### HasAllowFailure

`func (o *Task) HasAllowFailure() bool`

HasAllowFailure returns a boolean if a field has been set.

### GetLogToFile

`func (o *Task) GetLogToFile() bool`

GetLogToFile returns the LogToFile field if non-nil, zero value otherwise.

### GetLogToFileOk

`func (o *Task) GetLogToFileOk() (*bool, bool)`

GetLogToFileOk returns a tuple with the LogToFile field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogToFile

`func (o *Task) SetLogToFile(v bool)`

SetLogToFile sets LogToFile field to given value.

### HasLogToFile

`func (o *Task) HasLogToFile() bool`

HasLogToFile returns a boolean if a field has been set.

### GetRunIf

`func (o *Task) GetRunIf() string`

GetRunIf returns the RunIf field if non-nil, zero value otherwise.

### GetRunIfOk

`func (o *Task) GetRunIfOk() (*string, bool)`

GetRunIfOk returns a tuple with the RunIf field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRunIf

`func (o *Task) SetRunIf(v string)`

SetRunIf sets RunIf field to given value.

### HasRunIf

`func (o *Task) HasRunIf() bool`

HasRunIf returns a boolean if a field has been set.

### GetAllowWarning

`func (o *Task) GetAllowWarning() bool`

GetAllowWarning returns the AllowWarning field if non-nil, zero value otherwise.

### GetAllowWarningOk

`func (o *Task) GetAllowWarningOk() (*bool, bool)`

GetAllowWarningOk returns a tuple with the AllowWarning field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowWarning

`func (o *Task) SetAllowWarning(v bool)`

SetAllowWarning sets AllowWarning field to given value.

### HasAllowWarning

`func (o *Task) HasAllowWarning() bool`

HasAllowWarning returns a boolean if a field has been set.

### GetTaskCache

`func (o *Task) GetTaskCache() Cache`

GetTaskCache returns the TaskCache field if non-nil, zero value otherwise.

### GetTaskCacheOk

`func (o *Task) GetTaskCacheOk() (*Cache, bool)`

GetTaskCacheOk returns a tuple with the TaskCache field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskCache

`func (o *Task) SetTaskCache(v Cache)`

SetTaskCache sets TaskCache field to given value.

### HasTaskCache

`func (o *Task) HasTaskCache() bool`

HasTaskCache returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


