# ApiAuth

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uid** | Pointer to **string** |  | [optional] 
**Type** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 

## Methods

### NewApiAuth

`func NewApiAuth() *ApiAuth`

NewApiAuth instantiates a new ApiAuth object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiAuthWithDefaults

`func NewApiAuthWithDefaults() *ApiAuth`

NewApiAuthWithDefaults instantiates a new ApiAuth object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUid

`func (o *ApiAuth) GetUid() string`

GetUid returns the Uid field if non-nil, zero value otherwise.

### GetUidOk

`func (o *ApiAuth) GetUidOk() (*string, bool)`

GetUidOk returns a tuple with the Uid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUid

`func (o *ApiAuth) SetUid(v string)`

SetUid sets Uid field to given value.

### HasUid

`func (o *ApiAuth) HasUid() bool`

HasUid returns a boolean if a field has been set.

### GetType

`func (o *ApiAuth) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ApiAuth) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ApiAuth) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *ApiAuth) HasType() bool`

HasType returns a boolean if a field has been set.

### GetName

`func (o *ApiAuth) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ApiAuth) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ApiAuth) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *ApiAuth) HasName() bool`

HasName returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


