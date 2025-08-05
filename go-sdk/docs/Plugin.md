# Plugin

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | Pointer to **string** |  | [optional] 
**Title** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**License** | Pointer to **string** |  | [optional] 
**LongDescription** | Pointer to **string** |  | [optional] 
**Group** | Pointer to **string** |  | [optional] 
**Version** | Pointer to **string** |  | [optional] 
**Manifest** | Pointer to **map[string]string** |  | [optional] 
**Guides** | Pointer to **[]string** |  | [optional] 
**Aliases** | Pointer to **[]string** |  | [optional] 
**Tasks** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Triggers** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Conditions** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Controllers** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Storages** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Secrets** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**TaskRunners** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Apps** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**AppBlocks** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Charts** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**DataFilters** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**LogExporters** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**AdditionalPlugins** | Pointer to [**[]PluginPluginElementMetadata**](PluginPluginElementMetadata.md) |  | [optional] 
**Categories** | Pointer to [**[]PluginSubGroupPluginCategory**](PluginSubGroupPluginCategory.md) |  | [optional] 
**SubGroup** | Pointer to **string** |  | [optional] 

## Methods

### NewPlugin

`func NewPlugin() *Plugin`

NewPlugin instantiates a new Plugin object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPluginWithDefaults

`func NewPluginWithDefaults() *Plugin`

NewPluginWithDefaults instantiates a new Plugin object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *Plugin) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *Plugin) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *Plugin) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *Plugin) HasName() bool`

HasName returns a boolean if a field has been set.

### GetTitle

`func (o *Plugin) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *Plugin) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *Plugin) SetTitle(v string)`

SetTitle sets Title field to given value.

### HasTitle

`func (o *Plugin) HasTitle() bool`

HasTitle returns a boolean if a field has been set.

### GetDescription

`func (o *Plugin) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Plugin) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Plugin) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Plugin) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetLicense

`func (o *Plugin) GetLicense() string`

GetLicense returns the License field if non-nil, zero value otherwise.

### GetLicenseOk

`func (o *Plugin) GetLicenseOk() (*string, bool)`

GetLicenseOk returns a tuple with the License field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLicense

`func (o *Plugin) SetLicense(v string)`

SetLicense sets License field to given value.

### HasLicense

`func (o *Plugin) HasLicense() bool`

HasLicense returns a boolean if a field has been set.

### GetLongDescription

`func (o *Plugin) GetLongDescription() string`

GetLongDescription returns the LongDescription field if non-nil, zero value otherwise.

### GetLongDescriptionOk

`func (o *Plugin) GetLongDescriptionOk() (*string, bool)`

GetLongDescriptionOk returns a tuple with the LongDescription field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLongDescription

`func (o *Plugin) SetLongDescription(v string)`

SetLongDescription sets LongDescription field to given value.

### HasLongDescription

`func (o *Plugin) HasLongDescription() bool`

HasLongDescription returns a boolean if a field has been set.

### GetGroup

`func (o *Plugin) GetGroup() string`

GetGroup returns the Group field if non-nil, zero value otherwise.

### GetGroupOk

`func (o *Plugin) GetGroupOk() (*string, bool)`

GetGroupOk returns a tuple with the Group field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroup

`func (o *Plugin) SetGroup(v string)`

SetGroup sets Group field to given value.

### HasGroup

`func (o *Plugin) HasGroup() bool`

HasGroup returns a boolean if a field has been set.

### GetVersion

`func (o *Plugin) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *Plugin) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *Plugin) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *Plugin) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetManifest

`func (o *Plugin) GetManifest() map[string]string`

GetManifest returns the Manifest field if non-nil, zero value otherwise.

### GetManifestOk

`func (o *Plugin) GetManifestOk() (*map[string]string, bool)`

GetManifestOk returns a tuple with the Manifest field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetManifest

`func (o *Plugin) SetManifest(v map[string]string)`

SetManifest sets Manifest field to given value.

### HasManifest

`func (o *Plugin) HasManifest() bool`

HasManifest returns a boolean if a field has been set.

### GetGuides

`func (o *Plugin) GetGuides() []string`

GetGuides returns the Guides field if non-nil, zero value otherwise.

### GetGuidesOk

`func (o *Plugin) GetGuidesOk() (*[]string, bool)`

GetGuidesOk returns a tuple with the Guides field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGuides

`func (o *Plugin) SetGuides(v []string)`

SetGuides sets Guides field to given value.

### HasGuides

`func (o *Plugin) HasGuides() bool`

HasGuides returns a boolean if a field has been set.

### GetAliases

`func (o *Plugin) GetAliases() []string`

GetAliases returns the Aliases field if non-nil, zero value otherwise.

### GetAliasesOk

`func (o *Plugin) GetAliasesOk() (*[]string, bool)`

GetAliasesOk returns a tuple with the Aliases field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAliases

`func (o *Plugin) SetAliases(v []string)`

SetAliases sets Aliases field to given value.

### HasAliases

`func (o *Plugin) HasAliases() bool`

HasAliases returns a boolean if a field has been set.

### GetTasks

`func (o *Plugin) GetTasks() []PluginPluginElementMetadata`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *Plugin) GetTasksOk() (*[]PluginPluginElementMetadata, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *Plugin) SetTasks(v []PluginPluginElementMetadata)`

