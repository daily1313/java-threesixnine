package com.example.util;

import com.example.exception.DuplicatedPlayerNameException;
import com.example.exception.EmptyNameException;
import com.example.exception.NotEnoughNameSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator {

    private static final int PLAYER_NAME_MIN_LENGTH = 2;

    private NameValidator() {
    }

    public static void validateInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new EmptyNameException();
        }
    }

    public static void validateNameSize(List<String> names) {
        if(names.size() < PLAYER_NAME_MIN_LENGTH) {
            throw new NotEnoughNameSizeException();
        }
    }

    public static void validateDuplicatedPlayerNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if(uniqueNames.size() != names.size()) {
            throw new DuplicatedPlayerNameException();
        }
    }
}
