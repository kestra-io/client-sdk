# ServerInstance

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | [**ServerInstanceType**](ServerInstanceType.md) |  | 
**Version** | **string** |  | 
**Hostname** | **string** |  | 
**Props** | **map[string]interface{}** |  | 
**Metrics** | [**[]Metric**](Metric.md) |  | 

## Methods

### NewServerInstance

`func NewServerInstance(id string, type_ ServerInstanceType, version string, hostname string, props map[string]interface{}, metrics []Metric, ) *ServerInstance`

NewServerInstance instantiates a new ServerInstance object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServerInstanceWithDefaults

`func NewServerInstanceWithDefaults() *ServerInstance`

NewServerInstanceWithDefaults instantiates a new ServerInstance object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ServerInstance) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ServerInstance) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ServerInstance) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *ServerInstance) GetType() ServerInstanceType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ServerInstance) GetTypeOk() (*ServerInstanceType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ServerInstance) SetType(v ServerInstanceType)`

SetType sets Type field to given value.


### GetVersion

`func (o *ServerInstance) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *ServerInstance) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *ServerInstance) SetVersion(v string)`

SetVersion sets Version field to given value.


### GetHostname

`func (o *ServerInstance) GetHostname() string`

GetHostname returns the Hostname field if non-nil, zero value otherwise.

### GetHostnameOk

`func (o *ServerInstance) GetHostnameOk() (*string, bool)`

GetHostnameOk returns a tuple with the Hostname field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHostname

`func (o *ServerInstance) SetHostname(v string)`

SetHostname sets Hostname field to given value.


### GetProps

`func (o *ServerInstance) GetProps() map[string]interface{}`

GetProps returns the Props field if non-nil, zero value otherwise.

### GetPropsOk

`func (o *ServerInstance) GetPropsOk() (*map[string]interface{}, bool)`

GetPropsOk returns a tuple with the Props field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetProps

`func (o *ServerInstance) SetProps(v map[string]interface{})`

SetProps sets Props field to given value.


### GetMetrics

`func (o *ServerInstance) GetMetrics() []Metric`

GetMetrics returns the Metrics field if non-nil, zero value otherwise.

### GetMetricsOk

`func (o *ServerInstance) GetMetricsOk() (*[]Metric, bool)`

GetMetricsOk returns a tuple with the Metrics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetrics

`func (o *ServerInstance) SetMetrics(v []Metric)`

SetMetrics sets Metrics field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


