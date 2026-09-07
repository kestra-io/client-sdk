# NotificationControllerApiNotificationsSince


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**notifications** | [**List[Notification]**](Notification.md) |  | [optional] 
**server_time** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.notification_controller_api_notifications_since import NotificationControllerApiNotificationsSince

# TODO update the JSON string below
json = "{}"
# create an instance of NotificationControllerApiNotificationsSince from a JSON string
notification_controller_api_notifications_since_instance = NotificationControllerApiNotificationsSince.from_json(json)
# print the JSON string representation of the object
print(NotificationControllerApiNotificationsSince.to_json())

# convert the object into a dict
notification_controller_api_notifications_since_dict = notification_controller_api_notifications_since_instance.to_dict()
# create an instance of NotificationControllerApiNotificationsSince from a dict
notification_controller_api_notifications_since_from_dict = NotificationControllerApiNotificationsSince.from_dict(notification_controller_api_notifications_since_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


