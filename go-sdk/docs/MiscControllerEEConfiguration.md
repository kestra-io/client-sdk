# MiscControllerEEConfiguration

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uuid** | Pointer to **string** |  | [optional] 
**Version** | Pointer to **string** |  | [optional] 
**Edition** | Pointer to [**MiscControllerEdition**](MiscControllerEdition.md) |  | [optional] 
**CommitId** | Pointer to **string** |  | [optional] 
**CommitDate** | Pointer to **time.Time** |  | [optional] 
**IsCustomDashboardsEnabled** | Pointer to **bool** |  | [optional] 
**IsTaskRunEnabled** | Pointer to **bool** |  | [optional] 
**IsAnonymousUsageEnabled** | Pointer to **bool** |  | [optional] 
**IsUiAnonymousUsageEnabled** | Pointer to **bool** |  | [optional] 
**IsTemplateEnabled** | Pointer to **bool** |  | [optional] 
**Environment** | Pointer to [**MiscControllerEnvironment**](MiscControllerEnvironment.md) |  | [optional] 
**Url** | Pointer to **string** |  | [optional] 
**Preview** | Pointer to [**MiscControllerPreview**](MiscControllerPreview.md) |  | [optional] 
**SystemNamespace** | Pointer to **string** |  | [optional] 
**HiddenLabelsPrefixes** | Pointer to **[]string** |  | [optional] 
**ResourceToFilters** | Pointer to [**[]QueryFilterResourceField**](QueryFilterResourceField.md) |  | [optional] 
**IsAiEnabled** | Pointer to **bool** |  | [optional] 
**IsBasicAuthInitialized** | Pointer to **bool** |  | [optional] 
**Tenants** | Pointer to [**MiscControllerTenantConfigurationInfo**](MiscControllerTenantConfigurationInfo.md) |  | [optional] 
**SecretsEnabled** | Pointer to **bool** |  | [optional] 
**SupportedStorages** | Pointer to [**[]MiscControllerPluginIdAndVersion**](MiscControllerPluginIdAndVersion.md) |  | [optional] 
**SupportedSecrets** | Pointer to [**[]MiscControllerPluginIdAndVersion**](MiscControllerPluginIdAndVersion.md) |  | [optional] 
**PluginManagementEnabled** | Pointer to **bool** |  | [optional] 
**PluginCustomEnabled** | Pointer to **bool** |  | [optional] 
**Banner** | Pointer to [**Banner**](Banner.md) |  | [optional] 
**MailServiceEnabled** | Pointer to **bool** |  | [optional] 
**OutputsInInternalStorageEnabled** | Pointer to **bool** |  | [optional] 
**LeftSidebar** | Pointer to [**LeftSidebarConfiguration**](LeftSidebarConfiguration.md) |  | [optional] 
**RightSidebar** | Pointer to [**RightSidebarConfiguration**](RightSidebarConfiguration.md) |  | [optional] 
**InMaintenance** | Pointer to **bool** |  | [optional] 
**PasswordRegexp** | Pointer to **string** |  | [optional] 

## Methods

### NewMiscControllerEEConfiguration

`func NewMiscControllerEEConfiguration() *MiscControllerEEConfiguration`

NewMiscControllerEEConfiguration instantiates a new MiscControllerEEConfiguration object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMiscControllerEEConfigurationWithDefaults

`func NewMiscControllerEEConfigurationWithDefaults() *MiscControllerEEConfiguration`

NewMiscControllerEEConfigurationWithDefaults instantiates a new MiscControllerEEConfiguration object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUuid

`func (o *MiscControllerEEConfiguration) GetUuid() string`

GetUuid returns the Uuid field if non-nil, zero value otherwise.

### GetUuidOk

`func (o *MiscControllerEEConfiguration) GetUuidOk() (*string, bool)`

GetUuidOk returns a tuple with the Uuid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUuid

`func (o *MiscControllerEEConfiguration) SetUuid(v string)`

SetUuid sets Uuid field to given value.

### HasUuid

`func (o *MiscControllerEEConfiguration) HasUuid() bool`

HasUuid returns a boolean if a field has been set.

### GetVersion

