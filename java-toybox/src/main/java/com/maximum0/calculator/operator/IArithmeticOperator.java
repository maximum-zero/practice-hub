package com.maximum0.calculator.operator;

import com.maximum0.calculator.domain.PositiveNumber;

public interface IArithmeticOperator {
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
    boolean support(String operator);
}
