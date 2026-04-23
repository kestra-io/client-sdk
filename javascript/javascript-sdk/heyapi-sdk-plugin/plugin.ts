import { $, type TypeTsDsl } from "@hey-api/openapi-ts";
import type { KestraSdkPlugin } from "./types";

/**
 * Detects if the operation has a single body parameter whose camelCase name
 * contains 2 or more capital letters (i.e., it's a long auto-generated type name).
 *
 * When simplification applies, the function signature changes from:
 *   fn(parameters: { longTypeName: LongTypeName }, options?) => ...
 * to:
 *   fn(parameters: LongTypeName, options?) => ...
 *
 * Returns { paramName, typeSymbol } if simplification should be applied, null otherwise.
 */
function detectBodySimplification(
    operation: any,
    querySymbol: (filter: Record<string, unknown>) => any,
): { paramName: string; typeSymbol: any } | null {
    const bodySchema = operation.body?.schema;
    if (!bodySchema?.$ref) return null;

    // Use the full $ref as resourceId — this is how the TypeScript plugin registers type symbols
    const typeSymbol = querySymbol({
        category: 'type',
        resource: 'definition',
        resourceId: bodySchema.$ref,
    });

    if (!typeSymbol) return null;

    // Derive the camelCase param name from the TypeScript type symbol name
    // e.g. "IamUserControllerApiCreateOrUpdateUserRequest" → "iamUserControllerApiCreateOrUpdateUserRequest"
    const typeName: string = typeSymbol.name;
    const paramName = typeName.charAt(0).toLowerCase() + typeName.slice(1);

    return { paramName, typeSymbol };
}

