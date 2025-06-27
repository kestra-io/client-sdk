# SLA

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | [**SLAType**](SLAType.md) |  | 
**Behavior** | [**SLABehavior**](SLABehavior.md) |  | 
**Labels** | Pointer to [**AbstractFlowLabels**](AbstractFlowLabels.md) |  | [optional] 

## Methods

### NewSLA

`func NewSLA(id string, type_ SLAType, behavior SLABehavior, ) *SLA`

NewSLA instantiates a new SLA object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSLAWithDefaults

`func NewSLAWithDefaults() *SLA`

NewSLAWithDefaults instantiates a new SLA object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *SLA) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *SLA) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *SLA) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *SLA) GetType() SLAType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *SLA) GetTypeOk() (*SLAType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *SLA) SetType(v SLAType)`

SetType sets Type field to given value.


### GetBehavior

`func (o *SLA) GetBehavior() SLABehavior`

GetBehavior returns the Behavior field if non-nil, zero value otherwise.

### GetBehaviorOk

`func (o *SLA) GetBehaviorOk() (*SLABehavior, bool)`

GetBehaviorOk returns a tuple with the Behavior field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBehavior

`func (o *SLA) SetBehavior(v SLABehavior)`

SetBehavior sets Behavior field to given value.


### GetLabels

`func (o *SLA) GetLabels() AbstractFlowLabels`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *SLA) GetLabelsOk() (*AbstractFlowLabels, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *SLA) SetLabels(v AbstractFlowLabels)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *SLA) HasLabels() bool`

HasLabels returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


