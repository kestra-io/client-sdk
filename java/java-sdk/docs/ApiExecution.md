

# ApiExecution


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tenantId** | **String** |  |  |
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**flowId** | **String** |  |  |
|**flowRevision** | **Integer** |  |  |
|**taskRunList** | [**List&lt;ApiTaskRun&gt;**](ApiTaskRun.md) |  |  [optional] |
|**inputs** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**outputs** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**labels** | [**List&lt;Label&gt;**](Label.md) |  |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**state** | [**State**](State.md) |  |  |
|**parentId** | **String** |  |  [optional] |
|**originalId** | **String** |  |  |
|**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  |  [optional] |
|**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  |  |
|**scheduleDate** | **OffsetDateTime** |  |  [optional] |
|**traceParent** | **String** |  |  [optional] |
|**fixtures** | [**List&lt;TaskFixture&gt;**](TaskFixture.md) |  |  [optional] |
|**kind** | **ExecutionKind** |  |  [optional] |
|**breakpoints** | [**List&lt;Breakpoint&gt;**](Breakpoint.md) |  |  [optional] |
|**loopRun** | [**LoopRun**](LoopRun.md) |  |  [optional] |



