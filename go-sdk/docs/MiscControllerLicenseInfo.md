# MiscControllerLicenseInfo

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | **string** |  | 
**Expiry** | **time.Time** |  | 
**Expired** | **bool** |  | 
**MaxServers** | **int32** |  | 
**Standalone** | **bool** |  | 
**WorkerGroups** | **bool** |  | 

## Methods

### NewMiscControllerLicenseInfo

`func NewMiscControllerLicenseInfo(type_ string, expiry time.Time, expired bool, maxServers int32, standalone bool, workerGroups bool, ) *MiscControllerLicenseInfo`

NewMiscControllerLicenseInfo instantiates a new MiscControllerLicenseInfo object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMiscControllerLicenseInfoWithDefaults

`func NewMiscControllerLicenseInfoWithDefaults() *MiscControllerLicenseInfo`

NewMiscControllerLicenseInfoWithDefaults instantiates a new MiscControllerLicenseInfo object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *MiscControllerLicenseInfo) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *MiscControllerLicenseInfo) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *MiscControllerLicenseInfo) SetType(v string)`

SetType sets Type field to given value.


### GetExpiry

`func (o *MiscControllerLicenseInfo) GetExpiry() time.Time`

GetExpiry returns the Expiry field if non-nil, zero value otherwise.

### GetExpiryOk

`func (o *MiscControllerLicenseInfo) GetExpiryOk() (*time.Time, bool)`

GetExpiryOk returns a tuple with the Expiry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpiry

`func (o *MiscControllerLicenseInfo) SetExpiry(v time.Time)`

SetExpiry sets Expiry field to given value.


### GetExpired

`func (o *MiscControllerLicenseInfo) GetExpired() bool`

GetExpired returns the Expired field if non-nil, zero value otherwise.

### GetExpiredOk

`func (o *MiscControllerLicenseInfo) GetExpiredOk() (*bool, bool)`

GetExpiredOk returns a tuple with the Expired field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpired

`func (o *MiscControllerLicenseInfo) SetExpired(v bool)`

SetExpired sets Expired field to given value.


### GetMaxServers

`func (o *MiscControllerLicenseInfo) GetMaxServers() int32`

GetMaxServers returns the MaxServers field if non-nil, zero value otherwise.

### GetMaxServersOk

`func (o *MiscControllerLicenseInfo) GetMaxServersOk() (*int32, bool)`

GetMaxServersOk returns a tuple with the MaxServers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMaxServers

`func (o *MiscControllerLicenseInfo) SetMaxServers(v int32)`

SetMaxServers sets MaxServers field to given value.


### GetStandalone

`func (o *MiscControllerLicenseInfo) GetStandalone() bool`

GetStandalone returns the Standalone field if non-nil, zero value otherwise.

### GetStandaloneOk

`func (o *MiscControllerLicenseInfo) GetStandaloneOk() (*bool, bool)`

GetStandaloneOk returns a tuple with the Standalone field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStandalone

`func (o *MiscControllerLicenseInfo) SetStandalone(v bool)`

SetStandalone sets Standalone field to given value.


### GetWorkerGroups

`func (o *MiscControllerLicenseInfo) GetWorkerGroups() bool`

GetWorkerGroups returns the WorkerGroups field if non-nil, zero value otherwise.

### GetWorkerGroupsOk

`func (o *MiscControllerLicenseInfo) GetWorkerGroupsOk() (*bool, bool)`

GetWorkerGroupsOk returns a tuple with the WorkerGroups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroups

`func (o *MiscControllerLicenseInfo) SetWorkerGroups(v bool)`

SetWorkerGroups sets WorkerGroups field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


