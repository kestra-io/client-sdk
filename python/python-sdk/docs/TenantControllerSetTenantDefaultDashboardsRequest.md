# TenantControllerSetTenantDefaultDashboardsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**default_home_dashboard** | **str** |  | [optional] 
**default_flow_overview_dashboard** | **str** |  | [optional] 
**default_namespace_overview_dashboard** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.tenant_controller_set_tenant_default_dashboards_request import TenantControllerSetTenantDefaultDashboardsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TenantControllerSetTenantDefaultDashboardsRequest from a JSON string
tenant_controller_set_tenant_default_dashboards_request_instance = TenantControllerSetTenantDefaultDashboardsRequest.from_json(json)
# print the JSON string representation of the object
print(TenantControllerSetTenantDefaultDashboardsRequest.to_json())

# convert the object into a dict
tenant_controller_set_tenant_default_dashboards_request_dict = tenant_controller_set_tenant_default_dashboards_request_instance.to_dict()
# create an instance of TenantControllerSetTenantDefaultDashboardsRequest from a dict
tenant_controller_set_tenant_default_dashboards_request_from_dict = TenantControllerSetTenantDefaultDashboardsRequest.from_dict(tenant_controller_set_tenant_default_dashboards_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


