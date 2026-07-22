import { describe, it, expect } from 'vitest';
import * as Expressions from '@kestra-io/kestra-sdk/expressions';

describe('ExpressionsApi', () => {
    it('renderExpressions: renders Pebble expressions', async () => {
        const result = await Expressions.renderExpressions({
            expressions: ['{{ 1 + 2 }}'],
        });
        expect(result.rendered?.['{{ 1 + 2 }}']).toBe('3');
    });
});
