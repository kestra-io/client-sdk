# KestraIoKestraSdk.Flow

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  | 
**namespace** | **String** |  | 
**revision** | **Number** |  | [optional] 
**description** | **String** |  | [optional] 
**inputs** | [**[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**[Output]**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**disabled** | **Boolean** |  | 
**labels** | [**[Label]**](Label.md) |  | [optional] 
**variables** | **Object** |  | [optional] 
**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**deleted** | **Boolean** |  | 
**_finally** | [**[Task]**](Task.md) |  | [optional] 
**tasks** | [**[Task]**](Task.md) |  | 
**errors** | [**[Task]**](Task.md) |  | [optional] 
**afterExecution** | [**[Task]**](Task.md) |  | [optional] 
**triggers** | [**[AbstractTrigger]**](AbstractTrigger.md) |  | [optional] 
**pluginDefaults** | [**[PluginDefault]**](PluginDefault.md) |  | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) |  | [optional] 
**retry** | **Object** |  | [optional] 
**sla** | [**[SLA]**](SLA.md) |  | [optional] 
**checks** | [**[Check]**](Check.md) | A list of conditions that are evaluated before the flow is executed.  If no checks are defined, the flow executes normally. | [optional] 


