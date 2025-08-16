package com.example.exception;

public class NotEnoughNameSizeException extends RuntimeException {

    private static final String MINIMUM_TWO_PLAYERS_MESSAGE = "플레이어는 최소 2명 이상이여야 합니다.";

    public NotEnoughNameSizeException() {
        super(MINIMUM_TWO_PLAYERS_MESSAGE);
    }
}
