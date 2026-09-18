import pytest

from test_helpers import TENANT, random_id
from kestrapy import QuotaLimit, QuotaLimitControllerApiQuotaLimitResetRequest
from kestrapy.exceptions import NotFoundException


def test_search_quota_limits_returns_list(client):
    result = client.quotas.search_quota_limits(TENANT)

    assert isinstance(result, list)
    assert all(isinstance(item, QuotaLimit) for item in result)


def test_reset_quota_limit_unknown_id_returns_404(client):
    request = QuotaLimitControllerApiQuotaLimitResetRequest(id="does-not-exist-" + random_id())

    with pytest.raises(NotFoundException) as exc_info:
        client.quotas.reset_quota_limit(TENANT, request)
    assert exc_info.value.status == 404
    assert "Quota limit not found" in exc_info.value.body
