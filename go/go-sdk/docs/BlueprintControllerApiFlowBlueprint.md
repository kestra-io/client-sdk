# BlueprintControllerApiFlowBlueprint

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Title** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**IncludedTasks** | Pointer to **[]string** |  | [optional] 
**Tags** | Pointer to **[]string** |  | [optional] 
**Source** | Pointer to **string** |  | [optional] 
**PublishedAt** | Pointer to **time.Time** |  | [optional] 
**Template** | Pointer to [**BlueprintTemplate**](BlueprintTemplate.md) |  | [optional] 

## Methods

### NewBlueprintControllerApiFlowBlueprint

`func NewBlueprintControllerApiFlowBlueprint() *BlueprintControllerApiFlowBlueprint`

NewBlueprintControllerApiFlowBlueprint instantiates a new BlueprintControllerApiFlowBlueprint object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBlueprintControllerApiFlowBlueprintWithDefaults

`func NewBlueprintControllerApiFlowBlueprintWithDefaults() *BlueprintControllerApiFlowBlueprint`

NewBlueprintControllerApiFlowBlueprintWithDefaults instantiates a new BlueprintControllerApiFlowBlueprint object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *BlueprintControllerApiFlowBlueprint) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *BlueprintControllerApiFlowBlueprint) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *BlueprintControllerApiFlowBlueprint) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *BlueprintControllerApiFlowBlueprint) HasId() bool`

HasId returns a boolean if a field has been set.

### GetTitle

`func (o *BlueprintControllerApiFlowBlueprint) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *BlueprintControllerApiFlowBlueprint) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *BlueprintControllerApiFlowBlueprint) SetTitle(v string)`

SetTitle sets Title field to given value.

### HasTitle

`func (o *BlueprintControllerApiFlowBlueprint) HasTitle() bool`

HasTitle returns a boolean if a field has been set.

### GetDescription

`func (o *BlueprintControllerApiFlowBlueprint) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *BlueprintControllerApiFlowBlueprint) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *BlueprintControllerApiFlowBlueprint) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *BlueprintControllerApiFlowBlueprint) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetIncludedTasks

`func (o *BlueprintControllerApiFlowBlueprint) GetIncludedTasks() []string`

GetIncludedTasks returns the IncludedTasks field if non-nil, zero value otherwise.

### GetIncludedTasksOk

`func (o *BlueprintControllerApiFlowBlueprint) GetIncludedTasksOk() (*[]string, bool)`

GetIncludedTasksOk returns a tuple with the IncludedTasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIncludedTasks

`func (o *BlueprintControllerApiFlowBlueprint) SetIncludedTasks(v []string)`

SetIncludedTasks sets IncludedTasks field to given value.

### HasIncludedTasks

`func (o *BlueprintControllerApiFlowBlueprint) HasIncludedTasks() bool`

HasIncludedTasks returns a boolean if a field has been set.

### GetTags

`func (o *BlueprintControllerApiFlowBlueprint) GetTags() []string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *BlueprintControllerApiFlowBlueprint) GetTagsOk() (*[]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *BlueprintControllerApiFlowBlueprint) SetTags(v []string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *BlueprintControllerApiFlowBlueprint) HasTags() bool`

HasTags returns a boolean if a field has been set.

### GetSource

`func (o *BlueprintControllerApiFlowBlueprint) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *BlueprintControllerApiFlowBlueprint) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *BlueprintControllerApiFlowBlueprint) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *BlueprintControllerApiFlowBlueprint) HasSource() bool`

HasSource returns a boolean if a field has been set.

### GetPublishedAt

`func (o *BlueprintControllerApiFlowBlueprint) GetPublishedAt() time.Time`

GetPublishedAt returns the PublishedAt field if non-nil, zero value otherwise.

### GetPublishedAtOk

`func (o *BlueprintControllerApiFlowBlueprint) GetPublishedAtOk() (*time.Time, bool)`

GetPublishedAtOk returns a tuple with the PublishedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPublishedAt

`func (o *BlueprintControllerApiFlowBlueprint) SetPublishedAt(v time.Time)`

SetPublishedAt sets PublishedAt field to given value.

### HasPublishedAt

`func (o *BlueprintControllerApiFlowBlueprint) HasPublishedAt() bool`

HasPublishedAt returns a boolean if a field has been set.

### GetTemplate

`func (o *BlueprintControllerApiFlowBlueprint) GetTemplate() BlueprintTemplate`

GetTemplate returns the Template field if non-nil, zero value otherwise.

### GetTemplateOk

`func (o *BlueprintControllerApiFlowBlueprint) GetTemplateOk() (*BlueprintTemplate, bool)`

GetTemplateOk returns a tuple with the Template field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTemplate

`func (o *BlueprintControllerApiFlowBlueprint) SetTemplate(v BlueprintTemplate)`

SetTemplate sets Template field to given value.

### HasTemplate

`func (o *BlueprintControllerApiFlowBlueprint) HasTemplate() bool`

HasTemplate returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


