// @ts-check
// TestSuitesApi.spec.js

import { describe, it, expect } from 'vitest';
import { kestraClient, MAIN_TENANT, randomId } from './CommonTestSetup';

const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

// ---------------- YAML templates ----------------

const SIMPLE_TEST_SUITE = `
id: %testSuiteId%
namespace: %namespace%
description: assert flow is returning the input value as output
flowId: %flowId%
testCases:
  - id: test_case_1
    description: test_case_1 description
    type: io.kestra.core.tests.flow.UnitTest
    fixtures:
      inputs:
        inputA: "Hi there"
    assertions:
      - value: "{{ outputs.return.value }}"
        equalTo: 'Hi there'
`;

const INVALID_TEST_SUITE = `
id: %testSuiteId%
namespace: %namespace%
description: assert flow is returning the input value as output
# missing flow id
# missing test cases
`;

const FAILING_SIMPLE_TEST_SUITE = `
id: %testSuiteId%
namespace: %namespace%
description: assert flow is returning the input value as output
flowId: %flowId%
testCases:
  - id: test_case_1
    description: test_case_1 description
    type: io.kestra.core.tests.flow.UnitTest
    fixtures:
      inputs:
        inputA: "another value"
    assertions:
      - value: "{{ outputs.return.value }}"
        description: 'making this assertion always false'
        equalTo: 'Hi there'
`;

const LOG_FLOW = (id, ns) => `
id: ${id}
namespace: ${ns}

inputs:
  - id: inputA
    type: STRING

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: "inputA: {{ inputs.inputA }}"

  - id: return
    type: io.kestra.plugin.core.debug.Return
    format: "{{ inputs.inputA }}"

outputs:
  - id: "outputA"
    type: STRING
    value: "{{ outputs.return.value }}"
`;

// ---------------- helpers ----------------

function getTestSuiteYaml(template, testSuiteId, namespace, flowId) {
    return template
    .replace('%testSuiteId%', testSuiteId)
    .replace('%namespace%', namespace)
    .replace('%flowId%', flowId);
}

async function createSimpleFlow(flowId, namespace) {
    return createSimpleFlowFromBody(LOG_FLOW(flowId, namespace));
}

async function createSimpleFlowFromBody(flowBody) {
    const flow = await kestraClient().flowsApi.createFlow(MAIN_TENANT, flowBody);
    // small delay like the Java helper did
    await sleep(200);
    return flow;
}

async function assertTestSuiteExists(testSuite) {
    await expect(
        kestraClient().testSuitesApi.testSuite(testSuite.namespace, testSuite.id, MAIN_TENANT)
    ).resolves.toBeTruthy();
}

async function assertTestSuiteDoesNotExist(testSuite) {
    try {
        await kestraClient().testSuitesApi.testSuite(testSuite.namespace, testSuite.id, MAIN_TENANT);
        throw new Error('Expected 404 but request succeeded');
    } catch (err) {
        const status = err?.status ?? err?.response?.status ?? err?.code ?? err?.data?.code;
        expect(status).toBe(404);
    }
}

async function isTestSuiteDisabled(testSuite) {
    const ts = await kestraClient().testSuitesApi.testSuite(testSuite.namespace, testSuite.id, MAIN_TENANT);
    return !!ts?.disabled;
}

// ---------------- tests ----------------

