/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 *
 *
 */


package io.kestra.sdk.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.model.WorkerQueueFallback;
import io.kestra.sdk.model.WorkerSelectorMatch;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Routing requirements for a Worker Queue.
 *
 * <p>On a Flow, Task or Trigger, Kestra 2.0.11+ types {@code tags} as a property: the server returns
 * it as a string, either the JSON text of a literal list ({@code ["gpu"]}) or a Pebble expression.
 * Kestra 2.0.0-2.0.10, and namespace / tenant defaults, use a plain list. To work with every 2.0.x
 * server, a literal list is always read into {@link #getTags()} and any other string into
 * {@link #getTagsExpression()}. On write, {@code tagsExpression} is sent as a string when set (Kestra
 * 2.0.11+ only), otherwise {@code tags} is sent as a list. Setting one clears the other; should
 * both ever be set, {@code tagsExpression} wins, as in the Python and Go SDKs.
 *
 * <p>Namespace and tenant {@code defaultWorkerSelector} also use this class, but there the server
 * takes a plain list: use {@link #tags(List)} only, a {@code tagsExpression} is rejected.
 */
@JsonPropertyOrder({
  WorkerSelector.JSON_PROPERTY_TAGS,
  WorkerSelector.JSON_PROPERTY_MATCH,
  WorkerSelector.JSON_PROPERTY_FALLBACK
})
public class WorkerSelector {
  public static final String JSON_PROPERTY_TAGS = "tags";
  @jakarta.annotation.Nullable  private List<String> tags;

  @jakarta.annotation.Nullable  private String tagsExpression;

  // Fails on trailing content, so a string like '["gpu"] x' reads as an expression, as in the
  // Python and Go SDKs, instead of the list ["gpu"].
  private static final ObjectMapper TAGS_MAPPER = new ObjectMapper()
      .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);

  public static final String JSON_PROPERTY_MATCH = "match";
  @jakarta.annotation.Nullable  private WorkerSelectorMatch match;

  public static final String JSON_PROPERTY_FALLBACK = "fallback";
  @jakarta.annotation.Nullable  private WorkerQueueFallback fallback;

  public WorkerSelector() {
  }

  public WorkerSelector tags(@jakarta.annotation.Nullable List<String> tags) {
    
    this.tags = tags;
    this.tagsExpression = null;
    return this;
  }

  public WorkerSelector addTagsItem(String tagsItem) {
    this.tagsExpression = null;
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Required tags used to route to a matching Worker Queue. Each tag is an RFC 1123 label: lowercase alphanumerics and hyphens, must start and end with alphanumeric, max 64 chars per tag, max 20 tags.
   * @return tags
   */
  @jakarta.annotation.Nullable  @JsonIgnore
  public List<String> getTags() {
    return tags;
  }


  @JsonIgnore
  public void setTags(@jakarta.annotation.Nullable List<String> tags) {
    this.tags = tags;
    this.tagsExpression = null;
  }

  public WorkerSelector tagsExpression(@jakarta.annotation.Nullable String tagsExpression) {
    setTagsExpression(tagsExpression);
    return this;
  }

  /**
   * Pebble expression rendering to the tags (Flow, Task and Trigger only, Kestra 2.0.11+), e.g.
   * {@code {{ inputs.workers }}}. Null when the tags are a literal list, see {@link #getTags()}.
   * @return tagsExpression
   */
  @jakarta.annotation.Nullable  @JsonIgnore
  public String getTagsExpression() {
    return tagsExpression;
  }


  @JsonIgnore
  public void setTagsExpression(@jakarta.annotation.Nullable String tagsExpression) {
    this.tagsExpression = tagsExpression;
    if (tagsExpression != null) {
      this.tags = null;
    }
  }

  /** The {@code tags} JSON value: the expression when set, otherwise the list. */
  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  private Object getTagsJson() {
    return tagsExpression != null ? tagsExpression : tags;
  }

  /**
   * Reads {@code tags} as an array (Kestra before 2.0.11, namespace / tenant defaults) or a string
   * (Kestra 2.0.11+ flows, tasks and triggers): the JSON text of a list of strings is read into
   * {@code tags}, any other string into {@code tagsExpression}.
   */
  @JsonProperty(JSON_PROPERTY_TAGS)
  private void setTagsJson(@jakarta.annotation.Nullable JsonNode node) {
    this.tags = null;
    this.tagsExpression = null;
    if (node == null || node.isNull()) {
      return;
    }
    if (node.isArray()) {
      this.tags = stringList(node);
      return;
    }
    String text = node.asText();
    JsonNode parsed = parseArray(text);
    if (parsed != null && allTextual(parsed)) {
      this.tags = stringList(parsed);
    } else {
      this.tagsExpression = text;
    }
  }

  private static List<String> stringList(JsonNode array) {
    List<String> list = new ArrayList<>();
    for (JsonNode item : array) {
      list.add(item.isNull() ? null : item.asText());
    }
    return list;
  }

  private static boolean allTextual(JsonNode array) {
    for (JsonNode item : array) {
      if (!item.isTextual()) {
        return false;
      }
    }
    return true;
  }

  private static JsonNode parseArray(String text) {
    if (!text.trim().startsWith("[")) {
      return null;
    }
    try {
      JsonNode node = TAGS_MAPPER.readTree(text);
      return node != null && node.isArray() ? node : null;
    } catch (IOException e) {
      return null;
    }
  }

  public WorkerSelector match(@jakarta.annotation.Nullable WorkerSelectorMatch match) {
    
    this.match = match;
    return this;
  }

  /**
   * How selector tags are matched against a Worker Queue&#39;s tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null.
   * @return match
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_MATCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WorkerSelectorMatch getMatch() {
    return match;
  }


  @JsonProperty(JSON_PROPERTY_MATCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMatch(@jakarta.annotation.Nullable WorkerSelectorMatch match) {
    this.match = match;
  }

  public WorkerSelector fallback(@jakarta.annotation.Nullable WorkerQueueFallback fallback) {
    
    this.fallback = fallback;
    return this;
  }

  /**
   * Strategy when no worker is available. Defaults to FAIL when null.
   * @return fallback
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WorkerQueueFallback getFallback() {
    return fallback;
  }


  @JsonProperty(JSON_PROPERTY_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFallback(@jakarta.annotation.Nullable WorkerQueueFallback fallback) {
    this.fallback = fallback;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkerSelector workerSelector = (WorkerSelector) o;
    return Objects.equals(this.tags, workerSelector.tags) &&
        Objects.equals(this.tagsExpression, workerSelector.tagsExpression) &&
        Objects.equals(this.match, workerSelector.match) &&
        Objects.equals(this.fallback, workerSelector.fallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tags, tagsExpression, match, fallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkerSelector {\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    tagsExpression: ").append(toIndentedString(tagsExpression)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    fallback: ").append(toIndentedString(fallback)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
