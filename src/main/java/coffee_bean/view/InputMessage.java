package coffee_bean.view;

public enum InputMessage {
    INPUT_HEADER("\n[선호하는 커피 기호를 입력해주세요]"),
    INPUT_MESSAGE("입력 : "),
    ATTRIBUTE_FORMAT("\n%s [%.1f:%s ~ %.1f:%s]");

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
