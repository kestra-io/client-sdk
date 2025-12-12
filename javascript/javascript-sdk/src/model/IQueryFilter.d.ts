import { QueryFilterOpStatic } from './QueryFilterOp.js'

/**
 * Pass this model to represent filter queries
 */
export interface IQueryFilter {
    // TODO: help users select the right property on each table by restricting this by table
    property: string;
    operation: typeof QueryFilterOpStatic[keyof typeof QueryFilterOpStatic];
    value: any;
}