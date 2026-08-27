

# FlowInterface


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  [optional] |
|**namespace** | **String** |  |  [optional] |
|**revision** | **Integer** |  |  [optional] |
|**tenantId** | **String** |  |  [optional] |
|**deleted** | **Boolean** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**disabled** | **Boolean** |  |  [optional] |
|**labels** | [**List&lt;Label&gt;**](Label.md) |  |  [optional] |
|**inputs** | [**List&lt;InputObject&gt;**](InputObject.md) |  |  [optional] |
|**outputs** | [**List&lt;Output&gt;**](Output.md) |  |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**workerSelector** | [**WorkerSelector**](WorkerGroup.md) |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) |  |  [optional] |
|**sla** | [**List&lt;SLA&gt;**](SLA.md) |  |  [optional] |
|**source** | **String** |  |  [optional] |
|**draft** | **Boolean** | Whether this flow revision is a draft. Draft revisions are skipped when an execution starts without an explicit revision (webhooks, schedules, subflows, manual triggers). Executions can still target a draft by passing the revision explicitly. |  [optional] |



