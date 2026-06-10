package io.kestra;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Gates a test (or whole test class) to the Kestra version range it is valid for.
 *
 * <p>Replaces bare {@code @Disabled("Kestra 2.0: ...")}: instead of switching a
 * test off forever, you declare the line it asserts. The test then <em>runs</em>
 * against a matching server and is skipped — with a version-tied reason — against
 * any other. The version is resolved once from the live server
 * ({@code GET /api/v1/configs}), falling back to the {@code KESTRA_VERSION} env var.
 *
 * <p>Examples:
 * <pre>{@code
 * // asserts pre-2.0 behaviour (search filters server-side) — only run on <= 1.3
 * @EnabledIfKestraVersion(max = "1.3")
 * void searchNamespaces_withQuery() { ... }
 *
 * // asserts the new 2.0 behaviour — only run on >= 2.0
 * @EnabledIfKestraVersion(min = "2.0")
 * void searchNamespaces_viaActionsEndpoint() { ... }
 * }</pre>
 *
 * <p>An empty {@code min}/{@code max} means "no bound on that side". Both bounds
 * are inclusive and compared on {@code MAJOR.MINOR}.
 *
 * @see KestraServerVersion
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(KestraVersionCondition.class)
public @interface EnabledIfKestraVersion {

    /** Inclusive lower bound, e.g. {@code "2.0"}. Empty = unbounded below. */
    String min() default "";

    /** Inclusive upper bound, e.g. {@code "1.3"}. Empty = unbounded above. */
    String max() default "";

    /**
     * Why this gate exists — surfaced in the skip message. Use it to capture the
     * behaviour difference or a filed kestra-ee bug, e.g.
     * {@code "2.0 search no longer filters server-side (#265)"}.
     */
    String reason() default "";
}
