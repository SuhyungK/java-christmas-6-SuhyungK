package christmas.domain;

import christmas.constants.DiscountInfo;
import christmas.utils.MenuList;
import christmas.utils.MenuType;
import christmas.utils.Repeat;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.DateDiscount.*;

public class CustomerResult {
    public Customer customer;
    public int totalOrderAmount; // 할인 전 총주문 금액
    public int totalBenefitAmount; // 할인 금액의 합계
    public Map<String, Integer> discounts;
    public MenuList giveaway = MenuList.없음;
    public EventBadge badge; // 이벤트 배지
    private Map<MenuType, Integer> menuTypeList = new HashMap<>();

    public CustomerResult(Customer customer) {
        this.customer = customer;
        this.totalOrderAmount = calculateTotalAmount();
        if (this.totalOrderAmount >= EventInfo.MINIMUM_EVENT_AMOUNT.getNumber()) {
            this.giveaway = getGiveaway();
            discounts.put("크리스마스 디데이 할인", getDDayDiscount(customer.date));
            DiscountInfo weekInfo = getWeekInfo(customer.date);
            discounts.put(weekInfo.toString() + " 할인", calculateWeekDayDiscountAmount(weekInfo.getType()));
            discounts.put("특별 할인", getSpecialDiscount(customer.date));
            discounts.put("증정 이벤트", giveaway.getPrice());
            this.totalBenefitAmount = discounts.values().stream().mapToInt(i -> i).sum();
        }
        this.badge = getBadge();
        Repeat.readMenuHandler(InputView::readOrderMenus);
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

    public String printGiveaway() {
        if (giveaway.getType() == MenuType.없음) return "없음";
        return giveaway.name() + " 1개";
    }

    private int calculateWeekDayDiscountAmount(MenuType type) {
        return customer.orderMenu.keySet()
                                 .stream()
                                 .mapToInt(i -> {
                                     MenuList thisMenu = MenuList.fromString(i);
                                     if (thisMenu.getType() == type) {
                                         return EventInfo.DISCOUNT_PRCIE_UNIT.getNumber();
                                     }
                                     return 0;
                                 })
                                 .sum();
    }

    private MenuList getGiveaway() {
        if (totalOrderAmount >= EventInfo.MINIMUM_GIVEAWAY_EVENT_AMOUNT.getNumber()) {
            return MenuList.샴페인;
        }
        return MenuList.없음;
    }

    private EventBadge getBadge() {
        return EventBadge.of(totalBenefitAmount);
    }
}
