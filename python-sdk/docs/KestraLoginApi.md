# kestrapy.KestraLoginApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**login**](KestraLoginApi.md#login) | **POST** /login | 


# **login**
> object login(username, password, identity=identity, secret=secret)

### Example


```python
import kestrapy
from kestrapy.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = kestrapy.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with kestrapy.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = kestrapy.KestraLoginApi(api_client)
    username = 'username_example' # str | 
    password = 'password_example' # str | 
    identity = 'identity_example' # str |  (optional)
    secret = 'secret_example' # str |  (optional)

    try:
        api_response = api_instance.login(username, password, identity=identity, secret=secret)
        print("The response of KestraLoginApi->login:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling KestraLoginApi->login: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **str**|  | 
 **password** | **str**|  | 
 **identity** | **str**|  | [optional] 
 **secret** | **str**|  | [optional] 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | login 200 response |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

