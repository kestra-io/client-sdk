# InputObject

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | Pointer to **string** |  | [optional] 
**Id** | **string** |  | 
**Type** | [**Type**](Type.md) |  | 
**Description** | Pointer to **string** |  | [optional] 
**DependsOn** | Pointer to [**DependsOn**](DependsOn.md) |  | [optional] 
**Required** | Pointer to **bool** |  | [optional] 
**Defaults** | Pointer to [**string**](PropertyObject.md) |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 

## Methods

### NewInputObject

`func NewInputObject(id string, type_ Type, ) *InputObject`

NewInputObject instantiates a new InputObject object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInputObjectWithDefaults

`func NewInputObjectWithDefaults() *InputObject`

NewInputObjectWithDefaults instantiates a new InputObject object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *InputObject) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *InputObject) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *InputObject) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *InputObject) HasName() bool`

HasName returns a boolean if a field has been set.

### GetId

`func (o *InputObject) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InputObject) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InputObject) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *InputObject) GetType() Type`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *InputObject) GetTypeOk() (*Type, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *InputObject) SetType(v Type)`

SetType sets Type field to given value.


### GetDescription

`func (o *InputObject) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *InputObject) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *InputObject) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *InputObject) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetDependsOn

`func (o *InputObject) GetDependsOn() DependsOn`

GetDependsOn returns the DependsOn field if non-nil, zero value otherwise.

### GetDependsOnOk

`func (o *InputObject) GetDependsOnOk() (*DependsOn, bool)`

GetDependsOnOk returns a tuple with the DependsOn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDependsOn

`func (o *InputObject) SetDependsOn(v DependsOn)`

SetDependsOn sets DependsOn field to given value.

### HasDependsOn

`func (o *InputObject) HasDependsOn() bool`

HasDependsOn returns a boolean if a field has been set.

### GetRequired

`func (o *InputObject) GetRequired() bool`

GetRequired returns the Required field if non-nil, zero value otherwise.

### GetRequiredOk

`func (o *InputObject) GetRequiredOk() (*bool, bool)`

GetRequiredOk returns a tuple with the Required field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRequired

`func (o *InputObject) SetRequired(v bool)`

SetRequired sets Required field to given value.

### HasRequired

`func (o *InputObject) HasRequired() bool`

HasRequired returns a boolean if a field has been set.

### GetDefaults

`func (o *InputObject) GetDefaults() string`

GetDefaults returns the Defaults field if non-nil, zero value otherwise.

### GetDefaultsOk

`func (o *InputObject) GetDefaultsOk() (*string, bool)`

GetDefaultsOk returns a tuple with the Defaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDefaults

`func (o *InputObject) SetDefaults(v string)`

SetDefaults sets Defaults field to given value.

### HasDefaults

`func (o *InputObject) HasDefaults() bool`

HasDefaults returns a boolean if a field has been set.

### GetDisplayName

`func (o *InputObject) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *InputObject) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *InputObject) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *InputObject) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


