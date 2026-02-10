import { describe, it, expect } from 'vitest';

// Importing the internal ApiClient directly keeps this test fast and purely unit-level.
import ApiClient from '../javascript-sdk/src/ApiClient.js';

describe('ApiClient.buildCollectionParam (QueryFilter helpers)', () => {
  it('should expand map/object value for any field (not only labels)', () => {
    const client = new ApiClient();

    const filters = [
      {
        field: 'ID',
        operation: 'EQUALS',
        value: {
          a: 'b',
          c: 'd'
        }
      }
    ];

    const built = client.buildCollectionParam(filters, 'csv');

    expect(built).toHaveProperty('__kvpairs');
    expect(built.__kvpairs).toMatchObject({
      'filters[id][EQUALS][a]': 'b',
      'filters[id][EQUALS][c]': 'd'
    });
  });

  it('should transform QUERY field to q', () => {
    const client = new ApiClient();

    const filters = [
      {
        field: 'QUERY',
        operation: 'EQUALS',
        value: 'hello'
      }
    ];

    const built = client.buildCollectionParam(filters, 'csv');

    expect(built.__kvpairs).toEqual({
      'filters[q][EQUALS]': 'hello'
    });
  });

  it('should camelCase field with underscore (ASSET_ID -> assetId)', () => {
    const client = new ApiClient();

    const filters = [
      {
        field: 'ASSET_ID',
        operation: 'EQUALS',
        value: 'asset'
      }
    ];

    const built = client.buildCollectionParam(filters, 'csv');

    expect(built.__kvpairs).toEqual({
      'filters[assetId][EQUALS]': 'asset'
    });
  });
});

