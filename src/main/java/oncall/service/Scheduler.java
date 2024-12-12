package oncall.service;

import oncall.model.MonthSchedule;
import oncall.model.dto.MonthAndDayDTO;
import oncall.model.dto.WorkersDTO;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final int month;
    private final List<String> weekdayWorkers;
    private final List<String> holidayWorkers;
    private String currentDayOfWeek;
    private static final List<String> allDayOfWeek = List.of("일", "월", "화", "수", "목", "금", "토");
    private String yesterdayWorker = "";

    public Scheduler(MonthAndDayDTO monthAndDayDTO, WorkersDTO workersDTO) {
        this.month = monthAndDayDTO.month();
        this.currentDayOfWeek = monthAndDayDTO.day();
        this.weekdayWorkers = workersDTO.weekdayWorker();
        this.holidayWorkers = workersDTO.holidayWorker();
    }

    public List<String> makeMonthSchedule() {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= MonthSchedule.getMonthScheduleByMonth(month).getDay(); i++) {
            String worker = pickTodayWorker(i);
            if (MonthSchedule.getMonthScheduleByMonth(month).isHoliday(i)) {
                String result = month + "월 " + i + "일 " + currentDayOfWeek + "(휴일) " + worker;
                results.add(result);
                currentDayOfWeek = getNextDayOfWeek();
                continue;
            }
            String result = month + "월 " + i + "일 " + currentDayOfWeek + " " + worker;
            results.add(result);
            currentDayOfWeek = getNextDayOfWeek();
        }
        return results;
    }

    private String pickTodayWorker(int day) {
        if (currentDayOfWeek.equals("토") || currentDayOfWeek.equals("일") ||
                MonthSchedule.getMonthScheduleByMonth(month).isHoliday(day)) {
            return getWorker(holidayWorkers);
        }
        return getWorker(weekdayWorkers);
    }

    private String getWorker(List<String> workers) {
        String worker;
        if (workers.get(0).equals(yesterdayWorker)) {
            worker = workers.get(1);
            rotateWorker(workers, 1);
            yesterdayWorker = worker;
            return worker;
        }
        worker = workers.get(0);
        rotateWorker(workers, 0);
        yesterdayWorker = worker;
        return worker;
    }

    private void rotateWorker(List<String> workers, int index) {
        String worker = workers.get(index);
        workers.remove(index);
        workers.add(worker);
    }

    private String getNextDayOfWeek() {
        int nextDayIndex = (allDayOfWeek.indexOf(currentDayOfWeek) + 1) % allDayOfWeek.size();
        return allDayOfWeek.get(nextDayIndex);
    }
}
