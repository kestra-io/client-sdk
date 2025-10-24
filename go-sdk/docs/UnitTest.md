# UnitTest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Disabled** | Pointer to **bool** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Fixtures** | Pointer to [**Fixtures**](Fixtures.md) |  | [optional] 
**Assertions** | [**[]Assertion**](Assertion.md) |  | 

## Methods

### NewUnitTest

`func NewUnitTest(id string, type_ string, assertions []Assertion, ) *UnitTest`

NewUnitTest instantiates a new UnitTest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUnitTestWithDefaults

`func NewUnitTestWithDefaults() *UnitTest`

NewUnitTestWithDefaults instantiates a new UnitTest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *UnitTest) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *UnitTest) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *UnitTest) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *UnitTest) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *UnitTest) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *UnitTest) SetType(v string)`

SetType sets Type field to given value.


### GetDisabled

`func (o *UnitTest) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *UnitTest) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *UnitTest) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *UnitTest) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetDescription

`func (o *UnitTest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *UnitTest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *UnitTest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *UnitTest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetFixtures

`func (o *UnitTest) GetFixtures() Fixtures`

GetFixtures returns the Fixtures field if non-nil, zero value otherwise.

### GetFixturesOk

`func (o *UnitTest) GetFixturesOk() (*Fixtures, bool)`

GetFixturesOk returns a tuple with the Fixtures field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFixtures

`func (o *UnitTest) SetFixtures(v Fixtures)`

SetFixtures sets Fixtures field to given value.

### HasFixtures

`func (o *UnitTest) HasFixtures() bool`

HasFixtures returns a boolean if a field has been set.

### GetAssertions

`func (o *UnitTest) GetAssertions() []Assertion`

GetAssertions returns the Assertions field if non-nil, zero value otherwise.

### GetAssertionsOk

`func (o *UnitTest) GetAssertionsOk() (*[]Assertion, bool)`

GetAssertionsOk returns a tuple with the Assertions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAssertions

`func (o *UnitTest) SetAssertions(v []Assertion)`

SetAssertions sets Assertions field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


