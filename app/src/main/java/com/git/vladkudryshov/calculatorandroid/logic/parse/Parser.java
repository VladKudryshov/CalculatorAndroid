package com.git.vladkudryshov.calculatorandroid.logic.parse;

public class Parser {

    public static String splitExpression(String exp) {
        String splittedExp = "";
        exp = " " + exp;
        for (int i = 0; i < exp.length(); i++) {
            if ((exp.charAt(i) == '-' && !Character.isDigit(exp.charAt(i - 1))) || Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.') {
                splittedExp += exp.charAt(i);
            } else {
                splittedExp += " " + exp.charAt(i) + " ";
            }
        }
        return splittedExp.trim();
    }
}