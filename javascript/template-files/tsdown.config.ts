import { defineConfig } from 'tsdown'

export default defineConfig({
  exports: true,
  entry: './src/KestraClient.js',
  dts: false
})