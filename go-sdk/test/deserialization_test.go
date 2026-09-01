package test

import (
    "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
    "github.com/stretchr/testify/require"
    "testing"
)

func TestDeserialization_fromRealWorldUsecases(t *testing.T) {
    t.Run("deserialize_namespace_simple", func(t *testing.T) {
        jsonBody := `{
          "id": "namespaceid1",
          "deleted": false,
          "allowedNamespaces": [
            {
              "namespace": "othernamespace"
            }
          ]
        }
        `

        namespace := kestra_api_client.Namespace{}
        err := namespace.UnmarshalJSON([]byte(jsonBody))

        require.NoError(t, err)
        require.Equal(t, "namespaceid1", namespace.Id)
    })
    t.Run("deserialize_namespace_withStorageConfiguration_from_1.0.25", func(t *testing.T) {
        jsonBody := `
        {
          "id": "namespaceid1",
          "deleted": false,
          "allowedNamespaces": [
            {
              "namespace": "othernamespace"
            }
          ],
          "storageType": "s3",
          "storageConfiguration": {
            "bucket": "my-bucket",
            "region": "us-east-1"
          },
          "storageIsolation": {
            "enabled": false,
            "deniedServices": []
          },
          "secretIsolation": {
            "enabled": false,
            "deniedServices": []
          }
        }
        `

        namespace := kestra_api_client.Namespace{}
        err := namespace.UnmarshalJSON([]byte(jsonBody))

        require.NoError(t, err)
        require.Equal(t, "namespaceid1", namespace.Id)
    })
}
