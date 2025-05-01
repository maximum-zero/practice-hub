package com.maximum0.calculator.operator;

import com.maximum0.calculator.PositiveNumber;

public class DivisionArithmeticOperator implements IArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        if (operand2.toInt() < 1) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
        return operand1.toInt() / operand2.toInt();
    }
}
