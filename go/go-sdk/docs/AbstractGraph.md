# AbstractGraph

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Uid** | Pointer to **string** |  | [optional] 
**Type** | Pointer to **string** |  | [optional] 
**BranchType** | Pointer to [**AbstractGraphBranchType**](AbstractGraphBranchType.md) |  | [optional] 

## Methods

### NewAbstractGraph

`func NewAbstractGraph() *AbstractGraph`

NewAbstractGraph instantiates a new AbstractGraph object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractGraphWithDefaults

`func NewAbstractGraphWithDefaults() *AbstractGraph`

NewAbstractGraphWithDefaults instantiates a new AbstractGraph object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUid

`func (o *AbstractGraph) GetUid() string`

GetUid returns the Uid field if non-nil, zero value otherwise.

### GetUidOk

`func (o *AbstractGraph) GetUidOk() (*string, bool)`

GetUidOk returns a tuple with the Uid field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUid

`func (o *AbstractGraph) SetUid(v string)`

SetUid sets Uid field to given value.

### HasUid

`func (o *AbstractGraph) HasUid() bool`

HasUid returns a boolean if a field has been set.

### GetType

`func (o *AbstractGraph) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AbstractGraph) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AbstractGraph) SetType(v string)`

SetType sets Type field to given value.

### HasType

`func (o *AbstractGraph) HasType() bool`

HasType returns a boolean if a field has been set.

### GetBranchType

`func (o *AbstractGraph) GetBranchType() AbstractGraphBranchType`

GetBranchType returns the BranchType field if non-nil, zero value otherwise.

### GetBranchTypeOk

`func (o *AbstractGraph) GetBranchTypeOk() (*AbstractGraphBranchType, bool)`

GetBranchTypeOk returns a tuple with the BranchType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBranchType

`func (o *AbstractGraph) SetBranchType(v AbstractGraphBranchType)`

SetBranchType sets BranchType field to given value.

### HasBranchType

`func (o *AbstractGraph) HasBranchType() bool`

HasBranchType returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


