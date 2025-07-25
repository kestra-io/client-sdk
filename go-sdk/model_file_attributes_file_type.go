/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
	"fmt"
)

// FileAttributesFileType the model 'FileAttributesFileType'
type FileAttributesFileType string

// List of FileAttributes.FileType
const (
	FILEATTRIBUTESFILETYPE_File      FileAttributesFileType = "File"
	FILEATTRIBUTESFILETYPE_Directory FileAttributesFileType = "Directory"
)

// All allowed values of FileAttributesFileType enum
var AllowedFileAttributesFileTypeEnumValues = []FileAttributesFileType{
	"File",
	"Directory",
}

func (v *FileAttributesFileType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := FileAttributesFileType(value)
	for _, existing := range AllowedFileAttributesFileTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid FileAttributesFileType", value)
}

// NewFileAttributesFileTypeFromValue returns a pointer to a valid FileAttributesFileType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewFileAttributesFileTypeFromValue(v string) (*FileAttributesFileType, error) {
	ev := FileAttributesFileType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for FileAttributesFileType: valid values are %v", v, AllowedFileAttributesFileTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v FileAttributesFileType) IsValid() bool {
	for _, existing := range AllowedFileAttributesFileTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to FileAttributes.FileType value
func (v FileAttributesFileType) Ptr() *FileAttributesFileType {
	return &v
}

type NullableFileAttributesFileType struct {
	value *FileAttributesFileType
	isSet bool
}

func (v NullableFileAttributesFileType) Get() *FileAttributesFileType {
	return v.value
}

func (v *NullableFileAttributesFileType) Set(val *FileAttributesFileType) {
	v.value = val
	v.isSet = true
}

func (v NullableFileAttributesFileType) IsSet() bool {
	return v.isSet
}

func (v *NullableFileAttributesFileType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFileAttributesFileType(val *FileAttributesFileType) *NullableFileAttributesFileType {
	return &NullableFileAttributesFileType{value: val, isSet: true}
}

func (v NullableFileAttributesFileType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFileAttributesFileType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
