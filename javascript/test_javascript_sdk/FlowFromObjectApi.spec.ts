import { describe, it, expect } from 'vitest';
import { parse as parseYaml } from 'yaml';
import { flowToYaml } from '@kestra-io/kestra-sdk';

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
