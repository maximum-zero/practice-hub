package com.maximum0.toybox;

public class PasswordGenerator {
    public static void validate(String password) {
        if (password.length() < 8 || password.length() > 12) {
            throw new IllegalArgumentException("비밀번호가 최소 8자 이상 12자 이하여야 합니다.");
        }
    }
}
