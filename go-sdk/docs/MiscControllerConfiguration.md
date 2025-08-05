# MiscControllerConfiguration

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uuid** | Pointer to **string** |  | [optional] 
**Version** | Pointer to **string** |  | [optional] 
**CommitId** | Pointer to **string** |  | [optional] 
**CommitDate** | Pointer to **time.Time** |  | [optional] 
**IsCustomDashboardsEnabled** | Pointer to **bool** |  | [optional] 
**IsTaskRunEnabled** | Pointer to **bool** |  | [optional] 
**IsAnonymousUsageEnabled** | Pointer to **bool** |  | [optional] 
**IsTemplateEnabled** | Pointer to **bool** |  | [optional] 
**Environment** | Pointer to [**MiscControllerEnvironment**](MiscControllerEnvironment.md) |  | [optional] 
**Url** | Pointer to **string** |  | [optional] 
**Preview** | Pointer to [**MiscControllerPreview**](MiscControllerPreview.md) |  | [optional] 
**SystemNamespace** | Pointer to **string** |  | [optional] 
**HiddenLabelsPrefixes** | Pointer to **[]string** |  | [optional] 
**ResourceToFilters** | Pointer to [**[]QueryFilterResourceField**](QueryFilterResourceField.md) |  | [optional] 
**IsAiEnabled** | Pointer to **bool** |  | [optional] 
**IsBasicAuthInitialized** | Pointer to **bool** |  | [optional] 

## Methods

### NewMiscControllerConfiguration

`func NewMiscControllerConfiguration() *MiscControllerConfiguration`

NewMiscControllerConfiguration instantiates a new MiscControllerConfiguration object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMiscControllerConfigurationWithDefaults

`func NewMiscControllerConfigurationWithDefaults() *MiscControllerConfiguration`

NewMiscControllerConfigurationWithDefaults instantiates a new MiscControllerConfiguration object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUuid

`func (o *MiscControllerConfiguration) GetUuid() string`

GetUuid returns the Uuid field if non-nil, zero value otherwise.

### GetUuidOk

`func (o *MiscControllerConfiguration) GetUuidOk() (*string, bool)`

GetUuidOk returns a tuple with the Uuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUuid

`func (o *MiscControllerConfiguration) SetUuid(v string)`

SetUuid sets Uuid field to given value.

### HasUuid

`func (o *MiscControllerConfiguration) HasUuid() bool`

HasUuid returns a boolean if a field has been set.

### GetVersion

