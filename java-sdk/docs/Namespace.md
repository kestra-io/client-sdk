

# Namespace

A namespace is a logical grouping of flows and tasks. It is used to organize and manage flows and tasks within Kestra.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**deleted** | **Boolean** |  |  |
|**allowedTriggers** | [**List&lt;NamespaceAllowedTrigger&gt;**](NamespaceAllowedTrigger.md) |  |  [optional] |
|**storageIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**secretIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**description** | **String** |  |  |
|**variables** | **Map&lt;String, Object&gt;** |  |  |
|**pluginDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  |
|**allowedNamespaces** | [**List&lt;NamespaceAllowedNamespace&gt;**](NamespaceAllowedNamespace.md) |  |  |
|**workerGroup** | [**WorkerGroup**](WorkerGroup.md) |  |  |
|**storageType** | **String** |  |  [optional] |
|**storageConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**secretType** | **String** |  |  [optional] |
|**secretReadOnly** | **Boolean** |  |  [optional] |
|**secretConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**outputsInInternalStorage** | **Boolean** |  |  [optional] |



