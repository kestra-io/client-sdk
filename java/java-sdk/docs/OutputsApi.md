# OutputsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getExecutionOutputs**](OutputsApi.md#getExecutionOutputs) | **GET** /api/v1/{tenant}/outputs/executions/{executionId} | Get the outputs of an execution |
| [**getTaskOutputsInformation**](OutputsApi.md#getTaskOutputsInformation) | **GET** /api/v1/{tenant}/outputs/tasks/{executionId} | Get where each task run&#39;s outputs live for an execution |
| [**getTaskRunOutputs**](OutputsApi.md#getTaskRunOutputs) | **GET** /api/v1/{tenant}/outputs/tasks/{executionId}/{taskRunId} | Get the outputs of a single task run |


Since Kestra 2.0 an execution&#39;s outputs are no longer inlined on the `Execution`
payload; they are fetched from these endpoints instead.


## getExecutionOutputs

> Map&lt;String, Object&gt; getExecutionOutputs(executionId, tenant)

The outputs declared by the flow, for a terminated execution.

### Parameters

| Name | Type | Description | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**| | |

### Return type

**Map&lt;String, Object&gt;**


## getTaskOutputsInformation

> List&lt;OutputControllerTaskOutputInformation&gt; getTaskOutputsInformation(executionId, tenant)

Where each task run&#39;s outputs live for an execution: inline, or held in internal
storage and retrievable through `getTaskRunOutputs`.

### Parameters

| Name | Type | Description | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **tenant** | **String**| | |

### Return type

[**List&lt;OutputControllerTaskOutputInformation&gt;**](OutputControllerTaskOutputInformation.md)


## getTaskRunOutputs

> Map&lt;String, Object&gt; getTaskRunOutputs(executionId, taskRunId, tenant)

The outputs of a single task run.

### Parameters

| Name | Type | Description | Notes |
|------------- | ------------- | ------------- | -------------|
| **executionId** | **String**| The execution id | |
| **taskRunId** | **String**| The task run id | |
| **tenant** | **String**| | |

### Return type

**Map&lt;String, Object&gt;**
