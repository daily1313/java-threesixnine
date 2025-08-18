package com.example.exception;

public class InvalidGameOptionException extends RuntimeException {

    public InvalidGameOptionException() {
        super("1, 2 외의 값을 입력할 수 없습니다. 올바른 게임 옵션을 선택해주세요.");
    }
}
