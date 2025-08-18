package com.example.exception;

public class DuplicatedPlayerNameException extends RuntimeException {

    public DuplicatedPlayerNameException() {
        super("플레이어 이름은 중복해서 입력할 수 없습니다.");
    }
}