`func (o *MiscControllerEEConfiguration) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *MiscControllerEEConfiguration) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *MiscControllerEEConfiguration) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *MiscControllerEEConfiguration) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetEdition

`func (o *MiscControllerEEConfiguration) GetEdition() MiscControllerEdition`

GetEdition returns the Edition field if non-nil, zero value otherwise.

### GetEditionOk

`func (o *MiscControllerEEConfiguration) GetEditionOk() (*MiscControllerEdition, bool)`

GetEditionOk returns a tuple with the Edition field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEdition

`func (o *MiscControllerEEConfiguration) SetEdition(v MiscControllerEdition)`

SetEdition sets Edition field to given value.

### HasEdition

`func (o *MiscControllerEEConfiguration) HasEdition() bool`

HasEdition returns a boolean if a field has been set.

### GetCommitId

`func (o *MiscControllerEEConfiguration) GetCommitId() string`

GetCommitId returns the CommitId field if non-nil, zero value otherwise.

### GetCommitIdOk

`func (o *MiscControllerEEConfiguration) GetCommitIdOk() (*string, bool)`

GetCommitIdOk returns a tuple with the CommitId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCommitId

`func (o *MiscControllerEEConfiguration) SetCommitId(v string)`

SetCommitId sets CommitId field to given value.

### HasCommitId

`func (o *MiscControllerEEConfiguration) HasCommitId() bool`

HasCommitId returns a boolean if a field has been set.

### GetCommitDate

`func (o *MiscControllerEEConfiguration) GetCommitDate() time.Time`

GetCommitDate returns the CommitDate field if non-nil, zero value otherwise.

### GetCommitDateOk

`func (o *MiscControllerEEConfiguration) GetCommitDateOk() (*time.Time, bool)`

GetCommitDateOk returns a tuple with the CommitDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCommitDate

`func (o *MiscControllerEEConfiguration) SetCommitDate(v time.Time)`

SetCommitDate sets CommitDate field to given value.

### HasCommitDate

`func (o *MiscControllerEEConfiguration) HasCommitDate() bool`

HasCommitDate returns a boolean if a field has been set.

### GetIsCustomDashboardsEnabled

`func (o *MiscControllerEEConfiguration) GetIsCustomDashboardsEnabled() bool`

GetIsCustomDashboardsEnabled returns the IsCustomDashboardsEnabled field if non-nil, zero value otherwise.

### GetIsCustomDashboardsEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsCustomDashboardsEnabledOk() (*bool, bool)`

GetIsCustomDashboardsEnabledOk returns a tuple with the IsCustomDashboardsEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsCustomDashboardsEnabled

`func (o *MiscControllerEEConfiguration) SetIsCustomDashboardsEnabled(v bool)`

SetIsCustomDashboardsEnabled sets IsCustomDashboardsEnabled field to given value.

### HasIsCustomDashboardsEnabled

`func (o *MiscControllerEEConfiguration) HasIsCustomDashboardsEnabled() bool`

HasIsCustomDashboardsEnabled returns a boolean if a field has been set.

### GetIsTaskRunEnabled

`func (o *MiscControllerEEConfiguration) GetIsTaskRunEnabled() bool`

GetIsTaskRunEnabled returns the IsTaskRunEnabled field if non-nil, zero value otherwise.

### GetIsTaskRunEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsTaskRunEnabledOk() (*bool, bool)`

GetIsTaskRunEnabledOk returns a tuple with the IsTaskRunEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsTaskRunEnabled

`func (o *MiscControllerEEConfiguration) SetIsTaskRunEnabled(v bool)`

SetIsTaskRunEnabled sets IsTaskRunEnabled field to given value.

### HasIsTaskRunEnabled

`func (o *MiscControllerEEConfiguration) HasIsTaskRunEnabled() bool`

HasIsTaskRunEnabled returns a boolean if a field has been set.

### GetIsAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) GetIsAnonymousUsageEnabled() bool`

GetIsAnonymousUsageEnabled returns the IsAnonymousUsageEnabled field if non-nil, zero value otherwise.

### GetIsAnonymousUsageEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsAnonymousUsageEnabledOk() (*bool, bool)`

GetIsAnonymousUsageEnabledOk returns a tuple with the IsAnonymousUsageEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) SetIsAnonymousUsageEnabled(v bool)`

SetIsAnonymousUsageEnabled sets IsAnonymousUsageEnabled field to given value.

### HasIsAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) HasIsAnonymousUsageEnabled() bool`

HasIsAnonymousUsageEnabled returns a boolean if a field has been set.

### GetIsUiAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) GetIsUiAnonymousUsageEnabled() bool`

GetIsUiAnonymousUsageEnabled returns the IsUiAnonymousUsageEnabled field if non-nil, zero value otherwise.

### GetIsUiAnonymousUsageEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsUiAnonymousUsageEnabledOk() (*bool, bool)`

GetIsUiAnonymousUsageEnabledOk returns a tuple with the IsUiAnonymousUsageEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsUiAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) SetIsUiAnonymousUsageEnabled(v bool)`

SetIsUiAnonymousUsageEnabled sets IsUiAnonymousUsageEnabled field to given value.

### HasIsUiAnonymousUsageEnabled

`func (o *MiscControllerEEConfiguration) HasIsUiAnonymousUsageEnabled() bool`

HasIsUiAnonymousUsageEnabled returns a boolean if a field has been set.

### GetIsTemplateEnabled

`func (o *MiscControllerEEConfiguration) GetIsTemplateEnabled() bool`

GetIsTemplateEnabled returns the IsTemplateEnabled field if non-nil, zero value otherwise.

### GetIsTemplateEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsTemplateEnabledOk() (*bool, bool)`

GetIsTemplateEnabledOk returns a tuple with the IsTemplateEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsTemplateEnabled

`func (o *MiscControllerEEConfiguration) SetIsTemplateEnabled(v bool)`

SetIsTemplateEnabled sets IsTemplateEnabled field to given value.

### HasIsTemplateEnabled

`func (o *MiscControllerEEConfiguration) HasIsTemplateEnabled() bool`

HasIsTemplateEnabled returns a boolean if a field has been set.

### GetEnvironment

`func (o *MiscControllerEEConfiguration) GetEnvironment() MiscControllerEnvironment`

GetEnvironment returns the Environment field if non-nil, zero value otherwise.

### GetEnvironmentOk

`func (o *MiscControllerEEConfiguration) GetEnvironmentOk() (*MiscControllerEnvironment, bool)`

GetEnvironmentOk returns a tuple with the Environment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnvironment

`func (o *MiscControllerEEConfiguration) SetEnvironment(v MiscControllerEnvironment)`

SetEnvironment sets Environment field to given value.

### HasEnvironment

`func (o *MiscControllerEEConfiguration) HasEnvironment() bool`

HasEnvironment returns a boolean if a field has been set.

### GetUrl

`func (o *MiscControllerEEConfiguration) GetUrl() string`

GetUrl returns the Url field if non-nil, zero value otherwise.

### GetUrlOk

`func (o *MiscControllerEEConfiguration) GetUrlOk() (*string, bool)`

GetUrlOk returns a tuple with the Url field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrl

`func (o *MiscControllerEEConfiguration) SetUrl(v string)`

SetUrl sets Url field to given value.

### HasUrl

`func (o *MiscControllerEEConfiguration) HasUrl() bool`

HasUrl returns a boolean if a field has been set.

### GetPreview

`func (o *MiscControllerEEConfiguration) GetPreview() MiscControllerPreview`

GetPreview returns the Preview field if non-nil, zero value otherwise.

### GetPreviewOk

`func (o *MiscControllerEEConfiguration) GetPreviewOk() (*MiscControllerPreview, bool)`

GetPreviewOk returns a tuple with the Preview field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPreview

`func (o *MiscControllerEEConfiguration) SetPreview(v MiscControllerPreview)`

SetPreview sets Preview field to given value.

### HasPreview

`func (o *MiscControllerEEConfiguration) HasPreview() bool`

HasPreview returns a boolean if a field has been set.

### GetSystemNamespace

`func (o *MiscControllerEEConfiguration) GetSystemNamespace() string`

GetSystemNamespace returns the SystemNamespace field if non-nil, zero value otherwise.

### GetSystemNamespaceOk

`func (o *MiscControllerEEConfiguration) GetSystemNamespaceOk() (*string, bool)`

GetSystemNamespaceOk returns a tuple with the SystemNamespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSystemNamespace

`func (o *MiscControllerEEConfiguration) SetSystemNamespace(v string)`

SetSystemNamespace sets SystemNamespace field to given value.

### HasSystemNamespace

`func (o *MiscControllerEEConfiguration) HasSystemNamespace() bool`

HasSystemNamespace returns a boolean if a field has been set.

### GetHiddenLabelsPrefixes

`func (o *MiscControllerEEConfiguration) GetHiddenLabelsPrefixes() []string`

GetHiddenLabelsPrefixes returns the HiddenLabelsPrefixes field if non-nil, zero value otherwise.

