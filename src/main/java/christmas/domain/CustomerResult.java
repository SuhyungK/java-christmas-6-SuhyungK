package christmas.domain;

import christmas.utils.MenuList;
import christmas.utils.MenuType;

import java.awt.*;
import java.util.Map;

import static christmas.domain.DateDiscount.*;

public class CustomerResult {
    public Customer customer;
    public int totalOrderAmount; // 할인 전 총주문 금액
    public int totalBenefitAmount; // 할인 금액의 합계
    public MenuList giveaway; // 증정품
    public EventBadge badge; // 이벤트 배지
    private Map<MenuType, Integer> menuTypeList;

    public CustomerResult(Customer customer) {
        this.customer = customer;
        this.totalOrderAmount = calculateTotalAmount();
        this.giveaway = getGiveaway();
        this.totalBenefitAmount = calculateDiscountAmount();
        this.badge = getBadge();
    }

    public static CustomerResult of(Customer customer) {
        return new CustomerResult(customer);
    }

    public int calculateTotalAmount() {
        return customer.orderMenu.entrySet()
                                 .stream()
                                 .mapToInt(i -> {
                                     MenuList menu = MenuList.fromString(i.getKey());
                                     menuTypeList.put(menu.getType(), i.getValue());
                                     return menu
                                             .getPrice() * i.getValue();
                                 })
                                 .sum();
    }

    public int calculateDiscountAmount() {
        return getDDayDiscount(customer.date)
                + getSpecialDiscount(customer.date)
                + calculateWeekDayDiscountAmount(getDiscountMenuType(customer.date)) + giveaway.getPrice();
    }

    private int calculateWeekDayDiscountAmount(MenuType type) {
        return customer.orderMenu.keySet()
                                 .stream()
                                 .mapToInt(i -> {
                                     MenuList thisMenu = MenuList.fromString(i);
                                     if (thisMenu.getType() == type) {
                                         return EventInfo.DISCOUNT_PRCIE_UNIT.getDate();
                                     }
                                     return 0;
                                 })
                                 .sum();
    }

    private MenuList getGiveaway() {
        if (totalOrderAmount >= EventInfo.MINIMUM_GIVEAWAY_EVENT_AMOUNT.getDate()) {
            return MenuList.샴페인;
        }
        return MenuList.없음;
    }

    private EventBadge getBadge() {
        return EventBadge.of(totalBenefitAmount);
    }
}
