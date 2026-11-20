// The whole generated API surface behind one specifier, matching the in-repo OSS/EE UI SDKs
// where the root entry cannot carry it (module federation pins a share's whole export surface).
// The hand-written flow-from-object helpers are included so `/all` stays a superset of every
// per-module subpath (they live on `/flows`). The same goes for the executions overloads and
// background variants (on `/executions`): they are named explicitly so they win over the
// generated `deleteExecutionsBy*` re-exported by `./openapi/index`.
import * as generated from "./openapi/index"
import * as flowFromObject from "./flow-from-object"
import {
    deleteExecutionsByIds,
    deleteExecutionsByIdsInBackground,
    deleteExecutionsByQuery,
    deleteExecutionsByQueryInBackground,
} from "./executions"

export * from "./openapi/index"
export * from "./flow-from-object"
export {
    deleteExecutionsByIds,
    deleteExecutionsByIdsInBackground,
    deleteExecutionsByQuery,
    deleteExecutionsByQueryInBackground,
}
const sdk = {
    ...generated,
    ...flowFromObject,
    deleteExecutionsByIds,
    deleteExecutionsByIdsInBackground,
    deleteExecutionsByQuery,
    deleteExecutionsByQueryInBackground,
}
export default sdk
