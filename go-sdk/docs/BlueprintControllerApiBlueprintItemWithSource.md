# BlueprintControllerApiBlueprintItemWithSource

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Title** | **string** |  | 
**Description** | **string** |  | 
**IncludedTasks** | **[]string** |  | 
**Tags** | **[]string** |  | 
**PublishedAt** | **time.Time** |  | 
**Source** | Pointer to **string** |  | [optional] 
**Kind** | Pointer to [**BlueprintControllerKind**](BlueprintControllerKind.md) |  | [optional] 

## Methods

### NewBlueprintControllerApiBlueprintItemWithSource

`func NewBlueprintControllerApiBlueprintItemWithSource(id string, title string, description string, includedTasks []string, tags []string, publishedAt time.Time, ) *BlueprintControllerApiBlueprintItemWithSource`

NewBlueprintControllerApiBlueprintItemWithSource instantiates a new BlueprintControllerApiBlueprintItemWithSource object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBlueprintControllerApiBlueprintItemWithSourceWithDefaults

`func NewBlueprintControllerApiBlueprintItemWithSourceWithDefaults() *BlueprintControllerApiBlueprintItemWithSource`

NewBlueprintControllerApiBlueprintItemWithSourceWithDefaults instantiates a new BlueprintControllerApiBlueprintItemWithSource object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetId(v string)`

SetId sets Id field to given value.


### GetTitle

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetTitle() string`

GetTitle returns the Title field if non-nil, zero value otherwise.

### GetTitleOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetTitleOk() (*string, bool)`

GetTitleOk returns a tuple with the Title field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTitle

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetTitle(v string)`

SetTitle sets Title field to given value.


### GetDescription

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetIncludedTasks

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetIncludedTasks() []string`

GetIncludedTasks returns the IncludedTasks field if non-nil, zero value otherwise.

### GetIncludedTasksOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetIncludedTasksOk() (*[]string, bool)`

GetIncludedTasksOk returns a tuple with the IncludedTasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIncludedTasks

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetIncludedTasks(v []string)`

SetIncludedTasks sets IncludedTasks field to given value.


### GetTags

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetTags() []string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetTagsOk() (*[]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetTags(v []string)`

SetTags sets Tags field to given value.


### GetPublishedAt

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetPublishedAt() time.Time`

GetPublishedAt returns the PublishedAt field if non-nil, zero value otherwise.

### GetPublishedAtOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetPublishedAtOk() (*time.Time, bool)`

GetPublishedAtOk returns a tuple with the PublishedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPublishedAt

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetPublishedAt(v time.Time)`

SetPublishedAt sets PublishedAt field to given value.


### GetSource

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *BlueprintControllerApiBlueprintItemWithSource) HasSource() bool`

HasSource returns a boolean if a field has been set.

### GetKind

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetKind() BlueprintControllerKind`

GetKind returns the Kind field if non-nil, zero value otherwise.

### GetKindOk

`func (o *BlueprintControllerApiBlueprintItemWithSource) GetKindOk() (*BlueprintControllerKind, bool)`

GetKindOk returns a tuple with the Kind field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKind

`func (o *BlueprintControllerApiBlueprintItemWithSource) SetKind(v BlueprintControllerKind)`

SetKind sets Kind field to given value.

### HasKind

`func (o *BlueprintControllerApiBlueprintItemWithSource) HasKind() bool`

HasKind returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


