

# ExecutionControllerExecutionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labels** | [**List&lt;Label&gt;**](Label.md) |  |  |
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**flowId** | **String** |  |  |
|**flowRevision** | **Integer** |  |  |
|**taskRunList** | [**List&lt;TaskRun&gt;**](TaskRun.md) |  |  |
|**inputs** | **Map&lt;String, Object&gt;** |  |  |
|**outputs** | **Map&lt;String, Object&gt;** |  |  |
|**variables** | **Map&lt;String, Object&gt;** |  |  |
|**state** | [**State**](State.md) |  |  |
|**parentId** | **String** |  |  |
|**originalId** | **String** |  |  |
|**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  |  |
|**deleted** | **Boolean** |  |  |
|**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  |  |
|**scheduleDate** | **OffsetDateTime** |  |  [optional] |
|**traceParent** | **String** |  |  |
|**fixtures** | [**List&lt;TaskFixture&gt;**](TaskFixture.md) |  |  [optional] |
|**kind** | **ExecutionKind** |  |  [optional] |
|**breakpoints** | [**List&lt;Breakpoint&gt;**](Breakpoint.md) |  |  [optional] |
|**url** | **URI** |  |  |



