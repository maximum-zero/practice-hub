package com.maximum0.calculator.operator;

import com.maximum0.calculator.domain.PositiveNumber;

public class MultiplicationArithmeticOperator implements IArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "*".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() * operand2.toInt();
    }
}