`func (o *MiscControllerConfiguration) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *MiscControllerConfiguration) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *MiscControllerConfiguration) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *MiscControllerConfiguration) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetCommitId

`func (o *MiscControllerConfiguration) GetCommitId() string`

GetCommitId returns the CommitId field if non-nil, zero value otherwise.

### GetCommitIdOk

`func (o *MiscControllerConfiguration) GetCommitIdOk() (*string, bool)`

GetCommitIdOk returns a tuple with the CommitId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCommitId

`func (o *MiscControllerConfiguration) SetCommitId(v string)`

SetCommitId sets CommitId field to given value.

### HasCommitId

`func (o *MiscControllerConfiguration) HasCommitId() bool`

HasCommitId returns a boolean if a field has been set.

### GetCommitDate

`func (o *MiscControllerConfiguration) GetCommitDate() time.Time`

GetCommitDate returns the CommitDate field if non-nil, zero value otherwise.

### GetCommitDateOk

`func (o *MiscControllerConfiguration) GetCommitDateOk() (*time.Time, bool)`

GetCommitDateOk returns a tuple with the CommitDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCommitDate

`func (o *MiscControllerConfiguration) SetCommitDate(v time.Time)`

SetCommitDate sets CommitDate field to given value.

### HasCommitDate

`func (o *MiscControllerConfiguration) HasCommitDate() bool`

HasCommitDate returns a boolean if a field has been set.

### GetIsCustomDashboardsEnabled

`func (o *MiscControllerConfiguration) GetIsCustomDashboardsEnabled() bool`

GetIsCustomDashboardsEnabled returns the IsCustomDashboardsEnabled field if non-nil, zero value otherwise.

### GetIsCustomDashboardsEnabledOk

`func (o *MiscControllerConfiguration) GetIsCustomDashboardsEnabledOk() (*bool, bool)`

GetIsCustomDashboardsEnabledOk returns a tuple with the IsCustomDashboardsEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsCustomDashboardsEnabled

`func (o *MiscControllerConfiguration) SetIsCustomDashboardsEnabled(v bool)`

SetIsCustomDashboardsEnabled sets IsCustomDashboardsEnabled field to given value.

### HasIsCustomDashboardsEnabled

`func (o *MiscControllerConfiguration) HasIsCustomDashboardsEnabled() bool`

HasIsCustomDashboardsEnabled returns a boolean if a field has been set.

### GetIsTaskRunEnabled

`func (o *MiscControllerConfiguration) GetIsTaskRunEnabled() bool`

GetIsTaskRunEnabled returns the IsTaskRunEnabled field if non-nil, zero value otherwise.

### GetIsTaskRunEnabledOk

`func (o *MiscControllerConfiguration) GetIsTaskRunEnabledOk() (*bool, bool)`

GetIsTaskRunEnabledOk returns a tuple with the IsTaskRunEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsTaskRunEnabled

`func (o *MiscControllerConfiguration) SetIsTaskRunEnabled(v bool)`

SetIsTaskRunEnabled sets IsTaskRunEnabled field to given value.

### HasIsTaskRunEnabled

`func (o *MiscControllerConfiguration) HasIsTaskRunEnabled() bool`

HasIsTaskRunEnabled returns a boolean if a field has been set.

### GetIsAnonymousUsageEnabled

`func (o *MiscControllerConfiguration) GetIsAnonymousUsageEnabled() bool`

GetIsAnonymousUsageEnabled returns the IsAnonymousUsageEnabled field if non-nil, zero value otherwise.

### GetIsAnonymousUsageEnabledOk

`func (o *MiscControllerConfiguration) GetIsAnonymousUsageEnabledOk() (*bool, bool)`

GetIsAnonymousUsageEnabledOk returns a tuple with the IsAnonymousUsageEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsAnonymousUsageEnabled

`func (o *MiscControllerConfiguration) SetIsAnonymousUsageEnabled(v bool)`

SetIsAnonymousUsageEnabled sets IsAnonymousUsageEnabled field to given value.

### HasIsAnonymousUsageEnabled

`func (o *MiscControllerConfiguration) HasIsAnonymousUsageEnabled() bool`

HasIsAnonymousUsageEnabled returns a boolean if a field has been set.

### GetIsTemplateEnabled

`func (o *MiscControllerConfiguration) GetIsTemplateEnabled() bool`

GetIsTemplateEnabled returns the IsTemplateEnabled field if non-nil, zero value otherwise.

### GetIsTemplateEnabledOk

`func (o *MiscControllerConfiguration) GetIsTemplateEnabledOk() (*bool, bool)`

GetIsTemplateEnabledOk returns a tuple with the IsTemplateEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsTemplateEnabled

`func (o *MiscControllerConfiguration) SetIsTemplateEnabled(v bool)`

SetIsTemplateEnabled sets IsTemplateEnabled field to given value.

### HasIsTemplateEnabled

`func (o *MiscControllerConfiguration) HasIsTemplateEnabled() bool`

HasIsTemplateEnabled returns a boolean if a field has been set.

### GetEnvironment

`func (o *MiscControllerConfiguration) GetEnvironment() MiscControllerEnvironment`

GetEnvironment returns the Environment field if non-nil, zero value otherwise.

### GetEnvironmentOk

`func (o *MiscControllerConfiguration) GetEnvironmentOk() (*MiscControllerEnvironment, bool)`

GetEnvironmentOk returns a tuple with the Environment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnvironment

`func (o *MiscControllerConfiguration) SetEnvironment(v MiscControllerEnvironment)`

SetEnvironment sets Environment field to given value.

### HasEnvironment

`func (o *MiscControllerConfiguration) HasEnvironment() bool`

HasEnvironment returns a boolean if a field has been set.

### GetUrl

`func (o *MiscControllerConfiguration) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *MiscControllerConfiguration) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *MiscControllerConfiguration) SetUrl(v string)`

SetUrl sets Url field to given value.

### HasUrl

`func (o *MiscControllerConfiguration) HasUrl() bool`

HasUrl returns a boolean if a field has been set.

### GetPreview

`func (o *MiscControllerConfiguration) GetPreview() MiscControllerPreview`

GetPreview returns the Preview field if non-nil, zero value otherwise.

### GetPreviewOk

`func (o *MiscControllerConfiguration) GetPreviewOk() (*MiscControllerPreview, bool)`

GetPreviewOk returns a tuple with the Preview field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPreview

`func (o *MiscControllerConfiguration) SetPreview(v MiscControllerPreview)`

SetPreview sets Preview field to given value.

### HasPreview

`func (o *MiscControllerConfiguration) HasPreview() bool`

HasPreview returns a boolean if a field has been set.

### GetSystemNamespace

`func (o *MiscControllerConfiguration) GetSystemNamespace() string`

GetSystemNamespace returns the SystemNamespace field if non-nil, zero value otherwise.

### GetSystemNamespaceOk

`func (o *MiscControllerConfiguration) GetSystemNamespaceOk() (*string, bool)`

GetSystemNamespaceOk returns a tuple with the SystemNamespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSystemNamespace

`func (o *MiscControllerConfiguration) SetSystemNamespace(v string)`

SetSystemNamespace sets SystemNamespace field to given value.

### HasSystemNamespace

`func (o *MiscControllerConfiguration) HasSystemNamespace() bool`

HasSystemNamespace returns a boolean if a field has been set.

### GetHiddenLabelsPrefixes

`func (o *MiscControllerConfiguration) GetHiddenLabelsPrefixes() []string`

GetHiddenLabelsPrefixes returns the HiddenLabelsPrefixes field if non-nil, zero value otherwise.

### GetHiddenLabelsPrefixesOk

`func (o *MiscControllerConfiguration) GetHiddenLabelsPrefixesOk() (*[]string, bool)`

GetHiddenLabelsPrefixesOk returns a tuple with the HiddenLabelsPrefixes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHiddenLabelsPrefixes

`func (o *MiscControllerConfiguration) SetHiddenLabelsPrefixes(v []string)`

SetHiddenLabelsPrefixes sets HiddenLabelsPrefixes field to given value.

### HasHiddenLabelsPrefixes

`func (o *MiscControllerConfiguration) HasHiddenLabelsPrefixes() bool`

HasHiddenLabelsPrefixes returns a boolean if a field has been set.

### GetResourceToFilters

`func (o *MiscControllerConfiguration) GetResourceToFilters() []QueryFilterResourceField`

GetResourceToFilters returns the ResourceToFilters field if non-nil, zero value otherwise.

### GetResourceToFiltersOk

`func (o *MiscControllerConfiguration) GetResourceToFiltersOk() (*[]QueryFilterResourceField, bool)`

GetResourceToFiltersOk returns a tuple with the ResourceToFilters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceToFilters

`func (o *MiscControllerConfiguration) SetResourceToFilters(v []QueryFilterResourceField)`

SetResourceToFilters sets ResourceToFilters field to given value.

### HasResourceToFilters

`func (o *MiscControllerConfiguration) HasResourceToFilters() bool`

HasResourceToFilters returns a boolean if a field has been set.

### GetIsAiEnabled

`func (o *MiscControllerConfiguration) GetIsAiEnabled() bool`

GetIsAiEnabled returns the IsAiEnabled field if non-nil, zero value otherwise.

### GetIsAiEnabledOk

`func (o *MiscControllerConfiguration) GetIsAiEnabledOk() (*bool, bool)`

GetIsAiEnabledOk returns a tuple with the IsAiEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsAiEnabled

`func (o *MiscControllerConfiguration) SetIsAiEnabled(v bool)`

SetIsAiEnabled sets IsAiEnabled field to given value.

### HasIsAiEnabled

`func (o *MiscControllerConfiguration) HasIsAiEnabled() bool`

HasIsAiEnabled returns a boolean if a field has been set.

### GetIsBasicAuthInitialized

`func (o *MiscControllerConfiguration) GetIsBasicAuthInitialized() bool`

GetIsBasicAuthInitialized returns the IsBasicAuthInitialized field if non-nil, zero value otherwise.

### GetIsBasicAuthInitializedOk

`func (o *MiscControllerConfiguration) GetIsBasicAuthInitializedOk() (*bool, bool)`

GetIsBasicAuthInitializedOk returns a tuple with the IsBasicAuthInitialized field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsBasicAuthInitialized

`func (o *MiscControllerConfiguration) SetIsBasicAuthInitialized(v bool)`

SetIsBasicAuthInitialized sets IsBasicAuthInitialized field to given value.

### HasIsBasicAuthInitialized

`func (o *MiscControllerConfiguration) HasIsBasicAuthInitialized() bool`

HasIsBasicAuthInitialized returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


