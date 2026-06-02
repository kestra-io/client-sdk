# Changelog — Go SDK

All notable changes to the Go SDK (`github.com/kestra-io/client-sdk/go-sdk`).
The Go module is versioned independently of the other language SDKs and of the
Kestra server (backend support is tracked as a compatibility matrix, not in the
version number).

## v2.0.0

First **hand-written** client, replacing the generated OpenAPI client from the
`v1.0.x` line. This is an API-breaking change for SDK consumers, hence the major
version and the `/v2` module-path suffix. **Existing `v1.0.x` consumers are
unaffected** (distinct module path).

See [`MIGRATING.md`](./MIGRATING.md) for a step-by-step upgrade guide.

### Compatibility

- Targets **Kestra 1.3 and 2.x** with the same client.
- Caveat: on endpoints where a 1.3 server does not accept the `filters` array,
  that server silently ignores filtering (no error).

### ⚠️ Breaking changes (vs v1.0.x)

- **Module path** now requires the `/v2` suffix:
  `github.com/kestra-io/client-sdk/go-sdk/v2`.
- **Removed the generated surface**: `Configuration`, `NewConfiguration`,
  `ServerConfiguration(s)`, `APIClient`, `NewAPIClient`, the `ApiXxxRequest`
  builder types, and `XxxAPIService`.
- **Constructor**: `NewAPIClient(cfg)` → `NewClient(baseURL, opts...)` returning
  `*KestraClient`. `baseURL` is the bare host; the SDK adds `/api/v1/{tenant}/...`.
- **Authentication** moved from the context to the client: `WithTokenAuth` /
  `WithBasicAuth` replace `context.WithValue(ctx, ContextAccessToken|ContextBasicAuth, …)`.
  Removed `ContextAccessToken`, `ContextBasicAuth`, `BasicAuth`.
- **Service accessors**: `client.API.XxxAPI` (field) → `client.Xxx()` (method).
  Renames include `KVAPI` → `Kv()`, `ServiceAccountAPI` → `ServiceAccount()`.
- **Call style**: request-builder chaining + `.Execute()` → explicit method
  arguments (`client.Groups().SearchGroups(ctx, tenant, page, size, sort, filters)`).
- **Return signature**: `(T, *http.Response, error)` → `(T, error)` (no
  `*http.Response`).
- **Error type**: `*GenericOpenAPIError` (with `.Body()` method) → `*ApiError`
  (`{StatusCode int, Body []byte, Message string}`).
- **Filtering**: per-field builder setters (`.Q(...)`, `.Namespace(...)`) →
  `[]QueryFilter{{Field, Operation, Value}}` with `FilterX` / `OpX` constants.
- **Optional params** are pointers (`*int`, `*string`); use `PtrInt`/`PtrString`.
- **Debug output**: `cfg.Debug` (dumped bodies) → `WithDebug` / `WithLogger`
  (method/URL/status + headers only; sensitive headers redacted; no bodies).

### Added

- Hand-written client (`KestraClient`) with per-resource accessors.
- Client options: `WithBasicAuth`, `WithTokenAuth`, `WithHTTPClient`,
  `WithHeaders`, `WithHeader`, `WithDebug`, `WithLogger`.
- `Invitations()` and `Bindings()` APIs (previously only model structs existed).
- Kestra 2.0 unified `filters` support across search/list methods.

### Fixed

- Search/list filtering now actually applies against Kestra 2.0 (the generated
  client sent legacy params that 2.0 silently ignored).
- Successful responses are unmarshalled directly; the v1 "parse the error body
  on success" workarounds are no longer needed.

### Unchanged

- Data model structs and their `GetX()`/`SetX()`/`NewXxx()` helpers and
  `PtrString`/`PtrInt` are carried over from v1.

## v1.0.1 / v1.0.0

Generated OpenAPI client. No longer the active development line; kept for
existing consumers.
