package coffee_bean.error;

import static coffee_bean.error.ErrorMessage.INVALID_INPUT;
import static coffee_bean.error.ErrorMessage.INVALID_INPUT_RANGE;

import coffee_bean.NumericAttribute;

public class Validator {
    public static void validateInputRange(final NumericAttribute attribute, final double input) {
        if (input < attribute.getMinValue() || input > attribute.getMaxValue()) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE.getMessage());
        }
    }

    public static void validateNominalAttributeIndex(final int index) {
        if (index == -1) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
