package test

import (
	"encoding/json"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func TestTypeEnum_All(t *testing.T) {
	t.Run("should_accept_every_input_type_the_spec_declares", func(t *testing.T) {
		for _, value := range []string{
			"STRING", "SELECT", "INT", "FLOAT", "BOOL", "DATETIME", "DATE", "TIME",
			"DURATION", "FILE", "JSON", "ION", "URI", "SECRET", "ARRAY",
			"MULTISELECT", "YAML", "EMAIL", "FORM", "REUSABLE_INPUTS",
		} {
			parsed, err := kestra_api_client.NewTypeFromValue(value)
			require.NoError(t, err, value)
			require.Equal(t, kestra_api_client.Type(value), *parsed)
		}
	})

	t.Run("should_decode_a_block_whose_inputs_use_the_late_added_types", func(t *testing.T) {
		for _, inputType := range []string{"ION", "REUSABLE_INPUTS"} {
			payload := `{"namespace":"ns","id":"block","revision":1,"inputs":[{"id":"in","type":"` + inputType + `"}]}`

			var block kestra_api_client.ReusableInputsWithSource
			require.NoError(t, json.Unmarshal([]byte(payload), &block), inputType)
			require.Equal(t, kestra_api_client.Type(inputType), block.GetInputs()[0].GetType())
		}
	})
}
