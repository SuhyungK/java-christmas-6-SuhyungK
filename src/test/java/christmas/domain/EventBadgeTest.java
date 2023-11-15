package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EventBadgeTest {
    @Test
    void 일만원_이만원_사이일_때() {
        assertThat(EventBadge.of(12_000)).isEqualTo(EventBadge.트리);
    }

    @Test
    void 일만원일_때() {
        assertThat(EventBadge.of(10_000)).isEqualTo(EventBadge.트리);
    }

    @Test
    void 해당되는_배지가_없을_때() {
        assertThat(EventBadge.of(4_900)).isEqualTo(EventBadge.없음);
    }
}