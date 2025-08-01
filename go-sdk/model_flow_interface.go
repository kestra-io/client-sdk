/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
)

// checks if the FlowInterface type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &FlowInterface{}

// FlowInterface struct for FlowInterface
type FlowInterface struct {
	Id                   *string                `json:"id,omitempty"`
	Namespace            *string                `json:"namespace,omitempty"`
	Revision             *int32                 `json:"revision,omitempty"`
	TenantId             *string                `json:"tenantId,omitempty"`
	Deleted              *bool                  `json:"deleted,omitempty"`
	Disabled             *bool                  `json:"disabled,omitempty"`
	Labels               []Label                `json:"labels,omitempty"`
	Inputs               []InputObject          `json:"inputs,omitempty"`
	Outputs              []Output               `json:"outputs,omitempty"`
	Variables            map[string]interface{} `json:"variables,omitempty"`
	WorkerGroup          *WorkerGroup           `json:"workerGroup,omitempty"`
	Concurrency          *Concurrency           `json:"concurrency,omitempty"`
	Sla                  []SLA                  `json:"sla,omitempty"`
	Source               *string                `json:"source,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _FlowInterface FlowInterface

// NewFlowInterface instantiates a new FlowInterface object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewFlowInterface() *FlowInterface {
	this := FlowInterface{}
	return &this
}

// NewFlowInterfaceWithDefaults instantiates a new FlowInterface object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewFlowInterfaceWithDefaults() *FlowInterface {
	this := FlowInterface{}
	return &this
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *FlowInterface) GetId() string {
	if o == nil || IsNil(o.Id) {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetIdOk() (*string, bool) {
	if o == nil || IsNil(o.Id) {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *FlowInterface) HasId() bool {
	if o != nil && !IsNil(o.Id) {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *FlowInterface) SetId(v string) {
	o.Id = &v
}

// GetNamespace returns the Namespace field value if set, zero value otherwise.
func (o *FlowInterface) GetNamespace() string {
	if o == nil || IsNil(o.Namespace) {
		var ret string
		return ret
	}
	return *o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetNamespaceOk() (*string, bool) {
	if o == nil || IsNil(o.Namespace) {
		return nil, false
	}
	return o.Namespace, true
}

// HasNamespace returns a boolean if a field has been set.
func (o *FlowInterface) HasNamespace() bool {
	if o != nil && !IsNil(o.Namespace) {
		return true
	}

	return false
}

// SetNamespace gets a reference to the given string and assigns it to the Namespace field.
func (o *FlowInterface) SetNamespace(v string) {
	o.Namespace = &v
}

// GetRevision returns the Revision field value if set, zero value otherwise.
func (o *FlowInterface) GetRevision() int32 {
	if o == nil || IsNil(o.Revision) {
		var ret int32
		return ret
	}
	return *o.Revision
}

// GetRevisionOk returns a tuple with the Revision field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetRevisionOk() (*int32, bool) {
	if o == nil || IsNil(o.Revision) {
		return nil, false
	}
	return o.Revision, true
}

// HasRevision returns a boolean if a field has been set.
func (o *FlowInterface) HasRevision() bool {
	if o != nil && !IsNil(o.Revision) {
		return true
	}

	return false
}

// SetRevision gets a reference to the given int32 and assigns it to the Revision field.
func (o *FlowInterface) SetRevision(v int32) {
	o.Revision = &v
}

// GetTenantId returns the TenantId field value if set, zero value otherwise.
func (o *FlowInterface) GetTenantId() string {
	if o == nil || IsNil(o.TenantId) {
		var ret string
		return ret
	}
	return *o.TenantId
}

// GetTenantIdOk returns a tuple with the TenantId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetTenantIdOk() (*string, bool) {
	if o == nil || IsNil(o.TenantId) {
		return nil, false
	}
	return o.TenantId, true
}

// HasTenantId returns a boolean if a field has been set.
func (o *FlowInterface) HasTenantId() bool {
	if o != nil && !IsNil(o.TenantId) {
		return true
	}

	return false
}

// SetTenantId gets a reference to the given string and assigns it to the TenantId field.
func (o *FlowInterface) SetTenantId(v string) {
	o.TenantId = &v
}

// GetDeleted returns the Deleted field value if set, zero value otherwise.
func (o *FlowInterface) GetDeleted() bool {
	if o == nil || IsNil(o.Deleted) {
		var ret bool
		return ret
	}
	return *o.Deleted
}

// GetDeletedOk returns a tuple with the Deleted field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetDeletedOk() (*bool, bool) {
	if o == nil || IsNil(o.Deleted) {
		return nil, false
	}
	return o.Deleted, true
}

// HasDeleted returns a boolean if a field has been set.
func (o *FlowInterface) HasDeleted() bool {
	if o != nil && !IsNil(o.Deleted) {
		return true
	}

	return false
}

// SetDeleted gets a reference to the given bool and assigns it to the Deleted field.
func (o *FlowInterface) SetDeleted(v bool) {
	o.Deleted = &v
}

// GetDisabled returns the Disabled field value if set, zero value otherwise.
func (o *FlowInterface) GetDisabled() bool {
	if o == nil || IsNil(o.Disabled) {
		var ret bool
		return ret
	}
	return *o.Disabled
}

// GetDisabledOk returns a tuple with the Disabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetDisabledOk() (*bool, bool) {
	if o == nil || IsNil(o.Disabled) {
		return nil, false
	}
	return o.Disabled, true
}

// HasDisabled returns a boolean if a field has been set.
func (o *FlowInterface) HasDisabled() bool {
	if o != nil && !IsNil(o.Disabled) {
		return true
	}

	return false
}

// SetDisabled gets a reference to the given bool and assigns it to the Disabled field.
func (o *FlowInterface) SetDisabled(v bool) {
	o.Disabled = &v
}

// GetLabels returns the Labels field value if set, zero value otherwise.
func (o *FlowInterface) GetLabels() []Label {
	if o == nil || IsNil(o.Labels) {
		var ret []Label
		return ret
	}
	return o.Labels
}

// GetLabelsOk returns a tuple with the Labels field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetLabelsOk() ([]Label, bool) {
	if o == nil || IsNil(o.Labels) {
		return nil, false
	}
	return o.Labels, true
}

// HasLabels returns a boolean if a field has been set.
func (o *FlowInterface) HasLabels() bool {
	if o != nil && !IsNil(o.Labels) {
		return true
	}

	return false
}

// SetLabels gets a reference to the given []Label and assigns it to the Labels field.
func (o *FlowInterface) SetLabels(v []Label) {
	o.Labels = v
}

// GetInputs returns the Inputs field value if set, zero value otherwise.
func (o *FlowInterface) GetInputs() []InputObject {
	if o == nil || IsNil(o.Inputs) {
		var ret []InputObject
		return ret
	}
	return o.Inputs
}

// GetInputsOk returns a tuple with the Inputs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetInputsOk() ([]InputObject, bool) {
	if o == nil || IsNil(o.Inputs) {
		return nil, false
	}
	return o.Inputs, true
}

// HasInputs returns a boolean if a field has been set.
func (o *FlowInterface) HasInputs() bool {
	if o != nil && !IsNil(o.Inputs) {
		return true
	}

	return false
}

// SetInputs gets a reference to the given []InputObject and assigns it to the Inputs field.
func (o *FlowInterface) SetInputs(v []InputObject) {
	o.Inputs = v
}

// GetOutputs returns the Outputs field value if set, zero value otherwise.
func (o *FlowInterface) GetOutputs() []Output {
	if o == nil || IsNil(o.Outputs) {
		var ret []Output
		return ret
	}
	return o.Outputs
}

// GetOutputsOk returns a tuple with the Outputs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetOutputsOk() ([]Output, bool) {
	if o == nil || IsNil(o.Outputs) {
		return nil, false
	}
	return o.Outputs, true
}

// HasOutputs returns a boolean if a field has been set.
func (o *FlowInterface) HasOutputs() bool {
	if o != nil && !IsNil(o.Outputs) {
		return true
	}

	return false
}

// SetOutputs gets a reference to the given []Output and assigns it to the Outputs field.
func (o *FlowInterface) SetOutputs(v []Output) {
	o.Outputs = v
}

// GetVariables returns the Variables field value if set, zero value otherwise.
func (o *FlowInterface) GetVariables() map[string]interface{} {
	if o == nil || IsNil(o.Variables) {
		var ret map[string]interface{}
		return ret
	}
	return o.Variables
}

// GetVariablesOk returns a tuple with the Variables field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetVariablesOk() (map[string]interface{}, bool) {
	if o == nil || IsNil(o.Variables) {
		return map[string]interface{}{}, false
	}
	return o.Variables, true
}

// HasVariables returns a boolean if a field has been set.
func (o *FlowInterface) HasVariables() bool {
	if o != nil && !IsNil(o.Variables) {
		return true
	}

	return false
}

// SetVariables gets a reference to the given map[string]interface{} and assigns it to the Variables field.
func (o *FlowInterface) SetVariables(v map[string]interface{}) {
	o.Variables = v
}

// GetWorkerGroup returns the WorkerGroup field value if set, zero value otherwise.
func (o *FlowInterface) GetWorkerGroup() WorkerGroup {
	if o == nil || IsNil(o.WorkerGroup) {
		var ret WorkerGroup
		return ret
	}
	return *o.WorkerGroup
}

// GetWorkerGroupOk returns a tuple with the WorkerGroup field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetWorkerGroupOk() (*WorkerGroup, bool) {
	if o == nil || IsNil(o.WorkerGroup) {
		return nil, false
	}
	return o.WorkerGroup, true
}

// HasWorkerGroup returns a boolean if a field has been set.
func (o *FlowInterface) HasWorkerGroup() bool {
	if o != nil && !IsNil(o.WorkerGroup) {
		return true
	}

	return false
}

// SetWorkerGroup gets a reference to the given WorkerGroup and assigns it to the WorkerGroup field.
func (o *FlowInterface) SetWorkerGroup(v WorkerGroup) {
	o.WorkerGroup = &v
}

// GetConcurrency returns the Concurrency field value if set, zero value otherwise.
func (o *FlowInterface) GetConcurrency() Concurrency {
	if o == nil || IsNil(o.Concurrency) {
		var ret Concurrency
		return ret
	}
	return *o.Concurrency
}

// GetConcurrencyOk returns a tuple with the Concurrency field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetConcurrencyOk() (*Concurrency, bool) {
	if o == nil || IsNil(o.Concurrency) {
		return nil, false
	}
	return o.Concurrency, true
}

// HasConcurrency returns a boolean if a field has been set.
func (o *FlowInterface) HasConcurrency() bool {
	if o != nil && !IsNil(o.Concurrency) {
		return true
	}

	return false
}

// SetConcurrency gets a reference to the given Concurrency and assigns it to the Concurrency field.
func (o *FlowInterface) SetConcurrency(v Concurrency) {
	o.Concurrency = &v
}

// GetSla returns the Sla field value if set, zero value otherwise.
func (o *FlowInterface) GetSla() []SLA {
	if o == nil || IsNil(o.Sla) {
		var ret []SLA
		return ret
	}
	return o.Sla
}

// GetSlaOk returns a tuple with the Sla field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetSlaOk() ([]SLA, bool) {
	if o == nil || IsNil(o.Sla) {
		return nil, false
	}
	return o.Sla, true
}

// HasSla returns a boolean if a field has been set.
func (o *FlowInterface) HasSla() bool {
	if o != nil && !IsNil(o.Sla) {
		return true
	}

	return false
}

// SetSla gets a reference to the given []SLA and assigns it to the Sla field.
func (o *FlowInterface) SetSla(v []SLA) {
	o.Sla = v
}

// GetSource returns the Source field value if set, zero value otherwise.
func (o *FlowInterface) GetSource() string {
	if o == nil || IsNil(o.Source) {
		var ret string
		return ret
	}
	return *o.Source
}

// GetSourceOk returns a tuple with the Source field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FlowInterface) GetSourceOk() (*string, bool) {
	if o == nil || IsNil(o.Source) {
		return nil, false
	}
	return o.Source, true
}

// HasSource returns a boolean if a field has been set.
func (o *FlowInterface) HasSource() bool {
	if o != nil && !IsNil(o.Source) {
		return true
	}

	return false
}

// SetSource gets a reference to the given string and assigns it to the Source field.
func (o *FlowInterface) SetSource(v string) {
	o.Source = &v
}

func (o FlowInterface) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o FlowInterface) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Id) {
		toSerialize["id"] = o.Id
	}
	if !IsNil(o.Namespace) {
		toSerialize["namespace"] = o.Namespace
	}
	if !IsNil(o.Revision) {
		toSerialize["revision"] = o.Revision
	}
	if !IsNil(o.TenantId) {
		toSerialize["tenantId"] = o.TenantId
	}
	if !IsNil(o.Deleted) {
		toSerialize["deleted"] = o.Deleted
	}
	if !IsNil(o.Disabled) {
		toSerialize["disabled"] = o.Disabled
	}
	if !IsNil(o.Labels) {
		toSerialize["labels"] = o.Labels
	}
	if !IsNil(o.Inputs) {
		toSerialize["inputs"] = o.Inputs
	}
	if !IsNil(o.Outputs) {
		toSerialize["outputs"] = o.Outputs
	}
	if !IsNil(o.Variables) {
		toSerialize["variables"] = o.Variables
	}
	if !IsNil(o.WorkerGroup) {
		toSerialize["workerGroup"] = o.WorkerGroup
	}
	if !IsNil(o.Concurrency) {
		toSerialize["concurrency"] = o.Concurrency
	}
	if !IsNil(o.Sla) {
		toSerialize["sla"] = o.Sla
	}
	if !IsNil(o.Source) {
		toSerialize["source"] = o.Source
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *FlowInterface) UnmarshalJSON(data []byte) (err error) {
	varFlowInterface := _FlowInterface{}

	err = json.Unmarshal(data, &varFlowInterface)

	if err != nil {
		return err
	}

	*o = FlowInterface(varFlowInterface)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "namespace")
		delete(additionalProperties, "revision")
		delete(additionalProperties, "tenantId")
		delete(additionalProperties, "deleted")
		delete(additionalProperties, "disabled")
		delete(additionalProperties, "labels")
		delete(additionalProperties, "inputs")
		delete(additionalProperties, "outputs")
		delete(additionalProperties, "variables")
		delete(additionalProperties, "workerGroup")
		delete(additionalProperties, "concurrency")
		delete(additionalProperties, "sla")
		delete(additionalProperties, "source")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableFlowInterface struct {
	value *FlowInterface
	isSet bool
}

func (v NullableFlowInterface) Get() *FlowInterface {
	return v.value
}

func (v *NullableFlowInterface) Set(val *FlowInterface) {
	v.value = val
	v.isSet = true
}

func (v NullableFlowInterface) IsSet() bool {
	return v.isSet
}

func (v *NullableFlowInterface) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFlowInterface(val *FlowInterface) *NullableFlowInterface {
	return &NullableFlowInterface{value: val, isSet: true}
}

func (v NullableFlowInterface) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFlowInterface) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
