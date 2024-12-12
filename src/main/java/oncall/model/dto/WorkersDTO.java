package oncall.model.dto;

import java.util.List;

public record WorkersDTO(List<String> weekdayWorker, List<String> holidayWorker) {
}
