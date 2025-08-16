package com.example.exception;

public class NameNotBlankException extends RuntimeException {

    private static final String INPUT_NAME_MESSAGE = "이름을 입력해 주세요.";

    public NameNotBlankException() {
        super(INPUT_NAME_MESSAGE);
    }
}
