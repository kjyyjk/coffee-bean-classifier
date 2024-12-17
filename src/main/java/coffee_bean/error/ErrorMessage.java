package coffee_bean.error;

public enum ErrorMessage {
    INVALID_INPUT("잘못 입력하셨습니다\n"),
    INVALID_INPUT_RANGE("범위 내 올바른 값을 입력해주세요\n");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}