### GetHiddenLabelsPrefixesOk

`func (o *MiscControllerEEConfiguration) GetHiddenLabelsPrefixesOk() (*[]string, bool)`

GetHiddenLabelsPrefixesOk returns a tuple with the HiddenLabelsPrefixes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHiddenLabelsPrefixes

`func (o *MiscControllerEEConfiguration) SetHiddenLabelsPrefixes(v []string)`

SetHiddenLabelsPrefixes sets HiddenLabelsPrefixes field to given value.

### HasHiddenLabelsPrefixes

`func (o *MiscControllerEEConfiguration) HasHiddenLabelsPrefixes() bool`

HasHiddenLabelsPrefixes returns a boolean if a field has been set.

### GetResourceToFilters

`func (o *MiscControllerEEConfiguration) GetResourceToFilters() []QueryFilterResourceField`

GetResourceToFilters returns the ResourceToFilters field if non-nil, zero value otherwise.

### GetResourceToFiltersOk

`func (o *MiscControllerEEConfiguration) GetResourceToFiltersOk() (*[]QueryFilterResourceField, bool)`

GetResourceToFiltersOk returns a tuple with the ResourceToFilters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceToFilters

`func (o *MiscControllerEEConfiguration) SetResourceToFilters(v []QueryFilterResourceField)`

SetResourceToFilters sets ResourceToFilters field to given value.

### HasResourceToFilters

`func (o *MiscControllerEEConfiguration) HasResourceToFilters() bool`

HasResourceToFilters returns a boolean if a field has been set.

### GetIsAiEnabled

`func (o *MiscControllerEEConfiguration) GetIsAiEnabled() bool`

GetIsAiEnabled returns the IsAiEnabled field if non-nil, zero value otherwise.

### GetIsAiEnabledOk

`func (o *MiscControllerEEConfiguration) GetIsAiEnabledOk() (*bool, bool)`

GetIsAiEnabledOk returns a tuple with the IsAiEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsAiEnabled

`func (o *MiscControllerEEConfiguration) SetIsAiEnabled(v bool)`

SetIsAiEnabled sets IsAiEnabled field to given value.

### HasIsAiEnabled

`func (o *MiscControllerEEConfiguration) HasIsAiEnabled() bool`

HasIsAiEnabled returns a boolean if a field has been set.

### GetIsBasicAuthInitialized

`func (o *MiscControllerEEConfiguration) GetIsBasicAuthInitialized() bool`

GetIsBasicAuthInitialized returns the IsBasicAuthInitialized field if non-nil, zero value otherwise.

### GetIsBasicAuthInitializedOk

`func (o *MiscControllerEEConfiguration) GetIsBasicAuthInitializedOk() (*bool, bool)`

GetIsBasicAuthInitializedOk returns a tuple with the IsBasicAuthInitialized field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsBasicAuthInitialized

`func (o *MiscControllerEEConfiguration) SetIsBasicAuthInitialized(v bool)`

SetIsBasicAuthInitialized sets IsBasicAuthInitialized field to given value.

### HasIsBasicAuthInitialized

`func (o *MiscControllerEEConfiguration) HasIsBasicAuthInitialized() bool`

HasIsBasicAuthInitialized returns a boolean if a field has been set.

### GetTenants

`func (o *MiscControllerEEConfiguration) GetTenants() MiscControllerTenantConfigurationInfo`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *MiscControllerEEConfiguration) GetTenantsOk() (*MiscControllerTenantConfigurationInfo, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *MiscControllerEEConfiguration) SetTenants(v MiscControllerTenantConfigurationInfo)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *MiscControllerEEConfiguration) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetSecretsEnabled

`func (o *MiscControllerEEConfiguration) GetSecretsEnabled() bool`

GetSecretsEnabled returns the SecretsEnabled field if non-nil, zero value otherwise.

### GetSecretsEnabledOk

`func (o *MiscControllerEEConfiguration) GetSecretsEnabledOk() (*bool, bool)`

GetSecretsEnabledOk returns a tuple with the SecretsEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecretsEnabled

`func (o *MiscControllerEEConfiguration) SetSecretsEnabled(v bool)`

SetSecretsEnabled sets SecretsEnabled field to given value.

### HasSecretsEnabled

`func (o *MiscControllerEEConfiguration) HasSecretsEnabled() bool`

HasSecretsEnabled returns a boolean if a field has been set.

### GetSupportedStorages

