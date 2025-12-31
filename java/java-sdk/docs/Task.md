

# Task


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**type** | **String** |  |  |
|**version** | **String** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  |  [optional] |
|**description** | **String** |  |  [optional] |
|**retry** | **Object** |  |  [optional] |
|**timeout** | [**String**](PropertyDuration.md) |  |  [optional] |
|**disabled** | **Boolean** |  |  [optional] |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  [optional] |
|**logLevel** | **Level** |  |  [optional] |
|**allowFailure** | **Boolean** |  |  [optional] |
|**logToFile** | **Boolean** |  |  [optional] |
|**runIf** | **String** |  |  [optional] |
|**allowWarning** | **Boolean** |  |  [optional] |
|**taskCache** | [**Cache**](Cache.md) |  |  [optional] |
|**assets** | [**PropertyAssetsDeclaration**](PropertyAssetsDeclaration.md) |  |  [optional] |



