#!/usr/bin/env bash

set -e

log_and_run() {
  echo "> $@"
  "$@"
}

if [ $# -ge 1 ]; then
  versions="$1"
else
  versions="develop"
fi

echo "/n------------------------------------------------"
echo "Build local SDK and test it in a docker Kestra instance"

echo "install requirements"
log_and_run pip install -r requirements.txt -r test-requirements.txt --break-system-packages

echo "install SDK locally so it can be imported and used in e2e tests"
log_and_run pip install -e . --break-system-packages

echo "run model unit tests (no Kestra container needed)"
log_and_run python3 -m pytest tests/ -v

for KESTRA_VERSION in $versions; do
  if [ -z "$KESTRA_VERSION" ]; then
    continue
  fi

  echo "docker KESTRA_VERSION used: $KESTRA_VERSION\n"

  export KESTRA_VERSION=$KESTRA_VERSION

  echo "start Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
     echo "db Docker Compose failed. Dumping logs:";
     log_and_run docker compose -f docker-compose-ci.yml logs;
     exit 1;
  }

  # ---------------------------------------------------------------------------
  # Shard the suite across fresh stacks to cap the kestra-ee 2.0 scheduler heap
  # leak (see docker-compose-ci.yml). The leak is time-driven and takes a few
  # hundred seconds to OOM even at 4g; by splitting the suite and fully resetting
  # the stack (down/up = fresh JVM + empty DB) between shards, each JVM lives
  # well under that threshold and never accumulates far enough to die.
  #
  # ISOLATED_FILES each get their own fresh stack; the rest are round-robined
  # into NSHARDS groups. Files that drive the heap hardest run solo so a single
  # shard never lives long enough (or allocates enough) to hit the leak:
  #   - test_triggers_api: creates Schedule-trigger flows that feed
  #     DefaultSchedulableTriggerFetcher directly — the scheduler-leak
  #     ACCELERANT. Shards containing it OOM'd while a 141-test shard without it
  #     ran clean in 27s, so the leak is driven by schedule flows, not test
  #     volume. On a fresh short-lived stack the fetcher never chains far enough;
  #   - test_test_suites_api: creates flows + suites and runs them end-to-end
  #     (synchronous executions) — it OOM'd a shard right after ~56 other tests;
  #   - test_namespaces_api: hammers the un-paginated namespace/secret/credential
  #     endpoints (2.0 returns whole tables);
  #   - test_logs_api: the feature under test, kept solo for a clean signal.
  # Test files are independent (random ids, no cross-file state), so splitting by
  # file is safe.
  # ---------------------------------------------------------------------------
  NSHARDS="${NSHARDS:-4}"
  ISOLATED_FILES="testApis/test_logs_api.py testApis/test_namespaces_api.py testApis/test_test_suites_api.py testApis/test_triggers_api.py"

  mapfile -t ALL_FILES < <(ls testApis/test_*.py | sort)
  rest=()
  for f in "${ALL_FILES[@]}"; do
    case " $ISOLATED_FILES " in
      *" $f "*) : ;;            # isolated, handled as its own shard below
      *) rest+=("$f") ;;
    esac
  done

  # Build the shard list: each isolated file first (own fresh stack), then the
  # rest round-robined into NSHARDS groups.
  shards=()
  for f in $ISOLATED_FILES; do shards+=("$f"); done
  for ((g = 0; g < NSHARDS; g++)); do
    grp=""
    for ((i = g; i < ${#rest[@]}; i += NSHARDS)); do grp+="${rest[$i]} "; done
    [ -n "$grp" ] && shards+=("${grp% }")
  done

  test_rc=0
  shard_idx=0
  for shard in "${shards[@]}"; do
    if [ "$shard_idx" -ne 0 ]; then
      echo "reset the stack (empty DB + fresh JVMs) before shard ${shard_idx}"
      log_and_run docker compose -f docker-compose-ci.yml down
      log_and_run docker compose -f docker-compose-ci.yml up -d --wait || {
        echo "stack did not come back healthy before shard ${shard_idx}; dumping logs:"
        docker compose -f docker-compose-ci.yml logs --no-color --tail 100 || true
        test_rc=1
        break
      }
    fi
    shard_idx=$((shard_idx + 1))

    echo "=== shard ${shard_idx}: ${shard} ==="
    set +e
    # --reruns: the 2.0 develop stack is intermittently slow/unresponsive (a
    # single request occasionally hangs past the 10s timeout) and community
    # blueprint endpoints proxy to an external api.kestra.io that flakes with
    # 502s. Retry a failed test a couple of times (with a delay so the stack can
    # recover) so one transient blip doesn't red the whole suite. A genuinely
    # broken test still fails after its reruns.
    # shellcheck disable=SC2086  # word-splitting intentional: shard is a file list
    python3 -m pytest -v --timeout=10 --reruns 2 --reruns-delay 5 ${shard}
    rc=$?
    set -e
    # exit code 5 = "no tests collected"; treat as success for this shard
    if [ "$rc" -ne 0 ] && [ "$rc" -ne 5 ]; then
      test_rc=$rc
    fi
  done

  if [ "$test_rc" -ne 0 ]; then
    echo "tests failed (rc=$test_rc) - dumping Kestra diagnostics before teardown"
    echo "----- kestra container state -----"
    docker inspect python-sdk-test-kestra \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}} Restarts={{.RestartCount}}' || true
    echo "----- postgres container state -----"
    docker inspect python-sdk-test-postgres \
      --format 'OOMKilled={{.State.OOMKilled}} ExitCode={{.State.ExitCode}} Status={{.State.Status}}' || true
    echo "----- kestra logs (last 300 lines) -----"
    docker compose -f docker-compose-ci.yml logs --no-color --tail 300 kestra || true
  fi

  echo "stop Kestra container"
  log_and_run docker compose -f docker-compose-ci.yml down

  if [ "$test_rc" -ne 0 ]; then
    exit "$test_rc"
  fi
done
