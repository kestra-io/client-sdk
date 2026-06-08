/// Embed CI-tested source regions into Markdown docs (single source of truth).
///
/// Java port of the snippet injector: it keeps the example snippets in the
/// READMEs physically identical to code that the test suites compile/run, so
/// the docs can never silently drift from the SDK (the root cause of issue
/// #144). Implemented in plain Java so the Java SDK toolchain needs no other
/// language — run it with the JDK directly:
///
///     java test-utils/EmbedSnippets.java --write README.md
///     java test-utils/EmbedSnippets.java --check README.md
///
/// `--check` is the CI gate: it exits non-zero (without modifying anything) if
/// any doc is out of sync with its source region.
///
/// Conventions
/// -----------
/// In a *source* file, mark a region with line comments (any of `//`, `#`, `--`):
///
///     // region:flow-lifecycle
///     var page = client.flows().searchFlows(tenant, 1, 10, null, List.of());
///     // endregion
///
/// In a *Markdown* file, declare where it goes:
///
///     <!-- snippet:flow-lifecycle src=path/to/Example.java lang=java -->
///     ```java
///     (auto-managed — do not edit by hand)
///     ```
///     <!-- /snippet -->
///
/// `src` is resolved relative to the Markdown file's directory. The region body
/// is dedented before insertion; `lang` only sets the fence language.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmbedSnippets {

    // <!-- snippet:NAME src=... [lang=...] --> ... <!-- /snippet -->
    private static final Pattern SNIPPET = Pattern.compile(
            "(?<open><!--\\s*snippet:(?<name>[\\w.-]+)\\s+(?<attrs>[^>]*?)-->[ \\t]*\\n)"
                    + "(?<body>.*?)"
                    + "(?<close>[ \\t]*<!--\\s*/snippet\\s*-->)",
            Pattern.DOTALL);

    private static final Pattern ATTR = Pattern.compile("(\\w+)=(\\S+)");

    /** Drop a leading line-comment marker so region tags are recognised. */
    private static String commentStripped(String line) {
        return line.replaceFirst("^\\s*(?://|#|--)\\s?", "").trim();
    }

    private static String extractRegion(Path srcPath, String name) throws IOException {
        List<String> lines = Files.readAllLines(srcPath);
        int start = -1;
        int end = -1;
        for (int i = 0; i < lines.size(); i++) {
            String tag = commentStripped(lines.get(i));
            if (tag.equals("region:" + name) || tag.equals("region " + name)) {
                start = i + 1;
            } else if (start >= 0
                    && (tag.equals("endregion")
                            || tag.equals("endregion " + name)
                            || tag.equals("endregion:" + name))) {
                end = i;
                break;
            }
        }
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("region '" + name + "' not found in " + srcPath);
        }
        return stripBlankEdges(dedent(lines.subList(start, end)));
    }

    /** Remove the longest leading-whitespace prefix common to all non-blank lines. */
    private static String dedent(List<String> region) {
        String margin = null;
        for (String line : region) {
            if (line.isBlank()) {
                continue;
            }
            String indent = leadingWhitespace(line);
            margin = (margin == null) ? indent : commonPrefix(margin, indent);
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < region.size(); i++) {
            String line = region.get(i);
            if (i > 0) {
                out.append('\n');
            }
            if (line.isBlank()) {
                continue; // normalize whitespace-only lines to empty, like textwrap.dedent
            }
            out.append(margin == null ? line : line.substring(margin.length()));
        }
        return out.toString();
    }

    private static String leadingWhitespace(String line) {
        int i = 0;
        while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
            i++;
        }
        return line.substring(0, i);
    }

    private static String commonPrefix(String a, String b) {
        int n = Math.min(a.length(), b.length());
        int i = 0;
        while (i < n && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.substring(0, i);
    }

    /** Trim leading and trailing newlines only (mirrors Python's strip("\n")). */
    private static String stripBlankEdges(String s) {
        int start = 0;
        int end = s.length();
        while (start < end && s.charAt(start) == '\n') {
            start++;
        }
        while (end > start && s.charAt(end - 1) == '\n') {
            end--;
        }
        return s.substring(start, end);
    }

    private static String render(String markdown, Path baseDir) throws IOException {
        Matcher m = SNIPPET.matcher(markdown);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String attrs = m.group("attrs");
            String src = null;
            String lang = "";
            Matcher a = ATTR.matcher(attrs);
            while (a.find()) {
                if (a.group(1).equals("src")) {
                    src = a.group(2);
                } else if (a.group(1).equals("lang")) {
                    lang = a.group(2);
                }
            }
            if (src == null) {
                throw new IllegalArgumentException(
                        "snippet '" + m.group("name") + "' is missing a src= attribute");
            }
            String region = extractRegion(baseDir.resolve(src).normalize(), m.group("name"));
            String fenced = "```" + lang + "\n" + region + "\n```\n";
            String replacement = m.group("open") + fenced + m.group("close");
            m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /** Returns true if {@code path} is already up to date. */
    private static boolean process(Path path, boolean write) throws IOException {
        String original = Files.readString(path);
        Path baseDir = path.toAbsolutePath().getParent();
        String updated = render(original, baseDir);
        if (updated.equals(original)) {
            return true;
        }
        if (write) {
            Files.writeString(path, updated);
            System.out.println("updated " + path);
        } else {
            System.out.println("OUT OF SYNC: " + path + " (run with --write to fix)");
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        boolean write = false;
        boolean check = false;
        List<Path> files = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "--write" -> write = true;
                case "--check" -> check = true;
                default -> files.add(Path.of(arg));
            }
        }
        if (write == check || files.isEmpty()) {
            System.err.println("usage: java EmbedSnippets.java (--write | --check) FILE...");
            System.exit(2);
        }

        boolean allInSync = true;
        for (Path f : files) {
            allInSync &= process(f, write);
        }
        if (check && !allInSync) {
            System.exit(1);
        }
    }
}