SetTasks sets Tasks field to given value.

### HasTasks

`func (o *Plugin) HasTasks() bool`

HasTasks returns a boolean if a field has been set.

### GetTriggers

`func (o *Plugin) GetTriggers() []PluginPluginElementMetadata`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *Plugin) GetTriggersOk() (*[]PluginPluginElementMetadata, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *Plugin) SetTriggers(v []PluginPluginElementMetadata)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *Plugin) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.

### GetConditions

`func (o *Plugin) GetConditions() []PluginPluginElementMetadata`

GetConditions returns the Conditions field if non-nil, zero value otherwise.

### GetConditionsOk

`func (o *Plugin) GetConditionsOk() (*[]PluginPluginElementMetadata, bool)`

GetConditionsOk returns a tuple with the Conditions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConditions

`func (o *Plugin) SetConditions(v []PluginPluginElementMetadata)`

SetConditions sets Conditions field to given value.

### HasConditions

`func (o *Plugin) HasConditions() bool`

HasConditions returns a boolean if a field has been set.

### GetControllers

`func (o *Plugin) GetControllers() []PluginPluginElementMetadata`

GetControllers returns the Controllers field if non-nil, zero value otherwise.

### GetControllersOk

`func (o *Plugin) GetControllersOk() (*[]PluginPluginElementMetadata, bool)`

GetControllersOk returns a tuple with the Controllers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetControllers

`func (o *Plugin) SetControllers(v []PluginPluginElementMetadata)`

SetControllers sets Controllers field to given value.

### HasControllers

`func (o *Plugin) HasControllers() bool`

HasControllers returns a boolean if a field has been set.

### GetStorages

`func (o *Plugin) GetStorages() []PluginPluginElementMetadata`

GetStorages returns the Storages field if non-nil, zero value otherwise.

### GetStoragesOk

`func (o *Plugin) GetStoragesOk() (*[]PluginPluginElementMetadata, bool)`

GetStoragesOk returns a tuple with the Storages field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStorages

`func (o *Plugin) SetStorages(v []PluginPluginElementMetadata)`

SetStorages sets Storages field to given value.

### HasStorages

`func (o *Plugin) HasStorages() bool`

HasStorages returns a boolean if a field has been set.

### GetSecrets

`func (o *Plugin) GetSecrets() []PluginPluginElementMetadata`

GetSecrets returns the Secrets field if non-nil, zero value otherwise.

### GetSecretsOk

`func (o *Plugin) GetSecretsOk() (*[]PluginPluginElementMetadata, bool)`

GetSecretsOk returns a tuple with the Secrets field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecrets

`func (o *Plugin) SetSecrets(v []PluginPluginElementMetadata)`

SetSecrets sets Secrets field to given value.

### HasSecrets

`func (o *Plugin) HasSecrets() bool`

HasSecrets returns a boolean if a field has been set.

### GetTaskRunners

`func (o *Plugin) GetTaskRunners() []PluginPluginElementMetadata`

GetTaskRunners returns the TaskRunners field if non-nil, zero value otherwise.

### GetTaskRunnersOk

`func (o *Plugin) GetTaskRunnersOk() (*[]PluginPluginElementMetadata, bool)`

GetTaskRunnersOk returns a tuple with the TaskRunners field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunners

`func (o *Plugin) SetTaskRunners(v []PluginPluginElementMetadata)`

SetTaskRunners sets TaskRunners field to given value.

### HasTaskRunners

`func (o *Plugin) HasTaskRunners() bool`

HasTaskRunners returns a boolean if a field has been set.

### GetApps

`func (o *Plugin) GetApps() []PluginPluginElementMetadata`

GetApps returns the Apps field if non-nil, zero value otherwise.

### GetAppsOk

`func (o *Plugin) GetAppsOk() (*[]PluginPluginElementMetadata, bool)`

GetAppsOk returns a tuple with the Apps field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetApps

`func (o *Plugin) SetApps(v []PluginPluginElementMetadata)`

SetApps sets Apps field to given value.

### HasApps

