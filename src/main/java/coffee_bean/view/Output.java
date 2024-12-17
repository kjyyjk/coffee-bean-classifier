package coffee_bean.view;

import static coffee_bean.view.OutputMessage.CLASSIFY_ACCURACY_EVALUATION;
import static coffee_bean.view.OutputMessage.CLASSIFY_RESULT;
import static coffee_bean.view.OutputMessage.CLASSIFY_RESULT_FOOTER;
import static coffee_bean.view.OutputMessage.CLASSIFY_RESULT_HEADER;
import static coffee_bean.view.OutputMessage.WELCOME_MESSAGE;

import weka.classifiers.Evaluation;

public class Output {
    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE.getMessage());
    }

    public static void printClassifyResult(final String classifyResult) {
        System.out.println(CLASSIFY_RESULT_HEADER.getMessage());
        String message = CLASSIFY_RESULT.getMessage();
        System.out.println(message.formatted(classifyResult));
        System.out.println(CLASSIFY_RESULT_FOOTER.getMessage());
    }

    public static void printEvaluation(final Evaluation evaluation) {
        String summaryString = evaluation.toSummaryString();
        String message = CLASSIFY_ACCURACY_EVALUATION.getMessage();
        System.out.println(message.formatted(summaryString));
    }

    public static void printError(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
