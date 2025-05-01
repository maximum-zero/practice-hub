package com.maximum0.calculator;

import com.maximum0.calculator.domain.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    @DisplayName("사칙 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        assertThat(Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2))).isEqualTo(result);
    }

    @DisplayName("사칙연산이 아닌 경우 ArithmeticException 예외를 발생시킵니다.")
    @Test
    void exceptionByNotOperator() {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "&", new PositiveNumber(5)))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("올바른 사칙 연산이 아닙니다.");
    }

    @Test
    void exceptionByDivisionByZero() {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
            arguments(10, "+", 5, 15),
            arguments(10, "-", 5, 5),
            arguments(10, "*", 5, 50),
            arguments(10, "/", 5, 2)
        );
    }
}
