from typing import List

from kestrapy.base_api import BaseApi
from kestrapy.models.kill_switch import KillSwitch


class KillSwitchesApi(BaseApi):
    """Kill switches (`/api/v1/kill-switches`). Instance-owner-only."""

    def create_kill_switch(self, kill_switch: KillSwitch) -> KillSwitch:
        path = self._superadmin_path("kill-switches")
        return self._json_request("POST", path, KillSwitch, body=kill_switch)

    def update_kill_switch(self, id: str, kill_switch: KillSwitch) -> KillSwitch:
        path = self._superadmin_path("kill-switches", id)
        return self._json_request("PUT", path, KillSwitch, body=kill_switch)

    def delete_kill_switch(self, id: str) -> None:
        path = self._superadmin_path("kill-switches", id)
        self._void_request("DELETE", path)

    def search_kill_switches(self) -> List[KillSwitch]:
        path = self._superadmin_path("kill-switches", "search")
        return self._json_list_request("GET", path, KillSwitch)
