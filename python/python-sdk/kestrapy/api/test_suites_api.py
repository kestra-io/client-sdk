from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.paged_results_test_suite import PagedResultsTestSuite
from kestrapy.models.paged_results_test_suite_run_result import PagedResultsTestSuiteRunResult
from kestrapy.models.test_suite import TestSuite
from kestrapy.models.test_suite_controller_run_request import TestSuiteControllerRunRequest
from kestrapy.models.test_suite_controller_search_tests_last_result import TestSuiteControllerSearchTestsLastResult
from kestrapy.models.test_suite_controller_test_suite_bulk_request import TestSuiteControllerTestSuiteBulkRequest
from kestrapy.models.test_suite_controller_tests_last_result_response import TestSuiteControllerTestsLastResultResponse
from kestrapy.models.test_suite_run_result import TestSuiteRunResult
from kestrapy.models.test_suite_service_run_by_query_request import TestSuiteServiceRunByQueryRequest
from kestrapy.models.test_suite_service_test_run_by_query_result import TestSuiteServiceTestRunByQueryResult
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation


class TestSuitesApi(BaseApi):

    # ---- CRUD ----

    def create_test_suite(self, tenant: str, yaml_body: str) -> TestSuite:
        path = self._tenant_path(tenant, "tests")
        return self._json_request("POST", path, TestSuite, body=yaml_body, content_type=self.YAML)

    def test_suite(self, namespace: str, id: str, tenant: str) -> TestSuite:
        path = self._tenant_path(tenant, "tests", namespace, id)
        return self._json_request("GET", path, TestSuite)

    def update_test_suite(self, namespace: str, id: str, tenant: str, yaml_body: str) -> TestSuite:
        path = self._tenant_path(tenant, "tests", namespace, id)
        return self._json_request("PUT", path, TestSuite, body=yaml_body, content_type=self.YAML)

    def delete_test_suite(self, namespace: str, id: str, tenant: str) -> Any:
        path = self._tenant_path(tenant, "tests", namespace, id)
        return self._raw_json_request("DELETE", path)

    # ---- Bulk operations ----

    def delete_test_suites_by_ids(self, tenant: str, request: TestSuiteControllerTestSuiteBulkRequest) -> BulkResponse:
        path = self._tenant_path(tenant, "tests", "by-ids")
        return self._json_request("DELETE", path, BulkResponse, body=request)

    def enable_test_suites_by_ids(self, tenant: str, request: TestSuiteControllerTestSuiteBulkRequest) -> BulkResponse:
        path = self._tenant_path(tenant, "tests", "enable", "by-ids")
        return self._json_request("POST", path, BulkResponse, body=request)

    def disable_test_suites_by_ids(self, tenant: str, request: TestSuiteControllerTestSuiteBulkRequest) -> BulkResponse:
        path = self._tenant_path(tenant, "tests", "disable", "by-ids")
        return self._json_request("POST", path, BulkResponse, body=request)

    # ---- Run ----

    def run_test_suite(
        self,
        namespace: str,
        id: str,
        tenant: str,
        request: Optional[TestSuiteControllerRunRequest] = None,
    ) -> TestSuiteRunResult:
        path = self._tenant_path(tenant, "tests", namespace, id, "run")
        return self._json_request("POST", path, TestSuiteRunResult, body=request)

    def run_test_suites_by_query(self, tenant: str, request: TestSuiteServiceRunByQueryRequest) -> TestSuiteServiceTestRunByQueryResult:
        path = self._tenant_path(tenant, "tests", "run")
        return self._json_request("POST", path, TestSuiteServiceTestRunByQueryResult, body=request)

    # ---- Search ----

    def search_test_suites(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        namespace: Optional[str] = None,
        flow_id: Optional[str] = None,
        include_child_namespaces: Optional[bool] = None,
    ) -> PagedResultsTestSuite:
        path = self._tenant_path(tenant, "tests", "search")
        params = list(self._build_query_params(
            page=page, size=size, namespace=namespace,
            flowId=flow_id, includeChildNamespaces=include_child_namespaces,
        ).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsTestSuite, params=params)

    # ---- Results ----

    def test_result(self, id: str, tenant: str) -> TestSuiteRunResult:
        path = self._tenant_path(tenant, "tests", "results", id)
        return self._json_request("GET", path, TestSuiteRunResult)

    def search_test_suites_results(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        test_suite_id: Optional[str] = None,
        namespace: Optional[str] = None,
        flow_id: Optional[str] = None,
    ) -> PagedResultsTestSuiteRunResult:
        path = self._tenant_path(tenant, "tests", "results", "search")
        params = list(self._build_query_params(
            page=page, size=size, testSuiteId=test_suite_id,
            namespace=namespace, flowId=flow_id,
        ).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsTestSuiteRunResult, params=params)

    def tests_last_result(self, tenant: str, request: TestSuiteControllerSearchTestsLastResult) -> TestSuiteControllerTestsLastResultResponse:
        path = self._tenant_path(tenant, "tests", "results", "search", "last")
        return self._json_request("POST", path, TestSuiteControllerTestsLastResultResponse, body=request)

    # ---- Validation ----

    def validate_test_suite(self, tenant: str, yaml_body: str) -> ValidateConstraintViolation:
        path = self._tenant_path(tenant, "tests", "validate")
        return self._json_request("POST", path, ValidateConstraintViolation, body=yaml_body, content_type=self.YAML)
