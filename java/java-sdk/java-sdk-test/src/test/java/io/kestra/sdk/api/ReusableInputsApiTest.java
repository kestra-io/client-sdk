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

    static ReusableInputsWithSource create(String namespace, String id) throws ApiException {
        return api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id), null);
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createOrUpdateReusableInputs_create() throws ApiException {
        String namespace = randomId();
        String id = randomId();

        ReusableInputsWithSource created = create(namespace, id);

        assertThat(created.getId()).isEqualTo(id);
        assertThat(created.getNamespace()).isEqualTo(namespace);
        assertThat(created.getDescription()).isEqualTo("shared inputs");
        assertThat(created.getInputs()).extracting(InputObject::getId).containsExactly("name", "count");
        assertThat(created.getSource()).isEqualTo(source(namespace, id));
        assertThat(created.getRevision()).isEqualTo(1);
        assertThat(created.getLast()).isTrue();
        assertThat(created.getDeleted()).isFalse();
        assertThat(created.getCreated()).isNotNull();
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

        ReusableInputsWithSource found = api().reusableInputs(namespace, id, TENANT, null);

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
    // Drafts
    // ========================================================================

    @Test
    void createOrUpdateReusableInputs_draft() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        ReusableInputsWithSource published = create(namespace, id);

        ReusableInputsWithSource draft = api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id, "in progress"), null, true);

        assertThat(published.getDraft()).isFalse();
        assertThat(published.getUpdatedBy()).isNotBlank();
        assertThat(draft.getDraft()).isTrue();
        assertThat(draft.getRevision()).isEqualTo(2);
        assertThat(draft.getUpdatedBy()).isEqualTo(published.getUpdatedBy());
    }

    @Test
    void reusableInputs_skipsDraftsUnlessAllowed() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);
        api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id, "in progress"), null, true);

        ReusableInputsWithSource forExecution = api().reusableInputs(namespace, id, TENANT, null);
        assertThat(forExecution.getRevision()).isEqualTo(1);
        assertThat(forExecution.getDraft()).isFalse();

        ReusableInputsWithSource latest = api().reusableInputs(namespace, id, TENANT, null, true);
        assertThat(latest.getRevision()).isEqualTo(2);
        assertThat(latest.getDraft()).isTrue();
        assertThat(latest.getDescription()).isEqualTo("in progress");
    }

    @Test
    void reusableInputs_draftsOnly() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id), null, true);

        assertThatThrownBy(() -> api().reusableInputs(namespace, id, TENANT, null))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> assertThat(((ApiException) e).getCode()).isEqualTo(422));
        assertThat(api().reusableInputs(namespace, id, TENANT, null, true).getDraft()).isTrue();
    }

    @Test
    void listReusableInputs_excludesDraftsOnlyUnlessAllowed() throws ApiException {
        String namespace = randomId();
        String published = randomId();
        String draftsOnly = randomId();
        create(namespace, published);
        api().createOrUpdateReusableInputs(namespace, published, TENANT, source(namespace, published, "in progress"), null, true);
        api().createOrUpdateReusableInputs(namespace, draftsOnly, TENANT, source(namespace, draftsOnly), null, true);

        PagedResultsReusableInputsWithSource forExecution = api().listReusableInputs(namespace, TENANT, null, null);
        assertThat(forExecution.getResults())
                .extracting(ReusableInputsWithSource::getId, ReusableInputsWithSource::getRevision)
                .containsExactly(tuple(published, 1));

        PagedResultsReusableInputsWithSource withDrafts = api().listReusableInputs(namespace, TENANT, null, null, true);
        assertThat(withDrafts.getResults())
                .extracting(ReusableInputsWithSource::getId, ReusableInputsWithSource::getDraft)
                .containsExactlyInAnyOrder(tuple(published, true), tuple(draftsOnly, true));
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

        ReusableInputsWithSource inherited = api().reusableInputs(child, id, TENANT, null);
        assertThat(inherited.getNamespace()).isEqualTo(parent);

        PagedResultsReusableInputsWithSource listed = api().listReusableInputs(child, TENANT, null, null);
        assertThat(listed.getTotal()).isEqualTo(1);
        assertThat(listed.getResults()).extracting(ReusableInputsWithSource::getId).containsExactly(id);
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

        PagedResultsReusableInputsWithSource all = api().listReusableInputs(namespace, TENANT, null, null);
        assertThat(all.getTotal()).isEqualTo(3);

        PagedResultsReusableInputsWithSource firstPage = api().listReusableInputs(namespace, TENANT, 1, 2);
        assertThat(firstPage.getTotal()).isEqualTo(3);
        assertThat(firstPage.getResults()).hasSize(2);
    }

    @Test
    void listReusableInputsRevisions() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        create(namespace, id);
        api().createOrUpdateReusableInputs(namespace, id, TENANT, source(namespace, id, "updated inputs"), null);

        List<ReusableInputsWithSource> revisions = api().listReusableInputsRevisions(namespace, id, TENANT);
        assertThat(revisions).hasSize(2);
        assertThat(revisions).extracting(ReusableInputsWithSource::getRevision).containsExactly(1, 2);

        ReusableInputsWithSource latest = api().reusableInputs(namespace, id, TENANT, null);
        assertThat(latest.getDescription()).isEqualTo("updated inputs");
        assertThat(latest.getRevision()).isEqualTo(2);
        assertThat(latest.getSource()).isEqualTo(source(namespace, id, "updated inputs"));
        assertThat(latest.getLast()).isTrue();

        ReusableInputsWithSource first = api().reusableInputs(namespace, id, TENANT, 1);
        assertThat(first.getDescription()).isEqualTo("shared inputs");
        assertThat(first.getRevision()).isEqualTo(1);
        assertThat(first.getLast()).as("a pinned older revision is no longer the current one").isFalse();
    }

    @Test
    void listReusableInputsNamespaces() throws ApiException {
        String namespace = randomId();
        create(namespace, randomId());

        List<String> namespaces = api().listReusableInputsNamespaces(TENANT);

        assertThat(namespaces).contains(namespace);
    }
}
