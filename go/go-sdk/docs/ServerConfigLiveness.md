# ServerConfigLiveness

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Enabled** | **bool** |  | [default to true]
**Interval** | **string** |  | [default to "5s"]
**Timeout** | **string** |  | [default to "45s"]
**InitialDelay** | **string** |  | [default to "45s"]
**HeartbeatInterval** | **string** |  | [default to "3s"]

## Methods

### NewServerConfigLiveness

`func NewServerConfigLiveness(enabled bool, interval string, timeout string, initialDelay string, heartbeatInterval string, ) *ServerConfigLiveness`

NewServerConfigLiveness instantiates a new ServerConfigLiveness object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServerConfigLivenessWithDefaults

`func NewServerConfigLivenessWithDefaults() *ServerConfigLiveness`

NewServerConfigLivenessWithDefaults instantiates a new ServerConfigLiveness object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetEnabled

`func (o *ServerConfigLiveness) GetEnabled() bool`

GetEnabled returns the Enabled field if non-nil, zero value otherwise.

### GetEnabledOk

`func (o *ServerConfigLiveness) GetEnabledOk() (*bool, bool)`

GetEnabledOk returns a tuple with the Enabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnabled

`func (o *ServerConfigLiveness) SetEnabled(v bool)`

SetEnabled sets Enabled field to given value.


### GetInterval

`func (o *ServerConfigLiveness) GetInterval() string`

GetInterval returns the Interval field if non-nil, zero value otherwise.

### GetIntervalOk

`func (o *ServerConfigLiveness) GetIntervalOk() (*string, bool)`

GetIntervalOk returns a tuple with the Interval field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInterval

`func (o *ServerConfigLiveness) SetInterval(v string)`

SetInterval sets Interval field to given value.


### GetTimeout

`func (o *ServerConfigLiveness) GetTimeout() string`

GetTimeout returns the Timeout field if non-nil, zero value otherwise.

### GetTimeoutOk

`func (o *ServerConfigLiveness) GetTimeoutOk() (*string, bool)`

GetTimeoutOk returns a tuple with the Timeout field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimeout

`func (o *ServerConfigLiveness) SetTimeout(v string)`

SetTimeout sets Timeout field to given value.


### GetInitialDelay

`func (o *ServerConfigLiveness) GetInitialDelay() string`

GetInitialDelay returns the InitialDelay field if non-nil, zero value otherwise.

### GetInitialDelayOk

`func (o *ServerConfigLiveness) GetInitialDelayOk() (*string, bool)`

GetInitialDelayOk returns a tuple with the InitialDelay field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInitialDelay

`func (o *ServerConfigLiveness) SetInitialDelay(v string)`

SetInitialDelay sets InitialDelay field to given value.


### GetHeartbeatInterval

`func (o *ServerConfigLiveness) GetHeartbeatInterval() string`

GetHeartbeatInterval returns the HeartbeatInterval field if non-nil, zero value otherwise.

### GetHeartbeatIntervalOk

`func (o *ServerConfigLiveness) GetHeartbeatIntervalOk() (*string, bool)`

GetHeartbeatIntervalOk returns a tuple with the HeartbeatInterval field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetHeartbeatInterval

`func (o *ServerConfigLiveness) SetHeartbeatInterval(v string)`

SetHeartbeatInterval sets HeartbeatInterval field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


