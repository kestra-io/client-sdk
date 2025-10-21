

# ExecutionControllerExecutionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labels** | [**List&lt;Label&gt;**](Label.md) |  |  [optional] |
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**flowId** | **String** |  |  |
|**flowRevision** | **Integer** |  |  |
|**taskRunList** | [**List&lt;TaskRun&gt;**](TaskRun.md) |  |  [optional] |
|**inputs** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**outputs** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**state** | [**State**](State.md) |  |  |
|**parentId** | **String** |  |  [optional] |
|**originalId** | **String** |  |  [optional] |
|**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  |  [optional] |
|**scheduleDate** | **OffsetDateTime** |  |  [optional] |
|**traceParent** | **String** |  |  [optional] |
|**fixtures** | [**List&lt;TaskFixture&gt;**](TaskFixture.md) |  |  [optional] |
|**kind** | **ExecutionKind** |  |  [optional] |
|**breakpoints** | [**List&lt;Breakpoint&gt;**](Breakpoint.md) |  |  [optional] |
|**url** | **URI** |  |  [optional] |



