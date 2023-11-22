package christmas.utils;

import java.util.Arrays;

import static christmas.utils.MenuType.*;

public enum MenuList {
    양송이수프(에피타이저, 6_000),
    타파스(에피타이저, 5_500),
    시저샐러드(에피타이저, 8_000),
    티본스테이크(메인, 55_000),
    바비큐립(메인, 54_000),
    해산물파스타(메인, 35_000),
    크리스마스파스타(메인, 25_000),
    초코케이크(디저트, 15_000),
    아이스크립(디저트, 5_000),
    제로콜라(음료, 3_000),
    레드와인(음료, 60_000),
    샴페인(음료, 25_000),
    없음(MenuType.없음, 0);

    private final MenuType type;
    private final int price;

    MenuList(MenuType type, int price) {
        this.type = type;
        this.price = price;
    }

    public MenuType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static MenuList fromString(String value) {
        return Arrays.stream(MenuList.values())
                     .filter(menu -> menu.name()
                                         .equals(value))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.주문.toString()));
    }
}
