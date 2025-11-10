# HttpParameters

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ConversionService** | **map[string]interface{}** |  | 
**Empty** | Pointer to **bool** |  | [optional] 

## Methods

### NewHttpParameters

`func NewHttpParameters(conversionService map[string]interface{}, ) *HttpParameters`

NewHttpParameters instantiates a new HttpParameters object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewHttpParametersWithDefaults

`func NewHttpParametersWithDefaults() *HttpParameters`

NewHttpParametersWithDefaults instantiates a new HttpParameters object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetConversionService

`func (o *HttpParameters) GetConversionService() map[string]interface{}`

GetConversionService returns the ConversionService field if non-nil, zero value otherwise.

### GetConversionServiceOk

`func (o *HttpParameters) GetConversionServiceOk() (*map[string]interface{}, bool)`

GetConversionServiceOk returns a tuple with the ConversionService field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConversionService

`func (o *HttpParameters) SetConversionService(v map[string]interface{})`

SetConversionService sets ConversionService field to given value.


### GetEmpty

`func (o *HttpParameters) GetEmpty() bool`

GetEmpty returns the Empty field if non-nil, zero value otherwise.

### GetEmptyOk

`func (o *HttpParameters) GetEmptyOk() (*bool, bool)`

GetEmptyOk returns a tuple with the Empty field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmpty

`func (o *HttpParameters) SetEmpty(v bool)`

SetEmpty sets Empty field to given value.

### HasEmpty

`func (o *HttpParameters) HasEmpty() bool`

HasEmpty returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


