# AbstractTriggerForExecution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Version** | Pointer to **string** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  | [optional] 

## Methods

### NewAbstractTriggerForExecution

`func NewAbstractTriggerForExecution(id string, type_ string, ) *AbstractTriggerForExecution`

NewAbstractTriggerForExecution instantiates a new AbstractTriggerForExecution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractTriggerForExecutionWithDefaults

`func NewAbstractTriggerForExecutionWithDefaults() *AbstractTriggerForExecution`

NewAbstractTriggerForExecutionWithDefaults instantiates a new AbstractTriggerForExecution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *AbstractTriggerForExecution) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AbstractTriggerForExecution) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AbstractTriggerForExecution) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *AbstractTriggerForExecution) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AbstractTriggerForExecution) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AbstractTriggerForExecution) SetType(v string)`

SetType sets Type field to given value.


### GetVersion

`func (o *AbstractTriggerForExecution) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *AbstractTriggerForExecution) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *AbstractTriggerForExecution) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *AbstractTriggerForExecution) HasVersion() bool`

HasVersion returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


