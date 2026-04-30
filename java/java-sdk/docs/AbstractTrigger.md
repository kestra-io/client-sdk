

# AbstractTrigger


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**type** | **String** |  |  |
|**version** | **String** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  |  [optional] |
|**description** | **String** |  |  [optional] |
|**when** | **String** | A Pebble expression evaluated at trigger time. The trigger fires only when the expression evaluates to a truthy value (&#x60;true&#x60;, a non-empty string, a non-zero number). Use this to gate trigger execution on dynamic runtime values such as execution labels, flow variables, or environment conditions. |  |
|**disabled** | **Boolean** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**logLevel** | **Level** |  |  [optional] |
|**labels** | [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  |  [optional] |
|**stopAfter** | **List&lt;StateType&gt;** |  |  [optional] |
|**logToFile** | **Boolean** |  |  [optional] |
|**failOnTriggerError** | **Boolean** |  |  [optional] |
|**allowConcurrent** | **Boolean** |  |  [optional] |
|**assets** | [**AssetsDeclaration**](AssetsDeclaration.md) |  |  [optional] |



