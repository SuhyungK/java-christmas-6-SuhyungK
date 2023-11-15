package christmas.view;

import christmas.domain.CustomerResult;

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
        result.customer.orderMenu.forEach((key, value) -> System.out.println(key + " " + value + "개\n"));
    }

    public void printTotalOrderAmount() {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(result.totalOrderAmount + "원\n");
    }

    public void printGiveaway() {
//        if (result.giveaway.getType() == "없음")
    }

    public void printBenefit() {
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: -");
        System.out.println("평일 할인: -");
        System.out.println("특별 할인: -");
        System.out.println("증정 이벤트: -");

        System.out.println("\n<총혜택 금액>");
    }

    public void printPaymentAmount() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(result.badge);
    }


}
