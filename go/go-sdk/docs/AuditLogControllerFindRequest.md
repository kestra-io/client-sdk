# AuditLogControllerFindRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Resource** | Pointer to [**ResourceType**](ResourceType.md) |  | [optional] 
**Type** | Pointer to [**NullableCrudEventType**](CrudEventType.md) |  | [optional] 
**Detail** | Pointer to **map[string]map[string]interface{}** |  | [optional] 

## Methods

### NewAuditLogControllerFindRequest

`func NewAuditLogControllerFindRequest() *AuditLogControllerFindRequest`

NewAuditLogControllerFindRequest instantiates a new AuditLogControllerFindRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAuditLogControllerFindRequestWithDefaults

`func NewAuditLogControllerFindRequestWithDefaults() *AuditLogControllerFindRequest`

NewAuditLogControllerFindRequestWithDefaults instantiates a new AuditLogControllerFindRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResource

`func (o *AuditLogControllerFindRequest) GetResource() ResourceType`

GetResource returns the Resource field if non-nil, zero value otherwise.

### GetResourceOk

`func (o *AuditLogControllerFindRequest) GetResourceOk() (*ResourceType, bool)`

GetResourceOk returns a tuple with the Resource field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResource

`func (o *AuditLogControllerFindRequest) SetResource(v ResourceType)`

SetResource sets Resource field to given value.

### HasResource

`func (o *AuditLogControllerFindRequest) HasResource() bool`

HasResource returns a boolean if a field has been set.

### GetType

`func (o *AuditLogControllerFindRequest) GetType() CrudEventType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AuditLogControllerFindRequest) GetTypeOk() (*CrudEventType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AuditLogControllerFindRequest) SetType(v CrudEventType)`

SetType sets Type field to given value.

### HasType

`func (o *AuditLogControllerFindRequest) HasType() bool`

HasType returns a boolean if a field has been set.

### SetTypeNil

`func (o *AuditLogControllerFindRequest) SetTypeNil(b bool)`

 SetTypeNil sets the value for Type to be an explicit nil

### UnsetType
`func (o *AuditLogControllerFindRequest) UnsetType()`

UnsetType ensures that no value is present for Type, not even an explicit nil
### GetDetail

`func (o *AuditLogControllerFindRequest) GetDetail() map[string]map[string]interface{}`

GetDetail returns the Detail field if non-nil, zero value otherwise.

### GetDetailOk

`func (o *AuditLogControllerFindRequest) GetDetailOk() (*map[string]map[string]interface{}, bool)`

GetDetailOk returns a tuple with the Detail field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDetail

`func (o *AuditLogControllerFindRequest) SetDetail(v map[string]map[string]interface{})`

SetDetail sets Detail field to given value.

### HasDetail

`func (o *AuditLogControllerFindRequest) HasDetail() bool`

HasDetail returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


