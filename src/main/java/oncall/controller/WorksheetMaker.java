package oncall.controller;

import oncall.view.InputView;
import oncall.view.OutputView;

public class WorksheetMaker {
    public void runWorksheetMaker() {
        processRequestInput();
    }

    private void processRequestInput() {
        requestMonthAndDay();
        while (true){
            try {
                requestWeekdayWorker();
                requestHolidayWorker();
                return;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] requestMonthAndDay() {
        while (true){
            try {
                OutputView.requestMonthAndDay();
                return InputView.requestMonthAndDay();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void requestWeekdayWorker() {
        OutputView.requestWeekdayWorker();
        InputView.requestWeekdayWorker();
    }

    private void requestHolidayWorker() {
        OutputView.requestHolidayWorker();
        InputView.requestHolidayWorker();
    }
}
