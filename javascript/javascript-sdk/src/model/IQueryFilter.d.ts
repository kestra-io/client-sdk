import { QueryFilterOpStatic } from './QueryFilterOp.js'

export interface IQueryFilter {
    property: string;
    operation: typeof QueryFilterOpStatic[keyof typeof QueryFilterOpStatic];
    value: any;
}