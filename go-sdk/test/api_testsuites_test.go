package test

import (
	"context"
	"fmt"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func SIMPLE_TEST_SUITE(id string, ns string, flowId string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s
description: assert flow is returning the input value as output
flowId: %s
testCases:
  - id: test_case_1
    description: test_case_1 description
    type: io.kestra.core.tests.flow.UnitTest
    fixtures:
      inputs:
        inputA: "Hi there"
    assertions:
      - value: "{{ outputs.return.value }}"
        equalTo: 'Hi there'
`, id, ns, flowId)
}
func INVALID_TEST_SUITE(id string, ns string, flowId string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s
description: assert flow %s is returning the input value as output
# missing flow id
# missing test cases
`, id, ns, flowId)
}
func FAILING_SIMPLE_TEST_SUITE(id string, ns string, flowId string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s
description: assert flow is returning the input value as output
flowId: %s
testCases:
  - id: test_case_1
    description: test_case_1 description
    type: io.kestra.core.tests.flow.UnitTest
    fixtures:
      inputs:
        inputA: "another value"
    assertions:
      - value: "{{ outputs.return.value }}"
        description: 'making this assertion always false'
        equalTo: 'Hi there'
`, id, ns, flowId)
}

// createSimpleFlowNew creates a simple flow using the new hand-written API.
func createSimpleFlowNew(ctx context.Context, id string, ns string) {
	flowYaml := fmt.Sprintf(`
id: %s
namespace: %s
description: simple_flow_description

inputs:
  - id: inputA
    type: STRING
    defaults: 'default_value'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: "Hello World! {{ inputs.inputA }}"
  - id: return
    type: io.kestra.plugin.core.debug.Return
    format: "{{ inputs.inputA }}"
outputs:
  - id: flow_output
    type: STRING
    value: "{{ outputs.return.value }}"
`, id, ns)
	_, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, flowYaml)
	if err != nil {
		panic(fmt.Sprintf("error while inserting test flow with id: '%s', error: %s", id, err))
	}
}

func TestTestSuitesAPI_All(t *testing.T) {

	t.Run("createTestSuiteTest", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)

		res, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)

		require.NoError(t, err)
		require.EqualValues(t, testSuiteId, res.Id)
		require.EqualValues(t, flowId, res.FlowId)
		require.EqualValues(t, namespace, res.Namespace)
		require.EqualValues(t, "assert flow is returning the input value as output", *res.Description)
		require.Len(t, res.TestCases, 1)
		testCase := res.TestCases[0]
		require.EqualValues(t, "test_case_1 description", *testCase.Description)
		require.EqualValues(t, "io.kestra.core.tests.flow.UnitTest", testCase.Type)
		require.EqualValues(t, false, *testCase.Disabled)
		require.EqualValues(t, map[string]interface{}{"inputA": "Hi there"}, testCase.Fixtures.GetInputs())
		require.Len(t, testCase.Assertions, 1)
		assertion := testCase.Assertions[0]
		require.EqualValues(t, "Hi there", assertion.GetEqualTo())
		require.EqualValues(t, "{{ outputs.return.value }}", assertion.GetValue())
	})
	t.Run("getTestSuiteTest", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)
		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)

		res, err := KestraTestClient().TestSuites().TestSuite(ctx, namespace, testSuiteId, MAIN_TENANT)
		require.NoError(t, err)

		require.EqualValues(t, testSuiteId, res.Id)
		require.EqualValues(t, flowId, res.FlowId)
		require.EqualValues(t, namespace, res.Namespace)
		require.EqualValues(t, "assert flow is returning the input value as output", *res.Description)
	})
	t.Run("deleteTestSuiteTest", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)

		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)
		assertTestSuiteExists(t, ctx, namespace, testSuiteId)

		_, err = KestraTestClient().TestSuites().DeleteTestSuite(ctx, namespace, testSuiteId, MAIN_TENANT)
		require.NoError(t, err)

		assertTestSuiteDoesNotExist(t, ctx, namespace, testSuiteId)
	})
	t.Run("updateTestSuiteTest", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)

		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)
		assertTestSuiteExists(t, ctx, namespace, testSuiteId)

		// when
		testSuiteYaml = strings.ReplaceAll(testSuiteYaml, "assert flow is returning the input value as output", "updated testsuite description")
		testSuiteYaml = strings.ReplaceAll(testSuiteYaml, "test_case_1 description", "updated testcase description")

		_, err = KestraTestClient().TestSuites().UpdateTestSuite(ctx, namespace, testSuiteId, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)

		fetchedTestSuite, err := KestraTestClient().TestSuites().TestSuite(ctx, namespace, testSuiteId, MAIN_TENANT)
		require.NoError(t, err)
		require.EqualValues(t, testSuiteId, fetchedTestSuite.GetId())
		require.EqualValues(t, "updated testsuite description", fetchedTestSuite.GetDescription())
		require.EqualValues(t, "updated testcase description", fetchedTestSuite.GetTestCases()[0].GetDescription())
	})
	t.Run("validateTestSuiteTest_ok", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)

		validations, err := KestraTestClient().TestSuites().ValidateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)

		require.NoError(t, err)
		require.Len(t, validations.GetWarnings(), 0)
		require.Len(t, validations.GetInfos(), 0)
		require.Len(t, validations.GetDeprecationPaths(), 0)
		require.Empty(t, validations.GetConstraints())
	})
	t.Run("validateTestSuiteTest_invalid", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := INVALID_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)

		validations, err := KestraTestClient().TestSuites().ValidateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)

		require.NoError(t, err)
		require.Contains(t, validations.GetConstraints(), "testCases: must not be empty")
		require.Contains(t, validations.GetConstraints(), "flowId: must not be null")
	})
	t.Run("deleteTestSuiteByIdsTest", func(t *testing.T) {
		testSuiteId1 := randomId()
		testSuiteId2 := randomId()
		testSuiteId3 := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlowNew(ctx, flowId, namespace)

		testSuite1, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId1, namespace, flowId))
		require.NoError(t, err)
		testSuite2, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId2, namespace, flowId))
		require.NoError(t, err)
		testSuite3, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId3, namespace, flowId))
		require.NoError(t, err)
		assertTestSuiteExists(t, ctx, namespace, testSuite1.Id)
		assertTestSuiteExists(t, ctx, namespace, testSuite2.Id)
		assertTestSuiteExists(t, ctx, namespace, testSuite3.Id)

		deleteByIdsRequest := kestra_api_client.TestSuiteControllerTestSuiteBulkRequest{
			Ids: []kestra_api_client.TestSuiteControllerTestSuiteApiId{
				{Id: testSuiteId1, Namespace: namespace},
				{Id: testSuiteId3, Namespace: namespace},
			}}
		_, err = KestraTestClient().TestSuites().DeleteTestSuitesByIds(ctx, MAIN_TENANT, deleteByIdsRequest)
		require.NoError(t, err)

		assertTestSuiteExists(t, ctx, namespace, testSuite2.Id)
		assertTestSuiteDoesNotExist(t, ctx, namespace, testSuite1.Id)
		assertTestSuiteDoesNotExist(t, ctx, namespace, testSuite3.Id)
	})
	t.Run("disableTestSuiteByIdsTest", func(t *testing.T) {
		testSuiteId1 := randomId()
		testSuiteId2 := randomId()
		testSuiteId3 := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlowNew(ctx, flowId, namespace)

		testSuite1, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId1, namespace, flowId))
		require.NoError(t, err)
		testSuite2, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId2, namespace, flowId))
		require.NoError(t, err)
		testSuite3, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId3, namespace, flowId))
		require.NoError(t, err)
		assertTestSuiteEnabled(t, ctx, testSuite1)
		assertTestSuiteEnabled(t, ctx, testSuite2)
		assertTestSuiteEnabled(t, ctx, testSuite3)

		bulkByIdsRequest := kestra_api_client.TestSuiteControllerTestSuiteBulkRequest{
			Ids: []kestra_api_client.TestSuiteControllerTestSuiteApiId{
				{Id: testSuiteId1, Namespace: namespace},
				{Id: testSuiteId3, Namespace: namespace},
			}}
		_, err = KestraTestClient().TestSuites().DisableTestSuitesByIds(ctx, MAIN_TENANT, bulkByIdsRequest)
		require.NoError(t, err)

		assertTestSuiteEnabled(t, ctx, testSuite2)
		assertTestSuiteDisabled(t, ctx, testSuite1)
		assertTestSuiteDisabled(t, ctx, testSuite3)
	})
	t.Run("enableTestSuiteByIdsTest", func(t *testing.T) {
		testSuiteId1 := randomId()
		testSuiteId2 := randomId()
		testSuiteId3 := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlowNew(ctx, flowId, namespace)

		testSuite1, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId1, namespace, flowId))
		require.NoError(t, err)
		testSuite2, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId2, namespace, flowId))
		require.NoError(t, err)
		testSuite3, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId3, namespace, flowId))
		require.NoError(t, err)

		disableAllReq := kestra_api_client.TestSuiteControllerTestSuiteBulkRequest{
			Ids: []kestra_api_client.TestSuiteControllerTestSuiteApiId{
				{Id: testSuiteId1, Namespace: namespace},
				{Id: testSuiteId2, Namespace: namespace},
				{Id: testSuiteId3, Namespace: namespace},
			}}
		_, err = KestraTestClient().TestSuites().DisableTestSuitesByIds(ctx, MAIN_TENANT, disableAllReq)
		require.NoError(t, err)
		assertTestSuiteDisabled(t, ctx, testSuite1)
		assertTestSuiteDisabled(t, ctx, testSuite2)
		assertTestSuiteDisabled(t, ctx, testSuite3)

		enableRequest := kestra_api_client.TestSuiteControllerTestSuiteBulkRequest{
			Ids: []kestra_api_client.TestSuiteControllerTestSuiteApiId{
				{Id: testSuiteId1, Namespace: namespace},
				{Id: testSuiteId3, Namespace: namespace},
			}}
		_, err = KestraTestClient().TestSuites().EnableTestSuitesByIds(ctx, MAIN_TENANT, enableRequest)
		require.NoError(t, err)

		assertTestSuiteDisabled(t, ctx, testSuite2)
		assertTestSuiteEnabled(t, ctx, testSuite1)
		assertTestSuiteEnabled(t, ctx, testSuite3)
	})
	t.Run("searchTestSuiteTest", func(t *testing.T) {
		namespaceXXX := randomId()
		namespaceYYY := randomId()
		flowIdAAA := randomId()
		flowIdBBB := randomId()
		flowIdCCC := randomId()
		testSuiteId1 := randomId()
		testSuiteId2 := randomId()
		testSuiteId3 := randomId()
		testSuiteId4 := randomId()
		ctx := context.Background()

		createSimpleFlowNew(ctx, flowIdAAA, namespaceXXX)
		createSimpleFlowNew(ctx, flowIdBBB, namespaceXXX)
		createSimpleFlowNew(ctx, flowIdCCC, namespaceYYY)

		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId1, namespaceXXX, flowIdAAA))
		require.NoError(t, err)
		_, err = KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId2, namespaceXXX, flowIdAAA))
		require.NoError(t, err)
		_, err = KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId3, namespaceXXX, flowIdBBB))
		require.NoError(t, err)
		_, err = KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, SIMPLE_TEST_SUITE(testSuiteId4, namespaceYYY, flowIdCCC))
		require.NoError(t, err)

		searchByFlowAAA, err := KestraTestClient().TestSuites().SearchTestSuites(ctx, MAIN_TENANT, nil, nil, nil, nil, kestra_api_client.PtrString(flowIdAAA), nil)
		require.NoError(t, err)
		foundIds := []string{}
		for _, found := range searchByFlowAAA.GetResults() {
			foundIds = append(foundIds, found.GetId())
		}
		require.ElementsMatch(t, []string{testSuiteId1, testSuiteId2}, foundIds)

		searchByNamespaceYYY, err := KestraTestClient().TestSuites().SearchTestSuites(ctx, MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrString(namespaceYYY), nil, nil)
		require.NoError(t, err)
		foundIds = []string{}
		for _, found := range searchByNamespaceYYY.GetResults() {
			foundIds = append(foundIds, found.GetId())
		}
		require.ElementsMatch(t, []string{testSuiteId4}, foundIds)
	})
	t.Run("runTestSuiteTest", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)
		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)

		res, err := KestraTestClient().TestSuites().RunTestSuite(ctx, namespace, testSuiteId, MAIN_TENANT, nil)
		require.NoError(t, err)

		require.EqualValues(t, testSuiteId, res.GetTestSuiteId())
		require.EqualValues(t, kestra_api_client.TESTSTATE_SUCCESS, res.GetState())
		require.NotEmpty(t, res.GetEndDate())
	})
	t.Run("runTestSuiteTest_failed", func(t *testing.T) {
		testSuiteId := randomId()
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		testSuiteYaml := FAILING_SIMPLE_TEST_SUITE(testSuiteId, namespace, flowId)
		createSimpleFlowNew(ctx, flowId, namespace)
		_, err := KestraTestClient().TestSuites().CreateTestSuite(ctx, MAIN_TENANT, testSuiteYaml)
		require.NoError(t, err)

		res, err := KestraTestClient().TestSuites().RunTestSuite(ctx, namespace, testSuiteId, MAIN_TENANT, nil)
		require.NoError(t, err)

		require.EqualValues(t, testSuiteId, res.GetTestSuiteId())
		require.EqualValues(t, kestra_api_client.TESTSTATE_FAILED, res.GetState())
		require.Len(t, res.GetResults(), 1)
		result := res.GetResults()[0]
		require.EqualValues(t, "test_case_1", result.GetTestId())
		require.Len(t, result.GetAssertionResults(), 1)
		assertionResult := result.GetAssertionResults()[0]
		require.EqualValues(t, "Hi there", assertionResult.GetExpected())
		require.EqualValues(t, "another value", assertionResult.GetActual())
		require.EqualValues(t, "equalTo", assertionResult.GetOperator())
		require.False(t, assertionResult.GetIsSuccess())
	})
	t.Run("runTestSuiteByQueryTest", func(t *testing.T) {
		t.Skip("need to fix AssertionResult expected and actual deserialization first")
	})
	t.Run("searchTestSuitesResultsTest", func(t *testing.T) {
		t.Skip("need to fix AssertionResult expected and actual deserialization first")
	})
	t.Run("getTestResult", func(t *testing.T) {
		t.Skip("need to fix AssertionResult expected and actual deserialization first")
	})
	t.Run("getTestsLastResultTest", func(t *testing.T) {
		t.Skip("need to fix AssertionResult expected and actual deserialization first")
	})
}
func assertTestSuiteExists(t *testing.T, ctx context.Context, namespace string, id string) {
	_, err := KestraTestClient().TestSuites().TestSuite(ctx, namespace, id, MAIN_TENANT)
	require.NoError(t, err)
}
func assertTestSuiteDoesNotExist(t *testing.T, ctx context.Context, namespace string, id string) {
	_, err := KestraTestClient().TestSuites().TestSuite(ctx, namespace, id, MAIN_TENANT)
	require.ErrorContains(t, err, "API error 404")
}
func assertTestSuiteDisabled(t *testing.T, ctx context.Context, testSuite *kestra_api_client.TestSuite) {
	res, err := KestraTestClient().TestSuites().TestSuite(ctx, testSuite.Namespace, testSuite.Id, MAIN_TENANT)
	require.NoError(t, err)
	require.True(t, res.GetDisabled())
}
func assertTestSuiteEnabled(t *testing.T, ctx context.Context, testSuite *kestra_api_client.TestSuite) {
	res, err := KestraTestClient().TestSuites().TestSuite(ctx, testSuite.Namespace, testSuite.Id, MAIN_TENANT)
	require.NoError(t, err)
	require.False(t, res.GetDisabled())
}
