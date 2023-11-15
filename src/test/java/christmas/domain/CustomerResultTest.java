package christmas.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CustomerResultTest {
    private static Customer customer;
    @BeforeAll
    static void beforeAll() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("해산물파스타", 2);
        orderMenu.put("레드와인", 1);
        orderMenu.put("초코케이크", 1);
        customer = Customer.of(31, orderMenu);
    }

    @Test
    void name() {
        CustomerResult result = CustomerResult.of(customer);
        assertThat(result.calculateTotalAmount()).isEqualTo(145_000);
    }
}