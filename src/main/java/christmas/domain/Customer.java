package christmas.domain;

import java.util.Map;

public class Customer {
    int date;
    Map<String, Integer> orderMenu;

    Customer(int date, Map<String, Integer> orderMenu) {
        this.date = date;
        this.orderMenu = orderMenu;
    }

    public static Customer of(int date, Map<String, Integer> orderMenu) {
        return new Customer(date, orderMenu);
    }
}
