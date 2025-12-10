# KestraIoKestraSdk.ExecutionControllerExecutionResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**labels** | [**[Label]**](Label.md) |  | [optional] 
**id** | **String** |  | 
**namespace** | **String** |  | 
**flowId** | **String** |  | 
**flowRevision** | **Number** |  | 
**taskRunList** | [**[TaskRun]**](TaskRun.md) |  | [optional] 
**inputs** | **{String: Object}** |  | [optional] 
**outputs** | **{String: Object}** |  | [optional] 
**variables** | **{String: Object}** |  | [optional] 
**state** | [**State**](State.md) |  | 
**parentId** | **String** |  | [optional] 
**originalId** | **String** |  | [optional] 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | [optional] 
**deleted** | **Boolean** |  | 
**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  | [optional] 
**scheduleDate** | **Date** |  | [optional] 
**traceParent** | **String** |  | [optional] 
**fixtures** | [**[TaskFixture]**](TaskFixture.md) |  | [optional] 
**kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 
**breakpoints** | [**[Breakpoint]**](Breakpoint.md) |  | [optional] 
**url** | **String** |  | [optional] 


