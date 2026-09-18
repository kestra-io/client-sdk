#!/usr/bin/env bash
# -slim replaces -no-plugins (kestra-io/kestra#16054, kestra-io/actions#204), but
# older/unreleased versions may not have published a -slim image yet. Probe the
# registry and fall back so CI doesn't break on those.
resolve_kestra_image_suffix() {
  local version="$1"
  local repo="europe-west1-docker.pkg.dev/kestra-host/docker/kestra-ee"

  if docker pull -q "${repo}:${version}-slim" >/dev/null 2>&1; then
    echo "-slim"
  else
    echo "no ${repo}:${version}-slim, falling back to -no-plugins" >&2
    echo "-no-plugins"
  fi
}
