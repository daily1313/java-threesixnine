package com.example.util;

import java.util.List;

public class NameValidator {

    private static final String INPUT_NAME_MESSAGE = "이름을 입력해 주세요.";
    private static final String MINIMUM_TWO_PLAYERS_MESSAGE = "플레이어는 최소 2명 이상이여야 합니다.";
    private static final int PLAYER_NAME_MIN_LENGTH = 2;

    private NameValidator() {
    }

    public static void validateInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NAME_MESSAGE);
        }
    }

    public static void validateNameSize(List<String> names) {
        if(names.size() < PLAYER_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(MINIMUM_TWO_PLAYERS_MESSAGE);
        }
    }
}
