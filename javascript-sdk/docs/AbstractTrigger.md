# KestraIoKestraSdk.AbstractTrigger

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**minLogLevel** | [**Level**](Level.md) |  | [optional] 
**id** | **String** |  | 
**type** | **String** |  | 
**version** | **String** | Defines the version of the plugin to use.  The version must follow the Semantic Versioning (SemVer) specification:   - A single-digit MAJOR version (e.g., &#x60;1&#x60;).   - A MAJOR.MINOR version (e.g., &#x60;1.1&#x60;).   - A MAJOR.MINOR.PATCH version, optionally with any qualifier     (e.g., &#x60;1.1.2&#x60;, &#x60;1.1.0-SNAPSHOT&#x60;).  | [optional] 
**description** | **String** |  | [optional] 
**conditions** | [**[Condition]**](Condition.md) |  | [optional] 
**disabled** | **Boolean** |  | 
**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**logLevel** | [**Level**](Level.md) |  | [optional] 
**labels** | [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  | [optional] 
**stopAfter** | [**[StateType]**](StateType.md) |  | [optional] 
**logToFile** | **Boolean** |  | [optional] 
**failOnTriggerError** | **Boolean** |  | [optional] 


