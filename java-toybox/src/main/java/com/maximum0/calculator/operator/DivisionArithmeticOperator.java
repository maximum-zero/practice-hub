package com.maximum0.calculator.operator;

import com.maximum0.calculator.PositiveNumber;

public class DivisionArithmeticOperator implements IArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() / operand2.toInt();
    }
}
