import kestrapy
import os
from kestrapy.rest import ApiException
from pprint import pprint
import json

configuration = kestrapy.Configuration(
    host="http://localhost:8080",
    username="root@root.com",
    password="Root!1234"
)

tenant = 'main'

zip_path = os.environ.get('KESTRA_IMPORT_ZIP', 'flows.zip')

body = f"""
id: sdk
namespace: demo
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello from the SDK! 👋
"""

# Send the trigger as a Python dict, not a JSON string
trigger_dict = {
    "id": "schedule",
    "type": "io.kestra.plugin.core.trigger.Schedule",
    "cron": "*/15 * * * *"
}

with kestrapy.ApiClient(configuration) as api_client:
    api_instance = kestrapy.FlowsApi(api_client)

    try:
        validate_response = api_instance.validate_trigger(
            tenant,
            trigger_dict,
            _content_type="application/json"
        )
        print("\n✅ Validate trigger response (raw):")
        pprint(validate_response)

    except ApiException as e:
        print("❌ API exception during validate_trigger:")
        print(e)
        try:
            pprint(e.body)
        except Exception:
            pass
    except Exception as e:
        print("❌ Error during validate_trigger:")
        print(e)
