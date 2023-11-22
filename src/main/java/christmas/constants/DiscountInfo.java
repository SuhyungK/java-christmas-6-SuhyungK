package christmas.constants;

import christmas.utils.MenuType;

public enum DiscountInfo {
    주말(MenuType.메인),
    평일(MenuType.디저트);

    private final MenuType type;
    DiscountInfo(MenuType type) {
        this.type = type;
    }

    public MenuType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
