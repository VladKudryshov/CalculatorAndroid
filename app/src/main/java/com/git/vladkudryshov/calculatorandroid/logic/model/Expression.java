package com.git.vladkudryshov.calculatorandroid.logic.model;

public class Expression {
    private String strExp;
    private Double finalValue;
    private String postfixExp;

    public String getStrExp() {
        return strExp;
    }

    public void setStrExp(String strExp) {
        this.strExp = strExp;
    }

    public Double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(Double finalValue) {
        this.finalValue = finalValue;
    }

    public String getPostfixExp() {
        return postfixExp;
    }

    public void setPostfixExp(String postfixExp) {
        this.postfixExp = postfixExp;
    }
}