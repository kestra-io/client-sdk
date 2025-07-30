# JavaScript SDK

## Steps to generate the SDK

1. Update the `kestra-ee.yml` with the latest OpenSpec API changes (if necessary).

  - As of 2025-07-29, the `kestra-ee.yml` file has been generated and used without modifications.
  - Micronaut OpenAPI version `6.17.3` was used

2. **Generate the SDK** using the `generate-sdks.sh` script, which utilizes the `openapi-generator-cli` Docker image.

## How to use

The OpenAPI generator creates one API per controller. To simplify usage, use the manually written `KestraClient` (`import {KestraClient} from "kestra_api";`) that consolidates all APIs into a single client.

### Instantiate the client:

```javascript
const kestraClient = new KestraClient(host, token, username, password);
 ```

### Make API calls:

```javascript
kestraClient.flowsApi.searchFlows()
```

Each method of the API expects a callback function with the following signature:

```javascript
callback (error, data, response)
```
