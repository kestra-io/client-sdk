

# Flow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. |  [optional] |
|**disabled** | **Boolean** |  |  |
|**labels** | [**FlowAllOfLabels**](FlowAllOfLabels.md) |  |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**_finally** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**taskDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**tasks** | [**Map&lt;Task&gt;**](Task.md) |  |  |
|**errors** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**listeners** | [**List&lt;Listener&gt;**](Listener.md) |  |  [optional] |
|**afterExecution** | [**List&lt;Task&gt;**](Task.md) |  |  [optional] |
|**triggers** | [**List&lt;AbstractTrigger&gt;**](AbstractTrigger.md) |  |  [optional] |
|**pluginDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) |  |  [optional] |
|**retry** | **Object** |  |  [optional] |
|**sla** | [**List&lt;SLA&gt;**](SLA.md) |  |  [optional] |



