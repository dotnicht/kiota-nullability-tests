#!/usr/bin/env bash
# Starts each service sequentially on port 8080, dumps its OpenAPI spec, then kills it.
# Usage: ./run-spec.sh [output-dir]
#   output-dir defaults to ./specs/
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUT="${1:-$SCRIPT_DIR/specs}"
PORT=8080
BINARY_DIR="$SCRIPT_DIR/target/debug"

mkdir -p "$OUT"

services=(
  service-primitives
  service-objects
  service-enums
  service-collections
  service-compositions
  service-params
)

for svc in "${services[@]}"; do
  echo "==> $svc"
  PORT=$PORT "$BINARY_DIR/$svc" &
  PID=$!

  # Wait until port is open (up to 5s)
  for i in $(seq 1 50); do
    if curl -sf "http://localhost:$PORT/openapi.json" > /dev/null 2>&1; then break; fi
    sleep 0.1
  done

  curl -sf "http://localhost:$PORT/openapi.json" > "$OUT/$svc.json"
  echo "   saved $OUT/$svc.json"

  kill $PID 2>/dev/null
  wait $PID 2>/dev/null || true
  sleep 0.3
done

echo ""
echo "All specs saved to $OUT/"
ls -lh "$OUT/"
