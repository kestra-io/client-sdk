from typing import List

from kestrapy.base_api import BaseApi
from kestrapy.models.banner import Banner


class BannersApi(BaseApi):
    """Announcement banners (`/api/v1/banners`). Instance-owner-only."""

    def create_banner(self, banner: Banner) -> Banner:
        path = self._superadmin_path("banners")
        return self._json_request("POST", path, Banner, body=banner)

    def update_banner(self, id: str, banner: Banner) -> Banner:
        path = self._superadmin_path("banners", id)
        return self._json_request("PUT", path, Banner, body=banner)

    def delete_banner(self, id: str) -> None:
        path = self._superadmin_path("banners", id)
        self._void_request("DELETE", path)

    def search_banners(self) -> List[Banner]:
        path = self._superadmin_path("banners", "search")
        return self._json_list_request("GET", path, Banner)
