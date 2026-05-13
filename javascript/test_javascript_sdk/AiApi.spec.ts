import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { AiControllerFlowGenerationPrompt, AiControllerDashboardGenerationPrompt, TestSuiteGenerationPrompt } from '@kestra-io/kestra-sdk';

describe('AiApi', () => {
    it('providers: list AI providers', async () => {
        const result = await kestraClient.Ai.providers();
        expect(result).toBeDefined();
    });

    it('generateFlow: generate a flow from a prompt', async () => {
        const prompt: AiControllerFlowGenerationPrompt = {
            conversationId: randomId(),
            userPrompt: 'Create a simple flow that logs hello world',
        };
        const result = await kestraClient.Ai.generateFlow(prompt);
        expect(result).toBeDefined();
    });

    it('generateApp: generate an app from a prompt', async () => {
        const result = await kestraClient.Ai.generateApp({
            conversationId: randomId(),
            userPrompt: 'Create a simple app',
        });
        expect(result).toBeDefined();
    });

    it('generateDashboard: generate a dashboard from a prompt', async () => {
        const prompt: AiControllerDashboardGenerationPrompt = {
            conversationId: randomId(),
            userPrompt: 'Create a dashboard showing execution status',
        };
        const result = await kestraClient.Ai.generateDashboard(prompt);
        expect(result).toBeDefined();
    });

    it('generateTestSuite: generate a test suite for a flow', async () => {
        const prompt: TestSuiteGenerationPrompt = {
            conversationId: randomId(),
            userPrompt: 'Generate tests for a simple log flow',
        };
        const result = await kestraClient.Ai.generateTestSuite(prompt);
        expect(result).toBeDefined();
    });
});
