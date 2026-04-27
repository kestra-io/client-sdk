import { defineConfig } from 'tsdown'

export default defineConfig({
    exports: true,
    entry: [
        './src/index.js',
        './src/KestraClient.js',
        './src/model/*.js'
    ],
    dts: false,
    sourcemap: true
})