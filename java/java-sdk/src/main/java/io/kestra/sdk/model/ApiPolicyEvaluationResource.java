/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nullable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ApiPolicyEvaluationResource
 */
@JsonPropertyOrder({
  ApiPolicyEvaluationResource.JSON_PROPERTY_KIND,
  ApiPolicyEvaluationResource.JSON_PROPERTY_NAMESPACE,
  ApiPolicyEvaluationResource.JSON_PROPERTY_ID
})
public class ApiPolicyEvaluationResource {
  public static final String JSON_PROPERTY_KIND = "kind";
  @Nullable  private String kind;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @Nullable  private String namespace;

  public static final String JSON_PROPERTY_ID = "id";
  @Nullable  private String id;

  public ApiPolicyEvaluationResource() {
  }

  public ApiPolicyEvaluationResource kind(@Nullable String kind) {
    
    this.kind = kind;
    return this;
  }

  /**
   * Get kind
   * @return kind
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(@Nullable String kind) {
    this.kind = kind;
  }

  public ApiPolicyEvaluationResource namespace(@Nullable String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespace(@Nullable String namespace) {
    this.namespace = namespace;
  }

  public ApiPolicyEvaluationResource id(@Nullable String id) {
    
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Nullable  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@Nullable String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiPolicyEvaluationResource apiPolicyEvaluationResource = (ApiPolicyEvaluationResource) o;
    return Objects.equals(this.kind, apiPolicyEvaluationResource.kind) &&
        Objects.equals(this.namespace, apiPolicyEvaluationResource.namespace) &&
        Objects.equals(this.id, apiPolicyEvaluationResource.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, namespace, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiPolicyEvaluationResource {\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
