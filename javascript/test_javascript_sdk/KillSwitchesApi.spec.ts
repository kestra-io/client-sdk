import { describe, it, expect } from 'vitest';
import { randomId } from './_utils.js';
import * as KillSwitches from '@kestra-io/kestra-sdk/kill-switches';
import type { KillSwitch, EvaluationType } from '@kestra-io/kestra-sdk';

function makeKillSwitch(): KillSwitch {
    const tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    return {
        name: `test-ks-${randomId()}`,
        startDate: tomorrow.toISOString(),
        evaluationType: 'KILL' as EvaluationType,
        enabled: false,
    };
}

describe('KillSwitchesApi', () => {
    it('searchKillSwitches: returns a list of kill switches', async () => {
        const result = await KillSwitches.searchKillSwitches();
        expect(result).toBeDefined();
        expect(Array.isArray(result)).toBe(true);
    });

    it('createKillSwitch: creates a new kill switch', async () => {
        const ks = makeKillSwitch();
        const result = await KillSwitches.createKillSwitch(ks);
        expect(result).toBeDefined();
        expect((result as any).name).toBe(ks.name);
    });

    it('updateKillSwitch: updates an existing kill switch', async () => {
        const created = await KillSwitches.createKillSwitch(makeKillSwitch());
        const id = (created as any).id;
        const updated: KillSwitch = {
            ...created as KillSwitch,
            name: `updated-ks-${randomId()}`,
            evaluationType: 'CANCEL' as EvaluationType,
        };

        const result = await KillSwitches.updateKillSwitch({ id, ...updated });
        expect(result).toBeDefined();
    });

    it('deleteKillSwitch: deletes a kill switch', async () => {
        const created = await KillSwitches.createKillSwitch(makeKillSwitch());
        const id = (created as any).id;

        await KillSwitches.deleteKillSwitch({ id });
    });
});
