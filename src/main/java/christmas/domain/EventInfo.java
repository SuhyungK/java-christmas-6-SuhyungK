package christmas.domain;

public enum EventInfo {
    START_DATE(1),
    END_DATE(31),
    DDAY_END_DATE(25),
    DISCOUNT_PRCIE_UNIT(2_023),
    MINIMUM_EVENT_AMOUNT(10_000),
    MINIMUM_GIVEAWAY_EVENT_AMOUNT(120_000),
    MINIMUM_MENU_COUNT(20);

    private final int number;

    EventInfo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
