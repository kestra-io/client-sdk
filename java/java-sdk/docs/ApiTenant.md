

# ApiTenant


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**storageIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**secretIsolation** | [**Isolation**](Isolation.md) |  |  [optional] |
|**id** | **String** |  |  |
|**name** | **String** |  |  |
|**deleted** | **Boolean** |  |  |
|**defaultWorkerSelector** | [**WorkerSelector**](WorkerSelector.md) |  |  [optional] |
|**storageType** | **String** |  |  [optional] |
|**storageConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**secretType** | **String** |  |  [optional] |
|**secretReadOnly** | **Boolean** |  |  [optional] |
|**secretConfiguration** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**requireExistingNamespace** | **Boolean** |  |  [optional] |
|**outputsInInternalStorage** | **Boolean** |  |  [optional] |
|**appCatalogConfig** | [**TenantAppCatalogConfig**](TenantAppCatalogConfig.md) |  |  [optional] |
|**settings** | [**TenantPreferencesSettings**](TenantPreferencesSettings.md) |  |  [optional] |
|**sdkDefaultAuthentication** | [**SDKAuth**](SDKAuth.md) |  |  [optional] |
|**logo** | **String** |  |  [optional] |
|**concurrency** | [**Concurrency**](Concurrency.md) |  |  [optional] |
|**quotas** | [**List&lt;Quota&gt;**](Quota.md) |  |  [optional] |
|**workerSecretManagerMode** | [**SecretConfigurationWorkerSecretManagerMode**](SecretConfigurationWorkerSecretManagerMode.md) |  |  [optional] |



