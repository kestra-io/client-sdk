# KestraIoKestraSdk.Flow

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  | 
**namespace** | **String** |  | 
**revision** | **Number** |  | [optional] 
**inputs** | [**[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**[Output]**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**disabled** | **Boolean** |  | 
**labels** | [**FlowAllOfLabels**](FlowAllOfLabels.md) |  | [optional] 
**variables** | **{String: Object}** |  | [optional] 
**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**deleted** | **Boolean** |  | 
**_finally** | [**[Task]**](Task.md) |  | [optional] 
**taskDefaults** | [**[PluginDefault]**](PluginDefault.md) |  | [optional] 
**description** | **String** |  | [optional] 
**tasks** | [**[Task]**](Task.md) |  | 
**errors** | [**[Task]**](Task.md) |  | [optional] 
**listeners** | [**[Listener]**](Listener.md) |  | [optional] 
**afterExecution** | [**[Task]**](Task.md) |  | [optional] 
**triggers** | [**[AbstractTrigger]**](AbstractTrigger.md) |  | [optional] 
**pluginDefaults** | [**[PluginDefault]**](PluginDefault.md) |  | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) |  | [optional] 
**retry** | **Object** |  | [optional] 
**sla** | [**[SLA]**](SLA.md) |  | [optional] 


