package christmas.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum EventBadge {
    SANTA(benefitAmount -> benefitAmount >= 20_000),
    TREE(benefitAmount -> benefitAmount >= 10_000),
    STAR(benefitAmount -> benefitAmount >= 5_000),
    NOTHING(benefitAmount -> benefitAmount < 5_000);

    private final Predicate<Integer> find;

    EventBadge(Predicate<Integer> find) {
        this.find = find;
    }

    public static EventBadge of(int benefitAmount) {
        return Arrays.stream(EventBadge.values())
                     .filter(badge -> badge.find.test(benefitAmount))
                     .findFirst()
                     .orElse(NOTHING);
    }
}
