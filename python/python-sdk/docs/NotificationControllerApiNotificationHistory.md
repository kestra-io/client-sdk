# NotificationControllerApiNotificationHistory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**notifications** | [**List[Notification]**](Notification.md) |  | [optional] 
**server_time** | **datetime** |  | [optional] 
**next_cursor** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.notification_controller_api_notification_history import NotificationControllerApiNotificationHistory

# TODO update the JSON string below
json = "{}"
# create an instance of NotificationControllerApiNotificationHistory from a JSON string
notification_controller_api_notification_history_instance = NotificationControllerApiNotificationHistory.from_json(json)
# print the JSON string representation of the object
print(NotificationControllerApiNotificationHistory.to_json())

# convert the object into a dict
notification_controller_api_notification_history_dict = notification_controller_api_notification_history_instance.to_dict()
# create an instance of NotificationControllerApiNotificationHistory from a dict
notification_controller_api_notification_history_from_dict = NotificationControllerApiNotificationHistory.from_dict(notification_controller_api_notification_history_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


