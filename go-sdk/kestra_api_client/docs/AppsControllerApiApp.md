# AppsControllerApiApp

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uid** | Pointer to **string** |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Type** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**Tags** | Pointer to **[]string** |  | [optional] 
**Enabled** | Pointer to **bool** |  | [optional] 
**Created** | Pointer to **time.Time** |  | [optional] 
**Updated** | Pointer to **time.Time** |  | [optional] 

## Methods

### NewAppsControllerApiApp

`func NewAppsControllerApiApp() *AppsControllerApiApp`

NewAppsControllerApiApp instantiates a new AppsControllerApiApp object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAppsControllerApiAppWithDefaults

`func NewAppsControllerApiAppWithDefaults() *AppsControllerApiApp`

NewAppsControllerApiAppWithDefaults instantiates a new AppsControllerApiApp object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUid

`func (o *AppsControllerApiApp) GetUid() string`

GetUid returns the Uid field if non-nil, zero value otherwise.

### GetUidOk

`func (o *AppsControllerApiApp) GetUidOk() (*string, bool)`

GetUidOk returns a tuple with the Uid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUid

`func (o *AppsControllerApiApp) SetUid(v string)`

SetUid sets Uid field to given value.

### HasUid

`func (o *AppsControllerApiApp) HasUid() bool`

HasUid returns a boolean if a field has been set.

### GetId

`func (o *AppsControllerApiApp) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AppsControllerApiApp) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AppsControllerApiApp) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *AppsControllerApiApp) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *AppsControllerApiApp) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *AppsControllerApiApp) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *AppsControllerApiApp) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *AppsControllerApiApp) HasName() bool`

HasName returns a boolean if a field has been set.

### GetType

`func (o *AppsControllerApiApp) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AppsControllerApiApp) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AppsControllerApiApp) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *AppsControllerApiApp) HasType() bool`

HasType returns a boolean if a field has been set.

### GetNamespace

`func (o *AppsControllerApiApp) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *AppsControllerApiApp) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *AppsControllerApiApp) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *AppsControllerApiApp) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetFlowId

`func (o *AppsControllerApiApp) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *AppsControllerApiApp) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *AppsControllerApiApp) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *AppsControllerApiApp) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetTags

`func (o *AppsControllerApiApp) GetTags() []string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *AppsControllerApiApp) GetTagsOk() (*[]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *AppsControllerApiApp) SetTags(v []string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *AppsControllerApiApp) HasTags() bool`

HasTags returns a boolean if a field has been set.

### GetEnabled

`func (o *AppsControllerApiApp) GetEnabled() bool`

GetEnabled returns the Enabled field if non-nil, zero value otherwise.

### GetEnabledOk

`func (o *AppsControllerApiApp) GetEnabledOk() (*bool, bool)`

GetEnabledOk returns a tuple with the Enabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnabled

`func (o *AppsControllerApiApp) SetEnabled(v bool)`

SetEnabled sets Enabled field to given value.

### HasEnabled

`func (o *AppsControllerApiApp) HasEnabled() bool`

HasEnabled returns a boolean if a field has been set.

### GetCreated

`func (o *AppsControllerApiApp) GetCreated() time.Time`

GetCreated returns the Created field if non-nil, zero value otherwise.

### GetCreatedOk

`func (o *AppsControllerApiApp) GetCreatedOk() (*time.Time, bool)`

GetCreatedOk returns a tuple with the Created field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreated

`func (o *AppsControllerApiApp) SetCreated(v time.Time)`

SetCreated sets Created field to given value.

### HasCreated

`func (o *AppsControllerApiApp) HasCreated() bool`

HasCreated returns a boolean if a field has been set.

### GetUpdated

`func (o *AppsControllerApiApp) GetUpdated() time.Time`

GetUpdated returns the Updated field if non-nil, zero value otherwise.

### GetUpdatedOk

`func (o *AppsControllerApiApp) GetUpdatedOk() (*time.Time, bool)`

GetUpdatedOk returns a tuple with the Updated field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUpdated

`func (o *AppsControllerApiApp) SetUpdated(v time.Time)`

SetUpdated sets Updated field to given value.

### HasUpdated

`func (o *AppsControllerApiApp) HasUpdated() bool`

HasUpdated returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


