# CreateSecurityIntegrationRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** | The name of security integration. | 
**Description** | **string** | The description of security integration. | 
**Type** | [**SecurityIntegrationType**](SecurityIntegrationType.md) |  | 

## Methods

### NewCreateSecurityIntegrationRequest

`func NewCreateSecurityIntegrationRequest(name string, description string, type_ SecurityIntegrationType, ) *CreateSecurityIntegrationRequest`

NewCreateSecurityIntegrationRequest instantiates a new CreateSecurityIntegrationRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewCreateSecurityIntegrationRequestWithDefaults

`func NewCreateSecurityIntegrationRequestWithDefaults() *CreateSecurityIntegrationRequest`

NewCreateSecurityIntegrationRequestWithDefaults instantiates a new CreateSecurityIntegrationRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *CreateSecurityIntegrationRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *CreateSecurityIntegrationRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *CreateSecurityIntegrationRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *CreateSecurityIntegrationRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *CreateSecurityIntegrationRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *CreateSecurityIntegrationRequest) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetType

`func (o *CreateSecurityIntegrationRequest) GetType() SecurityIntegrationType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *CreateSecurityIntegrationRequest) GetTypeOk() (*SecurityIntegrationType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *CreateSecurityIntegrationRequest) SetType(v SecurityIntegrationType)`

SetType sets Type field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


