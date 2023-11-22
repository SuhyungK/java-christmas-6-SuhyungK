package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class DateDiscountTest {
    @Test
    void 삼일이_특별할인_되는지_테스트() {
        assertThat(DateDiscount.getSpecialDiscount(3)).isEqualTo(1_000);
    }

    @Test
    void 크리스마스에_특별할인_되는지_테스트() {
        assertThat(DateDiscount.getSpecialDiscount(25)).isEqualTo(1_000);

    }

    @Test
    void 십구일이_특별할인_안_되는지_테스트() {
        assertThat(DateDiscount.getSpecialDiscount(19)).isEqualTo(0);
    }
}