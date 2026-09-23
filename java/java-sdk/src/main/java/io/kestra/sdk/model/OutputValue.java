/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * 
 *
 */


package io.kestra.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

/**
 * Holds a flow output's `value`: per the spec a oneOf of an object or a string (typically a `{{ }}` expression).
 *
 * <p>The generated interface was empty and annotated with a
 * {@code @JsonTypeInfo(property = "")} that can never resolve a subtype, so the
 * value was deserialized to {@code null} (or failed) and was lost on a typed
 * read-then-write round-trip. The raw JSON value (a {@code String},
 * {@code Map}, {@code List}, ...) is now carried by {@link Value}, which
 * (de)serializes as the bare value. Build one with {@link #of(Object)}.
 */
@JsonDeserialize(as = OutputValue.Value.class)
public interface OutputValue {

  /**
   * Wrap a raw value (a {@code String} expression, a {@code Map}, a
   * {@code List}, ...) as a {@link OutputValue}.
   */
  static OutputValue of(Object value) {
    return new Value(value);
  }

  /** The raw value, serialized and deserialized as-is. */
  final class Value implements OutputValue {
    private final Object value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Value(Object value) {
      this.value = value;
    }

    @JsonValue
    public Object getValue() {
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      return o instanceof Value other && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(value);
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }
}
