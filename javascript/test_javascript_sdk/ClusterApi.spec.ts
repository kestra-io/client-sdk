import { describe, it, expect } from 'vitest';
import { kestraClient } from './CommonTestSetup.js';

const sleep = (ms: number): Promise<void> => new Promise((r) => setTimeout(r, ms));

// The maintenance flag may flip a moment after enter/exit returns, so poll.
async function waitForMaintenance(expected: boolean): Promise<boolean> {
    const deadline = Date.now() + 5_000;
    while (Date.now() < deadline) {
        const { maintenance } = await kestraClient.Cluster.maintenanceStatus();
        if (maintenance === expected) return true;
        await sleep(250);
    }
    return false;
}

describe.sequential('ClusterApi', () => {
    it('maintenanceStatus: reports not-in-maintenance before entering it', async () => {
        const result = await kestraClient.Cluster.maintenanceStatus();
        // This test runs first in the sequential block, before enterMaintenance.
        expect(result.maintenance).toBe(false);
    });

    it('enterMaintenance/exitMaintenance: toggle the maintenance flag', async () => {
        try {
            await kestraClient.Cluster.enterMaintenance();
            // Entering maintenance actually flips the reported status to true.
            expect(await waitForMaintenance(true)).toBe(true);
        } finally {
            await kestraClient.Cluster.exitMaintenance();
            // Exiting restores it to false.
            expect(await waitForMaintenance(false)).toBe(true);
        }
    });
});
