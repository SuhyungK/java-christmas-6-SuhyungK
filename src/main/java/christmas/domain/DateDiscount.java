package christmas.domain;

import java.time.LocalDate;

public class DateDiscount {
    private static final int DDAY_START_AMOUNT = 1_000;
    private static final int DDAY_UNIT_AMOUNT = 100;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;


    public static int getDDayDiscount(int date) {
        if (date > EventInfo.DDAY_END_DATE.getDate()) {
            return 0;
        }
        return DDAY_START_AMOUNT + --date * DDAY_UNIT_AMOUNT;

    }
    

}
