package oncall.view;

import java.util.List;

public class OutputView {
    private static final String REQUEST_MONTH_AND_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String REQUEST_WEEKDAY_WORKER = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String REQUEST_HOLIDAY_WORKER = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";


    public static void requestMonthAndDay() {
        System.out.print(REQUEST_MONTH_AND_DAY);
    }

    public static void requestWeekdayWorker() {
        System.out.print(REQUEST_WEEKDAY_WORKER);
    }

    public static void requestHolidayWorker() {
        System.out.print(REQUEST_HOLIDAY_WORKER);
    }

    public static void printResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }
}
