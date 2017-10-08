package com.git.vladkudryshov.calculatorandroid.logic.parse;

public final class Parser {

    public static String splitExpression(final String exp) {
        String splittedExp = "";
        final String temp = " " + exp;
        for (int i = 0; i < temp.length(); i++) {
            if ((temp.charAt(i) == '-' && !Character.isDigit(temp.charAt(i - 1))) || Character.isDigit(temp.charAt(i)) || temp.charAt(i) == '.') {
                splittedExp += temp.charAt(i);
            } else {
                splittedExp += " " + temp.charAt(i) + " ";
            }
        }
        return splittedExp.trim();
    }
}
