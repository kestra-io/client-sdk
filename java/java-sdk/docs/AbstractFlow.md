

# AbstractFlow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**namespace** | **String** |  |  |
|**revision** | **Integer** |  |  [optional] |
|**updated** | **OffsetDateTime** | The timestamp when this revision was created or last updated. |  [optional] |
|**description** | **String** |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  |
|**labels** | [**List&lt;Label&gt;**](Label.md) |  |  [optional] |
|**variables** | **Object** |  |  [optional] |
|**workerSelector** | [**WorkerSelector**](WorkerGroup.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**draft** | **Boolean** | Whether this flow revision is a draft. Draft revisions are skipped when an execution starts without an explicit revision (webhooks, schedules, subflows, manual triggers). Executions can still target a draft by passing the revision explicitly. |  |



