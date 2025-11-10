# Breakpoint

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Value** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewBreakpoint

`func NewBreakpoint(id string, ) *Breakpoint`

NewBreakpoint instantiates a new Breakpoint object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBreakpointWithDefaults

`func NewBreakpointWithDefaults() *Breakpoint`

NewBreakpointWithDefaults instantiates a new Breakpoint object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Breakpoint) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Breakpoint) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Breakpoint) SetId(v string)`

SetId sets Id field to given value.


### GetValue

`func (o *Breakpoint) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *Breakpoint) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *Breakpoint) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *Breakpoint) HasValue() bool`

HasValue returns a boolean if a field has been set.

### SetValueNil

`func (o *Breakpoint) SetValueNil(b bool)`

 SetValueNil sets the value for Value to be an explicit nil

### UnsetValue
`func (o *Breakpoint) UnsetValue()`

UnsetValue ensures that no value is present for Value, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


