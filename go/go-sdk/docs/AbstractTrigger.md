# AbstractTrigger

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**MinLogLevel** | Pointer to [**Level**](Level.md) |  | [optional] 
**Id** | **string** |  | 
**Type** | **string** |  | 
**Version** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Conditions** | Pointer to [**[]Condition**](Condition.md) |  | [optional] 
**Disabled** | Pointer to **bool** |  | [optional] [default to false]
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**LogLevel** | Pointer to [**Level**](Level.md) |  | [optional] 
**Labels** | Pointer to [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  | [optional] 
**StopAfter** | Pointer to [**[]StateType**](StateType.md) |  | [optional] 
**LogToFile** | Pointer to **bool** |  | [optional] 
**FailOnTriggerError** | Pointer to **bool** |  | [optional] 

## Methods

### NewAbstractTrigger

`func NewAbstractTrigger(id string, type_ string, ) *AbstractTrigger`

NewAbstractTrigger instantiates a new AbstractTrigger object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractTriggerWithDefaults

`func NewAbstractTriggerWithDefaults() *AbstractTrigger`

NewAbstractTriggerWithDefaults instantiates a new AbstractTrigger object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMinLogLevel

`func (o *AbstractTrigger) GetMinLogLevel() Level`

GetMinLogLevel returns the MinLogLevel field if non-nil, zero value otherwise.

### GetMinLogLevelOk

`func (o *AbstractTrigger) GetMinLogLevelOk() (*Level, bool)`

GetMinLogLevelOk returns a tuple with the MinLogLevel field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMinLogLevel

`func (o *AbstractTrigger) SetMinLogLevel(v Level)`

SetMinLogLevel sets MinLogLevel field to given value.

### HasMinLogLevel

`func (o *AbstractTrigger) HasMinLogLevel() bool`

HasMinLogLevel returns a boolean if a field has been set.

### GetId

`func (o *AbstractTrigger) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AbstractTrigger) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AbstractTrigger) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *AbstractTrigger) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AbstractTrigger) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AbstractTrigger) SetType(v string)`

SetType sets Type field to given value.


### GetVersion

`func (o *AbstractTrigger) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *AbstractTrigger) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *AbstractTrigger) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *AbstractTrigger) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetDescription

`func (o *AbstractTrigger) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *AbstractTrigger) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *AbstractTrigger) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *AbstractTrigger) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetConditions

`func (o *AbstractTrigger) GetConditions() []Condition`

GetConditions returns the Conditions field if non-nil, zero value otherwise.

### GetConditionsOk

`func (o *AbstractTrigger) GetConditionsOk() (*[]Condition, bool)`

GetConditionsOk returns a tuple with the Conditions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConditions

`func (o *AbstractTrigger) SetConditions(v []Condition)`

SetConditions sets Conditions field to given value.

### HasConditions

`func (o *AbstractTrigger) HasConditions() bool`

HasConditions returns a boolean if a field has been set.

### GetDisabled

`func (o *AbstractTrigger) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *AbstractTrigger) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *AbstractTrigger) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *AbstractTrigger) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *AbstractTrigger) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *AbstractTrigger) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *AbstractTrigger) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *AbstractTrigger) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetLogLevel

`func (o *AbstractTrigger) GetLogLevel() Level`

GetLogLevel returns the LogLevel field if non-nil, zero value otherwise.

### GetLogLevelOk

`func (o *AbstractTrigger) GetLogLevelOk() (*Level, bool)`

GetLogLevelOk returns a tuple with the LogLevel field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogLevel

`func (o *AbstractTrigger) SetLogLevel(v Level)`

SetLogLevel sets LogLevel field to given value.

### HasLogLevel

`func (o *AbstractTrigger) HasLogLevel() bool`

HasLogLevel returns a boolean if a field has been set.

### GetLabels

`func (o *AbstractTrigger) GetLabels() TheLabelsToPassToTheExecutionCreated`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *AbstractTrigger) GetLabelsOk() (*TheLabelsToPassToTheExecutionCreated, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *AbstractTrigger) SetLabels(v TheLabelsToPassToTheExecutionCreated)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *AbstractTrigger) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetStopAfter

`func (o *AbstractTrigger) GetStopAfter() []StateType`

GetStopAfter returns the StopAfter field if non-nil, zero value otherwise.

### GetStopAfterOk

`func (o *AbstractTrigger) GetStopAfterOk() (*[]StateType, bool)`

GetStopAfterOk returns a tuple with the StopAfter field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStopAfter

`func (o *AbstractTrigger) SetStopAfter(v []StateType)`

SetStopAfter sets StopAfter field to given value.

### HasStopAfter

`func (o *AbstractTrigger) HasStopAfter() bool`

HasStopAfter returns a boolean if a field has been set.

### GetLogToFile

`func (o *AbstractTrigger) GetLogToFile() bool`

GetLogToFile returns the LogToFile field if non-nil, zero value otherwise.

### GetLogToFileOk

`func (o *AbstractTrigger) GetLogToFileOk() (*bool, bool)`

GetLogToFileOk returns a tuple with the LogToFile field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogToFile

`func (o *AbstractTrigger) SetLogToFile(v bool)`

SetLogToFile sets LogToFile field to given value.

### HasLogToFile

`func (o *AbstractTrigger) HasLogToFile() bool`

HasLogToFile returns a boolean if a field has been set.

### GetFailOnTriggerError

`func (o *AbstractTrigger) GetFailOnTriggerError() bool`

GetFailOnTriggerError returns the FailOnTriggerError field if non-nil, zero value otherwise.

### GetFailOnTriggerErrorOk

`func (o *AbstractTrigger) GetFailOnTriggerErrorOk() (*bool, bool)`

GetFailOnTriggerErrorOk returns a tuple with the FailOnTriggerError field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFailOnTriggerError

`func (o *AbstractTrigger) SetFailOnTriggerError(v bool)`

SetFailOnTriggerError sets FailOnTriggerError field to given value.

### HasFailOnTriggerError

`func (o *AbstractTrigger) HasFailOnTriggerError() bool`

HasFailOnTriggerError returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


