package com.maximum0.passwordgenerator;

public class PasswordGenerator {
    private final static String WRONG_PASSWORD_LENGTH_ERROR_MESSAGE = "비밀번호가 최소 8자 이상 12자 이하여야 합니다.";

    public static void validate(String password) {
        int length = password.length();
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_ERROR_MESSAGE);
        }
    }
}
