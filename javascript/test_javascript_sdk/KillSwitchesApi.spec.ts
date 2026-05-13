import { describe, it, expect } from 'vitest';
import { kestraClient, randomId } from './CommonTestSetup.js';
import type { KillSwitch, EvaluationType } from '@kestra-io/kestra-sdk';

function makeKillSwitch(): KillSwitch {
    return {
        name: `test-ks-${randomId()}`,
        startDate: new Date().toISOString(),
        evaluationType: 'KILL' as EvaluationType,
    };
}

describe('KillSwitchesApi', () => {
    it('searchKillSwitches: returns a list of kill switches', async () => {
        const result = await kestraClient.KillSwitches.searchKillSwitches();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createKillSwitch: creates a new kill switch', async () => {
        const ks = makeKillSwitch();
        const result = await kestraClient.KillSwitches.createKillSwitch(ks);
        expect(result).toBeDefined();
        expect((result as any).name).toBe(ks.name);
    });

    it('updateKillSwitch: updates an existing kill switch', async () => {
        const created = await kestraClient.KillSwitches.createKillSwitch(makeKillSwitch());
        const id = (created as any).id;
        const updated: KillSwitch = {
            ...created as KillSwitch,
            name: `updated-ks-${randomId()}`,
            evaluationType: 'CANCEL' as EvaluationType,
        };

        const result = await kestraClient.KillSwitches.updateKillSwitch({ id, ...updated });
        expect(result).toBeDefined();
    });

    it('deleteKillSwitch: deletes a kill switch', async () => {
        const created = await kestraClient.KillSwitches.createKillSwitch(makeKillSwitch());
        const id = (created as any).id;

        await kestraClient.KillSwitches.deleteKillSwitch({ id });
    });
});
