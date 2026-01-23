# Output

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**Value** | [**OutputValue**](OutputValue.md) |  | 
**Type** | [**Type**](Type.md) |  | 
**DisplayName** | Pointer to **string** |  | [optional] 
**Required** | Pointer to **bool** |  | [optional] 

## Methods

### NewOutput

`func NewOutput(id string, value OutputValue, type_ Type, ) *Output`

NewOutput instantiates a new Output object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewOutputWithDefaults

`func NewOutputWithDefaults() *Output`

NewOutputWithDefaults instantiates a new Output object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Output) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Output) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Output) SetId(v string)`

SetId sets Id field to given value.


### GetDescription

`func (o *Output) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Output) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Output) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Output) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetValue

`func (o *Output) GetValue() OutputValue`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *Output) GetValueOk() (*OutputValue, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *Output) SetValue(v OutputValue)`

SetValue sets Value field to given value.


### GetType

`func (o *Output) GetType() Type`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *Output) GetTypeOk() (*Type, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *Output) SetType(v Type)`

SetType sets Type field to given value.


### GetDisplayName

`func (o *Output) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *Output) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *Output) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *Output) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetRequired

`func (o *Output) GetRequired() bool`

GetRequired returns the Required field if non-nil, zero value otherwise.

### GetRequiredOk

`func (o *Output) GetRequiredOk() (*bool, bool)`

GetRequiredOk returns a tuple with the Required field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRequired

`func (o *Output) SetRequired(v bool)`

SetRequired sets Required field to given value.

### HasRequired

`func (o *Output) HasRequired() bool`

HasRequired returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


