# InstanceControllerApiServerInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**ServerInstanceType**](ServerInstanceType.md) |  | [optional] 
**Version** | Pointer to **string** |  | [optional] 
**Hostname** | Pointer to **string** |  | [optional] 

## Methods

### NewInstanceControllerApiServerInstance

`func NewInstanceControllerApiServerInstance() *InstanceControllerApiServerInstance`

NewInstanceControllerApiServerInstance instantiates a new InstanceControllerApiServerInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiServerInstanceWithDefaults

`func NewInstanceControllerApiServerInstanceWithDefaults() *InstanceControllerApiServerInstance`

NewInstanceControllerApiServerInstanceWithDefaults instantiates a new InstanceControllerApiServerInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *InstanceControllerApiServerInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InstanceControllerApiServerInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InstanceControllerApiServerInstance) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *InstanceControllerApiServerInstance) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *InstanceControllerApiServerInstance) GetType() ServerInstanceType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *InstanceControllerApiServerInstance) GetTypeOk() (*ServerInstanceType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *InstanceControllerApiServerInstance) SetType(v ServerInstanceType)`

SetType sets Type field to given value.

### HasType

`func (o *InstanceControllerApiServerInstance) HasType() bool`

HasType returns a boolean if a field has been set.

### GetVersion

`func (o *InstanceControllerApiServerInstance) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *InstanceControllerApiServerInstance) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *InstanceControllerApiServerInstance) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *InstanceControllerApiServerInstance) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetHostname

`func (o *InstanceControllerApiServerInstance) GetHostname() string`

GetHostname returns the Hostname field if non-nil, zero value otherwise.

### GetHostnameOk

`func (o *InstanceControllerApiServerInstance) GetHostnameOk() (*string, bool)`

GetHostnameOk returns a tuple with the Hostname field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHostname

`func (o *InstanceControllerApiServerInstance) SetHostname(v string)`

SetHostname sets Hostname field to given value.

### HasHostname

`func (o *InstanceControllerApiServerInstance) HasHostname() bool`

HasHostname returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


