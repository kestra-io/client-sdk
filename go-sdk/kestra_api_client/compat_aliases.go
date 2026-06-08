package kestra_api_client

// Backward-compatibility aliases for the generated (v1.0.x) client surface.
//
// The hand-written rewrite renamed some generated types. These aliases keep the
// original exported names valid so existing consumers compile unchanged. An
// alias is the same type, so values are freely interchangeable.

// IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions was the v1.0.x name
// for the role-permissions payload; the current models use ListPermissions200Response.
type IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions = ListPermissions200Response
