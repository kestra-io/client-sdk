# Blueprint

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

## Methods

### NewBlueprint

`func NewBlueprint(title string, deleted bool, ) *Blueprint`

NewBlueprint instantiates a new Blueprint object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBlueprintWithDefaults

`func NewBlueprintWithDefaults() *Blueprint`

NewBlueprintWithDefaults instantiates a new Blueprint object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Blueprint) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Blueprint) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Blueprint) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *Blueprint) HasId() bool`

HasId returns a boolean if a field has been set.

### GetTitle

`func (o *Blueprint) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *Blueprint) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *Blueprint) SetTitle(v string)`

SetTitle sets Title field to given value.


### GetDescription

`func (o *Blueprint) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Blueprint) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Blueprint) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Blueprint) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetTags

`func (o *Blueprint) GetTags() []string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *Blueprint) GetTagsOk() (*[]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *Blueprint) SetTags(v []string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *Blueprint) HasTags() bool`

HasTags returns a boolean if a field has been set.

### GetIncludedTasks

`func (o *Blueprint) GetIncludedTasks() []string`

GetIncludedTasks returns the IncludedTasks field if non-nil, zero value otherwise.

### GetIncludedTasksOk

`func (o *Blueprint) GetIncludedTasksOk() (*[]string, bool)`

GetIncludedTasksOk returns a tuple with the IncludedTasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIncludedTasks

`func (o *Blueprint) SetIncludedTasks(v []string)`

SetIncludedTasks sets IncludedTasks field to given value.

### HasIncludedTasks

`func (o *Blueprint) HasIncludedTasks() bool`

HasIncludedTasks returns a boolean if a field has been set.

### GetPublishedAt

`func (o *Blueprint) GetPublishedAt() time.Time`

GetPublishedAt returns the PublishedAt field if non-nil, zero value otherwise.

### GetPublishedAtOk

`func (o *Blueprint) GetPublishedAtOk() (*time.Time, bool)`

GetPublishedAtOk returns a tuple with the PublishedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPublishedAt

`func (o *Blueprint) SetPublishedAt(v time.Time)`

SetPublishedAt sets PublishedAt field to given value.

### HasPublishedAt

`func (o *Blueprint) HasPublishedAt() bool`

HasPublishedAt returns a boolean if a field has been set.

### GetDeleted

`func (o *Blueprint) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Blueprint) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Blueprint) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetTemplate

`func (o *Blueprint) GetTemplate() BlueprintTemplate`

GetTemplate returns the Template field if non-nil, zero value otherwise.

### GetTemplateOk

`func (o *Blueprint) GetTemplateOk() (*BlueprintTemplate, bool)`

GetTemplateOk returns a tuple with the Template field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTemplate

`func (o *Blueprint) SetTemplate(v BlueprintTemplate)`

SetTemplate sets Template field to given value.

### HasTemplate

`func (o *Blueprint) HasTemplate() bool`

HasTemplate returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


