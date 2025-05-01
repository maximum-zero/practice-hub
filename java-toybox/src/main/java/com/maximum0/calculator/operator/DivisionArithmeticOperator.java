package com.maximum0.calculator.operator;

public class DivisionArithmeticOperator implements IArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 < 1) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
        return operand1 / operand2;
    }
}