export const handler: KestraSdkPlugin["Handler"] = ({ plugin }) => {
    const addTenantToParametersSymbol = plugin.symbol("addTenantToParameters", {
        getFilePath: () => "sdk/ks-shared",
    });

    const setGlobalTenantSymbol = plugin.symbol("setSelectedTenant", {
        getFilePath: () => "sdk/ks-shared",
    });

    const globalTenantSymbol = plugin.symbol("globalTenant", {
        getFilePath: () => "sdk/ks-shared",
    });

    const tenantNode = $.let(globalTenantSymbol).assign($.literal("main"))

    plugin.node(tenantNode);

    const setTenantFunctionNode = $.func().params(
        $.param("newTenant").type($.type("string"))
    ).do(
        $(globalTenantSymbol).assign($.id("newTenant"))
    );

    plugin.node($.const(setGlobalTenantSymbol).export().assign(setTenantFunctionNode));

    const optionsId = "options";
    const paramId = "parameters";

    const addTenantToParametersNode = $.func().generic("TParams")
        .params(
            $.param(paramId).type($.type("TParams"))
        ).returns($.type.and($.type("TParams"), $.type.object().prop("tenant", (p) => p.type("string"))))
        .do(
            $.return($.object()
                .prop("tenant", $(globalTenantSymbol))
                .spread($.id(paramId))
            )
        )

    plugin.node($.const(addTenantToParametersSymbol).export().assign(addTenantToParametersNode));

    // Helper: resolves tenant — uses provided value or falls back to globalTenant
    const resolveTenantSymbol = plugin.symbol("resolveTenant", {
        getFilePath: () => "sdk/ks-shared",
    });

    const resolveTenantNode = $.func()
        .params(
            $.param("tenant").required(false).type($.type("string"))
        ).returns($.type("string"))
        .do(
            $.return($("tenant").coalesce($(globalTenantSymbol)))
        );

    plugin.node($.const(resolveTenantSymbol).export().assign(resolveTenantNode));

    // Shared helper: extracts response.data or throws
    const getDataOrThrowSymbol = plugin.symbol("getDataOrThrow", {
        getFilePath: () => "sdk/ks-shared",
    });

    const getDataOrThrowNode = $.func().async()
        .generic("T").generic("E")
        .params(
            $.param("respPromise").type($.type("Promise").generic($.type.or(
                $.type.object().prop("data", (p) => p.type("T")).prop("error", (p) => p.type("undefined").optional()),
                $.type.object().prop("data", (p) => p.type("unknown").optional()).prop("error", (e) => e.type("E"))
            ))),
        )
        .returns($.type("Promise").generic($.type("T")))
        .do(
            $.const("resp").assign($.await("respPromise")),
            $.if($.expr(`"error" in resp`))
                .do($.expr("throw resp.error")),
            $.return($("resp").attr("data")),
        );

    plugin.node($.const(getDataOrThrowSymbol).export().assign(getDataOrThrowNode));

    // avoid having to unwrap the outputs
    const unwrapCallStatementsData = (callNode: any) => [
        $.return($(getDataOrThrowSymbol).call(callNode)),
    ];

    const operationsDict: Record<string, { symbol: ReturnType<typeof plugin.symbol>, methodName: string }[]> = {}



    plugin.forEach(
        "operation",
        ({ operation }) => {
            // on each operation, create a method that executes the operation from the sdk
            const methodName = plugin.config.methodNameBuilder?.(operation);
            if (!methodName) {
                return;
            }

            const pathParams = operation.parameters?.path || {};

            const sym = plugin.querySymbol({
                category: "sdk",
                resource: "operation",
                resourceId: operation.id,
            })

            if (!sym) {
                return;
            }

            const originalOperationSymbol = $(sym);

            const funcSymbol = plugin.symbol(methodName, {
                getFilePath: () => `sdk/ks-${operation.tags?.[0] ?? "default"}`,
            })

            if (!operationsDict[operation.tags?.[0] ?? "default"]) {
                operationsDict[operation.tags?.[0] ?? "default"] = [];
            }
            operationsDict[operation.tags?.[0] ?? "default"].push({ symbol: funcSymbol, methodName });

            const hasTenant = pathParams && "tenant" in pathParams;

            // Check if we should simplify the body parameter
            const bodySimplification = detectBodySimplification(operation, (filter) => plugin.querySymbol(filter as any));

            const isMultipart = operation.body?.mediaType === "multipart/form-data";

            // SSE operations return ServerSentEventsResult (not a data-bearing response),
            // so getDataOrThrow does not apply — pass these through unchanged.
            const isSSE = Object.values(operation.responses || {}).some(
                (resp: any) => resp?.mediaType === "text/event-stream"
            );

            const operationOptionsType = (sym: any, idx: 0 | 1 = 1) =>
                $.type("Omit").generics(
                    $.type("Parameters").generic($.type.query(sym)).idx(idx),
                    $.type.literal("throwOnError"),
                );

            const returnStatements = (callNode: any) =>
                isSSE ? [$.return(callNode)] : unwrapCallStatementsData(callNode);

            if (!hasTenant && !bodySimplification && !isMultipart) {
                // No tenant, no body simplification — wrap with getDataOrThrow (unless SSE)

                // Detect whether the original hey-api operation takes (parameters, options)
                // or just (options). Operations with no path/query params and no body only
                // expose a single options argument.
                const hasAnyParams =
                    Object.keys(operation.parameters?.path || {}).length > 0 ||
                    Object.keys(operation.parameters?.query || {}).length > 0 ||
                    !!operation.body;

                if (!hasAnyParams) {
                    // 1-param form: (options?) — options IS the first and only parameter
                    const functionNode = $.func()
                        .params(
                            $.param(optionsId).required(false)
                                .type(operationOptionsType(originalOperationSymbol, 0)),
                        )
                        .do(...returnStatements(originalOperationSymbol.call($(optionsId))));
                    plugin.node($.const(funcSymbol).export().assign(functionNode));
                } else {
                    // 2-param form: (parameters, options?)
                    // Mirror the original's required-ness for the parameters param
                    const hasRequiredParams =
                        Object.values(operation.parameters?.path || {}).some((p: any) => p.required) ||
                        Object.values(operation.parameters?.query || {}).some((p: any) => p.required) ||
                        (operation.body?.required === true);
                    const functionNode = $.func()
                        .params(
                            $.param(paramId).required(hasRequiredParams)
                                .type($.type("Parameters").generic($.type.query(originalOperationSymbol)).idx(0)),
                            $.param(optionsId).required(false)
                                .type(operationOptionsType(originalOperationSymbol)),
                        )
                        .do(...returnStatements(originalOperationSymbol.call($(paramId), $(optionsId))));
                    plugin.node($.const(funcSymbol).export().assign(functionNode));
                }
                return;
            }

            if (isMultipart && !hasTenant && !bodySimplification) {
                // Multipart but no tenant and no body simplification
                // Re-export with body added to spread of parameters with value empty object
                const functionNode = $.func()
                    .params(
                        $.param(paramId).type($.type("Parameters").generic($.type.query(originalOperationSymbol)).idx(0)),
                        $.param(optionsId).required(false).type(operationOptionsType(originalOperationSymbol)),
                    )
                    .do(
                        ...returnStatements(originalOperationSymbol.call($.object().prop("body", $.array()).spread($(paramId)), $(optionsId)))
                    );

                plugin.node($.const(funcSymbol).export().assign(functionNode).doc(operation.summary));
                return;
            }

            if (bodySimplification && !hasTenant) {

                // No tenant, but body simplification applies
                const { paramName, typeSymbol } = bodySimplification;

                // Check if there are other (non-body) params: path or query
                const hasOtherParams =
                    Object.keys(operation.parameters?.path || {}).length > 0 ||
                    Object.keys(operation.parameters?.query || {}).length > 0;

                let paramsType: TypeTsDsl;
                let callArgs: ReturnType<typeof $.object>;

                if (!hasOtherParams) {
                    // Only body: parameters: BodyType
                    paramsType = $.type(typeSymbol);
                    callArgs = $.object().prop(paramName, $(paramId));
                } else {
                    // Mixed: parameters: Omit<OriginalParams, 'bodyParamName'> & BodyType
                    paramsType = $.type.and(
                        $.type("Omit").generics(
                            $.type("Parameters").generic($.type.query(originalOperationSymbol)).idx(0),
                            $.type.literal(paramName)
                        ),
                        $.type(typeSymbol)
                    );
                    // { ...parameters, bodyParamName: parameters }
                    callArgs = $.object().spread($(paramId)).prop(paramName, $(paramId));
                }

                const functionNode = $.func()
                    .params(
                        $.param(paramId).type(paramsType),
                        $.param(optionsId).required(false).type(operationOptionsType(originalOperationSymbol)),
                    )
                    .do(
                        ...returnStatements(originalOperationSymbol.call(callArgs, optionsId))
                    );

                plugin.node(
                    $.const(funcSymbol).export().assign(functionNode).doc(operation.summary)
                );
                return;
            }

            // Has tenant path param
            const isTenantOnlyRequiredParam = Object.values(pathParams).filter((p: any) => p.name !== "tenant" && p.required).length === 0;

            const parametersArguments = isMultipart ? $.object()
                .prop("body", $.array())
                .spread($(paramId)) : $(paramId);

            if (!bodySimplification) {
                // Tenant but no body simplification — existing behavior
                const functionNode = $.func()
                    .params(
                        $.param(paramId)
                            .required(!isTenantOnlyRequiredParam)
                            .type($.type.and(
                                $.type("Omit").generics(
                                    $.type("Parameters").generic($.type.query(originalOperationSymbol)).idx(0),
                                    $.type.literal("tenant")
                                ),
                                $.type.object().prop("tenant", (p) => p.type("string").optional())
                            )),
                        $.param(optionsId)
                            .required(false)
                            .type(operationOptionsType(originalOperationSymbol)),
                    )
                    .do(
                        ...returnStatements(originalOperationSymbol.call(
                            $(addTenantToParametersSymbol).call(parametersArguments),
                            optionsId,
                        ))
                    );

                plugin.node($.const(funcSymbol).export().assign(functionNode).doc(operation.summary));
                return;
            }

            // Tenant + body simplification
            const { paramName, typeSymbol } = bodySimplification;
            const isBodyRequired = operation.body?.required ?? false;
            const parametersOptional = isTenantOnlyRequiredParam && !isBodyRequired;

            // Check if there are other non-tenant path or query params
            const hasOtherNonTenantParams =
                Object.keys(operation.parameters?.path || {}).filter((k) => k !== "tenant").length > 0 ||
                Object.keys(operation.parameters?.query || {}).length > 0;

            // parameters type: BodyType & { tenant?: string }
            // or: Omit<OriginalParams, 'bodyParamName' | 'tenant'> & BodyType & { tenant?: string }
            let paramsType: ReturnType<typeof $.type.and>;

            if (!hasOtherNonTenantParams) {
                paramsType = $.type.and(
                    $.type(typeSymbol),
                    $.type.object().prop("tenant", (p) => p.type("string").optional())
                );
            } else {
                paramsType = $.type.and(
                    $.type("Omit").generics(
                        $.type("Parameters").generic($.type.query(originalOperationSymbol)).idx(0),
                        $.type.or($.type.literal(paramName), $.type.literal("tenant"))
                    ),
                    $.type(typeSymbol),
                    $.type.object().prop("tenant", (p) => p.type("string").optional())
                );
            }

            // Build the call args:
            // { tenant: resolveTenant(parameters?.tenant), bodyParamName: parameters }
            // or for mixed: { ...parameters, tenant: resolveTenant(parameters?.tenant), bodyParamName: parameters }
            const tenantExpr = $(resolveTenantSymbol).call($("parameters").attr("tenant").optional());

            let callArgs: ReturnType<typeof $.object>;
            if (!hasOtherNonTenantParams) {
                callArgs = $.object()
                    .prop("tenant", tenantExpr)
                    .prop(paramName, $("parameters"));
            } else {
                callArgs = $.object()
                    .spread($("parameters"))
                    .prop("tenant", tenantExpr)
                    .prop(paramName, $("parameters"));
            }

            const functionNode = $.func()
                .params(
                    $.param(paramId)
                        .required(!parametersOptional)
                        .type(paramsType),
                    $.param(optionsId)
                        .required(false)
                        .type(operationOptionsType(originalOperationSymbol)),
                )
                .do(
                    ...returnStatements(originalOperationSymbol.call(callArgs, optionsId))
                );

            plugin.node($.const(funcSymbol).export().assign(functionNode).doc(operation.summary));
        },
        {
            order: "declarations",
        },
    );
};
