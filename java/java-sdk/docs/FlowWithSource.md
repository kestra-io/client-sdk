

# FlowWithSource


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labels** | [**List&lt;Label&gt;**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. |  [optional] |
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. |  [optional] |
|**disabled** | **Boolean** |  |  |
|**variables** | **Object** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**_finally** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**tasks** | [**Map&lt;Task&gt;**](Task.md) |  |  |
|**errors** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**afterExecution** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**triggers** | [**List&lt;AbstractTrigger&gt;**](AbstractTrigger.md) |  |  [optional] |
|**pluginDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) |  |  [optional] |
|**retry** | **Object** |  |  [optional] |
|**sla** | [**List&lt;SLA&gt;**](SLA.md) |  |  [optional] |
|**checks** | [**List&lt;Check&gt;**](Check.md) | A list of conditions that are evaluated before the flow is executed.  If no checks are defined, the flow executes normally. |  [optional] |
|**source** | **String** |  |  [optional] |



