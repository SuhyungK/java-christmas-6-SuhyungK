package christmas.domain;

import christmas.constants.DiscountInfo;

import java.time.LocalDate;

public class DateDiscount {
    private static final int DDAY_START_AMOUNT = 1_000;
    private static final int DDAY_UNIT_AMOUNT = 100;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int SPECIAL_DATE = 25;
    private static final int SPECIAL_UNIT_AMOUNT = 1_000;


    public static int getDDayDiscount(int date) {
        if (date > EventInfo.DDAY_END_DATE.getNumber()) {
            return 0;
        }
        return DDAY_START_AMOUNT + --date * DDAY_UNIT_AMOUNT;

    }

    public static DiscountInfo getWeekInfo(int date) {
        int weekNumber = getWeekNumber(date);
        if (weekNumber == 5 || weekNumber == 6) {
            return DiscountInfo.주말;
        }
        return DiscountInfo.평일;
    }

    public static int getSpecialDiscount(int date) {
        if (getWeekNumber(date) == 7 || date == SPECIAL_DATE) {
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
