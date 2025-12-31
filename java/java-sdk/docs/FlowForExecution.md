

# FlowForExecution


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  |
|**labels** | [**MapObjectObject**](MapObjectObject.md) |  |  [optional] |
|**variables** | **Object** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**tasks** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  |
|**errors** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**_finally** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**afterExecution** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**triggers** | [**List&lt;AbstractTriggerForExecution&gt;**](AbstractTriggerForExecution.md) |  |  [optional] |



