import { describe, it, expect } from 'vitest';
import { parse as parseYaml } from 'yaml';
import { flowToYaml } from '@kestra-io/kestra-sdk/flows';
import * as Flows from '@kestra-io/kestra-sdk/flows';
import * as Root from '@kestra-io/kestra-sdk';
import { readFileSync } from 'fs';
import { resolve } from 'path';
import All, * as AllNamed from '@kestra-io/kestra-sdk/all';

// Pure serialization tests for the object -> YAML layer used by
// createFlowFromObject / updateFlowFromObject. No live Kestra server is needed.

function buildFlow(): Record<string, unknown> {
    return {
        id: 'my-flow',
        namespace: 'company.team',
        disabled: false,
        draft: false,
        deleted: false,
        labels: [{ key: 'env', value: 'prod' }],
        tasks: [
            {
                id: 'log',
                type: 'io.kestra.plugin.core.log.Log',
                // plugin-specific property
                message: 'Hello {{ inputs.name }}',
            },
            {
                id: 'seq',
                type: 'io.kestra.plugin.core.flow.Sequential',
                // nested tasks with plugin-specific properties
                tasks: [
                    {
                        id: 'shell',
                        type: 'io.kestra.plugin.scripts.shell.Commands',
                        commands: ['echo one', 'echo two'],
                        script: 'echo start\necho done',
                    },
                ],
            },
        ],
    };
}

describe('flowToYaml', () => {
    it('keeps plugin-specific task properties in the emitted YAML', () => {
        const yaml = flowToYaml(buildFlow());

        expect(yaml).toContain('message:');
        expect(yaml).toContain('io.kestra.plugin.core.log.Log');
        expect(yaml).toContain('commands:');
        // Kestra expressions must not be mangled.
        expect(yaml).toContain('{{ inputs.name }}');
    });

    it('round-trips real values, including nested tasks and multi-line strings', () => {
        const parsed = parseYaml(flowToYaml(buildFlow()));

        expect(parsed.id).toBe('my-flow');
        expect(parsed.namespace).toBe('company.team');

        const log = parsed.tasks[0];
        expect(log.id).toBe('log');
        expect(log.type).toBe('io.kestra.plugin.core.log.Log');
        expect(log.message).toBe('Hello {{ inputs.name }}');

        const seq = parsed.tasks[1];
        expect(seq.type).toBe('io.kestra.plugin.core.flow.Sequential');
        const shell = seq.tasks[0];
        expect(shell.id).toBe('shell');
        expect(shell.commands).toEqual(['echo one', 'echo two']);
        // Multi-line string round-trips intact.
        expect(shell.script).toBe('echo start\necho done');

        expect(parsed.labels).toEqual([{ key: 'env', value: 'prod' }]);
    });

    it('strips server-managed fields (draft/deleted/revision/...) from flow source', () => {
        const yaml = flowToYaml({
            id: 'my-flow',
            namespace: 'company.team',
            disabled: false,
            draft: false,
            deleted: false,
            revision: 7,
            tenantId: 'main',
            source: 'id: my-flow',
            updated: '2026-01-01T00:00:00Z',
            tasks: [{ id: 'log', type: 'io.kestra.plugin.core.log.Log', message: 'hi' }],
        });
        expect(yaml).not.toContain('draft:');
        expect(yaml).not.toContain('deleted:');
        expect(yaml).not.toContain('revision:');

        const parsed = parseYaml(yaml);
        for (const field of ['draft', 'deleted', 'revision', 'tenantId', 'source', 'updated']) {
            expect(parsed[field]).toBeUndefined();
        }
        // Real content is preserved.
        expect(parsed.id).toBe('my-flow');
        expect(parsed.tasks[0].message).toBe('hi');
    });

    it('omits null fields rather than emitting null', () => {
        const yaml = flowToYaml({
            id: 'f',
            namespace: 'company.team',
            disabled: false,
            draft: false,
            deleted: false,
            description: null,
            tasks: [{ id: 'log', type: 'io.kestra.plugin.core.log.Log', message: 'hi' }],
        });
        expect(yaml).not.toContain('description:');
        expect(yaml).not.toContain('null');
    });

    it('throws on null or undefined input', () => {
        expect(() => flowToYaml(null as never)).toThrow();
        expect(() => flowToYaml(undefined as never)).toThrow();
    });

    it('keeps non-ASCII characters verbatim', () => {
        const yaml = flowToYaml({
            id: 'f',
            namespace: 'company.team',
            disabled: false,
            draft: false,
            deleted: false,
            tasks: [{ id: 'log', type: 'io.kestra.plugin.core.log.Log', message: 'grüß gott' }],
        });
        expect(yaml).toContain('grüß gott');
        expect(yaml).not.toContain('\\u');
        expect(parseYaml(yaml).tasks[0].message).toBe('grüß gott');
    });
});

