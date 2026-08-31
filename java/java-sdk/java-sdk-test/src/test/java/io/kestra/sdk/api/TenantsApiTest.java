package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

public class TenantsApiTest {

    static TenantsApi api() {
        return client().tenants();
    }

    static Tenant newTenant(String id) {
        return new Tenant()
                .id(id)
                .name("SDK test tenant " + id)
                .deleted(false)
                .concurrency(new Concurrency()
                        .limit(5)
                        .behavior(ConcurrencyBehavior.QUEUE))
                .addQuotasItem(new Quota()
                        .duration("PT1H")
                        .limit(100L)
                        .behavior(QuotaBehavior.FAIL));
    }

    static void deleteQuietly(String id) {
        try {
            api().deleteTenant(id);
        } catch (ApiException ignored) {
        }
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createTenant_roundTripsConcurrencyAndQuotas() throws ApiException {
        String id = randomId();
        try {
            Tenant created = api().createTenant(newTenant(id));

            assertThat(created.getId()).isEqualTo(id);
            assertThat(created.getConcurrency()).isNotNull();
            assertThat(created.getConcurrency().getLimit()).isEqualTo(5);
            assertThat(created.getConcurrency().getBehavior()).isEqualTo(ConcurrencyBehavior.QUEUE);
            assertThat(created.getQuotas()).hasSize(1);

            Tenant fetched = api().tenant(id);

            assertThat(fetched.getId()).isEqualTo(id);
            assertThat(fetched.getName()).isEqualTo("SDK test tenant " + id);
            assertThat(fetched.getConcurrency()).isNotNull();
            assertThat(fetched.getConcurrency().getLimit()).isEqualTo(5);
            assertThat(fetched.getConcurrency().getBehavior()).isEqualTo(ConcurrencyBehavior.QUEUE);
            assertThat(fetched.getQuotas()).hasSize(1);
            assertThat(fetched.getQuotas().get(0).getDuration()).isEqualTo("PT1H");
            assertThat(fetched.getQuotas().get(0).getLimit()).isEqualTo(100L);
            assertThat(fetched.getQuotas().get(0).getBehavior()).isEqualTo(QuotaBehavior.FAIL);
        } finally {
            deleteQuietly(id);
        }
    }

    @Test
    void updateTenant_basic() throws ApiException {
        String id = randomId();
        try {
            api().createTenant(newTenant(id));

            Tenant updated = api().updateTenant(id, newTenant(id)
                    .name("Renamed " + id)
                    .concurrency(new Concurrency()
                            .limit(10)
                            .behavior(ConcurrencyBehavior.FAIL)));

            assertThat(updated.getName()).isEqualTo("Renamed " + id);
            assertThat(updated.getConcurrency().getLimit()).isEqualTo(10);
            assertThat(updated.getConcurrency().getBehavior()).isEqualTo(ConcurrencyBehavior.FAIL);

            Tenant fetched = api().tenant(id);
            assertThat(fetched.getName()).isEqualTo("Renamed " + id);
            assertThat(fetched.getConcurrency().getLimit()).isEqualTo(10);
        } finally {
            deleteQuietly(id);
        }
    }

    @Test
    void deleteTenant_basic() throws ApiException {
        String id = randomId();
        api().createTenant(newTenant(id));

        api().deleteTenant(id);

        assertThatThrownBy(() -> api().tenant(id))
                .isInstanceOf(ApiException.class)
                .extracting(e -> ((ApiException) e).getCode())
                .isEqualTo(404);
    }

    @Test
    void tenant_unknownId() {
        assertThatThrownBy(() -> api().tenant(randomId()))
                .isInstanceOf(ApiException.class)
                .extracting(e -> ((ApiException) e).getCode())
                .isEqualTo(404);
    }

    @Test
    void createTenant_invalidId() {
        assertThatThrownBy(() -> api().createTenant(newTenant("UPPERCASE-" + randomId())))
                .isInstanceOf(ApiException.class)
                .extracting(e -> ((ApiException) e).getCode())
                .isEqualTo(422);
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchTenants_findsCreated() throws ApiException {
        String id = randomId();
        try {
            api().createTenant(newTenant(id));

            PagedResultsTenant results = api().searchTenants(1, MAX_PAGE_SIZE, null, null);

            assertThat(results.getTotal()).isGreaterThanOrEqualTo(1);
            assertThat(results.getResults())
                    .anySatisfy(tenant -> assertThat(tenant.getId()).isEqualTo(id));
        } finally {
            deleteQuietly(id);
        }
    }

    @Test
    void searchTenants_withSort() throws ApiException {
        PagedResultsTenant results = api().searchTenants(1, 10, java.util.List.of("id:asc"), null);

        assertThat(results.getResults()).isNotNull();
    }
}
