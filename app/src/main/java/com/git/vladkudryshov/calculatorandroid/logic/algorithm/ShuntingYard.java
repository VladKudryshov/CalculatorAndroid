package com.git.vladkudryshov.calculatorandroid.logic.algorithm;

import java.util.Stack;

public final class ShuntingYard {

    public static String infixToPostfix(final String infixExp) {
        final StringBuilder outPostfixExp = new StringBuilder();
        final Stack<Integer> priorityStack = new Stack<>();
        final Stack<String> symbolsStack = new Stack<>();
        for (final String token : infixExp.split(" ")) {
            if (token.isEmpty()) {
                continue;
            }
            final char charToken = token.charAt(0);
            final int priority = operatorPriority(charToken);
            if (Character.isDigit(charToken) || token.length() > 1) {
                outPostfixExp.append(token).append(" ");
                continue;
            }
            if (priority >= 0) {
                if (priorityStack.isEmpty()) {
                    priorityStack.push(priority);
                    symbolsStack.push(token);
                } else {
                    while (!priorityStack.isEmpty()) {
                        final int operationTwo = priorityStack.peek();
                        if (operationTwo > priority || operationTwo == priority) {
                            priorityStack.pop();
                            outPostfixExp.append(symbolsStack.pop()).append(" ");
                        } else {
                            break;
                        }
                    }
                    priorityStack.push(priority);
                    symbolsStack.push(token);
                }
                continue;
            }
            if (charToken == '(') {
                priorityStack.push(priority);
                symbolsStack.push(token);
            }
            if (charToken == ')') {
                while (!"(".equals(symbolsStack.peek())) {
                    outPostfixExp.append(symbolsStack.pop()).append(" ");
                    priorityStack.pop();
                }
                priorityStack.pop();
                symbolsStack.pop();
            }
        }
        while (!priorityStack.isEmpty()) {
            outPostfixExp.append(symbolsStack.pop()).append(" ");
            priorityStack.pop();
        }
        return outPostfixExp.toString();
    }

    private static Integer operatorPriority(final char operator) {
        switch (operator) {
            case '^':
                return 2;
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 0;
            case '-':
                return 0;
            default:
                return -1;
        }

    }

}
