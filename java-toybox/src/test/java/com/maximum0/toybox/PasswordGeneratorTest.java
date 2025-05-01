package com.maximum0.toybox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordGeneratorTest {

    @DisplayName("비밀번호가 최소 8자 이상 12자 이하면 예외가 발생하지 않습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오육칠팔", "일이삼사오육일팔구십일이"})
    void validatePasswordTest(String password) {
        assertThatCode(() -> PasswordGenerator.validate(password))
            .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킵니다.")
    @ParameterizedTest
    @ValueSource(strings = {"일이삼", "일이삼사오육", "일이삼사오육일팔구십일이삼", "일이삼사오육일팔구십일이삼사오육칠팔구십"})
    void validatePasswordTestByException(String password) {
        assertThatCode(() -> PasswordGenerator.validate(password))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비밀번호가 최소 8자 이상 12자 이하여야 합니다.");
    }
}
