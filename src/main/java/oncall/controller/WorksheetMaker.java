package oncall.controller;

import oncall.model.dto.MonthAndDayDTO;
import oncall.model.dto.WorkersDTO;
import oncall.service.Scheduler;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorksheetMaker {
    public void runWorksheetMaker() {
        MonthAndDayDTO monthAndDay = processRequestMonthAndDay();
        WorkersDTO workersDTO = processRequestWorkerNames();
        processMakeWorksheet(monthAndDay, workersDTO);
    }

    private MonthAndDayDTO processRequestMonthAndDay() {
        while (true){
            try {
                OutputView.requestMonthAndDay();
                String[] monthAndDay = InputView.requestMonthAndDay();
                return new MonthAndDayDTO(Integer.parseInt(monthAndDay[0]), monthAndDay[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WorkersDTO processRequestWorkerNames() {
        while (true){
            try {
                return new WorkersDTO(requestWeekdayWorker(), requestHolidayWorker());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> requestWeekdayWorker() {
        OutputView.requestWeekdayWorker();
        return new ArrayList<>(Arrays.asList(InputView.requestWeekdayWorker()));
    }

    private List<String> requestHolidayWorker() {
        OutputView.requestHolidayWorker();
        return new ArrayList<>(Arrays.asList(InputView.requestHolidayWorker()));
    }


    private void processMakeWorksheet(MonthAndDayDTO monthAndDayDTO, WorkersDTO workersDTO) {
        List<String> resultWorksheet = new Scheduler(monthAndDayDTO, workersDTO).makeMonthSchedule();
        OutputView.printResult(resultWorksheet);
    }
}
