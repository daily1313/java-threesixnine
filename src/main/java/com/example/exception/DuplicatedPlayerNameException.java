package com.example.exception;

public class DuplicatedPlayerNameException extends RuntimeException {

    private static final String DUPLICATED_PLAYER_NAME_MESSAGE = "플레이어 이름은 중복해서 입력할 수 없습니다.";

    public DuplicatedPlayerNameException() {
        super(DUPLICATED_PLAYER_NAME_MESSAGE);
    }
}
