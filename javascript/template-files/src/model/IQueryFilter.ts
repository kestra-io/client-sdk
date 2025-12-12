import { QueryFilterOpStatic } from './QueryFilterOp.js'

/**
 * Pass this model to represent filter queries
 */
export interface IQueryFilter {
    // TODO: help users select the right field on each table by restricting this by table
    field: string;
    operation: typeof QueryFilterOpStatic[keyof typeof QueryFilterOpStatic];
    value: any;
}