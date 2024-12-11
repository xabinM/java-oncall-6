package oncall.exception;

public enum Exception {
    INVALID_MONTH_FORM("1부터 12까지의 숫자와 월, 화, 수, 목, 금, 토, 일 중에 하나를 쉼표(,)로 구분지어 입력해주세요."),
    INVALID_WORKER_NAME_LENGTH("비상 근무자의 닉네임은 최대 5글자 입니다."),
    INVALID_WORKER_NAME_DUPLICATION("비상 근무자의 닉네임은 중복될 수 없습니다."),
    INVALID_WORKER_NAME_COUNT("비상 근무자는 최소 5명 최대 35명 입니다.");

    private final String message;
    private static final String PREFIX = "[ERROR] ";

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
