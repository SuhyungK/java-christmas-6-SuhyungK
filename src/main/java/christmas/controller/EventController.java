package christmas.controller;

import christmas.domain.Customer;
import christmas.utils.Repeat;
import christmas.view.InputView;

import java.util.Map;

public class EventController {
    public void start() {
//
//        Customer customer = new Customer(date, orderMenu);
        int date = Repeat.readDataHandler(InputView::readDate);
        Map<String, Integer> orderMenu = Repeat.readMenuHandler(InputView::readOrderMenus);


    }
}
