/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 *
 *
 */


package io.kestra.sdk.model;

import java.io.IOException;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.kestra.sdk.model.WorkerQueueFallback;
import io.kestra.sdk.model.WorkerSelectorMatch;

/**
 * Routing requirements for a Flow, Task or Trigger. Unlike {@link WorkerSelector} (namespace and
 * tenant defaults), {@code tags} is a Kestra property: either a JSON array literal such as
 * {@code ["gpu"]} or a Pebble expression rendered when the job is routed. The server returns it as a
 * string in both cases.
 *
 * <p>Kestra before 2.0.11 typed {@code tags} as a plain list: it returns a JSON array and rejects a
 * string. To work with every 2.0.x server, an array is read as its JSON text, and tags holding a
 * JSON array of strings are written back as an array (which 2.0.11+ accepts too). Any other value,
 * such as a Pebble expression, is written as a string.
 */
@JsonPropertyOrder({
  FlowWorkerSelector.JSON_PROPERTY_TAGS,
  FlowWorkerSelector.JSON_PROPERTY_MATCH,
  FlowWorkerSelector.JSON_PROPERTY_FALLBACK
})
public class FlowWorkerSelector {
  public static final String JSON_PROPERTY_TAGS = "tags";
  @jakarta.annotation.Nullable  private String tags;

  public static final String JSON_PROPERTY_MATCH = "match";
  @jakarta.annotation.Nullable  private WorkerSelectorMatch match;

  public static final String JSON_PROPERTY_FALLBACK = "fallback";
  @jakarta.annotation.Nullable  private WorkerQueueFallback fallback;

  public FlowWorkerSelector() {
  }

  public FlowWorkerSelector tags(@jakarta.annotation.Nullable String tags) {
    
    this.tags = tags;
    return this;
  }

  /**
   * Required tags used to route to a matching Worker Queue, as a JSON array literal (e.g. {@code ["gpu"]})
   * or a Pebble expression rendering to the tags. Each tag is an RFC 1123 label, max 63 chars per tag,
   * max 20 tags; a tag rendering to an empty value is ignored.
   * @return tags
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  @JsonSerialize(using = TagsSerializer.class)
  public String getTags() {
    return tags;
  }


  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  @JsonDeserialize(using = TagsDeserializer.class)
  public void setTags(@jakarta.annotation.Nullable String tags) {
    this.tags = tags;
  }

  public FlowWorkerSelector match(@jakarta.annotation.Nullable WorkerSelectorMatch match) {
    
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

  public FlowWorkerSelector fallback(@jakarta.annotation.Nullable WorkerQueueFallback fallback) {
    
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

  /** Reads a string as is, and an array (Kestra before 2.0.11) as its JSON text. */
  static class TagsDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      JsonNode node = p.readValueAsTree();
      if (node == null || node.isNull()) {
        return null;
      }
      return node.isTextual() ? node.asText() : node.toString();
    }
  }

  /** Writes tags holding a JSON array of strings as that array, anything else as a string. */
  static class TagsSerializer extends JsonSerializer<String> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      JsonNode array = stringArray(value);
      if (array == null) {
        gen.writeString(value);
        return;
      }
      gen.writeStartArray();
      for (JsonNode item : array) {
        gen.writeString(item.asText());
      }
      gen.writeEndArray();
    }

    private static JsonNode stringArray(String value) {
      if (!value.trim().startsWith("[")) {
        return null;
      }
      try {
        JsonNode node = MAPPER.readTree(value);
        if (node == null || !node.isArray()) {
          return null;
        }
        for (JsonNode item : node) {
          if (!item.isTextual()) {
            return null;
          }
        }
        return node;
      } catch (IOException e) {
        return null;
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowWorkerSelector flowWorkerSelector = (FlowWorkerSelector) o;
    return Objects.equals(this.tags, flowWorkerSelector.tags) &&
        Objects.equals(this.match, flowWorkerSelector.match) &&
        Objects.equals(this.fallback, flowWorkerSelector.fallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tags, match, fallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowWorkerSelector {\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