`func (o *Plugin) HasApps() bool`

HasApps returns a boolean if a field has been set.

### GetAppBlocks

`func (o *Plugin) GetAppBlocks() []PluginPluginElementMetadata`

GetAppBlocks returns the AppBlocks field if non-nil, zero value otherwise.

### GetAppBlocksOk

`func (o *Plugin) GetAppBlocksOk() (*[]PluginPluginElementMetadata, bool)`

GetAppBlocksOk returns a tuple with the AppBlocks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAppBlocks

`func (o *Plugin) SetAppBlocks(v []PluginPluginElementMetadata)`

SetAppBlocks sets AppBlocks field to given value.

### HasAppBlocks

`func (o *Plugin) HasAppBlocks() bool`

HasAppBlocks returns a boolean if a field has been set.

### GetCharts

`func (o *Plugin) GetCharts() []PluginPluginElementMetadata`

GetCharts returns the Charts field if non-nil, zero value otherwise.

### GetChartsOk

`func (o *Plugin) GetChartsOk() (*[]PluginPluginElementMetadata, bool)`

GetChartsOk returns a tuple with the Charts field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCharts

`func (o *Plugin) SetCharts(v []PluginPluginElementMetadata)`

SetCharts sets Charts field to given value.

### HasCharts

`func (o *Plugin) HasCharts() bool`

HasCharts returns a boolean if a field has been set.

### GetDataFilters

`func (o *Plugin) GetDataFilters() []PluginPluginElementMetadata`

GetDataFilters returns the DataFilters field if non-nil, zero value otherwise.

### GetDataFiltersOk

`func (o *Plugin) GetDataFiltersOk() (*[]PluginPluginElementMetadata, bool)`

GetDataFiltersOk returns a tuple with the DataFilters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDataFilters

`func (o *Plugin) SetDataFilters(v []PluginPluginElementMetadata)`

SetDataFilters sets DataFilters field to given value.

### HasDataFilters

`func (o *Plugin) HasDataFilters() bool`

HasDataFilters returns a boolean if a field has been set.

### GetLogExporters

`func (o *Plugin) GetLogExporters() []PluginPluginElementMetadata`

GetLogExporters returns the LogExporters field if non-nil, zero value otherwise.

### GetLogExportersOk

`func (o *Plugin) GetLogExportersOk() (*[]PluginPluginElementMetadata, bool)`

GetLogExportersOk returns a tuple with the LogExporters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogExporters

`func (o *Plugin) SetLogExporters(v []PluginPluginElementMetadata)`

SetLogExporters sets LogExporters field to given value.

### HasLogExporters

`func (o *Plugin) HasLogExporters() bool`

HasLogExporters returns a boolean if a field has been set.

### GetAdditionalPlugins

`func (o *Plugin) GetAdditionalPlugins() []PluginPluginElementMetadata`

GetAdditionalPlugins returns the AdditionalPlugins field if non-nil, zero value otherwise.

### GetAdditionalPluginsOk

`func (o *Plugin) GetAdditionalPluginsOk() (*[]PluginPluginElementMetadata, bool)`

GetAdditionalPluginsOk returns a tuple with the AdditionalPlugins field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAdditionalPlugins

`func (o *Plugin) SetAdditionalPlugins(v []PluginPluginElementMetadata)`

SetAdditionalPlugins sets AdditionalPlugins field to given value.

### HasAdditionalPlugins

`func (o *Plugin) HasAdditionalPlugins() bool`

HasAdditionalPlugins returns a boolean if a field has been set.

### GetCategories

`func (o *Plugin) GetCategories() []PluginSubGroupPluginCategory`

GetCategories returns the Categories field if non-nil, zero value otherwise.

### GetCategoriesOk

`func (o *Plugin) GetCategoriesOk() (*[]PluginSubGroupPluginCategory, bool)`

GetCategoriesOk returns a tuple with the Categories field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCategories

`func (o *Plugin) SetCategories(v []PluginSubGroupPluginCategory)`

SetCategories sets Categories field to given value.

### HasCategories

`func (o *Plugin) HasCategories() bool`

HasCategories returns a boolean if a field has been set.

### GetSubGroup

`func (o *Plugin) GetSubGroup() string`

GetSubGroup returns the SubGroup field if non-nil, zero value otherwise.

### GetSubGroupOk

`func (o *Plugin) GetSubGroupOk() (*string, bool)`

GetSubGroupOk returns a tuple with the SubGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubGroup

`func (o *Plugin) SetSubGroup(v string)`

SetSubGroup sets SubGroup field to given value.

### HasSubGroup

`func (o *Plugin) HasSubGroup() bool`

HasSubGroup returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


