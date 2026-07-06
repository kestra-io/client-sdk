import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
)
from kestrapy import (
    ChartFiltersOverrides,
    DashboardControllerPreviewRequest,
    ApiException,
)


def dashboard_yaml(title, dashboard_id=None):
    if dashboard_id is None:
        dashboard_id = random_id()
    return (
        f"id: {dashboard_id}\n"
        f"title: {title}\n"
        "description: Test dashboard\n"
        "timeWindow:\n"
        "  default: P30D\n"
        "  max: P365D\n"
        "charts: []\n"
    )


# ========================================================================
# CRUD
# ========================================================================


def test_create_dashboard_basic(client):
    title = f"test-dash-{random_id()}"
    result = client.dashboards.create_dashboard(tenant=TENANT, yaml_body=dashboard_yaml(title))

    assert result is not None
    assert result.get("id") is not None and result["id"] != ""
    assert result.get("title") == title


def test_dashboard_get_by_id(client):
    title = f"get-dash-{random_id()}"
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(title)
    )

    result = client.dashboards.dashboard(id=created["id"], tenant=TENANT)

    assert result is not None
    assert result["id"] == created["id"]
    assert result["title"] == title


def test_dashboard_not_found(client):
    with pytest.raises(ApiException):
        client.dashboards.dashboard(id="nonexistent-dash-id", tenant=TENANT)


def test_update_dashboard_change_title(client):
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(f"before-{random_id()}")
    )
    new_title = f"after-{random_id()}"

    updated = client.dashboards.update_dashboard(
        id=created["id"],
        tenant=TENANT,
        yaml_body=dashboard_yaml(new_title, dashboard_id=created["id"]),
    )

    assert updated["title"] == new_title


def test_delete_dashboard_basic(client):
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(f"to-delete-{random_id()}")
    )

    # Should not raise
    client.dashboards.delete_dashboard(id=created["id"], tenant=TENANT)

    with pytest.raises(ApiException):
        client.dashboards.dashboard(id=created["id"], tenant=TENANT)


# ========================================================================
# Search
# ========================================================================


def test_search_dashboards_basic(client):
    client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(f"searchable-{random_id()}")
    )

    result = client.dashboards.search_dashboards(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.get("results") is not None
    assert len(result["results"]) > 0


def test_search_dashboards_with_pagination(client):
    result = client.dashboards.search_dashboards(tenant=TENANT, page=1, size=2)

    assert result is not None
    assert result.get("results") is not None
    assert len(result["results"]) <= 2


def test_search_dashboards_with_query(client):
    title = f"dashboard-{random_id()}"
    client.dashboards.create_dashboard(tenant=TENANT, yaml_body=dashboard_yaml(title))

    result = client.dashboards.search_dashboards(
        tenant=TENANT, page=1, size=10, q=title
    )

    assert result is not None
    assert result.get("results") is not None
    assert len(result["results"]) > 0


def test_search_dashboards_with_sort(client):
    prefix = f"sortdash{random_id()[:6]}"
    title1 = f"{prefix}aaa"
    title2 = f"{prefix}zzz"
    client.dashboards.create_dashboard(tenant=TENANT, yaml_body=dashboard_yaml(title2))
    client.dashboards.create_dashboard(tenant=TENANT, yaml_body=dashboard_yaml(title1))

    result = client.dashboards.search_dashboards(
        tenant=TENANT, page=1, size=10, q=prefix, sort=["title:asc"]
    )

    assert len(result["results"]) >= 2
    titles = [d["title"] for d in result["results"]]
    idx1 = titles.index(title1)
    idx2 = titles.index(title2)
    assert idx1 >= 0
    assert idx2 > idx1


def test_search_dashboards_no_results(client):
    result = client.dashboards.search_dashboards(
        tenant=TENANT, page=1, size=10, q=f"nonexistent_dashboard_{random_id()}"
    )

    assert result is not None
    assert len(result["results"]) == 0


# ========================================================================
# Settings
# ========================================================================


def test_default_dashboards_basic(client):
    settings = client.dashboards.default_dashboards(tenant=TENANT)
    assert settings is not None


# ========================================================================
# Validation
# ========================================================================


def test_validate_dashboard_valid(client):
    result = client.dashboards.validate_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(f"valid-{random_id()}")
    )

    assert result is not None


def test_validate_chart_valid(client):
    chart_yaml = (
        "id: test-chart\n"
        "type: io.kestra.plugin.ee.core.dashboard.charts.Executions\n"
        "columns:\n"
        "  date:\n"
        "    field: DATE\n"
        "  duration:\n"
        "    field: DURATION\n"
        "graphStyle: LINES\n"
    )

    result = client.dashboards.validate_chart(tenant=TENANT, yaml_body=chart_yaml)

    assert result is not None


