# ValidateConstraintViolation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Flow** | **string** |  | 
**Namespace** | **string** |  | 
**Index** | **int32** |  | 
**Constraints** | **string** |  | 
**Outdated** | **bool** |  | 
**DeprecationPaths** | **[]string** |  | 
**Warnings** | **[]string** |  | 
**Infos** | **[]string** |  | 

## Methods

### NewValidateConstraintViolation

`func NewValidateConstraintViolation(flow string, namespace string, index int32, constraints string, outdated bool, deprecationPaths []string, warnings []string, infos []string, ) *ValidateConstraintViolation`

NewValidateConstraintViolation instantiates a new ValidateConstraintViolation object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewValidateConstraintViolationWithDefaults

`func NewValidateConstraintViolationWithDefaults() *ValidateConstraintViolation`

NewValidateConstraintViolationWithDefaults instantiates a new ValidateConstraintViolation object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFlow

`func (o *ValidateConstraintViolation) GetFlow() string`

GetFlow returns the Flow field if non-nil, zero value otherwise.

### GetFlowOk

`func (o *ValidateConstraintViolation) GetFlowOk() (*string, bool)`

GetFlowOk returns a tuple with the Flow field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlow

`func (o *ValidateConstraintViolation) SetFlow(v string)`

SetFlow sets Flow field to given value.


### GetNamespace

`func (o *ValidateConstraintViolation) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ValidateConstraintViolation) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ValidateConstraintViolation) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetIndex

`func (o *ValidateConstraintViolation) GetIndex() int32`

GetIndex returns the Index field if non-nil, zero value otherwise.

### GetIndexOk

`func (o *ValidateConstraintViolation) GetIndexOk() (*int32, bool)`

GetIndexOk returns a tuple with the Index field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIndex

`func (o *ValidateConstraintViolation) SetIndex(v int32)`

SetIndex sets Index field to given value.


### GetConstraints

`func (o *ValidateConstraintViolation) GetConstraints() string`

GetConstraints returns the Constraints field if non-nil, zero value otherwise.

### GetConstraintsOk

`func (o *ValidateConstraintViolation) GetConstraintsOk() (*string, bool)`

GetConstraintsOk returns a tuple with the Constraints field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConstraints

`func (o *ValidateConstraintViolation) SetConstraints(v string)`

SetConstraints sets Constraints field to given value.


### GetOutdated

`func (o *ValidateConstraintViolation) GetOutdated() bool`

GetOutdated returns the Outdated field if non-nil, zero value otherwise.

### GetOutdatedOk

`func (o *ValidateConstraintViolation) GetOutdatedOk() (*bool, bool)`

GetOutdatedOk returns a tuple with the Outdated field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutdated

`func (o *ValidateConstraintViolation) SetOutdated(v bool)`

SetOutdated sets Outdated field to given value.


### GetDeprecationPaths

`func (o *ValidateConstraintViolation) GetDeprecationPaths() []string`

GetDeprecationPaths returns the DeprecationPaths field if non-nil, zero value otherwise.

### GetDeprecationPathsOk

`func (o *ValidateConstraintViolation) GetDeprecationPathsOk() (*[]string, bool)`

GetDeprecationPathsOk returns a tuple with the DeprecationPaths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeprecationPaths

`func (o *ValidateConstraintViolation) SetDeprecationPaths(v []string)`

SetDeprecationPaths sets DeprecationPaths field to given value.


### GetWarnings

`func (o *ValidateConstraintViolation) GetWarnings() []string`

GetWarnings returns the Warnings field if non-nil, zero value otherwise.

### GetWarningsOk

`func (o *ValidateConstraintViolation) GetWarningsOk() (*[]string, bool)`

GetWarningsOk returns a tuple with the Warnings field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWarnings

`func (o *ValidateConstraintViolation) SetWarnings(v []string)`

SetWarnings sets Warnings field to given value.


### GetInfos

`func (o *ValidateConstraintViolation) GetInfos() []string`

GetInfos returns the Infos field if non-nil, zero value otherwise.

### GetInfosOk

`func (o *ValidateConstraintViolation) GetInfosOk() (*[]string, bool)`

GetInfosOk returns a tuple with the Infos field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInfos

`func (o *ValidateConstraintViolation) SetInfos(v []string)`

SetInfos sets Infos field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


