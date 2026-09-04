package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

public class ReusableInputsApiTest {

    static ReusableInputsApi api() {
        return client().reusableInputs();
    }

    static String source(String namespace, String id) {
        return source(namespace, id, "shared inputs");
    }

    static String source(String namespace, String id, String description) {
        return """
                id: %s
                namespace: %s
                description: %s
                inputs:
                  - id: name
                    type: STRING
                    defaults: world
                  - id: count
                    type: INT
                """.formatted(id, namespace, description);
    }

    static ReusableInputs create(String namespace, String id) throws ApiException {
        return api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id), null);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createOrUpdateReusableInputs_create() throws ApiException {
        String namespace = randomId();
        String id = randomId();

        ReusableInputs created = create(namespace, id);

        assertThat(created.getId()).isEqualTo(id);
        assertThat(created.getNamespace()).isEqualTo(namespace);
        assertThat(created.getDescription()).isEqualTo("shared inputs");
        assertThat(created.getInputs()).extracting(InputObject::getId).containsExactly("name", "count");
    }

    @Test
    void createOrUpdateReusableInputs_failIfExists() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);

        assertThatThrownBy(() -> api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id), true))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(409));
    }

    @Test
    void reusableInputs_get() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);

        ReusableInputs found = api().reusableInputs(namespace, id, TENANT, null);

        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getInputs()).hasSize(2);
    }

    @Test
    void deleteReusableInputs() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);

        api().deleteReusableInputs(namespace, id, TENANT);

        assertThatThrownBy(() -> api().reusableInputs(namespace, id, TENANT, null))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(404));
    }

    // ========================================================================
    // Namespace inheritance
    // ========================================================================

    @Test
    void reusableInputs_resolvesNamespaceInheritance() throws ApiException {
        String parent = randomId();
        String child = parent + ".child";
        String id = randomId();
        create(parent, id);

        ReusableInputs inherited = api().reusableInputs(child, id, TENANT, null);
        assertThat(inherited.getNamespace()).isEqualTo(parent);

        PagedResultsReusableInputs listed = api().listReusableInputs(child, TENANT, null, null);
        assertThat(listed.getTotal()).isEqualTo(1);
        assertThat(listed.getResults()).extracting(ReusableInputs::getId).containsExactly(id);
    }

    // ========================================================================
    // List & Revisions
    // ========================================================================

    @Test
    void listReusableInputs_paged() throws ApiException {
        String namespace = randomId();
        for (int i = 0; i < 3; i++) {
            create(namespace, randomId());
        }

        PagedResultsReusableInputs all = api().listReusableInputs(namespace, TENANT, null, null);
        assertThat(all.getTotal()).isEqualTo(3);

        PagedResultsReusableInputs firstPage = api().listReusableInputs(namespace, TENANT, 1, 2);
        assertThat(firstPage.getTotal()).isEqualTo(3);
        assertThat(firstPage.getResults()).hasSize(2);
    }

    @Test
    void listReusableInputsRevisions() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);
        api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id, "updated inputs"), null);

        List<ReusableInputs> revisions = api().listReusableInputsRevisions(namespace, id, TENANT);
        assertThat(revisions).hasSize(2);

        assertThat(api().reusableInputs(namespace, id, TENANT, null).getDescription()).isEqualTo("updated inputs");
        assertThat(api().reusableInputs(namespace, id, TENANT, 1).getDescription()).isEqualTo("shared inputs");
    }

    @Test
    void listReusableInputsNamespaces() throws ApiException {
        String namespace = randomId();
        create(namespace, randomId());

        List<String> namespaces = api().listReusableInputsNamespaces(TENANT);

        assertThat(namespaces).contains(namespace);
    }
}
