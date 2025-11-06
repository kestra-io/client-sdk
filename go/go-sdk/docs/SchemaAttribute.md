# SchemaAttribute

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Attributes** | Pointer to [**[]SchemaAttribute**](SchemaAttribute.md) |  | [optional] 
**Urn** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**SchemaAttributeType**](SchemaAttributeType.md) |  | [optional] 
**SubAttributes** | Pointer to [**[]SchemaAttribute**](SchemaAttribute.md) |  | [optional] 
**MultiValued** | Pointer to **bool** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Required** | Pointer to **bool** |  | [optional] 
**CanonicalValues** | Pointer to **[]string** |  | [optional] 
**CaseExact** | Pointer to **bool** |  | [optional] 
**Mutability** | Pointer to [**SchemaAttributeMutability**](SchemaAttributeMutability.md) |  | [optional] 
**Returned** | Pointer to [**SchemaAttributeReturned**](SchemaAttributeReturned.md) |  | [optional] 
**Uniqueness** | Pointer to [**SchemaAttributeUniqueness**](SchemaAttributeUniqueness.md) |  | [optional] 
**ReferenceTypes** | Pointer to **[]string** |  | [optional] 
**Accessor** | Pointer to **map[string]interface{}** |  | [optional] 
**ScimResourceIdReference** | Pointer to **bool** |  | [optional] 

## Methods

### NewSchemaAttribute

`func NewSchemaAttribute() *SchemaAttribute`

NewSchemaAttribute instantiates a new SchemaAttribute object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSchemaAttributeWithDefaults

`func NewSchemaAttributeWithDefaults() *SchemaAttribute`

NewSchemaAttributeWithDefaults instantiates a new SchemaAttribute object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAttributes

`func (o *SchemaAttribute) GetAttributes() []SchemaAttribute`

GetAttributes returns the Attributes field if non-nil, zero value otherwise.

### GetAttributesOk

`func (o *SchemaAttribute) GetAttributesOk() (*[]SchemaAttribute, bool)`

GetAttributesOk returns a tuple with the Attributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttributes

`func (o *SchemaAttribute) SetAttributes(v []SchemaAttribute)`

SetAttributes sets Attributes field to given value.

### HasAttributes

`func (o *SchemaAttribute) HasAttributes() bool`

HasAttributes returns a boolean if a field has been set.

### GetUrn

`func (o *SchemaAttribute) GetUrn() string`

GetUrn returns the Urn field if non-nil, zero value otherwise.

### GetUrnOk

`func (o *SchemaAttribute) GetUrnOk() (*string, bool)`

GetUrnOk returns a tuple with the Urn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUrn

`func (o *SchemaAttribute) SetUrn(v string)`

SetUrn sets Urn field to given value.

### HasUrn

`func (o *SchemaAttribute) HasUrn() bool`

HasUrn returns a boolean if a field has been set.

### GetName

`func (o *SchemaAttribute) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *SchemaAttribute) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *SchemaAttribute) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *SchemaAttribute) HasName() bool`

HasName returns a boolean if a field has been set.

### GetType

`func (o *SchemaAttribute) GetType() SchemaAttributeType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *SchemaAttribute) GetTypeOk() (*SchemaAttributeType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *SchemaAttribute) SetType(v SchemaAttributeType)`

SetType sets Type field to given value.

### HasType

`func (o *SchemaAttribute) HasType() bool`

HasType returns a boolean if a field has been set.

### GetSubAttributes

`func (o *SchemaAttribute) GetSubAttributes() []SchemaAttribute`

GetSubAttributes returns the SubAttributes field if non-nil, zero value otherwise.

### GetSubAttributesOk

`func (o *SchemaAttribute) GetSubAttributesOk() (*[]SchemaAttribute, bool)`

GetSubAttributesOk returns a tuple with the SubAttributes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubAttributes

`func (o *SchemaAttribute) SetSubAttributes(v []SchemaAttribute)`

SetSubAttributes sets SubAttributes field to given value.

### HasSubAttributes

`func (o *SchemaAttribute) HasSubAttributes() bool`

HasSubAttributes returns a boolean if a field has been set.

### GetMultiValued

`func (o *SchemaAttribute) GetMultiValued() bool`

GetMultiValued returns the MultiValued field if non-nil, zero value otherwise.

### GetMultiValuedOk

`func (o *SchemaAttribute) GetMultiValuedOk() (*bool, bool)`

GetMultiValuedOk returns a tuple with the MultiValued field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMultiValued

`func (o *SchemaAttribute) SetMultiValued(v bool)`

SetMultiValued sets MultiValued field to given value.

### HasMultiValued

`func (o *SchemaAttribute) HasMultiValued() bool`

HasMultiValued returns a boolean if a field has been set.

### GetDescription

