package com.git.vladkudryshov.calculatorandroid.logic.model;

public class Expression {

    private String strExp;
    private String postfixExp;

    public String getStrExp() {
        return strExp;
    }

    public void setStrExp(final String strExp) {
        this.strExp = strExp;
    }

    public String getPostfixExp() {
        return postfixExp;
    }

    public void setPostfixExp(final String postfixExp) {
        this.postfixExp = postfixExp;
    }
}