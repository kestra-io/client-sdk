# EventAppResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Data** | Pointer to [**AppResponse**](AppResponse.md) |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Comment** | Pointer to **string** |  | [optional] 
**Retry** | Pointer to **string** |  | [optional] 

## Methods

### NewEventAppResponse

`func NewEventAppResponse() *EventAppResponse`

NewEventAppResponse instantiates a new EventAppResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewEventAppResponseWithDefaults

`func NewEventAppResponseWithDefaults() *EventAppResponse`

NewEventAppResponseWithDefaults instantiates a new EventAppResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetData

`func (o *EventAppResponse) GetData() AppResponse`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *EventAppResponse) GetDataOk() (*AppResponse, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *EventAppResponse) SetData(v AppResponse)`

SetData sets Data field to given value.

### HasData

`func (o *EventAppResponse) HasData() bool`

HasData returns a boolean if a field has been set.

### GetId

`func (o *EventAppResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *EventAppResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *EventAppResponse) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *EventAppResponse) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *EventAppResponse) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *EventAppResponse) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *EventAppResponse) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *EventAppResponse) HasName() bool`

HasName returns a boolean if a field has been set.

### GetComment

`func (o *EventAppResponse) GetComment() string`

GetComment returns the Comment field if non-nil, zero value otherwise.

### GetCommentOk

`func (o *EventAppResponse) GetCommentOk() (*string, bool)`

GetCommentOk returns a tuple with the Comment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetComment

`func (o *EventAppResponse) SetComment(v string)`

SetComment sets Comment field to given value.

### HasComment

`func (o *EventAppResponse) HasComment() bool`

HasComment returns a boolean if a field has been set.

### GetRetry

`func (o *EventAppResponse) GetRetry() string`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *EventAppResponse) GetRetryOk() (*string, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *EventAppResponse) SetRetry(v string)`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *EventAppResponse) HasRetry() bool`

HasRetry returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


