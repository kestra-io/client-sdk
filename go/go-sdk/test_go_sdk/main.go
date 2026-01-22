package main

import (
	"context"
	"encoding/json"
	"fmt"
	"io"
	"log"

	kestra_api_client "github.com/kestra-io/client-sdk/go/go-sdk"
)

func main() {
	configuration := kestra_api_client.NewConfiguration()

	url := "http://localhost:8088"
	username := "root@root.com"
	password := "Root!1234"
	tenantId := "main"

	ctx := context.Background()

	configuration.Servers = []kestra_api_client.ServerConfiguration{
		{
			URL: url,
		},
	}

	basicAuth := kestra_api_client.BasicAuth{
		UserName: username,
		Password: password,
	}
	ctx = context.WithValue(ctx, kestra_api_client.ContextBasicAuth, basicAuth)

	apiClient := kestra_api_client.NewAPIClient(configuration)

	request := apiClient.FlowsAPI.SearchFlows(ctx, tenantId).Page(1).Size(10)

	flows, resp, err := request.Execute()
	if err != nil {
		log.Printf("Error when calling `SearchFlows`: %v\n", err)
		if resp != nil {
			log.Printf("HTTP response: %v\n", resp)
			if resp.Body != nil {
				defer resp.Body.Close()
				bodyBytes, readErr := io.ReadAll(resp.Body)
				if readErr == nil {
					log.Printf("Response Body: %s\n", string(bodyBytes))
				} else {
					log.Printf("Error reading response body: %v\n", readErr)
				}
			}
		}
		return
	}

	fmt.Printf("HTTP Status code: %s\n", resp.Status)
	fmt.Printf("Flows count: %d\n", flows.Total)

	if flows.Results == nil || len(flows.Results) == 0 {
		fmt.Println("No flows found.")
	} else {
		fmt.Println("Found Flows:")
		for _, flow := range flows.Results {

			var flowId, flowNamespace string
			flowId = flow.Id
			flowNamespace = flow.Namespace
			fmt.Printf("- ID: %s, Namespace: %s\n", flowId, flowNamespace)

			flowJSON, err := json.MarshalIndent(flow, "", "  ")
			if err != nil {
				fmt.Printf("Error marshaling flow to JSON: %v\n", err)
			} else {
				fmt.Printf("%s\n", flowJSON)
			}
		}
	}

}
