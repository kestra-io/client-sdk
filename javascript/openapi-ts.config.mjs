import * as path from 'path';
const __dirname = new URL('.', import.meta.url).pathname;

export default {
  input: path.resolve(__dirname, "../kestra-ee.yml"),
  output: {
    path: path.resolve(__dirname, "./javascript-sdk/src")
  },

  plugins: [
    {
        name: "@hey-api/client-fetch",
        asClass: true,
    },
    {
        name: "@hey-api/sdk",
        asClass: true,
        paramsStructure: "flat",
    },
  ],
};