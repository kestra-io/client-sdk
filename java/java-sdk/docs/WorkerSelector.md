

# WorkerSelector

Routing requirements for a Worker Queue. On a Flow, Task or Trigger, Kestra 2.0.11+ returns `tags` as a string (the JSON text of a literal list such as `["gpu"]`, or a Pebble expression); Kestra 2.0.0-2.0.10 and namespace / tenant defaults use a list. A literal list is always read into `tags`, any other string into `tagsExpression`. On write, `tagsExpression` is sent as the `tags` string when set (Kestra 2.0.11+ only), otherwise `tags` is sent as a list. Setting one clears the other.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **List&lt;String&gt;** | Required tags used to route to a matching Worker Queue. Each tag is an RFC 1123 label: lowercase alphanumerics and hyphens, must start and end with alphanumeric, max 64 chars per tag, max 20 tags. |  [optional] |
|**tagsExpression** | **String** | Pebble expression rendering to the tags (Flow, Task and Trigger only, Kestra 2.0.11+), e.g. &#x60;{{ inputs.workers }}&#x60;. Sent as the &#x60;tags&#x60; string; null when the tags are a literal list. |  [optional] |
|**match** | [**WorkerSelectorMatch**](WorkerSelectorMatch.md) | How selector tags are matched against a Worker Queue&#39;s tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null. |  [optional] |
|**fallback** | [**WorkerQueueFallback**](WorkerQueueFallback.md) | Strategy when no worker is available. Defaults to FAIL when null. |  [optional] |



