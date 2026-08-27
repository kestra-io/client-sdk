/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 */


package io.kestra.sdk.model;

import jakarta.annotation.Nonnull;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PolicyPreviewRequest
 */
@JsonPropertyOrder({
  PolicyPreviewRequest.JSON_PROPERTY_NAMESPACE,
  PolicyPreviewRequest.JSON_PROPERTY_SOURCE
})
public class PolicyPreviewRequest {
  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @Nonnull  private String namespace;

  public static final String JSON_PROPERTY_SOURCE = "source";
  @Nonnull  private String source;

  public PolicyPreviewRequest() {
  }

  public PolicyPreviewRequest namespace(@Nonnull String namespace) {
    
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespace() {
    return namespace;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespace(@Nonnull String namespace) {
    this.namespace = namespace;
  }

  public PolicyPreviewRequest source(@Nonnull String source) {
    
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  @Nonnull  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSource() {
    return source;
  }


  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(@Nonnull String source) {
    this.source = source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyPreviewRequest policyPreviewRequest = (PolicyPreviewRequest) o;
    return Objects.equals(this.namespace, policyPreviewRequest.namespace) &&
        Objects.equals(this.source, policyPreviewRequest.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyPreviewRequest {\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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
