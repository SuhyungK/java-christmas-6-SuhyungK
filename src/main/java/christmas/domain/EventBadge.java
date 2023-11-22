package christmas.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum EventBadge {
    산타(benefitAmount -> benefitAmount >= 20_000),
    트리(benefitAmount -> benefitAmount >= 10_000),
    별(benefitAmount -> benefitAmount >= 5_000),
    없음(benefitAmount -> benefitAmount < 5_000);

    private final Predicate<Integer> find;

    EventBadge(Predicate<Integer> find) {
        this.find = find;
    }

    public static EventBadge of(int benefitAmount) {
        return Arrays.stream(EventBadge.values())
                     .filter(badge -> badge.find.test(benefitAmount))
                     .findFirst()
                     .orElse(없음);
    }
}
