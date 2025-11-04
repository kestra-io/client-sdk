

# FlowWithSource


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  |
|**labels** | [**List&lt;Label&gt;**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**variables** | **Object** |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. |  [optional] |
|**sla** | [**List&lt;SLA&gt;**](SLA.md) |  |  [optional] |
|**_finally** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**tasks** | [**Map&lt;Task&gt;**](Task.md) |  |  |
|**errors** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**afterExecution** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**triggers** | [**List&lt;AbstractTrigger&gt;**](AbstractTrigger.md) |  |  [optional] |
|**pluginDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  [optional] |
|**retry** | **Object** |  |  [optional] |



