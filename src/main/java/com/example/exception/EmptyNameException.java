package com.example.exception;

public class EmptyNameException extends RuntimeException {

    public EmptyNameException() {
        super("이름을 입력해 주세요.");
    }
}
