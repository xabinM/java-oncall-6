package oncall.validator;

import oncall.exception.Exception;

import java.util.List;

public class MonthAndDayInputValidator {
    public static void validateMonthAndDayInput(String[] input) {
        validateArrayLength(input);
        validateIsIntegerMonth(input[0]);
        validateMonthForm(input[0]);
        validateDayForm(input[1]);
    }

    private static void validateArrayLength(String[] input) {
        if (input.length != 2) {
            throw new IllegalArgumentException(Exception.INVALID_MONTH_AND_DAY_FORM.getMessage());
        }
    }

    private static void validateIsIntegerMonth(String month) {
        try {
            double transMonth = Double.parseDouble(month);
            if (transMonth % 1 != 0) {
                throw new IllegalArgumentException(Exception.INVALID_MONTH_AND_DAY_FORM.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_MONTH_AND_DAY_FORM.getMessage());
        }
    }

    private static void validateMonthForm(String month) {
        int transMonth = Integer.parseInt(month);
        if (transMonth > 12 || transMonth < 1) {
            throw new IllegalArgumentException(Exception.INVALID_MONTH_AND_DAY_FORM.getMessage());
        }
    }

    private static void validateDayForm(String day) {
        List<String> days = List.of("월", "화", "수", "목", "금", "토", "일");
        if (!days.contains(day)) {
            throw new IllegalArgumentException(Exception.INVALID_MONTH_AND_DAY_FORM.getMessage());
        }
    }
}
