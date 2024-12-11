package oncall.controller;

import oncall.view.InputView;
import oncall.view.OutputView;

public class WorksheetMaker {
    public void runWorksheetMaker() {
        processRequestInput();
    }

    private void processRequestInput() {
        requestMonthAndDay();
        requestWeekdayWorker();
        requestHolidayWorker();
    }

    private void requestMonthAndDay() {
        OutputView.requestMonthAndDay();
        InputView.requestMonthAndDay();
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
