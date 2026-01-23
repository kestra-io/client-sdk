# BlueprintWithFlowEntity

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Title** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**Tags** | Pointer to **[]string** |  | [optional] 
**IncludedTasks** | Pointer to **[]string** |  | [optional] 
**PublishedAt** | Pointer to **time.Time** |  | [optional] 
**Deleted** | **bool** |  | 
**Template** | Pointer to [**BlueprintTemplate**](BlueprintTemplate.md) |  | [optional] 
**Flow** | **string** |  | 

## Methods

### NewBlueprintWithFlowEntity

`func NewBlueprintWithFlowEntity(title string, deleted bool, flow string, ) *BlueprintWithFlowEntity`

NewBlueprintWithFlowEntity instantiates a new BlueprintWithFlowEntity object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBlueprintWithFlowEntityWithDefaults

`func NewBlueprintWithFlowEntityWithDefaults() *BlueprintWithFlowEntity`

NewBlueprintWithFlowEntityWithDefaults instantiates a new BlueprintWithFlowEntity object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *BlueprintWithFlowEntity) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *BlueprintWithFlowEntity) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *BlueprintWithFlowEntity) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *BlueprintWithFlowEntity) HasId() bool`

HasId returns a boolean if a field has been set.

### GetTitle

`func (o *BlueprintWithFlowEntity) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *BlueprintWithFlowEntity) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *BlueprintWithFlowEntity) SetTitle(v string)`

SetTitle sets Title field to given value.


### GetDescription

`func (o *BlueprintWithFlowEntity) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *BlueprintWithFlowEntity) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *BlueprintWithFlowEntity) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *BlueprintWithFlowEntity) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetTags

`func (o *BlueprintWithFlowEntity) GetTags() []string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *BlueprintWithFlowEntity) GetTagsOk() (*[]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *BlueprintWithFlowEntity) SetTags(v []string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *BlueprintWithFlowEntity) HasTags() bool`

HasTags returns a boolean if a field has been set.

### GetIncludedTasks

`func (o *BlueprintWithFlowEntity) GetIncludedTasks() []string`

GetIncludedTasks returns the IncludedTasks field if non-nil, zero value otherwise.

### GetIncludedTasksOk

`func (o *BlueprintWithFlowEntity) GetIncludedTasksOk() (*[]string, bool)`

GetIncludedTasksOk returns a tuple with the IncludedTasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIncludedTasks

`func (o *BlueprintWithFlowEntity) SetIncludedTasks(v []string)`

SetIncludedTasks sets IncludedTasks field to given value.

### HasIncludedTasks

`func (o *BlueprintWithFlowEntity) HasIncludedTasks() bool`

HasIncludedTasks returns a boolean if a field has been set.

### GetPublishedAt

`func (o *BlueprintWithFlowEntity) GetPublishedAt() time.Time`

GetPublishedAt returns the PublishedAt field if non-nil, zero value otherwise.

### GetPublishedAtOk

`func (o *BlueprintWithFlowEntity) GetPublishedAtOk() (*time.Time, bool)`

GetPublishedAtOk returns a tuple with the PublishedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPublishedAt

`func (o *BlueprintWithFlowEntity) SetPublishedAt(v time.Time)`

SetPublishedAt sets PublishedAt field to given value.

### HasPublishedAt

`func (o *BlueprintWithFlowEntity) HasPublishedAt() bool`

HasPublishedAt returns a boolean if a field has been set.

### GetDeleted

`func (o *BlueprintWithFlowEntity) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *BlueprintWithFlowEntity) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *BlueprintWithFlowEntity) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetTemplate

`func (o *BlueprintWithFlowEntity) GetTemplate() BlueprintTemplate`

GetTemplate returns the Template field if non-nil, zero value otherwise.

### GetTemplateOk

`func (o *BlueprintWithFlowEntity) GetTemplateOk() (*BlueprintTemplate, bool)`

GetTemplateOk returns a tuple with the Template field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTemplate

`func (o *BlueprintWithFlowEntity) SetTemplate(v BlueprintTemplate)`

SetTemplate sets Template field to given value.

### HasTemplate

`func (o *BlueprintWithFlowEntity) HasTemplate() bool`

HasTemplate returns a boolean if a field has been set.

### GetFlow

`func (o *BlueprintWithFlowEntity) GetFlow() string`

GetFlow returns the Flow field if non-nil, zero value otherwise.

### GetFlowOk

`func (o *BlueprintWithFlowEntity) GetFlowOk() (*string, bool)`

GetFlowOk returns a tuple with the Flow field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlow

`func (o *BlueprintWithFlowEntity) SetFlow(v string)`

SetFlow sets Flow field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


