import { defineConfig } from 'tsdown'

export default defineConfig({
    exports: true,
    entry: './src/**/*.js',
    dts: true
})