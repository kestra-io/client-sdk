#!/bin/zsh

ROOT_DIR=$(cd "$(dirname "$0")/../.." && pwd)

TARGET_FILE="$ROOT_DIR/python-sdk/kestrapy/api/executions_api.py"


IMPORT=$(cat <<'EOF'
import requests
import sseclient
import json
from typing import Generator
EOF
)


SSE_METHOD=$(cat <<'EOF'
    def follow_execution_sse(
            self,
            execution_id: Annotated[StrictStr, Field(description="The execution id")],
            tenant: StrictStr,
            _request_timeout: Optional[Union[float, Tuple[float, float]]] = None,
            _request_auth: Optional[Dict[StrictStr, Any]] = None,
            _content_type: Optional[StrictStr] = None,
            _headers: Optional[Dict[StrictStr, Any]] = None,
            _host_index: Annotated[StrictInt, Field(ge=0, le=0)] = 0,
    ) -> Generator[Dict[str, Any], None, None]:
        """
        Follow an execution using SSE.

        This method establishes a persistent connection and yields
        EventExecution objects as they are streamed from the server,
        allowing to follow an execution in realtime.
        """

        _method, final_url, header_params, _body, _post_params = self._follow_execution_serialize(
            execution_id=execution_id,
            tenant=tenant,
            _request_auth=_request_auth,
            _content_type=_content_type,
            _headers=_headers,
            _host_index=_host_index
        )

        header_params['Accept'] = 'text/event-stream'

        try:
            response = requests.get(
                final_url,
                headers=header_params,
                stream=True,
                timeout=_request_timeout
            )

            response.raise_for_status()

            client = sseclient.SSEClient(response)

            for event in client.events():
                if event.data is None or event.data == "":
                    continue

                yield json.loads(event.data)

        except requests.exceptions.RequestException as e:
            print(f"SSE connection failed: {e}")
            raise e
EOF
)

tmpfile=$(mktemp)

echo "$IMPORT" > "$tmpfile"
cat "$TARGET_FILE" >> "$tmpfile"
echo "$SSE_METHOD" >> "$tmpfile"

mv "$tmpfile" "$TARGET_FILE"
echo "Code injected successfully."
