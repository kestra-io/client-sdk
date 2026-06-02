# Migrating the Go SDK: v1.0.x → v2.0.0

`go-sdk/v2.0.0` is the first **hand-written** release of the Go client. It
replaces the generated OpenAPI client shipped in `go-sdk/v1.0.x`. The data
models are largely unchanged, but the **transport/call layer is different**, so
this is a breaking upgrade with a new module path.

> Existing `go-sdk/v1.0.x` consumers are unaffected — it is a distinct module
> path and keeps working. Migrate when you are ready.

## Backend compatibility

The v2 client targets **Kestra 1.3 and 2.x**. The Kestra version you talk to is
a runtime/compatibility concern, independent of this SDK version — see the
compatibility note in the README. (One caveat: on endpoints where a 1.3 server
does not accept the `filters` array, filtering is silently ignored by that
server — no error.)

## 1. Module path / import

```go
// v1
import kestra "github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
// v2
import kestra "github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
```

```bash
go get github.com/kestra-io/client-sdk/go-sdk/v2@go-sdk/v2.0.0
```

## 2. Client construction — `Configuration`/`APIClient` are gone

```go
// v1
cfg := kestra.NewConfiguration()
cfg.Scheme = "https"
cfg.Host = "host:8080"
cfg.Servers = kestra.ServerConfigurations{{URL: host}}
cfg.Debug = true
cfg.AddDefaultHeader("X-Foo", "bar")
client := kestra.NewAPIClient(cfg)

// v2
client := kestra.NewClient("https://host:8080",
    kestra.WithDebug(true),
    kestra.WithHeaders(map[string]string{"X-Foo": "bar"}),
)
```

- `NewClient` takes the **bare host** (`https://host:8080`). The SDK adds
  `/api/v1/{tenant}/...` itself — **do not** include `/api/v1` in the base URL.
- Removed: `Configuration`, `NewConfiguration`, `ServerConfiguration(s)`,
  `APIClient`, `NewAPIClient`.

## 3. Authentication moved from the context to the client

```go
// v1 — auth carried on the context
ctx = context.WithValue(ctx, kestra.ContextAccessToken, token)
ctx = context.WithValue(ctx, kestra.ContextBasicAuth,
    kestra.BasicAuth{UserName: user, Password: pass})

// v2 — auth set on the client at construction
client := kestra.NewClient(host, kestra.WithTokenAuth(token))
client := kestra.NewClient(host, kestra.WithBasicAuth(user, pass))
```

Removed: `ContextAccessToken`, `ContextBasicAuth`, `BasicAuth`. An explicit
auth option always wins over an `Authorization` value passed via `WithHeaders`,
regardless of option order.

## 4. Service accessors: field → method

```go
// v1
client.API.GroupsAPI...   client.API.UsersAPI...   client.API.KVAPI...
// v2
client.Groups()...        client.Users()...        client.Kv()...
```

The `API` field and the `XxxAPI` fields are removed. Note the renames:
`KVAPI` → `Kv()`, `ServiceAccountAPI` → `ServiceAccount()`.

## 5. Call style: request builder + `.Execute()` → direct arguments

```go
// v1
res, httpResp, err := client.API.GroupsAPI.
    SearchGroups(ctx, tenant).Page(1).Size(50).Q("foo").Execute()

// v2
res, err := client.Groups().
    SearchGroups(ctx, tenant, kestra.PtrInt(1), kestra.PtrInt(50), nil, filters)
```

The `ApiXxxRequest` builder types and `.Execute()` are gone; parameters are
explicit method arguments.

## 6. Return signature drops `*http.Response`

```go
// v1
value, httpResp, err := ...Execute()   // (T, *http.Response, error)
// v2
value, err := ...                       // (T, error)
```

If you read the `*http.Response` (status, headers, raw body), use the typed
error (next section) for the failure path instead.

## 7. Error type: `GenericOpenAPIError` → `ApiError`

```go
// v1
if e, ok := err.(*kestra.GenericOpenAPIError); ok {
    body := e.Body()       // method
    msg  := e.Error()
}
// v2
if e, ok := err.(*kestra.ApiError); ok {
    status := e.StatusCode  // field, now directly available
    body   := e.Body        // field ([]byte)
    msg    := e.Message
}
```

`GenericOpenAPIError` (and `.Body()`/`.Model()`) is removed.

## 8. Filtering: typed setters → `[]QueryFilter`

```go
// v1
.Q("foo").Namespace("ns").Execute()
// v2
[]kestra.QueryFilter{
    {Field: kestra.FilterQuery, Operation: kestra.OpContains, Value: "foo"},
    {Field: kestra.FilterNamespace, Operation: kestra.OpEquals, Value: "ns"},
}
```

Search/list filtering uses the `QueryFilter{Field, Operation, Value}` model with
the `FilterX` / `OpX` enum constants instead of per-field builder methods.

## 9. Optional parameters are pointers

`page`/`size` are `*int`, optional strings are `*string`. Use the retained
`kestra.PtrInt(...)` / `kestra.PtrString(...)` helpers and pass `nil` to omit.

## 10. Debug output behavior changed

`cfg.Debug` dumped full request/response **bodies**. `WithDebug` / `WithLogger`
log **method/URL/status + headers only**, with `Authorization`, `Cookie`, and
other sensitive headers **redacted**, and never log bodies.

## What does NOT change

- **Model structs are reused** — `IAMGroupControllerApiGroupDetail`,
  `IAMInvitationControllerApiInvitationCreateRequest`, etc., with their
  `GetX()`/`SetX()`/`HasX()` accessors, `NewXxx()` constructors, and the
  `PtrString`/`PtrInt` helpers. Payload-shaping code mostly survives.
- The v1 client occasionally mis-typed *successful* responses, requiring
  callers to parse the "error" body on success. v2's request layer unmarshals
  success bodies directly, so those workarounds can be **deleted** — this is a
  fix, not a behavior you must preserve.
