# BlueprintTemplate

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Source** | **string** |  | 
**TemplateArguments** | Pointer to [**map[string]InputObject**](InputObject.md) |  | [optional] 

## Methods

### NewBlueprintTemplate

`func NewBlueprintTemplate(source string, ) *BlueprintTemplate`

NewBlueprintTemplate instantiates a new BlueprintTemplate object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBlueprintTemplateWithDefaults

`func NewBlueprintTemplateWithDefaults() *BlueprintTemplate`

NewBlueprintTemplateWithDefaults instantiates a new BlueprintTemplate object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSource

`func (o *BlueprintTemplate) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *BlueprintTemplate) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *BlueprintTemplate) SetSource(v string)`

SetSource sets Source field to given value.


### GetTemplateArguments

`func (o *BlueprintTemplate) GetTemplateArguments() map[string]InputObject`

GetTemplateArguments returns the TemplateArguments field if non-nil, zero value otherwise.

### GetTemplateArgumentsOk

`func (o *BlueprintTemplate) GetTemplateArgumentsOk() (*map[string]InputObject, bool)`

GetTemplateArgumentsOk returns a tuple with the TemplateArguments field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTemplateArguments

`func (o *BlueprintTemplate) SetTemplateArguments(v map[string]InputObject)`

SetTemplateArguments sets TemplateArguments field to given value.

### HasTemplateArguments

`func (o *BlueprintTemplate) HasTemplateArguments() bool`

HasTemplateArguments returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


