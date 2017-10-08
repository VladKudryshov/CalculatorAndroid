package com.git.vladkudryshov.calculatorandroid.logic.algorithm;

import java.util.Stack;

public final class PolishNotation {

    public static Double calculateExp(final String exp) {
        final Stack<Double> stack = new Stack<>();

        double numberTwo;
        double numberOne;

        for (final String token : exp.split(" ")) {
            Double decimal = null;
            try {
                decimal = Double.parseDouble(token);
            } catch (final NumberFormatException ignored) {
            }

            if (decimal != null) {
                stack.push(Double.parseDouble(token));
            } else if ("^".equals(token)) {
                numberTwo = stack.pop();
                numberOne = stack.pop();
                stack.push(Math.pow(numberOne, numberTwo));
            } else if ("*".equals(token)) {
                numberTwo = stack.pop();
                numberOne = stack.pop();
                stack.push(numberOne * numberTwo);
            } else if ("/".equals(token)) {
                numberTwo = stack.pop();
                numberOne = stack.pop();
                stack.push(numberOne / numberTwo);
            } else if ("+".equals(token)) {
                numberTwo = stack.pop();
                numberOne = stack.pop();
                stack.push(numberOne + numberTwo);
            } else if ("-".equals(token)) {
                numberTwo = stack.pop();
                numberOne = stack.pop();
                stack.push(numberOne - numberTwo);
            }
        }
        return stack.pop();
    }
}
