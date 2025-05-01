package com.maximum0.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveNumberTest {

    @DisplayName("양수만 전달할 수 있습니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10, 999, 10000})
    void createWhenPositiveNumber(int value) {
        assertThatCode(() -> new PositiveNumber(value))
            .doesNotThrowAnyException();
    }

    @DisplayName("0 또는 음수를 전달할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -999})
    void throwsExceptionWhenZeroOrNegative() {
        assertThatCode(() -> new PositiveNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }
}
