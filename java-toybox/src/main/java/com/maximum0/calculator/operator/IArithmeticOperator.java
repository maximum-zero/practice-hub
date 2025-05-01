package com.maximum0.calculator.operator;

public interface IArithmeticOperator {
    int calculate(int operand1, int operand2);
    boolean support(String operator);
}
