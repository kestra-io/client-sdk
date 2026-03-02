# KillSwitch

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Name** | **string** |  | 
**TenantId** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**ExecutionIds** | Pointer to **[]string** |  | [optional] 
**StartDate** | **time.Time** |  | 
**EndDate** | Pointer to **time.Time** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**EvaluationType** | [**EvaluationType**](EvaluationType.md) |  | 
**Enabled** | Pointer to **bool** |  | [optional] 
**Deleted** | Pointer to **bool** |  | [optional] 

## Methods

### NewKillSwitch

`func NewKillSwitch(name string, startDate time.Time, evaluationType EvaluationType, ) *KillSwitch`

NewKillSwitch instantiates a new KillSwitch object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewKillSwitchWithDefaults

`func NewKillSwitchWithDefaults() *KillSwitch`

NewKillSwitchWithDefaults instantiates a new KillSwitch object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *KillSwitch) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *KillSwitch) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *KillSwitch) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *KillSwitch) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *KillSwitch) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *KillSwitch) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *KillSwitch) SetName(v string)`

SetName sets Name field to given value.


### GetTenantId

`func (o *KillSwitch) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *KillSwitch) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *KillSwitch) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *KillSwitch) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetNamespace

`func (o *KillSwitch) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *KillSwitch) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *KillSwitch) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *KillSwitch) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetFlowId

`func (o *KillSwitch) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *KillSwitch) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *KillSwitch) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *KillSwitch) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetExecutionIds

`func (o *KillSwitch) GetExecutionIds() []string`

GetExecutionIds returns the ExecutionIds field if non-nil, zero value otherwise.

### GetExecutionIdsOk

`func (o *KillSwitch) GetExecutionIdsOk() (*[]string, bool)`

GetExecutionIdsOk returns a tuple with the ExecutionIds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionIds

`func (o *KillSwitch) SetExecutionIds(v []string)`

SetExecutionIds sets ExecutionIds field to given value.

### HasExecutionIds

`func (o *KillSwitch) HasExecutionIds() bool`

HasExecutionIds returns a boolean if a field has been set.

### GetStartDate

`func (o *KillSwitch) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *KillSwitch) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *KillSwitch) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.


### GetEndDate

`func (o *KillSwitch) GetEndDate() time.Time`

GetEndDate returns the EndDate field if non-nil, zero value otherwise.

### GetEndDateOk

`func (o *KillSwitch) GetEndDateOk() (*time.Time, bool)`

GetEndDateOk returns a tuple with the EndDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEndDate

`func (o *KillSwitch) SetEndDate(v time.Time)`

SetEndDate sets EndDate field to given value.

### HasEndDate

`func (o *KillSwitch) HasEndDate() bool`

HasEndDate returns a boolean if a field has been set.

### GetDescription

`func (o *KillSwitch) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *KillSwitch) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *KillSwitch) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *KillSwitch) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetEvaluationType

`func (o *KillSwitch) GetEvaluationType() EvaluationType`

GetEvaluationType returns the EvaluationType field if non-nil, zero value otherwise.

### GetEvaluationTypeOk

`func (o *KillSwitch) GetEvaluationTypeOk() (*EvaluationType, bool)`

GetEvaluationTypeOk returns a tuple with the EvaluationType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEvaluationType

`func (o *KillSwitch) SetEvaluationType(v EvaluationType)`

SetEvaluationType sets EvaluationType field to given value.


### GetEnabled

`func (o *KillSwitch) GetEnabled() bool`

GetEnabled returns the Enabled field if non-nil, zero value otherwise.

### GetEnabledOk

`func (o *KillSwitch) GetEnabledOk() (*bool, bool)`

GetEnabledOk returns a tuple with the Enabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnabled

`func (o *KillSwitch) SetEnabled(v bool)`

SetEnabled sets Enabled field to given value.

### HasEnabled

`func (o *KillSwitch) HasEnabled() bool`

HasEnabled returns a boolean if a field has been set.

### GetDeleted

`func (o *KillSwitch) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *KillSwitch) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *KillSwitch) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.

### HasDeleted

`func (o *KillSwitch) HasDeleted() bool`

HasDeleted returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


