package coffee_bean.view;

import static coffee_bean.view.InputMessage.ATTRIBUTE_FORMAT;
import static coffee_bean.view.InputMessage.INPUT_HEADER;
import static coffee_bean.view.InputMessage.INPUT_MESSAGE;

import coffee_bean.NumericAttribute;
import coffee_bean.error.Validator;
import java.util.Scanner;
import weka.core.Attribute;
import weka.core.Instances;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static double[] getAttributeInputValues(final Instances data) {
        String[] inputValues = getInputs(data);
        return convertUserInputToAttributes(data, inputValues);
    }

    private static String[] getInputs(final Instances data) {
        String[] inputs = new String[data.numAttributes() - 1];
        System.out.println(INPUT_HEADER.getMessage());
        for (int i = 0; i < data.numAttributes() - 1; i++) {
            String attributeName = data.attribute(i).name();
            NumericAttribute attribute = NumericAttribute.valueOf(attributeName);
            double attributeValue = getInput(attribute);
            inputs[i] = String.valueOf(attributeValue);
        }
        return inputs;
    }

    private static double getInput(final NumericAttribute attribute) {
        try {
            printAttribute(attribute);
            double input = inputValue();
            Validator.validateInputRange(attribute, input);
            return input;
        } catch (IllegalArgumentException e) {
            Output.printError(e);
            return getInput(attribute);
        }
    }

    private static double inputValue() {
        System.out.print(INPUT_MESSAGE.getMessage());
        return scanner.nextDouble();
    }

    private static void printAttribute(final NumericAttribute attribute) {
        String name = attribute.getName();
        double minValue = attribute.getMinValue();
        String minDescription = attribute.getMinDescription();
        double maxValue = attribute.getMaxValue();
        String maxDescription = attribute.getMaxDescription();
        String message = ATTRIBUTE_FORMAT.getMessage()
                .formatted(name, minValue, minDescription, maxValue, maxDescription);
        System.out.println(message);
    }

    private static double[] convertUserInputToAttributes(final Instances data, final String[] inputValues) {
        double[] values = new double[data.numAttributes()];
        for (int i = 0; i < data.numAttributes() - 1; i++) {
            values[i] = getValue(data.attribute(i), inputValues[i]);
        }
        return values;
    }

    private static double getValue(final Attribute attribute, final String inputValue) {
        if (attribute.isNumeric()) {
            return Double.parseDouble(inputValue);
        }
        return getNominalAttributeIndex(attribute, inputValue);
    }

    private static int getNominalAttributeIndex(final Attribute attribute, final String inputValue) {
        int index = attribute.indexOfValue(inputValue);
        Validator.validateNominalAttributeIndex(index);
        return index;
    }
}
