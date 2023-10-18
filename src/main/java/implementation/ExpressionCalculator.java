package implementation;

import calculator.Calculator;
import validation.Validator;

public class ExpressionCalculator {

    private final Calculator calculator;

    private final Validator validator;

    public ExpressionCalculator(Calculator calculator, Validator validator) {
        this.calculator = calculator;
        this.validator = validator;
    }

    public double calculate(String expression) {
        String nonEmptyCharsExpression = expression.replaceAll("\\s", "");

        try {
            validator.validate(nonEmptyCharsExpression);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this.calculator.calculate(nonEmptyCharsExpression);
    }
}
