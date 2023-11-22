package christmas.controller;

import christmas.domain.Customer;
import christmas.domain.CustomerResult;
import christmas.utils.Repeat;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class EventController {
    public void start() {
        OutputView.printInputStart();
        int date = Repeat.readDataHandler(InputView::readDate);
        Map<String, Integer> orderMenu = Repeat.readMenuHandler(InputView::readOrderMenus);
        OutputView.printResultStart();

        Customer customer = Customer.of(date, orderMenu);
        CustomerResult result = CustomerResult.of(customer);

        outputHandler(result);
    }


    private void outputHandler(CustomerResult result) {
        OutputView outputView = new OutputView(result);
        outputView.printMenu();
        outputView.printTotalOrderAmount();
        outputView.printGiveaway();
        outputView.printBenefit();
        outputView.printTotalBenefitAmount();
        outputView.printPaymentAmount();
        outputView.printEventBadge();
    }
}
