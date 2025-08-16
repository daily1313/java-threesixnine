package com.example.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final String WHITE_SPACE = "\\s";

    private NameParser() {
    }

    public static List<String> parseInputToPlayerNames(String input) {
        return Arrays.stream(input.replaceAll(WHITE_SPACE, EMPTY).split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