`func (o *SchemaAttribute) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *SchemaAttribute) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *SchemaAttribute) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *SchemaAttribute) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetRequired

`func (o *SchemaAttribute) GetRequired() bool`

GetRequired returns the Required field if non-nil, zero value otherwise.

### GetRequiredOk

`func (o *SchemaAttribute) GetRequiredOk() (*bool, bool)`

GetRequiredOk returns a tuple with the Required field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRequired

`func (o *SchemaAttribute) SetRequired(v bool)`

SetRequired sets Required field to given value.

### HasRequired

`func (o *SchemaAttribute) HasRequired() bool`

HasRequired returns a boolean if a field has been set.

### GetCanonicalValues

`func (o *SchemaAttribute) GetCanonicalValues() []string`

GetCanonicalValues returns the CanonicalValues field if non-nil, zero value otherwise.

### GetCanonicalValuesOk

`func (o *SchemaAttribute) GetCanonicalValuesOk() (*[]string, bool)`

GetCanonicalValuesOk returns a tuple with the CanonicalValues field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCanonicalValues

`func (o *SchemaAttribute) SetCanonicalValues(v []string)`

SetCanonicalValues sets CanonicalValues field to given value.

### HasCanonicalValues

`func (o *SchemaAttribute) HasCanonicalValues() bool`

HasCanonicalValues returns a boolean if a field has been set.

### GetCaseExact

`func (o *SchemaAttribute) GetCaseExact() bool`

GetCaseExact returns the CaseExact field if non-nil, zero value otherwise.

### GetCaseExactOk

`func (o *SchemaAttribute) GetCaseExactOk() (*bool, bool)`

GetCaseExactOk returns a tuple with the CaseExact field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCaseExact

`func (o *SchemaAttribute) SetCaseExact(v bool)`

SetCaseExact sets CaseExact field to given value.

### HasCaseExact

`func (o *SchemaAttribute) HasCaseExact() bool`

HasCaseExact returns a boolean if a field has been set.

### GetMutability

`func (o *SchemaAttribute) GetMutability() SchemaAttributeMutability`

GetMutability returns the Mutability field if non-nil, zero value otherwise.

### GetMutabilityOk

`func (o *SchemaAttribute) GetMutabilityOk() (*SchemaAttributeMutability, bool)`

GetMutabilityOk returns a tuple with the Mutability field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMutability

`func (o *SchemaAttribute) SetMutability(v SchemaAttributeMutability)`

SetMutability sets Mutability field to given value.

### HasMutability

`func (o *SchemaAttribute) HasMutability() bool`

HasMutability returns a boolean if a field has been set.

### GetReturned

`func (o *SchemaAttribute) GetReturned() SchemaAttributeReturned`

GetReturned returns the Returned field if non-nil, zero value otherwise.

### GetReturnedOk

`func (o *SchemaAttribute) GetReturnedOk() (*SchemaAttributeReturned, bool)`

GetReturnedOk returns a tuple with the Returned field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReturned

`func (o *SchemaAttribute) SetReturned(v SchemaAttributeReturned)`

SetReturned sets Returned field to given value.

### HasReturned

`func (o *SchemaAttribute) HasReturned() bool`

HasReturned returns a boolean if a field has been set.

### GetUniqueness

`func (o *SchemaAttribute) GetUniqueness() SchemaAttributeUniqueness`

GetUniqueness returns the Uniqueness field if non-nil, zero value otherwise.

### GetUniquenessOk

`func (o *SchemaAttribute) GetUniquenessOk() (*SchemaAttributeUniqueness, bool)`

GetUniquenessOk returns a tuple with the Uniqueness field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUniqueness

`func (o *SchemaAttribute) SetUniqueness(v SchemaAttributeUniqueness)`

SetUniqueness sets Uniqueness field to given value.

### HasUniqueness

`func (o *SchemaAttribute) HasUniqueness() bool`

HasUniqueness returns a boolean if a field has been set.

### GetReferenceTypes

`func (o *SchemaAttribute) GetReferenceTypes() []string`

GetReferenceTypes returns the ReferenceTypes field if non-nil, zero value otherwise.

### GetReferenceTypesOk

`func (o *SchemaAttribute) GetReferenceTypesOk() (*[]string, bool)`

GetReferenceTypesOk returns a tuple with the ReferenceTypes field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReferenceTypes

`func (o *SchemaAttribute) SetReferenceTypes(v []string)`

SetReferenceTypes sets ReferenceTypes field to given value.

### HasReferenceTypes

`func (o *SchemaAttribute) HasReferenceTypes() bool`

HasReferenceTypes returns a boolean if a field has been set.

### GetAccessor

`func (o *SchemaAttribute) GetAccessor() map[string]interface{}`

GetAccessor returns the Accessor field if non-nil, zero value otherwise.

### GetAccessorOk

`func (o *SchemaAttribute) GetAccessorOk() (*map[string]interface{}, bool)`

GetAccessorOk returns a tuple with the Accessor field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAccessor

`func (o *SchemaAttribute) SetAccessor(v map[string]interface{})`

SetAccessor sets Accessor field to given value.

### HasAccessor

`func (o *SchemaAttribute) HasAccessor() bool`

HasAccessor returns a boolean if a field has been set.

### GetScimResourceIdReference

`func (o *SchemaAttribute) GetScimResourceIdReference() bool`

GetScimResourceIdReference returns the ScimResourceIdReference field if non-nil, zero value otherwise.

### GetScimResourceIdReferenceOk

`func (o *SchemaAttribute) GetScimResourceIdReferenceOk() (*bool, bool)`

GetScimResourceIdReferenceOk returns a tuple with the ScimResourceIdReference field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetScimResourceIdReference

`func (o *SchemaAttribute) SetScimResourceIdReference(v bool)`

SetScimResourceIdReference sets ScimResourceIdReference field to given value.

### HasScimResourceIdReference

`func (o *SchemaAttribute) HasScimResourceIdReference() bool`

HasScimResourceIdReference returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


