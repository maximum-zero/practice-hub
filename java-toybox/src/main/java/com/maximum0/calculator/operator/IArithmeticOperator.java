package com.maximum0.calculator.operator;

import com.maximum0.calculator.PositiveNumber;

public interface IArithmeticOperator {
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
    boolean support(String operator);
}
