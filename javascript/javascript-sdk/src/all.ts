// The whole generated API surface behind one specifier, matching the in-repo OSS/EE UI SDKs
// where the root entry cannot carry it (module federation pins a share's whole export surface).
// The hand-written flow-from-object helpers are included so `/all` stays a superset of every
// per-module subpath (they live on `/flows`).
import * as generated from "./openapi/index"
import * as flowFromObject from "./flow-from-object"

export * from "./openapi/index"
export * from "./flow-from-object"
const sdk = { ...generated, ...flowFromObject }
export default sdk
