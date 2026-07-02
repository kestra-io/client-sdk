// Compile-time guard: the generated `Type` union must include 'FORM'.
// Not a `.spec.ts` — it has no runtime behavior and isn't picked up by vitest.
// It's checked by `npm run check:types` (`tsc --noEmit`), which has no live-server
// dependency, unlike the vitest suite (see globalSetup.ts).
import type { Type } from '@kestra-io/kestra-sdk';

const formType: Type = 'FORM';
void formType;
