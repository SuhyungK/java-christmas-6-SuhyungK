package christmas.domain;

import christmas.utils.MenuType;

import java.time.LocalDate;

public class DateDiscount {
    private static final int DDAY_START_AMOUNT = 1_000;
    private static final int DDAY_UNIT_AMOUNT = 100;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int SPECIAL_DATE = 25;
    private static final int SPECIAL_UNIT_AMOUNT = 1_000;


    public static int getDDayDiscount(int date) {
        if (date > EventInfo.DDAY_END_DATE.getDate()) {
            return 0;
        }
        return DDAY_START_AMOUNT + --date * DDAY_UNIT_AMOUNT;

    }

    public static MenuType getDiscountMenuType(int date) {
        int weekNumber = getWeekNumber(date);
        if (weekNumber == 5 || weekNumber == 6) {
            return MenuType.메인;
        }
        return MenuType.디저트;
    }

    public static int getSpecialDiscount(int date) {
        if (getWeekNumber(date) == 6 || date == SPECIAL_DATE) {
            return SPECIAL_UNIT_AMOUNT;
        }
        return 0;
    }

    private static int getWeekNumber(int date) {
        return LocalDate.of(YEAR, MONTH, date)
                        .getDayOfWeek()
                        .getValue();
    }

}
