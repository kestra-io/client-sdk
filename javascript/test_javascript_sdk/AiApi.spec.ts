import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';

describe('AiApi', () => {
    it('providers: list AI providers', async () => {
        const result = await kestraClient.Ai.providers();
        expect(result).toMatchInlineSnapshot(`
          [
            {
              "displayName": "Free tier",
              "id": "api",
              "isDefault": true,
            },
          ]
        `);
    });

    it('generateFlow: generate a flow from a prompt', async () => {
        const result = await kestraClient.Ai.generateFlow({
            providerId: 'api',
            conversationId: randomId(),
            userPrompt: 'Create a simple flow that logs hello world',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    });

    it('generateApp: generate an app from a prompt', async () => {

        const result = await kestraClient.Ai.generateApp({
            conversationId: randomId(),
            userPrompt: 'Create a simple app',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    });

    it('generateDashboard: generate a dashboard from a prompt', async () => {
        const result = await kestraClient.Ai.generateDashboard({
            conversationId: randomId(),
            userPrompt: 'Create a dashboard showing execution status',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    });

    it('generateTestSuite: generate a test suite for a flow', async () => {
        const result = await kestraClient.Ai.generateTestSuite({
            conversationId: randomId(),
            userPrompt: 'Generate tests for a simple log flow',
        });
        expect(result).toBeDefined();
        expect(typeof result).toBe('string');
    });
});