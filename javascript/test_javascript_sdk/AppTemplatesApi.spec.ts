// AppTemplatesApi.spec.ts — covers the App Templates module (/app-templates).
//
// An app template pairs a flow and an app source, both templated with
// `<< arg.<id> >>` placeholders that resolve against the template's
// `arguments`. A well-formed template declares no `namespace` (it is chosen
// when the template is rendered) and its app declares no `flowId` (the app
// runs the template's own flow): render reports either as a `problem`.
import { describe, it, expect } from 'vitest';
import { randomId, expectStatus } from './_utils.js';
import * as AppTemplates from '@kestra-io/kestra-sdk/app-templates';

const FLOW_SOURCE = `id: << arg.flowId >>
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: "Hello << arg.greeting >>"`;

const APP_SOURCE = `id: << arg.flowId >>_app
type: io.kestra.plugin.ee.apps.Execution
displayName: SDK app template
layout:
  - on: OPEN
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "# Hello"`;

function templateRequest(title: string) {
    return {
        title,
        description: 'created by AppTemplatesApi.spec.ts',
        tags: ['sdk-test'],
        arguments: [
            { id: 'flowId', type: 'STRING', defaults: 'default_flow' },
            { id: 'greeting', type: 'STRING', required: false },
        ] as any,
        flow: FLOW_SOURCE,
        app: APP_SOURCE,
    };
}

// The spec types each argument value as an object (`additionalProperties:
// {type: object}`), but the server takes the argument's own type — a plain
// string for STRING arguments — so the values are cast.
function argumentValues(values: Record<string, unknown>) {
    return values as Record<string, { [key: string]: unknown }>;
}

async function createTemplate() {
    const title = `tpl_${randomId()}`;
    const created = await AppTemplates.createAppTemplate(templateRequest(title));
    return { id: created.id ?? '', title, created };
}

describe('AppTemplatesApi', () => {
    it('createAppTemplate: creates an app template', async () => {
        const { id, title, created } = await createTemplate();

        expect(id).not.toBe('');
        expect(created.title).toBe(title);
        expect(created.tags).toEqual(['sdk-test']);
        expect(created.flow).toBe(FLOW_SOURCE);
        expect(created.arguments?.map((a: any) => a.id)).toEqual(['flowId', 'greeting']);
    });

    it('appTemplate: retrieves a created app template', async () => {
        const { id, title } = await createTemplate();

        const result = await AppTemplates.appTemplate({ id });
        expect(result.id).toBe(id);
        expect(result.title).toBe(title);
        expect(result.app).toBe(APP_SOURCE);
    });

    it('updateAppTemplate: replaces an app template', async () => {
        const { id } = await createTemplate();
        const renamed = `tpl_${randomId()}`;

        const result = await AppTemplates.updateAppTemplate({ id, ...templateRequest(renamed) });
        expect(result.id).toBe(id);
        expect(result.title).toBe(renamed);

        const fetched = await AppTemplates.appTemplate({ id });
        expect(fetched.title).toBe(renamed);
    });

    it('deleteAppTemplate: deletes an app template', async () => {
        const { id } = await createTemplate();

        await AppTemplates.deleteAppTemplate({ id });

        await expectStatus(AppTemplates.appTemplate({ id }), 404);
    });

    it('searchAppTemplates: returns created templates in a paged result', async () => {
        const { id } = await createTemplate();

        const result = await AppTemplates.searchAppTemplates({ page: 1, size: 1000 });
        expect(result.total).toBeGreaterThanOrEqual(1);
        expect(result.results?.map((t) => t.id)).toContain(id);
    });

    it('renderAppTemplate: renders the flow and app into the given namespace', async () => {
        const { id } = await createTemplate();
        const namespace = `app.templates.${randomId()}`;
        const flowId = `flow_${randomId()}`;

        const result = await AppTemplates.renderAppTemplate({
            id,
            namespace,
            argumentValues: argumentValues({ flowId, greeting: 'sdk' }),
        });

        expect(result.flow?.id).toBe(flowId);
        expect(result.flow?.problems).toEqual([]);
        expect(result.flow?.source).toContain(`namespace: ${namespace}`);
        expect(result.flow?.source).toContain('message: "Hello sdk"');

        expect(result.app?.id).toBe(`${flowId}_app`);
        expect(result.app?.problems).toEqual([]);
        expect(result.app?.source).toContain(`namespace: ${namespace}`);
        expect(result.app?.source).toContain(`flowId: ${flowId}`);
    });

    it('validateAppTemplateArguments: resolves provided values and falls back to defaults', async () => {
        const { id } = await createTemplate();

        const provided = await AppTemplates.validateAppTemplateArguments({
            id,
            argumentValues: argumentValues({ flowId: 'my_flow' }),
        });
        const flowIdArg = provided.inputs?.find((i: any) => i.input?.id === 'flowId');
        expect(flowIdArg?.value).toBe('my_flow');
        expect(flowIdArg?.isDefault).toBe(false);
        expect(flowIdArg?.errors).toEqual([]);

        const defaulted = await AppTemplates.validateAppTemplateArguments({ id, argumentValues: {} });
        const defaultedArg = defaulted.inputs?.find((i: any) => i.input?.id === 'flowId');
        expect(defaultedArg?.value).toBe('default_flow');
        expect(defaultedArg?.isDefault).toBe(true);
    });
});
