package com.example.util;

public class GameOptionValidator {

    private static final String INVALID_GAME_OPTION_MESSAGE = "1, 2 외의 값을 입력할 수 없습니다. 올바른 게임 옵션을 선택해주세요.";

    private GameOptionValidator() {
    }

    public static void validateGameOption(int option) {
        if(!isValidOption(option)) {
            throw new IllegalArgumentException(INVALID_GAME_OPTION_MESSAGE);
        }
    }

    private static boolean isValidOption(int option) {
        return option == 1 || option == 2;
    }
}