describe('TestSuitesApiTest', () => {
    it('createTestSuiteTest', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        const yaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        const resp = await kestraClient().testSuitesApi.createTestSuite(MAIN_TENANT, yaml);

        expect(resp.id).toBe(testSuiteId);
        expect(resp.flowId).toBe(flowId);
        expect(resp.namespace).toBe(namespace);
        expect(resp.description).toBe('assert flow is returning the input value as output');

        const testCaseIds = (resp.testCases ?? []).map((tc) => tc.id);
        expect(testCaseIds).toEqual(['test_case_1']);

        const first = (resp.testCases ?? [])[0];
        expect(first?.description).toBe('test_case_1 description');
        expect(first?.type).toBe('io.kestra.core.tests.flow.UnitTest');
        expect(first?.disabled).toBe(false);
        expect(first?.fixtures?.inputs).toEqual({ inputA: 'Hi there' });

        const assertion = (first?.assertions ?? [])[0];
        expect(assertion?.equalTo).toBe('Hi there');
        expect(assertion?.value).toBe('{{ outputs.return.value }}');
    });

    it('getTestSuiteTest', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        const yaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        await kestraClient().testSuitesApi.createTestSuite(MAIN_TENANT, yaml);
        const fetched = await kestraClient().testSuitesApi.testSuite(namespace, testSuiteId, MAIN_TENANT);

        expect(fetched.id).toBe(testSuiteId);
        expect(fetched.flowId).toBe(flowId);
        expect(fetched.namespace).toBe(namespace);
        expect(fetched.description).toBe('assert flow is returning the input value as output');
    });

    it('deleteTestSuiteTest', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        const yaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        const created = await kestraClient().testSuitesApi.createTestSuite(MAIN_TENANT, yaml);
        await assertTestSuiteExists(created);

        await kestraClient().testSuitesApi.deleteTestSuite(namespace, testSuiteId, MAIN_TENANT);
        await assertTestSuiteDoesNotExist(created);
    });

    it('updateTestSuiteTest', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        let yaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        const created = await kestraClient().testSuitesApi.createTestSuite(MAIN_TENANT, yaml);
        await assertTestSuiteExists(created);

        yaml = yaml
        .replace('assert flow is returning the input value as output', 'updated testsuite description')
        .replace('test_case_1 description', 'updated testcase description');

        await kestraClient().testSuitesApi.updateTestSuite(namespace, testSuiteId, MAIN_TENANT, yaml);
        const fetched = await kestraClient().testSuitesApi.testSuite(namespace, testSuiteId, MAIN_TENANT);

        expect(fetched.id).toBe(testSuiteId);
        expect(fetched.description).toBe('updated testsuite description');
        expect((fetched.testCases ?? [])[0]?.description).toBe('updated testcase description');
    });

    it('validateTestSuiteTest_ok', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        const yaml = getTestSuiteYaml(SIMPLE_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        const vr = await kestraClient().testSuitesApi.validateTestSuite(MAIN_TENANT, yaml);

        expect(vr?.warnings ?? []).toHaveLength(0);
        expect(vr?.infos ?? []).toHaveLength(0);
        expect(vr?.deprecationPaths ?? []).toHaveLength(0);
        expect(vr?.constraints ?? null).toBeNull();
    });

    it('validateTestSuiteTest_invalid', async () => {
        const testSuiteId = randomId();
        const namespace = randomId();
        const flowId = randomId();
        const yaml = getTestSuiteYaml(INVALID_TEST_SUITE, testSuiteId, namespace, flowId);

        await createSimpleFlow(flowId, namespace);

        const vr = await kestraClient().testSuitesApi.validateTestSuite(MAIN_TENANT, yaml);

        // Normalize to an array of strings
        const constraintsRaw = vr?.constraints ?? [];
        const constraints = Array.isArray(constraintsRaw)
            ? constraintsRaw
            : String(constraintsRaw)
            .split(/\r?\n/)
            .map(s => s.trim())
            .filter(Boolean);

        // Assert only that these messages are present (order/extra lines ignored)
        expect(constraints).toEqual(
            expect.arrayContaining([
                expect.stringMatching(/testCases:\s*must not be empty/i),
                expect.stringMatching(/flowId:\s*must not be null/i),
            ])
        );
    });

    it('deleteTestSuiteByIdsTest', async () => {
        const flowId = randomId();
        const namespace = randomId();
        const flow = await createSimpleFlowFromBody(LOG_FLOW(flowId, namespace));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts3 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );

        await assertTestSuiteExists(ts2);
        await assertTestSuiteExists(ts1);
        await assertTestSuiteExists(ts3);

        const idsToDelete = [
            { id: ts1.id, namespace: ts1.namespace },
            { id: ts3.id, namespace: ts3.namespace },
        ];
        await kestraClient().testSuitesApi.deleteTestSuitesByIds(MAIN_TENANT, { ids: idsToDelete });

        await assertTestSuiteExists(ts2);
        await assertTestSuiteDoesNotExist(ts1);
        await assertTestSuiteDoesNotExist(ts3);
    });

    it('disableTestSuiteByIdsTest', async () => {
        const flowId = randomId();
        const namespace = randomId();
        const flow = await createSimpleFlowFromBody(LOG_FLOW(flowId, namespace));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts3 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );

        expect(await isTestSuiteDisabled(ts1)).toBe(false);
        expect(await isTestSuiteDisabled(ts2)).toBe(false);
        expect(await isTestSuiteDisabled(ts3)).toBe(false);

        const idsToDisable = [
            { id: ts1.id, namespace: ts1.namespace },
            { id: ts3.id, namespace: ts3.namespace },
        ];
        await kestraClient().testSuitesApi.disableTestSuitesByIds(MAIN_TENANT, { ids: idsToDisable });

        expect(await isTestSuiteDisabled(ts1)).toBe(true);
        expect(await isTestSuiteDisabled(ts2)).toBe(false);
        expect(await isTestSuiteDisabled(ts3)).toBe(true);
    });

    it('enableTestSuiteByIdsTest', async () => {
        const flowId = randomId();
        const namespace = randomId();
        const flow = await createSimpleFlowFromBody(LOG_FLOW(flowId, namespace));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );
        const ts3 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT,
            getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flow.id)
        );

        // ensure initially not disabled
        expect(await isTestSuiteDisabled(ts1)).toBe(false);
        expect(await isTestSuiteDisabled(ts2)).toBe(false);
        expect(await isTestSuiteDisabled(ts3)).toBe(false);

        // disable ts1 & ts3
        const idsToDisable = [
            { id: ts1.id, namespace: ts1.namespace },
            { id: ts3.id, namespace: ts3.namespace },
        ];
        await kestraClient().testSuitesApi.disableTestSuitesByIds(MAIN_TENANT, { ids: idsToDisable });

        expect(await isTestSuiteDisabled(ts1)).toBe(true);
        expect(await isTestSuiteDisabled(ts2)).toBe(false);
        expect(await isTestSuiteDisabled(ts3)).toBe(true);

        // enable ts1
        const idsToEnable = [{ id: ts1.id, namespace: ts1.namespace }];
        await kestraClient().testSuitesApi.enableTestSuitesByIds(MAIN_TENANT, { ids: idsToEnable });

        expect(await isTestSuiteDisabled(ts1)).toBe(false);
        expect(await isTestSuiteDisabled(ts2)).toBe(false);
        expect(await isTestSuiteDisabled(ts3)).toBe(true);
    });

    it('searchTestSuiteTest', async () => {
        const namespaceXXX = `namespacexxx_${randomId()}`;
        const namespaceYYY = `namespaceyyy_${randomId()}`;

        const flowAAA = await createSimpleFlowFromBody(LOG_FLOW(`flowaaa_${randomId()}`, namespaceXXX));
        const flowBBB = await createSimpleFlowFromBody(LOG_FLOW(`flowbbb_${randomId()}`, namespaceXXX));
        const flowCCC = await createSimpleFlowFromBody(LOG_FLOW(`flowccc_${randomId()}`, namespaceYYY));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite111_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite222_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite333_${randomId()}`, namespaceXXX, flowBBB.id)
        );
        const ts4 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite444_${randomId()}`, namespaceYYY, flowCCC.id)
        );

        const page = 1;
        const size = 1000;
        const includeChildNamespaces = false;
        const sort = null;

        // by flowId
        {
            const flowIdToSearch = flowAAA.id;
            const res = await kestraClient().testSuitesApi.searchTestSuites(
                page, size, includeChildNamespaces, MAIN_TENANT, {sort:sort, flowId:flowIdToSearch}
            );
            const gotIds = (res?.results ?? []).map((r) => r.id).sort();
            expect(gotIds).toEqual([ts1.id, ts2.id].sort());
        }

        // by namespace
        {
            const namespaceToSearch = namespaceYYY;
            const res = await kestraClient().testSuitesApi.searchTestSuites(
                page, size, includeChildNamespaces, MAIN_TENANT, {sort:sort, namespace:namespaceToSearch}
            );
            const gotIds = (res?.results ?? []).map((r) => r.id).sort();
            expect(gotIds).toEqual([ts4.id].sort());
        }
    });

    it('runTestSuiteTest', async () => {
        const namespace = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, namespace);

        const ts = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId)
        );

        const run = await kestraClient().testSuitesApi.runTestSuite(namespace, ts.id, MAIN_TENANT, null);

        expect(run.testSuiteId).toBe(ts.id);
        expect(run.state).toBe('SUCCESS');
        expect(run.endDate).toBeTruthy();
    });

    it('runTestSuiteTest_failed', async () => {
        const namespace = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, namespace);

        const ts = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(FAILING_SIMPLE_TEST_SUITE, randomId(), namespace, flowId)
        );

        const run = await kestraClient().testSuitesApi.runTestSuite(namespace, ts.id, MAIN_TENANT, null);

        expect(run.testSuiteId).toBe(ts.id);
        expect(run.state).toBe('FAILED');
        expect(run.results ?? []).toHaveLength(1);

        const first = (run.results ?? [])[0];
        expect(first?.testId).toBe('test_case_1');
        const a = (first?.assertionResults ?? [])[0];
        expect(a?.expected).toBe('Hi there');
        expect(a?.actual).toBe('another value');
        expect(a?.operator).toBe('equalTo');
        expect(a?.isSuccess).toBe(false);
    });

    it('runTestSuiteByQueryTest', async () => {
        const namespaceXXX = `namespacexxx_${randomId()}`;
        const namespaceYYY = `namespaceyyy_${randomId()}`;

        const flowAAA = await createSimpleFlowFromBody(LOG_FLOW(`flowaaa_${randomId()}`, namespaceXXX));
        const flowBBB = await createSimpleFlowFromBody(LOG_FLOW(`flowbbb_${randomId()}`, namespaceXXX));
        const flowCCC = await createSimpleFlowFromBody(LOG_FLOW(`flowccc_${randomId()}`, namespaceYYY));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite111_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite222_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite333_${randomId()}`, namespaceXXX, flowBBB.id)
        );
        const ts4 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite444_${randomId()}`, namespaceYYY, flowCCC.id)
        );

        // by flowId
        {
            const res = await kestraClient().testSuitesApi.runTestSuitesByQuery(
                MAIN_TENANT, { flowId: flowAAA.id }
            );
            const gotIds = (res?.results ?? []).map((r) => r.testSuiteId).sort();
            expect(gotIds).toEqual([ts1.id, ts2.id].sort());
        }

        // by namespace
        {
            const res = await kestraClient().testSuitesApi.runTestSuitesByQuery(
                MAIN_TENANT, { namespace: namespaceYYY }
            );
            const gotIds = (res?.results ?? []).map((r) => r.testSuiteId).sort();
            expect(gotIds).toEqual([ts4.id].sort());
        }
    });

    it('searchTestSuitesResultsTest', async () => {
        const namespaceXXX = `namespacexxx_${randomId()}`;
        const namespaceYYY = `namespaceyyy_${randomId()}`;

        const flowAAA = await createSimpleFlowFromBody(LOG_FLOW(`flowaaa_${randomId()}`, namespaceXXX));
        const flowBBB = await createSimpleFlowFromBody(LOG_FLOW(`flowbbb_${randomId()}`, namespaceXXX));
        const flowCCC = await createSimpleFlowFromBody(LOG_FLOW(`flowccc_${randomId()}`, namespaceYYY));

        const ts1 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite111_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        const ts2 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite222_${randomId()}`, namespaceXXX, flowAAA.id)
        );
        const ts3 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite333_${randomId()}`, namespaceXXX, flowBBB.id)
        );
        const ts4 = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, `testsuite444_${randomId()}`, namespaceYYY, flowCCC.id)
        );

        // run all of them
        await kestraClient().testSuitesApi.runTestSuite(ts1.namespace, ts1.id, MAIN_TENANT, {});
        await kestraClient().testSuitesApi.runTestSuite(ts1.namespace, ts1.id, MAIN_TENANT, {});
        await kestraClient().testSuitesApi.runTestSuite(ts2.namespace, ts2.id, MAIN_TENANT, {});
        await kestraClient().testSuitesApi.runTestSuite(ts3.namespace, ts3.id, MAIN_TENANT, {});
        await kestraClient().testSuitesApi.runTestSuite(ts4.namespace, ts4.id, MAIN_TENANT, {});

        const page = 1;
        const size = 1000;
        const sort = null;

        // by testSuiteId
        {
            const res = await kestraClient().testSuitesApi.searchTestSuitesResults(
                page, size, MAIN_TENANT, {sort:sort, testSuiteId:ts1.id}
            );
            const results = res?.results ?? [];
            expect(results.every((r) => r.testSuiteId === ts1.id)).toBe(true);
            expect(results).toHaveLength(2);
        }

        // by flowId
        {
            const res = await kestraClient().testSuitesApi.searchTestSuitesResults(
                page, size, MAIN_TENANT, {sort:sort, flowId:flowAAA.id}
            );
            const results = res?.results ?? [];
            expect(results.every((r) => r.flowId === flowAAA.id)).toBe(true);
            const ids = results.map((r) => r.testSuiteId).sort();
            expect(ids).toEqual([ts1.id, ts1.id, ts2.id].sort());
        }

        // by namespace
        {
            const res = await kestraClient().testSuitesApi.searchTestSuitesResults(
                page, size, MAIN_TENANT, {sort:sort, namespace:namespaceYYY}
            );
            const results = res?.results ?? [];
            expect(results.every((r) => r.namespace === namespaceYYY)).toBe(true);
            const ids = results.map((r) => r.testSuiteId).sort();
            expect(ids).toEqual([ts4.id].sort());
        }
    });

    it('getTestResult', async () => {
        const namespace = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, namespace);

        const ts = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId)
        );

        const run = await kestraClient().testSuitesApi.runTestSuite(namespace, ts.id, MAIN_TENANT, null);

        const fetched = await kestraClient().testSuitesApi.testResult(run.id, MAIN_TENANT);
        expect(fetched.id).toBe(run.id);
    });

    it('getTestsLastResultTest', async () => {
        const namespace = randomId();
        const flowId = randomId();
        await createSimpleFlow(flowId, namespace);

        const ts = await kestraClient().testSuitesApi.createTestSuite(
            MAIN_TENANT, getTestSuiteYaml(SIMPLE_TEST_SUITE, randomId(), namespace, flowId)
        );

        const r1 = await kestraClient().testSuitesApi.runTestSuite(namespace, ts.id, MAIN_TENANT, null);
        const r2 = await kestraClient().testSuitesApi.runTestSuite(namespace, ts.id, MAIN_TENANT, null);

        const payload = {
            testSuiteIds: [{ id: ts.id, namespace: ts.namespace }],
        };
        const fetched = await kestraClient().testSuitesApi.testsLastResult(MAIN_TENANT, payload);

        const got = (fetched?.results ?? [])[0];
        expect(got?.id).toBe(r2.id);
        // ensure the latest is returned (not r1)
        expect(got?.id).not.toBe(r1.id);
    });
});
