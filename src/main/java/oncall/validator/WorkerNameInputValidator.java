package oncall.validator;

import oncall.exception.Exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorkerNameInputValidator {
    public static void validateWorkerNames(String[] names) {
        validateNameCount(names);
        validateNameLength(names);
        validateNameDuplication(names);
    }

    private static void validateNameCount(String[] names) {
        if (names.length > 35 || names.length < 5) {
            throw new IllegalArgumentException(Exception.INVALID_WORKER_NAME_COUNT.getMessage());
        }
    }

    private static void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5 || name.isBlank()) {
                throw new IllegalArgumentException(Exception.INVALID_WORKER_NAME_LENGTH.getMessage());
            }
        }
    }

    private static void validateNameDuplication(String[] names) {
        Set<String> tempNames = new HashSet<>(Arrays.asList(names));
        if (names.length != tempNames.size()) {
            throw new IllegalArgumentException(Exception.INVALID_WORKER_NAME_DUPLICATION.getMessage());
        }
    }
}
