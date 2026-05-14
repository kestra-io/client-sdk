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
        try {
            const result = await kestraClient.Ai.generateFlow(prompt);
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 422].includes(status)) return;
            throw err;
        }
    });

    it('generateApp: generate an app from a prompt', async () => {
        try {
            const result = await kestraClient.Ai.generateApp({
                conversationId: randomId(),
                userPrompt: 'Create a simple app',
            });
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 422].includes(status)) return;
            throw err;
        }
    });

    it('generateDashboard: generate a dashboard from a prompt', async () => {
        const prompt: AiControllerDashboardGenerationPrompt = {
            conversationId: randomId(),
            userPrompt: 'Create a dashboard showing execution status',
        };
        try {
            const result = await kestraClient.Ai.generateDashboard(prompt);
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 422].includes(status)) return;
            throw err;
        }
    });

    it('generateTestSuite: generate a test suite for a flow', async () => {
        const prompt: TestSuiteGenerationPrompt = {
            conversationId: randomId(),
            userPrompt: 'Generate tests for a simple log flow',
        };
        try {
            const result = await kestraClient.Ai.generateTestSuite(prompt);
            expect(result).toBeDefined();
        } catch (err: any) {
            const status = err?.response?.status ?? err?.status;
            if ([403, 404, 422].includes(status)) return;
            throw err;
        }
    });
});
