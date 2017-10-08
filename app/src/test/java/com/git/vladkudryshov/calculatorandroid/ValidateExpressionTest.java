package com.git.vladkudryshov.calculatorandroid;

import com.git.vladkudryshov.calculatorandroid.logic.algorithm.PolishNotation;
import com.git.vladkudryshov.calculatorandroid.logic.algorithm.ShuntingYard;
import com.git.vladkudryshov.calculatorandroid.logic.model.Expression;
import com.git.vladkudryshov.calculatorandroid.logic.parse.Parser;
import com.git.vladkudryshov.calculatorandroid.logic.parse.ParserImpl;
import com.git.vladkudryshov.calculatorandroid.logic.validator.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidateExpressionTest {

    private static final double DELTA = 1e-15;

    @Test
    public void divideByZero() throws Exception {
        final String expression = "2/(2-2)";
        final String status = Validator.checkErrorsExp(expression);
        assertEquals(status, "Divide by zero!");
    }

    @Test
    public void PairedParentheses() throws Exception {
        final String expression = "2/(2-2+2))/1";
        final String status = Validator.checkErrorsExp(expression);
        assertEquals(status, "In expression parentheses unpaired!");
    }

    @Test
    public void unCorrectExpression() throws Exception {
        final String expression = "hello/2";
        final String status = Validator.checkErrorsExp(expression);
        assertEquals(status, "Expression isn't correct!");

    }

    @Test
    public void trueCalculate() throws Exception {
        final Expression data = new Expression();
        double result = 0.0;
        final String expression = "(2+2)*2";
        final String status = Validator.checkErrorsExp(expression);
        if ("Success".equals(status)) {
            final String temp = Parser.splitExpression(expression);
            data.setStrExp(temp);
            data.setPostfixExp(ShuntingYard.infixToPostfix(data.getStrExp()));
            result = PolishNotation.calculateExp(data.getPostfixExp());
        }
        assertEquals(result,8.0,DELTA);
    }






}