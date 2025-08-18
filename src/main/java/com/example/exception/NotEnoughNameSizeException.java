package com.example.exception;

public class NotEnoughNameSizeException extends RuntimeException {

    public NotEnoughNameSizeException() {
        super("플레이어는 최소 2명 이상이여야 합니다.");
    }
}
