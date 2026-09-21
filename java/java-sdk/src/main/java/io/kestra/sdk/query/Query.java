/*
 * Kestra EE
 * All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
 *
 *
 *
 */


package io.kestra.sdk.query;

import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterLogical;
import io.kestra.sdk.model.QueryFilterOp;

import java.util.ArrayList;
import java.util.List;

/**
 * Fluent constructor layer over {@link QueryFilter} for building complex AND/OR (one level of
 * nesting) query filters (issue #246). The result of {@link #where(QueryFilter)} is a plain
 * {@code List<QueryFilter>} that drops straight into every generated {@code *ByQuery} method.
 *
 * <pre>{@code
 * import static io.kestra.sdk.query.Query.*;
 *
 * List<QueryFilter> filters = where(and(
 *     eq(QueryFilterField.NAMESPACE, "prod"),
 *     or(
 *         eq(QueryFilterField.STATE, "RUNNING"),
 *         eq(QueryFilterField.STATE, "SUCCESS")
 *     )
 * ));
 * }</pre>
 */
public final class Query {

  private Query() {
  }

  /**
   * Builds a leaf filter node.
   */
  public static QueryFilter filter(QueryFilterField field, QueryFilterOp operation, Object value) {
    return new QueryFilter().field(field).operation(operation).value(value);
  }

  public static QueryFilter eq(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.EQUALS, value);
  }

  public static QueryFilter notEq(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.NOT_EQUALS, value);
  }

  public static QueryFilter in(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.IN, value);
  }

  public static QueryFilter notIn(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.NOT_IN, value);
  }

  public static QueryFilter contains(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.CONTAINS, value);
  }

  public static QueryFilter startsWith(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.STARTS_WITH, value);
  }

  public static QueryFilter endsWith(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.ENDS_WITH, value);
  }

  public static QueryFilter regex(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.REGEX, value);
  }

  public static QueryFilter prefix(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.PREFIX, value);
  }

  public static QueryFilter greaterThan(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.GREATER_THAN, value);
  }

  public static QueryFilter greaterThanOrEqual(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.GREATER_THAN_OR_EQUAL_TO, value);
  }

  public static QueryFilter lessThan(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.LESS_THAN, value);
  }

  public static QueryFilter lessThanOrEqual(QueryFilterField field, Object value) {
    return filter(field, QueryFilterOp.LESS_THAN_OR_EQUAL_TO, value);
  }

  /**
   * Builds an AND group. Null and empty-group children are dropped; an empty group returns
   * {@code null}; a single effective child is returned directly (flattened).
   */
  public static QueryFilter and(QueryFilter... children) {
    return group(QueryFilterLogical.AND, children);
  }

  /**
   * Builds an OR group. Same dropping/flattening rules as {@link #and(QueryFilter...)}.
   */
  public static QueryFilter or(QueryFilter... children) {
    return group(QueryFilterLogical.OR, children);
  }

  private static QueryFilter group(QueryFilterLogical logical, QueryFilter... children) {
    List<QueryFilter> effective = new ArrayList<QueryFilter>();
    if (children != null) {
      for (QueryFilter child : children) {
        if (child == null || isEmptyGroup(child)) {
          continue;
        }
        effective.add(child);
      }
    }
    if (effective.isEmpty()) {
      return null;
    }
    if (effective.size() == 1) {
      return effective.get(0);
    }
    return new QueryFilter().logical(logical).children(effective);
  }

  private static boolean isEmptyGroup(QueryFilter f) {
    return f.getField() == null && (f.getChildren() == null || f.getChildren().isEmpty());
  }

  /**
   * Turns a filter tree root into the SDK's list type accepted by {@code *ByQuery} methods.
   * A {@code null} root yields an empty list; a top-level AND group is flattened one level;
   * anything else yields a single-element list.
   */
  public static List<QueryFilter> where(QueryFilter root) {
    if (root == null) {
      return new ArrayList<QueryFilter>();
    }
    if (root.getLogical() == QueryFilterLogical.AND && root.getChildren() != null) {
      return new ArrayList<QueryFilter>(root.getChildren());
    }
    List<QueryFilter> result = new ArrayList<QueryFilter>();
    result.add(root);
    return result;
  }
}
