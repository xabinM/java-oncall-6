package oncall.controller;

import oncall.model.dto.MonthAndDayDTO;
import oncall.model.MonthSchedule;
import oncall.model.dto.WorkersDTO;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class WorksheetMaker {
    public void runWorksheetMaker() {
        MonthAndDayDTO monthAndDay = processRequestMonthAndDay();
        WorkersDTO workersDTO = processRequestWorkerNames();
    }
    // 위에놈 두개를 주입 받아서 객체를 새로 만들고 필요한 인스턴스 변수 쫙만든다음에 그안에서 그냥 다처리하자

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
        return Arrays.asList(InputView.requestWeekdayWorker());
    }

    private List<String> requestHolidayWorker() {
        OutputView.requestHolidayWorker();
        return Arrays.asList(InputView.requestHolidayWorker());
    }

}
