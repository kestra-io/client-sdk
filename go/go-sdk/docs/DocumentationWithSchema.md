# DocumentationWithSchema

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Markdown** | Pointer to **string** |  | [optional] 
**Schema** | Pointer to [**PluginSchema**](PluginSchema.md) |  | [optional] 

## Methods

### NewDocumentationWithSchema

`func NewDocumentationWithSchema() *DocumentationWithSchema`

NewDocumentationWithSchema instantiates a new DocumentationWithSchema object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDocumentationWithSchemaWithDefaults

`func NewDocumentationWithSchemaWithDefaults() *DocumentationWithSchema`

NewDocumentationWithSchemaWithDefaults instantiates a new DocumentationWithSchema object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMarkdown

`func (o *DocumentationWithSchema) GetMarkdown() string`

GetMarkdown returns the Markdown field if non-nil, zero value otherwise.

### GetMarkdownOk

`func (o *DocumentationWithSchema) GetMarkdownOk() (*string, bool)`

GetMarkdownOk returns a tuple with the Markdown field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMarkdown

`func (o *DocumentationWithSchema) SetMarkdown(v string)`

SetMarkdown sets Markdown field to given value.

### HasMarkdown

`func (o *DocumentationWithSchema) HasMarkdown() bool`

HasMarkdown returns a boolean if a field has been set.

### GetSchema

`func (o *DocumentationWithSchema) GetSchema() PluginSchema`

GetSchema returns the Schema field if non-nil, zero value otherwise.

### GetSchemaOk

`func (o *DocumentationWithSchema) GetSchemaOk() (*PluginSchema, bool)`

GetSchemaOk returns a tuple with the Schema field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchema

`func (o *DocumentationWithSchema) SetSchema(v PluginSchema)`

SetSchema sets Schema field to given value.

### HasSchema

`func (o *DocumentationWithSchema) HasSchema() bool`

HasSchema returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


