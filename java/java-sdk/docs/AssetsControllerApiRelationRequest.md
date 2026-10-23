# AssetsControllerApiRelationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**kind** | **RelationKind** | The kind of relation to create. |  |
|**direction** | **RelationDirection** | The side the asset takes; ignored by an undirected kind. |  |
|**targetId** | **String** | The id of the asset or flow at the other end. |  |
|**targetNamespace** | **String** | The namespace at the other end, required when it is a flow. |  [optional] |
|**role** | **String** | The role the other end plays, for example primary or backup. |  [optional] |