`func (o *MiscControllerEEConfiguration) GetSupportedStorages() []MiscControllerPluginIdAndVersion`

GetSupportedStorages returns the SupportedStorages field if non-nil, zero value otherwise.

### GetSupportedStoragesOk

`func (o *MiscControllerEEConfiguration) GetSupportedStoragesOk() (*[]MiscControllerPluginIdAndVersion, bool)`

GetSupportedStoragesOk returns a tuple with the SupportedStorages field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSupportedStorages

`func (o *MiscControllerEEConfiguration) SetSupportedStorages(v []MiscControllerPluginIdAndVersion)`

SetSupportedStorages sets SupportedStorages field to given value.

### HasSupportedStorages

`func (o *MiscControllerEEConfiguration) HasSupportedStorages() bool`

HasSupportedStorages returns a boolean if a field has been set.

### GetSupportedSecrets

`func (o *MiscControllerEEConfiguration) GetSupportedSecrets() []MiscControllerPluginIdAndVersion`

GetSupportedSecrets returns the SupportedSecrets field if non-nil, zero value otherwise.

### GetSupportedSecretsOk

`func (o *MiscControllerEEConfiguration) GetSupportedSecretsOk() (*[]MiscControllerPluginIdAndVersion, bool)`

GetSupportedSecretsOk returns a tuple with the SupportedSecrets field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSupportedSecrets

`func (o *MiscControllerEEConfiguration) SetSupportedSecrets(v []MiscControllerPluginIdAndVersion)`

SetSupportedSecrets sets SupportedSecrets field to given value.

### HasSupportedSecrets

`func (o *MiscControllerEEConfiguration) HasSupportedSecrets() bool`

HasSupportedSecrets returns a boolean if a field has been set.

### GetPluginManagementEnabled

`func (o *MiscControllerEEConfiguration) GetPluginManagementEnabled() bool`

GetPluginManagementEnabled returns the PluginManagementEnabled field if non-nil, zero value otherwise.

### GetPluginManagementEnabledOk

`func (o *MiscControllerEEConfiguration) GetPluginManagementEnabledOk() (*bool, bool)`

GetPluginManagementEnabledOk returns a tuple with the PluginManagementEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginManagementEnabled

`func (o *MiscControllerEEConfiguration) SetPluginManagementEnabled(v bool)`

SetPluginManagementEnabled sets PluginManagementEnabled field to given value.

### HasPluginManagementEnabled

`func (o *MiscControllerEEConfiguration) HasPluginManagementEnabled() bool`

HasPluginManagementEnabled returns a boolean if a field has been set.

### GetPluginCustomEnabled

`func (o *MiscControllerEEConfiguration) GetPluginCustomEnabled() bool`

GetPluginCustomEnabled returns the PluginCustomEnabled field if non-nil, zero value otherwise.

### GetPluginCustomEnabledOk

`func (o *MiscControllerEEConfiguration) GetPluginCustomEnabledOk() (*bool, bool)`

GetPluginCustomEnabledOk returns a tuple with the PluginCustomEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginCustomEnabled

`func (o *MiscControllerEEConfiguration) SetPluginCustomEnabled(v bool)`

SetPluginCustomEnabled sets PluginCustomEnabled field to given value.

### HasPluginCustomEnabled

`func (o *MiscControllerEEConfiguration) HasPluginCustomEnabled() bool`

HasPluginCustomEnabled returns a boolean if a field has been set.

### GetBanner

`func (o *MiscControllerEEConfiguration) GetBanner() Banner`

GetBanner returns the Banner field if non-nil, zero value otherwise.

### GetBannerOk

`func (o *MiscControllerEEConfiguration) GetBannerOk() (*Banner, bool)`

GetBannerOk returns a tuple with the Banner field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBanner

`func (o *MiscControllerEEConfiguration) SetBanner(v Banner)`

SetBanner sets Banner field to given value.

### HasBanner

`func (o *MiscControllerEEConfiguration) HasBanner() bool`

HasBanner returns a boolean if a field has been set.

### GetMailServiceEnabled

`func (o *MiscControllerEEConfiguration) GetMailServiceEnabled() bool`

GetMailServiceEnabled returns the MailServiceEnabled field if non-nil, zero value otherwise.

### GetMailServiceEnabledOk

`func (o *MiscControllerEEConfiguration) GetMailServiceEnabledOk() (*bool, bool)`

GetMailServiceEnabledOk returns a tuple with the MailServiceEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMailServiceEnabled

