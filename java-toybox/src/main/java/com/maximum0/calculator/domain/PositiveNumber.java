package com.maximum0.calculator.domain;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        isPositiveNumber(value);
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    private void isPositiveNumber(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }
}
