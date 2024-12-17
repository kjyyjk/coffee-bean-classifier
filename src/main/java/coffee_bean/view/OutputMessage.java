package coffee_bean.view;

public enum OutputMessage {
    WELCOME_MESSAGE(
            "\n기호에 맞는 커피 원두를 추천해드리는 원두 추천기입니다." +
            "\n원두의 종류는 원산지와 품종으로 구성되며,\n현재 추천해드리는 원두 종류는 다음과 같습니다." +
            "\n-Guatemala Bourbon\n-Mexico Typica\n-Mexico Bourbon\n-Colombia Caturra\n-Mexico Caturra\n-Guatemala Caturra"),
    CLASSIFY_RESULT_HEADER("\n======================================"),
    CLASSIFY_RESULT("추천드릴 원두는 '%s'입니다"),
    CLASSIFY_RESULT_FOOTER("======================================"),
    CLASSIFY_ACCURACY_EVALUATION("분류 정확도: %s");
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