`func (o *MiscControllerEEConfiguration) SetMailServiceEnabled(v bool)`

SetMailServiceEnabled sets MailServiceEnabled field to given value.

### HasMailServiceEnabled

`func (o *MiscControllerEEConfiguration) HasMailServiceEnabled() bool`

HasMailServiceEnabled returns a boolean if a field has been set.

### GetOutputsInInternalStorageEnabled

`func (o *MiscControllerEEConfiguration) GetOutputsInInternalStorageEnabled() bool`

GetOutputsInInternalStorageEnabled returns the OutputsInInternalStorageEnabled field if non-nil, zero value otherwise.

### GetOutputsInInternalStorageEnabledOk

`func (o *MiscControllerEEConfiguration) GetOutputsInInternalStorageEnabledOk() (*bool, bool)`

GetOutputsInInternalStorageEnabledOk returns a tuple with the OutputsInInternalStorageEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputsInInternalStorageEnabled

`func (o *MiscControllerEEConfiguration) SetOutputsInInternalStorageEnabled(v bool)`

SetOutputsInInternalStorageEnabled sets OutputsInInternalStorageEnabled field to given value.

### HasOutputsInInternalStorageEnabled

`func (o *MiscControllerEEConfiguration) HasOutputsInInternalStorageEnabled() bool`

HasOutputsInInternalStorageEnabled returns a boolean if a field has been set.

### GetLeftSidebar

`func (o *MiscControllerEEConfiguration) GetLeftSidebar() LeftSidebarConfiguration`

GetLeftSidebar returns the LeftSidebar field if non-nil, zero value otherwise.

### GetLeftSidebarOk

`func (o *MiscControllerEEConfiguration) GetLeftSidebarOk() (*LeftSidebarConfiguration, bool)`

GetLeftSidebarOk returns a tuple with the LeftSidebar field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLeftSidebar

`func (o *MiscControllerEEConfiguration) SetLeftSidebar(v LeftSidebarConfiguration)`

SetLeftSidebar sets LeftSidebar field to given value.

### HasLeftSidebar

`func (o *MiscControllerEEConfiguration) HasLeftSidebar() bool`

HasLeftSidebar returns a boolean if a field has been set.

### GetRightSidebar

`func (o *MiscControllerEEConfiguration) GetRightSidebar() RightSidebarConfiguration`

GetRightSidebar returns the RightSidebar field if non-nil, zero value otherwise.

### GetRightSidebarOk

`func (o *MiscControllerEEConfiguration) GetRightSidebarOk() (*RightSidebarConfiguration, bool)`

GetRightSidebarOk returns a tuple with the RightSidebar field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRightSidebar

`func (o *MiscControllerEEConfiguration) SetRightSidebar(v RightSidebarConfiguration)`

SetRightSidebar sets RightSidebar field to given value.

### HasRightSidebar

`func (o *MiscControllerEEConfiguration) HasRightSidebar() bool`

HasRightSidebar returns a boolean if a field has been set.

### GetInMaintenance

`func (o *MiscControllerEEConfiguration) GetInMaintenance() bool`

GetInMaintenance returns the InMaintenance field if non-nil, zero value otherwise.

### GetInMaintenanceOk

`func (o *MiscControllerEEConfiguration) GetInMaintenanceOk() (*bool, bool)`

GetInMaintenanceOk returns a tuple with the InMaintenance field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInMaintenance

`func (o *MiscControllerEEConfiguration) SetInMaintenance(v bool)`

SetInMaintenance sets InMaintenance field to given value.

### HasInMaintenance

`func (o *MiscControllerEEConfiguration) HasInMaintenance() bool`

HasInMaintenance returns a boolean if a field has been set.

### GetPasswordRegexp

`func (o *MiscControllerEEConfiguration) GetPasswordRegexp() string`

GetPasswordRegexp returns the PasswordRegexp field if non-nil, zero value otherwise.

### GetPasswordRegexpOk

`func (o *MiscControllerEEConfiguration) GetPasswordRegexpOk() (*string, bool)`

GetPasswordRegexpOk returns a tuple with the PasswordRegexp field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordRegexp

`func (o *MiscControllerEEConfiguration) SetPasswordRegexp(v string)`

SetPasswordRegexp sets PasswordRegexp field to given value.

### HasPasswordRegexp

`func (o *MiscControllerEEConfiguration) HasPasswordRegexp() bool`

HasPasswordRegexp returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