# ========================================================================
# Chart data & export
# ========================================================================


@pytest.mark.xfail(
    reason="kestra-ee 2.0 hangs on the chart-data endpoint for a not-found chart "
    "instead of returning promptly, so the request exceeds the 10s pytest timeout "
    "(observed failing on a healthy webserver while neighbouring tests passed)",
    strict=False,
)
def test_dashboard_chart_data_not_found(client):
    title = f"chart-data-{random_id()}"
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(title)
    )

    filters = ChartFiltersOverrides()

    # Dashboard has no charts, so chart ID "nonexistent" should fail
    with pytest.raises(ApiException):
        client.dashboards.dashboard_chart_data(
            id=created["id"],
            chart_id="nonexistent",
            tenant=TENANT,
            filters=filters,
        )


@pytest.mark.xfail(
    reason="kestra-ee 2.0 hangs on the chart-data endpoint (same as the "
    "not-found variant above); a 2026-07-20 CI run showed the hang can also "
    "end in the JVM dying (heap OOM, ExitOnOutOfMemoryError) ~150s in, so the "
    "request exceeds the 10s pytest timeout",
    strict=False,
)
def test_dashboard_chart_data_with_populated_filters(client):
    from datetime import datetime, timezone, timedelta

    title = f"chart-data-filters-{random_id()}"
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(title)
    )

    # Exercise the non-empty filter branch: startDate, endDate, paging.
    now = datetime.now(timezone.utc)
    filters = ChartFiltersOverrides(
        start_date=now - timedelta(days=7),
        end_date=now,
        page_size=10,
        page_number=1,
    )

    # Dashboard has no charts so we still expect a 4xx — but with the
    # filter body populated, exercising the non-default code path.
    with pytest.raises(ApiException) as exc_info:
        client.dashboards.dashboard_chart_data(
            id=created["id"],
            chart_id="nonexistent",
            tenant=TENANT,
            filters=filters,
        )
    assert exc_info.value.status in (400, 404, 422)


def test_preview_chart_basic(client):
    request = DashboardControllerPreviewRequest(
        chart=(
            "id: preview-chart\n"
            "type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart\n"
            "graphStyle: LINES\n"
            "columns:\n"
            "  date:\n"
            "    field: DATE\n"
        )
    )

    # May fail with 422 if chart type not available, verifies endpoint reachability
    try:
        result = client.dashboards.preview_chart(tenant=TENANT, request=request)
        assert result is not None
    except ApiException as e:
        assert e.status in (400, 422)


def test_export_chart_basic(client):
    request = DashboardControllerPreviewRequest(
        chart=(
            "id: csv-chart\n"
            "type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart\n"
            "graphStyle: LINES\n"
            "columns:\n"
            "  date:\n"
            "    field: DATE\n"
        )
    )

    try:
        result = client.dashboards.export_chart(tenant=TENANT, request=request, format="CSV")
        assert result is not None
    except ApiException as e:
        assert e.status in (400, 422)


def test_export_chart_ion(client):
    request = DashboardControllerPreviewRequest(
        chart=(
            "id: ion-chart\n"
            "type: io.kestra.plugin.ee.core.dashboard.charts.TimeSeriesChart\n"
            "graphStyle: LINES\n"
            "columns:\n"
            "  date:\n"
            "    field: DATE\n"
        )
    )

    try:
        result = client.dashboards.export_chart(tenant=TENANT, request=request, format="ION")
        assert result is not None
    except ApiException as e:
        assert e.status in (400, 422)


@pytest.mark.xfail(
    reason="kestra-ee 2.0 hangs on the chart-data CSV-export endpoint for a "
    "not-found chart instead of returning promptly, so the request exceeds the "
    "10s pytest timeout (observed failing on a healthy webserver, no OOM, while "
    "every other shard-8 test passed) — same hang as test_dashboard_chart_data_not_found",
    strict=False,
)
def test_export_dashboard_chart_not_found(client):
    title = f"csv-export-{random_id()}"
    created = client.dashboards.create_dashboard(
        tenant=TENANT, yaml_body=dashboard_yaml(title)
    )

    filters = ChartFiltersOverrides()

    with pytest.raises(ApiException):
        client.dashboards.export_dashboard_chart(
            id=created["id"],
            chart_id="nonexistent",
            tenant=TENANT,
            filters=filters,
            format="CSV",
        )
