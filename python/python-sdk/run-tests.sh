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
  # Run every test file on its own fresh stack to cap the kestra-ee 2.0 scheduler
  # heap leak (see docker-compose-ci.yml). The leak is time-driven from boot: the
  # scheduler accumulates heap on a timer regardless of test volume, so ANY shard
  # that lives long enough OOMs. We used to isolate only the known heap-heavy
  # files (triggers/test_suites/namespaces/logs) and round-robin the rest into a
  # few batches, but a 2026-07 freshness run proved that unsafe — a batch of
  # "light" files (groups+phase4+users, none of them heap-heavy) still ran long
  # enough to OOM the JVM mid-shard, then every remaining test in that shard hit
  # the dead port (a wall of ConnectionRefused). So batching is out: each file
  # gets its own short-lived JVM (down/up between shards = fresh JVM + empty DB),
  # which never lives long enough for the timer leak to accumulate. Test files
  # are independent (random ids, no cross-file state), so per-file is safe.
  # test_helpers.py is an imported helper module (collects no tests), so skip it.
  # ---------------------------------------------------------------------------
  mapfile -t shards < <(ls testApis/test_*.py | grep -v '/test_helpers\.py$' | sort)

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
    # shard is a single test file path (no spaces); quote it normally.
    python3 -m pytest -v --timeout=10 --reruns 2 --reruns-delay 5 "${shard}"
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
