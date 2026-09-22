/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 * 
 *
 */


package io.kestra.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kestra.sdk.model.DependsOn;
import io.kestra.sdk.model.PropertyObject;
import io.kestra.sdk.model.Type;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * InputObject
 */
@JsonPropertyOrder({
  InputObject.JSON_PROPERTY_ID,
  InputObject.JSON_PROPERTY_TYPE,
  InputObject.JSON_PROPERTY_DESCRIPTION,
  InputObject.JSON_PROPERTY_DEPENDS_ON,
  InputObject.JSON_PROPERTY_REQUIRED,
  InputObject.JSON_PROPERTY_DEFAULTS,
  InputObject.JSON_PROPERTY_PREFILL,
  InputObject.JSON_PROPERTY_DISPLAY_NAME
})
@JsonTypeName("Input_Object_")
public class InputObject {
  public static final String JSON_PROPERTY_ID = "id";
  @jakarta.annotation.Nonnull  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  @jakarta.annotation.Nonnull  private Type type;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @jakarta.annotation.Nullable  private String description;

  public static final String JSON_PROPERTY_DEPENDS_ON = "dependsOn";
  @jakarta.annotation.Nullable  private DependsOn dependsOn;

  public static final String JSON_PROPERTY_REQUIRED = "required";
  @jakarta.annotation.Nullable  private Boolean required;

  public static final String JSON_PROPERTY_DEFAULTS = "defaults";
  @jakarta.annotation.Nullable  private String defaults;

  public static final String JSON_PROPERTY_PREFILL = "prefill";
  @jakarta.annotation.Nullable  private String prefill;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @jakarta.annotation.Nullable  private String displayName;

  public InputObject() {
  }

  public InputObject id(@jakarta.annotation.Nonnull String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(@jakarta.annotation.Nonnull String id) {
    this.id = id;
  }

  public InputObject type(@jakarta.annotation.Nonnull Type type) {
    
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @jakarta.annotation.Nonnull  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Type getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(@jakarta.annotation.Nonnull Type type) {
    this.type = type;
  }

  public InputObject description(@jakarta.annotation.Nullable String description) {
    
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@jakarta.annotation.Nullable String description) {
    this.description = description;
  }

  public InputObject dependsOn(@jakarta.annotation.Nullable DependsOn dependsOn) {
    
    this.dependsOn = dependsOn;
    return this;
  }

  /**
   * Get dependsOn
   * @return dependsOn
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DEPENDS_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DependsOn getDependsOn() {
    return dependsOn;
  }


  @JsonProperty(JSON_PROPERTY_DEPENDS_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDependsOn(@jakarta.annotation.Nullable DependsOn dependsOn) {
    this.dependsOn = dependsOn;
  }

  public InputObject required(@jakarta.annotation.Nullable Boolean required) {
    
    this.required = required;
    return this;
  }

  /**
   * Get required
   * @return required
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRequired() {
    return required;
  }


  @JsonProperty(JSON_PROPERTY_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequired(@jakarta.annotation.Nullable Boolean required) {
    this.required = required;
  }

  public InputObject defaults(@jakarta.annotation.Nullable String defaults) {
    
    this.defaults = defaults;
    return this;
  }

  /**
   * Get defaults
   * @return defaults
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDefaults() {
    return defaults;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefaults(@jakarta.annotation.Nullable String defaults) {
    this.defaults = defaults;
  }

  public InputObject prefill(@jakarta.annotation.Nullable String prefill) {
    
    this.prefill = prefill;
    return this;
  }

  /**
   * Optional UI hint for pre-filling the input. Cannot be used together with a default value.
   * @return prefill
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_PREFILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrefill() {
    return prefill;
  }


  @JsonProperty(JSON_PROPERTY_PREFILL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefill(@jakarta.annotation.Nullable String prefill) {
    this.prefill = prefill;
  }

  public InputObject displayName(@jakarta.annotation.Nullable String displayName) {
    
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   */
  @jakarta.annotation.Nullable  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
    this.displayName = displayName;
  }

  /**
   * An input is an open envelope: type-specific properties (e.g. `values` on a
   * SELECT input, `defaults`/`min`/`max` on numeric inputs) are carried here as
   * free-form additional properties. Without this these properties would be
   * silently dropped on (de)serialization.
   */
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   */
  @JsonAnySetter
  public InputObject putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
      this.additionalProperties = new HashMap<>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
      return null;
    }
    return this.additionalProperties.get(key);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputObject inputObject = (InputObject) o;
    return Objects.equals(this.id, inputObject.id) &&
        Objects.equals(this.type, inputObject.type) &&
        Objects.equals(this.description, inputObject.description) &&
        Objects.equals(this.dependsOn, inputObject.dependsOn) &&
        Objects.equals(this.required, inputObject.required) &&
        Objects.equals(this.defaults, inputObject.defaults) &&
        Objects.equals(this.prefill, inputObject.prefill) &&
        Objects.equals(this.displayName, inputObject.displayName) &&
        Objects.equals(this.additionalProperties, inputObject.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, description, dependsOn, required, defaults, prefill, displayName, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputObject {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dependsOn: ").append(toIndentedString(dependsOn)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    defaults: ").append(toIndentedString(defaults)).append("\n");
    sb.append("    prefill: ").append(toIndentedString(prefill)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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

