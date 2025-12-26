

# AbstractTrigger


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**type** | **String** |  |  |
|**version** | **String** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  |  [optional] |
|**description** | **String** |  |  [optional] |
|**conditions** | [**List&lt;Condition&gt;**](Condition.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**logLevel** | **Level** |  |  [optional] |
|**labels** | [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  |  [optional] |
|**stopAfter** | **List&lt;StateType&gt;** |  |  [optional] |
|**logToFile** | **Boolean** |  |  [optional] |
|**failOnTriggerError** | **Boolean** |  |  [optional] |
|**allowConcurrent** | **Boolean** |  |  [optional] |



