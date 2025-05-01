package com.maximum0.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("사칙 연산을 수행한다.")
    @Test
    void calculateTest() {
        int result = Calculator.calculate(10, "+", 5);
        assertThat(result).isEqualTo(15);

        int result2 = Calculator.calculate(10, "-", 5);
        assertThat(result2).isEqualTo(5);

        int result3 = Calculator.calculate(10, "*", 5);
        assertThat(result3).isEqualTo(50);

        int result4 = Calculator.calculate(10, "/", 5);
        assertThat(result4).isEqualTo(2);
    }

    @DisplayName("사칙연산이 아닌 경우 ArithmeticException 예외를 발생시킵니다.")
    @Test
    void exceptionByNotOperator() {
        assertThatCode(() -> Calculator.calculate(10, "&", 5))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("올바른 사칙 연산이 아닙니다.");
    }

    @Test
    void exceptionByDivisionByZero() {
        assertThatCode(() -> Calculator.calculate(10, "/", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }
}
