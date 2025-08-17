package com.example.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_GAME_OPTION_MESSAGE = "게임 옵션을 입력해 주세요. (1: single clap, 2: multiple clap)";
    private static final String INPUT_PLAYER_NAMES_MESSAGE = "플레이어 이름을 콤마(,)로 구분하여 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public int inputGameOption() {
        System.out.println(INPUT_GAME_OPTION_MESSAGE);
        String line = scanner.nextLine().trim();
        return Integer.parseInt(line);
    }

    public String inputPlayerNamesSeperatedByComma() {
        System.out.println(INPUT_PLAYER_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public String inputNumberByPlayer(String playerName) {
        System.out.print(playerName + ": ");
        return scanner.nextLine();
    }
}
