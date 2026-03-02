package io.kestra.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.model.Metric;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MetricModelTest {
    @Test
    void shouldDeserializeWorkerPendingMetricWithNumericValue() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Metric metric = mapper.readValue(
            "{\"name\":\"worker.job.pending\",\"type\":\"WORKER\",\"value\":3.5}",
            Metric.class
        );

        assertThat(metric.getName()).isEqualTo("worker.job.pending");
        assertThat(metric.getType()).isEqualTo("WORKER");
        assertThat(metric.getValue()).isEqualByComparingTo(new BigDecimal("3.5"));
    }

    @Test
    void shouldRejectObjectMetricValue() {
        ObjectMapper mapper = new ObjectMapper();

        assertThatThrownBy(() ->
            mapper.readValue(
                "{\"name\":\"worker.job.pending\",\"type\":\"WORKER\",\"value\":{\"pending\":3}}",
                Metric.class
            )
        ).isInstanceOf(Exception.class);
    }
}

