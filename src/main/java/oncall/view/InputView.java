package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.validator.MonthAndDayInputValidator;

public class InputView {
    public static String[] requestMonthAndDay() {
        String input = Console.readLine().trim();
        String[] monthAndDay = separateByComma(input);
        MonthAndDayInputValidator.validateMonthAndDayInput(monthAndDay);
        return monthAndDay;
    }

    public static String[] requestWeekdayWorker() {
        String input = Console.readLine().trim();
        return separateByComma(input);
    }

    public static String[] requestHolidayWorker() {
        String input = Console.readLine().trim();
        return separateByComma(input);
    }

    private static String[] separateByComma(String input) {
        return input.split(",");
    }
}
