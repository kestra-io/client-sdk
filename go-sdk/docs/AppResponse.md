# AppResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Dispatch** | **string** |  | 
**Stream** | **string** |  | 
**Layout** | [**AppResponseUILayout**](AppResponseUILayout.md) |  | 

## Methods

### NewAppResponse

`func NewAppResponse(dispatch string, stream string, layout AppResponseUILayout, ) *AppResponse`

NewAppResponse instantiates a new AppResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAppResponseWithDefaults

`func NewAppResponseWithDefaults() *AppResponse`

NewAppResponseWithDefaults instantiates a new AppResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDispatch

`func (o *AppResponse) GetDispatch() string`

GetDispatch returns the Dispatch field if non-nil, zero value otherwise.

### GetDispatchOk

`func (o *AppResponse) GetDispatchOk() (*string, bool)`

GetDispatchOk returns a tuple with the Dispatch field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDispatch

`func (o *AppResponse) SetDispatch(v string)`

SetDispatch sets Dispatch field to given value.


### GetStream

`func (o *AppResponse) GetStream() string`

GetStream returns the Stream field if non-nil, zero value otherwise.

### GetStreamOk

`func (o *AppResponse) GetStreamOk() (*string, bool)`

GetStreamOk returns a tuple with the Stream field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStream

`func (o *AppResponse) SetStream(v string)`

SetStream sets Stream field to given value.


### GetLayout

`func (o *AppResponse) GetLayout() AppResponseUILayout`

GetLayout returns the Layout field if non-nil, zero value otherwise.

### GetLayoutOk

`func (o *AppResponse) GetLayoutOk() (*AppResponseUILayout, bool)`

GetLayoutOk returns a tuple with the Layout field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLayout

`func (o *AppResponse) SetLayout(v AppResponseUILayout)`

SetLayout sets Layout field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


