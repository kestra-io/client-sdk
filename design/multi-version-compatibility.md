# Supporting two Kestra LTS lines (1.3 and 2.0) in one SDK repo

**Status:** Proposed. Java version-gate prototype implemented on this branch (see §4).
**Motivation:** [issue #265](https://github.com/kestra-io/client-sdk/issues/265) — tests skipped/disabled for Kestra 2.0 across all SDKs. Related exploration: `feat/v1-compatible-client` (single adaptive Go client).
**Author:** (draft for review)

## 1. Problem

The SDKs must work against two Kestra LTS lines that are live at the same time:
**1.3** and **2.0**. Today the only mechanism is *disabling* the tests that don't
pass against the 2.0 CI image — `@Disabled("Kestra 2.0: …")` in Java,
`t.Skip("…")` in Go, etc. That is a stop-gap with two failure modes:

- **Disabled-and-forgotten.** A bare `@Disabled` is off on *every* server. The
  1.3 behaviour it used to assert is now untested even on 1.3, and nothing
  re-enables it when the cause is fixed.
- **No contract for users.** Nothing tells a user which SDK version to install
  for their server, and nothing stops a 2.0-only call from compiling against a
  1.3 server and 404-ing at runtime.

## 2. What actually diverges

It's important to separate three kinds of incompatibility, because they have
different owners and only one of them is "SDK code":

| Bucket | Examples (from #265) | Owner |
|---|---|---|
| **A. API surface** — paths/types that exist in one line only | `/actions/` execution endpoints; KV detail `map`→scalar; `QueryFilter`→`SearchFilter` | **Per-line SDK source** — differs because the specs differ |
| **B. Server behaviour** — same endpoint, different result | search no longer filters server-side; replay/restart now require the source flow to exist | **Test expectations** — the SDK cannot (and should not) fake the old behaviour |
| **C. Environment** — config, not code | execution actions return 403 (test token lacks 2.0 RBAC perms) | **Test infra** |

The disabled tests in #265 are overwhelmingly **B and C — test assertions**, not
SDK behaviour. Bucket A is real SDK divergence, but it is contained *per line*:
each branch builds from its own committed spec (`kestra-ee.yml`) — regenerated for
the generated SDKs (Python, JS), hand-edited for the hand-written ones (Java, Go) —
so a 2.0 SDK *has* `/actions/` and a 1.3 SDK does not, with no conditional code in a
single artifact.

So the strategy splits cleanly: **per-line branches/specs** handle bucket A;
**version-gated tests** handle buckets B and C.

## 3. Decision

### 3.1 Version each SDK on its own semver; declare Kestra support explicitly

The SDK version is **not** coupled to the Kestra version. An SDK major bumps for
*SDK-surface* reasons (e.g. the generated→hand-written rewrite), and which Kestra
line a release targets is declared, not encoded in the number. This deliberately
avoids two problems that a "SDK major == Kestra major" rule would create: a
breaking renumber from today's shared `1.0.x` track, and a permanent entanglement
with Go — whose `/v2` already means "hand-written rewrite", not Kestra 2.0 (see
§3.5). "The SDK changed" and "which server it talks to" stay independent.

The contract is therefore:

- **A compatibility matrix** in every `README_*_SDK.md` mapping SDK version → supported
  Kestra version(s). *This is the contract* — the version number is not. It's the
  single biggest "clear for users" win and matches what k8s `client-go`, the
  Elasticsearch clients, and the AWS SDKs all publish.
- **Per-line branches drive the divergence.** Active development targets the latest
  Kestra line on `main`; each still-supported older LTS gets a maintenance branch
  (`releases/v1.3.x`) that receives back-ported fixes via the existing `backport`
  skill. `compute-version` already derives the Kestra version from the branch
  (`releases/* → that version`, else `develop`), and the spec (`kestra-ee.yml`) is
  committed per-branch — so each line builds from *its own* spec (regenerated for
  Python/JS, hand-edited for Java/Go) and bucket-A differences live on separate
  branches instead of as conditional code in one artifact.
- **Convenience pointers where the ecosystem has them.** npm dist-tags
  (`@kestra-2.x`, `@kestra-1.3`) give a floating "latest SDK for this Kestra line"
  alias. PyPI and Maven Central have no equivalent, so there the matrix + a pinned
  version range is the mechanism (see §3.4).

Because the two Kestra lines are published under the **same** package coordinates
at different versions, a single project normally uses one SDK matched to its
server; the mixed-fleet case is handled by isolation, not by a magic version
(§3.4).

### 3.2 Replace `@Disabled` / `t.Skip` with version gates

A test that asserts bucket-B/C behaviour should declare the **version range it is
valid for**, then *run* against a matching server and *skip with a version-tied
reason* against any other. This converts "disabled and forgotten" into
"conditionally asserted":

- A test that asserts **pre-2.0** behaviour (e.g. search filters server-side) is
  gated `max = "1.3"` — it keeps running on the 1.3 line and is skipped on 2.0.
- A test that asserts **new 2.0** behaviour is gated `min = "2.0"` — and someone
  should *write* these as the 1.3-only assertions are gated off, so 2.0 behaviour
  is positively covered rather than merely "not asserted".

The version is resolved **once from the live server** (`GET /api/v1/configs` →
`version`), with the CI `KESTRA_VERSION` env var as fallback. Pre-release labels
(`develop`, `…-SNAPSHOT`) are treated as the latest line: they satisfy every
`min` and no `max`.

### 3.3 Keep runtime adaptation the exception, not the model

`feat/v1-compatible-client` explores a *single adaptive client* (dual generated
surfaces, runtime `QueryFilter`→2.0-filter translation, a KV type that accepts
both shapes). It is tempting but is the wrong **primary** model long-term: it
forces a union API surface, runtime version-branching, and "compiles but 404s
against your server" — the opposite of clear.

Keep adaptive shims only where the cost is trivially low and the value is high
(the legacy-search-param translation is a good example — it spares users a
breaking rename within a line). Treat them as a thin compat layer *inside* a
line, never as a replacement for §3.1.

### 3.4 User procedure: installing for a 1.3 vs a 2.0 server

The rule a user follows is: **look up your Kestra version in the SDK's
compatibility matrix and install the SDK version it lists.** The package
name/coordinates never change between lines — only the version you pin (or the
dist-tag you point at) does. The version *numbers* below are illustrative
placeholders (`A.B.C` = the matrix entry for Kestra 1.3, `X.Y.Z` = the entry for
2.0); they track each SDK's own semver, not the Kestra number.

**JavaScript** — package `@kestra-io/kestra-sdk`. npm dist-tags give a floating
alias per Kestra line, so most users never read a number:
```bash
npm install @kestra-io/kestra-sdk@kestra-2.x    # floating: latest SDK for Kestra 2.x
npm install @kestra-io/kestra-sdk@kestra-1.3    # floating: latest SDK for Kestra 1.3
npm install @kestra-io/kestra-sdk@X.Y.Z         # or pin the exact matrix version
```
Imports are identical either way: `import { KestraClient } from "@kestra-io/kestra-sdk"`.

**Python** — package `kestrapy`. PyPI has no dist-tags, so pin the range the matrix
gives for your line:
```bash
pip install 'kestrapy>=X.Y,<NEXT'   # range the matrix lists for Kestra 2.x
pip install 'kestrapy>=A.B,<X.Y'    # range the matrix lists for Kestra 1.3
```
Imports are identical: `from kestrapy import KestraClient`.

**Java** (Maven) — coordinates `io.kestra:kestra-api-client`. No channels either; pin
the matrix version:
```xml
<dependency>
  <groupId>io.kestra</groupId>
  <artifactId>kestra-api-client</artifactId>
  <version>X.Y.Z</version>   <!-- the matrix entry for your Kestra line -->
</dependency>
```
Gradle: `implementation("io.kestra:kestra-api-client:X.Y.Z")`. Package imports
(`io.kestra.sdk.*`) are identical.

**Go** — the module-path major reflects the **SDK rewrite generation**, not Kestra.
Today that happens to line up: 1.3 is served by the older *generated* client on the
unsuffixed path, and 2.0-era development is the *hand-written* client on `/v2`:
```bash
go get github.com/kestra-io/client-sdk/go-sdk/v2@latest   # hand-written line (currently Kestra 2.x)
go get github.com/kestra-io/client-sdk/go-sdk@vA.B.C       # older generated line (Kestra 1.3)
```
Treat the matrix as authoritative for which tag maps to which Kestra — the
`/v2` boundary aligning with the Kestra-line boundary is a coincidence of timing,
not a rule, and won't hold for a future Kestra 3.0 (which would *not* get a Go `/v3`
unless the SDK surface also broke).

#### Can a single project use both at once?

For a **mixed fleet** (some servers on 1.3, some on 2.0) driven from one codebase:
because both Kestra lines ship under the **same package coordinates at different
versions**, none of the ecosystems let you depend on both cleanly — the dependency
resolver collapses them to one version:

| SDK | Both lines in one project/build? | Workaround |
|---|---|---|
| **JavaScript** | ⚠️ Via alias only | `npm install kestra-13@npm:@kestra-io/kestra-sdk@kestra-1.3 kestra-2@npm:@kestra-io/kestra-sdk@kestra-2.x`, import each alias |
| **Python** | ❌ Not in one env | `kestrapy` resolves to one version per environment — use **separate virtualenvs** (or two processes) |
| **Java** | ❌ Not on one classpath | One `io.kestra:kestra-api-client` version per module — would need shading/relocation |
| **Go** | ⚠️ Only by coincidence today | Works *now* because the two lines sit on different module majors (generated vs `/v2`); not a guarantee — once 1.3 support ends or 3.0 lands, both live lines share one major and can't coexist |

So the documented guidance for a mixed fleet is **isolate per server line**
(separate module, venv, or process) rather than forcing two versions into one
classpath. This is another reason §3.3 keeps a runtime-adaptive single client out
of the primary model: it would exist mainly to paper over this minority case, at a
cost not worth paying.

### 3.5 Migration: no renumber needed

Because the SDK version is decoupled from Kestra (§3.1), adopting this scheme is
**not** a breaking renumber — today's track simply continues. Current state:

- All four SDKs publish on a **shared `1.0.x` track** (tags `v1.0.N-<lang>` —
  Java `1.0.11`, Python `1.0.10`, JS `1.0.12`); that number was never tied to a
  Kestra version. It keeps advancing by SDK-surface semver.
- Go is **moving its module path to `/v2`** for the generated→hand-written rewrite
  (`chore(go): bump module path to /v2 for first hand-written release`), *not* for
  Kestra 2.0. Java likewise went hand-written (#222). These rewrites drive their
  own majors and are documented in the matrix like any other release.

Concretely, the migration is additive:

1. `main` keeps targeting the latest Kestra line and advancing its own semver.
2. (Re)cut/confirm a `releases/v1.3.x` maintenance branch per SDK for 1.3 bugfix
   back-ports.
3. Add the compatibility matrix to each README and, for npm, publish the
   `kestra-1.3` / `kestra-2.x` dist-tags.

No published version is skipped or reinterpreted; the matrix is layered on top of
the versioning that already exists.

## 4. Prototype (Java)

Implemented on this branch as the reference pattern other SDKs follow:

- `io.kestra.KestraServerVersion` — parses a `MAJOR.MINOR` from a server/CI label;
  unparseable labels (`develop`, `latest`) become `LATEST` (≥ every line).
- `io.kestra.EnabledIfKestraVersion` — `@EnabledIfKestraVersion(min=…, max=…, reason=…)`
  on a method or class. Inclusive bounds, either side optional.
- `io.kestra.KestraVersionCondition` — the JUnit 5 `ExecutionCondition` behind it.
- `TestUtils.serverVersion()` — resolves the version once from `GET /api/v1/configs`,
  falling back to `KESTRA_VERSION`.

`NamespacesApiTest` is converted as the worked example: its three search tests go
from `@Disabled("Kestra 2.0: …")` to `@EnabledIfKestraVersion(max = "1.3", reason = "…(#265)")`.

```java
@Test
@EnabledIfKestraVersion(max = "1.3", reason = "2.0 namespace search no longer filters server-side by 'q' (#265)")
void searchNamespaces_withQuery() throws ApiException { … }
```

### Equivalent gate per SDK (to build out)

| SDK | Mechanism |
|---|---|
| Java | `@EnabledIfKestraVersion(min/max)` (this branch) |
| Go | `requireKestraVersion(t, ">=2.0")` helper calling `t.Skip` with a version reason |
| Python | `@pytest.mark.min_kestra("2.0")` + a skip fixture |
| JS / Vitest | `it.skipIf(!serverAtLeast("2.0"))` |

## 5. Rollout

1. Land the Java gate (this branch) and migrate the remaining `@Disabled("Kestra 2.0…")`
   in Java to it (`Apps`, `Blueprints`, `Executions`, `Flows`).
2. Port the gate helper to Go / Python / JS; migrate their skips.
3. Add the compatibility matrix (§3.1) to each README; for npm, publish the
   `kestra-1.3` / `kestra-2.x` dist-tags.
4. Cut/confirm a `releases/v1.3.x` maintenance branch for each SDK (§3.5) — no
   version renumber.
5. **Definition of done for #265:** no bare `@Disabled` / `t.Skip` / `it.skip`
   referencing "Kestra 2.0" or "/actions/" remains — each is either a version gate
   or a fixed-and-re-enabled test, and genuine kestra-ee bugs are gated *and*
   linked to a filed issue.

## 6. Alternatives considered

- **Numeric lockstep — SDK major == Kestra major** (`@^2` ⇒ Kestra 2). Easiest for
  a user to eyeball, but **rejected**: it forces a breaking renumber from today's
  `1.0.x` track, and permanently entangles two unrelated reasons to bump a major —
  a Kestra major bump and an SDK-surface rewrite (Go's `/v2` is the latter, not the
  former). The §3.1 matrix gives the same "which SDK for my server" answer without
  hijacking the version number.
- **Lowest-common-denominator single SDK** (only expose what works on both). Loses
  features and cannot represent bucket-B behaviour differences. Rejected.
- **Full runtime-adaptive union client** (§3.3). Highest maintenance cost, least
  predictable for users. Kept as a narrow shim mechanism only.
- **Leave tests `@Disabled`.** The status quo; fails both goals (untested on the
  line where they're valid, no user contract). Rejected.
