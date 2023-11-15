package christmas.domain;

import christmas.utils.MenuList;
import christmas.utils.MenuType;

import static christmas.domain.DateDiscount.*;

public class CustomerResult {
    Customer customer;
    int totalOrderAmount; // 할인 전 총주문 금액
    int totalBenefitAmount; // 할인 금액의 합계
    MenuList giveaway; // 증정품
    EventBadge badge; // 이벤트 배지

    public CustomerResult() {
        this.totalOrderAmount = calculateTotalAmount();
        this.giveaway = getGiveaway();
        this.totalBenefitAmount = calculateDiscountAmount();
        this.badge = getBadge();
    }

    public CustomerResult of(Customer customer) {
        this.customer = customer;
        return new CustomerResult();
    }

    public int calculateTotalAmount() {
        return customer.orderMenu.keySet()
                                 .stream()
                                 .mapToInt(i -> MenuList.fromString(i)
                                                        .getPrice())
                                 .sum() + giveaway.getPrice();
    }

    public int calculateDiscountAmount() {
        return getDDayDiscount(customer.date)
                + getSpecialDiscount(customer.date)
                + calculateWeekDayDiscountAmount(getDiscountMenuType(customer.date));
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
