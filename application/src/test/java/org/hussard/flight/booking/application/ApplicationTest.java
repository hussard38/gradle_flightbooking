package org.hussard.flight.booking.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTest {
    @Test
    void contextLoads(ApplicationContext context) {
        assertThat(context).isNotNull();
    }

}
