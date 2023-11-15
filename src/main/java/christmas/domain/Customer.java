package christmas.domain;

import java.util.Map;

public class Customer {
    int date;
    Map<String, Integer> orderMenu;

    Customer(int date, Map<String, Integer> orderMenu) {
        this.date = date;
        this.orderMenu = orderMenu;
    }
}
