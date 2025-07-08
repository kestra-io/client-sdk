# KestraApi.DefaultApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**acceptInvitation**](DefaultApi.md#acceptInvitation) | **POST** /api/v1/invitation/accept/{invitationId} | 
[**createFromInvitation**](DefaultApi.md#createFromInvitation) | **POST** /api/v1/invitation/create/{invitationId} | 
[**forgottenPassword**](DefaultApi.md#forgottenPassword) | **GET** /api/v1/forgotten-password | Sends an email to reset a password.
[**login**](DefaultApi.md#login) | **POST** /login | 
[**resetPassword**](DefaultApi.md#resetPassword) | **POST** /api/v1/reset-password | Change a password for given token.



## acceptInvitation

> Object acceptInvitation(invitationId)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DefaultApi();
let invitationId = "invitationId_example"; // String | 
apiInstance.acceptInvitation(invitationId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitationId** | **String**|  | 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## createFromInvitation

> Object createFromInvitation(invitationId, authControllerInvitationUserRequest)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DefaultApi();
let invitationId = "invitationId_example"; // String | 
let authControllerInvitationUserRequest = new KestraApi.AuthControllerInvitationUserRequest(); // AuthControllerInvitationUserRequest | The basic information to create an account from an invitation
apiInstance.createFromInvitation(invitationId, authControllerInvitationUserRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invitationId** | **String**|  | 
 **authControllerInvitationUserRequest** | [**AuthControllerInvitationUserRequest**](AuthControllerInvitationUserRequest.md)| The basic information to create an account from an invitation | 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## forgottenPassword

> Object forgottenPassword(username)

Sends an email to reset a password.

Sends an email to reset a password. Note that whatever the username is found or not, the response will always be 200 to avoid leaking information.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DefaultApi();
let username = "username_example"; // String | User that has forgotten his password
apiInstance.forgottenPassword(username).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| User that has forgotten his password | 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## login

> Object login(username, password, opts)



### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DefaultApi();
let username = "username_example"; // String | 
let password = "password_example"; // String | 
let opts = {
  'identity': "identity_example", // String | 
  'secret': "secret_example" // String | 
};
apiInstance.login(username, password, opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**|  | 
 **password** | **String**|  | 
 **identity** | **String**|  | [optional] 
 **secret** | **String**|  | [optional] 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json


## resetPassword

> Object resetPassword(authControllerResetPasswordRequest)

Change a password for given token.

Change a password for given token. If password does not match password policy, use can still retry.

### Example

```javascript
import KestraApi from 'kestra_api';

let apiInstance = new KestraApi.DefaultApi();
let authControllerResetPasswordRequest = new KestraApi.AuthControllerResetPasswordRequest(); // AuthControllerResetPasswordRequest | The password
apiInstance.resetPassword(authControllerResetPasswordRequest).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authControllerResetPasswordRequest** | [**AuthControllerResetPasswordRequest**](AuthControllerResetPasswordRequest.md)| The password | 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

