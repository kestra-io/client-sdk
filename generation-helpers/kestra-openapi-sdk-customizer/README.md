# kestra-openapi-sdk-customizer

this is a cli to transform our kestra-ee.yml to better fit our SDK needs:
- remove all deprecated parameters and operations (example: old query filter params)
- exclude a list of operationId we don't want to handle yet

## run it
```
npm run build && npm start <your-kestra-openapi-spec.yml>
```


Example in  kestra-openapi-sdk-customizer dir:
```
npm run build && npm start $(readlink -f ../../kestra-ee.yml)
```