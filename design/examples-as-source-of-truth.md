# Keeping SDK examples correct: examples as a single source of truth

**Status:** Proposal / design — no implementation yet
**Motivation:** [issue #144](https://github.com/kestra-io/client-sdk/issues/144) — "SDK example code is not working (Python, JS, etc.)"
**Author:** (draft for review)

## 1. Problem

The SDK ships example code in two distinct surfaces, and **both drift out of sync with the actual SDK** because they are hand- or generator-copied snapshots that nothing verifies:

1. **Curated "getting-started" examples** — the snippets in the root `README_*_SDK.md` files
   (e.g. `README_JAVASCRIPT_SDK.md:95-117` "search and create a flow",
   `README_PYTHON_SDK.md`, `README_JAVA_SDK.md`).
2. **Per-API reference examples** — the auto-generated `python/python-sdk/docs/*.md`
   (one example per endpoint, ~176 calls).

Issue #144 is the symptom. The recent Python audit found, in the committed docs:
- every call used the wrong accessor (`kestra_client.FlowsApi.…` → `AttributeError`; the real
  property is `kestra_client.flows`);
- 37 calls had the wrong argument order (`tenant` was last; the hand-written API is tenant-first);
- 4 calls passed keyword args that don't exist on the method;
- 7 referenced methods that no longer exist (renamed/removed);
- 159 example blocks called `pprint` without importing it.

The root cause is structural, not a one-off: **the examples are copies, and no test or build step
fails when a copy disagrees with the code.** Fixing the copies (as we just did) resolves #144 *today*
but does nothing to prevent the next divergence.

### Why it got this bad on Python specifically
Commit #237 ("hand-write Python SDK API classes") turned `kestrapy/api/*_api.py` into hand-written
code, but the OpenAPI doc generator (`python/template/api_doc_example.mustache`) and the committed
`docs/*.md` were never retired. So the reference docs are **stale output of a generator that no
longer describes the SDK**. There is even a doc post-processor in `generate-sdks.sh:112-116` that was
meant to rewrite the accessor, but it is dead code:

```sh
# Replace wrong prop in docs for each api
for f in python-sdk/docs/*.md; do          # <-- wrong path: real dir is python/python-sdk/docs
  [ -f "$f" ] || continue                   #     so the glob matches nothing and the loop no-ops
  sed -E -i 's/\b([A-Za-z]+)Api\b/\L\1/g' "$f"   # (also mangles ServiceAccountApi -> serviceaccount)
done
```

## 2. Principle

> **An example should never be a copy. It should be the *only* place the code exists, and that place
> should be compiled/executed in CI.**

Drift becomes impossible when the published snippet is *physically the same text* as code that CI
runs. The two surfaces need two different mechanisms to achieve that, because their economics differ.

## 3. Current state

| Surface | JavaScript | Java | Python | Go |
|---|---|---|---|---|
| Curated example file | `javascript/test_javascript_sdk/basicSDKUsageExample.ts` | `java/java-sdk/java-sdk-test/src/main/java/io/kestra/example/BasicSDKUsageExample.java` | ❌ none | ❌ none |
| Executed in CI | ✅ vitest via `run-tests.sh` (`javascript-sdk.yml`) | ✅ gradle + `FlowsApiTest` (`java-sdk.yml`) | — | — |
| Snippet feeds the README | ❌ README has a separate copy | ❌ separate copy | ❌ separate copy | ❌ |
| Per-API reference docs | n/a | n/a | ✅ generated `docs/*.md` | — |

**Takeaways:**
- The hard part (a runnable, CI-tested example) already exists for JS and Java. The missing link is
  that the README keeps a *duplicate* instead of embedding the tested file.
- Python and Go have no curated tested example at all.
- The per-API `docs/*.md` are a separate problem: you cannot hand-write and run ~176 examples; they
  must be *derived* from the code.

## 4. Proposal

### Surface 1 — Curated README examples → inject from a CI-tested file

**Single source of truth:** one tested example file per language (the `BasicSDKUsageExample` files,
plus new ones for Python and Go). The README no longer contains a copy; it contains a *marker* that an
injector fills from the source.

**Author marks regions in the example source:**

```ts
// #region search-and-create
const searchRes = await Flows.searchFlows({ tenant: tenantId, page: 1, size: 10 });
const createRes = await Flows.createFlow({ tenant: tenantId, body: flow });
// #endregion
```

**README references the region (content between markers is machine-managed):**

```md
<!-- snippet:search-and-create lang=ts src=javascript/test_javascript_sdk/basicSDKUsageExample.ts -->
```ts
// (auto-filled by the injector — do not edit by hand)
```
<!-- /snippet -->
```

**An injector tool** reads the named region from `src`, writes it between the markers, and runs in two
modes:
- `--write` (local): update READMEs.
- `--check` (CI): exit non-zero if any README is out of date. This is the line that prevents #144
  from recurring.

**Tooling options:**
- **Off-the-shelf for TS/JS:** [`embedme`](https://github.com/zakhenry/embedme) does exactly this
  (`embedme --verify`). Mature, minimal config.
- **Recommended — one shared script for all four languages:** a ~50-line Node or Python script
  driven by `// #region NAME` / `// #endregion` (works in `.ts`, `.java`, `.go`, `.py`) and
  `<!-- snippet:NAME -->` markers in markdown. One tool, identical UX across SDKs, no per-language
  divergence. Lives in e.g. `test-utils/embed-snippets.(mjs|py)`.

**CI wiring (per existing workflow):**
- `javascript-sdk.yml`: after `npm test` (which already runs the example spec), add a
  `embed-snippets --check` step.
- `java-sdk.yml`: after the gradle test that exercises `BasicSDKUsageExample`, add the check.
- `python-sdk.yml` / `go-sdk.yml`: add a CI-run example test **and** the check.

**Gaps to close for full coverage:**
- Add `basic_sdk_usage_example.py` (run by an existing `testApis` test) — Python has no curated
  example today.
- Add a Go example (`Example_*` functions in Go double as `go test` cases and as `pkg.go.dev` docs —
  a natural fit).

### Surface 2 — Per-API reference docs → validate against the live signatures

You cannot realistically write and execute ~176 endpoint examples. But you don't need to *run* them to
keep them correct — you need them to **agree with the function signatures**. Every #144-class bug
(wrong accessor, wrong arg order, phantom method, bad keyword) is exactly "example disagrees with
signature."

**Single source of truth:** the hand-written SDK itself.

**Decision (implemented): validate, don't regenerate.** A signature-driven *generator* was considered,
but the rich `docs/*.md` content (parameter descriptions, auth, HTTP response codes) is derived from
the OpenAPI spec, not from the Python code — regenerating from signatures alone would drop it. So
instead of producing the docs, we *check* them: a small static validator
(`python/python-sdk/scripts/validate_doc_examples.py`) introspects every
`kestra_client.<accessor>.<method>(...)` example with `ast` and fails if:
1. `<accessor>` is not a real `@property` on `KestraClient` (catches `FlowsApi` → `flows`);
2. `<method>` does not exist on the API classes (catches renamed/removed methods);
3. a positional argument named like a real parameter sits at the wrong index (catches tenant-last);
4. a keyword argument names a parameter that doesn't exist (catches `q=` / `file_upload=`).

It needs no live server, so it runs as a fast CI step and as a gate inside `generate-sdks.sh`.

**Cleanup done alongside:**
- Removed the dead `generate-sdks.sh:112-116` post-processor (wrong path `python-sdk/docs`, and it
  mangled `ServiceAccountApi` → `serviceaccount`) and replaced it with the validator gate.
- `python/template/api_doc_example.mustache` remains for now; fully retiring the Python OpenAPI
  generation path is the larger task in §7.

Java/Go reference docs follow their own toolchains (javadoc / godoc) and are out of scope here.

## 5. Recommended rollout (independent, shippable in order)

1. **Build the shared injector** (`--write` / `--check`) and wire `--check` into JS + Java CI, using
   the example files that *already exist and already run*. Highest leverage, lowest risk; directly
   closes the #144 loop for the two SDKs that already have tested examples.
2. **Add curated tested examples for Python and Go**, then embed them in their READMEs via the same
   injector + CI check.
3. **Static validator for Python `docs/*.md`**, gating both CI (`python-sdk.yml`) and
   `generate-sdks.sh`.

Each step is self-contained and leaves the repo better than before.

> **Implemented for Python (this change):** shared injector (`test-utils/embed_snippets.py`); a
> CI-tested curated example (`python/python-sdk/testApis/basic_sdk_usage_example.py` +
> `test_basic_sdk_usage_example.py`) injected into `README_PYTHON_SDK.md`; the docs validator
> (`python/python-sdk/scripts/validate_doc_examples.py`); both wired into `python-sdk.yml` and the
> validator also gating `generate-sdks.sh`. JavaScript, Java and Go remain to be done (steps 1–2 for
> their curated examples).

## 6. Trade-offs & risks

- **Live-server dependency.** The curated examples hit a real Kestra (`localhost:9903` for JS,
  `:9901` for Java). The `--check` injector step is static (no server needed) — only the *example
  test* needs the server, which CI already provisions. Good separation.
- **Marker noise.** READMEs gain `<!-- snippet -->` comments. Acceptable; invisible when rendered.
- **Region granularity.** Keep regions small and named so a README can compose several (config +
  search + create) without forcing the example file to be one monolith.
- **Generator vs. hand-written reference docs.** The Python generator must reproduce today's doc
  structure (params table, auth, response section), or we accept a simpler generated format. Decide
  during step 3; the example *call* is the part that matters for correctness.
- **One tool vs. `embedme`.** `embedme` is less code to own but is JS-only; the shared script covers
  all four SDKs uniformly. Recommendation: shared script, because the value is cross-language
  consistency.

## 7. Out of scope

- Rewriting Java/Go reference documentation pipelines.
- Whether to retire Python SDK generation entirely (tracked separately; relevant because #237 already
  hand-wrote the API and the OpenAPI templates are now legacy).
