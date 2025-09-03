package io.kestra.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicSDKUsageExampleTest {
    @Test
    void test_getInstanceConfEdition() {
        assertEquals("OSS", BasicSDKUsageExample.getInstanceConfEdition());
    }
    @Test
    void test_listFlows() {
        BasicSDKUsageExample.listFlows();
    }
}

