# Isolation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**DeniedServices** | Pointer to [**[]ServiceType**](ServiceType.md) |  | [optional] 
**Enabled** | Pointer to **bool** |  | [optional] 

## Methods

### NewIsolation

`func NewIsolation() *Isolation`

NewIsolation instantiates a new Isolation object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIsolationWithDefaults

`func NewIsolationWithDefaults() *Isolation`

NewIsolationWithDefaults instantiates a new Isolation object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDeniedServices

`func (o *Isolation) GetDeniedServices() []ServiceType`

GetDeniedServices returns the DeniedServices field if non-nil, zero value otherwise.

### GetDeniedServicesOk

`func (o *Isolation) GetDeniedServicesOk() (*[]ServiceType, bool)`

GetDeniedServicesOk returns a tuple with the DeniedServices field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeniedServices

`func (o *Isolation) SetDeniedServices(v []ServiceType)`

SetDeniedServices sets DeniedServices field to given value.

### HasDeniedServices

`func (o *Isolation) HasDeniedServices() bool`

HasDeniedServices returns a boolean if a field has been set.

### GetEnabled

`func (o *Isolation) GetEnabled() bool`

GetEnabled returns the Enabled field if non-nil, zero value otherwise.

### GetEnabledOk

`func (o *Isolation) GetEnabledOk() (*bool, bool)`

GetEnabledOk returns a tuple with the Enabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEnabled

`func (o *Isolation) SetEnabled(v bool)`

SetEnabled sets Enabled field to given value.

### HasEnabled

`func (o *Isolation) HasEnabled() bool`

HasEnabled returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


