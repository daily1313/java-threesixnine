package com.example.util;

import com.example.exception.InvalidGameOptionException;

public class GameOptionValidator {

    private GameOptionValidator() {
    }

    public static void validateGameOption(int option) {
        if(!isValidOption(option)) {
            throw new InvalidGameOptionException();
        }
    }

    private static boolean isValidOption(int option) {
        return option == 1 || option == 2;
    }
}
