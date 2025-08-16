package com.example.exception;

public class InvalidGameOptionException extends RuntimeException {

    private static final String INVALID_GAME_OPTION_MESSAGE = "1, 2 외의 값을 입력할 수 없습니다. 올바른 게임 옵션을 선택해주세요.";

    public InvalidGameOptionException() {
        super(INVALID_GAME_OPTION_MESSAGE);
    }
}
