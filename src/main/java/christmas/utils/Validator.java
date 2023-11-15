package christmas.utils;

import christmas.domain.EventInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Validator {

    public static void isNumber(String data) {
        if (!data.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidDate(int data) {
        if (data < EventInfo.START_DATE.getDate() || data > EventInfo.END_DATE.getDate()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidMenu() {
        // TODO: 메뉴 유효성 검사
        // 1. - 으로 나눌 수 있는지
        // 2. 메뉴 이름이 메뉴판에 존재 하는지
        // 3. 메뉴의 개수는 숫자 인지
    }

    public static void isValidForm(String[] order) {
        if (order.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void isMenuExist(String orderMenu) {
        if (Arrays.stream(MenuList.values())
                  .noneMatch(menu -> menu.name()
                                         .equals(orderMenu))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplicatedMenu(HashMap<String, Integer> map, Map.Entry<String, Integer> entry) {
        if (map.containsKey(entry.getKey())) {
            throw new IllegalArgumentException();
        }
    }
}
