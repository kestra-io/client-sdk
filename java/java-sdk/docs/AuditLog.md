

# AuditLog


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tenantId** | **String** |  |  [optional] |
|**id** | **String** |  |  |
|**type** | **CrudEventType** |  |  |
|**detail** | [**AuditLogDetail**](AuditLogDetail.md) |  |  |
|**date** | **OffsetDateTime** |  |  |
|**userId** | **String** |  |  |
|**ipAddress** | **String** |  |  [optional] |
|**impersonatedBy** | **String** |  |  [optional] |
|**deleted** | **Boolean** |  |  [optional] |
|**appliedPatch** | **List&lt;Object&gt;** |  |  [optional] |
|**revertPatch** | **List&lt;Object&gt;** |  |  [optional] |



