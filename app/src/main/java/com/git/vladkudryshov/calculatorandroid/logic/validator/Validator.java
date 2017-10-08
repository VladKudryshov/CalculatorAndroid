package com.git.vladkudryshov.calculatorandroid.logic.validator;

import java.util.Stack;
import java.util.regex.Pattern;

public final class Validator {

    public static String checkErrorsExp(final String exp) {
        if (divideByZeroValidator(exp)) {
            return "Divide by zero!";
        }
        if (parenthesesValidator(exp)) {
            return "In expression parentheses unpaired!";
        }
        if (unCorrectExpValidator(exp)) {
            return "Expression isn't correct!";
        }
        return "Success";
    }

    private static boolean divideByZeroValidator(final CharSequence exp) {
        return Pattern.matches(".+/\\s*0[+\\-*/^()]*([^.]*)", exp) ||
                Pattern.matches(".+/\\((.*)-\\1\\)", exp) ||
                Pattern.matches(".+/\\((.*)*0\\)", exp);
    }

    private static boolean parenthesesValidator(final String exp) {
        final String temp = exp.replaceAll("[^()]*", "");
        if (temp.isEmpty()) {
            return false;
        }
        final Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(') {
                parenthesisStack.push('(');
            }
            if (temp.charAt(i) == ')') {
                if (parenthesisStack.isEmpty()) {
                    return true;
                }
                parenthesisStack.pop();
            }
        }
        return !parenthesisStack.isEmpty();
    }

    private static boolean unCorrectExpValidator(final CharSequence exp) {
        return !Pattern.matches("\\s*\\(*\\s*(-?\\d+|-?\\d+\\.\\d+)(\\s*[-+ */^]\\(*\\s*-?(\\d+|-?\\d+\\.\\d+)\\s*\\)*)*\\s*", exp);
    }

}
