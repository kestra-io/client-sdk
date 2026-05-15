import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe('ClusterApi', () => {
    it('enterMaintenance: enters maintenance mode', async () => {
        const result = await kestraClient.Cluster.enterMaintenance();
        expect(result).toBeDefined();
    });

    it('exitMaintenance: exits maintenance mode', async () => {
        const result = await kestraClient.Cluster.exitMaintenance();
        expect(result).toBeDefined();
    });
});
