import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as Ai from '@kestra-io/kestra-sdk/ai';

const providerId = 'gemini';

// If we get a Gemini Key in CI we could start using these tests
describe.skip('AiApi', () => {
    it('providers: list AI providers', async () => {
        const result = await Ai.providers();
        expect(result[0]).toMatchObject(
            {
                id: providerId,
                isDefault: true,
            },
        );
    });

    it('generateFlow: generate a flow from a prompt', async () => {
        const result = await Ai.generateFlow({
            conversationId: randomId(),
            userPrompt: 'Create a simple flow that logs hello world',
            namespace: 'company.team',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    });

    it('generateApp: generate an app from a prompt', async () => {
        const result = await Ai.generateApp({
            conversationId: randomId(),
            userPrompt: 'Create a simple app displaying a single button',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    }, 30_000);

    it('generateDashboard: generate a dashboard from a prompt', async () => {
        const result = await Ai.generateDashboard({
            conversationId: randomId(),
            userPrompt: 'Create a kestra dashboard with a simple markdown block',
            yaml: "id: test-dashboard",
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    }, 30_000);

    it('generateTestSuite: generate a test suite for a flow', async () => {
        const result = await Ai.generateTestSuite({
            conversationId: randomId(),
            userPrompt: 'Generate tests for a simple log flow',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    }, 30_000);
});