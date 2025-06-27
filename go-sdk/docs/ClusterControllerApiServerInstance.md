# ClusterControllerApiServerInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | [**ServerInstanceType**](ServerInstanceType.md) |  | 
**Version** | **string** |  | 
**Hostname** | **string** |  | 

## Methods

### NewClusterControllerApiServerInstance

`func NewClusterControllerApiServerInstance(id string, type_ ServerInstanceType, version string, hostname string, ) *ClusterControllerApiServerInstance`

NewClusterControllerApiServerInstance instantiates a new ClusterControllerApiServerInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiServerInstanceWithDefaults

`func NewClusterControllerApiServerInstanceWithDefaults() *ClusterControllerApiServerInstance`

NewClusterControllerApiServerInstanceWithDefaults instantiates a new ClusterControllerApiServerInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ClusterControllerApiServerInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ClusterControllerApiServerInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ClusterControllerApiServerInstance) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *ClusterControllerApiServerInstance) GetType() ServerInstanceType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ClusterControllerApiServerInstance) GetTypeOk() (*ServerInstanceType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ClusterControllerApiServerInstance) SetType(v ServerInstanceType)`

SetType sets Type field to given value.


### GetVersion

`func (o *ClusterControllerApiServerInstance) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *ClusterControllerApiServerInstance) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *ClusterControllerApiServerInstance) SetVersion(v string)`

SetVersion sets Version field to given value.


### GetHostname

`func (o *ClusterControllerApiServerInstance) GetHostname() string`

GetHostname returns the Hostname field if non-nil, zero value otherwise.

### GetHostnameOk

`func (o *ClusterControllerApiServerInstance) GetHostnameOk() (*string, bool)`

GetHostnameOk returns a tuple with the Hostname field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHostname

`func (o *ClusterControllerApiServerInstance) SetHostname(v string)`

SetHostname sets Hostname field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


