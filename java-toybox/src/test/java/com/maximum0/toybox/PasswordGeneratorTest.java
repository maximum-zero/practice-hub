package com.maximum0.toybox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordGeneratorTest {

    @DisplayName("비밀번호가 최소 8자 이상 12자 이하면 예외가 발생하지 않습니다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordGenerator.validate("일이삼사오육칠팔"))
            .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킵니다.")
    @Test
    void validatePasswordTestByException() {
        assertThatCode(() -> PasswordGenerator.validate("일이삼사오육칠"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비밀번호가 최소 8자 이상 12자 이하여야 합니다.");
    }
}
