

# FlowForExecution


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  |
|**labels** | [**List&lt;Label&gt;**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**tasks** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  |
|**errors** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**_finally** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**afterExecution** | [**List&lt;TaskForExecution&gt;**](TaskForExecution.md) |  |  [optional] |
|**triggers** | [**List&lt;AbstractTriggerForExecution&gt;**](AbstractTriggerForExecution.md) |  |  [optional] |



