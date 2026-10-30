package io.kestra.sdk.model;

import io.kestra.sdk.internal.ApiClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateTypeTest {
    @Test
    void shouldReadThePausingStateOfAnApprovalRunningItsOnWaitTasks() throws Exception {
        StateType state = new ApiClient().getObjectMapper().readValue("\"PAUSING\"", StateType.class);

        assertEquals(StateType.PAUSING, state);
    }

    @Test
    void shouldReadThePausingCountOfDailyExecutionStatistics() throws Exception {
        DailyExecutionStatisticsExecutionCounts counts = new ApiClient().getObjectMapper()
            .readValue("{\"PAUSING\":3}", DailyExecutionStatisticsExecutionCounts.class);

        assertEquals(3L, counts.getPAUSING());
    }
}
