import { describe, it, expect } from 'vitest';
import Metric from '../javascript-sdk/src/model/Metric.js';

describe('Metric model', () => {
    it('parses worker pending metric with numeric value', () => {
        const metric = Metric.constructFromObject({
            name: 'worker.job.pending',
            type: 'WORKER',
            value: 3
        });

        expect(metric.name).toBe('worker.job.pending');
        expect(metric.type).toBe('WORKER');
        expect(metric.value).toBe(3);
        expect(typeof metric.value).toBe('number');
    });

    it('does not preserve object values as metric value', () => {
        const metric = Metric.constructFromObject({
            name: 'worker.job.pending',
            type: 'WORKER',
            value: { pending: 3 }
        });

        expect(Number.isNaN(metric.value)).toBe(true);
    });
});

