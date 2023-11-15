package christmas.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Repeat {
    public static int readDataHandler(Supplier<String> supplier) {
        try {
            String data = supplier.get();
            Validator.isNotEmpty(data);
            Validator.isNumber(data);
            Validator.isValidDate(Integer.parseInt(data));
            return Integer.parseInt(data);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.날짜);
            return readDataHandler(supplier);
        }
    }

    public static Map<String, Integer> readMenuHandler(Supplier<String> supplier) {
        try {
            String data = supplier.get();
            Validator.isNotEmpty(data);
            return Arrays.stream(data.split(","))
                         .map(each -> {
                             String[] order = each.split("-");
                             Validator.isValidForm(order);
                             Validator.isMenuExist(order[0]);
                             Validator.isNumber(order[1]);
                             return Map.entry(order[0], Integer.parseInt(order[1]));
                         })
                         .collect(HashMap::new,
                                 (map, entry) -> {
                                    Validator.isDuplicatedMenu(map, entry);
                                    map.put(entry.getKey(), entry.getValue());
                                 },
                                 HashMap::putAll);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.주문);
            return new HashMap<>();
        }
    }
}
