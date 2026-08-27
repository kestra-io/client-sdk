

# Namespace


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**storageIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**secretIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**deleted** | **Boolean** |  |  |
|**description** | **String** |  |  [optional] |
|**variables** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**pluginDefaults** | [**List&lt;PluginDefault&gt;**](PluginDefault.md) |  |  [optional] |
|**allowedNamespaces** | [**List&lt;NamespaceAllowedNamespace&gt;**](NamespaceAllowedNamespace.md) |  |  [optional] |
|**defaultWorkerSelector** | [**WorkerSelector**](WorkerSelector.md) |  |  [optional] |
|**storageType** | **String** |  |  [optional] |
|**storageConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**secretType** | **String** |  |  [optional] |
|**secretReadOnly** | **Boolean** |  |  [optional] |
|**secretConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**outputsInInternalStorage** | **Boolean** |  |  [optional] |
|**sdkDefaultAuthentication** | [**SDKAuth**](SDKAuth.md) |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) | The concurrency limit applying to the executions of every flow inside this namespace and its descendants. |  [optional] |
|**quotas** | [**List&lt;Quota&gt;**](Quota.md) |  |  [optional] |
|**workerSecretManagerMode** | [**SecretConfigurationWorkerSecretManagerMode**](SecretConfigurationWorkerSecretManagerMode.md) |  |  [optional] |



