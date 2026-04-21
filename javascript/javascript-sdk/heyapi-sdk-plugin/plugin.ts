import {$} from "@hey-api/openapi-ts";
import type {KestraSdkPlugin} from "./types";


export const handler: KestraSdkPlugin["Handler"] = ({plugin}) => {
  const addTenantToParametersSymbol = plugin.symbol("addTenantToParameters",{
        getFilePath: () => "sdk/ks-shared",
  });

  const setGlobalTenantSymbol = plugin.symbol("setSelectedTenant",{
    getFilePath: () => "sdk/ks-shared",
  });

  const globalTenantSymbol = plugin.symbol("globalTenant",{
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

  const addTenantToParametersNode = $.func().generic("TParams")
    .params(
      $.param("parameters").type($.type("TParams"))
    ).returns($.type.and($.type("TParams"), $.type.object().prop("tenant", (p) => p.type("string"))))
    .do(
      $.return($.object()
        .prop("tenant", $(globalTenantSymbol))
        .spread($.id("parameters"))
      )
    )

  plugin.node($.const(addTenantToParametersSymbol).export().assign(addTenantToParametersNode));

  const operationsDict: Record<string, {symbol:ReturnType<typeof plugin.symbol>, methodName: string}[]> = {}

  plugin.forEach(
    "operation",
    ({operation}) => {
        const methodName = plugin.config.methodNameBuilder?.(operation);
        if (!methodName) {
            return;
        }

        const pathParams = operation.parameters?.path || {};
        const hasTenant = "tenant" in pathParams;
        const isMultipart = operation.body?.mediaType === "multipart/form-data";

        const sym = plugin.querySymbol({
          category: "sdk",
          resource: "operation",
          resourceId: operation.id,
        })

        if(!sym) {
            return;
        }

        const originalOperationSymbol = $(sym);

        const funcSymbol = plugin.symbol(methodName, {
            getFilePath: () => `sdk/ks-${operation.tags?.[0] ?? "default"}`,
        })

        if (!operationsDict[operation.tags?.[0] ?? "default"]) {
            operationsDict[operation.tags?.[0] ?? "default"] = [];
        }
        operationsDict[operation.tags?.[0] ?? "default"].push({symbol:funcSymbol, methodName});

        if (!hasTenant && !isMultipart) {
            plugin.node(
                $.const(funcSymbol)
                .assign(originalOperationSymbol)
                .export()
            );
            return;
        }

        const optionsId = "options"
        const paramId = "parameters"

        // When multipart/form-data, default body to {} so axios preserves the Content-Type header
        const withBodyDefault = (params: ReturnType<typeof $.id>) =>
            $.object().prop("body", $.object()).spread(params);

        if (!hasTenant) {
            // multipart only: wrap to ensure body defaults to {}
            const functionNode = $.func()
                .params(
                    $.param(paramId)
                        .required(false)
                        .type(
                            $.type("Parameters")
                                .generic($.type.query(originalOperationSymbol))
                                .idx(0)
                        ),
                    $.param(optionsId)
                        .required(false)
                        .type(
                            $.type("Parameters")
                                .generic($.type.query(originalOperationSymbol))
                                .idx(1)
                        )
                )
                .do(
                    $.return(originalOperationSymbol.call(
                        withBodyDefault($.id(paramId)),
                        optionsId,
                    ))
                )

            plugin.node($.const(funcSymbol).export().assign(functionNode).doc(operation.summary));
            return;
        }

        // Has tenant (with or without multipart)
        const isTenantOnlyRequiredParam = Object.values(pathParams).filter(p => p.name !== "tenant" && p.required).length === 0;

        const functionNode = $.func()
            .params(
                $.param(paramId)
                    .required(!isTenantOnlyRequiredParam)
                    .type($.type.and(
                        $.type("Omit").generics($.type("Parameters")
                            .generic($.type.query(originalOperationSymbol))
                            .idx(0), $.type.literal("tenant"))
                        ,
                            $.type.object().prop("tenant", (p) => p.type("string").optional())
                        )
                    )
                    ,
                $.param(optionsId)
                    .required(false)
                    .type(
                        $.type("Parameters")
                            .generic($.type.query(originalOperationSymbol))
                            .idx(1)
                        )
                )
            .do(
                isTenantOnlyRequiredParam ?
                    $.return(originalOperationSymbol.call(
                        $(addTenantToParametersSymbol).call(
                            isMultipart ? withBodyDefault($(paramId)) : $(paramId)
                        ),
                        optionsId,
                    ))
                : $.return(originalOperationSymbol.call(
                    $(addTenantToParametersSymbol).call(
                        isMultipart ? withBodyDefault($.id(paramId)) : paramId
                    ),
                    optionsId,
                ))
            )

        const exportedFunctionNode = $.const(funcSymbol).export().assign(functionNode)
            .doc(operation.summary);

        plugin.node(exportedFunctionNode);
    },
    {
      order: "declarations",
    },
  );
};
