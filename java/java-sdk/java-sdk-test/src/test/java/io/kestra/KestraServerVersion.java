package io.kestra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Kestra (major, minor) version the test suite is running against.
 *
 * <p>Used by {@link EnabledIfKestraVersion} to gate version-specific tests so that
 * an assertion is <em>enabled on the line where it is valid</em> and automatically
 * skipped (with a version-tied reason) everywhere else — instead of a bare
 * {@code @Disabled} that nothing ever re-enables. See
 * {@code design/multi-version-compatibility.md}.
 *
 * <p>Unparseable / pre-release labels (e.g. {@code develop}, {@code latest}) are
 * treated as the <em>latest</em> line: they satisfy every {@code min} bound and
 * no {@code max} bound. That matches how {@code compute-version} maps a non
 * {@code releases/*} branch to {@code develop}.
 */
public final class KestraServerVersion {

    /** Sentinel "latest / unreleased" line — higher than any concrete version. */
    public static final KestraServerVersion LATEST =
            new KestraServerVersion(Integer.MAX_VALUE, Integer.MAX_VALUE, "latest");

    private static final Pattern VERSION = Pattern.compile("(\\d+)\\.(\\d+)");

    private final int major;
    private final int minor;
    private final String raw;

    private KestraServerVersion(int major, int minor, String raw) {
        this.major = major;
        this.minor = minor;
        this.raw = raw;
    }

    /**
     * Parse a version label coming from the server ({@code /api/v1/configs} →
     * {@code version}, e.g. {@code "2.0.0-SNAPSHOT"}) or from the
     * {@code KESTRA_VERSION} CI env var (e.g. {@code "develop"}, {@code "v1.3.x"},
     * {@code "releases/v1.3.x"}). Anything without a {@code MAJOR.MINOR} pair is
     * treated as {@link #LATEST}.
     */
    public static KestraServerVersion parse(String label) {
        if (label == null || label.isBlank()) {
            return LATEST;
        }
        Matcher m = VERSION.matcher(label);
        if (!m.find()) {
            return LATEST;
        }
        return new KestraServerVersion(
                Integer.parseInt(m.group(1)),
                Integer.parseInt(m.group(2)),
                label);
    }

    /** True if this version is {@code >= major.minor}. */
    public boolean atLeast(int major, int minor) {
        return this.major != major ? this.major > major : this.minor >= minor;
    }

    /** True if this version is {@code <= major.minor}. */
    public boolean atMost(int major, int minor) {
        return this.major != major ? this.major < major : this.minor <= minor;
    }

    public int major() {
        return major;
    }

    public int minor() {
        return minor;
    }

    @Override
    public String toString() {
        return this == LATEST || major == Integer.MAX_VALUE
                ? raw + " (latest)"
                : major + "." + minor + " (" + raw + ")";
    }
}
