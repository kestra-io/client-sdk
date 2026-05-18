package test

import (
	"crypto/rand"
	"encoding/hex"
	"os"
	"path/filepath"
	"strings"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
)

const (
	HOST           = "http://localhost:9904"
	MAIN_TENANT    = "main"
	TEST_DATA_PATH = "../../../test-utils"
)

func KestraTestClient() *kestra_api_client.KestraClient {
	return kestra_api_client.NewClient(
		HOST,
		kestra_api_client.WithBasicAuth("root@root.com", "Root!1234"),
	)
}

func randomId() string {
	b := make([]byte, 16)
	_, err := rand.Read(b)
	if err != nil {
		panic(err)
	}
	return hex.EncodeToString(b)
}

type FlowBodyAndId struct {
	FlowBody      string
	FlowNamespace string
	FlowId        string
}

func GetCompleteFlow() string {
	s := get(filepath.Join(TEST_DATA_PATH, "flows", "flow_complete.yml"))
	s = strings.ReplaceAll(s, "flow_complete", randomId())
	s = strings.ReplaceAll(s, "tests", randomId())
	return s
}

func GetSimpleFlow() string {
	return GetSimpleFlowAndId().FlowBody
}

func GetSimpleFlowAndId() FlowBodyAndId {
	flowId := randomId()
	namespace := randomId()
	body := get(filepath.Join(TEST_DATA_PATH, "flows", "simple_flow.yml"))
	body = strings.ReplaceAll(body, "simple_flow_id_to_replace_by_random_id", flowId)
	body = strings.ReplaceAll(body, "simple_flow_namespace_to_replace_by_random_id", namespace)
	return FlowBodyAndId{
		FlowBody:      body,
		FlowNamespace: namespace,
		FlowId:        flowId,
	}
}

func get(filePath string) string {
	if !filepath.IsAbs(filePath) {
		if wd, err := os.Getwd(); err == nil {
			filePath = filepath.Join(wd, filePath)
		}
	}
	b, err := os.ReadFile(filePath)
	if err != nil {
		panic(err)
	}
	return string(b)
}
