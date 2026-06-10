package io.kestra;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.util.Optional;

/**
 * JUnit 5 condition backing {@link EnabledIfKestraVersion}. Resolves the server
 * version once (see {@link TestUtils#serverVersion()}) and enables/disables the
 * element based on its declared {@code [min, max]} range.
 */
public class KestraVersionCondition implements ExecutionCondition {

    private static final ConditionEvaluationResult ENABLED_NO_ANNOTATION =
            ConditionEvaluationResult.enabled("no @EnabledIfKestraVersion present");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<EnabledIfKestraVersion> annotation = context.getElement()
                .flatMap(el -> AnnotationSupport.findAnnotation(el, EnabledIfKestraVersion.class));
        if (annotation.isEmpty()) {
            return ENABLED_NO_ANNOTATION;
        }

        EnabledIfKestraVersion gate = annotation.get();
        KestraServerVersion server = TestUtils.serverVersion();

        if (!gate.min().isBlank()) {
            KestraServerVersion min = KestraServerVersion.parse(gate.min());
            if (!server.atLeast(min.major(), min.minor())) {
                return disabled(server, "requires Kestra >= " + gate.min(), gate.reason());
            }
        }
        if (!gate.max().isBlank()) {
            KestraServerVersion max = KestraServerVersion.parse(gate.max());
            if (!server.atMost(max.major(), max.minor())) {
                return disabled(server, "requires Kestra <= " + gate.max(), gate.reason());
            }
        }

        return ConditionEvaluationResult.enabled("server " + server + " is in range");
    }

    private static ConditionEvaluationResult disabled(KestraServerVersion server, String bound, String reason) {
        String message = "server is " + server + " but test " + bound;
        return ConditionEvaluationResult.disabled(
                reason.isBlank() ? message : message + " — " + reason);
    }
}
