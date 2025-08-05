# PluginDefault

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | **string** |  | 
**Forced** | Pointer to **bool** |  | [optional] 
**Values** | Pointer to **map[string]map[string]interface{}** |  | [optional] 

## Methods

### NewPluginDefault

`func NewPluginDefault(type_ string, ) *PluginDefault`

NewPluginDefault instantiates a new PluginDefault object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPluginDefaultWithDefaults

`func NewPluginDefaultWithDefaults() *PluginDefault`

NewPluginDefaultWithDefaults instantiates a new PluginDefault object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *PluginDefault) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *PluginDefault) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *PluginDefault) SetType(v string)`

SetType sets Type field to given value.


### GetForced

`func (o *PluginDefault) GetForced() bool`

GetForced returns the Forced field if non-nil, zero value otherwise.

### GetForcedOk

`func (o *PluginDefault) GetForcedOk() (*bool, bool)`

GetForcedOk returns a tuple with the Forced field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetForced

`func (o *PluginDefault) SetForced(v bool)`

SetForced sets Forced field to given value.

### HasForced

`func (o *PluginDefault) HasForced() bool`

HasForced returns a boolean if a field has been set.

### GetValues

`func (o *PluginDefault) GetValues() map[string]map[string]interface{}`

GetValues returns the Values field if non-nil, zero value otherwise.

### GetValuesOk

`func (o *PluginDefault) GetValuesOk() (*map[string]map[string]interface{}, bool)`

GetValuesOk returns a tuple with the Values field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValues

`func (o *PluginDefault) SetValues(v map[string]map[string]interface{})`

SetValues sets Values field to given value.

### HasValues

`func (o *PluginDefault) HasValues() bool`

HasValues returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


