// The whole generated API surface behind one specifier, for consumers who prefer a single import
// over the per-tag subpaths. This is the only place the barrel lives: the root entry exports the
// client facade and the generated types, keeping the three Kestra SDKs (this one and the in-repo
// OSS/EE UI SDKs) on the same entry-point shape.
import * as sdk from "./openapi/index"

export * from "./openapi/index"
export default sdk
