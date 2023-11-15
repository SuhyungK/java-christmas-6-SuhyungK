package christmas.domain;

public enum EventInfo {
    START_DATE(1),
    END_DATE(31);

    private final int date;

    EventInfo(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
