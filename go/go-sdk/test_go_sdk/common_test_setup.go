package main

import (
	"context"
	"crypto/rand"
	"encoding/hex"
	"os"
	"path/filepath"
	"strings"

	openapiclient "github.com/kestra-io/client-sdk/go/go-sdk"
)

const (
	HOST           = "http://localhost:9904"
	MAIN_TENANT    = "main"
	TEST_DATA_PATH = "../../../test-utils"
)

func KestraTestApiClient() *openapiclient.APIClient {
	configuration := openapiclient.NewConfiguration()

	url := HOST

	//configuration.Debug = true

	configuration.Servers = []openapiclient.ServerConfiguration{
		{
			URL: url,
		},
	}

	apiClient := openapiclient.NewAPIClient(configuration)

	return apiClient
}
func GetAuthContext() context.Context {
	username := "root@root.com"
	password := "Root!1234"

	ctx := context.Background()

	basicAuth := openapiclient.BasicAuth{
		UserName: username,
		Password: password,
	}
	ctx = context.WithValue(ctx, openapiclient.ContextBasicAuth, basicAuth)
	return ctx
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
