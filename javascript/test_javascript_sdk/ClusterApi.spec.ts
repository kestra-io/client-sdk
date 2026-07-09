import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

describe.sequential('ClusterApi', () => {
    it('maintenanceStatus: reports not-in-maintenance before entering it', async () => {
        const result = await kestraClient.Cluster.maintenanceStatus();
        // This test runs first in the sequential block, before enterMaintenance.
        expect(result.maintenance).toBe(false);
    });

    it('enterMaintenance: enters maintenance mode and always exits it during cleanup', async () => {
        const enterResult = await kestraClient.Cluster.enterMaintenance();
        expect(enterResult).toBeDefined();

        try {
            // Maintenance mode is enabled for this test only.
        } finally {
            const exitResult = await kestraClient.Cluster.exitMaintenance();
            expect(exitResult).toBeDefined();
        }
    });
});