describe('flow-from-object entry points', () => {
    it('lives on the /flows subpath next to the generated Flows operations', () => {
        expect(typeof Flows.createFlowFromObject).toBe('function');
        expect(typeof Flows.updateFlowFromObject).toBe('function');
        expect(typeof Flows.flowToYaml).toBe('function');
        expect(typeof Flows.createFlow).toBe('function');
        expect(Flows.flowToYaml({ id: 'f', namespace: 'company.team', tasks: [] })).toBe('id: f\nnamespace: company.team\ntasks: []\n');
    });

    it('is not exported by the root entry (types + client setup only)', () => {
        // The root must not pull the yaml package / Flows operations into bundles.
        expect(Object.keys(Root).filter(k => /FromObject|flowToYaml/.test(k))).toEqual([]);
        expect(typeof Root.configureClient).toBe('function');
    });

    it('exposes every helper on /all without colliding with a generated name', () => {
        // `/all` spreads the generated and flow-from-object namespaces into its
        // default export and `export *`s both: a shared name would silently let
        // flow-from-object win in the default export while the named export is
        // dropped (ESM) or resolves to the generated one (vitest's transform),
        // so the default and named exports would disagree on that name.
        expect(Object.keys(All).sort()).toEqual(Object.keys(AllNamed).filter(k => k !== 'default').sort());
        for (const [k, v] of Object.entries(All)) {
            expect((AllNamed as Record<string, unknown>)[k], k).toBe(v);
        }
        for (const k of ['createFlowFromObject', 'updateFlowFromObject', 'flowToYaml'] as const) {
            expect(typeof AllNamed[k], k).toBe('function');
            expect(AllNamed[k], k).toBe(Flows[k]);
            expect(All[k], k).toBe(Flows[k]);
        }
    });
});

// Shared contract asserted by all four SDKs (test-utils/yaml-ambiguous-strings.json):
// strings a YAML 1.1 / Jackson reader (Kestra's server) would re-type to a
// boolean, null, number or timestamp must be emitted quoted; ordinary strings
// stay plain.
const AMBIGUOUS: { mustQuote: string[]; staysPlain: string[] } = JSON.parse(
    readFileSync(resolve(import.meta.dirname, '../../test-utils/yaml-ambiguous-strings.json'), 'utf8'),
);

describe('flowToYaml ambiguous strings', () => {
    // An empty key is left out: emitters write it in their own form, which
    // still reads back as "".
    const keyed = Object.fromEntries(AMBIGUOUS.mustQuote.filter(s => s !== '').map(s => [s, 'k']));
    const yaml = flowToYaml({
        id: 'tricky',
        namespace: 'company.team',
        labels: { approved: 'yes' },
        tasks: [{
            id: 'out',
            type: 'io.kestra.plugin.core.output.OutputValues',
            values: AMBIGUOUS.mustQuote,
            keyed,
            plain: AMBIGUOUS.staysPlain,
        }],
    });

    it('emits every ambiguous string as a quoted scalar, as a value and as a key', () => {
        for (const s of AMBIGUOUS.mustQuote) {
            expect(yaml, `value ${JSON.stringify(s)}`).toContain(`\n      - "${s}"\n`);
        }
        for (const s of Object.keys(keyed)) {
            expect(yaml, `key ${JSON.stringify(s)}`).toContain(`\n      "${s}": k\n`);
        }
        for (const s of AMBIGUOUS.staysPlain) {
            expect(yaml, `value ${JSON.stringify(s)}`).toContain(`\n      - ${s}\n`);
        }
        expect(yaml).toContain('approved: "yes"');
    });

    it('re-parses to the exact original strings under YAML 1.2 and YAML 1.1', () => {
        for (const version of ['1.2', '1.1'] as const) {
            const parsed = parseYaml(yaml, { version });
            expect(parsed.tasks[0].values, `YAML ${version}`).toEqual(AMBIGUOUS.mustQuote);
            expect(parsed.tasks[0].keyed, `YAML ${version}`).toEqual(keyed);
            expect(parsed.tasks[0].plain, `YAML ${version}`).toEqual(AMBIGUOUS.staysPlain);
            expect(parsed.labels.approved).toBe('yes');
        }
    });

    it('never folds long lines', () => {
        const description = Array(5).fill('a very long single line description').join(' ');
        const expr = `{{ ${'x'.repeat(120)} }}`;
        const out = flowToYaml({
            id: 'long',
            namespace: 'company.team',
            description,
            tasks: [{ id: 't', type: 'io.kestra.plugin.core.log.Log', message: expr }],
        });
        expect(out).toContain(`description: ${description}\n`);
        expect(out).toContain(`    message: "${expr}"\n`);
        const parsed = parseYaml(out);
        expect(parsed.description).toBe(description);
        expect(parsed.tasks[0].message).toBe(expr);
    });

    it('keeps ordinary strings plain, expressions quoted and multi-line as literal blocks', () => {
        const out = flowToYaml({
            id: 'plain',
            namespace: 'company.team',
            tasks: [{ id: 't', type: 'io.kestra.plugin.core.log.Log', message: 'hello world', expr: '{{ inputs.x }}', script: 'a\nb' }],
        });
        expect(out).toContain('    message: hello world\n');
        expect(out).toContain('    expr: "{{ inputs.x }}"\n');
        expect(out).toContain('    script: |-\n      a\n      b\n');
    });
});
