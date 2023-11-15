package christmas.view;

import christmas.domain.CustomerResult;
import christmas.utils.MenuList;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class OutputView {
    CustomerResult result;

    public OutputView(CustomerResult result) {
        this.result = result;
    }

    public static void printInputStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printResultStart() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public void printMenu() {
        System.out.println("<주문 메뉴>");
        result.customer.orderMenu.forEach((key, value) -> System.out.println(key + " " + value + "개"));
        System.out.println();
    }

    public void printTotalOrderAmount() {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n\n", result.totalOrderAmount);
    }

    public String printGiveaway() {
        System.out.println("<증정 메뉴>");
        System.out.println(result.printGiveaway() + "\n");
        return null;
    }

    public String printBenefit() {
        System.out.println("<혜택 내역>");
        if (result.discounts.values().stream().mapToInt(i -> i).sum() == 0) {
            return printDefault("없음\n");
        }
        result.discounts.forEach((discountType, price) -> {
            if (price != 0) System.out.printf("%s: -%,d원\n", discountType, price);
        });
        System.out.println();
        return null;
    }

    public String printTotalBenefitAmount() {
        System.out.println("<총혜택 금액>");
        if (result.totalBenefitAmount == 0) {
            return printDefault("0원\n");
        }
        System.out.printf("-%,d원\n\n", result.totalBenefitAmount);
        return null;
    }
    public String printPaymentAmount() {
        System.out.println("<할인 후 예상 결제 금액>");
        if (result.paymentAmount == 0) {
            return printDefault("0원");
        }
        System.out.printf("%,d원\n\n", result.paymentAmount);
        return null;
    }

    public void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(result.badge);
    }

    private static String printDefault(String defaultValue) {
        System.out.println(defaultValue);
        return null;
    }
}
